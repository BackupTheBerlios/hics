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
public class frmAufenthalte extends javax.swing.JFrame
{
    public static String TITLE="Aufenthalte";
    private String[] columns = {"Name", "Zimmer", "von", "bis", "Status"};
    private static final int COL_NAME   = 0;
    private static final int COL_ZIMMER = 1;
    private static final int COL_VON    = 2;
    private static final int COL_BIS    = 3;
    private static final int COL_STATUS = 4;
    
    private String[] zimmerColumns = {"Zimmer", "von", "bis"};
    private static final int ZCOL_ZIMMER = 0;
    private static final int ZCOL_VON    = 1;
    private static final int ZCOL_BIS    = 2;
    
    private Integer[] aufenthaltsNummern;
    private Integer[] zimmerNummern;
    private Integer currentKundenNr;
    private AufenthaltHelper helper;
    private int currentIndex;
    private int currentZimmerIndex;
    private boolean newEntry = true;
    

    /** Creates new form frmStart */
    public frmAufenthalte() {
        super(TITLE);
        initComponents();
        setupListeners();
        
        helper = new AufenthaltHelper(DatabaseManager.db);
        loadTableData();
        
        setSize(getToolkit().getScreenSize());
        show();
    }
    
    public void reactivate( Kunde kunde )
    {
        this.setVisible( true );
        if( aufenthaltsNummern == null )
            return;
        
        currentKundenNr = kunde.getKundenNr();
        fillKundenWidgets( kunde );
    }
    
