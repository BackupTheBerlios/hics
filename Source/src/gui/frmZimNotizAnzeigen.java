/*
 * frmInfo.java
 *
 * Created on 21. April 2005, 08:10
 */

package gui;

/**
 *
 * @author  Standard
 */
public class frmZimNotizAnzeigen extends javax.swing.JFrame {
    public static int WIDTH=450;
    public static int HEIGHT=350;
    public static String TITLE="HICS - Informationen";
    
    /** Creates new form frmInfo */
    public frmZimNotizAnzeigen() {
        super(TITLE);
        initComponents();
        setSize(WIDTH, HEIGHT);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        pnlInformation = new javax.swing.JPanel();
        cmdSpeichern = new javax.swing.JButton();
        cmdAbbrechen = new javax.swing.JButton();
        jList1 = new javax.swing.JList();
        tblInfo = new javax.swing.JTable();
        lblAufgabe2 = new javax.swing.JLabel();
        lblAufgabe3 = new javax.swing.JLabel();
        lblAufgabe4 = new javax.swing.JLabel();
        lblAufgabe5 = new javax.swing.JLabel();
        pnlZurueck = new javax.swing.JPanel();
        cmdLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pnlInformation.setLayout(new java.awt.GridBagLayout());

        pnlInformation.setBorder(new javax.swing.border.EtchedBorder());
        cmdSpeichern.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/speichern.gif")));
        cmdSpeichern.setText("Speichern");
        cmdSpeichern.setToolTipText("Klicken Sie hier um die ge\u00e4nderten Daten zu speichern!");
        cmdSpeichern.setMaximumSize(new java.awt.Dimension(95, 30));
        cmdSpeichern.setMinimumSize(new java.awt.Dimension(95, 30));
        cmdSpeichern.setOpaque(false);
        cmdSpeichern.setPreferredSize(new java.awt.Dimension(125, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 80, 6, 0);
        pnlInformation.add(cmdSpeichern, gridBagConstraints);

        cmdAbbrechen.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/abbrechen.gif")));
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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 10, 6, 0);
        pnlInformation.add(cmdAbbrechen, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        pnlInformation.add(jList1, gridBagConstraints);

        tblInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"100", "neues Wasser f�r die Blumen", "Farn aussen", new Boolean(false)},
                {"020", "Bett nicht machen", null, null}
            },
            new String [] {
                "Zimmernr", "Aufgabe", "Details", "erledigt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblInfo.setGridColor(new java.awt.Color(0, 0, 0));
        tblInfo.setSelectionBackground(new java.awt.Color(153, 153, 255));
        tblInfo.setSurrendersFocusOnKeystroke(true);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 320;
        gridBagConstraints.ipady = 148;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(34, 10, 0, 10);
        pnlInformation.add(tblInfo, gridBagConstraints);

        lblAufgabe2.setFont(new java.awt.Font("Dialog", 1, 12));
        lblAufgabe2.setText("Zimmernr");
        lblAufgabe2.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAufgabe2.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAufgabe2.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAufgabe2.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAufgabe2.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 0, 0);
        pnlInformation.add(lblAufgabe2, gridBagConstraints);

        lblAufgabe3.setFont(new java.awt.Font("Dialog", 1, 12));
        lblAufgabe3.setText("Aufgabe");
        lblAufgabe3.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAufgabe3.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAufgabe3.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAufgabe3.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAufgabe3.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pnlInformation.add(lblAufgabe3, gridBagConstraints);

        lblAufgabe4.setFont(new java.awt.Font("Dialog", 1, 12));
        lblAufgabe4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAufgabe4.setText("Details");
        lblAufgabe4.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAufgabe4.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAufgabe4.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAufgabe4.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAufgabe4.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        pnlInformation.add(lblAufgabe4, gridBagConstraints);

        lblAufgabe5.setFont(new java.awt.Font("Dialog", 1, 12));
        lblAufgabe5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAufgabe5.setText("Erledigt");
        lblAufgabe5.setBorder(new javax.swing.border.BevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblAufgabe5.setMaximumSize(new java.awt.Dimension(95, 25));
        lblAufgabe5.setMinimumSize(new java.awt.Dimension(95, 25));
        lblAufgabe5.setPreferredSize(new java.awt.Dimension(95, 25));
        lblAufgabe5.setRequestFocusEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 10);
        pnlInformation.add(lblAufgabe5, gridBagConstraints);

        getContentPane().add(pnlInformation, java.awt.BorderLayout.CENTER);

        pnlZurueck.setBorder(new javax.swing.border.EtchedBorder());
        cmdLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("gifs/logout.gif")));
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

        pnlZurueck.add(cmdLogout);

        getContentPane().add(pnlZurueck, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void cmdLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLogoutActionPerformed
        // TODO add your handling code here:
        this.hide();
        new frmStart().setVisible(true);
    }//GEN-LAST:event_cmdLogoutActionPerformed

    private void cmdAbbrechenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAbbrechenActionPerformed
        // TODO add your handling code here:
        return;
    }//GEN-LAST:event_cmdAbbrechenActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmZimNotizAnzeigen().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAbbrechen;
    private javax.swing.JButton cmdLogout;
    private javax.swing.JButton cmdSpeichern;
    private javax.swing.JList jList1;
    private javax.swing.JLabel lblAufgabe2;
    private javax.swing.JLabel lblAufgabe3;
    private javax.swing.JLabel lblAufgabe4;
    private javax.swing.JLabel lblAufgabe5;
    private javax.swing.JPanel pnlInformation;
    private javax.swing.JPanel pnlZurueck;
    private javax.swing.JTable tblInfo;
    // End of variables declaration//GEN-END:variables
  
}
