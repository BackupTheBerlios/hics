/*
 * Aufenthalt.java
 *
 * Created on 11. Juni 2005, 11:31
 */

package database;

/**
 * Ein Objekt der Klasse Aufenthalt verwaltet Daten eines einzelnen Aufenthalts.
 * Sie erbt dabei alle M�glichkeiten der Basisklasse Entity und f�gt
 * etliche Methoden zum komfortablen Setzen der Werte hinzu.
 */
public class Aufenthalt extends Entity
{

    /**
     * Erstellt eine neue, nicht mit Daten gef�llte Instanz der Entity.
     */
    public Aufenthalt()
    {
        entityName = "Aufenthalt";
        primaryKeyNames = new String[] {"AufenthaltsNr"};
        propertyNames = new String[] {"KundenNr", "Von", "Bis","Status"};
        primaryKeys = new Object[primaryKeyNames.length];
        properties = new Object[propertyNames.length];
    }

    /**
     * Setzt die Aufenthaltsnummer f�r diese Entity fest.
     */
    public void setPrimaryKeys( Integer aufenthaltsNr ) {
        primaryKeys[0] = aufenthaltsNr;
    }

    /**
     * Setzt die Aufenthaltsnummer f�r diese Entity auf einen fortlaufenden Wert.
     * Das wirkt sich nur f�rs Einf�gen einer neuen Entity in die Datenbank
     * aus, und der Schl�ssel bleibt bis zum Aufruf von toDatabase() ung�ltig,
     * oder bis er erneut gesetzt wurde.
     */
    public void setSerialKey()
    {
        primaryKeys[0] = "DEFAULT";
    }

    /**
     * Ermittelt die Aufenthaltsnummer dieser Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public Integer getAufenthaltsNR()
    {
        return (Integer) primaryKeys[0];
    }

    /**
     * Setzt alle Eigenschaften dieser Entity auf einmal. Um einen Wert
     * auf NULL zu setzen, muss null als Argument �bergeben werden.
     */

    public void setProperties(Integer kundenNr, java.util.Date von, java.util.Date bis, String status )
    {
        // Die Werte sind so nummeriert wie oben in der Initialisierung
        // angegeben. Die Nummerierung ist unabh�ngig von der Reihenfolge
        // in der Datenbank.
        properties[0] = kundenNr;
        properties[1] = von;
        properties[2] = bis;
        properties[3] = status;
    }

    /**
	 * Ermittelt die Eigenschaft Von der Entity. Falls der entsprechende
	 * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
	 */
	public Integer getKundenNr()
	{
	    return (Integer) properties[0];
	}

    /**
     * Ermittelt die Eigenschaft Von der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public java.util.Date getVon()
    {
        return (java.util.Date) properties[1];
    }

    /**
     * Ermittelt die Eigenschaft Bis der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public java.util.Date getBis()
    {
        return (java.util.Date) properties[2];
    }

    /**
     * Ermittelt die Eigenschaft Status der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public String getStatus()
    {
        return (String) properties[3];
    }
}
