/*
 * frmAdmindaten.java
 *
 * Created on 26. Mai 2005, 01:41
 */

package gui;

import database.*;
import businesslogic.*;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author  TuBa
 */
public class frmAdmin extends javax.swing.JFrame {
   
   public Database db;
   private Integer mitarbeiterNr;
   private Integer zimmerNr;
   
  
 
    
   public static String TITLE="HICS - Personendaten";
    
    /** Creates new form Anzeige */
    public frmAdmin() {
        super(TITLE);
        initComponents();
        setSize(getToolkit().getScreenSize());
        show();
       
        if( dbConnect() == false ) {
            helpMeldungen.showErrorMessage(
              "Die Verbindung zur Datenbank konnte nicht hergestellt werden.");
            System.exit(1);
        }
    }
        
     private boolean dbConnect()
    {
        db = new Database( DatabaseAccess.url,
                           DatabaseAccess.user, DatabaseAccess.passwort );
        return db.connect();
    }
       
     
     private boolean dbDisconnect()
    {
        if( db != null )
            return db.disconnect();
        else
            return false;
    }
   
        
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        rbtnGroup = new javax.swing.ButtonGroup();
        pnlMitarbeiter = new javax.swing.JPanel();
        cmbBerechtigung = new javax.swing.JComboBox();
        lblMitarbeiterNN = new javax.swing.JLabel();
        txtMitarbeiterNN = new javax.swing.JTextField();
        lblMitarbeiterVN = new javax.swing.JLabel();
        txtMitarbeiterVN = new javax.swing.JTextField();
        lblLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        lblPwd = new javax.swing.JLabel();
        txtPwd = new javax.swing.JTextField();
        pnlLogout = new javax.swing.JPanel();
        cmdLogout = new javax.swing.JButton();
        cmdBeenden = new javax.swing.JButton();
        pnlTop = new javax.swing.JPanel();
        cmdNeu = new javax.swing.JButton();
        cmdSuchen = new javax.swing.JButton();
        cmdSpeichern = new javax.swing.JButton();
        cmdLoeschen = new javax.swing.JButton();
        pnlZimmer = new javax.swing.JPanel();
        lblZimNr = new javax.swing.JLabel();
        txtZimNr = new javax.swing.JTextField();
        lblBettenAnz = new javax.swing.JLabel();
        txtBettenANz = new javax.swing.JTextField();
        lblPreis = new javax.swing.JLabel();
        txtPreis = new javax.swing.JTextField();
        pnlRadioButton = new javax.swing.JPanel();
        rbtnMitarbeiter = new javax.swing.JRadioButton();
        rbtnZimmer = new javax.swing.JRadioButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        pnlMitarbeiter.setLayout(new java.awt.GridBagLayout());

