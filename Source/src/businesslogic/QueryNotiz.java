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
public class QueryNotiz extends Query
{
    String[] filterNotizNr;
    String[] filterKundenNr;
    String[] filterBezeichnung;
    
    /**
     * Erstellt eine neue Instanz von QueryNotiz.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public QueryNotiz( Database database )
    {
        super(database);
        filterNotizNr = new String[0];
        filterKundenNr = new String[0];
        filterBezeichnung = new String[0];
    }
    
    /**
     * Ermittelt alle Notiz-Entities,
     * die mit der SQL-Abfrage gefunden wurden.
     */
    public Notiz[] getNotizEntites()
    {
        Entity[] entities = this.getEntities( new Notiz() );
        Notiz[] notizen = new Notiz[entities.length];
        for( int i = 0; i < entities.length; i++ ) {
            notizen[i] = (Notiz) entities[i];
        }
        return notizen;
    }
    
    public boolean search()
    {
        String query = "SELECT NotizNr, KundenNr FROM Notiz";
        
        String where = this.getWhereString("", filterNotizNr);
        where = this.getWhereString(where, filterKundenNr);
        where = this.getWhereString(where, filterBezeichnung);
        
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
     * Erstellt einen neuen Filter für eine Notiznummer.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param notizNr  Die Notiznummer, nach dem gefiltert werden soll.
     */
    public void addFilterNotizNr( Integer notizNr )
    {
        String[] newFilter = new String[ filterNotizNr.length + 1 ];
        for( int i = 0; i < filterNotizNr.length; i++ ) {
            newFilter[i] = filterNotizNr[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "NotizNr = " + Database.getSqlString(notizNr);
        filterNotizNr = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach Notiznummern filtern.
     */
    public void unsetFilterNotizNr()
    {
        filterNotizNr = new String[0];
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
     * Erstellt einen neuen Filter für eine Notiz-Bezeichnung.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param bezeichnung  Die Bezeichnung, nach dem gefiltert werden soll.
     */
    public void addFilterBezeichnung( String bezeichnung )
    {
        String[] newFilter = new String[ filterBezeichnung.length + 1 ];
        for( int i = 0; i < filterBezeichnung.length; i++ ) {
            newFilter[i] = filterBezeichnung[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Bezeichnung = " + Database.getSqlString(bezeichnung);
        filterBezeichnung = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einer Notiz-Bezeichnung filtern.
     */
    public void unsetFilterBezeichnung()
    {
        filterBezeichnung = new String[0];
    }
}
