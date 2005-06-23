/*
 * Database.java
 *
 * @author: Andreas Schmidhuber
 */

package database;

import java.sql.*;
import java.util.Date;

public class Database {
    protected String url,user,passwd;
    protected Connection con;
    
    public Database(String url, String user, String passwd) {
        this.url = url;
        this.user = user;
        this.passwd = passwd;
        this.con = null;
    }
    
    /**
     * JDBC-Treiber wird geladen und die Verbindung zur Datenbank hergestellt.
     * 
     * @return  Wenn der Treiber geladen und die Verbindung hergestellt
     *          werden kann wird true zurückgegeben, ansonsten false.
     */
    public boolean connect()
    {
        try{
            Class.forName( "org.postgresql.Driver" );
            this.con = DriverManager.getConnection( url, user, passwd );
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
     * Verbindung zur Datenbank wird getrennt.
     * 
     * @return  Wenn die Verbindung getrennt werden kann wird true
     *          zurückgegeben, ansonsten false.
     */
    public boolean disconnect()
    {
        if( con == null )
            return false;
        
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
     * Macht eine SQL-SELECT-Abfrage in der Datenbank
     * und gibt das ResultSet zurück.
     * 
     * @return  Wenn die Abfrage korrekt ist und ein Ergebnis erhält, wird das
     *          ResultSet zurückgegeben, ansonsten null.
     */
    public ResultSet query(String SQLStatement)
    {
        if( con == null || SQLStatement.equals("") || SQLStatement == null)
            return null;
        
        try{
            Statement st = this.con.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_READ_ONLY
                           );
            ResultSet rs = st.executeQuery( SQLStatement );
            return rs;
        }
        catch(SQLException sqle){
            System.err.println("ERROR Query: " + sqle.toString());
            return null;
        }
    }
    
    /**
     * Macht eine Veränderung in der Datenbank mittels
     * INSERT, DELETE oder UPDATE Statement.
     *
     * @return  Wenn die Verbindung zur Datenbank hergestellt ist und
     *          das Update korrekt verarbeitet wurde, wird true zurückgegeben,
     *          ansonsten false.
     */
    public boolean change(String SQLStatement)
    {
        if( con == null || SQLStatement.equals(null) || SQLStatement == null)
            return false;
        
        try{
            Statement stmt = this.con.createStatement(
                                      ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE
                             );
            stmt.execute(SQLStatement);
        }
        catch(SQLException sqle){
            System.err.println("ERROR Change SQL: " + sqle.toString());
            return false;
        }
        return true;
    }
    
    /**
     * Convert a Java object to an SQL string.
     */
    public static String getSqlString( Object object )
    {
        if( object == null ) {
            return "NULL";
        }
        if( object instanceof String ) {
            return "'" + ((String) object).replaceAll("'", "''") + "'";
        }
        if( object instanceof Date ) {
            return "'" + ((Date) object).toString() + "'";
        }
        if( object instanceof Boolean ) {
            if( ((Boolean) object).booleanValue() == true )
                return "TRUE";
            else
                return "FALSE";
        }
        else {
            return object.toString();
        }
    }
}
