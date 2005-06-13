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
        primaryKeyNames = new String[] {"MitarbeiterNr"};
        propertyNames = new String[] {"Nachname", "Vorname", "Login", 
                "Passwort", "Berechtigung"};
        primaryKeys = new Object[primaryKeyNames.length];
        properties = new Object[propertyNames.length];
    }
    
    public void setPrimaryKeys( Integer mitarbeiterNr ) {
        primaryKeys[0] = mitarbeiterNr;
    }
    
    public void setSerialKey()
    {
        primaryKeys[0] = "DEFAULT";
    }
    
    public Integer getMitarbeiterNr() {
        return (Integer) primaryKeys[0];
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
    
    public Integer getBerechtigung() {
        return (Integer) properties[4];
    }
          
    public void setProperties( String nachname, String vorname, String login,
            String passwort, Integer berechtigung)
    {
        
        properties[0] = nachname;
        properties[1] = vorname;
        properties[2] = login;
        properties[3] = passwort;
        properties[4] = berechtigung;
    }
    
}
