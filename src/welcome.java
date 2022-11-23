
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class welcome extends javax.swing.JFrame {

    String images[] = {"src/AVATAR.jpg","src/WAKANDA FOREVER.jpg","src/JOHN WICK.jpg","src/minions.jpg","src/harry potter.jpg","src/joker.jpg"};
    public welcome() {
        initComponents();
        
        Dimension d = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());
        setSize(d.width, d.height);
        jpcaraousel.setBounds(0,70, d.width, 757);
        jLabel2.setBounds(0,0,100,70);
        jLabel1.setBounds(100,0,d.width-200, 70);
        home.setBounds(1435, 0, 90, 70);
        
     
        ImageIcon ic2 = new ImageIcon("src/MovieManiaLogo.jpg");
        Image im1 = ic2.getImage().getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon ic3 = new ImageIcon(im1);
        jLabel2.setIcon(ic3);
                                    
       ImageIcon img1 = new ImageIcon("src/home_logo.png");
       Image im2 = img1.getImage().getScaledInstance(home.getWidth(), home.getHeight(), Image.SCALE_SMOOTH);
       home.setIcon(new ImageIcon(im2));
       
       home.addMouseListener(new MouseAdapter() {
                                @Override
                                public void mouseClicked(MouseEvent e) {
                                    dispose();
                                    HOME_TESTING obj = new HOME_TESTING();
                                    obj.setVisible(true);
                                }
               });
        PanelSlider42<JPanel> slider = new PanelSlider42<JPanel>(jpcaraousel);
        JPanel jPanel = slider.getBasePanel();
        for (int i = 0; i < images.length; i++) {
            try {
                JLabel lb = new JLabel();
                BufferedImage image = ImageIO.read(new File(images[i]));
                Image img = image.getScaledInstance(jpcaraousel.getWidth(), jpcaraousel.getHeight(), Image.SCALE_SMOOTH);
                lb.setIcon(new ImageIcon(img));
                slider.addComponent(lb);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        slider.test();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpcaraousel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        home = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        getContentPane().setLayout(null);

        javax.swing.GroupLayout jpcaraouselLayout = new javax.swing.GroupLayout(jpcaraousel);
        jpcaraousel.setLayout(jpcaraouselLayout);
        jpcaraouselLayout.setHorizontalGroup(
            jpcaraouselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 820, Short.MAX_VALUE)
        );
        jpcaraouselLayout.setVerticalGroup(
            jpcaraouselLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(jpcaraousel);
        jpcaraousel.setBounds(-10, 60, 820, 550);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Algerian", 3, 40)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("WELCOME TO MOVIE mania                                         GO TO HOME PAGE");
        jLabel1.setOpaque(true);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 1590, 60);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(400, 30, 37, 15);

        home.setBackground(new java.awt.Color(0, 0, 0));
        home.setForeground(new java.awt.Color(0, 0, 0));
        home.setText("jLabel4");
        home.setToolTipText("Click here to go to HomePage");
        getContentPane().add(home);
        home.setBounds(1400, 30, 34, 15);

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpcaraousel;
    // End of variables declaration//GEN-END:variables
}
