/*
 * frmDatenEing.java
 *
 * Created on 13. Juni 2005, 09:35
 */

package gui;

/**
 *
 * @author  Sabrina
 */
public class frmDatenEing extends javax.swing.JFrame {
    
    public static int WIDTH=600;
    public static int HEIGHT=500;
    public static String TITLE="HICS - Neue Reservierung";
    
    
    public frmDatenEing() {
        super(TITLE);
        initComponents();
        setSize(WIDTH, HEIGHT);
        setLocation(((getToolkit().getScreenSize().width)/2)-(WIDTH/2),((getToolkit().getScreenSize().height)/2)-(HEIGHT/2));
        show();
    }
    
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        pnlTop = new javax.swing.JPanel();
        cmdNeu = new javax.swing.JButton();
        cmdSuchen = new javax.swing.JButton();
        cmdSpeichern = new javax.swing.JButton();
        cmdLoeschen = new javax.swing.JButton();
        cmdAbbrechen = new javax.swing.JButton();
        pnlDatenKunde = new javax.swing.JPanel();
        lblKundennr = new javax.swing.JLabel();
        txtKundennr = new javax.swing.JTextField();
        lblKundenNN = new javax.swing.JLabel();
        txtZimmer1 = new javax.swing.JTextField();
        lblKundenVN = new javax.swing.JLabel();
        txtKundenVN = new javax.swing.JTextField();
        lblLand = new javax.swing.JLabel();
        txtLand = new javax.swing.JTextField();
        lblStrasse = new javax.swing.JLabel();
        txtStrasse = new javax.swing.JTextField();
        lblHausStiegeTuer = new javax.swing.JLabel();
        txtHaus = new javax.swing.JTextField();
        lblPlz = new javax.swing.JLabel();
        txPlz = new javax.swing.JTextField();
        pnlDatenReserv = new javax.swing.JPanel();
        lblAnkunft = new javax.swing.JLabel();
        txtAnkunft = new javax.swing.JTextField();
        lblAbreise = new javax.swing.JLabel();
        txtAbreise = new javax.swing.JTextField();
        lblZimmer = new javax.swing.JLabel();
        txtZimmer = new javax.swing.JTextField();
        pnlNotiz = new javax.swing.JPanel();
        lblNotiz = new javax.swing.JLabel();
        txtNotiz = new javax.swing.JTextField();
        pnlAufgaben = new javax.swing.JPanel();
        lblAufgaben = new javax.swing.JLabel();
        lblDeadline = new javax.swing.JLabel();
        tblAufgaben = new javax.swing.JTable();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        cmdNeu.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/neu.gif")));
        cmdNeu.setToolTipText("Klicken Sie  auf  \"Neu\" um neue Daten anzulegen!");
        cmdNeu.setPreferredSize(new java.awt.Dimension(35, 30));
        pnlTop.add(cmdNeu);

        cmdSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/suchen.gif")));
        cmdSuchen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setOpaque(false);
        cmdSuchen.setPreferredSize(new java.awt.Dimension(35, 30));
        pnlTop.add(cmdSuchen);

        cmdSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/speichern.gif")));
        cmdSpeichern.setToolTipText("Speichert Daten!");
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
        pnlTop.add(cmdLoeschen);

        cmdAbbrechen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/abbrechen.gif")));
        cmdAbbrechen.setToolTipText("Aenderungen werden verworfen!");
        cmdAbbrechen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdAbbrechen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdAbbrechen.setOpaque(false);
        cmdAbbrechen.setPreferredSize(new java.awt.Dimension(35, 30));
        pnlTop.add(cmdAbbrechen);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        getContentPane().add(pnlTop, gridBagConstraints);

        pnlDatenKunde.setLayout(new java.awt.GridBagLayout());

        lblKundennr.setText("Kundennr");
        lblKundennr.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKundennr.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKundennr.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKundennr.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(lblKundennr, gridBagConstraints);

        txtKundennr.setMaximumSize(new java.awt.Dimension(95, 25));
        txtKundennr.setMinimumSize(new java.awt.Dimension(95, 25));
        txtKundennr.setPreferredSize(new java.awt.Dimension(95, 25));
        txtKundennr.setRequestFocusEnabled(false);
        txtKundennr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKundennrActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(txtKundennr, gridBagConstraints);

        lblKundenNN.setText("Nachname");
        lblKundenNN.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKundenNN.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKundenNN.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKundenNN.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(lblKundenNN, gridBagConstraints);

