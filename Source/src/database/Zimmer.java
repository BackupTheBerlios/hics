/*
 * Kunde.java
 *
 * Created on 25. Mai 2005, 23:04
 */

package database;

/**
 * Ein Objekt der Klasse Zimmer verwaltet Daten eines einzelnen Zimmers.
 * Sie erbt dabei alle Möglichkeiten der Basisklasse Entity und fügt
 * etliche Methoden zum komfortablen Setzen der Werte hinzu.
 */
public class Zimmer extends Entity
{

    /**
     * Erstellt eine neue, nicht mit Daten gefüllte Instanz der Entity.
     */
    public Zimmer()
    {
        entityName = "Zimmer";
        primaryKeyNames = new String[] {"ZimmerNr"};
        propertyNames = new String[] {"AnzahlBetten", "PreisProNacht"};
        primaryKeys = new Object[primaryKeyNames.length];
        properties = new Object[propertyNames.length];
    }

    /**
     * Setzt die Zimmernummer für diese Entity fest.
     */
    public void setPrimaryKeys( Integer zimmerNr ) {
        primaryKeys[0] = zimmerNr;
    }

    /**
     * Setzt die Zimmernummer für diese Entity auf einen fortlaufenden Wert.
     * Das wirkt sich nur fürs Einfügen einer neuen Entity in die Datenbank
     * aus, und der Schlüssel bleibt bis zum Aufruf von toDatabase() ungültig,
     * oder bis er erneut gesetzt wurde.
     */
    public void setSerialKey()
    {
        primaryKeys[0] = null;
    }

    /**
     * Ermittelt die Zimmernummer dieser Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public Integer getZimmerNr()
    {
        return (Integer) primaryKeys[0];
    }

    /**
     * Setzt alle Eigenschaften dieser Entity auf einmal. Um einen Wert
     * auf NULL zu setzen, muss null als Argument übergeben werden.
     */
    public void setProperties( Integer anzahlBetten, Double preisProNacht )
    {
        // Die Werte sind so nummeriert wie oben in der Initialisierung
        // angegeben. Die Nummerierung ist unabhängig von der Reihenfolge
        // in der Datenbank.
        properties[0] = anzahlBetten;
        properties[1] = preisProNacht;
    }


    /**
     * Ermittelt die Eigenschaft AnzahlBetten der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public Integer getAnzahlBetten()
    {
        return (Integer) properties[0];
    }

    /**
     * Ermittelt die Eigenschaft AnzahlBetten der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public Double getPreisProNacht()
    {
        return (Double) properties[1];
    }
}
