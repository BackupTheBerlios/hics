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
 * @author Standard
 */
public class AufenthaltHelper {
    
    public static final Integer AUFENTHALTSNR = null;
    public static final Integer KUNDENNR = null;
    public static Date VON = null;
    public static Date BIS = null;
    public static final String STATUS = "kein";
    
    private Database db;
    
    /** Creates a new instance of AufenthaltHelper */
    public AufenthaltHelper( Database database ) {
        db = database;
    }
    /**
     * Sucht nach einem oder auch mehreren parametern eines Aufenthalts.
     * Rückgabewert ist bei positiver Suche das oder die gefundenen Aufenthalts - 
     * Objekte. Bei einer negativen Suche wird null zurückgegeben. 
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
     * zurückgegeben.
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
        if(aufenthaltsNr != null && kundenNr != null && mitarbeiterNr != null &&
                von != null && bis != null && status != null){
            
            String ins = "INSERT INTO aufenthalt VALUES(" + aufenthaltsNr + ", " + 
                kundenNr + ", " + mitarbeiterNr + ", '" + von.toString() + "', '" + bis.toString() + "', '" + 
                status + "');";
            
            if(db.change(ins)){
                return true;
            }
        }
        return false;   
    }
    /**
     * Löscht einen oder mehrere Aufenthalte aus der DB.
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
     * Ändert einen Eintrag in der DB. Bei korrekter Änderung wird true und
     * ansonsten false zurückgegeben.
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
    /*
    public Integer getAufenthaltsNr (Date von, Date bis) {
        QueryAufenthalt query = new QueryAufenthalt( db );
        query.addFilterVon( von );
        query.addFilterBis( bis );
        query.search();  
        
        Aufenthalt[] aufe = query.getAufenthaltEntites();
        
        if ( aufe == null ) {
            return AUFENTHALTSNR;
        } 
        else if (aufe.length > 1) {
            return null; 
        }
        else {
            Integer aufenthaltsnr = null;
            Aufenthalt aufenthalt = aufe[1];
            aufenthaltsnr = aufenthalt.getAufenthaltsNR();
            return aufenthaltsnr;
        }
    }
    
    public Integer getAufenthaltsNr (Date bis) {
        QueryAufenthalt query = new QueryAufenthalt( db );
        query.addFilterBis( bis );
        query.search();    
        
        Aufenthalt[] aufe = query.getAufenthaltEntites();
        
        if ( aufe == null ) {
            return AUFENTHALTSNR;
        }
        else if (aufe.length > 1) {
            return null; 
        }
        else {
            Integer aufenthaltsnr = null;
            Aufenthalt aufenthalt = aufe[1];
            aufenthaltsnr = aufenthalt.getAufenthaltsNR();
            return aufenthaltsnr;
        }
    }
    
    public Date getAufenthaltsBeginn ( Integer aufenthaltsnr ) {
        QueryAufenthalt query = new QueryAufenthalt( db );
        query.addFilterAufenthaltsNr( aufenthaltsnr );
        query.search();   
        
        Aufenthalt[] aufe = query.getAufenthaltEntites();
        
        if ( aufe == null ) {
            return null;
        }
        else if (aufe.length > 1) {
            return null; 
        }
        else {
            Date aufebeg = null;
            Aufenthalt aufenthalt = aufe[1];
            aufebeg = aufenthalt.getVon();
            return aufebeg;
        }
        
    }
    
    
    public Date getAufenthaltsEnde ( Integer aufenthaltsnr ) {
        QueryAufenthalt query = new QueryAufenthalt( db );
        query.addFilterAufenthaltsNr( aufenthaltsnr );
        query.search();    
        
        Aufenthalt[] aufe = query.getAufenthaltEntites();
        
        if ( aufe == null ) {
            return null;
        }
        else if (aufe.length > 1) {
            return null; 
        }
        else {
            Date aufend = null;
            Aufenthalt aufenthalt = aufe[1];
            aufend = aufenthalt.getBis();
            return aufend;
        }
    }
    
    public Integer getKundenNr ( Integer kundennr ) {
        QueryAufenthalt query = new QueryAufenthalt( db );
        query.addFilterKundenNr( kundennr );
        query.search();   
        
       Aufenthalt[] aufe = query.getAufenthaltEntites();
        
        if ( aufe == null ) {
            return KUNDENNR;
        }
       else if (aufe.length > 1) {
            return null; 
        }
        else {
            Integer aufenr = null;
            Aufenthalt aufenthalt = aufe[1];
            kundennr = aufenthalt.getKundenNr();
            return aufenr;
        }
        
    }
    
    public String getStatus ( String status ) {
        QueryAufenthalt query = new QueryAufenthalt( db );
        query.addFilterStatus( status );
        query.search();   
        
        Aufenthalt[] aufe = query.getAufenthaltEntites();
        
        if ( aufe == null ) {
            return null;
        }
       else if (aufe.length > 1) {
            return null; 
        }
        else {
            String stat = null;
            Aufenthalt aufenthalt = aufe[1];
            stat = aufenthalt.getStatus();
            return stat;
        }
               
    }
     */
}
