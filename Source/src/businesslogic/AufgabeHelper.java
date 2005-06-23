/*
 * AufgabeHelper.java
 *
 * Created on 20. Juni 2005, 23:35
 */

package businesslogic;

import database.*;
import java.util.Date;
import java.sql.*;

/**
 *
 * @author Schmidhuber Andreas
 */

public class AufgabeHelper {
    
    private Database db;
    
    /** Creates a new instance of AufgabeHelper */
    public AufgabeHelper( Database database ) {
        db = database;
    }
    
     /**
     * Gibt eine Liste aller Kunden zurück, oder null, falls beim Suchen
     * ein Fehler aufgetreten ist.
     */
    public Aufgabe[] getAufgaben()
    {
        QueryAufgabe query = new QueryAufgabe( db );
        
        if( query.search() == false )
            return null;
        Aufgabe[] aufgaben = query.getAufgabenEntities();
        return aufgaben;
    }
    
    
    /**
     * Sucht nach einem oder auch mehreren parametern einer Augabe.
     * Rückgabewert ist bei positiver Suche das oder die gefundenen Aufgaben - 
     * Objekte. Bei einer negativen Suche wird null zurückgegeben. 
     **/
    public Aufgabe[] getAufgabe(Integer aufgabenNr, Integer zimmerNr ,
            Date ab, Date deadline, Boolean erledigt){
        
        boolean nu = false;
        
        QueryAufgabe query = new QueryAufgabe( db );
        if(aufgabenNr != null){
            query.addFilterAufgabenNr( aufgabenNr );
            nu = true;
        }
        if(zimmerNr != null){
            query.addFilterZimmerNr( zimmerNr );
            nu = true;
        }
        if(ab != null){
            query.addFilterAb( ab );
            nu = true;
        }
        if(deadline != null){
            query.addFilterDeadline( deadline );
            nu = true;
        }
        if(erledigt != null){
            query.addFilterErledigt( erledigt );
            nu = true;
        }
        if(nu != false){
            query.search();
            Aufgabe[] aufg = query.getAufgabenEntities();
            return aufg;
        }
        else{
            return null;
        }
    }
    /**
     * Legt eine neue Aufgabe in der DB an falls die AufgabenNr. noch 
     * nicht belegt ist.
     * Wenn die Aufgabe angelet werden konnte wird true und ansonsten false
     * zurückgegeben.
     **/
    public boolean setAufgabe(Integer aufgabenNr, Integer zimmerNr ,
            String bezeichnung, Date ab, Date deadline, Boolean erledigt, Database db){
        
        if(aufgabenNr == null || zimmerNr == null || bezeichnung == null ||
                ab == null || deadline == null || erledigt == null){
            return false;
        }
        
        Aufgabe newAuf = null;
        AufgabeHelper aufHelp = new AufgabeHelper(db);

        Aufgabe[] auf = aufHelp.getAufgabe(aufgabenNr, null, null,
                null, null);
        if(auf.length > 0){
            System.out.println("DEBUG: Aufgabe besteht bereits");
            return false;
        }
        String ins = "INSERT INTO aufgabe VALUES(" + aufgabenNr + ", " + 
                zimmerNr + ", '" + bezeichnung + "', '" + ab.toString() + "', '" + deadline.toString() + "', '" + 
                erledigt + "');";
            
        if(db.change(ins)){
            return true;
        }
        return false;   
    }
    /**
     * Löscht eine oder mehrere Aufgaben aus der DB.
     **/
    public void delAufgabe(Integer[] aufgabenNr){
        Aufgabe newAuf = null;
        AufgabeHelper aufHelp = new AufgabeHelper(db);
        Aufgabe [][] auf = new Aufgabe[aufgabenNr.length][];
        
        for(int i = 0 ; i < aufgabenNr.length ; i++){
            auf[i] = aufHelp.getAufgabe(aufgabenNr[i], null, null, null, null);
            
            db.change("DELETE FROM aufgabe WHERE aufgabennr = " + aufgabenNr[i] + ";");
        }
    }
    /**
     * Ändert einen Eintrag in der DB. Bei korrekter Änderung wird true und
     * ansonsten false zurückgegeben.
     **/
    public boolean changeAufgabe(Integer aufgabenNr, Integer zimmerNr ,
            String bezeichnung, Date ab, Date deadline, Boolean erledigt){
        
        if(aufgabenNr == null || zimmerNr == null || bezeichnung == null ||
                ab == null || deadline == null || erledigt == null){
            return false;
        }
        
        AufgabeHelper aufHelp = new AufgabeHelper(db);
        Aufgabe [] auf = aufHelp.getAufgabe(aufgabenNr, null, null, null, null);
        boolean ch = true;
        String [] up = new String[5];
        
        if(auf != null){
            up[0] = "UPDATE aufgabe SET zimmernr = " + zimmerNr + 
                        " WHERE aufgabennr = " + aufgabenNr + ";";
            
            up[1] = "UPDATE aufgabe SET bezeichnung = '" + bezeichnung +
                        "' WHERE aufgabennr = " + aufgabenNr + ";";
                
            up[2] = "UPDATE aufgabe SET ab = '" + ab.toString() +
                        "' WHERE aufgabennr = " + aufgabenNr + ";";
                
            up[3] = "UPDATE aufgabe SET deadline = '" + deadline.toString() +
                        "' WHERE aufgabennr = " + aufgabenNr + ";";
                
            up[4] = "UPDATE aufgabe SET erledigt = '" + erledigt +
                        "' WHERE aufgabennr = " + aufgabenNr + ";";
                
            for(int i = 0; i < up.length; i++){
                if(!db.change(up[i])){
                    ch = false;
                }
            }
            return ch;
        }
        return false;
    }
}
