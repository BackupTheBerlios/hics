/*
 * Berechtigung.java
 *
 * Created on 8. Juni 2005, 08:51
 */

package database; // Diese Zeile auskommentieren

/**
 *
 * @author Studeny Iris
 * @version 1.0.1
 */
public class Berechtigung extends Entity {
    
    /** Creates a new instance of Berechtigung */
    public Berechtigung() {
        entityName = "Berechtigung";
        primaryKeyNames = new String[] {"BerechtigungsNr"};
        propertyNames = new String[] {"Bezeichnung"};
        primaryKeys = new Object[primaryKeyNames.length];
        properties = new Object[propertyNames.length];
    }
    
    public void setPrimaryKeys(Integer berechtigungsNr) {
        primaryKeys[0] = berechtigungsNr;
    }
    
    public void setSerialKey()
    {
        primaryKeys[0] = "DEFAULT";
    }
    
    public Integer getBerechtigungsNr() {
        return (Integer) primaryKeys[0];
    }
    
    public String getBezeichnung() {
        return (String) properties[0];
    }
     
    public void setProperties(String bezeichnung )
    {
        properties[0] = bezeichnung;
              
    } 
        
}