        cmbBerechtigung.addItem("");
        cmbBerechtigung.addItem("Rezeption");
        cmbBerechtigung.addItem("Admin");
        cmbBerechtigung.addItem("Reinigung");
        cmbBerechtigung.setEditable(false);
        cmbBerechtigung.setMaximumSize(new java.awt.Dimension(110, 25));
        cmbBerechtigung.setMinimumSize(new java.awt.Dimension(110, 25));
        cmbBerechtigung.setOpaque(false);
        cmbBerechtigung.setPreferredSize(new java.awt.Dimension(125, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 21, 16);
        pnlMitarbeiter.add(cmbBerechtigung, gridBagConstraints);

        lblMitarbeiterNN.setText("Nachname");
        lblMitarbeiterNN.setMaximumSize(new java.awt.Dimension(95, 25));
        lblMitarbeiterNN.setMinimumSize(new java.awt.Dimension(95, 25));
        lblMitarbeiterNN.setPreferredSize(new java.awt.Dimension(95, 25));
        lblMitarbeiterNN.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlMitarbeiter.add(lblMitarbeiterNN, gridBagConstraints);

        txtMitarbeiterNN.setMaximumSize(new java.awt.Dimension(95, 25));
        txtMitarbeiterNN.setMinimumSize(new java.awt.Dimension(95, 25));
        txtMitarbeiterNN.setPreferredSize(new java.awt.Dimension(95, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlMitarbeiter.add(txtMitarbeiterNN, gridBagConstraints);

        lblMitarbeiterVN.setText("Vorname");
        lblMitarbeiterVN.setMaximumSize(new java.awt.Dimension(95, 25));
        lblMitarbeiterVN.setMinimumSize(new java.awt.Dimension(95, 25));
        lblMitarbeiterVN.setPreferredSize(new java.awt.Dimension(95, 25));
        lblMitarbeiterVN.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlMitarbeiter.add(lblMitarbeiterVN, gridBagConstraints);

        txtMitarbeiterVN.setMaximumSize(new java.awt.Dimension(95, 25));
        txtMitarbeiterVN.setMinimumSize(new java.awt.Dimension(95, 25));
        txtMitarbeiterVN.setPreferredSize(new java.awt.Dimension(95, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlMitarbeiter.add(txtMitarbeiterVN, gridBagConstraints);

        lblLogin.setText("Login");
        lblLogin.setMaximumSize(new java.awt.Dimension(95, 25));
        lblLogin.setMinimumSize(new java.awt.Dimension(95, 25));
        lblLogin.setPreferredSize(new java.awt.Dimension(95, 25));
        lblLogin.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlMitarbeiter.add(lblLogin, gridBagConstraints);

        txtLogin.setMaximumSize(new java.awt.Dimension(95, 25));
        txtLogin.setMinimumSize(new java.awt.Dimension(95, 25));
        txtLogin.setPreferredSize(new java.awt.Dimension(95, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlMitarbeiter.add(txtLogin, gridBagConstraints);

        lblPwd.setText("Passwort");
        lblPwd.setMaximumSize(new java.awt.Dimension(95, 25));
        lblPwd.setMinimumSize(new java.awt.Dimension(95, 25));
        lblPwd.setPreferredSize(new java.awt.Dimension(95, 25));
        lblPwd.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlMitarbeiter.add(lblPwd, gridBagConstraints);

        txtPwd.setMaximumSize(new java.awt.Dimension(95, 25));
        txtPwd.setMinimumSize(new java.awt.Dimension(95, 25));
        txtPwd.setPreferredSize(new java.awt.Dimension(95, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlMitarbeiter.add(txtPwd, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        getContentPane().add(pnlMitarbeiter, gridBagConstraints);

        cmdLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/logout.gif")));
        cmdLogout.setMnemonic('O');
        cmdLogout.setToolTipText("Ausloggen!");
        cmdLogout.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdLogout.setMinimumSize(new java.awt.Dimension(10, 30));
        cmdLogout.setOpaque(false);
        cmdLogout.setPreferredSize(new java.awt.Dimension(35, 30));
        cmdLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogoutActionPerformed(evt);
            }
        });

        pnlLogout.add(cmdLogout);

        cmdBeenden.setMnemonic('B');
        cmdBeenden.setText("Beenden");
        cmdBeenden.setToolTipText("Schlie\u00dft das Programm.");
        cmdBeenden.setPreferredSize(new java.awt.Dimension(75, 30));
        cmdBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBeendenActionPerformed(evt);
            }
        });

        pnlLogout.add(cmdBeenden);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 10);
        getContentPane().add(pnlLogout, gridBagConstraints);

        cmdNeu.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/neu.gif")));
        cmdNeu.setMnemonic('N');
        cmdNeu.setToolTipText("Klicken Sie  auf  \"Neu\" um neue Daten anzulegen!");
        cmdNeu.setPreferredSize(new java.awt.Dimension(35, 30));
        cmdNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNeuActionPerformed(evt);
            }
        });

        pnlTop.add(cmdNeu);

        cmdSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/suchen.gif")));
        cmdSuchen.setMnemonic('L');
        cmdSuchen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setOpaque(false);
        cmdSuchen.setPreferredSize(new java.awt.Dimension(35, 30));
        cmdSuchen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSuchenActionPerformed(evt);
            }
        });

        pnlTop.add(cmdSuchen);

        cmdSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/speichern.gif")));
        cmdSpeichern.setMnemonic('S');
        cmdSpeichern.setToolTipText("Klicken Sie hier um die ge\u00e4nderten Daten zu speichern!");
        cmdSpeichern.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSpeichern.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdSpeichern.setOpaque(false);
        cmdSpeichern.setPreferredSize(new java.awt.Dimension(35, 30));
        cmdSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSpeichernActionPerformed(evt);
            }
        });

        pnlTop.add(cmdSpeichern);

        cmdLoeschen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/loeschen.gif")));
        cmdLoeschen.setMnemonic('D');
        cmdLoeschen.setToolTipText("Klicken Sie  auf  \"L\u00f6schen\" um Daten zu l\u00f6schen!");
        cmdLoeschen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen.setOpaque(false);
        cmdLoeschen.setPreferredSize(new java.awt.Dimension(35, 30));
        cmdLoeschen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoeschenActionPerformed(evt);
            }
        });

        pnlTop.add(cmdLoeschen);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 20, 10);
        getContentPane().add(pnlTop, gridBagConstraints);

        pnlZimmer.setLayout(new java.awt.GridBagLayout());

        lblZimNr.setText("Zimmer");
        lblZimNr.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlZimmer.add(lblZimNr, gridBagConstraints);

        txtZimNr.setMaximumSize(new java.awt.Dimension(95, 25));
        txtZimNr.setMinimumSize(new java.awt.Dimension(95, 25));
        txtZimNr.setPreferredSize(new java.awt.Dimension(95, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlZimmer.add(txtZimNr, gridBagConstraints);

        lblBettenAnz.setText("Betten");
        lblBettenAnz.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlZimmer.add(lblBettenAnz, gridBagConstraints);

        txtBettenANz.setMaximumSize(new java.awt.Dimension(95, 25));
        txtBettenANz.setMinimumSize(new java.awt.Dimension(95, 25));
        txtBettenANz.setPreferredSize(new java.awt.Dimension(95, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlZimmer.add(txtBettenANz, gridBagConstraints);

        lblPreis.setText("Preis / Nacht");
        lblPreis.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlZimmer.add(lblPreis, gridBagConstraints);

        txtPreis.setMaximumSize(new java.awt.Dimension(95, 25));
        txtPreis.setMinimumSize(new java.awt.Dimension(95, 25));
        txtPreis.setPreferredSize(new java.awt.Dimension(95, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlZimmer.add(txtPreis, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 10, 33, 5);
        getContentPane().add(pnlZimmer, gridBagConstraints);

        rbtnGroup.add(rbtnMitarbeiter);
        rbtnMitarbeiter.setSelected(true);
        rbtnMitarbeiter.setText("Mitarbeiter bearbeiten");
        rbtnMitarbeiter.setActionCommand("mitarbeiter");
        pnlRadioButton.add(rbtnMitarbeiter);

        rbtnGroup.add(rbtnZimmer);
        rbtnZimmer.setActionCommand("zimmer");
        rbtnZimmer.setLabel("Zimmer bearbeiten");
        pnlRadioButton.add(rbtnZimmer);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        getContentPane().add(pnlRadioButton, gridBagConstraints);

        pack();
    }//GEN-END:initComponents

    
 
    
    private void cmdSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSpeichernActionPerformed
        
        boolean best�tigung = false;
        
        ButtonModel selected = rbtnGroup.getSelection();
        String selection = (selected.getActionCommand());
        
        if (selection.equals("mitarbeiter")){
            
            Integer berechtigung = new Integer(cmbBerechtigung.getSelectedIndex());

            String vname = txtMitarbeiterVN.getText();
            String nname = txtMitarbeiterNN.getText();
            String login = txtLogin.getText();
            String pwd = txtPwd.getText();
            
            if( berechtigung.intValue() == 0)
            helpMeldungen.showInformationMessage("Bitte w�hlen Sie eine " +
                    "Berechtigung aus!");
            else if( vname.equals("") )
                helpMeldungen.showInformationMessage("Bitte geben Sie einen " +
                        "Vornamen ein!");

            else if( nname.equals("") )
                helpMeldungen.showInformationMessage("Bitte geben Sie einen " +
                        "Nachnamen ein!");
            else if( login.equals("") )
                helpMeldungen.showInformationMessage("Bitte geben Sie einen " +
                        "Loginnamen ein!");
            else if( pwd.equals("") )
               helpMeldungen.showInformationMessage("Bitte geben Sie ein " +
                       "Passwort ein!");
            else {
                if(mitarbeiterNr == null) {

                     MitarbeiterHelper helper = new MitarbeiterHelper(db);
                     mitarbeiterNr = new Integer(helper.newMitarbNr().intValue()+1);
                     if (mitarbeiterNr == null) {
                         helpMeldungen.showErrorMessage("Es ist keine neue " +
                                 "Mitarbeiternr verf�gbar!");
                     }
                     else {
                         best�tigung = helper.setMitarbeiter(mitarbeiterNr, 
                             berechtigung, nname, vname, login, pwd, db);
                     }
                 }
                else {

                    MitarbeiterHelper helper = new MitarbeiterHelper(db);
                    best�tigung = helper.changeMitarbeiter(mitarbeiterNr, 
                         berechtigung, nname, vname, login, pwd);
                }

                if (best�tigung == false) {
                    helpMeldungen.showErrorMessage("Der Mitarbeiter konnte nicht " +
                            "gespeichert werden!");
                }
                else {
                    helpMeldungen.showInformationMessage("Der Mitarbeiter wurde " +
                            "gespeichert!");
                    cmdNeu.doClick();
                }
            }

        }
        
        if(selection.equals("zimmer")){
            
            zimmerNr = null;
            Integer betten = null;
            Float preis = null;   
            
             try {
                zimmerNr = Integer.valueOf( txtZimNr.getText() );
            } catch( NumberFormatException e ) {
                helpMeldungen.showErrorMessage("Bitte geben Sie eine Zahl " +
                        "in das Textfeld 'ZimmerNr' ein!");
                txtZimNr.setText("");
                return;
            }
            try {
                betten = Integer.valueOf( txtBettenANz.getText() );
            } catch( NumberFormatException e ) {
                helpMeldungen.showErrorMessage("Bitte geben Sie eine Zahl " +
                        "in das Textfeld 'Betten' ein!");
                txtBettenANz.setText("");
                return;
            }
         
             try {
                preis =Float.valueOf( txtPreis.getText() );
            } catch( NumberFormatException e ) {
                helpMeldungen.showErrorMessage("Bitte geben Sie eine Zahl " +
                        "in das Textfeld 'Preis' ein!");
                        txtPreis.setText("");
                return;
            }

             
             ZimmerHelper helper = new ZimmerHelper(db);
             best�tigung = helper.setZimmer(zimmerNr, betten, preis,db);
             
             if (best�tigung == false){
               best�tigung = helper.changeZimmer(zimmerNr, betten, preis);
             
                if (best�tigung == false){
                    helpMeldungen.showErrorMessage("Das Zimmer konnte nicht " +
                            "gespeichert werden!");
                }
             }
             if(best�tigung == true) {
                    helpMeldungen.showInformationMessage("Das Zimmer wurde " +
                        "gespeichert!");
                    cmdNeu.doClick();
             }
              
        }
        
    }//GEN-LAST:event_cmdSpeichernActionPerformed

    private void cmdBeendenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBeendenActionPerformed
         dbDisconnect();
        System.exit(0);
    }//GEN-LAST:event_cmdBeendenActionPerformed

    private void cmdSuchenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSuchenActionPerformed
  
        ButtonModel selected = rbtnGroup.getSelection();
        String selection = (selected.getActionCommand());
        
        if (selection.equals("mitarbeiter")){
            
            Integer berechtigung = new Integer(cmbBerechtigung.getSelectedIndex());
            String vname = txtMitarbeiterVN.getText();
            String nname = txtMitarbeiterNN.getText();
            String login = txtLogin.getText();
            String pwd = txtPwd.getText();
            
            if( berechtigung.intValue() == 0)
                        berechtigung = null;
            if( vname.equals("") )
                vname = null;
            if( nname.equals("") )
                nname = null;
            if( login.equals("") )
                login = null;
            if( pwd.equals("") )
                pwd = null;
            
            MitarbeiterHelper helper = new MitarbeiterHelper(db);
            Mitarbeiter[] mita = helper.getMitarbeiter(null, berechtigung, nname, 
                    vname, login, pwd);

            if( mita == null || mita.length == 0 ) {
                helpMeldungen.showErrorMessage("Es wurde kein Mitarbeiter gefunden!");
            }
            else if (mita.length == 1) {

                mitarbeiterNr = (mita[0].getMitarbeiterNr());
                cmbBerechtigung.setSelectedIndex((mita[0].getBerechtigungsNr()).intValue());
                txtMitarbeiterVN.setText(mita[0].getVorname());
                txtMitarbeiterNN.setText(mita[0].getNachname());
                txtLogin.setText(mita[0].getLogin());
                txtPwd.setText(mita[0].getPasswort());
            }
            else {
                helpMeldungen.showErrorMessage("Bitte grenzen Sie " +
                        "ihre Suche ein!");
            }   
            
            
        }
         
        if (selection.equals("zimmer")){
            zimmerNr = null;
            Integer betten = null;
            Float preis = null;
            
                     
             if( txtZimNr.getText().equals(""))
                zimmerNr = null;
             else
                zimmerNr = new Integer(txtZimNr.getText());
             if(txtBettenANz.getText().equals(""))
                betten = null;
             else
                betten = new Integer(txtBettenANz.getText());
            if(txtPreis.getText().equals(""))
                preis = null;
             else
                preis = new Float(txtPreis.getText());
         
            
            
            ZimmerHelper helper = new ZimmerHelper(db);
            Zimmer[] zim = helper.getZimmer(zimmerNr, betten, preis);

            if( zim == null || zim.length == 0 ) {
                helpMeldungen.showErrorMessage("Es wurde kein Zimmer gefunden!");
            }
            else if (zim.length == 1) {

                txtZimNr.setText(""+zim[0].getZimmerNr());
                txtBettenANz.setText(""+zim[0].getAnzahlBetten());
                txtPreis.setText(""+zim[0].getPreisProNacht());

            }
            else {
                helpMeldungen.showErrorMessage("Bitte grenzen Sie " +
                        "ihre Suche ein!");
            }    
        
        }
        
        

    }//GEN-LAST:event_cmdSuchenActionPerformed

    private void cmdNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNeuActionPerformed
        
        mitarbeiterNr = null;
        cmbBerechtigung.setSelectedIndex(0);        
        txtMitarbeiterVN.setText("");
        txtMitarbeiterNN.setText("");
        txtLogin.setText("");
        txtPwd.setText("");
        txtZimNr.setText("");
        txtBettenANz.setText("");
        txtPreis.setText("");
        
        zimmerNr = null;
        txtZimNr.setText("");
        txtBettenANz.setText("");
        txtPreis.setText("");
        
      
        
      
        
    }//GEN-LAST:event_cmdNeuActionPerformed

    private void cmdLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoeschenActionPerformed
       
        ButtonModel selected = rbtnGroup.getSelection();
        String selection = (selected.getActionCommand());
        
        if (selection.equals("mitarbeiter")){
        
            if(mitarbeiterNr == null){
                helpMeldungen.showErrorMessage("Sie m�ssen einen " +
                        "Datensatz ausw�hlen!");
            }
            else {
                String[] buttons = {"L�schen","Abbrechen"};
                boolean best�tigung = helpMeldungen.showOptionDialog1("M�chten " +
                        "Sie diesen Datensatz endg�ltig l�schen?",
                        "L�schen",buttons);

                if (best�tigung == true){
                    Integer[] mitarbNr = {mitarbeiterNr};
                    MitarbeiterHelper helper = new MitarbeiterHelper(db);
                    helper.delMitarbeiter(mitarbNr);
                    cmdNeu.doClick();
                }
            }
        }
        if (selection.equals("zimmer")) {
            if(zimmerNr == null) {
                helpMeldungen.showErrorMessage("Sie m�ssen einen " +
                        "Datensatz ausw�hlen!");
            }
            else {
                String[] buttons = {"L�schen","Abbrechen"};
                boolean best�tigung = helpMeldungen.showOptionDialog1("M�chten " +
                        "Sie diesen Datensatz endg�ltig l�schen?",
                        "L�schen",buttons);
                
                if (best�tigung == true){
                    Integer[] zimNr = {zimmerNr};
                    ZimmerHelper helper = new ZimmerHelper(db);
                    helper.delZimmer(zimNr);
                    cmdNeu.doClick();
                }
            }
        }
        
    }//GEN-LAST:event_cmdLoeschenActionPerformed

    private void cmdLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogoutActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new frmStart().setVisible(true);
    }//GEN-LAST:event_cmdLogoutActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdmin().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbBerechtigung;
    private javax.swing.JButton cmdBeenden;
    private javax.swing.JButton cmdLoeschen;
    private javax.swing.JButton cmdLogout;
    private javax.swing.JButton cmdNeu;
    private javax.swing.JButton cmdSpeichern;
    private javax.swing.JButton cmdSuchen;
    private javax.swing.JLabel lblBettenAnz;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblMitarbeiterNN;
    private javax.swing.JLabel lblMitarbeiterVN;
    private javax.swing.JLabel lblPreis;
    private javax.swing.JLabel lblPwd;
    private javax.swing.JLabel lblZimNr;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlMitarbeiter;
    private javax.swing.JPanel pnlRadioButton;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel pnlZimmer;
    private javax.swing.ButtonGroup rbtnGroup;
    private javax.swing.JRadioButton rbtnMitarbeiter;
    private javax.swing.JRadioButton rbtnZimmer;
    private javax.swing.JTextField txtBettenANz;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtMitarbeiterNN;
    private javax.swing.JTextField txtMitarbeiterVN;
    private javax.swing.JTextField txtPreis;
    private javax.swing.JTextField txtPwd;
    private javax.swing.JTextField txtZimNr;
    // End of variables declaration//GEN-END:variables
    
}
