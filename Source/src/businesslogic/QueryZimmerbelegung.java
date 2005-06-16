/*
 * QueryZimmerbelegung.java
 *
 * Created on 14. Juni 2005, 13:58
 */

package businesslogic;

import database.*;
import java.util.Date;

/**
 *
 * @author Jakob Petsovits
 */
public class QueryZimmerbelegung extends Query
{
    String[] filterAufenthaltsNr;
    String[] filterZimmerNr;
    String[] filterVon;
    String[] filterBis;
    
    /**
     * Erstellt eine neue Instanz von QueryZimmerbelegung.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public QueryZimmerbelegung( Database database )
    {
        super(database);
        filterAufenthaltsNr = new String[0];
        filterZimmerNr = new String[0];
        filterVon = new String[0];
        filterBis = new String[0];
    }
    
    /**
     * Ermittelt alle Aufenthalts-Entities,
     * die mit der SQL-Abfrage gefunden wurden.
     */
    public Aufenthalt[] getAufenthaltEntites()
    {
        Entity[] entities = this.getEntities( new Aufenthalt() );
        Aufenthalt[] aufenthalts = new Aufenthalt[entities.length];
        for( int i = 0; i < entities.length; i++ ) {
            aufenthalts[i] = (Aufenthalt) entities[i];
        }
        return aufenthalts;
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
        String query = "SELECT AufenthaltsNr, ZimmerNr FROM belegt";
        
        String where = this.getWhereString("", filterAufenthaltsNr);
        where = this.getWhereString(where, filterZimmerNr);
        where = this.getWhereString(where, filterVon);
        where = this.getWhereString(where, filterBis);
        
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
     * Erstellt einen neuen Filter für die AufenthaltsNr.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param aufenthaltsNr  Die gewünschte Aufenthaltsnummer.
     */
    public void addFilterAufenthaltsNr( Integer aufenthaltsNr )
    {
        String[] newFilter = new String[ filterAufenthaltsNr.length + 1 ];
        for( int i = 0; i < filterAufenthaltsNr.length; i++ ) {
            newFilter[i] = filterAufenthaltsNr[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "AufenthaltsNr = " + Database.getSqlString(aufenthaltsNr);
        filterAufenthaltsNr = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach Aufenthaltsnummern filtern.
     */
    public void unsetFilterAufenthaltsNr()
    {
        filterAufenthaltsNr = new String[0];
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
    
    /**
     * Erstellt einen neuen Filter für ein Anfangsdatum der Zimmerbelegung.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param von  Das Anfangsdatum der Zimmerbelegung,
     *             nach dem gefiltert werden soll.
     */
    public void addFilterVon( Date von )
    {
        String[] newFilter = new String[ filterVon.length + 1 ];
        for( int i = 0; i < filterVon.length; i++ ) {
            newFilter[i] = filterVon[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "von = " + Database.getSqlString(von);
        filterVon = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Anfangsdatum
     * der Zimmerbelegung filtern.
     */
    public void unsetFilterVon()
    {
        filterVon = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für ein Enddatum der Zimmerbelegung.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param bis  Das Enddatum der Zimmerbelegung,
     *             nach dem gefiltert werden soll.
     */
    public void addFilterBis( Date bis )
    {
        String[] newFilter = new String[ filterBis.length + 1 ];
        for( int i = 0; i < filterBis.length; i++ ) {
            newFilter[i] = filterBis[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "bis = " + Database.getSqlString(bis);
        filterBis = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Enddatum der Zimmerbelegung filtern.
     */
    public void unsetFilterBis()
    {
        filterVon = new String[0];
    }
}
