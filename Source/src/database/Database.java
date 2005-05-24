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
    
    /***************************************************************************
     * driver wird geladen und die verbindung zur db erstellt.
     * wenn der driver geladen und die verbindung hergestellt
     * werden kann wird true zurückgegeben, ansonsten false.
     ***************************************************************************/
    boolean Connect(){
        try{
            Class.forName( "org.postgresql.Driver" );
            this.con = DriverManager.getConnection(this.url,this.user,this.passwd);
            return true;
        }
        catch (ClassNotFoundException cnfe){
            System.err.println("ERROR load driver: " + cnfe.toString());
            return false;
        }
        catch (SQLException sqle){
            System.err.println("ERROR Connect: " + sqle.toString());
            return false;
        }
    }
    
    /***************************************************************************
     * verbindung zur db wird getrennt.
     * wenn die verbindung getrennt werden kann wird true zurückgegeben,
     * ansonsten false.
     ***************************************************************************/
    boolean Disconnect(){
        try{
            this.con.close();
            return true;
        }
        catch (SQLException sqle){
            System.err.println("ERROR Disconnect: " + sqle.toString());
            return false;
        }
    }
    
    /***************************************************************************
     * macht eine abfrage in der datenbank und gibt das resultset zurück.
     * wenn die abfrage korrekt ist und ein ergebnis erhält, wird das
     * resultset zurückgegeben, ansonsten null.
     ***************************************************************************/
    ResultSet Query(String SQLStatement){
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
    
    /***************************************************************************
     * macht eine veränderung in der datenbank (insert,delete,update).
     * wenn das update korrekt ist wird true zurückgegeben, ansonsten false.
     ***************************************************************************/
    boolean Change(String SQLStatement){
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
