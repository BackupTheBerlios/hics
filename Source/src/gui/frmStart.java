/*
 * frmStart.java
 *
 * Created on 21. April 2005, 14:16
 */

package gui;

import database.*;
import businesslogic.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author  Standard
 */
public class frmStart extends javax.swing.JFrame
{
    public static final int WIDTH  = 450;
    public static final int HEIGHT = 400;
    public static final String TITLE = "HICS - Login";
    
    /**
     * Erstellt ein neues Formular vom Typ frmStart.
     */
    public frmStart() {
        super(TITLE);
        initComponents();       
        setSize(WIDTH, HEIGHT);
        setLocation(((getToolkit().getScreenSize().width)/2)-(WIDTH/2),100);
        
        if( DatabaseManager.connect() == false ) {
            helpMeldungen.showErrorMessage(
              "Die Verbindung zur Datenbank konnte nicht hergestellt werden.");
            System.exit(1);
        }
        
        show();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        pnlStart = new javax.swing.JPanel();
        lblStart = new javax.swing.JLabel();
        lblStart1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblBenutzername = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        lblKennwort = new javax.swing.JLabel();
        pwdKennwort = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();
        cmdBeenden = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        pnlStart.setLayout(new java.awt.GridBagLayout());

        pnlStart.setMinimumSize(new java.awt.Dimension(200, 50));
        pnlStart.setOpaque(false);
        pnlStart.setPreferredSize(new java.awt.Dimension(450, 300));
        lblStart.setFont(new java.awt.Font("Arial", 0, 24));
        lblStart.setText("Herzlich willkommen bei HICS!");
        lblStart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 40, 21, 30);
        pnlStart.add(lblStart, gridBagConstraints);

        lblStart1.setFont(new java.awt.Font("Arial", 0, 18));
        lblStart1.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/Logo_klein.jpg")));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 130, 0, 0);
        pnlStart.add(lblStart1, gridBagConstraints);

        getContentPane().add(pnlStart, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(200, 50));
        jPanel1.setPreferredSize(new java.awt.Dimension(450, 100));
        lblBenutzername.setText("Benutzername");
        lblBenutzername.setMaximumSize(new java.awt.Dimension(100, 22));
        lblBenutzername.setMinimumSize(new java.awt.Dimension(100, 22));
        lblBenutzername.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel1.add(lblBenutzername, gridBagConstraints);

        txtUsername.setToolTipText("Tragen Sie hier Ihren Benutzenamen ein! Achten Sie auf Gro\u00df- und Kleinschreibung!");
        txtUsername.setMinimumSize(new java.awt.Dimension(11, 22));
        txtUsername.setNextFocusableComponent(pwdKennwort);
        txtUsername.setPreferredSize(new java.awt.Dimension(50, 22));
        txtUsername.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 69;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(txtUsername, gridBagConstraints);

        lblKennwort.setText("Kennwort");
        lblKennwort.setMaximumSize(new java.awt.Dimension(80, 16));
        lblKennwort.setMinimumSize(new java.awt.Dimension(80, 16));
        lblKennwort.setOpaque(true);
        lblKennwort.setPreferredSize(new java.awt.Dimension(100, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel1.add(lblKennwort, gridBagConstraints);

        pwdKennwort.setToolTipText("Geben Sie hier Ihr Kennwort ein!  Anstelle des Kennwortes erscheinen \"*\"-Zeichen.  Achten Sie auf Gro\u00df- und Kleinschreibung!");
        pwdKennwort.setNextFocusableComponent(cmdLogin);
        pwdKennwort.setPreferredSize(new java.awt.Dimension(50, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 69;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(pwdKennwort, gridBagConstraints);

        cmdLogin.setMnemonic('I');
        cmdLogin.setText("Login");
        cmdLogin.setToolTipText("Geben Sie Ihren Benutzernamen und Ihr Kennwort in die entsprechenden Felder ein und\n klicken Sie anschlie\u00dfend auf  \"Login\" um einzuloggen! \nAchten Sie auf Gro\u00df- und Kleinschreibung!");
        cmdLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        cmdLogin.setMaximumSize(new java.awt.Dimension(90, 23));
        cmdLogin.setMinimumSize(new java.awt.Dimension(90, 23));
        cmdLogin.setNextFocusableComponent(cmdBeenden);
        cmdLogin.setPreferredSize(new java.awt.Dimension(90, 23));
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });
        cmdLogin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdLoginKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel1.add(cmdLogin, gridBagConstraints);

        cmdBeenden.setMnemonic('B');
        cmdBeenden.setText("Beenden");
        cmdBeenden.setToolTipText("Schlie\u00dft das Programm.");
        cmdBeenden.setMaximumSize(new java.awt.Dimension(90, 23));
        cmdBeenden.setMinimumSize(new java.awt.Dimension(90, 23));
        cmdBeenden.setPreferredSize(new java.awt.Dimension(90, 23));
        cmdBeenden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quit(evt);
            }
        });
        cmdBeenden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cmdBeendenKeyPressed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel1.add(cmdBeenden, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void cmdBeendenKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdBeendenKeyPressed
        cmdBeenden.doClick();
    }//GEN-LAST:event_cmdBeendenKeyPressed

    private void cmdLoginKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cmdLoginKeyPressed
        cmdLogin.doClick();
    }//GEN-LAST:event_cmdLoginKeyPressed

    
    private void quit(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quit
        DatabaseManager.disconnect();
        System.exit(0);
    }//GEN-LAST:event_quit

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    
    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        
       
        
        if( DatabaseManager.db == null ) {
            helpMeldungen.showErrorMessage(
              "Ohne Datenbankverbindung kann kein Login erfolgen.");
        }
        
        String login = txtUsername.getText();
        String passwort = new String(pwdKennwort.getPassword());
        MitarbeiterHelper helper = new MitarbeiterHelper(DatabaseManager.db);
        Mitarbeiter mitarbeiter = helper.getMitarbeiter( login, passwort );
        Session.mitarbeiter = mitarbeiter;
        int berechtigung = helper.getMitarbeiterBerechtigung(mitarbeiter);
        
        if( berechtigung == MitarbeiterHelper.BERECHTIGUNG_REINIGUNG ) {
          this.dispose();
          new frmAufgabenAnzeigen().setVisible(true);
        }
        else if( berechtigung == MitarbeiterHelper.BERECHTIGUNG_ADMIN ) {
          this.dispose();
          new frmAdmin().setVisible(true);
        }
        else if( berechtigung == MitarbeiterHelper.BERECHTIGUNG_REZEPTION ) {
           this.dispose();
           new frmZimmerplan().setVisible(true);
        }
        else {
          helpMeldungen.showErrorMessage("Falscher Benutzername oder falsches Passwort!");
        }
        
        
    }//GEN-LAST:event_cmdLoginActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmStart().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdBeenden;
    private javax.swing.JButton cmdLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblBenutzername;
    private javax.swing.JLabel lblKennwort;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblStart1;
    private javax.swing.JPanel pnlStart;
    private javax.swing.JPasswordField pwdKennwort;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
  
    
    
}
