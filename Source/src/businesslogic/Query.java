/*
 * Query.java
 *
 * Created on 26. Mai 2005, 23:29
 */

package businesslogic;

import java.sql.*;
import database.*;

/**
 * Query verkörpert eine Datenbankabfrage. Ihr wichtigstes Element ist
 * ein Abfrage-String, der von einer abgeleiteten Klasse gesetzt werden muss.
 * Diese Abfrage wird an das Database-Objekt der Klasse geschickt, und aus
 * dem Ergebnis können Entity-Objekte erzeugt werden.
 *
 * Diese Klasse ist als Basisklasse für konkrete, abzuleitende Klassen gedacht.
 * In diesen Klassen muss im Prinzip nur der Abfrage-String gesetzt werden,
 * um voll einsatzfähig zu sein. Darüber hinaus sollen auch Methoden zum
 * leichteren Setzen der Suchparameter und zum Ermitteln eines bestimmten 
 * Entity-Typs (oder zum Ermitteln von Nicht-Entity-Ergebnissen)
 * implementiert werden.
 */
public abstract class Query
{
    // Ein SQL-SELECT-Statement, das zum Ermitteln des Abfrage-Ergebnisses
    // verwendet wird.
    protected String query;
    // Das Ergebnis der Abfrage.
    protected ResultSet result;
    
    // Das Datenbank-Objekt, das zum Abfragen der Werte verwendet werden soll.
    private Database db;
    
    
    /** 
     * Erstellt eine neue Instanz von Query.
     *
     * @param database  Das Datenbank-Objekt, das zum Abfragen der Werte
     *                  verwendet werden soll.
     */
    public Query( Database database )
    {
        result = null;
        db = database;
    }
    
    /**
     * Diese Methode muss von abgeleiteten Klassen implementiert werden.
     * Sie stellen hier den SQL-Abfragestring zusammen und rufen
     * search( query ) auf. Falls aus dem Abfrage-Ergebnis Entities extrahiert
     * werden sollen, müssen dort Spalten mit den Namen der Primärschlüsseln
     * der Entity enthalten sein. Nach Aufruf dieser Methode ist das
     * Abfrage-Ergebnis im Objekt zwischengespeichert und kann
     * über diverse andere Methoden ermittelt werden.
     * 
     * @return  Falls die Abfrage nicht durchgeführt werden konnte (z.B.
     *          weil das Database-Objekt keine Verbindung zur Datenbank hat),
     *          gibt die Methode false zurück. Ansonsten, und insbesondere auch
     *          bei leeren Ergebnismengen, wird true zurückgegeben.
     */
    abstract public boolean search();
    
    /**
     * Übernimmt die konkrete SQL-Abfrage und schickt sie an das
     * Database-Objekt. Das Abfrage-Ergebnis wird im Query-Objekt
     * zwischengespeichert und kann nach Aufruf dieser Methode
     * über diverse andere Methoden ermittelt werden.
     * 
     * @return  Falls die Abfrage nicht durchgeführt werden konnte (z.B.
     *          weil das Database-Objekt keine Verbindung zur Datenbank hat),
     *          gibt die Methode false zurück. Ansonsten, und insbesondere auch
     *          bei leeren Ergebnismengen, wird true zurückgegeben.
     */
    protected boolean search( String query )
    {
        if( db == null || query == null )
            return false;
        
        result = db.query( query );
        
        if( result == null )
            return false;
        else
            return true;
    }
    
    /**
     * Gibt das unbearbeitete Ergebnis der Abfrage als JDBC-ResultSet zurück.
     * Falls noch gar nicht gesucht wurde, wird null zurückgegeben.
     */
    public ResultSet getResultSet()
    {
        return result;
    }
    
    /**
     * Ermittelt die Anzahl der Zeilen des Abfrage-Ergebnisses.
     */
    public int getRowCount()
    {
        if( result == null )
            return 0;
        
        try {
            result.last();
            return result.getRow();
        }
        catch( SQLException e ) {
            return 0;
        }
    }
    
