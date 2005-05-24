/*
 * Anzeige.java
 *
 * Created on 26. April 2005, 13:38
 */

package gui;

/**
 *
 * @author  Standard
 */
public class frmKundendaten extends javax.swing.JFrame {
    public static int WIDTH=450;
    public static int HEIGHT=350;
    public static String TITLE="HICS - Kundendaten";
    
    /** Creates new form Anzeige */
    public frmKundendaten() {
        super(TITLE);
        initComponents();
        setSize(WIDTH, HEIGHT);
        show();
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        cmdSuchen = new javax.swing.JButton();
        cmdSpeichern = new javax.swing.JButton();
        cmdZurueck = new javax.swing.JButton();
        cmbDaten = new javax.swing.JComboBox();
        cmdBearbeiten = new javax.swing.JButton();
        cmdLoeschen = new javax.swing.JButton();
        cmdAbbrechen = new javax.swing.JButton();
        cmdNeu = new javax.swing.JButton();
        lblKundennr = new javax.swing.JLabel();
        txtKundennr = new javax.swing.JTextField();
        lblKundenNN = new javax.swing.JLabel();
        txtZimmer1 = new javax.swing.JTextField();
        lblKundenVN = new javax.swing.JLabel();
        txtKundenVN = new javax.swing.JTextField();
        txtLand = new javax.swing.JTextField();
        lblBundesland = new javax.swing.JLabel();
        txtBundesland = new javax.swing.JTextField();
        lblPLZ = new javax.swing.JLabel();
        txtPLZ = new javax.swing.JTextField();
        lblStrasse = new javax.swing.JLabel();
        txtStrasse = new javax.swing.JTextField();
        lblHausStiegeTuer = new javax.swing.JLabel();
        txtHaus = new javax.swing.JTextField();
        txtStiege = new javax.swing.JTextField();
        txtTuer = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        cmdLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.EtchedBorder());
        cmdSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/suchen.gif")));
        cmdSuchen.setText("Suchen");
        cmdSuchen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setPreferredSize(new java.awt.Dimension(125, 30));
        jPanel1.add(cmdSuchen, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        cmdSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/speichern.gif")));
        cmdSpeichern.setText("Speichern");
        cmdSpeichern.setToolTipText("Klicken Sie hier um die ge\u00e4nderten Daten zu speichern!");
        cmdSpeichern.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSpeichern.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdSpeichern.setPreferredSize(new java.awt.Dimension(125, 30));
        jPanel1.add(cmdSpeichern, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 50, -1, -1));

