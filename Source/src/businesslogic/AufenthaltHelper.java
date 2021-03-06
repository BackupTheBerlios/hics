/*
 * AufenthaltHelper.java
 *
 * Created on 16. Juni 2005, 16:20
 */

package businesslogic;

import database.*;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author Schmidhuber Andreas
 */
public class AufenthaltHelper {
    
    private Database db;
    
    /** Creates a new instance of AufenthaltHelper */
    public AufenthaltHelper( Database database ) {
        db = database;
    }
    
    /**
     * Gibt eine Liste aller Aufenthalte zur�ck, oder null, falls beim Suchen
     * ein Fehler aufgetreten ist.
     */
    public Aufenthalt[] getAufenthalte()
    {
        QueryAufenthalt query = new QueryAufenthalt( db );
        
        if( query.search() == false )
            return null;
        Aufenthalt[] aufenthalte = query.getAufenthaltEntities();
        return aufenthalte;
    }
    
    /**
     * Gibt eine den zu einem Aufenthalt zugeh�rigen Zimmerbelegungen zur�ck.
     */
    public Zimmerbelegung[] getZimmerbelegungenInAufenthalt( Aufenthalt aufenthalt )
    {
        QueryZimmerbelegung query = new QueryZimmerbelegung( db );
        query.addFilterAufenthaltsNr( aufenthalt.getAufenthaltsNr() );
        
        if( query.search() == false )
            return null;
        Zimmerbelegung[] belegungen = query.getZimmerbelegungEntities();
        if( belegungen.length == 0 )
            return null;
        else
            return belegungen;
    }
    
    /**
     * Gibt eine den zu einem Aufenthalt zugeh�rigen Kunden zur�ck.
     */
    public Kunde getKundeInAufenthalt( Aufenthalt aufenthalt )
    {
        QueryKunde query = new QueryKunde( db );
        query.addFilterKundenNr( aufenthalt.getKundenNr() );
        
        if( query.search() == false )
            return null;
        Kunde[] kunden = query.getKundenEntities();
        if( kunden.length == 0 )
            return null;
        else
            return kunden[0];
    }
    
    /**
     * Gibt die Liste der den zu einem Aufenthalt zugeh�rigen
     * belegten Zimmer zur�ck.
     */
    public Zimmer[] getZimmernInAufenthalt( Aufenthalt aufenthalt )
    {
        QueryZimmerbelegung query = new QueryZimmerbelegung( db );
        query.addFilterAufenthaltsNr( aufenthalt.getAufenthaltsNr() );
        
        if( query.search() == false )
            return null;
        Zimmer[] zimmern = query.getZimmerEntities();
        return zimmern;
    }
    
    
    
    /**
     * Gibt eine Liste von Aufenthalten zur�ck, die dem Suchkriterium
     * entsprechen.
     */
    public Aufenthalt[] search( String string )
    {
        /*QueryZimmerbelegung query = new QueryZimmerbelegung( db );
        query.addFilterAufenthaltsNr( aufenthalt.getAufenthaltsNr() );
        
        if( query.search() == false )*/
            return null;
        /*Zimmer[] zimmern = query.getZimmerEntities();
        if( zimmern.length == 0 )
            return null;
        else
            return zimmern;*/
    }
    
