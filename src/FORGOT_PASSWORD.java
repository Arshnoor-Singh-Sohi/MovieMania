
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FORGOT_PASSWORD extends javax.swing.JFrame {

    public FORGOT_PASSWORD() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/forgot_pass.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
        forgot_pass.setBounds(0,20,d.width,40);
        mainpanel1.setBounds(140, 80, 800, 200);
        mainpanel1.setVisible(true);
        mainpanel2.setVisible(false);
        mainpanel3.setVisible(false);
        
        user_tf1.requestFocus();
        
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        user_tf1 = new javax.swing.JTextField();
        generate_otp_bt1 = new javax.swing.JButton();
        mainpanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        confirm_otp_tf1 = new javax.swing.JPasswordField();
        cancel_otp_bt1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        regenerate_otp_bt1 = new javax.swing.JButton();
        submit_otp_bt1 = new javax.swing.JButton();
        mainpanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        new_pass_tf1 = new javax.swing.JTextField();
        cancel_pass_bt1 = new javax.swing.JButton();
        submit_pass_bt1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        con_new_pass_tf1 = new javax.swing.JPasswordField();
        forgot_pass = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mainpanel1.setBackground(new Color(255,0,0,0));
        mainpanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setText("USERNAME");
        mainpanel1.add(jLabel1);
        jLabel1.setBounds(41, 24, 120, 30);

        user_tf1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        user_tf1.setToolTipText("Enter your username");
        mainpanel1.add(user_tf1);
        user_tf1.setBounds(170, 20, 350, 40);

        generate_otp_bt1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        generate_otp_bt1.setText("GENERATE OTP");
        generate_otp_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_otp_bt1ActionPerformed(evt);
            }
        });
        mainpanel1.add(generate_otp_bt1);
        generate_otp_bt1.setBounds(170, 80, 160, 30);

        getContentPane().add(mainpanel1);
        mainpanel1.setBounds(140, 80, 760, 130);

        mainpanel2.setBackground(new Color(255,0,0,0));
        mainpanel2.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setText("OTP");
        mainpanel2.add(jLabel2);
        jLabel2.setBounds(90, 30, 60, 24);

        confirm_otp_tf1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        confirm_otp_tf1.setToolTipText("Enter the OTP");
        mainpanel2.add(confirm_otp_tf1);
        confirm_otp_tf1.setBounds(170, 20, 170, 40);

        cancel_otp_bt1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        cancel_otp_bt1.setText("CANCEL");
        cancel_otp_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel_otp_bt1ActionPerformed(evt);
            }
        });
        mainpanel2.add(cancel_otp_bt1);
        cancel_otp_bt1.setBounds(360, 90, 100, 30);

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 22)); // NOI18N
        jLabel5.setText("or");
        mainpanel2.add(jLabel5);
        jLabel5.setBounds(300, 90, 50, 20);

        regenerate_otp_bt1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        regenerate_otp_bt1.setText("RE-GENERATE OTP");
        regenerate_otp_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regenerate_otp_bt1ActionPerformed(evt);
            }
        });
        mainpanel2.add(regenerate_otp_bt1);
        regenerate_otp_bt1.setBounds(190, 140, 230, 30);

        submit_otp_bt1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        submit_otp_bt1.setText("SUBMIT");
        submit_otp_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_otp_bt1ActionPerformed(evt);
            }
        });
        mainpanel2.add(submit_otp_bt1);
        submit_otp_bt1.setBounds(170, 90, 100, 30);

        getContentPane().add(mainpanel2);
        mainpanel2.setBounds(140, 220, 760, 180);

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

        new_pass_tf1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
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

        con_new_pass_tf1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        con_new_pass_tf1.setToolTipText("Re-enter your password");
        mainpanel3.add(con_new_pass_tf1);
        con_new_pass_tf1.setBounds(300, 70, 230, 30);

        getContentPane().add(mainpanel3);
        mainpanel3.setBounds(140, 410, 760, 170);

        forgot_pass.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        forgot_pass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgot_pass.setText("FORGOT PASSWORD");
        getContentPane().add(forgot_pass);
        forgot_pass.setBounds(380, 10, 360, 50);

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

        bg.setText("jLabel6");
        getContentPane().add(bg);
        bg.setBounds(20, 90, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generate_otp_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_otp_bt1ActionPerformed
        try
        {
            String user = user_tf1.getText();
            ResultSet rs = DBLoader.executeSQL("select * from login_users where username='"+user+"'");
            
            if(rs.next())
            {
                int a = (int) (100000 + (999999 - 100000)*Math.random());
                
                ResultSet rs1 = DBLoader.executeSQL("select * from generated_otp where otp="+a);
                
                if(!rs1.next())
                {
                    rs1.moveToInsertRow();
                    
                    rs1.updateInt("otp", a);
                    
                    rs1.insertRow();
                }
                
                JOptionPane.showMessageDialog(this, "YOUR OTP IS "+a);
                mainpanel2.setBounds(140, 80, 800, 200);
                mainpanel1.setVisible(false);
                mainpanel2.setVisible(true);
                regenerate_otp_bt1.setVisible(false);
                                                
            }
            else
            {
                JOptionPane.showMessageDialog(this, "INVALID USERNAME OR NOT A USER");
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_generate_otp_bt1ActionPerformed

    private void regenerate_otp_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regenerate_otp_bt1ActionPerformed
        try
        {
            int a = (int) (100000 + (999999 - 100000)*Math.random());
                
                ResultSet rs1 = DBLoader.executeSQL("select * from generated_otp where otp="+a);
                
                if(!rs1.next())
                {
                    rs1.moveToInsertRow();
                    
                    rs1.updateInt("otp", a);
                    
                    rs1.insertRow();
                }
                
                JOptionPane.showMessageDialog(this, "YOUR OTP IS "+a);
//                mainpanel2.setBounds(140, 80, 800, 200);
//                mainpanel1.setVisible(false);
//                mainpanel2.setVisible(true);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_regenerate_otp_bt1ActionPerformed

    private void submit_otp_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_otp_bt1ActionPerformed
        try
        {
            ResultSet rs = DBLoader.executeSQL("select * from generated_otp");
            
            if(rs.next())
            {
                int otp = rs.getInt("otp");
                int con_otp = Integer.parseInt(confirm_otp_tf1.getText());
                if(otp == con_otp)
                {
                    rs.deleteRow();
                    mainpanel3.setBounds(140, 80, 800, 200);
                    mainpanel2.setVisible(false);
                    mainpanel3.setVisible(true);
                }
                else  
                {
                    JOptionPane.showMessageDialog(this, "INVALID OTP");
                    rs.deleteRow();
                    regenerate_otp_bt1.setVisible(true);
                    Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        
                    bg.setSize(d.width, d.height);
                    ImageIcon img2 = new ImageIcon("src/forgot_pass.jpg");
                    Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
                    bg.setIcon(new ImageIcon(im2));
                    bg.setBounds(0, 0, d.width, d.height);
                }
            }
            
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_submit_otp_bt1ActionPerformed

    private void cancel_otp_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_otp_bt1ActionPerformed
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
        LOGIN_PAGE obj = new LOGIN_PAGE();
        obj.setVisible(true);
    }//GEN-LAST:event_cancel_otp_bt1ActionPerformed

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
        LOGIN_PAGE obj = new LOGIN_PAGE();
        obj.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void submit_pass_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_pass_bt1ActionPerformed
        try
        {
            String user = user_tf1.getText();
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
    }//GEN-LAST:event_submit_pass_bt1ActionPerformed

    private void cancel_pass_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel_pass_bt1ActionPerformed
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
        LOGIN_PAGE obj = new LOGIN_PAGE();
        obj.setVisible(true);
    }//GEN-LAST:event_cancel_pass_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(FORGOT_PASSWORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FORGOT_PASSWORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FORGOT_PASSWORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FORGOT_PASSWORD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FORGOT_PASSWORD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JButton cancel_otp_bt1;
    private javax.swing.JButton cancel_pass_bt1;
    private javax.swing.JPasswordField con_new_pass_tf1;
    private javax.swing.JPasswordField confirm_otp_tf1;
    private javax.swing.JLabel forgot_pass;
    private javax.swing.JButton generate_otp_bt1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel mainpanel1;
    private javax.swing.JPanel mainpanel2;
    public javax.swing.JPanel mainpanel3;
    private javax.swing.JTextField new_pass_tf1;
    private javax.swing.JButton regenerate_otp_bt1;
    private javax.swing.JButton submit_otp_bt1;
    private javax.swing.JButton submit_pass_bt1;
    private javax.swing.JTextField user_tf1;
    // End of variables declaration//GEN-END:variables
}
