
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class FAV_MOVIES extends javax.swing.JFrame {

    public FAV_MOVIES() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/fav_movies.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
        setVisible(true);

        jScrollPane1.setVisible(false);
        get_data();
    }
    
    void get_data()
    {
        mainpanel.repaint();
        mainpanel.removeAll();
        jScrollPane1.setVisible(false);
        try {
            ResultSet rs = DBLoader.executeSQL("select * from mv_list where username='"+Global.user+"'");

            int x = 10, y = 10, j = 0;

            while (rs.next()) {
                j++;
                FAV_SHOWS_DESIGN obj = new FAV_SHOWS_DESIGN();

                jScrollPane1.setVisible(true);
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String photo = rs.getString("photo");

                obj.name.setText(name);

                obj.remove.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        ResultSet rs1 = DBLoader.executeSQL("select * from mv_list where id=" + id+" and username='"+Global.user+"'");
                        try {
                            if (rs1.next()) {
                                rs1.deleteRow();
                                get_data();
                            } else {
                                JOptionPane.showMessageDialog(null, "ALREADY DELETED");
                            }
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                });

                URL url = new URL("https://image.tmdb.org/t/p/original/"+photo);

                BufferedImage img = ImageIO.read(url);

                Image im = img.getScaledInstance(obj.photo.getWidth(), obj.photo.getHeight(), BufferedImage.SCALE_SMOOTH);

                obj.photo.setIcon(new ImageIcon(im));

                obj.setBounds(10, y, 500, 200);

                mainpanel.add(obj);

                y = y + 210;

                repaint();
                mainpanel.repaint();
                obj.repaint();
            }
            int ss = 210 * j;
            mainpanel.setPreferredSize(new Dimension(510, ss));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fav_lb2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        fav_lb2.setFont(new java.awt.Font("Algerian", 0, 36)); // NOI18N
        fav_lb2.setText("FAVOURITE MOVIES");
        getContentPane().add(fav_lb2);
        fav_lb2.setBounds(360, 20, 340, 40);

        mainpanel.setBackground(new Color(255,0,0,0));

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 957, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 417, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 100, 960, 420);

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
        bg.setBounds(50, 70, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
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
            java.util.logging.Logger.getLogger(FAV_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FAV_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FAV_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FAV_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FAV_MOVIES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel fav_lb2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
