/*
 * Entity.java
 *
 * Created on 25. Mai 2005, 15:56
 * @author Jakob Petsovits
 */

package database;

import java.sql.ResultSet;


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
 *
 * Die Werte der Entity werden als Java-Objekte gespeichert, die z.B.
 * vom Typ String oder Integer sein können (irgendwas, hauptsache Object).
 * Beim Auslesen und Schreiben werden sie automatisch vom bzw. ins
 * Datenbankformat umgewandelt.
 */
public abstract class Entity
{
    // Der Name der zugehörigen Datenbanktabelle.
    protected String entityName;
    // Eine Liste von Strings, die die Spaltennamen der Primärschlüssel enthält.
    protected String[] primaryKeyNames;
    // Eine Liste von Objekten (vom gleichen Typ haben wie ihre Entsprechungen
    // in der Datenbank), die die Primärschlüssel der Entity enthält.
    protected Object[] primaryKeys;
    // Eine Liste von Strings, die die Spaltennamen der Eigenschaften
    // (= Nicht-Primärschlüssel) enthält.
    protected String[] propertyNames;
    // Eine Liste von Objekten (vom gleichen Typ haben wie ihre Entsprechungen
    // in der Datenbank), die die Eigenschaften der Entity enthält.
    protected Object[] properties;
    
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
    public Entity() {
        db = null; // sollte eh automatisch gemacht werden, schadet aber nicht
    }
    
    
    /**
     * Belegt die Primärschlüssel der Entity mit neuen Werten.
     * Das nächste Speichern wird mit diesen Schlüsseln erfolgen,
     * wobei die alte Entity noch vorhanden ist (falls sie nicht mit
     * deleteFromDatabase() gelöscht wurde).
     *
     * @param primaryKeys  Ein Array mit neuen Werten für die Primärschlüssel.
     */
    public void setPrimaryKeys( Object[] primaryKeys )
    {
        this.primaryKeys = primaryKeys;
    }
    
    /**
     * Gibt die Liste der Primärschlüsseln zurück.
     */
    public Object[] getPrimaryKeys()
    {
        return this.primaryKeys;
    }
    
    /**
     * Gibt die Liste der Spaltennamen der Eigenschaften zurück.
     */
    public String[] getPrimaryKeyNames()
    {
        return this.primaryKeyNames;
    }
    
    
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
     * Nach Aufruf dieser Methode haben alle Daten dieses Objekts gleiche Werte
     * wie ihre Gegenstücke in der Datenbank.
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
        
        // SQL-Abfrage zusammenstellen.
        // Der erste Primärschluessel hat noch keinen Beistrich vorn.
        String query = "SELECT ";
        
        for( i = 0; i < primaryKeyNames.length; i++ )
        {
            if( i != 0 ) {
                query += ", ";
            }
            query += primaryKeyNames[i];
        }
        for( i = 0; i < propertyNames.length; i++ ) {
            query += ", " + propertyNames[i];
        }
        query += " FROM " + entityName + " WHERE ";
        
        for( i = 1; i < primaryKeyNames.length; i++ )
        {
            if( i != 0 ) {
                query += ", ";
            }
            query += primaryKeyNames[i] + " = "
                     + Database.getSqlString(primaryKeys[i]);
        }
        query += ";";
        
        // Daten aus der Datenbank auslesen
        ResultSet result = db.query( query );
        
        if( result == null )
            return false;
        
        // Sicherheitskopie, falls was schief lauft
        // Zu ueberlegen: aus Performance-Gründen weglassen?
        Object[] primaryBackup = primaryKeys;
        Object[] propertyBackup = properties;
        
