import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class REGISTER_PAGE extends javax.swing.JFrame {

    public REGISTER_PAGE() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/register.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
        jLabel1.setBounds(0, 20, d.width, 40);
        jLabel3.setBounds(500, 100, 120, 40);
        f_name_tf1.setBounds(630, 100, 300, 40);
        jLabel4.setBounds(500, 150, 120, 40);
        l_name_tf2.setBounds(630, 150, 300, 40);
        jLabel5.setBounds(500, 200, 120, 40);
        username_tf3.setBounds(630, 200, 300, 40);
        jLabel6.setBounds(500, 250, 120, 40);
        pass_tf4.setBounds(630, 250, 300, 40);
        jLabel2.setBounds(410, 300, 200, 40);
        confirm_pass_tf5.setBounds(630, 300, 300, 40);
        sign_up_bt1.setBounds(660, 380, 150, 50);
        already_user_bt1.setBounds(640, 500, 200, 50);
        jLabel7.setBounds(725, 450, 30, 30);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        f_name_tf1 = new javax.swing.JTextField();
        username_tf3 = new javax.swing.JTextField();
        l_name_tf2 = new javax.swing.JTextField();
        already_user_bt1 = new javax.swing.JButton();
        sign_up_bt1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        confirm_pass_tf5 = new javax.swing.JPasswordField();
        pass_tf4 = new javax.swing.JPasswordField();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SIGN UP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 20, 110, 40);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("CONFIRM PASSWORD");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 300, 170, 30);

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel3.setText("FIRST NAME");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 110, 120, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel4.setText("LAST NAME");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(110, 150, 120, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("USERNAME");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(110, 200, 120, 30);

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("PASSWORD");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(100, 250, 100, 30);

        f_name_tf1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        f_name_tf1.setToolTipText("Enter your First Name");
        getContentPane().add(f_name_tf1);
        f_name_tf1.setBounds(230, 100, 250, 40);

        username_tf3.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        username_tf3.setToolTipText("Enter your username");
        getContentPane().add(username_tf3);
        username_tf3.setBounds(230, 200, 250, 40);

        l_name_tf2.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        l_name_tf2.setToolTipText("Enter your Last Name");
        getContentPane().add(l_name_tf2);
        l_name_tf2.setBounds(230, 150, 250, 40);

        already_user_bt1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        already_user_bt1.setText("ALREADY USER?");
        already_user_bt1.setToolTipText("Click here if you are already a user");
        already_user_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                already_user_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(already_user_bt1);
        already_user_bt1.setBounds(250, 500, 200, 50);

        sign_up_bt1.setFont(new java.awt.Font("Dialog", 0, 20)); // NOI18N
        sign_up_bt1.setText("SIGN UP");
        sign_up_bt1.setToolTipText("Click here to sign-up");
        sign_up_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_up_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(sign_up_bt1);
        sign_up_bt1.setBounds(270, 380, 150, 50);

        jLabel7.setFont(new java.awt.Font("Dialog", 0, 30)); // NOI18N
        jLabel7.setText("or");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(330, 450, 40, 30);

        confirm_pass_tf5.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        confirm_pass_tf5.setToolTipText("Re-enter your password");
        getContentPane().add(confirm_pass_tf5);
        confirm_pass_tf5.setBounds(230, 300, 250, 40);

        pass_tf4.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pass_tf4.setToolTipText("Enter your password");
        getContentPane().add(pass_tf4);
        pass_tf4.setBounds(230, 250, 250, 40);

        bg.setText("jLabel8");
        getContentPane().add(bg);
        bg.setBounds(20, 40, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void already_user_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_already_user_bt1ActionPerformed
        dispose();
        LOGIN_PAGE obj = new LOGIN_PAGE();
        obj.setVisible(true);
    }//GEN-LAST:event_already_user_bt1ActionPerformed

    private void sign_up_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sign_up_bt1ActionPerformed
        try
        {
            String f_name = f_name_tf1.getText();
            String l_name = l_name_tf2.getText();
            String username = username_tf3.getText();
            String password = pass_tf4.getText();
            String con_pass = confirm_pass_tf5.getText();
            
            if(!f_name.isEmpty() && !username.isEmpty() && !password.isEmpty() && !con_pass.isEmpty())
            {
                if(password.equals(con_pass))
                {
                    ResultSet rs = DBLoader.executeSQL("select * from login_users where username='"+username+"'");
                
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(this, "ALREADY A USER");
                    }
                    else
                    {
                        rs.moveToInsertRow();
                    
                        rs.updateString("username", username);
                        rs.updateString("password", password);
                        rs.updateString("first_name", f_name);
                        rs.updateString("last_name", l_name);
                    
                        rs.insertRow();
                        JOptionPane.showMessageDialog(this, "USER REGISTERED !!!");
                        dispose();
                        LOGIN_PAGE obj = new LOGIN_PAGE();
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
    }//GEN-LAST:event_sign_up_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(REGISTER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(REGISTER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(REGISTER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(REGISTER_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new REGISTER_PAGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton already_user_bt1;
    private javax.swing.JLabel bg;
    private javax.swing.JPasswordField confirm_pass_tf5;
    private javax.swing.JTextField f_name_tf1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField l_name_tf2;
    private javax.swing.JPasswordField pass_tf4;
    private javax.swing.JButton sign_up_bt1;
    private javax.swing.JTextField username_tf3;
    // End of variables declaration//GEN-END:variables
}
