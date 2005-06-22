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
    public static final int FILTER_AND = 0;
    public static final int FILTER_OR = 1;
    int filterMode;
    
    String[] filterKundenNr;
    String[] filterNachname;
    String[] filterVorname;
    String[] filterLand;
    String[] filterPlz;
    String[] filterWohnort;
    String[] filterStrasse;
    String[] filterTelNr;
    String[] filterNotiz;
    
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
        filterLand = new String[0];
        filterPlz = new String[0];
        filterWohnort = new String[0];
        filterStrasse = new String[0];
        filterTelNr = new String[0];
        filterNotiz = new String[0];
        
        filterMode = FILTER_AND;
    }
    
    /**
     * Ermittelt alle Kunden-Entities,
     * die mit der SQL-Abfrage gefunden wurden.
     */
    public Kunde[] getKundenEntities()
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
        where = this.getWhereString(where, filterLand);
        where = this.getWhereString(where, filterPlz);
        where = this.getWhereString(where, filterWohnort);
        where = this.getWhereString(where, filterStrasse);
        where = this.getWhereString(where, filterTelNr);
        where = this.getWhereString(where, filterNotiz);
        query += where + ";";
        return this.search( query );
    }
    
    /**
     * Setzt fest, wie die unterschiedlichen Filtertypen kombiniert werden.
     * Falls FILTER_AND als Argument übergeben wird, werden Filter
     * unterschiedlicher Properties mit AND kombiniert, bei FILTER_OR mit OR.
     */
    public void setFilterMode( int filterMode )
    {
        this.filterMode = filterMode;
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
                if( filterMode == FILTER_AND )
                    result += " AND (";
                else if( filterMode == FILTER_OR )
                    result += " OR (";
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
     * Erstellt einen neuen Suchfilter für einen Nachnamen.
     * Im Gegensatz zu normalen Filtern findet dieser Filter auch
     * dann Nachnamen, wenn nur ein Teilstring angegeben wurde.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param nachname  Der Nachname, nach dem gefiltert werden soll.
     */
    public void addSearchFilterNachname( String nachname )
    {
        String[] newFilter = new String[ filterNachname.length + 1 ];
        for( int i = 0; i < filterNachname.length; i++ ) {
            newFilter[i] = filterNachname[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Nachname LIKE " + Database.getSqlString("%" + nachname + "%");
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
     * Erstellt einen neuen Suchfilter für einen Vornamen.
     * Im Gegensatz zu normalen Filtern findet dieser Filter auch
     * dann Vornamen, wenn nur ein Teilstring angegeben wurde.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param vorname  Der Vorname, nach dem gefiltert werden soll.
     */
    public void addSearchFilterVorname( String vorname )
    {
        String[] newFilter = new String[ filterVorname.length + 1 ];
        for( int i = 0; i < filterVorname.length; i++ ) {
            newFilter[i] = filterVorname[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Vorname LIKE " + Database.getSqlString("%" + vorname + "%");
        filterVorname = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Vornamen filtern.
     */
    public void unsetFilterVorname()
    {
        filterVorname = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für ein Land.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param land  Der Land, nach dem gefiltert werden soll.
     */
    public void addFilterLand( String land )
    {
        String[] newFilter = new String[ filterLand.length + 1 ];
        for( int i = 0; i < filterLand.length; i++ ) {
            newFilter[i] = filterLand[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Land = " + Database.getSqlString(land);
        filterLand = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Land filtern.
     */
    public void unsetFilterLand()
    {
        filterLand = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für die plz.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param plz  Die gewünschte Kundennummer.
     */
    public void addFilterPlz( Integer plz)
    {
        String[] newFilter = new String[ filterPlz.length + 1 ];
        for( int i = 0; i < filterPlz.length; i++ ) {
            newFilter[i] = filterPlz[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Plz = " + Database.getSqlString(plz);
        filterPlz = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach PLZ filtern.
     */
    public void unsetFilterPlz()
    {
        filterPlz = new String[0];
    }
    
     /**
     * Erstellt einen neuen Filter für ein Wohnort.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param wohnort Der Wohnort, nach dem gefiltert werden soll.
     */
    public void addFilterWohnort( String wohnort )
    {
        String[] newFilter = new String[ filterWohnort.length + 1 ];
        for( int i = 0; i < filterWohnort.length; i++ ) {
            newFilter[i] = filterWohnort[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Wohnort = " + Database.getSqlString(wohnort);
        filterWohnort = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Wohnort filtern.
     */
    public void unsetFilterWohnort()
    {
        filterWohnort = new String[0];
    }
    
     /**
     * Erstellt einen neuen Filter für eine Strasse.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param strasse Die Strasse, nach dem gefiltert werden soll.
     */
    public void addFilterStrasse( String strasse)
    {
        String[] newFilter = new String[ filterStrasse.length + 1 ];
        for( int i = 0; i < filterStrasse.length; i++ ) {
            newFilter[i] = filterStrasse[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Strasse = " + Database.getSqlString(strasse);
        filterStrasse = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einer Strasse filtern.
     */
    public void unsetFilterStrasse()
    {
        filterStrasse = new String[0];
    }
    
     /**
     * Erstellt einen neuen Filter für eine TelNr.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param telNr Die TelNr, nach dem gefiltert werden soll.
     */
    public void addFilterTelNr( String telNr)
    {
        String[] newFilter = new String[ filterTelNr.length + 1 ];
        for( int i = 0; i < filterTelNr.length; i++ ) {
            newFilter[i] = filterTelNr[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "TelNr = " + Database.getSqlString(telNr);
        filterTelNr = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einer TelNr filtern.
     */
    public void unsetFilterTelNr()
    {
        filterTelNr = new String[0];
    }
    
     /**
     * Erstellt einen neuen Filter für eine Notiz.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param notiz  Die Notiz, nach dem gefiltert werden soll.
     */
    public void addFilterNotiz( String notiz )
    {
        String[] newFilter = new String[ filterNotiz.length + 1 ];
        for( int i = 0; i < filterNotiz.length; i++ ) {
            newFilter[i] = filterNotiz[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "Notiz = " + Database.getSqlString(notiz);
        filterNotiz = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einer Notiz filtern.
     */
    public void unsetFilterNotiz()
    {
        filterNotiz = new String[0];
    }
}
