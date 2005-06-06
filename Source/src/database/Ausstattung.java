/*
 * Kunde.java
 *
 * Created on 06. Juni 2005, 16:21
 */

package database;

/**
 * Ein Objekt der Klasse Ausstattung verwaltet Daten eines einzelnen Kunden.
 * Sie erbt dabei alle Möglichkeiten der Basisklasse Entity und fügt
 * etliche Methoden zum komfortablen Setzen der Werte hinzu.
 */
public class Ausstattung extends Entity
{

    /**
     * Erstellt eine neue, nicht mit Daten gefüllte Instanz der Entity.
     */
    public Ausstattung()
    {
        entityName = "Ausstattung";
        primaryKeyNames = new String[] {"AusstattungsNr"};
        propertyNames = new String[] {"Bezeichnung"};
        primaryKeys = new Object[primaryKeyNames.length];
        properties = new Object[propertyNames.length];
    }

    /**
     * Setzt die Ausstattungsnummer für diese Entity fest.
     */
    public void setPrimaryKeys( Integer ausstattungsNr ) {
        primaryKeys[0] = ausstattungsNr;
    }

    /**
     * Setzt die Kundennummer für diese Entity auf einen fortlaufenden Wert.
     * Das wirkt sich nur fürs Einfügen einer neuen Entity in die Datenbank
     * aus, und der Schlüssel bleibt bis zum Aufruf von toDatabase() ungültig,
     * oder bis er erneut gesetzt wurde.
     */
    public void setSerialKey()
    {
        primaryKeys[0] = "DEFAULT";
    }

    /**
     * Ermittelt die Ausstattungsnummer dieser Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public Integer getAusstattungsNr()
    {
        return (Integer) primaryKeys[0];
    }

    /**
     * Setzt alle Eigenschaften dieser Entity auf einmal. Um einen Wert
     * auf NULL zu setzen, muss null als Argument übergeben werden.
     */
    public void setProperties( String bezeichnung)
    {
        // Die Werte sind so nummeriert wie oben in der Initialisierung
        // angegeben. Die Nummerierung ist unabhängig von der Reihenfolge
        // in der Datenbank.
        
        properties[0] = bezeichnung;
    }

    /**
     * Ermittelt die Eigenschaft Bezeichning der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public String getBezeichnung()
    {
        return (String) properties[0];
    }
}
