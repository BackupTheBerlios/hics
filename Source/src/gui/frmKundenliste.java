/*
 * frmZimmerplan.java
 *
 * Created on 25. Mai 2005, 13:51
 */

package gui;

import database.*;
import businesslogic.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author  Jakob
 */
public class frmKundenliste extends javax.swing.JFrame
{
    public static String TITLE="Kundenliste";
    private String[] columns = {"Name", "Adresse", "Telefonnr.", "Notiz"};
    private static final int COL_NAME    = 0;
    private static final int COL_ADRESSE = 1;
    private static final int COL_TELNR   = 2;
    private static final int COL_NOTIZ   = 3;
    
    private Integer[] kundenNummern;
    private KundenHelper helper;
    private int currentIndex;
    private boolean newEntry = true;
    

    /** Creates new form frmStart */
    public frmKundenliste() {
        super(TITLE);
        initComponents();
        setupListeners();
        
        helper = new KundenHelper(DatabaseManager.db);
        loadTableData();
        
        setSize(getToolkit().getScreenSize());
        show();
    }
    
    private void setupListeners()
    {
        //Ask to be notified of selection changes.
        ListSelectionModel rowSM = tblKunden.getSelectionModel();
        rowSM.addListSelectionListener(
            new ListSelectionListener()
            {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm =
                        (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        clearTextFields();
                    } else {
                        int selectedRow = lsm.getMinSelectionIndex();
                        fillTextFields( selectedRow );
                    }
                }
            }
        );
    }
    
    /**
     * Füllt mit Hilfe eines Helper-Objekts die Zimmertabelle mit allen Kunden.
     */
    public void loadTableData()
    {
        Kunde[] kunden = helper.getKunden();
        if( kunden == null )
            return;
        
        kundenNummern = new Integer[kunden.length];
        loadTableData( kunden );
    }

    /**
     * Füllt mit Hilfe eines Helper-Objekts die Zimmertabelle bestimmten Kunden.
     */
    public void loadTableData( Kunde[] kunden )
    {
        if( kunden == null )
            return;
        
        tblKunden.setModel( new javax.swing.table.DefaultTableModel(
                                new Object[0][columns.length], columns )
        );
        
        Object[][] contents = new Object[kunden.length][columns.length];
        
        // Zunächst wird die Tabelle mit Dummy-Einträgen gefüllt
        for( int i = 0; i < kunden.length; i++ ) {
            for( int k = 0; k < columns.length; k++ ) {
                contents[i][k] = "";
            }
        }
        tblKunden.setModel(
            new javax.swing.table.DefaultTableModel( contents, columns )
        );
        
        // jetzt werden die eigentlichen Einträge eingefügt
        for( int i = 0; i < kunden.length; i++ ) {
            refreshKunde( i, kunden[i] );
        }
    }
    
    /**
     * Aktualisiert einen Tabelleneintrag mit den Daten eines Kunden-Objekts.
     */
    public void refreshKunde( int tableIndex, Kunde newValue )
    {
        kundenNummern[tableIndex] = newValue.getKundenNr();
        tblKunden.setValueAt(
            newValue.getVorname() + " " + newValue.getNachname(),
            tableIndex, COL_NAME );
        tblKunden.setValueAt(
            newValue.getLand() + "-" + newValue.getPLZ().toString() + " "
            + newValue.getWohnort() + ", " + newValue.getStrasse(),
            tableIndex, COL_ADRESSE );
        tblKunden.setValueAt(
            newValue.getTelNr(), tableIndex, COL_TELNR );
        tblKunden.setValueAt(
            newValue.getNotiz(), tableIndex, COL_NOTIZ );
    }
    
    /**
     * Löscht den Text aller Kundendaten-Textfelder.
     */
    private void clearTextFields()
    {
        txtVorname.setText("");
        txtNachname.setText("");
        txtPlz.setText("");
        txtOrt.setText("");
        txtStrasse.setText("");
        txtLand.setText("");
        txtTelNr.setText("");
        txtNotiz.setText("");
        
    }
    
    /**
     * Füllt die Kundendaten-Textfelder mit Werten aus der Datenbank.
     */
    private void fillTextFields( int tableIndex )
    {
        currentIndex = tableIndex;
        newEntry = false;
        Kunde kunde = new Kunde();
        kunde.assignDatabase( DatabaseManager.db );
        kunde.setPrimaryKeys( kundenNummern[currentIndex] );
        if( kunde.fromDatabase() == false )
            helpMeldungen.showErrorMessage("Konnte die Daten nicht auslesen!");
        
        txtVorname.setText( kunde.getVorname() );
        txtNachname.setText( kunde.getNachname() );
        txtPlz.setText( kunde.getPLZ().toString() );
        txtOrt.setText( kunde.getWohnort() );
        txtStrasse.setText( kunde.getStrasse() );
        txtLand.setText( kunde.getLand() );
        txtTelNr.setText( kunde.getTelNr() );
        txtNotiz.setText( kunde.getNotiz() );
    }
    
    /**
     * Schreibt die Kundendaten-Textfelder wieder in die Datenbank zurück.
     */
    private void saveTextFields()
    {
        if( txtNachname.getText().equals("") || txtVorname.getText().equals("") )
        {
            helpMeldungen.showErrorMessage("Zum Speichern in die Datenbank " +
                "muessen sowohl Vor- als auch Nachname eingegeben werden!");
            return;
        }
        
        Integer plz;
        if( txtPlz.getText().equals("") ) {
            plz = null;
        }
        else {
            try {
                plz = Integer.valueOf( txtPlz.getText() );
            } catch( NumberFormatException e ) {
                helpMeldungen.showErrorMessage("Bitte geben Sie eine Zahl " +
                        "in das Textfeld 'PLZ' ein!");
                return;
            }
        }
        
        Kunde kunde = new Kunde();
        kunde.assignDatabase( DatabaseManager.db );
        
        if( newEntry == false )
            kunde.setPrimaryKeys( kundenNummern[currentIndex] );
        else
            kunde.setSerialKey();
        
        kunde.setProperties(
            txtNachname.getText(), txtVorname.getText(), txtLand.getText(),
            plz, txtOrt.getText(), txtStrasse.getText(),
            txtTelNr.getText(), txtNotiz.getText()
        );
        
        if( kunde.toDatabase() == false ) {
            helpMeldungen.showErrorMessage("Die Kundendaten konnten wegen " +
                "eines Fehlers nicht in die Datenbank geschrieben werden.");
            return;
        }
        else {
            if( newEntry == false ) {
                refreshKunde( currentIndex, kunde );
            }
            else {
                loadTableData();
            }
        }
    }
    
    /**
     * Löscht den derzeit ausgewählten Kunden.
     */
    private void deleteCurrentEntry()
    {
        if( newEntry == true )
        {
            helpMeldungen.showErrorMessage("Da gerade kein Kunde ausgewaehlt " +
                "ist, wird auch keiner gelöscht.");
            return;
        }
        
        Kunde kunde = new Kunde();
        kunde.assignDatabase( DatabaseManager.db );
        kunde.setPrimaryKeys( kundenNummern[currentIndex] );
        
        if( kunde.deleteFromDatabase() == false ) {
            helpMeldungen.showErrorMessage("Die Kundendaten konnten wegen " +
                "eines Fehlers nicht geloescht werden.");
        }
        loadTableData();
    }
    
    /**
     * Filtert die Kundenliste anhand des Texts im Such-Textfeld.
     */
    public void search()
    {
        if( txtSuchen.getText().length() < 3 ) {
            helpMeldungen.showInformationMessage("Der Suchbegriff muss " +
                "mindestens drei Zeichen lang sein.");
            return;
        }
        Kunde[] kunden = helper.searchByName( txtSuchen.getText() );
        if( kunden == null ) {
            helpMeldungen.showInformationMessage(
                "Beim Suchen ist ein Fehler aufgetreten. Ätsch.");
            return;
        }
        
        loadTableData( kunden );
        
        if( kunden.length == 0 ) {
            helpMeldungen.showInformationMessage(
                "Mit diesem Suchbegriff wurden keine Kunden gefunden.");
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        pnlCaption = new javax.swing.JPanel();
        lblCaption = new javax.swing.JLabel();
        pnlAnzeige = new javax.swing.JPanel();
        pnlAnzeigeOben = new javax.swing.JPanel();
        pnlSuchen = new javax.swing.JPanel();
        txtSuchen = new javax.swing.JTextField();
        lblSuchen = new javax.swing.JLabel();
        pnlSuchaktionen = new javax.swing.JPanel();
        btnSuchenReset = new javax.swing.JButton();
        btnSuchen = new javax.swing.JButton();
        pnlAnzeigeKunde = new javax.swing.JPanel();
        lblNachname = new javax.swing.JLabel();
        txtNachname = new javax.swing.JTextField();
        lblVorname = new javax.swing.JLabel();
        txtVorname = new javax.swing.JTextField();
        lblLand = new javax.swing.JLabel();
        txtLand = new javax.swing.JTextField();
        lblPlz = new javax.swing.JLabel();
        txtPlz = new javax.swing.JTextField();
        lblOrt = new javax.swing.JLabel();
        txtOrt = new javax.swing.JTextField();
        lblStrasse = new javax.swing.JLabel();
        txtStrasse = new javax.swing.JTextField();
        lblTelNr = new javax.swing.JLabel();
        txtTelNr = new javax.swing.JTextField();
        lblNotiz = new javax.swing.JLabel();
        txtNotiz = new javax.swing.JTextField();
        pnlOk = new javax.swing.JPanel();
        btnNeuerKunde = new javax.swing.JButton();
        btnSpeichern = new javax.swing.JButton();
        pnlLöschen = new javax.swing.JPanel();
        cmdLoeschen = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        tblKunden = new javax.swing.JTable();
        pnlLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getAccessibleContext().setAccessibleName("Kundenliste");
        pnlCaption.setLayout(new java.awt.BorderLayout());

        lblCaption.setFont(new java.awt.Font("Arial", 1, 18));
        lblCaption.setText("Kunden");
        pnlCaption.add(lblCaption, java.awt.BorderLayout.CENTER);
        lblCaption.getAccessibleContext().setAccessibleName("");

        getContentPane().add(pnlCaption, java.awt.BorderLayout.NORTH);

        pnlAnzeige.setLayout(new java.awt.BorderLayout());

        pnlAnzeigeOben.setLayout(new javax.swing.BoxLayout(pnlAnzeigeOben, javax.swing.BoxLayout.Y_AXIS));

        pnlSuchen.setLayout(new java.awt.BorderLayout());

        pnlSuchen.setBorder(new javax.swing.border.TitledBorder("Suchen"));
        pnlSuchen.add(txtSuchen, java.awt.BorderLayout.CENTER);

        lblSuchen.setText("Suchen nach: ");
        lblSuchen.setRequestFocusEnabled(false);
        pnlSuchen.add(lblSuchen, java.awt.BorderLayout.WEST);

        btnSuchenReset.setText("Suche zur\u00fccksetzen");
        btnSuchenReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuchenResetActionPerformed(evt);
            }
        });

        pnlSuchaktionen.add(btnSuchenReset);

        btnSuchen.setText("Suche starten");
        btnSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuchenActionPerformed(evt);
            }
        });

        pnlSuchaktionen.add(btnSuchen);

        pnlSuchen.add(pnlSuchaktionen, java.awt.BorderLayout.SOUTH);

        pnlAnzeigeOben.add(pnlSuchen);

        pnlAnzeigeKunde.setLayout(new java.awt.GridLayout(8, 2));

        pnlAnzeigeKunde.setBorder(new javax.swing.border.TitledBorder("Kundendaten"));
        lblNachname.setText("Nachname");
        lblNachname.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblNachname);

        txtNachname.setToolTipText("Geben Sie hier den Nachnamen/Familiennamen des Kunden ein!");
        txtNachname.setMinimumSize(new java.awt.Dimension(600, 1));
        pnlAnzeigeKunde.add(txtNachname);

        lblVorname.setText("Vorname");
        lblVorname.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblVorname);

        pnlAnzeigeKunde.add(txtVorname);

        lblLand.setText("Land");
        lblLand.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblLand);

        txtLand.setToolTipText("Geben Sie hier das Land ein!");
        pnlAnzeigeKunde.add(txtLand);

        lblPlz.setText("Plz");
        lblPlz.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblPlz);

        txtPlz.setToolTipText("Geben Sie hier die Postleitzahl ein!");
        pnlAnzeigeKunde.add(txtPlz);

        lblOrt.setText("Wohnort");
        lblOrt.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblOrt);

        txtOrt.setToolTipText("Geben Sie hier die Postleitzahl ein!");
        pnlAnzeigeKunde.add(txtOrt);

        lblStrasse.setText("Stra\u00dfe");
        lblStrasse.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblStrasse);

        txtStrasse.setToolTipText("Geben Sie hier die Strasse, in der der Kunde wohnt, ein!");
        pnlAnzeigeKunde.add(txtStrasse);

        lblTelNr.setText("Telefonnr.");
        lblTelNr.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblTelNr);

        txtTelNr.setToolTipText("");
        pnlAnzeigeKunde.add(txtTelNr);

        lblNotiz.setText("Notiz");
        lblNotiz.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblNotiz);

        pnlAnzeigeKunde.add(txtNotiz);

        pnlAnzeigeOben.add(pnlAnzeigeKunde);

        btnNeuerKunde.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/neu.gif")));
        btnNeuerKunde.setText("Neuer Kunde");
        btnNeuerKunde.setToolTipText("Bet\u00e4tigen Sie diesen Button um ein neues Objekt zu erstellen!");
        btnNeuerKunde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNeuerKundeActionPerformed(evt);
            }
        });

        pnlOk.add(btnNeuerKunde);

        btnSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/ok.gif")));
        btnSpeichern.setText("Werte \u00fcbernehmen");
        btnSpeichern.setToolTipText("Bet\u00e4tigen Sie diesen Button um zu best\u00e4tigen!");
        btnSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpeichernActionPerformed(evt);
            }
        });

        pnlOk.add(btnSpeichern);

        pnlAnzeigeOben.add(pnlOk);

        pnlAnzeige.add(pnlAnzeigeOben, java.awt.BorderLayout.NORTH);

        pnlLöschen.setLayout(new java.awt.BorderLayout());

        cmdLoeschen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/abbrechen.gif")));
        cmdLoeschen.setText("Ausgew\u00e4hlten Kunden l\u00f6schen");
        cmdLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoeschenActionPerformed(evt);
            }
        });

        pnlLöschen.add(cmdLoeschen, java.awt.BorderLayout.EAST);

        pnlAnzeige.add(pnlLöschen, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlAnzeige, java.awt.BorderLayout.WEST);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        tblKunden.setBorder(new javax.swing.border.EtchedBorder());
        tblKunden.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Zimmer", "Betten", "Preis", "Notiz", "Title 5"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKunden.setGridColor(new java.awt.Color(255, 255, 255));
        pnlCenter.add(tblKunden, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlCenter, java.awt.BorderLayout.CENTER);

        pnlLogout.setBorder(new javax.swing.border.EtchedBorder());
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/logout.gif")));
        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        pnlLogout.add(btnLogout);

        getContentPane().add(pnlLogout, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void btnSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuchenActionPerformed
        search();
    }//GEN-LAST:event_btnSuchenActionPerformed

    private void btnSuchenResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuchenResetActionPerformed
        txtSuchen.setText("");
        loadTableData();
    }//GEN-LAST:event_btnSuchenResetActionPerformed

    private void cmdLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoeschenActionPerformed
        deleteCurrentEntry();
    }//GEN-LAST:event_cmdLoeschenActionPerformed

    private void btnSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpeichernActionPerformed
        this.saveTextFields( );
    }//GEN-LAST:event_btnSpeichernActionPerformed

    private void btnNeuerKundeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNeuerKundeActionPerformed
        clearTextFields();
        newEntry = true;
        currentIndex = -1; // eigentlich wurscht, aber sicherheitshalber
        txtNachname.requestFocus();
    }//GEN-LAST:event_btnNeuerKundeActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.dispose();
        new frmStart().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmKundenliste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNeuerKunde;
    private javax.swing.JButton btnSpeichern;
    private javax.swing.JButton btnSuchen;
    private javax.swing.JButton btnSuchenReset;
    private javax.swing.JButton cmdLoeschen;
    private javax.swing.JLabel lblCaption;
    private javax.swing.JLabel lblLand;
    private javax.swing.JLabel lblNachname;
    private javax.swing.JLabel lblNotiz;
    private javax.swing.JLabel lblOrt;
    private javax.swing.JLabel lblPlz;
    private javax.swing.JLabel lblStrasse;
    private javax.swing.JLabel lblSuchen;
    private javax.swing.JLabel lblTelNr;
    private javax.swing.JLabel lblVorname;
    private javax.swing.JPanel pnlAnzeige;
    private javax.swing.JPanel pnlAnzeigeKunde;
    private javax.swing.JPanel pnlAnzeigeOben;
    private javax.swing.JPanel pnlCaption;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlLöschen;
    private javax.swing.JPanel pnlOk;
    private javax.swing.JPanel pnlSuchaktionen;
    private javax.swing.JPanel pnlSuchen;
    private javax.swing.JTable tblKunden;
    private javax.swing.JTextField txtLand;
    private javax.swing.JTextField txtNachname;
    private javax.swing.JTextField txtNotiz;
    private javax.swing.JTextField txtOrt;
    private javax.swing.JTextField txtPlz;
    private javax.swing.JTextField txtStrasse;
    private javax.swing.JTextField txtSuchen;
    private javax.swing.JTextField txtTelNr;
    private javax.swing.JTextField txtVorname;
    // End of variables declaration//GEN-END:variables

}
