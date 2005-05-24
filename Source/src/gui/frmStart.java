/*
 * frmStart.java
 *
 * Created on 21. April 2005, 14:16
 */

package gui;

/**
 *
 * @author  Standard
 */
public class frmStart extends javax.swing.JFrame {
    public static int WIDTH=450;
    public static int HEIGHT=350;
    public static String TITLE="HICS - Start";
    
    /** Creates new form frmStart */
    public frmStart() {
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
        pnlStart = new javax.swing.JPanel();
        lblStart = new javax.swing.JLabel();
        lblStart1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblBenutzername = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        lblKennwort = new javax.swing.JLabel();
        pwdKennwort = new javax.swing.JPasswordField();
        cmdLogin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        pnlStart.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlStart.setMinimumSize(new java.awt.Dimension(181, 44));
        pnlStart.setPreferredSize(new java.awt.Dimension(181, 44));
        lblStart.setFont(new java.awt.Font("Banjoman Open Bold", 0, 24));
        lblStart.setText("Herzlich willkommen bei HICS!");
        pnlStart.add(lblStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        lblStart1.setFont(new java.awt.Font("Banjoman Open Bold", 0, 18));
        lblStart1.setIcon(new javax.swing.ImageIcon("D:\\Universitšt\\Informatik2\\Sem6\\Software Engineering 2\\Projekt\\Code\\HICS_v1_0\\Logo_klein.jpg"));
        pnlStart.add(lblStart1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        getContentPane().add(pnlStart, java.awt.BorderLayout.CENTER);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel1.setPreferredSize(new java.awt.Dimension(383, 70));
        lblBenutzername.setText("Benutzername");
        jPanel1.add(lblBenutzername, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 9, -1, -1));

        jTextField1.setText("Benutzername");
        jTextField1.setToolTipText("Tragen Sie hier Ihren Benutzenamen ein! Achten Sie auf Gro\u00df- und Kleinschreibung!");
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 9, -1, -1));

        lblKennwort.setText("Kennwort");
        lblKennwort.setMaximumSize(new java.awt.Dimension(80, 16));
        lblKennwort.setMinimumSize(new java.awt.Dimension(80, 16));
        lblKennwort.setPreferredSize(new java.awt.Dimension(80, 16));
        jPanel1.add(lblKennwort, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 35, -1, -1));

        pwdKennwort.setToolTipText("Geben Sie hier Ihr Kennwort ein!  Anstelle des Kennwortes erscheinen \"*\"-Zeichen.  Achten Sie auf Gro\u00df- und Kleinschreibung!");
        pwdKennwort.setPreferredSize(new java.awt.Dimension(86, 23));
        jPanel1.add(pwdKennwort, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 35, -1, -1));

        cmdLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gifs/login.gif")));
        cmdLogin.setText("Login");
        cmdLogin.setToolTipText("Geben Sie Ihren Benutzernamen und Ihr Kennwort in die entsprechenden Felder ein und\n klicken Sie anschlie\u00dfend auf  \"Login\" um einzuloggen!  Achten Sie auf Gro\u00df- und Kleinschreibung!");
        cmdLogin.setMaximumSize(new java.awt.Dimension(86, 25));
        cmdLogin.setMinimumSize(new java.awt.Dimension(86, 25));
        cmdLogin.setPreferredSize(new java.awt.Dimension(125, 30));
        cmdLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdLoginActionPerformed(evt);
            }
        });

        jPanel1.add(cmdLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 17, -1, -1));

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        pack();
    }//GEN-END:initComponents

    private void cmdLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdLoginActionPerformed
        // TODO add your handling code here:
        this.hide();
        new frmAnzeige().setVisible(true);
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
    private javax.swing.JButton cmdLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblBenutzername;
    private javax.swing.JLabel lblKennwort;
    private javax.swing.JLabel lblStart;
    private javax.swing.JLabel lblStart1;
    private javax.swing.JPanel pnlStart;
    private javax.swing.JPasswordField pwdKennwort;
    // End of variables declaration//GEN-END:variables
    
    
    
}
