/*
 * frmAdmindaten.java
 *
 * Created on 26. Mai 2005, 01:41
 */

package gui;

/**
 *
 * @author  TuBa
 */
public class frmAdmindaten extends javax.swing.JFrame {
    
    public static int WIDTH=500;
    public static int HEIGHT=400;
    public static String TITLE="HICS - Personendaten";
    
    /** Creates new form Anzeige */
    public frmAdmindaten() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        cmdSuchen = new javax.swing.JButton();
        cmdSpeichern = new javax.swing.JButton();
        cmdZurueck = new javax.swing.JButton();
        cmdLoeschen = new javax.swing.JButton();
        cmdAbbrechen = new javax.swing.JButton();
        cmdNeu = new javax.swing.JButton();
        lblSVNr = new javax.swing.JLabel();
        txtSVNr = new javax.swing.JTextField();
        lblKundenNN = new javax.swing.JLabel();
        txtKundeNN = new javax.swing.JTextField();
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
        jPanel2 = new javax.swing.JPanel();
        cmdLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setBorder(new javax.swing.border.EtchedBorder());
        cmdSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/suchen.gif")));
        cmdSuchen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setMinimumSize(new java.awt.Dimension(10, 25));
        cmdSuchen.setPreferredSize(new java.awt.Dimension(35, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(cmdSuchen, gridBagConstraints);

        cmdSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/speichern.gif")));
        cmdSpeichern.setToolTipText("Speichert Daten!");
        cmdSpeichern.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSpeichern.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdSpeichern.setPreferredSize(new java.awt.Dimension(35, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(cmdSpeichern, gridBagConstraints);

        cmdZurueck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/zurueck.gif")));
        cmdZurueck.setToolTipText("Das lezte Window wird ge\u00f6ffnet!");
        cmdZurueck.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdZurueck.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdZurueck.setPreferredSize(new java.awt.Dimension(35, 30));
        cmdZurueck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdZurueckActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(cmdZurueck, gridBagConstraints);

        cmdLoeschen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/loeschen.gif")));
        cmdLoeschen.setToolTipText("L\u00f6scht Daten!");
        cmdLoeschen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen.setPreferredSize(new java.awt.Dimension(35, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(cmdLoeschen, gridBagConstraints);

        cmdAbbrechen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/abbrechen.gif")));
        cmdAbbrechen.setToolTipText("\u00c4nderungen werden r\u00fcckg\u00e4ngig gemacht!");
        cmdAbbrechen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdAbbrechen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdAbbrechen.setPreferredSize(new java.awt.Dimension(35, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(cmdAbbrechen, gridBagConstraints);

        cmdNeu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/neu.gif")));
        cmdNeu.setToolTipText("Neue Daten werden angelegt!");
        cmdNeu.setPreferredSize(new java.awt.Dimension(35, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(cmdNeu, gridBagConstraints);

        lblSVNr.setText("SVNr");
        lblSVNr.setMaximumSize(new java.awt.Dimension(95, 25));
        lblSVNr.setMinimumSize(new java.awt.Dimension(95, 25));
        lblSVNr.setPreferredSize(new java.awt.Dimension(95, 25));
        lblSVNr.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(21, 0, 0, 0);
        jPanel1.add(lblSVNr, gridBagConstraints);

        txtSVNr.setText("SVNr");
        txtSVNr.setMaximumSize(new java.awt.Dimension(95, 25));
        txtSVNr.setMinimumSize(new java.awt.Dimension(95, 25));
        txtSVNr.setPreferredSize(new java.awt.Dimension(95, 25));
        txtSVNr.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 0, 0, 0);
        jPanel1.add(txtSVNr, gridBagConstraints);

        lblKundenNN.setText("Nachname");
        lblKundenNN.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKundenNN.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKundenNN.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKundenNN.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lblKundenNN, gridBagConstraints);

        txtKundeNN.setText("Nachname");
        txtKundeNN.setMaximumSize(new java.awt.Dimension(95, 25));
        txtKundeNN.setMinimumSize(new java.awt.Dimension(95, 25));
        txtKundeNN.setPreferredSize(new java.awt.Dimension(95, 25));
        txtKundeNN.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(txtKundeNN, gridBagConstraints);

        lblKundenVN.setText("Vorname");
        lblKundenVN.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lblKundenVN, gridBagConstraints);

        txtKundenVN.setText("Vorname");
        txtKundenVN.setMaximumSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setMinimumSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setPreferredSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel1.add(txtKundenVN, gridBagConstraints);

        txtLand.setText("A");
        txtLand.setMaximumSize(new java.awt.Dimension(95, 25));
        txtLand.setMinimumSize(new java.awt.Dimension(95, 25));
        txtLand.setPreferredSize(new java.awt.Dimension(95, 25));
        txtLand.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(txtLand, gridBagConstraints);

        lblBundesland.setText("Bundesland");
        lblBundesland.setMaximumSize(new java.awt.Dimension(95, 25));
        lblBundesland.setMinimumSize(new java.awt.Dimension(95, 25));
        lblBundesland.setPreferredSize(new java.awt.Dimension(95, 25));
        lblBundesland.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lblBundesland, gridBagConstraints);

        txtBundesland.setText("Bundesland");
        txtBundesland.setMaximumSize(new java.awt.Dimension(95, 25));
        txtBundesland.setMinimumSize(new java.awt.Dimension(95, 25));
        txtBundesland.setPreferredSize(new java.awt.Dimension(95, 25));
        txtBundesland.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(txtBundesland, gridBagConstraints);

        lblPLZ.setText("Land - PLZ");
        lblPLZ.setMaximumSize(new java.awt.Dimension(95, 25));
        lblPLZ.setMinimumSize(new java.awt.Dimension(95, 25));
        lblPLZ.setPreferredSize(new java.awt.Dimension(95, 25));
        lblPLZ.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lblPLZ, gridBagConstraints);

        txtPLZ.setText("PLZ");
        txtPLZ.setMaximumSize(new java.awt.Dimension(95, 25));
        txtPLZ.setMinimumSize(new java.awt.Dimension(95, 25));
        txtPLZ.setPreferredSize(new java.awt.Dimension(95, 25));
        txtPLZ.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(txtPLZ, gridBagConstraints);

        lblStrasse.setText("Strasse");
        lblStrasse.setMaximumSize(new java.awt.Dimension(95, 25));
        lblStrasse.setMinimumSize(new java.awt.Dimension(95, 25));
        lblStrasse.setPreferredSize(new java.awt.Dimension(95, 25));
        lblStrasse.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lblStrasse, gridBagConstraints);

        txtStrasse.setText("Strasse");
        txtStrasse.setMaximumSize(new java.awt.Dimension(95, 25));
        txtStrasse.setMinimumSize(new java.awt.Dimension(95, 25));
        txtStrasse.setPreferredSize(new java.awt.Dimension(95, 25));
        txtStrasse.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(txtStrasse, gridBagConstraints);

        lblHausStiegeTuer.setText("Nr/Stiege/Tuer");
        lblHausStiegeTuer.setMaximumSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setMinimumSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setPreferredSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(lblHausStiegeTuer, gridBagConstraints);

        txtHaus.setText("Nr/Stiege/Tuer");
        txtHaus.setMaximumSize(new java.awt.Dimension(95, 25));
        txtHaus.setMinimumSize(new java.awt.Dimension(95, 25));
        txtHaus.setPreferredSize(new java.awt.Dimension(95, 25));
        txtHaus.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(txtHaus, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBorder(new javax.swing.border.EtchedBorder());
        cmdLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/logout.gif")));
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

        jPanel2.add(cmdLogout);

        getContentPane().add(jPanel2, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void cmdLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogoutActionPerformed
        // TODO add your handling code here:
        this.hide();
        new frmStart().setVisible(true);
    }//GEN-LAST:event_cmdLogoutActionPerformed

    private void cmdZurueckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdZurueckActionPerformed
        // TODO add your handling code here:
        this.hide();
        new frmDaten1().setVisible(true);    
    }//GEN-LAST:event_cmdZurueckActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdmindaten().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAbbrechen;
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
    private javax.swing.JLabel lblPLZ;
    private javax.swing.JLabel lblSVNr;
    private javax.swing.JLabel lblStrasse;
    private javax.swing.JTextField txtBundesland;
    private javax.swing.JTextField txtHaus;
    private javax.swing.JTextField txtKundeNN;
    private javax.swing.JTextField txtKundenVN;
    private javax.swing.JTextField txtLand;
    private javax.swing.JTextField txtPLZ;
    private javax.swing.JTextField txtSVNr;
    private javax.swing.JTextField txtStrasse;
    // End of variables declaration//GEN-END:variables
    
}
