/*
 * Aufgabe.java
 *
 * Created on 06. Juni 2005, 15:14
 */

package database;

/**
 * Ein Objekt der Klasse Aufgabe verwaltet Daten einer einzelnen Aufgabe.
 * Sie erbt dabei alle M�glichkeiten der Basisklasse Entity und f�gt
 * etliche Methoden zum komfortablen Setzen der Werte hinzu.
 */
public class Aufgabe extends Entity
{

    /**
     * Erstellt eine neue, nicht mit Daten gef�llte Instanz der Entity.
     */
    public Aufgabe()
    {
        entityName = "Aufgabe";
        primaryKeyNames = new String[] {"AufgabenNr"};
        propertyNames = new String[] {"ZimmerNr", "Bezeichnung","Ab","Deadline","Erledigt"};
        primaryKeys = new Object[primaryKeyNames.length];
        properties = new Object[propertyNames.length];
    }

    /**
     * Setzt die Aufgabenummer f�r diese Entity fest.
     */
    public void setPrimaryKeys( Integer aufgabeNr ) {
        primaryKeys[0] = aufgabeNr;
    }

    /**
     * Setzt die Aufgabenummer f�r diese Entity auf einen fortlaufenden Wert.
     * Das wirkt sich nur f�rs Einf�gen einer neuen Entity in die Datenbank
     * aus, und der Schl�ssel bleibt bis zum Aufruf von toDatabase() ung�ltig,
     * oder bis er erneut gesetzt wurde.
     */
    public void setSerialKey()
    {
        primaryKeys[0] = null;
    }

    /**
     * Ermittelt die Aufgabenummer dieser Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public Integer getAufgabenNr()
    {
        return (Integer) primaryKeys[0];
    }

    /**
     * Setzt alle Eigenschaften dieser Entity auf einmal. Um einen Wert
     * auf NULL zu setzen, muss null als Argument �bergeben werden.
     */
    
    public void setProperties( Integer zimmerNr, String bezeichnung,
            java.util.Date ab, java.util.Date deadline, Boolean erledigt )
    {
        // Die Werte sind so nummeriert wie oben in der Initialisierung
        // angegeben. Die Nummerierung ist unabh�ngig von der Reihenfolge
        // in der Datenbank.
        properties[0] = zimmerNr;
        properties[1] = bezeichnung;
        properties[2] = ab;
        properties[3] = deadline;
        properties[4] = erledigt;
    }


    /**
     * Ermittelt die Eigenschaft Zimmernummer der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public Integer getZimmerNr()
    {
        return (Integer) properties[0];
    }

    /**
     * Ermittelt die Eigenschaft Bezeichnung der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public String getBezeichnung()
    {
        return (String) properties[1];
    }
    
    /**
     * Ermittelt die Eigenschaft Ab der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public java.util.Date getAb()
    {
        return (java.util.Date) properties[2];
    }
    
    /**
     * Ermittelt die Eigenschaft Deadline der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public java.util.Date getDeadline()
    {
        return (java.util.Date) properties[3];
    }
    
    /**
     * Ermittelt die Eigenschaft Erledigt der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public Boolean getErledigt()
    {
        return (Boolean) properties[4];
    }
}
