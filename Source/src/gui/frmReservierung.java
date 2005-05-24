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
public class frmReservierung extends javax.swing.JFrame {
    public static int WIDTH=450;
    public static int HEIGHT=350;
    public static String TITLE="HICS - Reservierung";
    
    /** Creates new form Anzeige */
    public frmReservierung() {
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
        jPanel1 = new javax.swing.JPanel();
        cmdNotiz = new javax.swing.JButton();
        cmdReservierung = new javax.swing.JButton();
        cmdKunde = new javax.swing.JButton();
        cmdZurueck = new javax.swing.JButton();
        lblAnkunft = new javax.swing.JLabel();
        txtAnkunft = new javax.swing.JTextField();
        lblAbreise = new javax.swing.JLabel();
        txtAbreise = new javax.swing.JTextField();
        lblZimmer = new javax.swing.JLabel();
        txtZimmer = new javax.swing.JTextField();
        lblKunde = new javax.swing.JLabel();
        txtKundennr = new javax.swing.JTextField();
        cmdBearbeiten = new javax.swing.JButton();
        cmdSpeichern = new javax.swing.JButton();
        cmdLoeschen = new javax.swing.JButton();
        cmdAbbrechen = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        cmdLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(new javax.swing.border.EtchedBorder());
        cmdNotiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/info.gif")));
        cmdNotiz.setText("Notiz");
        cmdNotiz.setToolTipText("Klicken Sie hier um eine Info zu erstellen!");
        cmdNotiz.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdNotiz.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdNotiz.setPreferredSize(new java.awt.Dimension(125, 30));
        cmdNotiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNotizActionPerformed(evt);
            }
        });

        jPanel1.add(cmdNotiz, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 90, -1));

        cmdReservierung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/reservierung.gif")));
        cmdReservierung.setText("Reservierung");
        cmdReservierung.setToolTipText("Klicken Sie hier um eine Reservierung zu duchzuf\u00fchren!");
        cmdReservierung.setMaximumSize(new java.awt.Dimension(110, 25));
        cmdReservierung.setMinimumSize(new java.awt.Dimension(110, 25));
        cmdReservierung.setPreferredSize(new java.awt.Dimension(140, 30));
        jPanel1.add(cmdReservierung, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        cmdKunde.setText("Kundendaten");
        cmdKunde.setToolTipText("Klicken Sie hier um nach Kundendaten zu suchen!");
        cmdKunde.setMaximumSize(new java.awt.Dimension(110, 25));
        cmdKunde.setMinimumSize(new java.awt.Dimension(110, 25));
        cmdKunde.setPreferredSize(new java.awt.Dimension(125, 30));
        cmdKunde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdKundeActionPerformed(evt);
            }
        });

        jPanel1.add(cmdKunde, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, -1, -1));

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

        jPanel1.add(cmdZurueck, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, -1, -1));

        lblAnkunft.setText("Ankunft");
        lblAnkunft.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAnkunft.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAnkunft.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAnkunft.setRequestFocusEnabled(false);
        jPanel1.add(lblAnkunft, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        txtAnkunft.setText("Ankunft");
        txtAnkunft.setMaximumSize(new java.awt.Dimension(95, 25));
        txtAnkunft.setMinimumSize(new java.awt.Dimension(95, 25));
        txtAnkunft.setPreferredSize(new java.awt.Dimension(95, 25));
        txtAnkunft.setRequestFocusEnabled(false);
        jPanel1.add(txtAnkunft, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 90, 130, -1));

        lblAbreise.setText("Abreise");
        lblAbreise.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAbreise.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAbreise.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAbreise.setRequestFocusEnabled(false);
        jPanel1.add(lblAbreise, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        txtAbreise.setText("Abreise");
        txtAbreise.setMaximumSize(new java.awt.Dimension(95, 25));
        txtAbreise.setMinimumSize(new java.awt.Dimension(95, 25));
        txtAbreise.setPreferredSize(new java.awt.Dimension(95, 25));
        txtAbreise.setRequestFocusEnabled(false);
        jPanel1.add(txtAbreise, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 130, 130, -1));

        lblZimmer.setText("Zimmer");
        lblZimmer.setMaximumSize(new java.awt.Dimension(95, 25));
        lblZimmer.setMinimumSize(new java.awt.Dimension(95, 25));
        lblZimmer.setPreferredSize(new java.awt.Dimension(95, 25));
        lblZimmer.setRequestFocusEnabled(false);
        jPanel1.add(lblZimmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        txtZimmer.setText("Zimmer");
        txtZimmer.setMaximumSize(new java.awt.Dimension(95, 25));
        txtZimmer.setMinimumSize(new java.awt.Dimension(95, 25));
        txtZimmer.setPreferredSize(new java.awt.Dimension(95, 25));
        txtZimmer.setRequestFocusEnabled(false);
        txtZimmer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtZimmerActionPerformed(evt);
            }
        });

        jPanel1.add(txtZimmer, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 170, 130, -1));

        lblKunde.setText("Kundennr");
        lblKunde.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKunde.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKunde.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKunde.setRequestFocusEnabled(false);
        jPanel1.add(lblKunde, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        txtKundennr.setText("Kundennr");
        txtKundennr.setMaximumSize(new java.awt.Dimension(95, 25));
        txtKundennr.setMinimumSize(new java.awt.Dimension(95, 25));
        txtKundennr.setPreferredSize(new java.awt.Dimension(95, 25));
        txtKundennr.setRequestFocusEnabled(false);
        jPanel1.add(txtKundennr, new org.netbeans.lib.awtextra.AbsoluteConstraints(115, 50, 130, -1));

        cmdBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/bearbeiten.gif")));
        cmdBearbeiten.setText("Bearbeiten");
        cmdBearbeiten.setToolTipText("Klicken Sie hier um eine Reservierung zu bearbeiten!\nKlicken Sie anschlie\u00dfend auf  \"Speichern\" um die \u00c4nderungen zu speichern!\nKlicken Sie anschlie\u00dfend auf  \"Abbrechen\" um die \u00c4nderungen nicht zu speichern!");
        cmdBearbeiten.setPreferredSize(new java.awt.Dimension(125, 30));
        jPanel1.add(cmdBearbeiten, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        cmdSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/speichern.gif")));
        cmdSpeichern.setText("Speichern");
        cmdSpeichern.setToolTipText("Klicken Sie hier um die ge\u00e4nderten Daten zu speichern!");
        cmdSpeichern.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSpeichern.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdSpeichern.setPreferredSize(new java.awt.Dimension(125, 30));
        cmdSpeichern.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdSpeichernActionPerformed(evt);
            }
        });

        jPanel1.add(cmdSpeichern, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, -1, -1));

        cmdLoeschen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/loeschen.gif")));
        cmdLoeschen.setText("Loeschen");
        cmdLoeschen.setToolTipText("Klicken Sie  auf  \"L\u00f6schen\" um die Reservierung zu l\u00f6schen!");
        cmdLoeschen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen.setPreferredSize(new java.awt.Dimension(125, 30));
        jPanel1.add(cmdLoeschen, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, -1, -1));

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

        jPanel1.add(cmdAbbrechen, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

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
        jPanel2.getAccessibleContext().setAccessibleParent(this);

        pack();
    }//GEN-END:initComponents

    private void cmdAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAbbrechenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdAbbrechenActionPerformed

    private void cmdSpeichernActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdSpeichernActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmdSpeichernActionPerformed

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

    private void cmdKundeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdKundeActionPerformed
        // TODO add your handling code here:
        new frmKundendaten().setVisible(true);
    }//GEN-LAST:event_cmdKundeActionPerformed

    private void txtZimmerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtZimmerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtZimmerActionPerformed

    private void cmdNotizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNotizActionPerformed
        // TODO add your handling code here:
        this.hide();
        new frmInfo().setVisible(true);
    }//GEN-LAST:event_cmdNotizActionPerformed
    
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
    private javax.swing.JButton cmdAbbrechen;
    private javax.swing.JButton cmdBearbeiten;
    private javax.swing.JButton cmdKunde;
    private javax.swing.JButton cmdLoeschen;
    private javax.swing.JButton cmdLogout;
    private javax.swing.JButton cmdNotiz;
    private javax.swing.JButton cmdReservierung;
    private javax.swing.JButton cmdSpeichern;
    private javax.swing.JButton cmdZurueck;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAbreise;
    private javax.swing.JLabel lblAnkunft;
    private javax.swing.JLabel lblKunde;
    private javax.swing.JLabel lblZimmer;
    private javax.swing.JTextField txtAbreise;
    private javax.swing.JTextField txtAnkunft;
    private javax.swing.JTextField txtKundennr;
    private javax.swing.JTextField txtZimmer;
    // End of variables declaration//GEN-END:variables
    
}