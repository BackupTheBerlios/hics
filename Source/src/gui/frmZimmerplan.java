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
    public static int WIDTH=600;
    public static int HEIGHT=500;
    public static String TITLE="Zimmerplan";
    
    /** Creates new form frmStart */
    public frmZimmerplan() {
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

        tblZimmer = new javax.swing.JTable();
        jPanelBottom = new javax.swing.JPanel();
        btnLogout = new javax.swing.JButton();
        jPanelTop = new javax.swing.JPanel();
        cmbMenue = new javax.swing.JComboBox();
        btnBearbeiten = new javax.swing.JButton();
        btnNotiz = new javax.swing.JButton();
        btnZimDetail = new javax.swing.JButton();
        jPanelText = new javax.swing.JPanel();
        lblZimmernr = new javax.swing.JLabel();
        lblBettenAnz = new javax.swing.JLabel();
        lblResdauer = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getAccessibleContext().setAccessibleName("Zimmerplan");
        tblZimmer.setBorder(new javax.swing.border.EtchedBorder());
        tblZimmer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"101", "XX (X)", "12.5.05 - 14.5.05", "Huber, Hans", "checked in"},
                {"102", "X", "13.5.05 - 15.5.05", "Maier, Karl", null},
                {"103", "XX X", null, null, null},
                {"104", "XX X (X)", null, null, null},
                {"105", "X X", null, null, null},
                {"201", "X", null, null, null},
                {"202", "XX", null, null, null},
                {"203", "XX", null, null, null},
                {"204", null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Zimmer", "Betten", "Reservierung", "Gast", "Notiz"
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
        tblZimmer.setMinimumSize(new java.awt.Dimension(500, 300));
        tblZimmer.setPreferredSize(new java.awt.Dimension(500, 300));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(tblZimmer, gridBagConstraints);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/logout.gif")));
        btnLogout.setMaximumSize(new java.awt.Dimension(22, 24));
        btnLogout.setMinimumSize(new java.awt.Dimension(22, 24));
        btnLogout.setPreferredSize(new java.awt.Dimension(35, 30));
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jPanelBottom.add(btnLogout);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(jPanelBottom, gridBagConstraints);

        jPanelTop.setLayout(new java.awt.GridBagLayout());

        jPanelTop.setMinimumSize(new java.awt.Dimension(500, 41));
        jPanelTop.setPreferredSize(new java.awt.Dimension(500, 70));
        cmbMenue.addItem("Kunde");
        cmbMenue.addItem("Zimmer");
        cmbMenue.addItem("Reservierung");
        cmbMenue.addItem("Notiz");
        cmbMenue.setEditable(false);
        cmbMenue.setMinimumSize(new java.awt.Dimension(80, 20));
        cmbMenue.setPreferredSize(new java.awt.Dimension(80, 20));
        cmbMenue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMenueActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 80);
        jPanelTop.add(cmbMenue, gridBagConstraints);

        btnBearbeiten.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/bearbeiten.gif")));
        btnBearbeiten.setMaximumSize(new java.awt.Dimension(35, 30));
        btnBearbeiten.setMinimumSize(new java.awt.Dimension(35, 30));
        btnBearbeiten.setPreferredSize(new java.awt.Dimension(35, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jPanelTop.add(btnBearbeiten, gridBagConstraints);

        btnNotiz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/info.gif")));
        btnNotiz.setMaximumSize(new java.awt.Dimension(35, 30));
        btnNotiz.setMinimumSize(new java.awt.Dimension(35, 30));
        btnNotiz.setPreferredSize(new java.awt.Dimension(35, 30));
        btnNotiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNotizActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 200);
        jPanelTop.add(btnNotiz, gridBagConstraints);

        btnZimDetail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/zimmer.gif")));
        btnZimDetail.setToolTipText("\u00f6ffnet die Zimmer Details");
        btnZimDetail.setMaximumSize(new java.awt.Dimension(35, 30));
        btnZimDetail.setMinimumSize(new java.awt.Dimension(35, 30));
        btnZimDetail.setPreferredSize(new java.awt.Dimension(35, 30));
        btnZimDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZimmerDetailActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 15);
        jPanelTop.add(btnZimDetail, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        getContentPane().add(jPanelTop, gridBagConstraints);

        jPanelText.setLayout(new java.awt.GridLayout(1, 4));

        jPanelText.setMinimumSize(new java.awt.Dimension(500, 25));
        jPanelText.setPreferredSize(new java.awt.Dimension(500, 25));
        lblZimmernr.setText("Zimmer");
        jPanelText.add(lblZimmernr);
        lblZimmernr.getAccessibleContext().setAccessibleName("");

        lblBettenAnz.setText("Betten");
        jPanelText.add(lblBettenAnz);

        lblResdauer.setText("Reservierung");
        jPanelText.add(lblResdauer);

        lblName.setText("Gast");
        jPanelText.add(lblName);

        lblStatus.setText("Status");
        jPanelText.add(lblStatus);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        getContentPane().add(jPanelText, gridBagConstraints);

        pack();
    }//GEN-END:initComponents

    private void btnZimmerDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZimmerDetailActionPerformed
       this.hide();
       new frmZimmer().setVisible(true);
    }//GEN-LAST:event_btnZimmerDetailActionPerformed

    private void btnNotizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNotizActionPerformed
        this.hide();
        new frmNotiz().setVisible(true);
    }//GEN-LAST:event_btnNotizActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        this.hide();
        new frmStart().setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void cmbMenueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMenueActionPerformed
       int index = 0;
              
        index = cmbMenue.getSelectedIndex();
        if(index == 0) {
            this.setVisible(true);
            new frmKundendaten().setVisible(true);
           
        }
        if(index == 1) {
            new frmZimmerplan().setVisible(true);
            this.hide();
        }
        if(index == 2) {
            new frmReservierung().setVisible(true);
            this.hide();
        }if(index == 3) {
            new frmNotiz().setVisible(true);
            this.hide();
        }
                
        index = 4;
    
    }//GEN-LAST:event_cmbMenueActionPerformed
    
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
    private javax.swing.JButton btnBearbeiten;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnNotiz;
    private javax.swing.JButton btnZimDetail;
    private javax.swing.JComboBox cmbMenue;
    private javax.swing.JPanel jPanelBottom;
    private javax.swing.JPanel jPanelText;
    private javax.swing.JPanel jPanelTop;
    private javax.swing.JLabel lblBettenAnz;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblResdauer;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblZimmernr;
    private javax.swing.JTable tblZimmer;
    // End of variables declaration//GEN-END:variables
    
}
