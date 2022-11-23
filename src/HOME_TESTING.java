
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.ImageIcon;

public class HOME_TESTING extends javax.swing.JFrame {

    public HOME_TESTING() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/hall.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
        welcome.setBounds(0,70,d.width,40);
        
        upcoming_movies.setBounds(390, 340, 230, 60);
        search_movies.setBounds(670, 340, 230, 60);
        search_tv_shows_bt.setBounds(950, 340, 230, 60);
        search_actor.setBounds(390, 460, 230, 60);
        search_company.setBounds(670, 460, 230, 60);
        fav_movies_bt.setBounds(950, 460, 230, 60);
        genre_tvl.setBounds(390, 580, 230, 60);
        genre_ml1.setBounds(670, 580, 230, 60);
        fav_tv_bt.setBounds(950, 580, 230, 60);
        
        jComboBox1.setBounds(1385, 10, 135, 40);
        welcome.setText(Global.username);
        welcome.setForeground(new java.awt.Color(222, 222, 222));
            
        setVisible(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genre_tvl = new javax.swing.JButton();
        upcoming_movies = new javax.swing.JButton();
        search_movies = new javax.swing.JButton();
        search_actor = new javax.swing.JButton();
        search_company = new javax.swing.JButton();
        genre_ml1 = new javax.swing.JButton();
        search_tv_shows_bt = new javax.swing.JButton();
        fav_tv_bt = new javax.swing.JButton();
        fav_movies_bt = new javax.swing.JButton();
        welcome = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        genre_tvl.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        genre_tvl.setText("GENRE TV LIST");
        genre_tvl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genre_tvlActionPerformed(evt);
            }
        });
        getContentPane().add(genre_tvl);
        genre_tvl.setBounds(200, 380, 230, 60);

        upcoming_movies.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        upcoming_movies.setText("UPCOMING MOVIES");
        upcoming_movies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upcoming_moviesActionPerformed(evt);
            }
        });
        getContentPane().add(upcoming_movies);
        upcoming_movies.setBounds(200, 140, 230, 60);

        search_movies.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        search_movies.setText("SEARCH MOVIES");
        search_movies.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_moviesActionPerformed(evt);
            }
        });
        getContentPane().add(search_movies);
        search_movies.setBounds(480, 140, 230, 60);

        search_actor.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        search_actor.setText("SEARCH ACTORS");
        search_actor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_actorActionPerformed(evt);
            }
        });
        getContentPane().add(search_actor);
        search_actor.setBounds(200, 260, 230, 60);

        search_company.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        search_company.setText("SEARCH COMPANY");
        search_company.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_companyActionPerformed(evt);
            }
        });
        getContentPane().add(search_company);
        search_company.setBounds(480, 260, 230, 60);

        genre_ml1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        genre_ml1.setText("GENRE MOVIES LIST");
        genre_ml1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                genre_ml1ActionPerformed(evt);
            }
        });
        getContentPane().add(genre_ml1);
        genre_ml1.setBounds(480, 380, 230, 60);

        search_tv_shows_bt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        search_tv_shows_bt.setText("SEARCH TV SHOWS");
        search_tv_shows_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_tv_shows_btActionPerformed(evt);
            }
        });
        getContentPane().add(search_tv_shows_bt);
        search_tv_shows_bt.setBounds(760, 140, 230, 60);

        fav_tv_bt.setFont(new java.awt.Font("Dialog", 0, 17)); // NOI18N
        fav_tv_bt.setText("FAVOURITE TV SHOWS");
        fav_tv_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fav_tv_btActionPerformed(evt);
            }
        });
        getContentPane().add(fav_tv_bt);
        fav_tv_bt.setBounds(760, 380, 230, 60);

        fav_movies_bt.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        fav_movies_bt.setText("FAVOURITE MOVIES");
        fav_movies_bt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fav_movies_btActionPerformed(evt);
            }
        });
        getContentPane().add(fav_movies_bt);
        fav_movies_bt.setBounds(760, 260, 230, 60);

        welcome.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(welcome);
        welcome.setBounds(280, 10, 710, 50);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "USER", "CHANGE PASSWORD", "DELETE ACCOUNT", "LOG OUT" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(20, 90, 130, 24);

        bg.setText("jLabel1");
        getContentPane().add(bg);
        bg.setBounds(50, 10, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void search_moviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_moviesActionPerformed
        dispose();
        SEARCH_MOVIES obj = new SEARCH_MOVIES();
        obj.setVisible(true);
    }//GEN-LAST:event_search_moviesActionPerformed

    private void upcoming_moviesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upcoming_moviesActionPerformed
        dispose();
        UPCOMING_MOVIES obj = new UPCOMING_MOVIES();
        obj.setVisible(true);
    }//GEN-LAST:event_upcoming_moviesActionPerformed

    private void search_actorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_actorActionPerformed
        dispose();
        SEARCH_PEOPLE obj = new SEARCH_PEOPLE();
        obj.setVisible(true);
    }//GEN-LAST:event_search_actorActionPerformed

    private void search_companyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_companyActionPerformed
        dispose();
        SEARCH_COMPANY obj = new SEARCH_COMPANY();
        obj.setVisible(true);
    }//GEN-LAST:event_search_companyActionPerformed

    private void genre_tvlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genre_tvlActionPerformed
        dispose();
        GENRE_TV_LIST obj = new GENRE_TV_LIST();
    }//GEN-LAST:event_genre_tvlActionPerformed

    private void genre_ml1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_genre_ml1ActionPerformed
        dispose();
        GENRE_MOVIE_LIST obj = new GENRE_MOVIE_LIST();
        obj.setVisible(true);
    }//GEN-LAST:event_genre_ml1ActionPerformed

    private void search_tv_shows_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_tv_shows_btActionPerformed
        dispose();
        SEARCH_TV_SHOWS obj = new SEARCH_TV_SHOWS();
        obj.setVisible(true);
    }//GEN-LAST:event_search_tv_shows_btActionPerformed

    private void fav_movies_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fav_movies_btActionPerformed
        dispose();
        FAV_MOVIES obj = new FAV_MOVIES();
        obj.setVisible(true);
    }//GEN-LAST:event_fav_movies_btActionPerformed

    private void fav_tv_btActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fav_tv_btActionPerformed
        dispose();
        FAV_SHOWS obj = new FAV_SHOWS();
        obj.setVisible(true);
    }//GEN-LAST:event_fav_tv_btActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String itemselected = jComboBox1.getSelectedItem()+"";
        if(itemselected.equals("CHANGE PASSWORD"))
        {
            dispose();
            CHANGE_PASSWORD obj = new CHANGE_PASSWORD();
            obj.setVisible(true);
        }
        else if(itemselected.equals("DELETE ACCOUNT"))
        {
            dispose();
            DELETE_ACCOUNT obj = new DELETE_ACCOUNT();
            obj.setVisible(true);
        }
        else if(itemselected.equals("LOG OUT"))
        {
            dispose();
            LOGIN_PAGE obj = new LOGIN_PAGE();
            obj.setVisible(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

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
            java.util.logging.Logger.getLogger(HOME_TESTING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HOME_TESTING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HOME_TESTING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HOME_TESTING.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HOME_TESTING().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bg;
    private javax.swing.JButton fav_movies_bt;
    private javax.swing.JButton fav_tv_bt;
    private javax.swing.JButton genre_ml1;
    private javax.swing.JButton genre_tvl;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JButton search_actor;
    private javax.swing.JButton search_company;
    private javax.swing.JButton search_movies;
    private javax.swing.JButton search_tv_shows_bt;
    private javax.swing.JButton upcoming_movies;
    public javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
