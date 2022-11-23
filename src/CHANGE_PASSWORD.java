import java.awt.Dimension;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class CHANGE_PASSWORD extends javax.swing.JFrame {

    public CHANGE_PASSWORD() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/change_pass.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        new_pass_tf1 = new javax.swing.JTextField();
        cancel_pass_bt1 = new javax.swing.JButton();
        submit_pass_bt1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        con_new_pass_tf1 = new javax.swing.JPasswordField();
        change_pass = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mainpanel3.setBackground(new Color(255,0,0,0));
        mainpanel3.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("CONFIRM NEW PASSWORD");
        mainpanel3.add(jLabel3);
        jLabel3.setBounds(30, 70, 250, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("NEW PASSWORD");
        mainpanel3.add(jLabel4);
        jLabel4.setBounds(120, 20, 160, 30);

        new_pass_tf1.setToolTipText("Enter your password");
        mainpanel3.add(new_pass_tf1);
        new_pass_tf1.setBounds(300, 20, 230, 30);

        cancel_pass_bt1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        cancel_pass_bt1.setText("CANCEL");
        cancel_pass_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_pass_bt1ActionPerformed(evt);
            }
        });
        mainpanel3.add(cancel_pass_bt1);
        cancel_pass_bt1.setBounds(490, 130, 100, 30);

        submit_pass_bt1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        submit_pass_bt1.setText("SUBMIT");
        submit_pass_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_pass_bt1ActionPerformed(evt);
            }
        });
        mainpanel3.add(submit_pass_bt1);
        submit_pass_bt1.setBounds(300, 130, 100, 30);

        jLabel8.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel8.setText("or");
        mainpanel3.add(jLabel8);
        jLabel8.setBounds(430, 130, 50, 20);

        con_new_pass_tf1.setToolTipText("Re-enter your password");
        mainpanel3.add(con_new_pass_tf1);
        con_new_pass_tf1.setBounds(300, 70, 230, 30);

        getContentPane().add(mainpanel3);
        mainpanel3.setBounds(110, 90, 760, 170);

        change_pass.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        change_pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        change_pass.setText("CHANGE PASSWORD");
        getContentPane().add(change_pass);
        change_pass.setBounds(380, 10, 360, 50);

        back.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        back.setText("BACK");
        back.setToolTipText("Bcak to homepage");
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

    private void cancel_pass_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_pass_bt1ActionPerformed
        dispose();
        HOME_TESTING obj = new HOME_TESTING();
        obj.setVisible(true);
    }//GEN-LAST:event_cancel_pass_bt1ActionPerformed

    private void submit_pass_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_pass_bt1ActionPerformed
        try
        {
            
            String user = Global.user;
            System.out.println(user);
            String pass = new_pass_tf1.getText();
            String con_pass = con_new_pass_tf1.getText();

            ResultSet rs = DBLoader.executeSQL("select * from login_users where username='"+user+"'");

            if(!pass.isEmpty() && !con_pass.isEmpty())
            {
                if(pass.equals(con_pass))
                {
                    if(rs.next())
                    {
                        rs.updateString("password", con_pass);

                        rs.updateRow();
                        JOptionPane.showMessageDialog(this, "PASSWORD CHANGED !!!");
                        dispose();
                        HOME_TESTING obj = new HOME_TESTING();
                        obj.setVisible(true);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "PASSWORD IS NOT SAME");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "ALL FIELDS ARE MANDATORY");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_submit_pass_bt1ActionPerformed

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        try
        {
            ResultSet rs = DBLoader.executeSQL("select * from generated_otp");

            while(rs.next())
            {
                rs.deleteRow();
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        dispose();
        HOME_TESTING obj = new HOME_TESTING();
        obj.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

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
            java.util.logging.Logger.getLogger(CHANGE_PASSWORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CHANGE_PASSWORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CHANGE_PASSWORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CHANGE_PASSWORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CHANGE_PASSWORD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JButton cancel_pass_bt1;
    private javax.swing.JLabel change_pass;
    private javax.swing.JPasswordField con_new_pass_tf1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    public javax.swing.JPanel mainpanel3;
    private javax.swing.JTextField new_pass_tf1;
    private javax.swing.JButton submit_pass_bt1;
    // End of variables declaration//GEN-END:variables
}
