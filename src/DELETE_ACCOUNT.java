import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class DELETE_ACCOUNT extends javax.swing.JFrame {


    public DELETE_ACCOUNT() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/change_pass.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);

        
        del_acc_pass_tf1.requestFocus();
        setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        del_acc_pass_tf1 = new javax.swing.JPasswordField();
        submit_pass_bt1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cancel_pass_bt1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new Color(255,0,0,0));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("ENTER YOUR PASSWORD ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(30, 40, 250, 30);

        del_acc_pass_tf1.setToolTipText("Enter your password");
        del_acc_pass_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                del_acc_pass_tf1ActionPerformed(evt);
            }
        });
        jPanel1.add(del_acc_pass_tf1);
        del_acc_pass_tf1.setBounds(290, 30, 330, 40);

        submit_pass_bt1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        submit_pass_bt1.setText("DELETE ACCOUNT");
        submit_pass_bt1.setToolTipText("");
        submit_pass_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_pass_bt1ActionPerformed(evt);
            }
        });
        jPanel1.add(submit_pass_bt1);
        submit_pass_bt1.setBounds(220, 110, 180, 30);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel8.setText("or");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(420, 110, 50, 20);

        cancel_pass_bt1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        cancel_pass_bt1.setText("CANCEL");
        cancel_pass_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_pass_bt1ActionPerformed(evt);
            }
        });
        jPanel1.add(cancel_pass_bt1);
        cancel_pass_bt1.setBounds(470, 110, 100, 30);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(140, 70, 720, 150);

        back.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        back.setText("BACK");
        back.setToolTipText("Back to homepage");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });
        getContentPane().add(back);
        back.setBounds(10, 10, 80, 30);

        bg.setText("jLabel1");
        getContentPane().add(bg);
        bg.setBounds(40, 70, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void del_acc_pass_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_del_acc_pass_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_del_acc_pass_tf1ActionPerformed

    private void submit_pass_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_pass_bt1ActionPerformed
        try
        {
            String user = Global.user;
            String pass = del_acc_pass_tf1.getText();

            ResultSet rs = DBLoader.executeSQL("select * from login_users where username='"+user+"' and password='"+pass+"'");

            if(!pass.isEmpty())
            {
                
                int result = JOptionPane.showConfirmDialog(this, "DO YOU WANT TO DELETE YOUR ACCOUNT?", "DELETE CONFIRMATION", JOptionPane.YES_NO_OPTION);
                if(result==JOptionPane.YES_OPTION)
                {
                    if(rs.next())
                    {
                        ResultSet rs2 = DBLoader.executeSQL("select * from mv_list where username='"+Global.user+"'");
                        while(rs2.next())
                        {
                            rs2.deleteRow();
                        }
                        ResultSet rs3 = DBLoader.executeSQL("select * from tv_list where username='"+Global.user+"'");
                        while(rs3.next())
                        {
                            rs3.deleteRow();
                        }
                        rs.deleteRow();
                        JOptionPane.showMessageDialog(this, "YOUR ACCOUNT IS DELETED!!!");
                        dispose();
                        LOGIN_PAGE obj = new LOGIN_PAGE();
                        obj.setVisible(true); 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "PASSWORD IS WRONG");
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "PASSWORD FIELD IS EMPTY");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_submit_pass_bt1ActionPerformed

    private void cancel_pass_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_pass_bt1ActionPerformed
        dispose();
        HOME_TESTING obj = new HOME_TESTING();
        obj.setVisible(true);
    }//GEN-LAST:event_cancel_pass_bt1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        HOME_TESTING obj = new HOME_TESTING();
        obj.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DELETE_ACCOUNT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DELETE_ACCOUNT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DELETE_ACCOUNT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DELETE_ACCOUNT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DELETE_ACCOUNT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JButton cancel_pass_bt1;
    private javax.swing.JPasswordField del_acc_pass_tf1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton submit_pass_bt1;
    // End of variables declaration//GEN-END:variables
}
