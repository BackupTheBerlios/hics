/*
 * QueryAufgabe.java
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
public class QueryAufgabe extends Query
{
    String[] filterAufgabenNr;
    String[] filterZimmerNr;
    String[] filterAb;
    String[] filterDeadline;
    String[] filterErledigt;
    
    /**
     * Erstellt eine neue Instanz von QueryAufgabe.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public QueryAufgabe( Database database )
    {
        super(database);
        filterAufgabenNr = new String[0];
        filterZimmerNr = new String[0];
        filterAb = new String[0];
        filterDeadline = new String[0];
        filterErledigt = new String[0];
    }
    
    /**
     * Ermittelt alle Aufgaben-Entities,
     * die mit der SQL-Abfrage gefunden wurden.
     */
    public Aufgabe[] getAufgabenEntites()
    {
        Entity[] entities = this.getEntities( new Aufgabe() );
        Aufgabe[] aufgaben = new Aufgabe[entities.length];
        for( int i = 0; i < entities.length; i++ ) {
            aufgaben[i] = (Aufgabe) entities[i];
        }
        return aufgaben;
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
        String query = "SELECT AufgabenNr, ZimmerNr FROM Aufgabe";
        
        String where = this.getWhereString("", filterAufgabenNr);
        where = this.getWhereString(where, filterZimmerNr);
        where = this.getWhereString(where, filterAb);
        where = this.getWhereString(where, filterDeadline);
        where = this.getWhereString(where, filterErledigt);
        
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
     * Erstellt einen neuen Filter für die Aufgabennummer.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param aufgabenNr  Die gewünschte Aufgabennummer.
     */
    public void addFilterAufgabenNr( Integer aufgabenNr )
    {
        String[] newFilter = new String[ filterAufgabenNr.length + 1 ];
        for( int i = 0; i < filterAufgabenNr.length; i++ ) {
            newFilter[i] = filterAufgabenNr[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "AufgabenNr = " + Database.getSqlString(aufgabenNr);
        filterAufgabenNr = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach Aufgabennummern filtern.
     */
    public void unsetFilterAufgabenNr()
    {
        filterAufgabenNr = new String[0];
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
     * Erstellt einen neuen Filter für ein Anfangsdatum der Aufgabe.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param ab  Das Anfangsdatum der Aufgabe,
     *            nach dem gefiltert werden soll.
     */
    public void addFilterAb( Date ab )
    {
        String[] newFilter = new String[ filterAb.length + 1 ];
        for( int i = 0; i < filterAb.length; i++ ) {
            newFilter[i] = filterAb[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "ab = " + Database.getSqlString(ab);
        filterAb = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Anfangsdatum
     * der Aufgabe filtern.
     */
    public void unsetFilterAb()
    {
        filterAb = new String[0];
    }
    
    /**
     * Erstellt einen neuen Filter für die Deadline der Aufgabe.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param deadline  Die Deadline der Aufgabe,
     *                  nach der gefiltert werden soll.
     */
    public void addFilterDeadline( Date deadline )
    {
        String[] newFilter = new String[ filterDeadline.length + 1 ];
        for( int i = 0; i < filterDeadline.length; i++ ) {
            newFilter[i] = filterDeadline[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "bis = " + Database.getSqlString(deadline);
        filterDeadline = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einer Deadline der Aufgabe filtern.
     */
    public void unsetFilterDeadline()
    {
        filterDeadline = new String[0];
    }
    
    
    
    /**
     * Erstellt einen neuen Filter für den Aufgaben-Status.
     * Bereits vorhandene Filter dieses Typs bleiben erhalten und werden
     * mit einem OR kombiniert.
     *
     * @param erledigt  Der Aufgaben-Status,
     *                  nach dem gefiltert werden soll.
     */
    public void addFilterErledigt( Boolean erledigt )
    {
        String[] newFilter = new String[ filterErledigt.length + 1 ];
        for( int i = 0; i < filterErledigt.length; i++ ) {
            newFilter[i] = filterErledigt[i];
        }
        newFilter[ newFilter.length - 1 ]
                = "erledigt = " + Database.getSqlString(erledigt);
        filterErledigt = newFilter;
    }
    
    /**
     * Löscht alle Filter, die nach einem Aufgaben-Status filtern.
     */
    public void unsetFilterErledigt()
    {
        filterDeadline = new String[0];
    }
}
