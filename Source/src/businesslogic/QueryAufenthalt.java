/*
 * QueryZimmer.java
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
public class QueryAufenthalt extends Query
{
    String[] filterAufenthaltsNr;
    String[] filterKundenNr;
    String[] filterMitarbeiterNr;
    String[] filterVon;
    String[] filterBis;
    String[] filterStatus;
    
    /**
     * Erstellt eine neue Instanz von QueryAufenthalt.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public QueryAufenthalt( Database database )
    {
        super(database);
        filterAufenthaltsNr = new String[0];
        filterKundenNr = new String[0];
        filterMitarbeiterNr = new String[0];
        filterVon = new String[0];
        filterBis = new String[0];
        filterStatus = new String[0];
    }
    
    /**
     * Ermittelt alle Aufenthalts-Entities,
     * die mit der SQL-Abfrage gefunden wurden.
     */
    public Aufenthalt[] getAufenthaltEntities()
    {
        Entity[] entities = this.getEntities( new Aufenthalt() );
        Aufenthalt[] aufenthalts = new Aufenthalt[entities.length];
        for( int i = 0; i < entities.length; i++ ) {
            aufenthalts[i] = (Aufenthalt) entities[i];
        }
        return aufenthalts;
    }
    
    public boolean search()
    {
        String query = "SELECT AufenthaltsNr FROM Aufenthalt";
        
        String where = this.getWhereString("", filterAufenthaltsNr);
        where = this.getWhereString(where, filterKundenNr);
        where = this.getWhereString(where, filterMitarbeiterNr);
        where = this.getWhereString(where, filterVon);
        where = this.getWhereString(where, filterBis);
        where = this.getWhereString(where, filterStatus);
        
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
     * Erstellt einen neuen Filter für ein Anfangsdatum des Aufenthalts.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param von  Das Anfangsdatum des Aufenthalts,
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
     * Löscht alle Filter, die nach einem Anfangsdatum des Aufenthalts filtern.
     */
    public void unsetFilterVon()
    {
        filterVon = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für ein Enddatum des Aufenthalts.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param bis  Das Enddatum des Aufenthalts,
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
     * Löscht alle Filter, die nach einem Enddatum des Aufenthalts filtern.
     */
    public void unsetFilterBis()
    {
        filterVon = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für einen bestimmten Aufenthalts-Status.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param status  Der Status, nach dem gefiltert werden soll.
     */
    public void addFilterStatus( String status )
    {
        String[] newFilter = new String[ filterStatus.length + 1 ];
        for( int i = 0; i < filterStatus.length; i++ ) {
            newFilter[i] = filterStatus[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Status = " + Database.getSqlString(status);
        filterStatus = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Login filtern.
     */
    public void unsetFilterStatus()
    {
        filterStatus = new String[0];
    }
}
