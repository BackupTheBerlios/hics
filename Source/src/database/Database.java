/*
 * Database.java
 *
 * @author: Andreas Schmidhuber
 */

package database;

import java.sql.*;

class Database {
    protected String url,user,passwd;
    protected Connection con;
    
    Database(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
        this.con = null;
    }
    
    /**
     * JDBC-Treiber wird geladen und die verbindung zur Datenbank erstellt.
     * 
     * @return  Wenn der Treiber geladen und die Verbindung hergestellt
     *          werden kann wird true zurückgegeben, ansonsten false.
     */
    boolean connect(){
        try{
            Class.forName( "org.postgresql.Driver" );
            this.con = DriverManager.getConnection(this.url,this.user,this.passwd);
            return true;
        }
        catch (ClassNotFoundException cnfe){
            System.err.println("ERROR loading driver: " + cnfe.toString());
            return false;
        }
        catch (SQLException sqle){
            System.err.println("ERROR when connecting: " + sqle.toString());
            return false;
        }
    }
    
    /**
     * Verbindung zur db wird getrennt.
     * 
     * @return  Wenn die Verbindung getrennt werden kann wird true
     *          zurückgegeben, ansonsten false.
     */
    boolean disconnect(){
        try{
            this.con.close();
            return true;
        }
        catch (SQLException sqle){
            System.err.println("ERROR when disconnecting: " + sqle.toString());
            return false;
        }
    }
    
    /**
     * Macht eine abfrage in der Datenbank und gibt das ResultSet zurück.
     * 
     * @return  Wenn die Abfrage korrekt ist und ein Ergebnis erhält, wird das
     *          ResultSet zurückgegeben, ansonsten null.
     */
    ResultSet query(String SQLStatement){
        try{
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery( SQLStatement );
            return rs;
        }
        catch(SQLException sqle){
            System.err.println("ERROR Query: " + sqle.toString());
            return null;
        }
    }
    
    /**
     * Macht eine veränderung in der Datenbank (insert, delete, update).
     *
     * @return  Wenn das update korrekt ist wird true zurückgegeben,
     *          ansonsten false.
     */
    boolean change(String SQLStatement){
        try{
            Statement stmt = this.con.createStatement();
            stmt.execute(SQLStatement);
        }
        catch(SQLException sqle){
            System.err.println("ERROR Change SQL: " + sqle.toString());
            return false;
        }
        return true;
    }
}
