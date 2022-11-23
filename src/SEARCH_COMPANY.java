
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

public class SEARCH_COMPANY extends javax.swing.JFrame {

    public SEARCH_COMPANY() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/company.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
//        mainpanel.setBounds(700, 100, 984, 555);
                
        setVisible(true);
        search_company_tf1.requestFocus();
        jScrollPane1.setVisible(false);
    }
    
    void search()
    {
        mainpanel.repaint();
        mainpanel.removeAll();
        jScrollPane1.setVisible(true);
        
        String api_key = "980d96176457a6e65b8bc282bcadccd4";
        try 
        {
            String c_name = search_company_tf1.getText();
            String co_name = c_name.replace(" ","%20");
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/search/company?api_key="+api_key+"&query="+co_name+"&page=1").asString();
            
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
//                    System.out.println(i);
                    JSONObject company_detail = (JSONObject) jsonarray.get(i);
                    
                    String name = (String) company_detail.get("name");
                    String logo = (String) company_detail.get("logo");
                    
                    if(logo != null)
                    {
                        j++;
                        
                        SEARCH_COMPANY_DESIGN obj = new SEARCH_COMPANY_DESIGN();
                        
                        obj.name.setText(name);
                        
                        URL url = new URL("https://image.tmdb.org/t/p/original/"+logo);
                        
                        BufferedImage img = ImageIO.read(url);
                        
                        Image im = img.getScaledInstance(obj.logo.getWidth(), obj.logo.getHeight(), BufferedImage.SCALE_SMOOTH);
                        
                        obj.logo.setIcon(new ImageIcon(im));
                        
                        obj.setBounds(10, y, 500, 200);
                        
                        mainpanel.add(obj);
                        
                        y = y + 210;
                        
                        mainpanel.repaint();
                        obj.repaint();
                    }
                    else
                    {
                        j++;
                        
                        SEARCH_COMPANY_DESIGN obj = new SEARCH_COMPANY_DESIGN();
                        
                        obj.name.setText(name);
                        
                        ImageIcon img = new ImageIcon("src/MovieManiaLogo.jpg");
                        Image im = img.getImage().getScaledInstance(obj.logo.getWidth(), obj.logo.getHeight(), Image.SCALE_SMOOTH);
                        obj.logo.setIcon(new ImageIcon(im));
                        obj.setBounds(10, y, 500, 200);
                        
                        mainpanel.add(obj);
                        
                        y = y + 210;
                        
                        mainpanel.repaint();
                        obj.repaint();
                    }
                }
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

        search_company_bt1 = new javax.swing.JButton();
        search_company_tf1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainpanel = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        search_company_bt1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        search_company_bt1.setText("SEARCH");
        search_company_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_company_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(search_company_bt1);
        search_company_bt1.setBounds(1300, 70, 170, 50);

        search_company_tf1.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        search_company_tf1.setToolTipText("Enter the name of any movie company");
        search_company_tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_company_tf1ActionPerformed(evt);
            }
        });
        getContentPane().add(search_company_tf1);
        search_company_tf1.setBounds(640, 70, 580, 50);

        mainpanel.setBackground(new Color(255,0,0,0));
        mainpanel.setForeground(new java.awt.Color(0, 0, 0));
        mainpanel.setLayout(null);
        jScrollPane1.setViewportView(mainpanel);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(820, 180, 650, 330);

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
        bg.setBounds(10, 70, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void search_company_tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_company_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_search_company_tf1ActionPerformed

    private void search_company_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_company_bt1ActionPerformed
        search();
    }//GEN-LAST:event_search_company_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(SEARCH_COMPANY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SEARCH_COMPANY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SEARCH_COMPANY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SEARCH_COMPANY.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SEARCH_COMPANY().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JButton search_company_bt1;
    private javax.swing.JTextField search_company_tf1;
    // End of variables declaration//GEN-END:variables
}
