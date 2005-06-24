/*
 * DatabaseAccess.java
 *
 * Created on 15. Juni 2005, 00:33
 */

package gui;

/**
 * Diese Klasse beinhaltet die Werte zum Zugreifen auf die Datenbank.
 * Die sind von System zu System verschieden und kommen deshalb
 * nicht ins CVS.
 *
 * @author Jakob Petsovits
 */
public class DatabaseAccess
{
    public static final String url = "jdbc:postgresql://localhost:5432/hics";
    public static final String user = "postgres";
    public static final String passwort = "passwortEinfügen";

    /** Creates a new instance of DatabaseAccess */
    public DatabaseAccess() {
    }

}
