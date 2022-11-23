
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
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Search_Movie_By_Category extends javax.swing.JFrame {

    public Search_Movie_By_Category(int id, String name, String cat) {
        initComponents();
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/genre.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
        jLabel1.setText(name);
        jLabel1.setBounds(0, 10, d.width, 50);

        setResizable(false);
        load(id, cat);
    }

    void load(int id2, String cat) {
        String api = "980d96176457a6e65b8bc282bcadccd4";
        try {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/discover/" + cat + "?api_key=" + api + "&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&primary_release_date.gte=1990-01-01&primary_release_date.lte=2022-12-31&vote_average.gte=6&with_genres=" + id2).asString();
//            System.out.println(response.getBody());

            if (response.getStatus() == 200) {
                String res = response.getBody();

                JSONParser parser = new JSONParser();
                JSONObject jsonObject = (JSONObject) parser.parse(res);
                JSONArray ja = (JSONArray) jsonObject.get("results");

                int x = 10, y = 10, j = 0;

                for (int i = 0; i < ja.size(); i++) {
//                    System.out.println(i);
                    JSONObject jo = (JSONObject) ja.get(i);

                    long id = (Long) jo.get("id");
                    String original_title = (String) jo.get("original_title");
                    String overview = (String) jo.get("overview");
                    String release_date = (String) jo.get("release_date");
                    String poster_path = (String) jo.get("poster_path");

                    if (poster_path != null) {
                        j++;
                        moviedesign obj = new moviedesign();
                        
                        obj.yt_bt.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try
                                {                                    
                                    String youtubeid = (String) jo.get("original_title");
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

                        obj.title.setText(original_title);
                        obj.desc.setText(overview);
                        obj.date.setText(release_date);

                        URL url = new URL("https://image.tmdb.org/t/p/original/" + poster_path);

                        BufferedImage img = ImageIO.read(url);

                        Image im = img.getScaledInstance(obj.jLabel1.getWidth(), obj.jLabel1.getHeight(), img.SCALE_SMOOTH);

                        obj.jLabel1.setIcon(new ImageIcon(im));

                        obj.setBounds(10, y, 500, 200);

                        mainpanel.add(obj);
                        y = y + 210;
                        repaint();    
                        mainpanel.repaint();
                        obj.repaint();
                    }

                }
                int ss = 210 * j;
                mainpanel.setPreferredSize(new Dimension(510, ss));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 10, 660, 50);

        mainpanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 338, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(500, 410, 560, 340);

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

        bg.setText("jLabel2");
        getContentPane().add(bg);
        bg.setBounds(970, 30, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        GENRE_MOVIE_LIST obj = new GENRE_MOVIE_LIST();
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
            java.util.logging.Logger.getLogger(Search_Movie_By_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Search_Movie_By_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Search_Movie_By_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Search_Movie_By_Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // new Search_Movie_By_Category(0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
