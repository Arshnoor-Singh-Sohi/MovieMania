
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URI;
import java.net.URL;
import java.sql.ResultSet;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class SEARCH_MOVIES extends javax.swing.JFrame {

    public SEARCH_MOVIES() {
        initComponents();

        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/collage1.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
        setVisible(true);
        search_movies_tf1.requestFocus();
        jScrollPane1.setVisible(false);
    }

    void search() {
        mainpanel.repaint();
        mainpanel.removeAll();
        jScrollPane1.setVisible(false);

        String api_key = "980d96176457a6e65b8bc282bcadccd4";
        try {
            String m_name = search_movies_tf1.getText();
            String mo_name = m_name.replace(" ", "%20");
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/movie?api_key=" + api_key + "&language=en-US&query=" + mo_name + "&page=1&include_adult=false").asString();

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
                    JSONObject movie_detail = (JSONObject) jsonarray.get(i);

                    long id = (Long) movie_detail.get("id");
                    int id1 = (int) id;

                    String title = (String) movie_detail.get("title");
                    String overview = (String) movie_detail.get("overview");
                    String release_date = (String) movie_detail.get("release_date");
                    String poster_path = (String) movie_detail.get("poster_path");

                    if (poster_path != null) {
                        j++;
                        SEARCH_MOVIES_DESIGN obj = new SEARCH_MOVIES_DESIGN();

                        ResultSet rs = DBLoader.executeSQL("select * from mv_list where id=" + id1 + " and username='" + Global.user + "'");
                        if (rs.next()) {
                            ImageIcon img1 = new ImageIcon("src/like.png");
                            Image im1 = img1.getImage().getScaledInstance(40, obj.mv_list.getHeight(), Image.SCALE_SMOOTH);
                            obj.mv_list.setIcon(new ImageIcon(im1));
        
                            obj.mv_list.setText("REMOVE");
                            obj.mv_list.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        ResultSet rs1 = DBLoader.executeSQL("select * from mv_list where id=" + id1 + " and username='" + Global.user + "'");
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
                            obj.mv_list.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    try {
                                        ResultSet rs2 = DBLoader.executeSQL("select * from mv_list where id=" + id + " and username='" + Global.user + "'");
                                        if (rs2.next()) {
                                            JOptionPane.showMessageDialog(null, "ALREADY ADDED");
                                        } else {
                                            rs2.moveToInsertRow();

                                            rs2.updateString("username", Global.user);
                                            rs2.updateInt("id", id1);
                                            rs2.updateString("name", title);
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

                        obj.name.setText(title);

                        obj.release_date.setText(release_date);

                        obj.overview1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JOptionPane.showMessageDialog(null, overview);
                            }
                        });
                        

                        obj.youtube.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try
                                {
                                    String youtubeid = (String) movie_detail.get("title");
                                    String youtube = youtubeid.replace(" ", "%20");
                                    URI u = new URI("www.youtube.com/results?search_query=" + youtube);
                                   
                                    Desktop d = Desktop.getDesktop();
                                    d.browse(u);
                                }
                                catch(Exception ex)
                                {
                                    ex.printStackTrace();
                                }
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

        search_movies_tf1 = new javax.swing.JTextField();
        movies_bt1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        search_movies_tf1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        search_movies_tf1.setToolTipText("Enter the name of any movie");
        search_movies_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_movies_tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(search_movies_tf1);
        search_movies_tf1.setBounds(170, 49, 510, 50);

        movies_bt1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        movies_bt1.setText("SEARCH");
        movies_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movies_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(movies_bt1);
        movies_bt1.setBounds(720, 50, 150, 50);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 847, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(170, 170, 850, 490);

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
        bg.setBounds(40, 100, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_movies_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_movies_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_movies_tf1ActionPerformed

    private void movies_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movies_bt1ActionPerformed
        search();
    }//GEN-LAST:event_movies_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(SEARCH_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SEARCH_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SEARCH_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SEARCH_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SEARCH_MOVIES().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton movies_bt1;
    private javax.swing.JTextField search_movies_tf1;
    // End of variables declaration//GEN-END:variables
}
