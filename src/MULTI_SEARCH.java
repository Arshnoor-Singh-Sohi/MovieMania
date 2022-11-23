
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Image;
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

public class MULTI_SEARCH extends javax.swing.JFrame {

    public MULTI_SEARCH() {
        initComponents();
        
        setSize(1000,600);
        setVisible(true);
        jScrollPane1.setVisible(false);
    }

    void search()
    {
        mainpanel.repaint();
        mainpanel.removeAll();
        jScrollPane1.setVisible(false);
        
        String api_key = "980d96176457a6e65b8bc282bcadccd4";
        try
        {
            String m_name = multi_search_tf1.getText();
            String ms_name = m_name.replace(" ", "%20");
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/multi?api_key="+api_key+"&language=en-US&query="+ms_name+"&page=1&include_adult=false").asString();
            
            if(response.getStatus()==200)
            {
                jScrollPane1.setVisible(true);
                
                String res = response.getBody();
                System.out.println(res);
                
                JSONParser parser = new JSONParser();
                JSONObject jsonobject = (JSONObject) parser.parse(res);
                JSONArray jsonarray = (JSONArray) jsonobject.get("results");
                
                int x=10, y=10, j=0;
                
                for(int i=0; i<jsonarray.size(); i++)
                {
                    System.out.println(i);
                    
                    JSONObject jsonobject1 = (JSONObject) jsonarray.get(i);
                    JSONArray jsonarray1 = (JSONArray) jsonobject1.get("known_for");
                    
                    if(jsonarray.size() == 9)
                    {
                        System.out.println("------------ ENTER IN THE IF PART ----------");
                        for(int a=0; a<jsonarray1.size(); a++)
                        {
                            JSONObject ms_details = (JSONObject) jsonarray1.get(a);
                        
                            String original_title  = (String) ms_details.get("original_title");
                            String release_date = (String) ms_details.get("release_date");
                            String overview = (String) ms_details.get("overview");
                            String poster_path = (String) ms_details.get("poster_path");
                        
                            if(poster_path != null)
                            {
                                j++;
                            
                                MULTI_SEARCH_DESIGN obj = new MULTI_SEARCH_DESIGN();
                            
                                obj.name.setText(original_title);
                            
                                obj.release_date.setText(release_date);
                            
                                obj.overview.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JOptionPane.showMessageDialog(null, overview);
                                    }
                                });
                            
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
                    }
                    else if(jsonarray.size() == 15)
                    {   
                        System.out.println("------------ ENTER IN THE ELSE PART ----------");
                        
                            String original_title  = (String) jsonobject1.get("original_title");
                            String release_date = (String) jsonobject1.get("release_date");
                            String overview = (String) jsonobject1.get("overview");
                            String poster_path = (String) jsonobject1.get("poster_path");
                        
                            if(poster_path != null)
                            {
                                j++;
                            
                                MULTI_SEARCH_DESIGN obj = new MULTI_SEARCH_DESIGN();
                            
                                obj.name.setText(original_title);
                            
                                obj.release_date.setText(release_date);
                            
                                obj.overview.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        JOptionPane.showMessageDialog(null, overview);
                                    }
                                });
                            
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
                }
                System.out.println("END");
                int ss = 210*j;
                mainpanel.setPreferredSize(new Dimension(510,ss));
            }
            else
            {
                System.out.println(response.getStatus()+" ----> "+response.getStatusText());
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

        multi_search_tf1 = new javax.swing.JTextField();
        multi_search_bt1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        multi_search_tf1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        getContentPane().add(multi_search_tf1);
        multi_search_tf1.setBounds(170, 40, 520, 50);

        multi_search_bt1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        multi_search_bt1.setText("SEARCH");
        multi_search_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                multi_search_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(multi_search_bt1);
        multi_search_bt1.setBounds(740, 40, 150, 50);

        javax.swing.GroupLayout mainpanelLayout = new javax.swing.GroupLayout(mainpanel);
        mainpanel.setLayout(mainpanelLayout);
        mainpanelLayout.setHorizontalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 717, Short.MAX_VALUE)
        );
        mainpanelLayout.setVerticalGroup(
            mainpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 357, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(170, 130, 720, 360);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void multi_search_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_multi_search_bt1ActionPerformed
        search();
    }//GEN-LAST:event_multi_search_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(MULTI_SEARCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MULTI_SEARCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MULTI_SEARCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MULTI_SEARCH.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MULTI_SEARCH().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton multi_search_bt1;
    private javax.swing.JTextField multi_search_tf1;
    // End of variables declaration//GEN-END:variables
}