        txtZimmer1.setMaximumSize(new java.awt.Dimension(95, 25));
        txtZimmer1.setMinimumSize(new java.awt.Dimension(95, 25));
        txtZimmer1.setPreferredSize(new java.awt.Dimension(95, 25));
        txtZimmer1.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(txtZimmer1, gridBagConstraints);

        lblKundenVN.setText("Vorname");
        lblKundenVN.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(lblKundenVN, gridBagConstraints);

        txtKundenVN.setMaximumSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setMinimumSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setPreferredSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(txtKundenVN, gridBagConstraints);

        lblLand.setText("Land");
        lblLand.setMaximumSize(new java.awt.Dimension(95, 25));
        lblLand.setMinimumSize(new java.awt.Dimension(95, 25));
        lblLand.setPreferredSize(new java.awt.Dimension(95, 25));
        lblLand.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(lblLand, gridBagConstraints);

        txtLand.setMaximumSize(new java.awt.Dimension(95, 25));
        txtLand.setMinimumSize(new java.awt.Dimension(95, 25));
        txtLand.setPreferredSize(new java.awt.Dimension(95, 25));
        txtLand.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(txtLand, gridBagConstraints);

        lblStrasse.setText("Strasse");
        lblStrasse.setMaximumSize(new java.awt.Dimension(95, 25));
        lblStrasse.setMinimumSize(new java.awt.Dimension(95, 25));
        lblStrasse.setPreferredSize(new java.awt.Dimension(95, 25));
        lblStrasse.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(lblStrasse, gridBagConstraints);

        txtStrasse.setMaximumSize(new java.awt.Dimension(95, 25));
        txtStrasse.setMinimumSize(new java.awt.Dimension(95, 25));
        txtStrasse.setPreferredSize(new java.awt.Dimension(95, 25));
        txtStrasse.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(txtStrasse, gridBagConstraints);

        lblHausStiegeTuer.setText("Nr/Stg/Tuer");
        lblHausStiegeTuer.setMaximumSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setMinimumSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setPreferredSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(lblHausStiegeTuer, gridBagConstraints);

        txtHaus.setMaximumSize(new java.awt.Dimension(95, 25));
        txtHaus.setMinimumSize(new java.awt.Dimension(95, 25));
        txtHaus.setPreferredSize(new java.awt.Dimension(95, 25));
        txtHaus.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(txtHaus, gridBagConstraints);

        lblPlz.setText("Plz");
        lblPlz.setMaximumSize(new java.awt.Dimension(95, 25));
        lblPlz.setMinimumSize(new java.awt.Dimension(95, 25));
        lblPlz.setPreferredSize(new java.awt.Dimension(95, 25));
        lblPlz.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(lblPlz, gridBagConstraints);

        txPlz.setMaximumSize(new java.awt.Dimension(95, 25));
        txPlz.setMinimumSize(new java.awt.Dimension(95, 25));
        txPlz.setPreferredSize(new java.awt.Dimension(95, 25));
        txPlz.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenKunde.add(txPlz, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 5, 5);
        getContentPane().add(pnlDatenKunde, gridBagConstraints);

        pnlDatenReserv.setLayout(new java.awt.GridBagLayout());

        lblAnkunft.setText("Ankunft");
        lblAnkunft.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAnkunft.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAnkunft.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAnkunft.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenReserv.add(lblAnkunft, gridBagConstraints);

        txtAnkunft.setMaximumSize(new java.awt.Dimension(95, 25));
        txtAnkunft.setMinimumSize(new java.awt.Dimension(95, 25));
        txtAnkunft.setPreferredSize(new java.awt.Dimension(95, 25));
        txtAnkunft.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenReserv.add(txtAnkunft, gridBagConstraints);

        lblAbreise.setText("Abreise");
        lblAbreise.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAbreise.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAbreise.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAbreise.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenReserv.add(lblAbreise, gridBagConstraints);

        txtAbreise.setMaximumSize(new java.awt.Dimension(95, 25));
        txtAbreise.setMinimumSize(new java.awt.Dimension(95, 25));
        txtAbreise.setPreferredSize(new java.awt.Dimension(95, 25));
        txtAbreise.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlDatenReserv.add(txtAbreise, gridBagConstraints);

