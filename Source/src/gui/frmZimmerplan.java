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
public class frmZimmerplan extends javax.swing.JFrame
{
    public static String TITLE="Zimmerplan";
    private String[] columns = {"Zimmer", "Anzahl Betten", "Preis/Nacht", "belegt von"};
    private static final int COL_ZIMMER  = 0;
    private static final int COL_BETTEN  = 1;
    private static final int COL_PREIS   = 2;
    private static final int COL_KUNDE   = 3;
    
    private String[] aufgabenColumns = {"Aufgabe", "ab", "Deadline", "erledigt"};
    private static final int AGCOL_AUFGABE  = 0;
    private static final int AGCOL_AB       = 1;
    private static final int AGCOL_DEADLINE = 2;
    private static final int AGCOL_ERLEDIGT = 3;
    
    private String[] ausstattungColumns = {"Ausstattung"};
    private static final int ASCOL_AUSSTATTUNG = 0;
    
    private Integer[] zimmerNummern;
    private Integer[] aufgabenNummern;
    private Integer[] ausstattungsNummern;
    private ZimmerHelper helper;
    private int currentIndex;
    private int currentAufgabenIndex;
    private int currentAusstattungsIndex;
    private boolean newEntry = true;
    

    /** Creates new form frmStart */
    public frmZimmerplan() {
        super(TITLE);
        initComponents();
        setupListeners();
        
        helper = new ZimmerHelper(DatabaseManager.db);
        loadTableData();
        
        setSize(getToolkit().getScreenSize());
        show();
    }
    
