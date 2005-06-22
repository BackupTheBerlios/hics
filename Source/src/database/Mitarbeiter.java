/*
 * Mitarbeiter.java
 *
 * Created on 8. Juni 2005, 08:49
 */

package database; // Diese Zeile auskommentieren

/**
 *
 * @author Studeny Iris
 * @version 1.0.1
 */
public class Mitarbeiter extends Entity {
    
    /** Creates a new instance of Mitarbeiter */
    public Mitarbeiter() {
        entityName = "Mitarbeiter";
        primaryKeyNames = new String[] {"MitarbeiterNr", "BerechtigungsNr"};
        propertyNames = new String[] {"Nachname", "Vorname", "Login", 
                "Passwort"};
        primaryKeys = new Object[primaryKeyNames.length];
        properties = new Object[propertyNames.length];
    }
    
    public void setPrimaryKeys( Integer mitarbeiterNr, Integer berechtigungsNr )
    {
        primaryKeys[0] = mitarbeiterNr;
        primaryKeys[1] = berechtigungsNr;
    }
    
    public void setSerialKey( Integer berechtigungsNr )
    {
        primaryKeys[0] = null;
        primaryKeys[1] = berechtigungsNr;
    }
    
    public Integer getMitarbeiterNr() {
        return (Integer) primaryKeys[0];
    }
    
    public Integer getBerechtigungsNr() {
        return (Integer) primaryKeys[1];
    }
    
    public String getNachname() {
        return (String) properties[0];
    }
    
    public String getVorname() {
        return (String) properties[1];
    }
    
    public String getLogin() {
        return (String) properties[2];
    }
    
    public String getPasswort() {
        return (String) properties[3];
    }
          
    public void setProperties( String nachname, String vorname, String login,
            String passwort )
    {
        
        properties[0] = nachname;
        properties[1] = vorname;
        properties[2] = login;
        properties[3] = passwort;
    }
    
}
