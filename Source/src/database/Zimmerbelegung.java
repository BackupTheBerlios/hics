/*
 * Kunde.java
 *
 * Created on 25. Mai 2005, 23:04
 */

package database;

/**
 * Ein Objekt der Klasse Zimmerbelegung verwaltet Zuordnungen von Zimmern
 * mit Aufenthalten mit von- und bis-Datum.
 * Sie erbt dabei alle Möglichkeiten der Basisklasse Entity und fügt
 * etliche Methoden zum komfortablen Setzen der Werte hinzu.
 */
public class Zimmerbelegung extends Entity
{

    /**
     * Erstellt eine neue, nicht mit Daten gefüllte Instanz der Relation.
     */
    public Zimmerbelegung()
    {
        entityName = "belegt";
        primaryKeyNames = new String[] {"AufenthaltsNr", "ZimmerNr"};
        propertyNames = new String[] {"von", "bis"};
        primaryKeys = new Object[primaryKeyNames.length];
        properties = new Object[propertyNames.length];
    }

    /**
     * Setzt die Aufenthalts- und Zimmernummer für diese Relation fest.
     */
    public void setPrimaryKeys( Integer aufenthaltsNr, Integer zimmerNr ) {
        primaryKeys[0] = aufenthaltsNr;
        primaryKeys[1] = zimmerNr;
    }

    /**
     * Ermittelt die Aufenthaltsnummer dieser Relation. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public Integer getAufenthaltsNr()
    {
        return (Integer) primaryKeys[0];
    }

    /**
     * Ermittelt die Zimmernummer dieser Relation. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public Integer getZimmerNr()
    {
        return (Integer) primaryKeys[1];
    }

    /**
     * Setzt alle Eigenschaften dieser Relation auf einmal. Um einen Wert
     * auf NULL zu setzen, muss null als Argument übergeben werden.
     */
    public void setProperties( java.sql.Date von, java.sql.Date bis )
    {
        // Die Werte sind so nummeriert wie oben in der Initialisierung
        // angegeben. Die Nummerierung ist unabhängig von der Reihenfolge
        // in der Datenbank.
        properties[0] = von;
        properties[1] = bis;
    }


    /**
     * Ermittelt die Eigenschaft Von der Relation. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public java.sql.Date getVon()
    {
        return (java.sql.Date) properties[0];
    }

    /**
     * Ermittelt die Eigenschaft Von der Relation. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public java.sql.Date getBis()
    {
        return (java.sql.Date) properties[1];
    }
}
