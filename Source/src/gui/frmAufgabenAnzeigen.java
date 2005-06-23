/*
 * frmInfo.java
 *
 * Created on 21. April 2005, 08:10
 */

package gui;

import database.*;
import businesslogic.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;


/**
 *
 * @author  Standard
 */
public class frmAufgabenAnzeigen extends javax.swing.JFrame {
    public static int WIDTH=700;
    public static int HEIGHT=700;
    public static String TITLE="HICS - Informationen";
    
    private String[] columns = {"ZimmerNr", "Aufgabe", "Deadline", "Status"};
    private static final int COL_NR    = 0;
    private static final int COL_AUFGABE = 1;
    private static final int COL_DEADLINE   = 2;
    private static final int COL_STATUS   = 3;
    
    private Integer[] aufgabenNummern;
    private AufgabeHelper helper;
    private int currentIndex;
    private boolean newEntry = true;
    
//    TableModel model = new AbstrachtTableModel(){
//        public String getColumnName(int col) {
//            return coumnNames[col].toString();
//        }
//        public int getRowCount() { return rowData.length;}
//        public int getColumnCOunt ()
//    }
    
    public Database db;
    
    /** Creates new form frmInfo */
    public frmAufgabenAnzeigen() {
        super(TITLE);
        initComponents();
        setSize(WIDTH, HEIGHT);
        setLocation(((getToolkit().getScreenSize().width)/2)-(WIDTH/2),((getToolkit().getScreenSize().height)/2)-(HEIGHT/2));
        
        setupListeners();
        
        helper = new AufgabeHelper(DatabaseManager.db);
        
        
        
        loadTableData();
        
        
    }
   
    
     private boolean dbDisconnect()
    {
        if( db != null )
            return db.disconnect();
        else
            return false;
    }
     
