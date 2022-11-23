
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class GENRE_TV_LIST extends javax.swing.JFrame {
    
    ArrayList<category> al;
    
    mytablemodel tm;

    public GENRE_TV_LIST() {
        
        al = new ArrayList<>();
        
        tm = new mytablemodel();
        
        initComponents();
        
        tvl_tb1.setModel(tm);
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        
        bg.setSize(d.width, d.height);
        ImageIcon img2 = new ImageIcon("src/genre.jpg");
        Image im2 = img2.getImage().getScaledInstance(bg.getWidth(), bg.getHeight(), Image.SCALE_SMOOTH);
        bg.setIcon(new ImageIcon(im2));
        bg.setBounds(0, 0, d.width, d.height);
        
        jScrollPane1.setBounds(430, 430, 700, 320);
        search_tvl_bt1.setBounds(690, 780, 180, 40);
        jLabel1.setBounds(600, 20, 400, 48);
        
        setVisible(true);
        genre();
    }

    void genre()
    {
        String api_key = "980d96176457a6e65b8bc282bcadccd4";
        try 
        {
            HttpResponse<String> response = Unirest.get("https://api.themoviedb.org/3/genre/tv/list?api_key="+api_key+"&language=en-US").asString();
            
            if(response.getStatus()==200)
            {
                String res = response.getBody();
//                System.out.println(res);
                
                JSONParser parser = new JSONParser();
                JSONObject jsonobject = (JSONObject) parser.parse(res);
                JSONArray jsonarray = (JSONArray) jsonobject.get("genres");
                
                for(int i=0; i<jsonarray.size(); i++)
                {
                    JSONObject genre_detail = (JSONObject) jsonarray.get(i);
                    
                    long id = (long) genre_detail.get("id");
                    String name = (String) genre_detail.get("name");
                    
                    al.add(new category(id, name));
                }
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    class mytablemodel extends AbstractTableModel
    {

        @Override
        public int getRowCount() 
        {
            return al.size();
        }

        @Override
        public int getColumnCount() 
        {
            return 2;
        }

        @Override
        public String getColumnName(int j) 
        {
            String[] c = { "id", "name" };
            return c[j];
        }

        @Override
        public Object getValueAt(int i, int j) 
        {
            category obj = al.get(i);
            if(j==0)
                return obj.id;
            else
                return obj.name;
        } 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tvl_tb1 = new javax.swing.JTable();
        search_tvl_bt1 = new javax.swing.JButton();
        back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        tvl_tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tvl_tb1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 70, 950, 420);

        search_tvl_bt1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        search_tvl_bt1.setText("SEARCH");
        search_tvl_bt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_tvl_bt1ActionPerformed(evt);
            }
        });
        getContentPane().add(search_tvl_bt1);
        search_tvl_bt1.setBounds(440, 510, 170, 40);

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

        jLabel1.setFont(new java.awt.Font("Algerian", 0, 45)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("TV SHOWS GENRE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(460, 10, 300, 30);

        bg.setText("jLabel2");
        getContentPane().add(bg);
        bg.setBounds(940, 20, 37, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        dispose();
        HOME_TESTING obj = new HOME_TESTING();
        obj.setVisible(true);
    }//GEN-LAST:event_backActionPerformed

    private void search_tvl_bt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_tvl_bt1ActionPerformed
        int d = tvl_tb1.getSelectedRow();
        if(d==-1)
        {
            JOptionPane.showMessageDialog(this, "PLEASE SELECT THE ROW!!!");
        }
        else
        {
            long id = al.get(d).id;
            String  name = al.get(d).name;
            SEARCH_TVSHOWS_BY_CATEGORY obj = new SEARCH_TVSHOWS_BY_CATEGORY((int) id, name, "tv");
            dispose();
            obj.setVisible(true);
        }
    }//GEN-LAST:event_search_tvl_bt1ActionPerformed

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
            java.util.logging.Logger.getLogger(GENRE_TV_LIST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GENRE_TV_LIST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GENRE_TV_LIST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GENRE_TV_LIST.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GENRE_TV_LIST().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton search_tvl_bt1;
    private javax.swing.JTable tvl_tb1;
    // End of variables declaration//GEN-END:variables
}