        lblZimmer.setText("Zimmer");
        lblZimmer.setMaximumSize(new java.awt.Dimension(95, 25));
        lblZimmer.setMinimumSize(new java.awt.Dimension(95, 25));
        lblZimmer.setPreferredSize(new java.awt.Dimension(95, 25));
        lblZimmer.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlDatenReserv.add(lblZimmer, gridBagConstraints);

        txtZimmer.setMaximumSize(new java.awt.Dimension(95, 25));
        txtZimmer.setMinimumSize(new java.awt.Dimension(95, 25));
        txtZimmer.setPreferredSize(new java.awt.Dimension(95, 25));
        txtZimmer.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 0, 0, 0);
        pnlDatenReserv.add(txtZimmer, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 5, 5);
        getContentPane().add(pnlDatenReserv, gridBagConstraints);

        pnlNotiz.setLayout(new java.awt.GridLayout(1, 2));

        lblNotiz.setText("Notiz");
        lblNotiz.setMaximumSize(new java.awt.Dimension(95, 25));
        lblNotiz.setMinimumSize(new java.awt.Dimension(95, 25));
        lblNotiz.setPreferredSize(new java.awt.Dimension(95, 25));
        lblNotiz.setRequestFocusEnabled(false);
        pnlNotiz.add(lblNotiz);

        txtNotiz.setMaximumSize(new java.awt.Dimension(95, 25));
        txtNotiz.setMinimumSize(new java.awt.Dimension(95, 25));
        txtNotiz.setPreferredSize(new java.awt.Dimension(95, 25));
        txtNotiz.setRequestFocusEnabled(false);
        pnlNotiz.add(txtNotiz);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(pnlNotiz, gridBagConstraints);

        pnlAufgaben.setLayout(new java.awt.GridBagLayout());

        lblAufgaben.setText("Aufgabe");
        lblAufgaben.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAufgaben.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAufgaben.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAufgaben.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlAufgaben.add(lblAufgaben, gridBagConstraints);

        lblDeadline.setText("Deadline");
        lblDeadline.setMaximumSize(new java.awt.Dimension(95, 25));
        lblDeadline.setMinimumSize(new java.awt.Dimension(95, 25));
        lblDeadline.setPreferredSize(new java.awt.Dimension(95, 25));
        lblDeadline.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlAufgaben.add(lblDeadline, gridBagConstraints);

        tblAufgaben.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Aufgabe", "Title 2"
            }
        ));
        tblAufgaben.setPreferredSize(new java.awt.Dimension(190, 96));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        pnlAufgaben.add(tblAufgaben, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 15, 5, 5);
        getContentPane().add(pnlAufgaben, gridBagConstraints);

        pack();
    }//GEN-END:initComponents

    private void txtKundennrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKundennrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKundennrActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDatenEing().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAbbrechen;
    private javax.swing.JButton cmdLoeschen;
    private javax.swing.JButton cmdNeu;
    private javax.swing.JButton cmdSpeichern;
    private javax.swing.JButton cmdSuchen;
    private javax.swing.JLabel lblAbreise;
    private javax.swing.JLabel lblAnkunft;
    private javax.swing.JLabel lblAufgaben;
    private javax.swing.JLabel lblDeadline;
    private javax.swing.JLabel lblHausStiegeTuer;
    private javax.swing.JLabel lblKundenNN;
    private javax.swing.JLabel lblKundenVN;
    private javax.swing.JLabel lblKundennr;
    private javax.swing.JLabel lblLand;
    private javax.swing.JLabel lblNotiz;
    private javax.swing.JLabel lblPlz;
    private javax.swing.JLabel lblStrasse;
    private javax.swing.JLabel lblZimmer;
    private javax.swing.JPanel pnlAufgaben;
    private javax.swing.JPanel pnlDatenKunde;
    private javax.swing.JPanel pnlDatenReserv;
    private javax.swing.JPanel pnlNotiz;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblAufgaben;
    private javax.swing.JTextField txPlz;
    private javax.swing.JTextField txtAbreise;
    private javax.swing.JTextField txtAnkunft;
    private javax.swing.JTextField txtHaus;
    private javax.swing.JTextField txtKundenVN;
    private javax.swing.JTextField txtKundennr;
    private javax.swing.JTextField txtLand;
    private javax.swing.JTextField txtNotiz;
    private javax.swing.JTextField txtStrasse;
    private javax.swing.JTextField txtZimmer;
    private javax.swing.JTextField txtZimmer1;
    // End of variables declaration//GEN-END:variables
    
}
