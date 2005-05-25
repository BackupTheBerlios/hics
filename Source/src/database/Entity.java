/*
 * Entity.java
 *
 * Created on 25. Mai 2005, 15:56
 * @author Jakob Petsovits
 */

package database;

/**
 * Entity ist eine Klasse zum Verwalten von Prim�rschl�sseln und Eigenschaften
 * einer Datenbank-Entity. Als solches enth�lt sie im Normalfall die Werte
 * einer Tabellenzeile. Sie erm�glicht au�erdem das Auslesen und Speichern 
 * der Werte von bzw. in die Datenbank.
 *
 * Diese Klasse ist als Basisklasse f�r konkretere, abzuleitende Klassen
 * gedacht. In den abgeleiteten Klassen m�ssen nur noch die Namen der
 * Tabellenspalten definiert werden, um vollwertige Funktionalit�t zum
 * Auslesen und Speichern zu erhalten. Weiters sollen f�r Schl�ssel und
 * Eigenschaften get- und set-Methoden in den abgeleiteten Klassen zur
 * Verf�gung gestellt werden.
 */
public abstract class Entity
{
    // Der Name der zugeh�rigen Datenbanktabelle.
    protected String entityName;
    // Eine Liste von Strings, die die Spaltennamen der Prim�rschl�ssel enth�lt.
    protected String[] primaryKeyNames;
    // Eine Liste von Strings, die die Prim�rschl�ssel der Entity enth�lt.
    protected String[] primaryKeys;
    // Eine Liste von Strings, die die Spaltennamen der Eigenschaften
    // (= Nicht-Prim�rschl�ssel) enth�lt.
    protected String[] propertyNames;
    // Eine Liste von Strings, die die Eigenschaften der Entity enth�lt.
    protected String[] properties;
    
    // Das Datenbank-Objekt, das zum Auslesen und Schreiben
    // verwendet werden soll.
    private Database db;
    
    
    /**
     * Erstellt eine neue, nicht mit Daten gef�llte Instanz der Entity.
     * Abgeleitete Klassen sollen im Konstruktor die Instanzvariablen
     * entityName, primaryKeyNames und propertyNames f�llen.
     * Des weiteren sollen die primaryKeys- und properties-Arrays
     * richtig dimensioniert werden, z.B. mit "primaryKeys = new String[2];"
     * (f�r einen aus zwei Werten zusammengesetzten Prim�rschl�ssel).
     */
    public Entity() {}
    
    /**
     * Weist der Entity eine Datenbank zu, die zum Auslesen und Schreiben
     * der Daten verwendet werden soll.
     * 
     * @returns  Falls der Parameter null ist, wird false zur�ckgegeben,
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
     * die mit den gesetzten Prim�rschl�sseln identifiziert werden kann.
     * 
     * @return  Falls es keine Entity mit den entsprechenden Prim�rschl�sseln
     *          gibt, oder das Database-Objekt keine Verbindung zur Datenbank
     *          hat, wird false zur�ckgegeben. Ansonsten ist der R�ckgabewert
     *          f�r erfolgreiches Auslesen true.
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
     * Schreibt die Entity in die Datenbank zur�ck. Geschrieben wird dabei jene
     * Entity, die mit den gesetzten Prim�rschl�sseln identifiziert werden kann.
     * Falls es keine Entity mit den entsprechenden Prim�rschl�sseln gibt,
     * wird diese erzeugt.
     * 
     * @return  F�r den Fall, dass das Database-Objekt keine Verbindung zur
     *          Datenbank hat oder sonstige Fehlermeldungen zur�ckgibt, ist der
     *          R�ckgabewert false, ansonsten gibt die Methode true zur�ck.
     */
    public boolean toDatabase()
    {
        //blabla;
        
        return true;
    }
    
    /**
     * L�scht die Entity, die mit den gesetzten Prim�rschl�sseln
     * identifiziert wird, aus der Datenbank. 
     * 
     * @return  F�r den Fall, dass das Database-Objekt keine Verbindung zur
     *          Datenbank hat oder sonstige Fehlermeldungen zur�ckgibt, ist der
     *          R�ckgabewert false, ansonsten gibt die Methode true zur�ck.
     */
    public boolean deleteFromDatabase()
    {
        //bla. blablabla.
        
        return true;
    }
    
    /**
     * Pr�ft, ob es einen Datenbank-Eintrag f�r die gesetzten
     * Prim�rschl�sselwerte gibt. Falls eine solche Entity vorhanden ist,
     * wird true zur�ckgegeben, falls nicht, false. F�r den Fall, dass das
     * Database-Objekt keine Verbindung zur Datenbank hat oder sonstige
     * Fehlermeldungen zur�ckgibt, ist der R�ckgabewert ebenfalls false.
     */
    public boolean isInDatabase()
    {
        //superbla.
        
        return true;
    }
}