    /**
     * Sucht nach einem oder auch mehreren parametern eines Aufenthalts.
     * R�ckgabewert ist bei positiver Suche das oder die gefundenen Aufenthalts - 
     * Objekte. Bei einer negativen Suche wird null zur�ckgegeben. 
     **/
    public Aufenthalt[] getAufenthalt(Integer aufenthaltsNr, Integer kundenNr ,
            Integer mitarbeiterNr, Date von, Date bis, String status){
        
        boolean nu = false;
        
        QueryAufenthalt query = new QueryAufenthalt( db );
        if(aufenthaltsNr != null){
            query.addFilterAufenthaltsNr( aufenthaltsNr );
            nu = true;
        }
        if(kundenNr != null){
            query.addFilterKundenNr( kundenNr );
            nu = true;
        }
        if(mitarbeiterNr != null){
            query.addFilterMitarbeiterNr( mitarbeiterNr );
            nu = true;
        }
        if(von != null){
            query.addFilterVon( von );
            nu = true;
        }
        if(bis != null){
            query.addFilterBis( bis );
            nu = true;
        }
        if(status != null){
            query.addFilterStatus( status );
            nu = true;
        }
        if(nu != false){
            query.search();
            Aufenthalt[] aufent = query.getAufenthaltEntities();
            return aufent;
        }
        else{
            return null;
        }
    }
    /**
     * Legt einen neuen Aufenthalt in der DB an falls die AufenthaltsNr. noch 
     * nicht belegt ist.
     * Wenn der Aufenthalt angelet werden konnte wird true und ansonsten false
     * zur�ckgegeben.
     **/
    public boolean setAufenthalt(Integer aufenthaltsNr, Integer kundenNr ,
            Integer mitarbeiterNr, Date von, Date bis, String status, Database db){
        
        if(aufenthaltsNr == null || kundenNr == null || mitarbeiterNr == null ||
                von == null || bis == null || status == null){
            return false;
        }
        
        Aufenthalt newAuf = null;
        AufenthaltHelper aufHelp = new AufenthaltHelper(db);
        Aufenthalt[] auf = aufHelp.getAufenthalt(aufenthaltsNr, null, null, null,
                null, null);
        if(auf.length > 0){
            System.out.println("DEBUG: Aufenthalt besteht bereits");
            return false;
        }
        
        String ins = "INSERT INTO aufenthalt VALUES(" + aufenthaltsNr + ", " + 
            kundenNr + ", " + mitarbeiterNr + ", '" + von.toString() + "', '" + bis.toString() + "', '" + 
            status + "');";
            
        if(db.change(ins)){
            return true;
        }
        
        return false;   
    }
    /**
     * L�scht einen oder mehrere Aufenthalte aus der DB.
     **/
    public void delAufenthalt(Integer[] aufenthaltsNr){
        Aufenthalt newAuf = null;
        AufenthaltHelper aufHelp = new AufenthaltHelper(db);
        Aufenthalt [][] auf = new Aufenthalt[aufenthaltsNr.length][];
        
        for(int i = 0 ; i < aufenthaltsNr.length ; i++){
            auf[i] = aufHelp.getAufenthalt(aufenthaltsNr[i], null, null, null,
                    null, null);
            
            db.change("DELETE FROM aufenthalt WHERE aufenthaltsnr = " + aufenthaltsNr[i] + ";");
        }
    }
    /**
     * �ndert einen Eintrag in der DB. Bei korrekter �nderung wird true und
     * ansonsten false zur�ckgegeben.
     **/
    public boolean changeAufenthalt(Integer aufenthaltsNr, Integer kundenNr ,
            Integer mitarbeiterNr, Date von, Date bis, String status){
        
        if(aufenthaltsNr == null || kundenNr == null || mitarbeiterNr == null ||
                von == null || bis == null || status == null){
            return false;
        }
        
        AufenthaltHelper aufHelp = new AufenthaltHelper(db);
        Aufenthalt [] auf = aufHelp.getAufenthalt(aufenthaltsNr, null, null, null, null, null);
        boolean ch = true;
        String [] up = new String[5];
        
        if(auf != null){
            up[0] = "UPDATE aufenthalt SET kundennr = " + kundenNr + 
                        " WHERE aufenthaltsnr = " + aufenthaltsNr + ";";
            
            up[1] = "UPDATE aufenthalt SET mitarbeiternr = " + mitarbeiterNr +
                        " WHERE aufenthaltsnr = " + aufenthaltsNr + ";";
                
            up[2] = "UPDATE aufenthalt SET von = '" + von.toString() +
                        "' WHERE aufenthaltsnr = " + aufenthaltsNr + ";";
                
            up[3] = "UPDATE aufenthalt SET bis = '" + bis.toString() +
                        "' WHERE aufenthaltsnr = " + aufenthaltsNr + ";";
                
            up[4] = "UPDATE aufenthalt SET status = '" + status +
                        "' WHERE aufenthaltsnr = " + aufenthaltsNr + ";";
                
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