    private void setupListeners()
    {
        //Ask to be notified of selection changes.
        ListSelectionModel rowSM = tblAufenthalte.getSelectionModel();
        rowSM.addListSelectionListener(
            new ListSelectionListener()
            {
                public void valueChanged(ListSelectionEvent e) {
                    //Ignore extra messages.
                    if (e.getValueIsAdjusting()) return;

                    ListSelectionModel lsm =
                        (ListSelectionModel)e.getSource();
                    if (lsm.isSelectionEmpty()) {
                        clearWidgets();
                    } else {
                        int selectedRow = lsm.getMinSelectionIndex();
                        fillWidgets( selectedRow );
                    }
                }
            }
        );
        // Verändern der Zimmerauswahl
        rowSM = tblZimmer.getSelectionModel();
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
                        fillZimmerWidgets( selectedRow );
                    }
                }
            }
        );
    }
    
    /**
     * Füllt mit Hilfe eines Helper-Objekts die Aufenthaltstabelle
     * mit allen Aufenthalten.
     */
    public void loadTableData()
    {
        Aufenthalt[] aufenthalte = helper.getAufenthalte();
        if( aufenthalte == null )
            return;
        
        aufenthaltsNummern = new Integer[aufenthalte.length];
        zimmerNummern = null;
        currentKundenNr = null;
        loadTableData( aufenthalte );
    }

    /**
     * Füllt mit Hilfe eines Helper-Objekts die Aufenthaltstabelle mit den
     * angegebenen Aufenthalten.
     */
    public void loadTableData( Aufenthalt[] aufenthalte )
    {
        if( aufenthalte == null )
            return;
        
        tblAufenthalte.setModel( new javax.swing.table.DefaultTableModel(
                                new Object[0][columns.length], columns )
        );
        
        Object[][] contents = new Object[aufenthalte.length][columns.length];
        
        // Zunächst wird die Tabelle mit Dummy-Einträgen gefüllt
        for( int i = 0; i < aufenthalte.length; i++ ) {
            for( int k = 0; k < columns.length; k++ ) {
                contents[i][k] = "";
            }
        }
        tblAufenthalte.setModel(
            new javax.swing.table.DefaultTableModel( contents, columns )
        );
        
        // jetzt werden die eigentlichen Einträge eingefügt
        for( int i = 0; i < aufenthalte.length; i++ ) {
            refreshAufenthalt( i, aufenthalte[i] );
        }
    }
    
    /**
     * Füllt die Zimmerdaten-Steuerelemente mit Werten aus der Datenbank.
     */
    private void loadZimmerTableData( Aufenthalt aufenthalt )
    {
        Zimmerbelegung[] belegungen = helper.getZimmerbelegungenInAufenthalt( aufenthalt );
        if( belegungen == null ) 
            return;
        
        tblZimmer.setModel( new javax.swing.table.DefaultTableModel(
                            new Object[0][zimmerColumns.length],
                            zimmerColumns )
        );
        
        Object[][] contents = new Object[belegungen.length][zimmerColumns.length];
        zimmerNummern = new Integer[belegungen.length];
        
        // Zunächst wird die Tabelle mit Dummy-Einträgen gefüllt
        for( int i = 0; i < belegungen.length; i++ ) {
            for( int k = 0; k < zimmerColumns.length; k++ ) {
                contents[i][k] = "";
            }
        }
        tblZimmer.setModel(
            new javax.swing.table.DefaultTableModel( contents, zimmerColumns )
        );
        
        // jetzt werden die eigentlichen Einträge eingefügt
        for( int i = 0; i < belegungen.length; i++ ) {
            refreshZimmer( i, belegungen[i] );
        }
    }
    
    /**
     * Aktualisiert einen Tabelleneintrag mit den Daten eines Kunden-Objekts.
     */
    public void refreshAufenthalt( int tableIndex, Aufenthalt newValue )
    {
        aufenthaltsNummern[tableIndex] = newValue.getAufenthaltsNr();
        Kunde kunde = helper.getKundeInAufenthalt( newValue );
        tblAufenthalte.setValueAt(
            kunde.getVorname() + " " + kunde.getNachname(),
            tableIndex, COL_NAME );
        Zimmer[] zimmern = helper.getZimmernInAufenthalt( newValue );
        String zimmerNummernString = "";
        for( int i = 0; i < zimmern.length; i++ ) {
            if( i != 0 ) {
                zimmerNummernString += ", ";
            }
            zimmerNummernString += zimmern[i].getZimmerNr().toString();
        }
        tblAufenthalte.setValueAt(
            zimmerNummernString, tableIndex, COL_ZIMMER );
        tblAufenthalte.setValueAt(
            "von " + newValue.getVon().toString(), tableIndex, COL_VON );
        tblAufenthalte.setValueAt(
            "bis " + newValue.getBis().toString(), tableIndex, COL_BIS );
        tblAufenthalte.setValueAt(
            newValue.getStatus(), tableIndex, COL_STATUS );
    }
    
    /**
     * Aktualisiert einen Zimmertabelleneintrag mit den Daten eines Zimmer-Objekts.
     */
    public void refreshZimmer( int tableIndex, Zimmerbelegung belegung )
    {
        zimmerNummern[tableIndex] = belegung.getZimmerNr();
        tblZimmer.setValueAt(
            zimmerNummern[tableIndex].toString(), tableIndex, ZCOL_ZIMMER );
        tblZimmer.setValueAt(
            "von " + belegung.getVon().toString(), tableIndex, ZCOL_VON );
        tblZimmer.setValueAt(
            "bis " + belegung.getBis().toString(), tableIndex, ZCOL_BIS );
    }
    
    /**
     * Löscht die Inhalte der Daten-Steuerelemente.
     */
    private void clearWidgets()
    {
        txtStatus.setText("");
        txtVon.setText("");
        txtBis.setText("");
        
        clearKundenWidgets();
        clearZimmerWidgets();
    }
    
    /**
     * Löscht den Text aller Kundendaten-Textfelder.
     */
    private void clearKundenWidgets()
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
     * Löscht den Text aller Zimmerdaten-Steuerelemente.
     */
    private void clearZimmerWidgets()
    {
        // Zimmerliste nicht mehr anzeigen
        tblZimmer.setModel( new javax.swing.table.DefaultTableModel(
                            new Object[0][zimmerColumns.length],
                            zimmerColumns )
        );
        zimmerNummern = null;
    }
    
    /**
     * Füllt die Steuerelemente mit Werten aus der Datenbank.
     */
    private void fillWidgets( int tableIndex )
    {
        currentIndex = tableIndex;
        newEntry = false;
        Aufenthalt aufenthalt = new Aufenthalt();
        aufenthalt.assignDatabase( DatabaseManager.db );
        aufenthalt.setPrimaryKeys( aufenthaltsNummern[currentIndex] );
        
        if( aufenthalt.fromDatabase() == false )
            helpMeldungen.showErrorMessage("Konnte die Daten nicht auslesen!");
        
        txtStatus.setText( aufenthalt.getStatus() );
        txtVon.setText( aufenthalt.getVon().toString() );
        txtBis.setText( aufenthalt.getBis().toString() );
        
        Kunde kunde = helper.getKundeInAufenthalt( aufenthalt );
        if( kunde == null ) {
            currentKundenNr = null;
            kunde = new Kunde();
        }
        
        fillKundenWidgets( kunde );
        loadZimmerTableData( aufenthalt );
    }
    
    /**
     * Füllt die Kundendaten-Textfelder mit Werten aus der Datenbank.
     */
    private void fillKundenWidgets( Kunde kunde )
    {        
        currentKundenNr = kunde.getKundenNr();
        
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
     * Füllt die Zimmer-Steuerelemente mit Daten.
     */
    public void fillZimmerWidgets( int selectedRow )
    {
        currentZimmerIndex = selectedRow;
        if( zimmerNummern == null )
            return;
        
        Zimmer zimmer = new Zimmer();
        zimmer.assignDatabase( DatabaseManager.db );
        zimmer.setPrimaryKeys( zimmerNummern[currentZimmerIndex] );
        if( zimmer.fromDatabase() == false ) {
            helpMeldungen.showErrorMessage(
                "Konnte die Zimmerdaten nicht auslesen!");
        }
        /*txtBezeichnung.setText( aufgabe.getBezeichnung() );
        chkErledigt.setSelected( aufgabe.getErledigt().booleanValue() );
        txtAb.setText( aufgabe.getAb().toString() );
        txtDeadline.setText( aufgabe.getDeadline().toString() );
         */
    }
    
    /**
     * Schreibt die Aufenthalts-Daten wieder in die Datenbank zurück.
     */
    private void saveTextFields()
    {
        Aufenthalt aufenthalt = new Aufenthalt();
        aufenthalt.assignDatabase( DatabaseManager.db );
        
        if( newEntry == false )
            aufenthalt.setPrimaryKeys( aufenthaltsNummern[currentIndex] );
        else
            aufenthalt.setSerialKey();
        
        java.sql.Date von, bis;
        try {
            von = java.sql.Date.valueOf( txtVon.getText() );
            bis = java.sql.Date.valueOf( txtBis.getText() );
        } catch( IllegalArgumentException e ) {
            txtVon.setText( aufenthalt.getVon().toString() );
            txtBis.setText( aufenthalt.getBis().toString() );
            helpMeldungen.showErrorMessage("Bitte geben Sie Daten der Form " +
                "JJJJ-MM-TT in die Textfelder 'Von' und 'Bis' ein." +
                "Der Aufenthalt wurde zunächst nicht gespeichert.");
            return;
        }
        
        if( currentKundenNr == null ) {
            helpMeldungen.showErrorMessage("Bitte wählen Sie einen Kunden aus. " +
                "Der Aufenthalt wurde zunächst nicht gespeichert.");
        }
            
        aufenthalt.setProperties( currentKundenNr, Session.mitarbeiter.getMitarbeiterNr(),
                von, bis, txtStatus.getText() );
        
        if( aufenthalt.toDatabase() == false ) {
            helpMeldungen.showErrorMessage("Die Aufenthaltsdaten konnten wegen " +
                "eines Fehlers nicht in die Datenbank geschrieben werden.");
            return;
        }
        else {
            if( newEntry == false ) {
                refreshAufenthalt( currentIndex, aufenthalt );
            }
            else {
                loadTableData();
            }
        }
    }
    
    /**
     * Löscht den derzeit ausgewählten Aufenthalt.
     */
    private void deleteCurrentEntry()
    {
        if( newEntry == true )
        {
            helpMeldungen.showErrorMessage("Da gerade kein Aufenthalt ausgewaehlt " +
                "ist, wird auch keiner gelöscht.");
            return;
        }
        
        Aufenthalt aufenthalt = new Aufenthalt();
        aufenthalt.assignDatabase( DatabaseManager.db );
        aufenthalt.setPrimaryKeys( aufenthaltsNummern[currentIndex] );
        
        if( aufenthalt.deleteFromDatabase() == false ) {
            helpMeldungen.showErrorMessage("Die Aufenthaltsdaten konnten wegen " +
                "eines Fehlers nicht geloescht werden.");
        }
        loadTableData();
    }
    
    /**
     * Filtert die Aufenthaltsliste anhand des Texts im Such-Textfeld.
     */
    public void search()
    {
        if( txtSuchen.getText().length() < 3 ) {
            helpMeldungen.showInformationMessage("Der Suchbegriff muss " +
                "mindestens drei Zeichen lang sein.");
            return;
        }
        Aufenthalt[] aufenthalte = helper.search( txtSuchen.getText() );
        if( aufenthalte == null ) {
            helpMeldungen.showInformationMessage(
                "Beim Suchen ist ein Fehler aufgetreten. Ätsch.");
            return;
        }
        
        loadTableData( aufenthalte );
        
        if( aufenthalte.length == 0 ) {
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
        pnlAnzeigeAufenthalt = new javax.swing.JPanel();
        lblStatus = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        lblVon = new javax.swing.JLabel();
        txtVon = new javax.swing.JTextField();
        lblBis = new javax.swing.JLabel();
        txtBis = new javax.swing.JTextField();
        pnlAnzeigeKunde = new javax.swing.JPanel();
        btnKundeSelect = new javax.swing.JButton();
        pnlKundenFill = new javax.swing.JPanel();
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
        btnNeuerAufenthalt = new javax.swing.JButton();
        btnSpeichern = new javax.swing.JButton();
        pnlLöschen = new javax.swing.JPanel();
        cmdLoeschen = new javax.swing.JButton();
        pnlCenter = new javax.swing.JPanel();
        tblAufenthalte = new javax.swing.JTable();
        pnlZimmerliste = new javax.swing.JPanel();
        pnlZimmerActions = new javax.swing.JPanel();
        btnZimmerNeu = new javax.swing.JButton();
        btnZimmerLoeschen = new javax.swing.JButton();
        tblZimmer = new javax.swing.JTable();
        pnlLogout = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        pnlSwitcher = new javax.swing.JPanel();
        pnlSwitcherButtons = new javax.swing.JPanel();
        btnSwitchToZimmerplan = new javax.swing.JButton();
        btnSwitchToKunden = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getAccessibleContext().setAccessibleName("Kundenliste");
        pnlCaption.setLayout(new java.awt.BorderLayout());

        lblCaption.setFont(new java.awt.Font("Arial", 1, 18));
        lblCaption.setText("Aufenthalte");
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

        pnlAnzeigeAufenthalt.setLayout(new java.awt.GridLayout(3, 2));

        pnlAnzeigeAufenthalt.setBorder(new javax.swing.border.TitledBorder("Aufenthaltsdaten"));
        lblStatus.setText("Status");
        lblStatus.setRequestFocusEnabled(false);
        pnlAnzeigeAufenthalt.add(lblStatus);

        txtStatus.setToolTipText("");
        txtStatus.setMinimumSize(new java.awt.Dimension(600, 1));
        pnlAnzeigeAufenthalt.add(txtStatus);

        lblVon.setText("Von");
        lblVon.setRequestFocusEnabled(false);
        pnlAnzeigeAufenthalt.add(lblVon);

        pnlAnzeigeAufenthalt.add(txtVon);

        lblBis.setText("Bis");
        lblBis.setRequestFocusEnabled(false);
        pnlAnzeigeAufenthalt.add(lblBis);

        txtBis.setToolTipText("");
        pnlAnzeigeAufenthalt.add(txtBis);

        pnlAnzeigeOben.add(pnlAnzeigeAufenthalt);

        pnlAnzeigeKunde.setLayout(new java.awt.GridLayout(9, 2));

        pnlAnzeigeKunde.setBorder(new javax.swing.border.TitledBorder("Kundendaten"));
        btnKundeSelect.setText("Kunden ausw\u00e4hlen");
        btnKundeSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKundeSelectActionPerformed(evt);
            }
        });

        pnlAnzeigeKunde.add(btnKundeSelect);

        pnlAnzeigeKunde.add(pnlKundenFill);

        lblNachname.setText("Nachname");
        lblNachname.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblNachname);

        txtNachname.setEditable(false);
        txtNachname.setToolTipText("Geben Sie hier den Nachnamen/Familiennamen des Kunden ein!");
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
        txtLand.setToolTipText("Geben Sie hier das Land ein!");
        pnlAnzeigeKunde.add(txtLand);

        lblPlz.setText("Plz");
        lblPlz.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblPlz);

        txtPlz.setEditable(false);
        txtPlz.setToolTipText("Geben Sie hier die Postleitzahl ein!");
        pnlAnzeigeKunde.add(txtPlz);

        lblOrt.setText("Wohnort");
        lblOrt.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblOrt);

        txtOrt.setEditable(false);
        txtOrt.setToolTipText("Geben Sie hier die Postleitzahl ein!");
        pnlAnzeigeKunde.add(txtOrt);

        lblStrasse.setText("Stra\u00dfe");
        lblStrasse.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblStrasse);

        txtStrasse.setEditable(false);
        txtStrasse.setToolTipText("Geben Sie hier die Strasse, in der der Kunde wohnt, ein!");
        pnlAnzeigeKunde.add(txtStrasse);

        lblTelNr.setText("Telefonnr.");
        lblTelNr.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblTelNr);

        txtTelNr.setEditable(false);
        txtTelNr.setToolTipText("");
        pnlAnzeigeKunde.add(txtTelNr);

        lblNotiz.setText("Notiz");
        lblNotiz.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblNotiz);

        txtNotiz.setEditable(false);
        pnlAnzeigeKunde.add(txtNotiz);

        pnlAnzeigeOben.add(pnlAnzeigeKunde);

        btnNeuerAufenthalt.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/neu.gif")));
        btnNeuerAufenthalt.setText("Neuer Aufenthalt");
        btnNeuerAufenthalt.setToolTipText("Bet\u00e4tigen Sie diesen Button um ein neues Objekt zu erstellen!");
        btnNeuerAufenthalt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNeuerAufenthaltActionPerformed(evt);
            }
        });

        pnlOk.add(btnNeuerAufenthalt);

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

        pnlLöschen.setLayout(new java.awt.BorderLayout());

        cmdLoeschen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/abbrechen.gif")));
        cmdLoeschen.setText("Ausgew\u00e4hlten Aufenthalt l\u00f6schen");
        cmdLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoeschenActionPerformed(evt);
            }
        });

        pnlLöschen.add(cmdLoeschen, java.awt.BorderLayout.EAST);

        pnlAnzeige.add(pnlLöschen, java.awt.BorderLayout.SOUTH);

        getContentPane().add(pnlAnzeige, java.awt.BorderLayout.WEST);

        pnlCenter.setLayout(new java.awt.BorderLayout());

        tblAufenthalte.setBorder(new javax.swing.border.EtchedBorder());
        tblAufenthalte.setModel(new javax.swing.table.DefaultTableModel(
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
        tblAufenthalte.setGridColor(new java.awt.Color(255, 255, 255));
        pnlCenter.add(tblAufenthalte, java.awt.BorderLayout.CENTER);

        pnlZimmerliste.setLayout(new java.awt.BorderLayout());

        pnlZimmerliste.setBorder(new javax.swing.border.TitledBorder("Zimmerbelegung dieses Aufenthalts"));
        btnZimmerNeu.setText("Zimmer hinzuf\u00fcgen");
        pnlZimmerActions.add(btnZimmerNeu);

        btnZimmerLoeschen.setText("Zimmer entfernen");
        pnlZimmerActions.add(btnZimmerLoeschen);

        pnlZimmerliste.add(pnlZimmerActions, java.awt.BorderLayout.NORTH);

        tblZimmer.setModel(new javax.swing.table.DefaultTableModel(
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
        tblZimmer.setGridColor(new java.awt.Color(255, 255, 255));
        tblZimmer.setMinimumSize(new java.awt.Dimension(60, 100));
        pnlZimmerliste.add(tblZimmer, java.awt.BorderLayout.CENTER);

        pnlCenter.add(pnlZimmerliste, java.awt.BorderLayout.SOUTH);

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

        btnSwitchToZimmerplan.setText("Zimmerplan");
        btnSwitchToZimmerplan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchToZimmerplanActionPerformed(evt);
            }
        });

        pnlSwitcherButtons.add(btnSwitchToZimmerplan);

        btnSwitchToKunden.setText("Kunden");
        btnSwitchToKunden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSwitchToKundenActionPerformed(evt);
            }
        });

        pnlSwitcherButtons.add(btnSwitchToKunden);

        pnlSwitcher.add(pnlSwitcherButtons, java.awt.BorderLayout.NORTH);

        getContentPane().add(pnlSwitcher, java.awt.BorderLayout.EAST);

        pack();
    }//GEN-END:initComponents

    private void btnKundeSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKundeSelectActionPerformed
        this.setVisible( false );
        new frmKundenliste( this, frmKundenliste.MODE_AUSWAHL_AUFENTHALTE ).setVisible(true);
    }//GEN-LAST:event_btnKundeSelectActionPerformed

    private void btnSwitchToKundenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchToKundenActionPerformed
        this.dispose();
        new frmKundenliste().setVisible(true);
    }//GEN-LAST:event_btnSwitchToKundenActionPerformed

    private void btnSwitchToZimmerplanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSwitchToZimmerplanActionPerformed
        this.dispose();
        new frmZimmerplan().setVisible(true);
    }//GEN-LAST:event_btnSwitchToZimmerplanActionPerformed

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

    private void btnNeuerAufenthaltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNeuerAufenthaltActionPerformed
        clearWidgets();
        txtStatus.setText("Reserviert");
        txtVon.setText( new java.sql.Date(new java.util.Date().getTime()).toString() );
        txtBis.setText( new java.sql.Date(new java.util.Date().getTime()).toString() );
        newEntry = true;
        currentIndex = -1; // eigentlich wurscht, aber sicherheitshalber
    }//GEN-LAST:event_btnNeuerAufenthaltActionPerformed

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
                new frmAufenthalte().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKundeSelect;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNeuerAufenthalt;
    private javax.swing.JButton btnSpeichern;
    private javax.swing.JButton btnSuchen;
    private javax.swing.JButton btnSuchenReset;
    private javax.swing.JButton btnSwitchToKunden;
    private javax.swing.JButton btnSwitchToZimmerplan;
    private javax.swing.JButton btnZimmerLoeschen;
    private javax.swing.JButton btnZimmerNeu;
    private javax.swing.JButton cmdLoeschen;
    private javax.swing.JLabel lblBis;
    private javax.swing.JLabel lblCaption;
    private javax.swing.JLabel lblLand;
    private javax.swing.JLabel lblNachname;
    private javax.swing.JLabel lblNotiz;
    private javax.swing.JLabel lblOrt;
    private javax.swing.JLabel lblPlz;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblStrasse;
    private javax.swing.JLabel lblSuchen;
    private javax.swing.JLabel lblTelNr;
    private javax.swing.JLabel lblVon;
    private javax.swing.JLabel lblVorname;
    private javax.swing.JPanel pnlAnzeige;
    private javax.swing.JPanel pnlAnzeigeAufenthalt;
    private javax.swing.JPanel pnlAnzeigeKunde;
    private javax.swing.JPanel pnlAnzeigeOben;
    private javax.swing.JPanel pnlCaption;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlKundenFill;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlLöschen;
    private javax.swing.JPanel pnlOk;
    private javax.swing.JPanel pnlSuchaktionen;
    private javax.swing.JPanel pnlSuchen;
    private javax.swing.JPanel pnlSwitcher;
    private javax.swing.JPanel pnlSwitcherButtons;
    private javax.swing.JPanel pnlZimmerActions;
    private javax.swing.JPanel pnlZimmerliste;
    private javax.swing.JTable tblAufenthalte;
    private javax.swing.JTable tblZimmer;
    private javax.swing.JTextField txtBis;
    private javax.swing.JTextField txtLand;
    private javax.swing.JTextField txtNachname;
    private javax.swing.JTextField txtNotiz;
    private javax.swing.JTextField txtOrt;
    private javax.swing.JTextField txtPlz;
    private javax.swing.JTextField txtStatus;
    private javax.swing.JTextField txtStrasse;
    private javax.swing.JTextField txtSuchen;
    private javax.swing.JTextField txtTelNr;
    private javax.swing.JTextField txtVon;
    private javax.swing.JTextField txtVorname;
    // End of variables declaration//GEN-END:variables

}
