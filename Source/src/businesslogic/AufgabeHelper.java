/*
 * AufgabeHelper.java
 *
 * Created on 20. Juni 2005, 23:35
 */

package businesslogic;

import database.*;
import java.sql.*;

/**
 *
 * @author Schmidhuber Andreas
 */

public class AufgabeHelper {
    
    private Database db;
    
    /** Creates a new instance of AufgabeHelper */
    public AufgabeHelper( Database database ) {
        db = database;
    }
    
     /**
     * Gibt eine Liste aller Kunden zurück, oder null, falls beim Suchen
     * ein Fehler aufgetreten ist.
     */
    public Aufgabe[] getAufgaben()
    {   Boolean ausstehend = new Boolean(false);
        java.util.Date dt = new java.util.Date();

        
        QueryAufgabe query = new QueryAufgabe( db );
        query.addFilterErledigt(ausstehend);
        query.addFilterAb(dt);
                
        if( query.search() == false )
            return null;
        Aufgabe[] aufgaben = query.getAufgabenEntities();
        return aufgaben;
    
    
    
    }
    
   
  
}
