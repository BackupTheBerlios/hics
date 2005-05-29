/*
 * Anzeige.java
 *
 * Created on 26. April 2005, 13:38
 */

package gui;

import gui.frmNotiz;

/**
 *
 * @author  Standard
 */
public class frmDaten extends javax.swing.JFrame {
    public static int WIDTH=500;
    public static int HEIGHT=400;
    public static String TITLE="HICS - Daten";
    
    /** Creates new form Anzeige */
    public frmDaten() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlTop = new javax.swing.JPanel();
        cmdSuchen = new javax.swing.JButton();
        cmdSpeichern = new javax.swing.JButton();
        cmbDaten = new javax.swing.JComboBox();
        cmdLoeschen = new javax.swing.JButton();
        cmdLoeschen1 = new javax.swing.JButton();
        cmdNeu = new javax.swing.JButton();
        cmdZurueck = new javax.swing.JButton();
        pnlTabel = new javax.swing.JPanel();
        tblInfo = new javax.swing.JTable();
        lblAufgabe2 = new javax.swing.JLabel();
        lblAufgabe3 = new javax.swing.JLabel();
        lblAufgabe4 = new javax.swing.JLabel();
        pnlLogout = new javax.swing.JPanel();
        cmdLogout = new javax.swing.JButton();

        getContentPane().setLayout(new java.awt.GridBagLayout());

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pnlTop.setLayout(new java.awt.GridBagLayout());

