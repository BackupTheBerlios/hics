/*
 * DatabaseManager.java
 *
 * Created on 22. Juni 2005, 14:57
 */

package gui;

import database.*;

/**
 *
 * @author Jakob Petsovits
 */
public class DatabaseManager
{
    public static Database db;
    
    /** Creates a new instance of DatabaseManager */
    public DatabaseManager() {
    }
    
    public static boolean connect()
    {
        db = new Database( DatabaseAccess.url,
                           DatabaseAccess.user, DatabaseAccess.passwort );
        return db.connect();
    }
    
    public static boolean disconnect()
    {
        if( db != null )
            return db.disconnect();
        else
            return false;
    }
    
}
