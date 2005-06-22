/*
 *KundenHelper.java
 *
 * Created on 16. Juni 2005, 16:20
 */

package businesslogic;

import database.*;
import java.sql.*;

/**
 *
 * @author Zeynep
 */
public class KundenHelper {
  
    private Database db;
    
    /** Creates a new instance of KundenHelper */
    public KundenHelper( Database database ) {
        db = database;
    }
    
    /**
     * Gibt eine Liste aller Kunden zurück, oder null, falls beim Suchen
     * ein Fehler aufgetreten ist.
     */
    public Kunde[] getKunden()
    {
        QueryKunde query = new QueryKunde( db );
        
        query.search();
        Kunde[] kunden = query.getKundenEntities();
        return kunden;
    }
    
    /**
     * Sucht nach einem oder auch mehreren parametern einer Kunde.
     * Rückgabewert ist bei positiver Suche das oder die gefundenen Kunde - 
     * Objekte. Bei einer negativen Suche wird null zurückgegeben. 
     */
    public Kunde[] getKunde( Integer kundenNr, String nachname, String vorname,
                             String land, Integer plz, String wohnort, 
                             String strasse, String telNr ){
        
        boolean nu = false;
        
        QueryKunde query = new QueryKunde( db );
       
        if(kundenNr != null){
            query.addFilterKundenNr( kundenNr );
            nu = true;
        }
       
        if(nachname != null){
            query.addFilterNachname( nachname );
            nu = true;
        }
        
        if(vorname != null){
            query.addFilterVorname( vorname );
            nu = true;
        }
        
         if(land != null){
            query.addFilterLand( land );
            nu = true;
        }
        
        if(plz != null){
            query.addFilterPlz( plz );
            nu = true;
        }
        
         if(wohnort != null){
            query.addFilterWohnort ( wohnort );
            nu = true;
        }
        
          if(strasse != null){
            query.addFilterStrasse ( strasse );
            nu = true;
        }
        
          if(telNr != null){
            query.addFilterTelNr ( telNr );
            nu = true;
        }
               
        if(nu != false){
            query.search();
            Kunde[] kunden = query.getKundenEntities();
            return kunden;
        }
        else{
            return null;
        }
    }
    /**
     * Legt eine neue Kunde in der DB an falls die KundenNr. noch 
     * nicht belegt ist.
     * Wenn die Kunden angelet werden konnte wird true und ansonsten false
     * zurückgegeben.
     **/
    public boolean setKunde(Integer kundenNr, String nachname, String vorname,
                             String land, Integer plz, String wohnort, 
                             String strasse, String telNr, Database db){
        
        if(kundenNr == null || nachname == null || vorname == null ||
           land == null || plz == null || wohnort == null || strasse == null || telNr == null){
           
           return false;
        }
        
        Kunde newKun = null;
        KundenHelper kunHelp = new KundenHelper(db);
        Kunde[] kun = kunHelp.getKunde(kundenNr, null, null, null, null, null, null, null);
        if(kun.length > 0){
            System.out.println("DEBUG: Kunde besteht bereits");
            return false;
        }
       String ins = "INSERT INTO kunde VALUES(" + kundenNr + ", " + 
                nachname + ", " + vorname + ", " + land + ", " + plz + ", " + 
                wohnort + ", " + strasse + ", " + telNr + ");";
            
       if(db.change(ins)){
        return true;
       }

        return false;   
    }
    /**
     * Löscht einen oder mehrere Kunden aus der DB.
     **/
    public void delKunde(Integer[] kundenNr){
        Kunde newKun = null;
        KundenHelper kunHelp = new KundenHelper(db);
        Kunde [][] kun = new Kunde[kundenNr.length][];
        
        for(int i = 0 ; i < kundenNr.length ; i++){
            kun[i] = kunHelp.getKunde(kundenNr[i], null, null, null, null, null,null, null);
            
            db.change("DELETE FROM kunde WHERE kundennr = " + kundenNr[i] + ";");
        }
    }
    /**
     * Ändert einen Eintrag in der DB. Bei korrekter Änderung wird true und
     * ansonsten false zurückgegeben.
     **/
    public boolean changeKunde(Integer kundenNr, String nachname, String vorname,
                              String land, Integer plz, String wohnort, 
                              String strasse, String telNr){
        
        if(kundenNr == null || nachname == null || vorname == null ||
           land == null || plz == null || wohnort == null || strasse == null || telNr == null){
            return false;
        }
        
        KundenHelper kunHelp = new KundenHelper(db);
        Kunde [] kun = kunHelp.getKunde(kundenNr, null, null , null, null, null, null, null);
        boolean ch = true;
        String [] up = new String[7];
        
        if(kun != null){
            up[0] = "UPDATE kunde SET nachname = " + nachname + 
                        " WHERE kundennr = " + kundenNr + ";";
            
            up[1] = "UPDATE kunde SET vorname = " + vorname +
                       " WHERE kundennr = " + kundenNr + ";";
                
            up[2] = "UPDATE kunde SET land = " + land +
                       " WHERE kundennr = " + kundenNr + ";";
                
            up[3] = "UPDATE kunde SET plz = " + plz +
                        " WHERE kundennr = " + kundenNr + ";";
                
            up[4] = "UPDATE kunde SET wohnort = " + wohnort +
                       " WHERE kundennr = " + kundenNr + ";";
            
            up[5] = "UPDATE kunde SET strasse = " + strasse +
                        " WHERE kundennr = " + kundenNr + ";";
                
            up[6] = "UPDATE kunde SET telNr = " + telNr +
                       " WHERE kundennr = " + kundenNr + ";";
                
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