    /**
     * Ermittelt alle Entity-Objekte vom Typ der als Parameter
     * übergebenen Vorlage, die im Abfrage-Ergebnis gefunden wurden.
     *
     * @param template  Ein Objekt vom gleichen Typ wie die gewünschten
     *                  Entities, die gefunden werden sollen.
     *
     * @result  Eine Liste von allen Entities des angegebenen Entity-Typs,
     *          die mit der Abfrage gefunden wurden. Bei Fehlern wird null
     *          zurückgegeben, bei einem leeren Ergebnis ist der Rückgabewert
     *          ein leeres Array. Es werden genau so viele Entities
     *          zurückgeliefert, wie es Zeilen im Abfrage-Ergebnis gibt.
     *          Bei nicht ermittelbaren Entities können daher auch Nullwerte
     *          in der Liste vorkommen.
     */
    protected Entity[] getEntities( Entity template )
    {
        if( result == null || template == null )
            return null;
        
        Entity[] entities = new Entity[ getRowCount() ];
        
        int[] columns = getPrimaryKeyColumns( template );
        if( columns == null )
            return null;
        
        try {
            // alle Zeilen durchgehen und von jeder die Entity mitnehmen
            for( result.first(); result.isAfterLast() == false; result.next() )
            {
                entities[result.getRow()] = getEntity( template, columns );
            }
        }
        catch( SQLException e ) {
            return null;
        }
        return entities;
    }
    
    /**
     * Ermittelt ein einzelnes Entity-Objekt vom Typ der als Parameter
     * übergebenen Vorlage. Es wird das Objekt in der als Parameter übergebenen
     * Zeile des ResultSets ausgelesen.
     *
     * @param template  Ein Objekt vom gleichen Typ wie die gewünschten
     *                  Entities, die gefunden werden sollen.
     *
     * @result  Das Entity-Objekt der gewünschten ResultSet-Zeile, falls es
     *          ermittelt werden konnte. Falls nicht, wird stattdessen null
     *          zurückgegeben (z.B. auch, wenn es gar nicht so viele Zeilen
     *          im Ergebnis gibt wie in row angegeben).
     */
    protected Entity getEntity( Entity template, int row )
    {
        if( result == null || template == null )
            return null;
        
        int[] columns = getPrimaryKeyColumns( template );
        if( columns == null )
            return null;
        
        try {
            // in die Zeile row wechseln
            result.absolute( row );
        } catch( SQLException e ) {
            return null;
        }
        return getEntity( template, columns );
    }
    
    /**
     * Ermittelt ein einzelnes Entity-Objekt vom Typ der als Parameter
     * übergebenen Vorlage. Es wird das Objekt in der aktuellen Zeile des
     * ResultSets ausgelesen.
     *
     * @param template  Ein Objekt vom gleichen Typ wie die gewünschten
     *                  Entities, die gefunden werden sollen.
     * @param columns  Eine Liste von Indizes der auszulesenden Spalten.
     *                 Die Liste darf nicht null sein, und es wird erwartet,
     *                 dass sie in der gleichen Reihenfolge sortiert ist wie
     *                 die primaryKeyNames des Entity-Objekts.
     *
     * @result  Das Entity-Objekt der aktuellen ResultSet-Zeile, falls es
     *          ermittelt werden konnte. Falls nicht, wird stattdessen null
     *          zurückgegeben.
     */
    private Entity getEntity( Entity template, int[] columns )
    {
        Entity newEntity;
        
        // Neue Entity vom Typ der übergebenen instanzieren
        try {
            newEntity = (Entity) template.getClass().newInstance();
        } catch( Exception e ) {
            return null;
        }
        Object[] primaryKeys = new Object[ columns.length ];

        // Primärschlüsselwerte auslesen und dem Entity-Objekt übergeben
        try {
            for( int i = 0; i < columns.length; i++ )
            {
                primaryKeys[i] = result.getObject(columns[i]);
            }
        } catch( SQLException e ) {
            return null;
        }
        newEntity.setPrimaryKeys( primaryKeys );
        
        // Aus der Datenbank holen und fertig. Das ging ja einfach.
        if( newEntity.fromDatabase() == false )
            return null;
        else
            return newEntity;
    }
    
    /**
     * Findet heraus, ob das Abfrage-Ergebnis die zum Erstellen eines
     * Entity-Objekts nötigen Spalten hat. Falls ja, wird eine Liste der
     * Spaltenindizes zurückgegeben (in der gleichen Reihenfolge wie die
     * primaryKeyNames der Entity). Falls nicht alle Primärschlüsselspalten
     * vorhanden sind, ist der Rückgabewert null.
     */
    private int[] getPrimaryKeyColumns( Entity template )
    {
        String[] primaryKeyNames = template.getPrimaryKeyNames();
        int[] columns = new int[ primaryKeyNames.length ];
        
        try {
            for( int i = 0; i < columns.length; i++ )
            {
                columns[i] = result.findColumn( primaryKeyNames[i] );
            }
        } catch( SQLException e ) {
            return null;
        }
        return columns;
    }
}
