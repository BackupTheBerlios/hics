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
 * @author Jakob Petsovits
 */
public class MitarbeiterHelper
{
    // Enums are not yet supported in Java 1.4
    public static final int BERECHTIGUNG_KEINE = 0;
    public static final int BERECHTIGUNG_ADMIN = 1;
    public static final int BERECHTIGUNG_REZEPTION = 2;
    public static final int BERECHTIGUNG_REINIGUNG = 3;
    
      
    // Das Datenbank-Objekt, das zum Abfragen der Werte verwendet werden soll.
    private Database db;
    
    /**
     * Erstellt eine neue Instanz von MitarbeiterHelper.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public MitarbeiterHelper( Database database )
    {
        db = database;
    }
    
   //sucht nach usernamen und gibt true zurück, wenn er bereits besteht
    public boolean userNameVorhanden(String username){
         
        
        QueryMitarbeiter query = new QueryMitarbeiter( db );
        query.addFilterLogin( username );
        query.search();
        Mitarbeiter[] mitarb = query.getMitarbeiterEntities();
        if (mitarb.length == 0){
             return true;
        }
        else {
             return false;
        }
    }
    
    /**
     * Gibt den Mitarbeiter zurück, der über das angegebene Login und Passwort
     * verfügt.
     */
    public Mitarbeiter getMitarbeiter( String login, String passwort )
    {
        QueryMitarbeiter query = new QueryMitarbeiter( db );
        query.addFilterLogin( login );
        query.addFilterPasswort( passwort );
        
        if( query.search() == false )
            return null;
        Mitarbeiter[] mitarbs = query.getMitarbeiterEntities();
        if( mitarbs == null || mitarbs.length == 0 )
            return null;
        else
            return mitarbs[0];
    }
    
    /**
     * Sucht nach einem oder auch mehreren parametern eines Mitarbeiters.
     * Rückgabewert ist bei positiver Suche das oder die gefundenen Mitarbeiter - 
     * Objekte. Bei einer negativen Suche wird null zurückgegeben. 
     **/
    public Mitarbeiter[] getMitarbeiter(Integer mitarbeiterNr, 
            Integer berechtigungsNr, String nachname, String vorname,
            String login, String passwort){
        
        boolean nu = false;
        
        QueryMitarbeiter query = new QueryMitarbeiter( db );
        if(berechtigungsNr != null){
            query.addFilterBerechtigungsNr( berechtigungsNr );
            nu = true;
        }
        if(mitarbeiterNr != null){
            query.addFilterMitarbeiterNr( mitarbeiterNr );
            nu = true;
        }
        if(vorname != null){
            query.addFilterVname( vorname);
            nu = true;
        }
        
        if(nachname != null){
            query.addFilterNname( nachname );
            nu = true;
        }
        if(login != null){
            query.addFilterLogin( login );
            nu = true;
        }
        if(passwort != null){
            query.addFilterPasswort( passwort );
            nu = true;
        }
      
        if(nu != false){
            query.search();
            Mitarbeiter[] mitarb = query.getMitarbeiterEntities();
            return mitarb;
        }
        else{
            return null;
        }
    }
    
    /**
     * Sucht einen die nächste freie MitarbeiterNr
     **/
    public Integer newMitarbNr() {
        String search = "select MAX(mitarbeiterNR) as mitarbnr from mitarbeiter;";
        Integer mitarbNr = null;
        try {
            ResultSet mitarb =  db.query(search);   
            while (mitarb.next()){
                mitarbNr = new Integer(mitarb.getInt("mitarbnr"));
            }
            
            return mitarbNr;
        }
        catch(SQLException e){
            System.out.println("DEBUG: keine neue MitarbeiterNr gefuden");
            return null;
        }
        
    }
    
