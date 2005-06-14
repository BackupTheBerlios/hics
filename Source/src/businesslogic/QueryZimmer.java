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
    
    public Zimmer[] getZimmerEntites()
    {
        return (Zimmer[]) this.getEntities( new Zimmer() );
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
     * Erstellt einen neuen Filter f�r die ZimmerNr.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param zimmerNr  Die gew�nschte Zimmernummer.
     */
    public void addFilterZimmerNr( Integer zimmerNr )
    {
        String[] newFilter = new String[ filterZimmerNr.length + 1 ];
        for( int i = 0; i < filterZimmerNr.length; i++ ) {
            newFilter[i] = filterZimmerNr[i];
        }
        newFilter[ newFilter.length - 1 ] = "ZimmerNr = "
                                            + Database.getSqlString(zimmerNr);
    }
    
    /**
     * L�scht alle Filter, die nach Zimmernummern filtern.
     */
    public void unsetFilterZimmerNr()
    {
        filterZimmerNr = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter f�r die Anzahl der Betten.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param anzahlBetten  Die gew�nschte Anzahl der Betten.
     */
    public void addFilterAnzahlBetten( Integer anzahlBetten )
    {
        String[] newFilter = new String[ filterAnzahlBetten.length + 1 ];
        for( int i = 0; i < filterAnzahlBetten.length; i++ ) {
            newFilter[i] = filterAnzahlBetten[i];
        }
        newFilter[ newFilter.length - 1 ] = "AnzahlBetten = "
                                            + Database.getSqlString(anzahlBetten);
    }
    
    /**
     * L�scht alle Filter, die nach Anzahl der Betten filtern.
     */
    public void unsetFilterAnzahlBetten()
    {
        filterAnzahlBetten = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter f�r den Preis pro Nacht.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param preisProNacht  Der gew�nschte Preis pro Nacht.
     */
    public void addFilterPreisProNacht( Float preisProNacht )
    {
        String[] newFilter = new String[ filterPreisProNacht.length + 1 ];
        for( int i = 0; i < filterPreisProNacht.length; i++ ) {
            newFilter[i] = filterPreisProNacht[i];
        }
        newFilter[ newFilter.length - 1 ] = "PreisProNacht = "
                                            + Database.getSqlString(preisProNacht);
    }
    
    /**
     * L�scht alle Filter, die nach Preis pro Nacht filtern.
     */
    public void unsetFilterPreisProNacht()
    {
        filterPreisProNacht = new String[0];
    }
}
