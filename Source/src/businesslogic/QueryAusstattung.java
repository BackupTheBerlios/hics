/*
 * QueryAusstattung.java
 *
 * Created on 14. Juni 2005, 13:58
 */

package businesslogic;

import database.*;

/**
 *
 * @author Jakob Petsovits
 */
public class QueryAusstattung extends Query
{
    String[] filterAusstattungsNr;
    String[] filterZimmerNr;
    
    /**
     * Erstellt eine neue Instanz von QueryAusstattung.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public QueryAusstattung( Database database )
    {
        super(database);
        filterAusstattungsNr = new String[0];
        filterZimmerNr = new String[0];
    }
    
    /**
     * Ermittelt alle Ausstattung-Entities,
     * die mit der SQL-Abfrage gefunden wurden.
     */
    public Ausstattung[] getAusstattungEntities()
    {
        Entity[] entities = this.getEntities( new Ausstattung() );
        Ausstattung[] ausstattungen = new Ausstattung[entities.length];
        for( int i = 0; i < entities.length; i++ ) {
            ausstattungen[i] = (Ausstattung) entities[i];
        }
        return ausstattungen;
    }
    
    /**
     * Ermittelt alle Zimmer-Entities,
     * die mit der SQL-Abfrage gefunden wurden.
     */
    public Zimmer[] getZimmerEntites()
    {
        Entity[] entities = this.getEntities( new Zimmer() );
        Zimmer[] zimmern = new Zimmer[entities.length];
        for( int i = 0; i < entities.length; i++ ) {
            zimmern[i] = (Zimmer) entities[i];
        }
        return zimmern;
    }
    
    public boolean search()
    {
        String query = "SELECT AusstattungsNr, ZimmerNr FROM verfuegt_ueber";
        
        String where = this.getWhereString("", filterAusstattungsNr);
        where = this.getWhereString(where, filterZimmerNr);
        
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
     * Erstellt einen neuen Filter für die AusstattungsNr.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param ausstattungsNr  Die gewünschte Ausstattungsnummer.
     */
    public void addFilterAusstattungsNr( Integer ausstattungsNr )
    {
        String[] newFilter = new String[ filterAusstattungsNr.length + 1 ];
        for( int i = 0; i < filterAusstattungsNr.length; i++ ) {
            newFilter[i] = filterAusstattungsNr[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "AusstattungsNr = " + Database.getSqlString(ausstattungsNr);
        filterAusstattungsNr = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach Ausstattungsnummern filtern.
     */
    public void unsetFilterAusstattungsNr()
    {
        filterAusstattungsNr = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für die Zimmernummer.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param zimmerNr  Die gewünschte Zimmernummer.
     */
    public void addFilterZimmerNr( Integer zimmerNr )
    {
        String[] newFilter = new String[ filterZimmerNr.length + 1 ];
        for( int i = 0; i < filterZimmerNr.length; i++ ) {
            newFilter[i] = filterZimmerNr[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "ZimmerNr = " + Database.getSqlString(zimmerNr);
        filterZimmerNr = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach Zimmernummern filtern.
     */
    public void unsetFilterZimmerNr()
    {
        filterZimmerNr = new String[0];
    }
}
