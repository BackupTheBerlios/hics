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
public class QueryKunde extends Query
{
    String[] filterKundenNr;
    String[] filterNachname;
    String[] filterVorname;
    
    /**
     * Erstellt eine neue Instanz von QueryKunde.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public QueryKunde( Database database )
    {
        super(database);
        filterKundenNr = new String[0];
        filterNachname = new String[0];
        filterVorname = new String[0];
    }
    
    /**
     * Ermittelt alle Kunden-Entities,
     * die mit der SQL-Abfrage gefunden wurden.
     */
    public Kunde[] getKundenEntites()
    {
        Entity[] entities = this.getEntities( new Kunde() );
        Kunde[] kunden = new Kunde[entities.length];
        for( int i = 0; i < entities.length; i++ ) {
            kunden[i] = (Kunde) entities[i];
        }
        return kunden;
    }
    
    public boolean search()
    {
        String query = "SELECT KundenNr FROM Kunde";
        
        String where = this.getWhereString("", filterKundenNr);
        where = this.getWhereString(where, filterNachname);
        where = this.getWhereString(where, filterVorname);
        
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
     * Erstellt einen neuen Filter für die KundenNr.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param kundenNr  Die gewünschte Kundennummer.
     */
    public void addFilterKundenNr( Integer kundenNr )
    {
        String[] newFilter = new String[ filterKundenNr.length + 1 ];
        for( int i = 0; i < filterKundenNr.length; i++ ) {
            newFilter[i] = filterKundenNr[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "KundenNr = " + Database.getSqlString(kundenNr);
        filterKundenNr = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach Kundennummern filtern.
     */
    public void unsetFilterKundenNr()
    {
        filterKundenNr = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für einen Nachnamen.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param nachname  Der Nachname, nach dem gefiltert werden soll.
     */
    public void addFilterNachname( String nachname )
    {
        String[] newFilter = new String[ filterNachname.length + 1 ];
        for( int i = 0; i < filterNachname.length; i++ ) {
            newFilter[i] = filterNachname[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Nachname = " + Database.getSqlString(nachname);
        filterNachname = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Nachnamen filtern.
     */
    public void unsetFilterNachname()
    {
        filterNachname = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für einen Vornamen.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param vorname  Der Vorname, nach dem gefiltert werden soll.
     */
    public void addFilterVorname( String vorname )
    {
        String[] newFilter = new String[ filterVorname.length + 1 ];
        for( int i = 0; i < filterVorname.length; i++ ) {
            newFilter[i] = filterVorname[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Vorname = " + Database.getSqlString(vorname);
        filterVorname = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Vornamen filtern.
     */
    public void unsetFilterVorname()
    {
        filterVorname = new String[0];
    }
}
