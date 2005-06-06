/*
 * Kunde.java
 *
 * Created on 06. Juni 2005, 16:21
 */

package database;

/**
 * Ein Objekt der Klasse Ausstattung verwaltet Daten eines einzelnen Kunden.
 * Sie erbt dabei alle M�glichkeiten der Basisklasse Entity und f�gt
 * etliche Methoden zum komfortablen Setzen der Werte hinzu.
 */
public class Ausstattung extends Entity
{

    /**
     * Erstellt eine neue, nicht mit Daten gef�llte Instanz der Entity.
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
     * Setzt die Ausstattungsnummer f�r diese Entity fest.
     */
    public void setPrimaryKeys( Integer ausstattungsNr ) {
        primaryKeys[0] = ausstattungsNr;
    }

    /**
     * Setzt die Kundennummer f�r diese Entity auf einen fortlaufenden Wert.
     * Das wirkt sich nur f�rs Einf�gen einer neuen Entity in die Datenbank
     * aus, und der Schl�ssel bleibt bis zum Aufruf von toDatabase() ung�ltig,
     * oder bis er erneut gesetzt wurde.
     */
    public void setSerialKey()
    {
        primaryKeys[0] = "DEFAULT";
    }

    /**
     * Ermittelt die Ausstattungsnummer dieser Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public Integer getAusstattungsNr()
    {
        return (Integer) primaryKeys[0];
    }

    /**
     * Setzt alle Eigenschaften dieser Entity auf einmal. Um einen Wert
     * auf NULL zu setzen, muss null als Argument �bergeben werden.
     */
    public void setProperties( String bezeichnung)
    {
        // Die Werte sind so nummeriert wie oben in der Initialisierung
        // angegeben. Die Nummerierung ist unabh�ngig von der Reihenfolge
        // in der Datenbank.
        
        properties[0] = bezeichnung;
    }

    /**
     * Ermittelt die Eigenschaft Bezeichning der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public String getBezeichnung()
    {
        return (String) properties[0];
    }
}