        cmdZurueck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/zurueck.gif")));
        cmdZurueck.setText("Zurueck");
        cmdZurueck.setToolTipText("Klicken Sie  auf  \"Zurueck\" um wieder auf den vorigen Bildschirm zu gelangen!");
        cmdZurueck.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdZurueck.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdZurueck.setPreferredSize(new java.awt.Dimension(125, 30));
        cmdZurueck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdZurueckActionPerformed(evt);
            }
        });

        jPanel1.add(cmdZurueck, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 210, -1, -1));

        cmbDaten.setMaximumSize(new java.awt.Dimension(110, 25));
        cmbDaten.setMinimumSize(new java.awt.Dimension(110, 25));
        cmbDaten.setPreferredSize(new java.awt.Dimension(125, 30));
        cmbDaten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDatenActionPerformed(evt);
            }
        });

        jPanel1.add(cmbDaten, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cmdBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/bearbeiten.gif")));
        cmdBearbeiten.setText("Bearbeiten");
        cmdBearbeiten.setToolTipText("Klicken Sie hier um Kundendaten zu bearbeiten!\nKlicken Sie anschlie\u00dfend auf  \"Speichern\" um die \u00c4nderungen zu speichern!\nKlicken Sie anschlie\u00dfend auf  \"Abbrechen\" um die \u00c4nderungen nicht zu speichern!");
        cmdBearbeiten.setPreferredSize(new java.awt.Dimension(125, 30));
        jPanel1.add(cmdBearbeiten, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 10, -1, -1));

        cmdLoeschen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/loeschen.gif")));
        cmdLoeschen.setText("Loeschen");
        cmdLoeschen.setToolTipText("Klicken Sie  auf  \"L\u00f6schen\" um Kundendaten zu l\u00f6schen!");
        cmdLoeschen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen.setPreferredSize(new java.awt.Dimension(125, 30));
        jPanel1.add(cmdLoeschen, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 90, -1, -1));

        cmdAbbrechen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/abbrechen.gif")));
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

        jPanel1.add(cmdAbbrechen, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 130, -1, -1));

        cmdNeu.setText("Neu");
        cmdNeu.setToolTipText("Klicken Sie  auf  \"Neu\" um Kundendaten anzulegen!");
        cmdNeu.setPreferredSize(new java.awt.Dimension(125, 30));
        jPanel1.add(cmdNeu, new org.netbeans.lib.awtextra.AbsoluteConstraints(275, 170, -1, -1));

        lblKundennr.setText("Kundennr");
        lblKundennr.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKundennr.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKundennr.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKundennr.setRequestFocusEnabled(false);
        jPanel1.add(lblKundennr, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtKundennr.setText("Kundennr");
        txtKundennr.setMaximumSize(new java.awt.Dimension(95, 25));
        txtKundennr.setMinimumSize(new java.awt.Dimension(95, 25));
        txtKundennr.setPreferredSize(new java.awt.Dimension(95, 25));
        txtKundennr.setRequestFocusEnabled(false);
        jPanel1.add(txtKundennr, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 130, -1));

        lblKundenNN.setText("Nachname");
        lblKundenNN.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKundenNN.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKundenNN.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKundenNN.setRequestFocusEnabled(false);
        jPanel1.add(lblKundenNN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        txtZimmer1.setText("Nachname");
        txtZimmer1.setMaximumSize(new java.awt.Dimension(95, 25));
        txtZimmer1.setMinimumSize(new java.awt.Dimension(95, 25));
        txtZimmer1.setPreferredSize(new java.awt.Dimension(95, 25));
        txtZimmer1.setRequestFocusEnabled(false);
        jPanel1.add(txtZimmer1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 130, -1));

        lblKundenVN.setText("Vorname");
        lblKundenVN.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setRequestFocusEnabled(false);
        jPanel1.add(lblKundenVN, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        txtKundenVN.setText("Vorname");
        txtKundenVN.setMaximumSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setMinimumSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setPreferredSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setRequestFocusEnabled(false);
        jPanel1.add(txtKundenVN, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 130, -1));

        txtLand.setText("A");
        txtLand.setMaximumSize(new java.awt.Dimension(95, 25));
        txtLand.setMinimumSize(new java.awt.Dimension(95, 25));
        txtLand.setPreferredSize(new java.awt.Dimension(95, 25));
        txtLand.setRequestFocusEnabled(false);
        jPanel1.add(txtLand, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 40, -1));

        lblBundesland.setText("Bundesland");
        lblBundesland.setMaximumSize(new java.awt.Dimension(95, 25));
        lblBundesland.setMinimumSize(new java.awt.Dimension(95, 25));
        lblBundesland.setPreferredSize(new java.awt.Dimension(95, 25));
        lblBundesland.setRequestFocusEnabled(false);
        jPanel1.add(lblBundesland, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtBundesland.setText("Bundesland");
        txtBundesland.setMaximumSize(new java.awt.Dimension(95, 25));
        txtBundesland.setMinimumSize(new java.awt.Dimension(95, 25));
        txtBundesland.setPreferredSize(new java.awt.Dimension(95, 25));
        txtBundesland.setRequestFocusEnabled(false);
        jPanel1.add(txtBundesland, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 130, -1));

        lblPLZ.setText("Land - PLZ");
        lblPLZ.setMaximumSize(new java.awt.Dimension(95, 25));
        lblPLZ.setMinimumSize(new java.awt.Dimension(95, 25));
        lblPLZ.setPreferredSize(new java.awt.Dimension(95, 25));
        lblPLZ.setRequestFocusEnabled(false);
        jPanel1.add(lblPLZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtPLZ.setText("PLZ");
        txtPLZ.setMaximumSize(new java.awt.Dimension(95, 25));
        txtPLZ.setMinimumSize(new java.awt.Dimension(95, 25));
        txtPLZ.setPreferredSize(new java.awt.Dimension(95, 25));
        txtPLZ.setRequestFocusEnabled(false);
        jPanel1.add(txtPLZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 90, -1));

        lblStrasse.setText("Strasse");
        lblStrasse.setMaximumSize(new java.awt.Dimension(95, 25));
        lblStrasse.setMinimumSize(new java.awt.Dimension(95, 25));
        lblStrasse.setPreferredSize(new java.awt.Dimension(95, 25));
        lblStrasse.setRequestFocusEnabled(false);
        jPanel1.add(lblStrasse, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtStrasse.setText("Strasse");
        txtStrasse.setMaximumSize(new java.awt.Dimension(95, 25));
        txtStrasse.setMinimumSize(new java.awt.Dimension(95, 25));
        txtStrasse.setPreferredSize(new java.awt.Dimension(95, 25));
        txtStrasse.setRequestFocusEnabled(false);
        jPanel1.add(txtStrasse, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 130, -1));

        lblHausStiegeTuer.setText("Haus-Stiege-Tuer");
        lblHausStiegeTuer.setMaximumSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setMinimumSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setPreferredSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setRequestFocusEnabled(false);
        jPanel1.add(lblHausStiegeTuer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 110, -1));

        txtHaus.setText("Haus");
        txtHaus.setMaximumSize(new java.awt.Dimension(95, 25));
        txtHaus.setMinimumSize(new java.awt.Dimension(95, 25));
        txtHaus.setPreferredSize(new java.awt.Dimension(95, 25));
        txtHaus.setRequestFocusEnabled(false);
        txtHaus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHausActionPerformed(evt);
            }
        });

        jPanel1.add(txtHaus, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 40, -1));

        txtStiege.setText("Stiege");
        txtStiege.setMaximumSize(new java.awt.Dimension(95, 25));
        txtStiege.setMinimumSize(new java.awt.Dimension(95, 25));
        txtStiege.setPreferredSize(new java.awt.Dimension(95, 25));
        txtStiege.setRequestFocusEnabled(false);
        jPanel1.add(txtStiege, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 50, -1));

        txtTuer.setText("Tuer");
        txtTuer.setMaximumSize(new java.awt.Dimension(95, 25));
        txtTuer.setMinimumSize(new java.awt.Dimension(95, 25));
        txtTuer.setPreferredSize(new java.awt.Dimension(95, 25));
        txtTuer.setRequestFocusEnabled(false);
        jPanel1.add(txtTuer, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 40, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(new javax.swing.border.EtchedBorder());
        cmdLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/logout.gif")));
        cmdLogout.setText("Ausloggen");
        cmdLogout.setToolTipText("Klicken Sie  auf  \"Ausloggen\" um wieder auf den Startbildschim zu gelangen!");
        cmdLogout.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdLogout.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdLogout.setPreferredSize(new java.awt.Dimension(125, 30));
        cmdLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogoutActionPerformed(evt);
            }
        });

        jPanel2.add(cmdLogout);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void cmdZurueckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdZurueckActionPerformed
        // TODO add your handling code here:
        this.hide();
        new frmDaten().setVisible(true);
    }//GEN-LAST:event_cmdZurueckActionPerformed

    private void cmdLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogoutActionPerformed
        // TODO add your handling code here:
        this.hide();
        new frmStart().setVisible(true);
    }//GEN-LAST:event_cmdLogoutActionPerformed

    private void txtHausActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHausActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHausActionPerformed

    private void cmdAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAbbrechenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdAbbrechenActionPerformed

    private void cmbDatenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDatenActionPerformed
        // TODO add your handling code here:
        cmbDaten.addItem("Mitarbeiter");
        cmbDaten.addItem("Kunde");
        cmbDaten.addItem("Reservierung");
        cmbDaten.addItem("Notiz");
        cmbDaten.setEditable(false);
        //cmbDaten.addActionListener(ComboAddHandler);
    }//GEN-LAST:event_cmbDatenActionPerformed

   /* public class ComboAddHandler implements ActionListener {
        
    }*/
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAnzeige().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbDaten;
    private javax.swing.JButton cmdAbbrechen;
    private javax.swing.JButton cmdBearbeiten;
    private javax.swing.JButton cmdLoeschen;
    private javax.swing.JButton cmdLogout;
    private javax.swing.JButton cmdNeu;
    private javax.swing.JButton cmdSpeichern;
    private javax.swing.JButton cmdSuchen;
    private javax.swing.JButton cmdZurueck;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBundesland;
    private javax.swing.JLabel lblHausStiegeTuer;
    private javax.swing.JLabel lblKundenNN;
    private javax.swing.JLabel lblKundenVN;
    private javax.swing.JLabel lblKundennr;
    private javax.swing.JLabel lblPLZ;
    private javax.swing.JLabel lblStrasse;
    private javax.swing.JTextField txtBundesland;
    private javax.swing.JTextField txtHaus;
    private javax.swing.JTextField txtKundenVN;
    private javax.swing.JTextField txtKundennr;
    private javax.swing.JTextField txtLand;
    private javax.swing.JTextField txtPLZ;
    private javax.swing.JTextField txtStiege;
    private javax.swing.JTextField txtStrasse;
    private javax.swing.JTextField txtTuer;
    private javax.swing.JTextField txtZimmer1;
    // End of variables declaration//GEN-END:variables
    
}