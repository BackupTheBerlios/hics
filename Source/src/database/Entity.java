/*
 * Entity.java
 *
 * Created on 25. Mai 2005, 15:56
 * @author Jakob Petsovits
 */

package database;

/**
 * Entity ist eine Klasse zum Verwalten von Primärschlüsseln und Eigenschaften
 * einer Datenbank-Entity. Als solches enthält sie im Normalfall die Werte
 * einer Tabellenzeile. Sie ermöglicht außerdem das Auslesen und Speichern 
 * der Werte von bzw. in die Datenbank.
 *
 * Diese Klasse ist als Basisklasse für konkretere, abzuleitende Klassen
 * gedacht. In den abgeleiteten Klassen müssen nur noch die Namen der
 * Tabellenspalten definiert werden, um vollwertige Funktionalität zum
 * Auslesen und Speichern zu erhalten. Weiters sollen für Schlüssel und
 * Eigenschaften get- und set-Methoden in den abgeleiteten Klassen zur
 * Verfügung gestellt werden.
 */
public abstract class Entity
{
    // Der Name der zugehörigen Datenbanktabelle.
    protected String entityName;
    // Eine Liste von Strings, die die Spaltennamen der Primärschlüssel enthält.
    protected String[] primaryKeyNames;
    // Eine Liste von Strings, die die Primärschlüssel der Entity enthält.
    protected String[] primaryKeys;
    // Eine Liste von Strings, die die Spaltennamen der Eigenschaften
    // (= Nicht-Primärschlüssel) enthält.
    protected String[] propertyNames;
    // Eine Liste von Strings, die die Eigenschaften der Entity enthält.
    protected String[] properties;
    
    // Das Datenbank-Objekt, das zum Auslesen und Schreiben
    // verwendet werden soll.
    private Database db;
    
    
    /**
     * Erstellt eine neue, nicht mit Daten gefüllte Instanz der Entity.
     * Abgeleitete Klassen sollen im Konstruktor die Instanzvariablen
     * entityName, primaryKeyNames und propertyNames füllen.
     * Des weiteren sollen die primaryKeys- und properties-Arrays
     * richtig dimensioniert werden, z.B. mit "primaryKeys = new String[2];"
     * (für einen aus zwei Werten zusammengesetzten Primärschlüssel).
     */
    public Entity() {}
    
    /**
     * Weist der Entity eine Datenbank zu, die zum Auslesen und Schreiben
     * der Daten verwendet werden soll.
     * 
     * @returns  Falls der Parameter null ist, wird false zurückgegeben,
     *           ansonsten true.
     */
    boolean assignDatabase( Database database )
    {
        if( database == null )
            return false;
        else
            return true;
    }
    
    /**
     * Liest die Entity aus der Datenbank aus. Gelesen wird dabei jene Entity,
     * die mit den gesetzten Primärschlüsseln identifiziert werden kann.
     * 
     * @return  Falls es keine Entity mit den entsprechenden Primärschlüsseln
     *          gibt, oder das Database-Objekt keine Verbindung zur Datenbank
     *          hat, wird false zurückgegeben. Ansonsten ist der Rückgabewert
     *          für erfolgreiches Auslesen true.
     */
    public boolean fromDatabase()
    {
        int i;
        
        // Pruefen, ob eh alles Notwendige vorhanden ist
        if( db == null || entityName == null || primaryKeyNames.length == 0 )
        {
            return false;
        }
        
        // SQL-Abfrage zusammenstellen
        String query = "SELECT " + primaryKeyNames[0];
        
        for( i = 1; i < primaryKeyNames.length; i++ ) {
            query += ", " + primaryKeyNames[i];
        }
        for( i = 0; i < propertyNames.length; i++ ) {
            query += ", " + propertyNames[i];
        }
        query += " FROM " + entityName;
        
        ResultSet result = db.query( query );
        
        return true;
    }
    
    /**
     * Schreibt die Entity in die Datenbank zurück. Geschrieben wird dabei jene
     * Entity, die mit den gesetzten Primärschlüsseln identifiziert werden kann.
     * Falls es keine Entity mit den entsprechenden Primärschlüsseln gibt,
     * wird diese erzeugt.
     * 
     * @return  Für den Fall, dass das Database-Objekt keine Verbindung zur
     *          Datenbank hat oder sonstige Fehlermeldungen zurückgibt, ist der
     *          Rückgabewert false, ansonsten gibt die Methode true zurück.
     */
    public boolean toDatabase()
    {
        //blabla;
        
        return true;
    }
    
    /**
     * Löscht die Entity, die mit den gesetzten Primärschlüsseln
     * identifiziert wird, aus der Datenbank. 
     * 
     * @return  Für den Fall, dass das Database-Objekt keine Verbindung zur
     *          Datenbank hat oder sonstige Fehlermeldungen zurückgibt, ist der
     *          Rückgabewert false, ansonsten gibt die Methode true zurück.
     */
    public boolean deleteFromDatabase()
    {
        //bla. blablabla.
        
        return true;
    }
    
    /**
     * Prüft, ob es einen Datenbank-Eintrag für die gesetzten
     * Primärschlüsselwerte gibt. Falls eine solche Entity vorhanden ist,
     * wird true zurückgegeben, falls nicht, false. Für den Fall, dass das
     * Database-Objekt keine Verbindung zur Datenbank hat oder sonstige
     * Fehlermeldungen zurückgibt, ist der Rückgabewert ebenfalls false.
     */
    public boolean isInDatabase()
    {
        //superbla.
        
        return true;
    }
}
