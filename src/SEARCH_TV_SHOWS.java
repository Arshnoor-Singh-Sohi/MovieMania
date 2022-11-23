
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.sql.*;

public class SEARCH_TV_SHOWS extends javax.swing.JFrame {

    public SEARCH_TV_SHOWS() {
        initComponents();

        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/tvshows.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
        setVisible(true);
        search_tvshows_tf1.requestFocus();
        jScrollPane1.setVisible(false);
    }

    void search() {
        mainpanel.repaint();
        mainpanel.removeAll();
        jScrollPane1.setVisible(false);

        String api_key = "980d96176457a6e65b8bc282bcadccd4";
        try {
            String tv_name = search_tvshows_tf1.getText();
            String tvs_name = tv_name.replace(" ", "%20");
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/tv?api_key=" + api_key + "&language=en-US&page=1&query=" + tvs_name + "&include_adult=false").asString();

            if (response.getStatus() == 200) {
                jScrollPane1.setVisible(true);

                String res = response.getBody();
//                System.out.println(res);

                JSONParser parser = new JSONParser();
                JSONObject jsonobject = (JSONObject) parser.parse(res);
                JSONArray jsonarray = (JSONArray) jsonobject.get("results");

                int x = 10, y = 10, j = 0;

                for (int i = 0; i < jsonarray.size(); i++) {
//                    System.out.println(i);
                    JSONObject tvs_details = (JSONObject) jsonarray.get(i);

                    long id = (Long) tvs_details.get("id");
                    int id1 = (int) id;

                    String original_name = (String) tvs_details.get("original_name");
                    String release_date = (String) tvs_details.get("first_air_date");
                    String overview = (String) tvs_details.get("overview");
                    String poster_path = (String) tvs_details.get("poster_path");

                    if (poster_path != null) {
                        j++;
                        SEARCH_TV_SHOWS_DESIGN obj = new SEARCH_TV_SHOWS_DESIGN();
                        ResultSet rs = DBLoader.executeSQL("select * from tv_list where id=" + id1+" and username='"+Global.user+"'");
                        if (rs.next()) {
                            ImageIcon img1 = new ImageIcon("src/like.png");
                            Image im1 = img1.getImage().getScaledInstance(40, obj.list.getHeight(), Image.SCALE_SMOOTH);
                            obj.list.setIcon(new ImageIcon(im1));
                            
                            obj.list.setText("REMOVE");
                            obj.list.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        ResultSet rs1 = DBLoader.executeSQL("select * from tv_list where id=" + id1+" and username='"+Global.user+"'");
                                        if (rs1.next()) {
                                            rs1.deleteRow();
                                            search();
                                        } else {
                                            JOptionPane.showMessageDialog(null, "ALREADY DELETED");
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            });

                        } else {
                            obj.list.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        ResultSet rs2 = DBLoader.executeSQL("select * from tv_list where id=" + id+" and username='"+Global.user+"'");
                                        if (rs2.next()) {
                                            JOptionPane.showMessageDialog(null, "ALREADY ADDED");
                                        } else {
                                            rs2.moveToInsertRow();
                                            
                                            rs2.updateString("username", Global.user);
                                            rs2.updateInt("id", id1);
                                            rs2.updateString("name", original_name);
                                            rs2.updateString("photo", poster_path);

                                            rs2.insertRow();
                                            search();
                                        }
                                    } catch (Exception ex) {
                                        ex.printStackTrace();
                                    }
                                }
                            });
                        }
                        obj.original_title.setText(original_name);

                        obj.release_date.setText(release_date);

                        obj.overview.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(null, overview);
                            }
                        });

                        URL url = new URL("https://image.tmdb.org/t/p/original/" + poster_path);

                        BufferedImage img = ImageIO.read(url);

                        Image im = img.getScaledInstance(obj.photo.getWidth(), obj.photo.getHeight(), img.SCALE_SMOOTH);

                        obj.photo.setIcon(new ImageIcon(im));

                        obj.setBounds(10, y, 850, 200);

                        mainpanel.add(obj);

                        y = y + 210;

                        repaint();
                        mainpanel.repaint();
                        obj.repaint();
                    }
                }
//                System.out.println("END");
                int ss = 210 * j;
                mainpanel.setPreferredSize(new Dimension(510, ss));
            } else {
                System.out.println(response.getStatus() + " ----> " + response.getStatusText());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        search_tvshows_tf1 = new javax.swing.JTextField();
        tvshows_bt1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        search_tvshows_tf1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        search_tvshows_tf1.setToolTipText("Enter the name of any tv show");
        getContentPane().add(search_tvshows_tf1);
        search_tvshows_tf1.setBounds(160, 40, 530, 50);

        tvshows_bt1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tvshows_bt1.setText("SEARCH");
        tvshows_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tvshows_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(tvshows_bt1);
        tvshows_bt1.setBounds(750, 40, 150, 50);

        mainpanel.setBackground(new Color(255,0,0,0));

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 857, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 140, 860, 510);

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
        bg.setBounds(920, 20, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tvshows_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tvshows_bt1ActionPerformed
        search();
    }//GEN-LAST:event_tvshows_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(SEARCH_TV_SHOWS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SEARCH_TV_SHOWS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SEARCH_TV_SHOWS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SEARCH_TV_SHOWS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SEARCH_TV_SHOWS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JTextField search_tvshows_tf1;
    private javax.swing.JButton tvshows_bt1;
    // End of variables declaration//GEN-END:variables
}
