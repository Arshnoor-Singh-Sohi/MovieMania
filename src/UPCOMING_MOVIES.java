
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class UPCOMING_MOVIES extends javax.swing.JFrame {

    public UPCOMING_MOVIES() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/collage2.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
        setVisible(true);
        jScrollPane1.setVisible(false);
        
        load();
    }
 void load()
    {
        mainpanel.repaint();
        mainpanel.removeAll();
        jScrollPane1.setVisible(false);
        
        String api = "980d96176457a6e65b8bc282bcadccd4";
        try 
        {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/movie/upcoming?api_key="+api+"&language=en-US&page=1&region=US").asString();
            
            if(response.getStatus()==200)
            {
                jScrollPane1.setVisible(true);
                
                String res = response.getBody();
//                System.out.println(res);
                
                JSONParser parser = new JSONParser();
                JSONObject jsonobject = (JSONObject) parser.parse(res);
                JSONArray jsonarray = (JSONArray) jsonobject.get("results");
                
                int x=10, y=10, j=0;
                
                for(int i=0; i<jsonarray.size(); i++)
                {
                    JSONObject detailobj = (JSONObject) jsonarray.get(i);
                    
                    long id =(Long) detailobj.get("id");
                    String original_title = (String) detailobj.get("original_title"); 
                    String overview = (String) detailobj.get("overview"); 
                    String release_date = (String) detailobj.get("release_date");
                    String poster_path = (String) detailobj.get("poster_path");
                    
//                    System.out.println("Original_Title : "+original_title+"   Poster_Path : "+poster_path);
                    
                    if(poster_path != null)
                    {
                        j++;
                        
                        UPCOMING_MOVIES_DESIGN obj = new UPCOMING_MOVIES_DESIGN();
                        
                        obj.name.setText(original_title);
                        
                        URL url = new URL("https://image.tmdb.org/t/p/original/"+poster_path);
                        
                        BufferedImage img = ImageIO.read(url);
                        
                        Image im = img.getScaledInstance(obj.photo.getWidth(), obj.photo.getHeight(), img.SCALE_SMOOTH);
                        
                        obj.photo.setIcon(new ImageIcon(im));
                        
                        obj.setBounds(10, y, 500, 200);
                        
                        mainpanel.add(obj);
                        
                        y = y + 210;
                        
                        repaint();
                        mainpanel.repaint();
                        obj.repaint();
                    }
                }
                int ss = 210*j;
                mainpanel.setPreferredSize(new Dimension(510,ss));
                    
            }
            else
            {
                System.out.println(response.getStatus()+" -----> "+response.getStatusText());
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(370, 100, 790, 380);

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

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Algerian", 0, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("UPCOMING MOVIES");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(650, 10, 380, 50);

        bg.setText("jLabel2");
        getContentPane().add(bg);
        bg.setBounds(1210, 10, 37, 15);

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
            java.util.logging.Logger.getLogger(UPCOMING_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UPCOMING_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UPCOMING_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UPCOMING_MOVIES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UPCOMING_MOVIES().setVisible(true);
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
