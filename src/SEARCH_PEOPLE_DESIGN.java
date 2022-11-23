
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;



public class SEARCH_PEOPLE_DESIGN extends javax.swing.JPanel {

    public SEARCH_PEOPLE_DESIGN() {
        initComponents();
        
        ImageIcon img = new ImageIcon("src/yt.png");
        Image im = img.getImage().getScaledInstance(40, youtube.getHeight(), Image.SCALE_SMOOTH);
        youtube.setIcon(new ImageIcon(im));
        
        ImageIcon img1 = new ImageIcon("src/unlike.png");
        Image im1 = img1.getImage().getScaledInstance(40, mv_list.getHeight(), Image.SCALE_SMOOTH);
        mv_list.setIcon(new ImageIcon(im1));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photo = new javax.swing.JLabel();
        release_date = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        mv_list = new javax.swing.JButton();
        youtube = new javax.swing.JButton();
        overview = new javax.swing.JButton();

        setBackground(new Color(255,0,0,0));
        setLayout(null);

        photo.setText("jLabel1");
        add(photo);
        photo.setBounds(10, 20, 150, 160);

        release_date.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        release_date.setForeground(new java.awt.Color(255, 0, 0));
        release_date.setText("jLabel2");
        add(release_date);
        release_date.setBounds(190, 70, 240, 40);

        name.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 0, 0));
        name.setText("jLabel2");
        add(name);
        name.setBounds(190, 20, 240, 40);

        mv_list.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mv_list.setText("ADD TO MY LIST");
        mv_list.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mv_listActionPerformed(evt);
            }
        });
        add(mv_list);
        mv_list.setBounds(390, 140, 195, 40);

        youtube.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        youtube.setText("WATCH TRAILER");
        youtube.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                youtubeActionPerformed(evt);
            }
        });
        add(youtube);
        youtube.setBounds(615, 140, 195, 40);

        overview.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        overview.setText("OVERVIEW");
        add(overview);
        overview.setBounds(200, 140, 160, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void mv_listActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mv_listActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mv_listActionPerformed

    private void youtubeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_youtubeActionPerformed

    }//GEN-LAST:event_youtubeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton mv_list;
    public javax.swing.JLabel name;
    public javax.swing.JButton overview;
    public javax.swing.JLabel photo;
    public javax.swing.JLabel release_date;
    public javax.swing.JButton youtube;
    // End of variables declaration//GEN-END:variables
}
