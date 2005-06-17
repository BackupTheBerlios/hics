/*
 * frmZimmerplan.java
 *
 * Created on 25. Mai 2005, 13:51
 */

package gui;

import java.awt.*;

/**
 *
 * @author  Sabrina
 */
public class frmZimmerplan extends javax.swing.JFrame {
    public static String TITLE="Zimmerplan";
    
    /** Creates new form frmStart */
    public frmZimmerplan() {
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

        pnlTop = new javax.swing.JPanel();
        btnNeu = new javax.swing.JButton();
        btnBearbeiten = new javax.swing.JButton();
        btnAufgaben = new javax.swing.JButton();
        btnCheckIn = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        btnOk = new javax.swing.JButton();
        pnlBottom = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        pnlAnzeige = new javax.swing.JPanel();
        pnlAnzeigeKunde = new javax.swing.JPanel();
        lblKundennr = new javax.swing.JLabel();
        txtKundennr = new javax.swing.JTextField();
        lblNachname = new javax.swing.JLabel();
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
        pnlAnzeigeZimmer = new javax.swing.JPanel();
        lblBettenanz = new javax.swing.JLabel();
        txtBetten = new javax.swing.JTextField();
        lblPreis = new javax.swing.JLabel();
        txtPreis = new javax.swing.JTextField();
        lblAussattung = new javax.swing.JLabel();
        txtAusstattung = new javax.swing.JTextField();
        pnlNotiz = new javax.swing.JPanel();
        lblNotiz = new javax.swing.JLabel();
        txtNotiz = new javax.swing.JTextField();
        pnlAufgaben = new javax.swing.JPanel();
        lblAufgaben = new javax.swing.JLabel();
        txtAufgaben = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        tblZimmer = new javax.swing.JTable();
        lblZimmernr = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        getAccessibleContext().setAccessibleName("Zimmerplan");
        pnlTop.setBorder(new javax.swing.border.EtchedBorder());
        pnlTop.setMinimumSize(new java.awt.Dimension(340, 41));
        pnlTop.setPreferredSize(new java.awt.Dimension(300, 70));
        btnNeu.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/neu.gif")));
        btnNeu.setToolTipText("Bet\u00e4tigen Sie diesen Button um ein neues Objekt zu erstellen!");
        btnNeu.setMaximumSize(new java.awt.Dimension(35, 30));
        btnNeu.setMinimumSize(new java.awt.Dimension(35, 30));
        btnNeu.setPreferredSize(new java.awt.Dimension(35, 30));
        btnNeu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZimmerDetailActionPerformed(evt);
            }
        });

        pnlTop.add(btnNeu);

        btnBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/bearbeiten.gif")));
        btnBearbeiten.setToolTipText("Bet\u00e4tigen Sie diesen Button um ein  Objekt zu bearbeiten!");
        btnBearbeiten.setMaximumSize(new java.awt.Dimension(35, 30));
        btnBearbeiten.setMinimumSize(new java.awt.Dimension(35, 30));
        btnBearbeiten.setPreferredSize(new java.awt.Dimension(35, 30));
        pnlTop.add(btnBearbeiten);

        btnAufgaben.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/aufgaben.gif")));
        btnAufgaben.setToolTipText("Bet\u00e4tigen Sie diesen Button um Aufgaben zu erstellen!");
        btnAufgaben.setMaximumSize(new java.awt.Dimension(35, 30));
        btnAufgaben.setMinimumSize(new java.awt.Dimension(35, 30));
        btnAufgaben.setPreferredSize(new java.awt.Dimension(35, 30));
        btnAufgaben.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAufgabenActionPerformed(evt);
            }
        });

        pnlTop.add(btnAufgaben);

        btnCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/login.gif")));
        btnCheckIn.setToolTipText("Bet\u00e4tigen Sie diesen Button um einzuchecken!");
        btnCheckIn.setMaximumSize(new java.awt.Dimension(35, 30));
        btnCheckIn.setMinimumSize(new java.awt.Dimension(35, 30));
        btnCheckIn.setPreferredSize(new java.awt.Dimension(35, 30));
        pnlTop.add(btnCheckIn);

        btnCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/logout.gif")));
        btnCheckOut.setToolTipText("Bet\u00e4tigen Sie diesen Button um eauszuchecken!");
        btnCheckOut.setMaximumSize(new java.awt.Dimension(35, 30));
        btnCheckOut.setMinimumSize(new java.awt.Dimension(35, 30));
        btnCheckOut.setPreferredSize(new java.awt.Dimension(35, 30));
        pnlTop.add(btnCheckOut);

        btnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/ok.gif")));
        btnOk.setToolTipText("Bet\u00e4tigen Sie diesen Button um zu best\u00e4tigen!");
        btnOk.setMaximumSize(new java.awt.Dimension(35, 30));
        btnOk.setMinimumSize(new java.awt.Dimension(35, 30));
        btnOk.setPreferredSize(new java.awt.Dimension(35, 30));
        pnlTop.add(btnOk);

        getContentPane().add(pnlTop);
        pnlTop.setBounds(10, 10, 490, 50);

        pnlBottom.setBorder(new javax.swing.border.EtchedBorder());
        pnlBottom.setMinimumSize(new java.awt.Dimension(735, 65));
        pnlBottom.setPreferredSize(new java.awt.Dimension(249, 244));
        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/logout.gif")));
        btnLogout.setMaximumSize(new java.awt.Dimension(22, 24));
        btnLogout.setMinimumSize(new java.awt.Dimension(22, 24));
        btnLogout.setPreferredSize(new java.awt.Dimension(35, 30));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        pnlBottom.add(btnLogout);

        getContentPane().add(pnlBottom);
        pnlBottom.setBounds(0, 431, 740, 65);

        pnlAnzeige.setLayout(new java.awt.GridBagLayout());

        pnlAnzeige.setPreferredSize(new java.awt.Dimension(302, 394));
        pnlAnzeigeKunde.setLayout(new java.awt.GridLayout(7, 2));

        pnlAnzeigeKunde.setBorder(new javax.swing.border.TitledBorder("Kundendaten"));
        lblKundennr.setText("Kundennr");
        lblKundennr.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKundennr.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKundennr.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKundennr.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblKundennr);

        txtKundennr.setText("0");
        txtKundennr.setToolTipText("Geben Sie hier die Kundennumer ein!");
        txtKundennr.setMaximumSize(new java.awt.Dimension(95, 25));
        txtKundennr.setMinimumSize(new java.awt.Dimension(95, 25));
        txtKundennr.setPreferredSize(new java.awt.Dimension(95, 25));
        txtKundennr.setRequestFocusEnabled(false);
        txtKundennr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKundennrActionPerformed(evt);
            }
        });

        pnlAnzeigeKunde.add(txtKundennr);

        lblNachname.setText("Nachname");
        lblNachname.setMaximumSize(new java.awt.Dimension(95, 25));
        lblNachname.setMinimumSize(new java.awt.Dimension(95, 25));
        lblNachname.setPreferredSize(new java.awt.Dimension(95, 25));
        lblNachname.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblNachname);

        txtZimmer1.setText("Nachname");
        txtZimmer1.setToolTipText("Geben Sie hier den Nachnamen/Familiennamen des Kunden ein!");
        txtZimmer1.setMaximumSize(new java.awt.Dimension(95, 25));
        txtZimmer1.setMinimumSize(new java.awt.Dimension(95, 25));
        txtZimmer1.setPreferredSize(new java.awt.Dimension(95, 25));
        txtZimmer1.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(txtZimmer1);

        lblKundenVN.setText("Vorname");
        lblKundenVN.setMaximumSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setMinimumSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setPreferredSize(new java.awt.Dimension(95, 25));
        lblKundenVN.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblKundenVN);

        txtKundenVN.setText("Vorname");
        txtKundenVN.setToolTipText("Geben Sie hier den Vornamen des Kunden ein!");
        txtKundenVN.setMaximumSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setMinimumSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setPreferredSize(new java.awt.Dimension(95, 25));
        txtKundenVN.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(txtKundenVN);

        lblLand.setText("Land");
        lblLand.setMaximumSize(new java.awt.Dimension(95, 25));
        lblLand.setMinimumSize(new java.awt.Dimension(95, 25));
        lblLand.setPreferredSize(new java.awt.Dimension(95, 25));
        lblLand.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblLand);

        txtLand.setText("Land");
        txtLand.setToolTipText("Geben Sie hier das Land ein!");
        txtLand.setMaximumSize(new java.awt.Dimension(95, 25));
        txtLand.setMinimumSize(new java.awt.Dimension(95, 25));
        txtLand.setPreferredSize(new java.awt.Dimension(95, 25));
        txtLand.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(txtLand);

        lblStrasse.setText("Strasse");
        lblStrasse.setMaximumSize(new java.awt.Dimension(95, 25));
        lblStrasse.setMinimumSize(new java.awt.Dimension(95, 25));
        lblStrasse.setPreferredSize(new java.awt.Dimension(95, 25));
        lblStrasse.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblStrasse);

        txtStrasse.setText("Strasse");
        txtStrasse.setToolTipText("Geben Sie hier die Strasse, in der der Kunde wohnt, ein!");
        txtStrasse.setMaximumSize(new java.awt.Dimension(95, 25));
        txtStrasse.setMinimumSize(new java.awt.Dimension(95, 25));
        txtStrasse.setPreferredSize(new java.awt.Dimension(95, 25));
        txtStrasse.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(txtStrasse);

        lblHausStiegeTuer.setText("Nr/Stg/Tuer");
        lblHausStiegeTuer.setMaximumSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setMinimumSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setPreferredSize(new java.awt.Dimension(95, 25));
        lblHausStiegeTuer.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblHausStiegeTuer);

        txtHaus.setToolTipText("Geben Sie hier Hausnummer, Stiege und T\u00fcr des Kunden ein!");
        txtHaus.setMaximumSize(new java.awt.Dimension(95, 25));
        txtHaus.setMinimumSize(new java.awt.Dimension(95, 25));
        txtHaus.setPreferredSize(new java.awt.Dimension(95, 25));
        txtHaus.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(txtHaus);

        lblPlz.setText("Plz");
        lblPlz.setMaximumSize(new java.awt.Dimension(95, 25));
        lblPlz.setMinimumSize(new java.awt.Dimension(95, 25));
        lblPlz.setPreferredSize(new java.awt.Dimension(95, 25));
        lblPlz.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(lblPlz);

        txPlz.setToolTipText("Geben Sie hier die Postleitzahl ein!");
        txPlz.setMaximumSize(new java.awt.Dimension(95, 25));
        txPlz.setMinimumSize(new java.awt.Dimension(95, 25));
        txPlz.setPreferredSize(new java.awt.Dimension(95, 25));
        txPlz.setRequestFocusEnabled(false);
        pnlAnzeigeKunde.add(txPlz);

        pnlAnzeige.add(pnlAnzeigeKunde, new java.awt.GridBagConstraints());

        pnlAnzeigeZimmer.setLayout(new java.awt.GridLayout(3, 2));

        pnlAnzeigeZimmer.setBorder(new javax.swing.border.TitledBorder("Zimmer"));
        lblBettenanz.setText("Betten");
        lblBettenanz.setMaximumSize(new java.awt.Dimension(95, 25));
        lblBettenanz.setMinimumSize(new java.awt.Dimension(95, 25));
        lblBettenanz.setPreferredSize(new java.awt.Dimension(95, 25));
        lblBettenanz.setRequestFocusEnabled(false);
        pnlAnzeigeZimmer.add(lblBettenanz);

        txtBetten.setMaximumSize(new java.awt.Dimension(95, 25));
        txtBetten.setMinimumSize(new java.awt.Dimension(95, 25));
        txtBetten.setPreferredSize(new java.awt.Dimension(95, 25));
        txtBetten.setRequestFocusEnabled(false);
        pnlAnzeigeZimmer.add(txtBetten);

        lblPreis.setText("Preis");
        lblPreis.setMaximumSize(new java.awt.Dimension(95, 25));
        lblPreis.setMinimumSize(new java.awt.Dimension(95, 25));
        lblPreis.setPreferredSize(new java.awt.Dimension(95, 25));
        lblPreis.setRequestFocusEnabled(false);
        pnlAnzeigeZimmer.add(lblPreis);

        txtPreis.setMaximumSize(new java.awt.Dimension(95, 25));
        txtPreis.setMinimumSize(new java.awt.Dimension(95, 25));
        txtPreis.setPreferredSize(new java.awt.Dimension(95, 25));
        txtPreis.setRequestFocusEnabled(false);
        pnlAnzeigeZimmer.add(txtPreis);

        lblAussattung.setText("Ausstattung");
        lblAussattung.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAussattung.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAussattung.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAussattung.setRequestFocusEnabled(false);
        pnlAnzeigeZimmer.add(lblAussattung);

        txtAusstattung.setMaximumSize(new java.awt.Dimension(95, 25));
        txtAusstattung.setMinimumSize(new java.awt.Dimension(95, 25));
        txtAusstattung.setPreferredSize(new java.awt.Dimension(95, 25));
        txtAusstattung.setRequestFocusEnabled(false);
        pnlAnzeigeZimmer.add(txtAusstattung);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pnlAnzeige.add(pnlAnzeigeZimmer, gridBagConstraints);

        pnlNotiz.setLayout(new java.awt.GridLayout(1, 0));

        pnlNotiz.setBorder(new javax.swing.border.EtchedBorder());
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
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pnlAnzeige.add(pnlNotiz, gridBagConstraints);

        pnlAufgaben.setLayout(new java.awt.GridLayout(1, 0));

        pnlAufgaben.setBorder(new javax.swing.border.EtchedBorder());
        lblAufgaben.setText("Aufgaben");
        lblAufgaben.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAufgaben.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAufgaben.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAufgaben.setRequestFocusEnabled(false);
        pnlAufgaben.add(lblAufgaben);

        txtAufgaben.setMaximumSize(new java.awt.Dimension(95, 25));
        txtAufgaben.setMinimumSize(new java.awt.Dimension(95, 25));
        txtAufgaben.setPreferredSize(new java.awt.Dimension(95, 25));
        txtAufgaben.setRequestFocusEnabled(false);
        pnlAufgaben.add(txtAufgaben);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pnlAnzeige.add(pnlAufgaben, gridBagConstraints);

        getContentPane().add(pnlAnzeige);
        pnlAnzeige.setBounds(510, 10, 202, 410);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setMaximumSize(new java.awt.Dimension(500, 450));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 400));
        tblZimmer.setBorder(new javax.swing.border.EtchedBorder());
        tblZimmer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"101", ""},
                {"102", ""},
                {"103", ""},
                {"104", ""},
                {"105", ""},
                {"201", ""},
                {"202", ""},
                {"203", ""},
                {"204", null},
                {null, null}
            },
            new String [] {
                "Zimmer", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblZimmer.setGridColor(new java.awt.Color(255, 255, 255));
        tblZimmer.setMaximumSize(new java.awt.Dimension(450, 600));
        tblZimmer.setMinimumSize(new java.awt.Dimension(450, 300));
        tblZimmer.setPreferredSize(new java.awt.Dimension(350, 500));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(tblZimmer, gridBagConstraints);

        lblZimmernr.setText("Zimmer");
        lblZimmernr.setMinimumSize(new java.awt.Dimension(450, 16));
        jPanel1.add(lblZimmernr, new java.awt.GridBagConstraints());
        lblZimmernr.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jPanel1);
        jPanel1.setBounds(10, 80, 490, 330);

        pack();
    }//GEN-END:initComponents

    private void txtKundennrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKundennrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKundennrActionPerformed

    private void btnAufgabenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAufgabenActionPerformed
        this.hide();
        new frmAufgabenAnzeigen().setVisible(true);
    }//GEN-LAST:event_btnAufgabenActionPerformed

    private void btnZimmerDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZimmerDetailActionPerformed
       this.hide();
       new frmDatenEing().setVisible(true);
    }//GEN-LAST:event_btnZimmerDetailActionPerformed

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
    private javax.swing.JButton btnAufgaben;
    private javax.swing.JButton btnBearbeiten;
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNeu;
    private javax.swing.JButton btnOk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAufgaben;
    private javax.swing.JLabel lblAussattung;
    private javax.swing.JLabel lblBettenanz;
    private javax.swing.JLabel lblHausStiegeTuer;
    private javax.swing.JLabel lblKundenVN;
    private javax.swing.JLabel lblKundennr;
    private javax.swing.JLabel lblLand;
    private javax.swing.JLabel lblNachname;
    private javax.swing.JLabel lblNotiz;
    private javax.swing.JLabel lblPlz;
    private javax.swing.JLabel lblPreis;
    private javax.swing.JLabel lblStrasse;
    private javax.swing.JLabel lblZimmernr;
    private javax.swing.JPanel pnlAnzeige;
    private javax.swing.JPanel pnlAnzeigeKunde;
    private javax.swing.JPanel pnlAnzeigeZimmer;
    private javax.swing.JPanel pnlAufgaben;
    private javax.swing.JPanel pnlBottom;
    private javax.swing.JPanel pnlNotiz;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblZimmer;
    private javax.swing.JTextField txPlz;
    private javax.swing.JTextField txtAufgaben;
    private javax.swing.JTextField txtAusstattung;
    private javax.swing.JTextField txtBetten;
    private javax.swing.JTextField txtHaus;
    private javax.swing.JTextField txtKundenVN;
    private javax.swing.JTextField txtKundennr;
    private javax.swing.JTextField txtLand;
    private javax.swing.JTextField txtNotiz;
    private javax.swing.JTextField txtPreis;
    private javax.swing.JTextField txtStrasse;
    private javax.swing.JTextField txtZimmer1;
    // End of variables declaration//GEN-END:variables
    
}