        try
        {
            // String-Werte aus dem ResultSet ermitteln
            for( i = 0; i < primaryKeyNames.length; i++ ) {
                primaryKeys[i] = result.getObject(i);
            }
            for( i = primaryKeyNames.length;
                 i < primaryKeyNames.length + propertyNames.length; i++ )
            {
                properties[i] = result.getObject(i);
            }
        }
        catch( java.sql.SQLException e )
        {
            primaryKeys = primaryBackup;
            properties = propertyBackup;
            return false;
        }
        return true;
    }
    
    
    /**
     * Schreibt die Entity in die Datenbank zurück. Geschrieben wird dabei jene
     * Entity, die mit den gesetzten Primärschlüsseln identifiziert werden kann.
     * Falls es keine Entity mit den entsprechenden Primärschlüsseln gibt,
     * wird diese erzeugt. Falls Werte aus Spalten mit DEFAULT-Werten
     * geschrieben wurden, sind diese Werte ab sofort abrufbar.
     * 
     * @return  Für den Fall, dass das Database-Objekt keine Verbindung zur
     *          Datenbank hat oder sonstige Fehlermeldungen zurückgibt, ist der
     *          Rückgabewert false, ansonsten gibt die Methode true zurück.
     */
    public boolean toDatabase()
    {
        // Pruefen, ob eh alles Notwendige vorhanden ist
        if( db == null || entityName == null
            || primaryKeyNames.length == 0 || primaryKeys.length == 0
            || propertyNames.length == 0 || properties.length == 0 )
        {
            return false;
        }
        
        String changeStatement;
        
        if( this.isInDatabase() == true )
            changeStatement = this.getUpdateStatement();
        else
            changeStatement = this.getInsertStatement();
        
        // Daten aus der Datenbank auslesen
        boolean result = db.change( changeStatement );
        
        // erneutes Auslesen, z.B. damit wir die per DEFAULT zugeteilten Werte
        // wissen.
        this.fromDatabase();
        
        return result;
    }
    
    
    /**
     * Erstellt ein SQL-UPDATE-Statement zum Schreiben der aktuellen Daten in
     * die Datenbank (wobei die Methode von toDatabase() aufgerufen wird).
     * Es wird vorausgesetzt, dass alle Datenvariablen der Klasse initialisiert
     * und auf Richtigkeit überprüft worden sind.
     */
    private String getUpdateStatement()
    {
        int i;
        String updateStatement;
        
        // Der erste Primärschluessel hat noch keinen Beistrich vorn.
        updateStatement = "UPDATE " + entityName + " SET ";
        
        // Strings vom Typ ", ZimmerNr = 666"
        for( i = 0; i < primaryKeyNames.length; i++ )
        {
            if( i != 0 ) {
                updateStatement += ", ";
            }
            updateStatement += primaryKeyNames[i] + " = "
                               + Database.getSqlString(primaryKeys[i]);
        }
        for( i = primaryKeyNames.length;
             i < primaryKeyNames.length + propertyNames.length; i++ )
        {
            updateStatement += ", " + propertyNames[i] + " = "
                               + Database.getSqlString(properties[i]);
        }
        updateStatement += ";";
        
        // und fertig. WHERE-Bedingung brauchen wir keine, die soll der
        // Programmierer, bzw. die Programmiererin, high-level auf Objektbasis
        // machen, wenn sie gebraucht wird.
        return updateStatement;
    }
    
    
    /**
     * Erstellt ein SQL-INSERT-Statement zum Schreiben der aktuellen Daten in
     * die Datenbank (wobei die Methode von toDatabase() aufgerufen wird).
     * Es wird vorausgesetzt, dass alle Datenvariablen der Klasse initialisiert
     * und auf Richtigkeit überprüft worden sind.
     */
    private String getInsertStatement()
    {
        int i;
        String insertStatement;
        
        insertStatement = "INSERT INTO " + entityName + " ( ";
        
        // Ein String vom Typ "schlüsselName1, schlüsselName2" usw.
        for( i = 0; i < primaryKeyNames.length; i++ )
        {
            if( i != 0 ) {
                insertStatement += ", ";
            }
            insertStatement += primaryKeyNames[i];
        }
        // Fortsetzung der Spaltennamenaufzaehlung mit den Eigenschaften
        for( i = primaryKeyNames.length;
             i < primaryKeyNames.length + propertyNames.length; i++ )
        {
            insertStatement += ", " + propertyNames[i];
        }
        insertStatement += " ) VALUES ( ";
        
        // So, jetzt kommen die Werte hinein ("schluessel1, schluessel2" usw.)
        for( i = 0; i < primaryKeyNames.length; i++ )
        {
            if( i != 0 ) {
                insertStatement += ", ";
            }
            if( primaryKeys[i] == null ) // gibts nicht, deshalb: default
                insertStatement += "DEFAULT";
            else
                insertStatement += Database.getSqlString(primaryKeys[i]);
        }
        // Fortsetzung der Werteaufzaehlung mit den Eigenschaften
        for( i = primaryKeyNames.length;
             i < primaryKeyNames.length + propertyNames.length; i++ )
        {
            insertStatement += ", " + Database.getSqlString(properties[i]);
        }
        insertStatement += " );";
        
        // und fertig
        return insertStatement;
    }
    
    
    /**
     * Löscht die Entity, die mit den gesetzten Primärschlüsseln
     * identifiziert wird, aus der Datenbank. 
     * 
     * @return  Für den Fall, dass das Database-Objekt keine Verbindung zur
     *          Datenbank hat oder sonstige Fehlermeldungen zurückgibt, ist der
     *          Rückgabewert false, ansonsten gibt die Methode true zurück.
     *          (Sie gibt auch true zurück, wenn die Entity schon vorher nicht
     *           in der Datenbank vorhanden war).
     */
    public boolean deleteFromDatabase()
    {
        int i;
        String deleteStatement;
        
        if( this.isInDatabase() == false )
            return true; // true wie: das Objekt ist gelöscht.
        
        // Pruefen, ob eh alles Notwendige vorhanden ist
        if( db == null || entityName == null || primaryKeyNames.length == 0 )
        {
            return false;
        }
        
        // Der erste Primärschluessel hat noch keinen Beistrich vorn.
        deleteStatement = "DELETE FROM " + entityName + " WHERE ";
        
        // Strings vom Typ ", ZimmerNr = 666"
        for( i = 0; i < primaryKeyNames.length; i++ )
        {
            if( i != 0 ) {
                deleteStatement += " AND ";
            }
            deleteStatement += primaryKeyNames[i] + " = "
                               + Database.getSqlString(primaryKeys[i]);
        }
        deleteStatement += ";";
        
        // Daten aus der Datenbank auslesen
        return db.change( deleteStatement );
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
        int i;
        
        // Pruefen, ob eh alles Notwendige vorhanden ist
        if( db == null || entityName == null || primaryKeyNames.length == 0 )
        {
            return false;
        }
        
        // SQL-Abfrage zusammenstellen
        // (ohne Eigenschaften, die sind in dem Zusammenhang unwichtig)
        String query = "SELECT ";
        
        for( i = 1; i < primaryKeyNames.length; i++ )
        {
            if( i != 0 ) {
                query += ", ";
            }
            query += primaryKeyNames[i];
        }
        query += " FROM " + entityName + " WHERE ";
        
        for( i = 1; i < primaryKeyNames.length; i++ )
        {
            if( i != 0 ) {
                query += ", ";
            }
            query += primaryKeyNames[i] + " = "
                     + Database.getSqlString(primaryKeys[i]);
        }
        query += ";";
        
        // Daten aus der Datenbank auslesen
        ResultSet result = db.query( query );
        
        if( result == null )
            return false;
        else
            return true;
    }
}
