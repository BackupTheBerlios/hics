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
public class QueryZimmer extends Query
{
    String[] filterZimmerNr;
    String[] filterAnzahlBetten;
    String[] filterPreisProNacht;
    
    /**
     * Erstellt eine neue Instanz von QueryZimmer.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public QueryZimmer( Database database )
    {
        super(database);
        filterZimmerNr = new String[0];
        filterAnzahlBetten = new String[0];
        filterPreisProNacht = new String[0];
    }
    
    /**
     * Ermittelt alle Zimmer-Entities, die mit der SQL-Abfrage gefunden wurden.
     */
    public Zimmer[] getZimmerEntities()
    {
        Entity[] entities = this.getEntities( new Zimmer() );
        Zimmer[] zimmers = new Zimmer[entities.length];
        for( int i = 0; i < entities.length; i++ ) {
            zimmers[i] = (Zimmer) entities[i];
        }
        return zimmers;
    }
    
    public boolean search()
    {
        String query = "SELECT ZimmerNr FROM Zimmer";
        
        String where = this.getWhereString("", filterZimmerNr);
        where = this.getWhereString(where, filterAnzahlBetten);
        where = this.getWhereString(where, filterAnzahlBetten);
        
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
     * Erstellt einen neuen Filter für die ZimmerNr.
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
        newFilter[ newFilter.length - 1 ] = "ZimmerNr = "
                                            + Database.getSqlString(zimmerNr);
        filterZimmerNr = newFilter;
    }
    
    /**
     * Erstellt einen neuen Suchfilter für die ZimmerNr.
     * Im Gegensatz zu normalen Filtern findet dieser Filter auch
     * dann Zimmernummern, wenn nur ein Teilstring angegeben wurde.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param zimmerNr  Die gewünschte Zimmernummer.
     */
    public void addSearchFilterZimmerNr( String zimmerNr )
    {
        String[] newFilter = new String[ filterZimmerNr.length + 1 ];
        for( int i = 0; i < filterZimmerNr.length; i++ ) {
            newFilter[i] = filterZimmerNr[i];
        }
        newFilter[ newFilter.length - 1 ] =
            "CAST(ZimmerNr AS VARCHAR(10) ) LIKE "
            + Database.getSqlString("%" + zimmerNr + "%");
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
     * Erstellt einen neuen Filter für die Anzahl der Betten.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param anzahlBetten  Die gewünschte Anzahl der Betten.
     */
    public void addFilterAnzahlBetten( Integer anzahlBetten )
    {
        String[] newFilter = new String[ filterAnzahlBetten.length + 1 ];
        for( int i = 0; i < filterAnzahlBetten.length; i++ ) {
            newFilter[i] = filterAnzahlBetten[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "AnzahlBetten = " + Database.getSqlString(anzahlBetten);
        filterAnzahlBetten = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach Anzahl der Betten filtern.
     */
    public void unsetFilterAnzahlBetten()
    {
        filterAnzahlBetten = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für den Preis pro Nacht.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param preisProNacht  Der gewünschte Preis pro Nacht.
     */
    public void addFilterPreisProNacht( Float preisProNacht )
    {
        String[] newFilter = new String[ filterPreisProNacht.length + 1 ];
        for( int i = 0; i < filterPreisProNacht.length; i++ ) {
            newFilter[i] = filterPreisProNacht[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "PreisProNacht = " + Database.getSqlString(preisProNacht);
        filterPreisProNacht = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach Preis pro Nacht filtern.
     */
    public void unsetFilterPreisProNacht()
    {
        filterPreisProNacht = new String[0];
    }
}