    private void setupListeners()
    {
        // Verändern der Zimmerauswahl
        ListSelectionModel rowSM = tblZimmer.getSelectionModel();
        rowSM.addListSelectionListener(
            new ListSelectionListener()
            {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm =
                        (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        clearZimmerWidgets();
                    } else {
                        int selectedRow = lsm.getMinSelectionIndex();
                        fillWidgets( selectedRow );
                    }
                }
            }
        );
        // Verändern der Aufgabenauswahl
        rowSM = tblAufgaben.getSelectionModel();
        rowSM.addListSelectionListener(
            new ListSelectionListener()
            {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm =
                        (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        clearAufgabenWidgets();
                    } else {
                        int selectedRow = lsm.getMinSelectionIndex();
                        fillAufgabenWidgets( selectedRow );
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
        Zimmer[] zimmern = helper.getZimmern();
        if( zimmern == null )
            return;
        
        zimmerNummern = new Integer[zimmern.length];
        loadTableData( zimmern );
    }

    /**
     * Füllt mit Hilfe eines Helper-Objekts die Zimmertabelle mit den
     * als Parameter angegebenen Zimmern.
     */
    public void loadTableData( Zimmer[] zimmern )
    {
        if( zimmern == null )
            return;
        
        tblZimmer.setModel( new javax.swing.table.DefaultTableModel(
                                new Object[0][columns.length], columns )
        );
        
        Object[][] contents = new Object[zimmern.length][columns.length];
        
        // Zunächst wird die Tabelle mit Dummy-Einträgen gefüllt
        for( int i = 0; i < zimmern.length; i++ ) {
            for( int k = 0; k < columns.length; k++ ) {
                contents[i][k] = "";
            }
        }
        tblZimmer.setModel(
            new javax.swing.table.DefaultTableModel( contents, columns )
        );
        
        // jetzt werden die eigentlichen Einträge eingefügt
        for( int i = 0; i < zimmern.length; i++ ) {
            refreshZimmer( i, zimmern[i], helper.getKundeInZimmer(zimmern[i]) );
        }
    }
    
    /**
     * Füllt mit Hilfe eines Helper-Objekts die Aufgabentabelle mit
     * den Aufgaben des aktuell ausgewählten Zimmers.
     */
    public void loadAufgabenTableData( Zimmer zimmer )
    {
        Aufgabe[] aufgaben = helper.getZimmerAufgaben( zimmer );
        if( aufgaben == null )
            return;
        
        tblAufgaben.setModel( new javax.swing.table.DefaultTableModel(
                                  new Object[0][aufgabenColumns.length],
                                  aufgabenColumns )
        );
        
        Object[][] contents = new Object[aufgaben.length][aufgabenColumns.length];
        aufgabenNummern = new Integer[aufgaben.length];
        
        // Zunächst wird die Tabelle mit Dummy-Einträgen gefüllt
        for( int i = 0; i < aufgaben.length; i++ ) {
            for( int k = 0; k < aufgabenColumns.length; k++ ) {
                contents[i][k] = "";
            }
        }
        tblAufgaben.setModel(
            new javax.swing.table.DefaultTableModel( contents, aufgabenColumns )
        );
        
        // jetzt werden die eigentlichen Einträge eingefügt
        for( int i = 0; i < aufgaben.length; i++ ) {
            refreshAufgabe( i, aufgaben[i] );
        }
    }
    
    /**
     * Füllt mit Hilfe eines Helper-Objekts die Ausstattungstabelle mit
     * den Ausstattungen des aktuell ausgewählten Zimmers.
     */
    public void loadAusstattungsTableData( Zimmer zimmer )
    {
        Ausstattung[] ausstattungen = helper.getZimmerAusstattungen( zimmer );
        if( ausstattungen == null )
            return;
        
        tblAusstattung.setModel( new javax.swing.table.DefaultTableModel(
                                  new Object[0][ausstattungColumns.length],
                                  ausstattungColumns )
        );
        
        Object[][] contents = new Object[ausstattungen.length][ausstattungColumns.length];
        ausstattungsNummern = new Integer[ausstattungen.length];
        
        // Zunächst wird die Tabelle mit Dummy-Einträgen gefüllt
        for( int i = 0; i < ausstattungen.length; i++ ) {
            for( int k = 0; k < ausstattungColumns.length; k++ ) {
                contents[i][k] = "";
            }
        }
        tblAusstattung.setModel(
            new javax.swing.table.DefaultTableModel( contents, ausstattungColumns )
        );
        
        // jetzt werden die eigentlichen Einträge eingefügt
        for( int i = 0; i < ausstattungen.length; i++ ) {
            refreshAusstattung( i, ausstattungen[i] );
        }
    }
    
    /**
     * Aktualisiert einen Tabelleneintrag mit den Daten eines Zimmer-Objekts.
     */
    public void refreshZimmer( int tableIndex, Zimmer newValue, Kunde belegtVon )
    {
        zimmerNummern[tableIndex] = newValue.getZimmerNr();
        tblZimmer.setValueAt(
            zimmerNummern[tableIndex].toString(), tableIndex, COL_ZIMMER );
        tblZimmer.setValueAt(
            newValue.getAnzahlBetten().toString() + " Betten",
            tableIndex, COL_BETTEN );
        tblZimmer.setValueAt(
            newValue.getPreisProNacht().toString() + " Euro",
            tableIndex, COL_PREIS );
        if( belegtVon == null ) {
            tblZimmer.setValueAt(
                "(nicht belegt)", tableIndex, COL_KUNDE );
        }
        else {
            tblZimmer.setValueAt(
                belegtVon.getVorname() + " " + belegtVon.getNachname(),
                tableIndex, COL_KUNDE );
        }
    }
    
    /**
     * Aktualisiert einen Aufgaben-Tabelleneintrag mit den Daten
     * eines Aufgaben-Objekts.
     */
    public void refreshAufgabe( int tableIndex, Aufgabe newValue )
    {
        aufgabenNummern[tableIndex] = newValue.getAufgabenNr();
        tblAufgaben.setValueAt(
            newValue.getBezeichnung(), tableIndex, AGCOL_AUFGABE );
        tblAufgaben.setValueAt(
            "ab " + newValue.getAb().toString(),
            tableIndex, AGCOL_AB );
        tblAufgaben.setValueAt(
            "Deadline: " + newValue.getDeadline().toString(),
            tableIndex, AGCOL_DEADLINE );
        
        if( newValue.getErledigt() == null
            || newValue.getErledigt().booleanValue() == false )
        {
            tblAufgaben.setValueAt( "nicht erledigt", tableIndex, AGCOL_ERLEDIGT );
        }
        else {
            tblAufgaben.setValueAt( "erledigt", tableIndex, AGCOL_ERLEDIGT );
        }
    }
    
    /**
     * Aktualisiert einen Ausstattungs-Tabelleneintrag mit den Daten
     * eines Ausstattungs-Objekts.
     */
    public void refreshAusstattung( int tableIndex, Ausstattung newValue )
    {
        ausstattungsNummern[tableIndex] = newValue.getAusstattungsNr();
        tblAusstattung.setValueAt(
            newValue.getBezeichnung(), tableIndex, ASCOL_AUSSTATTUNG );
    }
    
    /**
     * Löscht den Text aller Zimmerdaten-Textfelder.
     */
    private void clearZimmerWidgets()
    {
        txtZimmerNr.setText("");
        txtAnzahlBetten.setText("");
        txtPreis.setText("");
        
        clearAufgabenWidgets();
        clearAusstattungsWidgets();
        clearKundenTextFields();
    }
    
    private void clearAufgabenWidgets()
    {
        // Zimmeraufgaben nicht mehr anzeigen
        tblAufgaben.setModel( new javax.swing.table.DefaultTableModel(
                                  new Object[0][aufgabenColumns.length],
                                  aufgabenColumns )
        );
        aufgabenNummern = null;
        txtBezeichnung.setText("");
        txtAb.setText("");
        txtDeadline.setText("");
        chkErledigt.setSelected( false );
    }
    
    private void clearAusstattungsWidgets()
    {
        // Ausstattung nicht mehr anzeigen
        tblAusstattung.setModel( new javax.swing.table.DefaultTableModel(
                                     new Object[0][ausstattungColumns.length],
                                     ausstattungColumns )
        );
        ausstattungsNummern = null;
        txtAb.setText("");
    }
    
    /**
     * Löscht den Text aller Kundendaten-Textfelder.
     */
    private void clearKundenTextFields()
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
     * Füllt die Zimmer- und Kundendaten-Steuerelemente mit Werten aus der Datenbank.
     */
    private void fillWidgets( int tableIndex )
    {
        currentIndex = tableIndex;
        newEntry = false;
        
        Zimmer zimmer = new Zimmer();
        zimmer.assignDatabase( DatabaseManager.db );
        zimmer.setPrimaryKeys( zimmerNummern[currentIndex] );
        if( zimmer.fromDatabase() == false ) {
            helpMeldungen.showErrorMessage(
                "Konnte die Zimmerdaten nicht auslesen!");
        }
        txtZimmerNr.setText( zimmer.getZimmerNr().toString() );
        txtAnzahlBetten.setText( zimmer.getAnzahlBetten().toString() );
        txtPreis.setText( zimmer.getPreisProNacht().toString() );
        
        Kunde kunde = helper.getKundeInZimmer( zimmer );
        if( kunde == null ) {
            clearKundenTextFields();
        }
        else {
            txtVorname.setText( kunde.getVorname() );
            txtNachname.setText( kunde.getNachname() );
            txtPlz.setText( kunde.getPLZ().toString() );
            txtOrt.setText( kunde.getWohnort() );
            txtStrasse.setText( kunde.getStrasse() );
            txtLand.setText( kunde.getLand() );
            txtTelNr.setText( kunde.getTelNr() );
            txtNotiz.setText( kunde.getNotiz() );
        }
        
        loadAufgabenTableData( zimmer );
        loadAusstattungsTableData( zimmer );
    }
    
    /**
     * Füllt die Aufgaben-Steuerelemente mit Daten.
     */
    public void fillAufgabenWidgets( int selectedRow )
    {
        currentAufgabenIndex = selectedRow;
        if( aufgabenNummern == null )
            return;
        
        Aufgabe aufgabe = new Aufgabe();
        aufgabe.assignDatabase( DatabaseManager.db );
        aufgabe.setPrimaryKeys( aufgabenNummern[currentAufgabenIndex] );
        if( aufgabe.fromDatabase() == false ) {
            helpMeldungen.showErrorMessage(
                "Konnte die Aufgabendaten nicht auslesen!");
        }
        txtBezeichnung.setText( aufgabe.getBezeichnung() );
        chkErledigt.setSelected( aufgabe.getErledigt().booleanValue() );
        txtAb.setText( aufgabe.getAb().toString() );
        txtDeadline.setText( aufgabe.getDeadline().toString() );
    }
    
    /**
     * Schreibt die Zimmerdaten-Textfelder wieder in die Datenbank zurück.
     */
    private void saveTextFields()
    {
        Integer zimmerNummer;
        try {
            zimmerNummer = Integer.valueOf( txtZimmerNr.getText() );
        } catch( NumberFormatException e ) {
            helpMeldungen.showErrorMessage(
                "Bitte geben Sie eine Zimmernummer ein!");
            return;
        }
        if( zimmerNummer.intValue() != zimmerNummern[currentIndex].intValue() )
        {
            // Zimmernummer wurde geändert: als neues Zimmer speichern
            newEntry = true;
        }
        
        Integer anzahlBetten;
        try {
            anzahlBetten = Integer.valueOf( txtAnzahlBetten.getText() );
        } catch( NumberFormatException e ) {
            helpMeldungen.showErrorMessage("Bitte geben Sie eine Zahl " +
                "in das Textfeld 'Anzahl Betten' ein!");
            return;
        }
        
        Double preisProNacht;
        try {
            preisProNacht = Double.valueOf( txtPreis.getText() );
        } catch( NumberFormatException e ) {
            helpMeldungen.showErrorMessage("Bitte geben Sie eine Zahl " +
                "in das Textfeld 'Preis pro Nacht' ein!");
            return;
        }
        
        Zimmer zimmer = new Zimmer();
        zimmer.assignDatabase( DatabaseManager.db );
        
        zimmer.setPrimaryKeys( zimmerNummer );
        
        zimmer.setProperties( anzahlBetten, preisProNacht );
        
        if( zimmer.toDatabase() == false ) {
            helpMeldungen.showErrorMessage("Die Zimmerdaten konnten wegen " +
                "eines Fehlers nicht in die Datenbank geschrieben werden.");
            return;
        }
        else {
            if( newEntry == false ) {
                refreshZimmer( currentIndex, zimmer,
                               helper.getKundeInZimmer(zimmer) );
            }
            else {
                loadTableData();
            }
        }
    }
    
    /**
     * Speichert die derzeit bearbeitete Aufgabe.
     */
    private void saveCurrentAufgabe()
    {
        if( newEntry == true ) {
            return;
        }
        
        Aufgabe aufgabe = new Aufgabe();
        aufgabe.assignDatabase( DatabaseManager.db );
        aufgabe.setPrimaryKeys( aufgabenNummern[currentAufgabenIndex] );
        
        if( aufgabe.fromDatabase() == false ) {
            helpMeldungen.showErrorMessage("Die Aufgabe konnten wegen " +
                "eines Fehlers nicht gespeichert werden.");
            return;
        }
        
        java.sql.Date ab, deadline;
        try {
            ab = java.sql.Date.valueOf( txtAb.getText() );
            deadline = java.sql.Date.valueOf( txtDeadline.getText() );
        } catch( IllegalArgumentException e ) {
            txtAb.setText( aufgabe.getAb().toString() );
            txtDeadline.setText( aufgabe.getDeadline().toString() );
            return;
        }
        aufgabe.setProperties( aufgabe.getZimmerNr(),
            txtBezeichnung.getText(), ab, deadline, 
            new Boolean(chkErledigt.isSelected())
        );
        
        if( aufgabe.toDatabase() == false ) {
            helpMeldungen.showErrorMessage("Die Aufgabe konnten wegen " +
                "eines Fehlers nicht gespeichert werden.");
            return;
        }
        
        refreshAufgabe( currentAufgabenIndex, aufgabe );
    }
    
    /**
     * Löscht das derzeit ausgewählte Zimmer.
     */
    private void deleteCurrentEntry()
    {
        if( newEntry == true )
        {
            helpMeldungen.showErrorMessage("Da gerade kein Zimmer ausgewaehlt " +
                "ist, wird auch keines gelöscht.");
            return;
        }
        
        Zimmer zimmer = new Zimmer();
        zimmer.assignDatabase( DatabaseManager.db );
        zimmer.setPrimaryKeys( zimmerNummern[currentIndex] );
        
        if( zimmer.deleteFromDatabase() == false ) {
            helpMeldungen.showErrorMessage("Das Zimmer konnten wegen " +
                "eines Fehlers nicht gelöscht werden.");
        }
        loadTableData();
    }
    
    /**
     * Löscht die derzeit ausgewählte Aufgabe.
     */
    private void deleteCurrentAufgabe()
    {
        if( newEntry == true )
        {
            helpMeldungen.showErrorMessage("Da gerade kein Zimmer ausgewaehlt " +
                "ist, wird auch nichts gelöscht.");
            return;
        }
        
        Aufgabe aufgabe = new Aufgabe();
        aufgabe.assignDatabase( DatabaseManager.db );
        aufgabe.setPrimaryKeys( aufgabenNummern[currentAufgabenIndex] );
        
        if( aufgabe.deleteFromDatabase() == false ) {
            helpMeldungen.showErrorMessage("Die Aufgabe konnten wegen " +
                "eines Fehlers nicht gelöscht werden.");
        }
        
        Zimmer zimmer = new Zimmer();
        zimmer.assignDatabase( DatabaseManager.db );
        zimmer.setPrimaryKeys( zimmerNummern[currentIndex] );
        loadAufgabenTableData( zimmer );
    }
    
    /**
     * Fügt eine neue Aufgabe fürs aktuelle Zimmer in die Aufgabenansicht ein.
     */
    public void neueAufgabe()
    {
        if( newEntry == true ) {
            helpMeldungen.showErrorMessage("Da gerade kein Zimmer ausgewählt ist, "
                + "kann für dieses zurzeit keine Aufgabe erstellt werden.");
            return;
        }
        
        Aufgabe aufgabe = new Aufgabe();
        aufgabe.assignDatabase( DatabaseManager.db );
        aufgabe.setSerialKey();
        aufgabe.setProperties( zimmerNummern[currentIndex], "(Neue Aufgabe)",
                               new java.util.Date(), new java.util.Date(),
                               new Boolean(false) );
        
        if( aufgabe.toDatabase() == false ) {
            helpMeldungen.showErrorMessage("Beim Erstellen einer neuen Aufgabe "
                + "ist ein Fehler aufgetreten. Ätsch.");
            return;
        }
        
        Zimmer zimmer = new Zimmer();
        zimmer.assignDatabase( DatabaseManager.db );
        zimmer.setPrimaryKeys( zimmerNummern[currentIndex] );
        if( zimmer.fromDatabase() == true ) {
            loadAufgabenTableData( zimmer );
        }
    }
    
    
    /**
     * Filtert die Zimmerliste anhand des Texts im Such-Textfeld.
     */
    public void search()
    {
        if( txtSuchen.getText().length() < 1 )
            return;
        
        Zimmer[] zimmern = helper.searchByNumber( txtSuchen.getText() );
        if( zimmern == null ) {
            helpMeldungen.showInformationMessage(
                "Beim Suchen ist ein Fehler aufgetreten. Ätsch.");
            return;
        }
        
        loadTableData( zimmern );
        
        if( zimmern.length == 0 ) {
            helpMeldungen.showInformationMessage(
                "Mit diesem Suchbegriff wurden keine Zimmer gefunden.");
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
        pnlAnzeigeZimmer = new javax.swing.JPanel();
        lblZimmerNr = new javax.swing.JLabel();
        txtZimmerNr = new javax.swing.JTextField();
        lblAnzahlBetten = new javax.swing.JLabel();
        txtAnzahlBetten = new javax.swing.JTextField();
        lblPreis = new javax.swing.JLabel();
        txtPreis = new javax.swing.JTextField();
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
        btnSpeichern = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        tblZimmer = new javax.swing.JTable();
        pnlZimmerProperties = new javax.swing.JPanel();
        pnlAufgaben = new javax.swing.JPanel();
        tblAufgaben = new javax.swing.JTable();
        pnlAufgabenEdit = new javax.swing.JPanel();
        pnlAufgabenEditOben = new javax.swing.JPanel();
        lblBezeichnung = new javax.swing.JLabel();
        txtBezeichnung = new javax.swing.JTextField();
        chkErledigt = new javax.swing.JCheckBox();
        pnlAufgabenEditUnten = new javax.swing.JPanel();
        lblAb = new javax.swing.JLabel();
        txtAb = new javax.swing.JTextField();
        lblDeadline = new javax.swing.JLabel();
        txtDeadline = new javax.swing.JTextField();
        pnlAufgabenActions = new javax.swing.JPanel();
        btnAufgabeNeu = new javax.swing.JButton();
        btnAufgabeLoeschen = new javax.swing.JButton();
        pnlAusstattung = new javax.swing.JPanel();
        tblAusstattung = new javax.swing.JTable();
        pnlAusstattungsActions = new javax.swing.JPanel();
        btnAusstattungNeu = new javax.swing.JButton();
        btnAusstattungLoeschen = new javax.swing.JButton();
        pnlAusstattungEdit = new javax.swing.JPanel();
        lblElement = new javax.swing.JLabel();
        cmbElement = new javax.swing.JComboBox();
        pnlLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        pnlSwitcher = new javax.swing.JPanel();
        pnlSwitcherButtons = new javax.swing.JPanel();
        btnSwitchToKunden = new javax.swing.JButton();
        btnSwitchToAufenthalte = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getAccessibleContext().setAccessibleName("Kundenliste");
        pnlCaption.setLayout(new java.awt.BorderLayout());

        lblCaption.setFont(new java.awt.Font("Arial", 1, 18));
        lblCaption.setText("Zimmer");
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

        pnlAnzeigeZimmer.setLayout(new java.awt.GridLayout(3, 2));

        pnlAnzeigeZimmer.setBorder(new javax.swing.border.TitledBorder("Zimmerdaten"));
        lblZimmerNr.setText("Zimmernummer");
        lblZimmerNr.setRequestFocusEnabled(false);
        pnlAnzeigeZimmer.add(lblZimmerNr);

        txtZimmerNr.setToolTipText("");
        txtZimmerNr.setMinimumSize(new java.awt.Dimension(600, 1));
        pnlAnzeigeZimmer.add(txtZimmerNr);

        lblAnzahlBetten.setText("Anzahl Betten");
        lblAnzahlBetten.setRequestFocusEnabled(false);
        pnlAnzeigeZimmer.add(lblAnzahlBetten);

        pnlAnzeigeZimmer.add(txtAnzahlBetten);

        lblPreis.setText("Preis pro Nacht");
        lblPreis.setRequestFocusEnabled(false);
        pnlAnzeigeZimmer.add(lblPreis);

        txtPreis.setToolTipText("");
        pnlAnzeigeZimmer.add(txtPreis);

        pnlAnzeigeOben.add(pnlAnzeigeZimmer);

        pnlAnzeigeKunde.setLayout(new java.awt.GridLayout(8, 2));

        pnlAnzeigeKunde.setBorder(new javax.swing.border.TitledBorder("Kundendaten"));
        lblNachname.setText("Nachname");
        lblNachname.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblNachname);

        txtNachname.setEditable(false);
        txtNachname.setToolTipText("");
        txtNachname.setMinimumSize(new java.awt.Dimension(600, 1));
        pnlAnzeigeKunde.add(txtNachname);

        lblVorname.setText("Vorname");
        lblVorname.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblVorname);

        txtVorname.setEditable(false);
        pnlAnzeigeKunde.add(txtVorname);

        lblLand.setText("Land");
        lblLand.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblLand);

        txtLand.setEditable(false);
        pnlAnzeigeKunde.add(txtLand);

        lblPlz.setText("Plz");
        lblPlz.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblPlz);

