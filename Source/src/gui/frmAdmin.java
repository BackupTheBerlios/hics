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
public class frmAdmin extends javax.swing.JFrame {
    
   public static String TITLE="HICS - Personendaten";
    
    /** Creates new form Anzeige */
    public frmAdmin() {
        super(TITLE);
        initComponents();
        setSize(getToolkit().getScreenSize());
        show();
    }
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

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
        pnlTop = new javax.swing.JPanel();
        cmdNeu = new javax.swing.JButton();
        cmdSuchen = new javax.swing.JButton();
        cmdSpeichern = new javax.swing.JButton();
        cmdLoeschen = new javax.swing.JButton();
        cmdAbbrechen = new javax.swing.JButton();
        pnlZimmer = new javax.swing.JPanel();
        lblZimNr = new javax.swing.JLabel();
        txtZimNr = new javax.swing.JTextField();
        lblBettenAnz = new javax.swing.JLabel();
        txtBettenANz = new javax.swing.JTextField();
        lblPreis = new javax.swing.JLabel();
        txtPreis = new javax.swing.JTextField();
        lblAusstattung = new javax.swing.JLabel();
        lstAusstattung = new javax.swing.JList();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        pnlMitarbeiter.setLayout(new java.awt.GridBagLayout());

        cmbBerechtigung.addItem("Rezeption");
        cmbBerechtigung.addItem("Raumpflege");
        cmbBerechtigung.addItem("Admin");
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

        lblLogin.setText("Passwort");
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
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 10);
        getContentPane().add(pnlMitarbeiter, gridBagConstraints);

        cmdLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/logout.gif")));
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 10, 10);
        getContentPane().add(pnlLogout, gridBagConstraints);

        cmdNeu.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/neu.gif")));
        cmdNeu.setToolTipText("Klicken Sie  auf  \"Neu\" um neue Daten anzulegen!");
        cmdNeu.setPreferredSize(new java.awt.Dimension(35, 30));
        cmdNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdNeuActionPerformed(evt);
            }
        });

        pnlTop.add(cmdNeu);

        cmdSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/suchen.gif")));
        cmdSuchen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setOpaque(false);
        cmdSuchen.setPreferredSize(new java.awt.Dimension(35, 30));
        pnlTop.add(cmdSuchen);

        cmdSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/speichern.gif")));
        cmdSpeichern.setToolTipText("Klicken Sie hier um die ge\u00e4nderten Daten zu speichern!");
        cmdSpeichern.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSpeichern.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdSpeichern.setOpaque(false);
        cmdSpeichern.setPreferredSize(new java.awt.Dimension(35, 30));
        pnlTop.add(cmdSpeichern);

        cmdLoeschen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/loeschen.gif")));
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

        cmdAbbrechen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/abbrechen.gif")));
        cmdAbbrechen.setToolTipText("Klicken Sie  auf  \"Abbrechen\" um die \u00c4nderungen nicht zu speichern!");
        cmdAbbrechen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdAbbrechen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdAbbrechen.setOpaque(false);
        cmdAbbrechen.setPreferredSize(new java.awt.Dimension(35, 30));
        pnlTop.add(cmdAbbrechen);

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

        lblAusstattung.setText("Ausstattung");
        lblAusstattung.setPreferredSize(new java.awt.Dimension(100, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlZimmer.add(lblAusstattung, gridBagConstraints);

        lstAusstattung.setMinimumSize(new java.awt.Dimension(95, 25));
        lstAusstattung.setPreferredSize(new java.awt.Dimension(95, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(6, 0, 0, 0);
        pnlZimmer.add(lstAusstattung, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 10, 5, 5);
        getContentPane().add(pnlZimmer, gridBagConstraints);

        pack();
    }//GEN-END:initComponents

    private void cmdNeuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdNeuActionPerformed
        
        txtMitarbeiterVN.setText("");
        txtMitarbeiterNN.setText("");
        txtLogin.setText("");
        txtPwd.setText("");
        txtZimNr.setText("");
        txtBettenANz.setText("");
        txtPreis.setText("");
        
    }//GEN-LAST:event_cmdNeuActionPerformed

    private void cmdLoeschenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoeschenActionPerformed
        // TODO add your handling code here:
        // helpMeldungen.showOptionDialog1("M�chten Sie diesen Datensatz endg�ltig l�schen?","L�schen",);
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
    private javax.swing.JButton cmdAbbrechen;
    private javax.swing.JButton cmdLoeschen;
    private javax.swing.JButton cmdLogout;
    private javax.swing.JButton cmdNeu;
    private javax.swing.JButton cmdSpeichern;
    private javax.swing.JButton cmdSuchen;
    private javax.swing.JLabel lblAusstattung;
    private javax.swing.JLabel lblBettenAnz;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblMitarbeiterNN;
    private javax.swing.JLabel lblMitarbeiterVN;
    private javax.swing.JLabel lblPreis;
    private javax.swing.JLabel lblPwd;
    private javax.swing.JLabel lblZimNr;
    private javax.swing.JList lstAusstattung;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlMitarbeiter;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JPanel pnlZimmer;
    private javax.swing.JTextField txtBettenANz;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtMitarbeiterNN;
    private javax.swing.JTextField txtMitarbeiterVN;
    private javax.swing.JTextField txtPreis;
    private javax.swing.JTextField txtPwd;
    private javax.swing.JTextField txtZimNr;
    // End of variables declaration//GEN-END:variables
    
}
