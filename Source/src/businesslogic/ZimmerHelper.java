/*
 * MitarbeiterHelper.java
 *
 * Created on 14. Juni 2005, 23:37
 */

package businesslogic;

import database.*;
import java.sql.*;

/**
 *
 * @author Sabrina Valek
 */
public class ZimmerHelper
{
   
      
    // Das Datenbank-Objekt, das zum Abfragen der Werte verwendet werden soll.
    private Database db;
    
    /**
     * Erstellt eine neue Instanz von ZimmerHelper.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public ZimmerHelper( Database database )
    {
        db = database;
    }
    
    /**
     * Gibt eine Liste aller Zimmer zurück, oder null, falls beim Suchen
     * ein Fehler aufgetreten ist.
     */
    public Zimmer[] getZimmern()
    {
        QueryZimmer query = new QueryZimmer( db );
        
        if( query.search() == false )
            return null;
        Zimmer[] zimmern = query.getZimmerEntities();
        return zimmern;
    }
    
    /**
     * Gibt den Kunden zurück, der zum derzeitigen Zeitpunkt das angegebene
     * Zimmer belegt.
     */
    public Kunde getKundeInZimmer( Zimmer zimmer )
    {
        //QueryBla query = new QueryBla( db );
        
        //if( query.search() == false )
            return null;
        //Kunde[] kunden = query.getKundeEntities();
        //if( kunden.length > 0 ) {
        //    return kunden[0];
        //}
    }
    
    /**
     * Gibt eine Liste aller Zimmer zurück, bei denen der gewünschte String
     * auftritt. Falls beim Suchen ein Fehler passiert, wird null zurückgegeben.
     */
    public Zimmer[] searchByName( String searchString )
    {
        QueryZimmer query = new QueryZimmer( db );
        
        //query.setFilterMode( QueryZimmer.FILTER_OR );
        //query.addSearchFilterNachname( searchString );
        //query.addSearchFilterVorname( searchString );
        
        if( query.search() == false )
            return null;
        Zimmer[] zimmern = query.getZimmerEntities();
        
        return zimmern;
    }
    
    /**
     * Sucht nach einem oder auch mehreren parametern eines Zimmers.
     * Rückgabewert ist bei positiver Suche das oder die gefundenen Zimmer - 
     * Objekte. Bei einer negativen Suche wird null zurückgegeben. 
     **/
    public Zimmer[] getZimmer(Integer zimmerNr, 
            Integer betten, Float preis){
        
        boolean nu = false;
        
        QueryZimmer query = new QueryZimmer( db );
        if(zimmerNr != null){
            query.addFilterZimmerNr( zimmerNr );
            nu = true;
        }
        if(betten != null){
            query.addFilterAnzahlBetten( betten );
            nu = true;
        }
        if(preis != null){
            query.addFilterPreisProNacht( preis);
            nu = true;
        }
        
      
        if(nu != false){
            query.search();
            Zimmer[] zimmer = query.getZimmerEntities();
            return zimmer;
        }
        else{
            return null;
        }
    }
    
    /**
     * Sucht nach allen Ausstattungen, die ein Zimmer haben kann.
     * Rückgabewert ist bei positiver Suche das oder die gefundenen 
     * Ausstattungs - Objekte. Bei einer negativen Suche wird null 
     * zurückgegeben. 
     **/
    public Ausstattung[] getAusstattung(){
        
            QueryAusstattung query = new QueryAusstattung( db );
        
        if( query.search() == false )
            return null;
        Ausstattung[] ausstattung = query.getAusstattungEntites();
        return ausstattung;
       
    }
    
           
//    /**
//     * Sucht die nächste freie MitarbeiterNr
//     **/
//    public Integer newMitarbNr() {
//        String search = "select MAX(mitarbeiterNR) as mitarbnr from mitarbeiter;";
//        Integer mitarbNr = null;
//        try {
//            ResultSet mitarb =  db.query(search);   
//            while (mitarb.next()){
//                mitarbNr = new Integer(mitarb.getInt("mitarbnr"));
//            }
//            
//            return mitarbNr;
//        }
//        catch(SQLException e){
//            System.out.println("DEBUG: keine neue MitarbeiterNr gefuden");
//            return null;
//        }
//        
//    }
    
    /**
     * Legt einen neues Zimmer in der DB an falls die ZimmerNr. noch 
     * nicht belegt ist.
     * Wenn das Zimmer angelet werden konnte wird true und ansonsten false
     * zurückgegeben.
     **/
    public boolean setZimmer(Integer zimmerNr, 
            Integer betten, Float preis, Database db){
        
        if( zimmerNr == null || betten == null || preis == null ){
            return false;
        }
        
        Zimmer newZim = null;
        ZimmerHelper zimHelp = new ZimmerHelper(db);
        Zimmer[] zim = zimHelp.getZimmer(zimmerNr, null, null);
        if(zim.length > 0){
            System.out.println("DEBUG: Zimmer besteht bereits");
            return false;
        }
        String ins = "INSERT INTO zimmer VALUES(" + zimmerNr + ", " + 
                betten + "," + preis + ");";
            
        if(db.change(ins)){
            return true;
        }
        return false;   
    }
    /**
     * Löscht einen oder mehrere Zimmer aus der DB.
     **/
    public void delZimmer(Integer[] zimmerNr){
        Zimmer newZim = null;
        ZimmerHelper zimHelp = new ZimmerHelper(db);
        Zimmer [][] zim = new Zimmer[zimmerNr.length][];
        
        for(int i = 0 ; i < zimmerNr.length ; i++){
            zim[i] = zimHelp.getZimmer(zimmerNr[i], null, null);
            
            db.change("DELETE FROM zimmer WHERE zimmernr = " + zimmerNr[i] + ";");
        }
    }
    /**
     * Ändert einen Eintrag in der DB. Bei korrekter Änderung wird true und
     * ansonsten false zurückgegeben.
     **/
    public boolean changeZimmer(Integer zimmerNr, 
            Integer betten, Float preis){
        
         if( zimmerNr == null || betten == null || preis == null){
            return false;
        }
        
        ZimmerHelper zimHelp = new ZimmerHelper(db);
        Zimmer[] zim = zimHelp.getZimmer(zimmerNr, null, null); 
        
        boolean ch = true;
        String [] up = new String[2];
        
        if(zim != null){
            up[0] = "UPDATE zimmer SET anzahlbetten = " + betten + 
                        " WHERE zimmernr = " + zimmerNr + ";";
            
            up[1] = "UPDATE zimmer SET preispronacht = " + preis +
                        " WHERE zimmernr = " + zimmerNr + ";";
                
                
            for(int i = 0; i < up.length; i++){
                if(!db.change(up[i])){
                    ch = false;
                }
            }
            return ch;
        }
        return false;
    }
     
    
}