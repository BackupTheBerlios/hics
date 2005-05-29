/*
 * Kunde.java
 *
 * Created on 25. Mai 2005, 23:04
 * @author Jakob Petsovits
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
    }

    /**
     * Setzt die Zimmernummer für diese Entity fest.
     */
    public void setPrimaryKeys( String zimmerNr ) {
        primaryKeys = new String[primaryKeyNames.length];
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
        primaryKeys = new String[primaryKeyNames.length];
        primaryKeys[0] = "DEFAULT";
    }

    /**
     * Ermittelt die Zimmernummer dieser Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public Integer getZimmerNR()
    {
        try {
            return Integer.valueOf(primaryKeys[0]);
        }
        catch( NumberFormatException e ) {
            return null;
        }
    }

    /**
     * Setzt alle Eigenschaften dieser Entity auf einmal. Um einen Wert
     * auf NULL zu setzen, muss null als Argument übergeben werden.
     */
    public void setProperties( Integer anzahlbetten, Double preispronacht )
    {
        // Die Werte sind so nummeriert wie oben in der Initialisierung
        // angegeben. Die Nummerierung ist unabhängig von der Reihenfolge
        // in der Datenbank.
        
        properties = new String[propertyNames.length];
        if( anzahlbetten == null ){properties[0] = null;}
        else{properties[0] = anzahlbetten.toString();}
        
        if( preispronacht == null ){properties[1] = null;}
        else{properties[1] = preispronacht.toString();}
        
    }


    /**
     * Ermittelt die Eigenschaft AnzahlBetten der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public Integer getAnzahlBetten()
    {
        if(properties == null){return null;}
        else{
            try {
                return Integer.valueOf(properties[0]);
            } catch( NumberFormatException e ) {
                return null;
            }
        }
    }

    /**
     * Ermittelt die Eigenschaft AnzahlBetten der Entity. Falls der entsprechende
     * Wert in der Datenbank NULL ist, wird null zurückgegeben.
     */
    public Double getPreisProNacht()
    {
        if(properties == null){return null;}
        else{
            try {
                return Double.valueOf(properties[1]);
            } catch( NumberFormatException e ) {
                return null;
            }
        }
    }
}
