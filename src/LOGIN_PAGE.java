
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane; 

public class LOGIN_PAGE extends javax.swing.JFrame {
 
    public LOGIN_PAGE() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/login_page.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
        ImageIcon img = new ImageIcon("src/user_pic.png");
        Image im = img.getImage().getScaledInstance(user_pic.getWidth(), user_pic.getHeight(), Image.SCALE_SMOOTH);
        user_pic.setIcon(new ImageIcon(im));
        user_pic.setBounds(460, 70, 50, 50);
        
        ImageIcon img1 = new ImageIcon("src/pass_pic1.png");
        Image im1 = img1.getImage().getScaledInstance(pass_pic.getWidth(), pass_pic.getHeight(), Image.SCALE_SMOOTH);
        pass_pic.setIcon(new ImageIcon(im1));
        pass_pic.setBounds(460, 120, 100, 50);
        
        header.setBounds(0, 20, d.width, 40);
        jLabel2.setBounds(500, 80, 110, 40);
        username_tf1.setBounds(620, 80, 300, 40);
        jLabel1.setBounds(500, 130, 110, 40);
        jp1.setBounds(620, 130, 300, 40);
        forgot_pass_bt1.setBounds(850, 180, 160, 30);
        login_bt1.setBounds(660,220,150,50);
        register_bt1.setBounds(660,340,150,50);
        jLabel4.setBounds(725, 290, 30, 30);
        setVisible(true);
                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username_tf1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jp1 = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        register_bt1 = new javax.swing.JButton();
        header = new javax.swing.JLabel();
        login_bt1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        forgot_pass_bt1 = new javax.swing.JButton();
        pass_pic = new javax.swing.JLabel();
        user_pic = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        username_tf1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        username_tf1.setToolTipText("Enter the username");
        username_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                username_tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(username_tf1);
        username_tf1.setBounds(210, 80, 290, 30);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("PASSWORD");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(70, 130, 110, 30);

        jp1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jp1.setToolTipText("Enter the password");
        getContentPane().add(jp1);
        jp1.setBounds(210, 130, 290, 30);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("USERNAME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(70, 80, 110, 30);

        register_bt1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        register_bt1.setText("REGISTER");
        register_bt1.setToolTipText("Register yourself");
        register_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                register_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(register_bt1);
        register_bt1.setBounds(210, 340, 150, 50);

        header.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        header.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        header.setText("USER LOGIN");
        getContentPane().add(header);
        header.setBounds(230, 10, 230, 40);

        login_bt1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        login_bt1.setText("LOGIN");
        login_bt1.setToolTipText("Click here to login");
        login_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                login_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(login_bt1);
        login_bt1.setBounds(210, 220, 150, 50);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 25)); // NOI18N
        jLabel4.setText("or");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(270, 290, 40, 26);

        forgot_pass_bt1.setText("FORGOT PASSWORD?");
        forgot_pass_bt1.setToolTipText("Reset your password");
        forgot_pass_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forgot_pass_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(forgot_pass_bt1);
        forgot_pass_bt1.setBounds(430, 170, 160, 25);

        pass_pic.setBackground(new Color(255,0,0,0));
        getContentPane().add(pass_pic);
        pass_pic.setBounds(30, 130, 30, 40);

        user_pic.setBackground(new Color(255,0,0,0));
        getContentPane().add(user_pic);
        user_pic.setBounds(30, 80, 30, 40);

        bg.setText("jLabel3");
        getContentPane().add(bg);
        bg.setBounds(20, 20, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void username_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_username_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_username_tf1ActionPerformed

    private void register_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_register_bt1ActionPerformed
        dispose();
        REGISTER_PAGE obj = new REGISTER_PAGE();
        obj.setVisible(true);
    }//GEN-LAST:event_register_bt1ActionPerformed

    private void login_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_login_bt1ActionPerformed
        try
        {
            String u = username_tf1.getText();
            String p = jp1.getText();
            String f_name;
            String l_name;
            
            if(!u.isEmpty() && !p.isEmpty())
            {            
                ResultSet rs = DBLoader.executeSQL("select * from login_users where username='"+u+"' and password='"+p+"'");
                if(rs.next())
                {
                    f_name = rs.getString("first_name");
                    l_name = rs.getString("last_name");
                    JOptionPane.showMessageDialog(this, "LOGIN SUCCESSFULL!!!");
                    Global.username = "WELCOME  "+f_name+"  "+l_name;
                    Global.user = u;
                    dispose();
                    welcome obj = new welcome();
                    obj.setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(this, "INVALID USERNAME OR PASSWORD");
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
    }//GEN-LAST:event_login_bt1ActionPerformed

    private void forgot_pass_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forgot_pass_bt1ActionPerformed
        dispose();
        FORGOT_PASSWORD obj = new FORGOT_PASSWORD();
        obj.setVisible(true);
    }//GEN-LAST:event_forgot_pass_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(LOGIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN_PAGE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LOGIN_PAGE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton forgot_pass_bt1;
    private javax.swing.JLabel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jp1;
    private javax.swing.JButton login_bt1;
    private javax.swing.JLabel pass_pic;
    private javax.swing.JButton register_bt1;
    private javax.swing.JLabel user_pic;
    public javax.swing.JTextField username_tf1;
    // End of variables declaration//GEN-END:variables
}
