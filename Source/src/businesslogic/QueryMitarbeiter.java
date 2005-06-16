/*
 * QueryZimmer.java
 *
 * Created on 14. Juni 2005, 13:58
 */

package businesslogic;

import database.*;

/**
 *
 * @author Jakob Petsovits
 */
public class QueryMitarbeiter extends Query
{
    String[] filterMitarbeiterNr;
    String[] filterLogin;
    String[] filterPasswort;
    
    /**
     * Erstellt eine neue Instanz von QueryMitarbeiter.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public QueryMitarbeiter( Database database )
    {
        super(database);
        filterMitarbeiterNr = new String[0];
        filterLogin = new String[0];
        filterPasswort = new String[0];
    }
    
    /**
     * Ermittelt alle Mitarbeiter-Entities,
     * die mit der SQL-Abfrage gefunden wurden.
     */
    public Mitarbeiter[] getMitarbeiterEntites()
    {
        Entity[] entities = this.getEntities( new Mitarbeiter() );
        Mitarbeiter[] mitarbs = new Mitarbeiter[entities.length];
        for( int i = 0; i < entities.length; i++ ) {
            mitarbs[i] = (Mitarbeiter) entities[i];
        }
        return mitarbs;
    }
    
    public boolean search()
    {
        String query = "SELECT MitarbeiterNr, BerechtigungsNr FROM Mitarbeiter";
        
        String where = this.getWhereString("", filterMitarbeiterNr);
        where = this.getWhereString(where, filterLogin);
        where = this.getWhereString(where, filterPasswort);
        
        query += where + ";";
        return this.search( query );
    }
    
    /**
     * Konstruiert einen String, der die einzelnen Filter-Strings
     * in filters in einem größeren String enthält (ausgehend vom bisher
     * konstruierten Filter-String für andere Eigenschaften).
     * Es werden Strings der Form
     * [WHERE|AND] (filter1 [OR filter2 [OR filter3...]) erstellt.
     *
     * @param current  Der bisherige String mit allen Filtern.
     *                 Falls er ungleich "" ist, wird mit AND fortgesetzt,
     *                 ansonsten beginnt der Ergebnis-String mit WHERE.
     * @param filters  Strings der Form "propertyName = property".
     */
    private String getWhereString( String current, String[] filters )
    {
        String result = new String(current);
        
        if( filters.length != 0 ) {
            if( current.equals("") ) {
                result = " WHERE (";
            }
            else {
                result += " AND (";
            }
        }
        
        for( int i = 0; i < filters.length; i++ )
        {
            if( i != 0 ) {
                result += " OR ";
            }
            result += filters[i];
        }
        
        if( filters.length != 0 ) {
            result += ")";
        }
        
        return result;
    }
    
    /**
     * Erstellt einen neuen Filter für die MitarbeiterNr.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param mitarbeiterNr  Die gewünschte Mitarbeiternummer.
     */
    public void addFilterMitarbeiterNr( Integer mitarbeiterNr )
    {
        String[] newFilter = new String[ filterMitarbeiterNr.length + 1 ];
        for( int i = 0; i < filterMitarbeiterNr.length; i++ ) {
            newFilter[i] = filterMitarbeiterNr[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "MitarbeiterNr = " + Database.getSqlString(mitarbeiterNr);
        filterMitarbeiterNr = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach Mitarbeiternummern filtern.
     */
    public void unsetFilterMitarbeiterNr()
    {
        filterMitarbeiterNr = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für ein Login.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param login  Das Login, nach dem gefiltert werden soll.
     */
    public void addFilterLogin( String login )
    {
        String[] newFilter = new String[ filterLogin.length + 1 ];
        for( int i = 0; i < filterLogin.length; i++ ) {
            newFilter[i] = filterLogin[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Login = " + Database.getSqlString(login);
        filterLogin = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Login filtern.
     */
    public void unsetFilterLogin()
    {
        filterLogin = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für ein Passwort.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param passwort  Das Passwort, nach dem gefiltert werden soll.
     */
    public void addFilterPasswort( String passwort )
    {
        String[] newFilter = new String[ filterPasswort.length + 1 ];
        for( int i = 0; i < filterPasswort.length; i++ ) {
            newFilter[i] = filterPasswort[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Passwort = " + Database.getSqlString(passwort);
        filterPasswort = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Passwort filtern.
     */
    public void unsetFilterPasswort()
    {
        filterPasswort = new String[0];
    }
}