        txtPlz.setEditable(false);
        pnlAnzeigeKunde.add(txtPlz);

        lblOrt.setText("Wohnort");
        lblOrt.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblOrt);

        txtOrt.setEditable(false);
        pnlAnzeigeKunde.add(txtOrt);

        lblStrasse.setText("Stra\u00dfe");
        lblStrasse.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblStrasse);

        txtStrasse.setEditable(false);
        pnlAnzeigeKunde.add(txtStrasse);

        lblTelNr.setText("Telefonnr.");
        lblTelNr.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblTelNr);

        txtTelNr.setEditable(false);
        pnlAnzeigeKunde.add(txtTelNr);

        lblNotiz.setText("Notiz");
        lblNotiz.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblNotiz);

        txtNotiz.setEditable(false);
        pnlAnzeigeKunde.add(txtNotiz);

        pnlAnzeigeOben.add(pnlAnzeigeKunde);

        pnlOk.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));

        btnSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/ok.gif")));
        btnSpeichern.setText("Werte speichern");
        btnSpeichern.setToolTipText("Bet\u00e4tigen Sie diesen Button um zu best\u00e4tigen!");
        btnSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSpeichernActionPerformed(evt);
            }
        });

        pnlOk.add(btnSpeichern);

        pnlAnzeigeOben.add(pnlOk);

        pnlAnzeige.add(pnlAnzeigeOben, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnlAnzeige, java.awt.BorderLayout.WEST);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        tblZimmer.setBorder(new javax.swing.border.EtchedBorder());
        tblZimmer.setModel(new javax.swing.table.DefaultTableModel(
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
        tblZimmer.setGridColor(new java.awt.Color(255, 255, 255));
        pnlCenter.add(tblZimmer, java.awt.BorderLayout.CENTER);

        pnlZimmerProperties.setLayout(new javax.swing.BoxLayout(pnlZimmerProperties, javax.swing.BoxLayout.X_AXIS));

        pnlAufgaben.setLayout(new java.awt.BorderLayout());

        pnlAufgaben.setBorder(new javax.swing.border.TitledBorder("Aufgaben"));
        tblAufgaben.setBorder(new javax.swing.border.EtchedBorder());
        tblAufgaben.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAufgaben.setGridColor(new java.awt.Color(255, 255, 255));
        tblAufgaben.setMinimumSize(new java.awt.Dimension(60, 100));
        pnlAufgaben.add(tblAufgaben, java.awt.BorderLayout.CENTER);

        pnlAufgabenEdit.setLayout(new java.awt.BorderLayout());

        pnlAufgabenEditOben.setLayout(new java.awt.BorderLayout());

        lblBezeichnung.setText("Aufgabe: ");
        pnlAufgabenEditOben.add(lblBezeichnung, java.awt.BorderLayout.WEST);

        txtBezeichnung.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBezeichnungFocusLost(evt);
            }
        });

        pnlAufgabenEditOben.add(txtBezeichnung, java.awt.BorderLayout.CENTER);

        chkErledigt.setText("erledigt");
        chkErledigt.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkErledigtStateChanged(evt);
            }
        });

        pnlAufgabenEditOben.add(chkErledigt, java.awt.BorderLayout.EAST);

        pnlAufgabenEdit.add(pnlAufgabenEditOben, java.awt.BorderLayout.NORTH);

        pnlAufgabenEditUnten.setLayout(new javax.swing.BoxLayout(pnlAufgabenEditUnten, javax.swing.BoxLayout.X_AXIS));

        lblAb.setText("G\u00fcltig ab: ");
        pnlAufgabenEditUnten.add(lblAb);

        txtAb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtAbFocusLost(evt);
            }
        });

        pnlAufgabenEditUnten.add(txtAb);

        lblDeadline.setText("  Deadline: ");
        pnlAufgabenEditUnten.add(lblDeadline);

        txtDeadline.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDeadlineFocusLost(evt);
            }
        });

        pnlAufgabenEditUnten.add(txtDeadline);

        pnlAufgabenEdit.add(pnlAufgabenEditUnten, java.awt.BorderLayout.SOUTH);

        pnlAufgaben.add(pnlAufgabenEdit, java.awt.BorderLayout.SOUTH);

        pnlAufgabenActions.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 0));

        btnAufgabeNeu.setText("Neue Aufgabe");
        btnAufgabeNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAufgabeNeuActionPerformed(evt);
            }
        });

        pnlAufgabenActions.add(btnAufgabeNeu);

        btnAufgabeLoeschen.setText("Aufgabe l\u00f6schen");
        btnAufgabeLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAufgabeLoeschenActionPerformed(evt);
            }
        });

        pnlAufgabenActions.add(btnAufgabeLoeschen);

        pnlAufgaben.add(pnlAufgabenActions, java.awt.BorderLayout.NORTH);

        pnlZimmerProperties.add(pnlAufgaben);

        pnlAusstattung.setLayout(new java.awt.BorderLayout());

        pnlAusstattung.setBorder(new javax.swing.border.TitledBorder("Ausstattung"));
        tblAusstattung.setBorder(new javax.swing.border.EtchedBorder());
        tblAusstattung.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblAusstattung.setGridColor(new java.awt.Color(255, 255, 255));
        tblAusstattung.setMinimumSize(new java.awt.Dimension(60, 100));
        pnlAusstattung.add(tblAusstattung, java.awt.BorderLayout.CENTER);

        pnlAusstattungsActions.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 0, 0));

        btnAusstattungNeu.setText("Neues Element");
        btnAusstattungNeu.setEnabled(false);
        pnlAusstattungsActions.add(btnAusstattungNeu);

        btnAusstattungLoeschen.setText("Element l\u00f6schen");
        btnAusstattungLoeschen.setEnabled(false);
        pnlAusstattungsActions.add(btnAusstattungLoeschen);

        pnlAusstattung.add(pnlAusstattungsActions, java.awt.BorderLayout.NORTH);

        pnlAusstattungEdit.setLayout(new javax.swing.BoxLayout(pnlAusstattungEdit, javax.swing.BoxLayout.X_AXIS));

        lblElement.setText("Ausstattungselement: ");
        lblElement.setEnabled(false);
        pnlAusstattungEdit.add(lblElement);

        cmbElement.setEnabled(false);
        pnlAusstattungEdit.add(cmbElement);

        pnlAusstattung.add(pnlAusstattungEdit, java.awt.BorderLayout.SOUTH);

        pnlZimmerProperties.add(pnlAusstattung);

        pnlCenter.add(pnlZimmerProperties, java.awt.BorderLayout.SOUTH);

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

        pnlSwitcher.setLayout(new java.awt.BorderLayout());

        pnlSwitcher.setBorder(new javax.swing.border.TitledBorder("Wechseln zu"));
        pnlSwitcherButtons.setLayout(new java.awt.GridLayout(2, 0));

        btnSwitchToKunden.setText("Kunden");
        btnSwitchToKunden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchToKundenActionPerformed(evt);
            }
        });

        pnlSwitcherButtons.add(btnSwitchToKunden);

        btnSwitchToAufenthalte.setText("Aufenthalte");
        btnSwitchToAufenthalte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchToAufenthalteActionPerformed(evt);
            }
        });

        pnlSwitcherButtons.add(btnSwitchToAufenthalte);

        pnlSwitcher.add(pnlSwitcherButtons, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnlSwitcher, java.awt.BorderLayout.EAST);

        pack();
    }//GEN-END:initComponents

    private void btnSwitchToAufenthalteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchToAufenthalteActionPerformed
        this.dispose();
        new frmAufenthalte().setVisible(true);
    }//GEN-LAST:event_btnSwitchToAufenthalteActionPerformed

    private void btnSwitchToKundenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchToKundenActionPerformed
        this.dispose();
        new frmKundenliste().setVisible(true);
    }//GEN-LAST:event_btnSwitchToKundenActionPerformed

    private void txtDeadlineFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDeadlineFocusLost
        saveCurrentAufgabe();
    }//GEN-LAST:event_txtDeadlineFocusLost

    private void txtAbFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtAbFocusLost
        saveCurrentAufgabe();
    }//GEN-LAST:event_txtAbFocusLost

    private void chkErledigtStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkErledigtStateChanged
        saveCurrentAufgabe();
    }//GEN-LAST:event_chkErledigtStateChanged

    private void txtBezeichnungFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBezeichnungFocusLost
        saveCurrentAufgabe();
    }//GEN-LAST:event_txtBezeichnungFocusLost

    private void btnAufgabeLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAufgabeLoeschenActionPerformed
        deleteCurrentAufgabe();
    }//GEN-LAST:event_btnAufgabeLoeschenActionPerformed

    private void btnAufgabeNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAufgabeNeuActionPerformed
        neueAufgabe();
    }//GEN-LAST:event_btnAufgabeNeuActionPerformed

    private void btnSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuchenActionPerformed
        search();
    }//GEN-LAST:event_btnSuchenActionPerformed

    private void btnSuchenResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuchenResetActionPerformed
        txtSuchen.setText("");
        loadTableData();
    }//GEN-LAST:event_btnSuchenResetActionPerformed

    private void btnSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSpeichernActionPerformed
        this.saveTextFields( );
    }//GEN-LAST:event_btnSpeichernActionPerformed

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
                new frmZimmerplan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAufgabeLoeschen;
    private javax.swing.JButton btnAufgabeNeu;
    private javax.swing.JButton btnAusstattungLoeschen;
    private javax.swing.JButton btnAusstattungNeu;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSpeichern;
    private javax.swing.JButton btnSuchen;
    private javax.swing.JButton btnSuchenReset;
    private javax.swing.JButton btnSwitchToAufenthalte;
    private javax.swing.JButton btnSwitchToKunden;
    private javax.swing.JCheckBox chkErledigt;
    private javax.swing.JComboBox cmbElement;
    private javax.swing.JLabel lblAb;
    private javax.swing.JLabel lblAnzahlBetten;
    private javax.swing.JLabel lblBezeichnung;
    private javax.swing.JLabel lblCaption;
    private javax.swing.JLabel lblDeadline;
    private javax.swing.JLabel lblElement;
    private javax.swing.JLabel lblLand;
    private javax.swing.JLabel lblNachname;
    private javax.swing.JLabel lblNotiz;
    private javax.swing.JLabel lblOrt;
    private javax.swing.JLabel lblPlz;
    private javax.swing.JLabel lblPreis;
    private javax.swing.JLabel lblStrasse;
    private javax.swing.JLabel lblSuchen;
    private javax.swing.JLabel lblTelNr;
    private javax.swing.JLabel lblVorname;
    private javax.swing.JLabel lblZimmerNr;
    private javax.swing.JPanel pnlAnzeige;
    private javax.swing.JPanel pnlAnzeigeKunde;
    private javax.swing.JPanel pnlAnzeigeOben;
    private javax.swing.JPanel pnlAnzeigeZimmer;
    private javax.swing.JPanel pnlAufgaben;
    private javax.swing.JPanel pnlAufgabenActions;
    private javax.swing.JPanel pnlAufgabenEdit;
    private javax.swing.JPanel pnlAufgabenEditOben;
    private javax.swing.JPanel pnlAufgabenEditUnten;
    private javax.swing.JPanel pnlAusstattung;
    private javax.swing.JPanel pnlAusstattungEdit;
    private javax.swing.JPanel pnlAusstattungsActions;
    private javax.swing.JPanel pnlCaption;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlOk;
    private javax.swing.JPanel pnlSuchaktionen;
    private javax.swing.JPanel pnlSuchen;
    private javax.swing.JPanel pnlSwitcher;
    private javax.swing.JPanel pnlSwitcherButtons;
    private javax.swing.JPanel pnlZimmerProperties;
    private javax.swing.JTable tblAufgaben;
    private javax.swing.JTable tblAusstattung;
    private javax.swing.JTable tblZimmer;
    private javax.swing.JTextField txtAb;
    private javax.swing.JTextField txtAnzahlBetten;
    private javax.swing.JTextField txtBezeichnung;
    private javax.swing.JTextField txtDeadline;
    private javax.swing.JTextField txtLand;
    private javax.swing.JTextField txtNachname;
    private javax.swing.JTextField txtNotiz;
    private javax.swing.JTextField txtOrt;
    private javax.swing.JTextField txtPlz;
    private javax.swing.JTextField txtPreis;
    private javax.swing.JTextField txtStrasse;
    private javax.swing.JTextField txtSuchen;
    private javax.swing.JTextField txtTelNr;
    private javax.swing.JTextField txtVorname;
    private javax.swing.JTextField txtZimmerNr;
    // End of variables declaration//GEN-END:variables

}
