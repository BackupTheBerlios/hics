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
 * @author Jakob Petsovits
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
        
        if( query.search() == false )
            return null;
        Kunde[] kunden = query.getKundenEntities();
        return kunden;
    }
    
    /**
     * Gibt eine Liste aller Kunden zurück, bei denen der gewünschte String
     * im Namen enthalten ist. Falls beim Suchen ein Fehler aufgetreten ist,
     * wird null zurückgegeben.
     */
    public Kunde[] searchByName( String searchString )
    {
        QueryKunde query = new QueryKunde( db );
        
        query.setFilterMode( QueryKunde.FILTER_OR );
        query.addSearchFilterNachname( searchString );
        query.addSearchFilterVorname( searchString );
        
        if( query.search() == false )
            return null;
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
}