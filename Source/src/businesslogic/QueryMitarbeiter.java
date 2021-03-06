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
    String[] filterBerechtigungsNr;
    String[] filterNname;
    String[] filterVname;
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
        filterBerechtigungsNr = new String[0];
        filterNname = new String[0];
        filterVname = new String[0];
        filterLogin = new String[0];
        filterPasswort = new String[0];
    }
    
    /**
     * Ermittelt alle Mitarbeiter-Entities,
     * die mit der SQL-Abfrage gefunden wurden.
     */
    public Mitarbeiter[] getMitarbeiterEntities()
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
        where = this.getWhereString(where, filterBerechtigungsNr);
        where = this.getWhereString(where, filterNname);
        where = this.getWhereString(where, filterVname);
        where = this.getWhereString(where, filterLogin);
        where = this.getWhereString(where, filterPasswort);
        
        query += where + ";";
        return this.search( query );
    }
    
    /**
     * Konstruiert einen String, der die einzelnen Filter-Strings
     * in filters in einem gr��eren String enth�lt (ausgehend vom bisher
     * konstruierten Filter-String f�r andere Eigenschaften).
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
     * Erstellt einen neuen Filter f�r die MitarbeiterNr.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param mitarbeiterNr  Die gew�nschte Mitarbeiternummer.
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
     * L�scht alle Filter, die nach Mitarbeiternummern filtern.
     */
    public void unsetFilterMitarbeiterNr()
    {
        filterMitarbeiterNr = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter f�r die BerechtigungsNr.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param berechtigungsNr  Die gew�nschte BerechtigungsNr.
     */
    public void addFilterBerechtigungsNr( Integer berechtigungsNr )
    {
        String[] newFilter = new String[ filterBerechtigungsNr.length + 1 ];
        for( int i = 0; i < filterBerechtigungsNr.length; i++ ) {
            newFilter[i] = filterBerechtigungsNr[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "BerechtigungsNr = " + Database.getSqlString(berechtigungsNr);
        filterBerechtigungsNr = newFilter;
    }
    
    /**
     * L�scht alle Filter, die nach Berechtigungsnr filtern.
     */
    public void unsetFilterBerechtigungsNr()
    {
        filterBerechtigungsNr = new String[0];
    }
    
    
    /**
     * Erstellt einen neuen Filter f�r ein Login.
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
     * L�scht alle Filter, die nach einem Login filtern.
     */
    public void unsetFilterLogin()
    {
        filterLogin = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter f�r ein Passwort.
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
     * L�scht alle Filter, die nach einem Passwort filtern.
     */
    public void unsetFilterPasswort()
    {
        filterPasswort = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter f�r einen Nachnamen.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param nname  Der Nachname, nach dem gefiltert werden soll.
     */
    public void addFilterNname( String nname )
    {
        String[] newFilter = new String[ filterNname.length + 1 ];
        for( int i = 0; i < filterNname.length; i++ ) {
            newFilter[i] = filterNname[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Nachname = " + Database.getSqlString(nname);
        filterNname = newFilter;
    }
    
    /**
     * L�scht alle Filter, die nach einem Nachnamen filtern.
     */
    public void unsetFilterNname()
    {
        filterNname = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter f�r einen Vornamen.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param vname  Der Vorname, nach dem gefiltert werden soll.
     */
    public void addFilterVname( String vname )
    {
        String[] newFilter = new String[ filterVname.length + 1 ];
        for( int i = 0; i < filterVname.length; i++ ) {
            newFilter[i] = filterVname[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Vorname = " + Database.getSqlString(vname);
        filterVname = newFilter;
    }
    
    /**
     * L�scht alle Filter, die nach einem Vornamen filtern.
     */
    public void unsetFilterVname()
    {
        filterVname = new String[0];
    }
}