      private void setupListeners()
    {
        //Ask to be notified of selection changes.
        ListSelectionModel rowSM = tblInfo.getSelectionModel();
        rowSM.addListSelectionListener(
            new ListSelectionListener()
            {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm =
                        (ListSelectionModel)e.getSource();
//                    if (lsm.isSelectionEmpty()) {
//                        clearTextFields();
//                    } else {
//                        int selectedRow = lsm.getMinSelectionIndex();
//                        fillTextFields( selectedRow );
//                    }
                }
            }
        );
    }
    
     
  /**
     * Füllt mit Hilfe eines Helper-Objekts die Zimmertabelle mit allen Kunden.
     */
    public void loadTableData()
    {
        Aufgabe[] aufgabe = helper.getAufgaben();
        if( aufgabe == null )
            return;
        
        aufgabenNummern = new Integer[aufgabe.length];
        loadTableData( aufgabe );
    }

    /**
     * Füllt mit Hilfe eines Helper-Objekts die Zimmertabelle bestimmten Kunden.
     */
    public void loadTableData( Aufgabe[] aufgabe )
    {
        if( aufgabe == null )
            return;
        
               
        tblInfo.setModel( new javax.swing.table.DefaultTableModel(
                                new Object[0][columns.length], columns )
        );
        
               
        
        Object[][] contents = new Object[aufgabe.length][columns.length];
        
        // Zunächst wird die Tabelle mit Dummy-Einträgen gefüllt
        for( int i = 0; i < aufgabe.length; i++ ) {
            contents[i][COL_NR] = "";
            contents[i][COL_AUFGABE] = "";
            contents[i][COL_DEADLINE] = "";
            contents[i][COL_STATUS] = "";
        }
        tblInfo.setModel(
            new javax.swing.table.DefaultTableModel( contents, columns )
        );
        
        tblInfo.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblInfo.getColumnModel().getColumn(1).setPreferredWidth(300);
        tblInfo.getColumnModel().getColumn(2).setPreferredWidth(60);
        tblInfo.getColumnModel().getColumn(3).setPreferredWidth(60);
        

        // jetzt werden die eigentlichen Einträge eingefügt
        for( int i = 0; i < aufgabe.length; i++ ) {
            refreshAufgabe( i, aufgabe[i] );
        }
    }
    
    /**
     * Aktualisiert einen Tabelleneintrag mit den Daten eines Kunden-Objekts.
     */
    public void refreshAufgabe( int tableIndex, Aufgabe newValue )
    {
        aufgabenNummern[tableIndex] = newValue.getAufgabeNR();
        tblInfo.setValueAt(
            newValue.getZimmerNr(), tableIndex, COL_NR );
        tblInfo.setValueAt(
            newValue.getBezeichnung(), tableIndex, COL_AUFGABE );
        tblInfo.setValueAt(
            newValue.getDeadline(), tableIndex, COL_DEADLINE );
        tblInfo.setValueAt(
            newValue.getErledigt(), tableIndex, COL_STATUS );
    }
     
     
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        pnlInformation = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInfo = new javax.swing.JTable();
        pnlLogout = new javax.swing.JPanel();
        cmdLogout = new javax.swing.JButton();
        cmdBeenden = new javax.swing.JButton();
        pnlButtons = new javax.swing.JPanel();
        cmdAbbrechen = new javax.swing.JButton();
        cmdSpeichern = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        pnlInformation.setLayout(new java.awt.GridBagLayout());

        jScrollPane1.setMaximumSize(new java.awt.Dimension(630, 430));
        jScrollPane1.setMinimumSize(new java.awt.Dimension(630, 430));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(630, 430));
        tblInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ZimmerNr", "Aufgabe", "Deadline", "erledigt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInfo.setGridColor(new java.awt.Color(0, 0, 0));
        tblInfo.setMaximumSize(new java.awt.Dimension(600, 400));
        tblInfo.setMinimumSize(new java.awt.Dimension(600, 400));
        tblInfo.setPreferredSize(new java.awt.Dimension(600, 400));
        tblInfo.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tblInfo.setSurrendersFocusOnKeystroke(true);
        jScrollPane1.setViewportView(tblInfo);

        pnlInformation.add(jScrollPane1, new java.awt.GridBagConstraints());

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(pnlInformation, gridBagConstraints);

        pnlLogout.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 2, 1));

        pnlLogout.setMaximumSize(new java.awt.Dimension(300, 50));
        pnlLogout.setMinimumSize(new java.awt.Dimension(300, 50));
        pnlLogout.setOpaque(false);
        pnlLogout.setPreferredSize(new java.awt.Dimension(300, 50));
        cmdLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/logout.gif")));
        cmdLogout.setText("Ausloggen");
        cmdLogout.setToolTipText("Klicken Sie  auf  \"Ausloggen\" um wieder auf den Startbildschim zu gelangen!");
        cmdLogout.setMaximumSize(new java.awt.Dimension(125, 30));
        cmdLogout.setMinimumSize(new java.awt.Dimension(125, 30));
        cmdLogout.setPreferredSize(new java.awt.Dimension(125, 30));
        cmdLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogoutActionPerformed(evt);
            }
        });

        pnlLogout.add(cmdLogout);

        cmdBeenden.setMnemonic('B');
        cmdBeenden.setText("Beenden");
        cmdBeenden.setToolTipText("Schlie\u00dft das Programm.");
        cmdBeenden.setMaximumSize(new java.awt.Dimension(125, 30));
        cmdBeenden.setMinimumSize(new java.awt.Dimension(125, 30));
        cmdBeenden.setPreferredSize(new java.awt.Dimension(125, 30));
        cmdBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBeendenActionPerformed(evt);
            }
        });

        pnlLogout.add(cmdBeenden);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(pnlLogout, gridBagConstraints);

        pnlButtons.setMaximumSize(new java.awt.Dimension(400, 50));
        pnlButtons.setMinimumSize(new java.awt.Dimension(400, 50));
        pnlButtons.setPreferredSize(new java.awt.Dimension(400, 50));
        cmdAbbrechen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/abbrechen.gif")));
        cmdAbbrechen.setText("Abbrechen");
        cmdAbbrechen.setToolTipText("Klicken Sie  auf  \"Abbrechen\" um die \u00c4nderungen nicht zu speichern!");
        cmdAbbrechen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdAbbrechen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdAbbrechen.setPreferredSize(new java.awt.Dimension(125, 30));
        cmdAbbrechen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAbbrechenActionPerformed(evt);
            }
        });

        pnlButtons.add(cmdAbbrechen);

        cmdSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/speichern.gif")));
        cmdSpeichern.setText("Speichern");
        cmdSpeichern.setToolTipText("Klicken Sie hier um die ge\u00e4nderten Daten zu speichern!");
        cmdSpeichern.setMaximumSize(new java.awt.Dimension(95, 30));
        cmdSpeichern.setMinimumSize(new java.awt.Dimension(95, 30));
        cmdSpeichern.setOpaque(false);
        cmdSpeichern.setPreferredSize(new java.awt.Dimension(125, 30));
        cmdSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSpeichernActionPerformed(evt);
            }
        });

        pnlButtons.add(cmdSpeichern);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(pnlButtons, gridBagConstraints);

        pack();
    }//GEN-END:initComponents

    private void cmdBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBeendenActionPerformed
        dbDisconnect();
        System.exit(0);
    }//GEN-LAST:event_cmdBeendenActionPerformed

//    AufgabenHelper helper = new AufgabenHelper(db);
//    Aufgabe[] aufg = helper.getAufgaben(null, null, null, 
//                null,null);
//           
//        if( aufg == null || aufg.length == 0 ) {
//            helpMeldungen.showErrorMessage("Es wurden keine Aufgaben gefunden!");
//        }
//        else {
//              helpMeldungen.showErrorMessage("Es wurden Aufgaben gefunden!");
//        }
    
    private void cmdSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSpeichernActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdSpeichernActionPerformed

    private void cmdLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogoutActionPerformed
        // TODO add your handling code here:
        this.hide();
        new frmStart().setVisible(true);
    }//GEN-LAST:event_cmdLogoutActionPerformed

    private void cmdAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAbbrechenActionPerformed
        // TODO add your handling code here:
        return;
    }//GEN-LAST:event_cmdAbbrechenActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAufgabenAnzeigen().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAbbrechen;
    private javax.swing.JButton cmdBeenden;
    private javax.swing.JButton cmdLogout;
    private javax.swing.JButton cmdSpeichern;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlInformation;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JTable tblInfo;
    // End of variables declaration//GEN-END:variables
  
}