        pnlTop.setPreferredSize(new java.awt.Dimension(400, 80));
        cmdSuchen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/suchen.gif")));
        cmdSuchen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdSuchen.setOpaque(false);
        cmdSuchen.setPreferredSize(new java.awt.Dimension(35, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        pnlTop.add(cmdSuchen, gridBagConstraints);

        cmdSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/speichern.gif")));
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        pnlTop.add(cmdSpeichern, gridBagConstraints);

        cmbDaten.addItem("Kunde");
        cmbDaten.addItem("Zimmer");
        cmbDaten.addItem("Reservierung");
        cmbDaten.addItem("Notiz");
        cmbDaten.setEditable(false);
        cmbDaten.setMaximumSize(new java.awt.Dimension(110, 25));
        cmbDaten.setMinimumSize(new java.awt.Dimension(110, 25));
        cmbDaten.setOpaque(false);
        cmbDaten.setPreferredSize(new java.awt.Dimension(125, 30));
        cmbDaten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDatenActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 21, 16);
        pnlTop.add(cmbDaten, gridBagConstraints);

        cmdLoeschen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/loeschen.gif")));
        cmdLoeschen.setToolTipText("Klicken Sie  auf  \"L\u00f6schen\" um Daten zu l\u00f6schen!");
        cmdLoeschen.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen.setOpaque(false);
        cmdLoeschen.setPreferredSize(new java.awt.Dimension(35, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        pnlTop.add(cmdLoeschen, gridBagConstraints);

        cmdLoeschen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/abbrechen.gif")));
        cmdLoeschen1.setToolTipText("Klicken Sie  auf  \"Abbrechen\" um die \u00c4nderungen nicht zu speichern!");
        cmdLoeschen1.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen1.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdLoeschen1.setOpaque(false);
        cmdLoeschen1.setPreferredSize(new java.awt.Dimension(35, 30));
        cmdLoeschen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoeschen1ActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        pnlTop.add(cmdLoeschen1, gridBagConstraints);

        cmdNeu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/neu.gif")));
        cmdNeu.setToolTipText("Klicken Sie  auf  \"Neu\" um neue Daten anzulegen!");
        cmdNeu.setPreferredSize(new java.awt.Dimension(35, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        pnlTop.add(cmdNeu, gridBagConstraints);

        cmdZurueck.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/zurueck.gif")));
        cmdZurueck.setToolTipText("Klicken Sie  auf  \"Zurueck\" um wieder auf den vorigen Bildschirm zu gelangen!");
        cmdZurueck.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdZurueck.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdZurueck.setPreferredSize(new java.awt.Dimension(35, 30));
        cmdZurueck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdZurueckActionPerformed(evt);
            }
        });

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        pnlTop.add(cmdZurueck, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 4;
        getContentPane().add(pnlTop, gridBagConstraints);

        pnlTabel.setLayout(new java.awt.GridBagLayout());

        pnlTabel.setPreferredSize(new java.awt.Dimension(400, 200));
        tblInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Thema", "Aufgabe", "Details"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblInfo.setPreferredSize(new java.awt.Dimension(300, 100));
        tblInfo.setSurrendersFocusOnKeystroke(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlTabel.add(tblInfo, gridBagConstraints);

        lblAufgabe2.setFont(new java.awt.Font("Dialog", 1, 12));
        lblAufgabe2.setText("Thema");
        lblAufgabe2.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAufgabe2.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAufgabe2.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAufgabe2.setPreferredSize(new java.awt.Dimension(100, 25));
        lblAufgabe2.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlTabel.add(lblAufgabe2, gridBagConstraints);

        lblAufgabe3.setFont(new java.awt.Font("Dialog", 1, 12));
        lblAufgabe3.setText("Aufgabe");
        lblAufgabe3.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAufgabe3.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAufgabe3.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAufgabe3.setPreferredSize(new java.awt.Dimension(100, 25));
        lblAufgabe3.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlTabel.add(lblAufgabe3, gridBagConstraints);

        lblAufgabe4.setFont(new java.awt.Font("Dialog", 1, 12));
        lblAufgabe4.setText("Details");
        lblAufgabe4.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAufgabe4.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAufgabe4.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAufgabe4.setPreferredSize(new java.awt.Dimension(100, 25));
        lblAufgabe4.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlTabel.add(lblAufgabe4, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 4;
        getContentPane().add(pnlTabel, gridBagConstraints);

        pnlLogout.setPreferredSize(new java.awt.Dimension(400, 50));
        cmdLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/logout.gif")));
        cmdLogout.setToolTipText("Klicken Sie  auf  \"Ausloggen\" um wieder auf den Startbildschim zu gelangen!");
        cmdLogout.setMaximumSize(new java.awt.Dimension(95, 25));
        cmdLogout.setMinimumSize(new java.awt.Dimension(95, 25));
        cmdLogout.setPreferredSize(new java.awt.Dimension(30, 30));
        cmdLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLogoutActionPerformed(evt);
            }
        });

        pnlLogout.add(cmdLogout);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        getContentPane().add(pnlLogout, gridBagConstraints);

        pack();
    }//GEN-END:initComponents

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

    private void cmdLoeschen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoeschen1ActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_cmdLoeschen1ActionPerformed

    private void cmbDatenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDatenActionPerformed
        // TODO add your handling code here:
        int index = 0;
      
        
        index = cmbDaten.getSelectedIndex();
        if(index == 0) {
            new frmKundendaten().setVisible(true);
            this.hide();
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
    }//GEN-LAST:event_cmbDatenActionPerformed

   /* public class ComboAddHandler implements ActionListener {
        
    }*/
        
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDaten().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbDaten;
    private javax.swing.JButton cmdLoeschen;
    private javax.swing.JButton cmdLoeschen1;
    private javax.swing.JButton cmdLogout;
    private javax.swing.JButton cmdNeu;
    private javax.swing.JButton cmdSpeichern;
    private javax.swing.JButton cmdSuchen;
    private javax.swing.JButton cmdZurueck;
    private javax.swing.JLabel lblAufgabe2;
    private javax.swing.JLabel lblAufgabe3;
    private javax.swing.JLabel lblAufgabe4;
    private javax.swing.JPanel pnlLogout;
    private javax.swing.JPanel pnlTabel;
    private javax.swing.JPanel pnlTop;
    private javax.swing.JTable tblInfo;
    // End of variables declaration//GEN-END:variables
    
}
