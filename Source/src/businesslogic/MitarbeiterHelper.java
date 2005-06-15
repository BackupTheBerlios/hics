/*
 * MitarbeiterHelper.java
 *
 * Created on 14. Juni 2005, 23:37
 */

package businesslogic;

import database.*;

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
    
    /**
     * Findet heraus, welche Berechtigung ein Mitarbeiter hat.
     * Der Rückgabewert ist eine Konstante BERECHTIGUNG_*,
     * die in dieser Klasse definiert ist.
     */
    public int getMitarbeiterBerechtigung( String login, String passwort )
    {
        QueryMitarbeiter query = new QueryMitarbeiter( db );
        query.addFilterLogin( login );
        query.addFilterPasswort( passwort );
        query.search();
        
        Mitarbeiter[] mitarbs = query.getMitarbeiterEntites();
        
        if( mitarbs == null || mitarbs.length != 1 ) {
            return BERECHTIGUNG_KEINE;
        }
        else {
            // Berechtigung des Mitarbeiters ermitteln
            Berechtigung berechtigung = new Berechtigung();
            berechtigung.setPrimaryKeys( mitarbs[0].getBerechtigungsNr() );
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
