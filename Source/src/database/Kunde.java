/*
 * Kunde.java
 *
 * Created on 25. Mai 2005, 23:04
 * @author Jakob Petsovits
 */

package database;

/**
 * Ein Objekt der Klasse Kunde verwaltet Daten eines einzelnen Kunden.
 * Sie erbt dabei alle M�glichkeiten der Basisklasse Entity und f�gt
 * etliche Methoden zum komfortablen Setzen der Werte hinzu.
 */
public class Kunde extends Entity
{

    /**
     * Erstellt eine neue, nicht mit Daten gef�llte Instanz der Entity.
     */
    public Kunde()
    {
        entityName = "Kunde";
        primaryKeyNames = new String[] {"KundenNr"};
        primaryKeys     = new Object[1];
        propertyNames = new String[] {"Nachname", "Vorname", "Land", "PLZ",
                                      "Wohnort", "Strasse", "TelNr"};
        properties    = new Object[7];
    }

    /**
     * Setzt die Kundennummer f�r diese Entity fest.
     */
    public void setPrimaryKeys( Integer kundenNr ) {
        primaryKeys[0] = kundenNr;
    }

    /**
     * Setzt die Kundennummer f�r diese Entity auf einen fortlaufenden Wert.
     * Das wirkt sich nur f�rs Einf�gen einer neuen Entity in die Datenbank
     * aus, und der Schl�ssel bleibt bis zum Aufruf von toDatabase() ung�ltig,
     * oder bis er erneut gesetzt wurde.
     */
    public void setSerialKey()
    {
        primaryKeys[0] = null;
    }

    /**
     * Ermittelt die Kundennummer dieser Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public Integer getKundenNr()
    {
        return (Integer) primaryKeys[0];
    }

    /**
     * Setzt alle Eigenschaften dieser Entity auf einmal. Um einen Wert
     * auf NULL zu setzen, muss null als Argument �bergeben werden.
     */
    public void setProperties( String nachname, String vorname, String land,
                               Integer plz, String wohnort, String strasse,
                               String telnr )
    {
        // Die Werte sind so nummeriert wie oben in der Initialisierung
        // angegeben. Die Nummerierung ist unabh�ngig von der Reihenfolge
        // in der Datenbank.
        properties[0] = nachname;
        properties[1] = vorname;
        properties[2] = land;
        properties[4] = wohnort;
        properties[5] = strasse;
        properties[6] = telnr;

        if( plz == null )
            properties[3] = null;
        else
            properties[3] = plz;
    }

    /**
     * Ermittelt die Eigenschaft Nachname der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public String getNachname()
    {
        return (String) properties[0];
    }

    /**
     * Ermittelt die Eigenschaft Vorname der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public String getVorname()
    {
        return (String) properties[1];
    }

    /**
     * Ermittelt die Eigenschaft Land der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public String getLand()
    {
        return (String) properties[2];
    }

    /**
     * Ermittelt die Eigenschaft PLZ der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public Integer getPLZ()
    {
        return (Integer) properties[3];
    }

    /**
     * Ermittelt die Eigenschaft Wohnort der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public String getWohnort()
    {
        return (String) properties[4];
    }

    /**
     * Ermittelt die Eigenschaft Strasse der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public String getStrasse()
    {
        return (String) properties[5];
    }

    /**
     * Ermittelt die Eigenschaft TelNr der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zur�ckgegeben.
     */
    public String getTelNr()
    {
        return (String) properties[6];
    }
}