    /**
     * Legt einen neuen Aufenthalt in der DB an falls die AufenthaltsNr. noch 
     * nicht belegt ist.
     * Wenn der Aufenthalt angelet werden konnte wird true und ansonsten false
     * zurückgegeben.
     **/
    public boolean setMitarbeiter(Integer mitarbeiterNr, 
            Integer berechtigungsNr, String nachname, String vorname,
            String login, String passwort, Database db){
        
        if( mitarbeiterNr == null || berechtigungsNr == null || vorname == null ||
                nachname == null || login == null || passwort == null){
            return false;
        }
        
        Mitarbeiter newAuf = null;
        MitarbeiterHelper mitHelp = new MitarbeiterHelper(db);
        Mitarbeiter[] auf = mitHelp.getMitarbeiter(mitarbeiterNr, null, null, null,
                null, null);
        if(auf.length > 0){
            System.out.println("DEBUG: Mitarbeiter besteht bereits");
            return false;
        }
        String ins = "INSERT INTO mitarbeiter VALUES(" + mitarbeiterNr + ", " + 
                berechtigungsNr + ",'" + nachname + "','" + vorname + "', '" + login + "', '" + 
                passwort + "');";
            
        if(db.change(ins)){
            return true;
        }
        return false;   
    }
    /**
     * Löscht einen oder mehrere Mitarbeiter aus der DB.
     **/
    public void delMitarbeiter(Integer[] mitarbeiterNr){
        Mitarbeiter newMit = null;
        MitarbeiterHelper mitHelp = new MitarbeiterHelper(db);
        Mitarbeiter [][] mit = new Mitarbeiter[mitarbeiterNr.length][];
        
        for(int i = 0 ; i < mitarbeiterNr.length ; i++){
            mit[i] = mitHelp.getMitarbeiter(mitarbeiterNr[i], null, null, null,
                    null, null);
            
            db.change("DELETE FROM mitarbeiter WHERE mitarbeiternr = " + mitarbeiterNr[i] + ";");
        }
    }
    /**
     * Ändert einen Eintrag in der DB. Bei korrekter Änderung wird true und
     * ansonsten false zurückgegeben.
     **/
    public boolean changeMitarbeiter(Integer mitarbeiterNr, 
            Integer berechtigungsNr, String nachname, String vorname,
            String login, String passwort){
        
         if( mitarbeiterNr == null || berechtigungsNr == null || vorname == null ||
                nachname == null || login == null || passwort == null){
            return false;
        }
        
        MitarbeiterHelper mitHelp = new MitarbeiterHelper(db);
        Mitarbeiter[] mit = mitHelp.getMitarbeiter(mitarbeiterNr, null, null, null,
                null, null); 
        
        boolean ch = true;
        String [] up = new String[5];
        
        if(mit != null){
            up[0] = "UPDATE mitarbeiter SET berechtigungsnr = " + berechtigungsNr + 
                        " WHERE mitarbeiternr = " + mitarbeiterNr + ";";
            
            up[1] = "UPDATE mitarbeiter SET nachname = '" + nachname +
                        "' WHERE mitarbeiternr = " + mitarbeiterNr + ";";
                
            up[2] = "UPDATE mitarbeiter SET vorname = '" + vorname +
                        "' WHERE mitarbeiternr = " + mitarbeiterNr + ";";
                
            up[3] = "UPDATE mitarbeiter SET login = '" + login +
                        "' WHERE mitarbeiternr = " + mitarbeiterNr + ";";
                
            up[4] = "UPDATE mitarbeiter SET passwort = '" + passwort +
                        "' WHERE mitarbeiternr = " + mitarbeiterNr + ";";
                
            for(int i = 0; i < up.length; i++){
                if(!db.change(up[i])){
                    ch = false;
                }
            }
            return ch;
        }
        return false;
    }
     
       
    
    /**
     * Findet heraus, welche Berechtigung ein Mitarbeiter hat.
     * Der Rückgabewert ist eine Konstante BERECHTIGUNG_*,
     * die in dieser Klasse definiert ist.
     */
    public int getMitarbeiterBerechtigung( Mitarbeiter mitarbeiter )
    {   
        if( mitarbeiter == null ) {
            return BERECHTIGUNG_KEINE;
        }
        else {
            // Berechtigung des Mitarbeiters ermitteln
            Berechtigung berechtigung = new Berechtigung();
            berechtigung.setPrimaryKeys( mitarbeiter.getBerechtigungsNr() );
            berechtigung.assignDatabase( db );
            if( berechtigung.fromDatabase() == false )
                return BERECHTIGUNG_KEINE;
            
            // So, damit hätten wir die Berechtigung aus der Datenbank.
            // Jetzt nur noch schauen, welche es ist.
            String bezeichnung = berechtigung.getBezeichnung();
            if( bezeichnung.equals("Admin") )
                return BERECHTIGUNG_ADMIN;
            else if( bezeichnung.equals("Rezeption") )
                return BERECHTIGUNG_REZEPTION;
            else if( bezeichnung.equals("Reinigung") )
                return BERECHTIGUNG_REINIGUNG;
            else
                return BERECHTIGUNG_KEINE;
        }
    }
}
