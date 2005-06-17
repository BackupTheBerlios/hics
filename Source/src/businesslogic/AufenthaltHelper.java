/*
 * AufenthaltHelper.java
 *
 * Created on 16. Juni 2005, 16:20
 */

package businesslogic;

import database.*;
import java.util.Date;
//import java.text.DateFormat;

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
}
