
package proyectofinal;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class MainFrame extends javax.swing.JFrame {

    private PlayArea SaveParameter;
    private ThreadOne to;
    
    
    public MainFrame() {
        
        initComponents();
        
        SaveParameter=new PlayArea(ContainThePlayArea,10);
        this.add(SaveParameter);

        Controls();
        
    }
    /* Este metodo se encarga de los atajos de teclado o las pulsaciones
    del teclado*/
    private void Controls()
    {
       InputMap in=this.getRootPane().getInputMap();
       ActionMap ac=this.getRootPane().getActionMap();
       KeyStroke keyStroke;
       
       /*Obtencion de las pulsacion de la flecha de la derecha*/
       in.put(KeyStroke.getKeyStroke("RIGHT"), "right");
       
       /*Obtencion de las pulsacion de la flecha de la izquerda*/
       in.put(KeyStroke.getKeyStroke("LEFT"), "left");
       
       /*Obtencion de las pulsacion de la flecha hacia arriba*/
       in.put(KeyStroke.getKeyStroke("UP"), "up");
       
       /*Obtencion de las pulsacion de la flecha hacia abajo*/
       in.put(KeyStroke.getKeyStroke("DOWN"), "down");
       
       /*Agrega una accion al mapa de accion*/
       ac.put("right",new AbstractAction(){
           @Override
           public void actionPerformed(ActionEvent e) {
                SaveParameter.moveBlockRight();
           }
           
       });
       
       ac.put("left", new AbstractAction(){
           @Override
           public void actionPerformed(ActionEvent e) {
                SaveParameter.moveBlockLeft();
           }
           
       });
       
       ac.put("up",new AbstractAction(){
           @Override
           public void actionPerformed(ActionEvent e) {
               SaveParameter.RotateBlock();
           }
           
       });
       
       ac.put("down", new AbstractAction(){
           @Override
           public void actionPerformed(ActionEvent e) {
               SaveParameter.BlockDown();
           }
           
       });
    }        

    /* Metodo responsable de crear un objeto tipo hilo.*/
    public void StartGame()
    {
       SaveParameter.ResetBackgroundArray();
       to= new ThreadOne(SaveParameter,this);
       to.start();
    } 
    
    /*Metodo encargado de actualizar los puntos obtenidos*/
    public void UpdateScore(int score)
    {
        ScoreLabel.setText("Score: " + score);
    } 
    
    /*Metodo encargado de actualizar el nivel*/
    public void UpdateLevel(int level)
    {
        LevelLabel.setText("Level: " + level);
    }        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ScoreLabel = new javax.swing.JLabel();
        LevelLabel = new javax.swing.JLabel();
        MainMenu = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ContainThePlayArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ScoreLabel.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        ScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        ScoreLabel.setText("Score: 0");

        LevelLabel.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        LevelLabel.setForeground(new java.awt.Color(255, 255, 255));
        LevelLabel.setText("Level: 1");

        MainMenu.setBackground(new java.awt.Color(0,0,0,1));
        MainMenu.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        MainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (20)_adobespark.png"))); // NOI18N
        MainMenu.setText("Main Menu");
        MainMenu.setBorder(null);
        MainMenu.setFocusable(false);
        MainMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MainMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (21)_adobespark.png"))); // NOI18N
        MainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MainMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MainMenuMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                MainMenuMousePressed(evt);
            }
        });
        MainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo final.png"))); // NOI18N

        ContainThePlayArea.setBackground(new java.awt.Color(0, 0, 0));
        ContainThePlayArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ContainThePlayArea.setPreferredSize(new java.awt.Dimension(300, 550));

        javax.swing.GroupLayout ContainThePlayAreaLayout = new javax.swing.GroupLayout(ContainThePlayArea);
        ContainThePlayArea.setLayout(ContainThePlayAreaLayout);
        ContainThePlayAreaLayout.setHorizontalGroup(
            ContainThePlayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 340, Short.MAX_VALUE)
        );
        ContainThePlayAreaLayout.setVerticalGroup(
            ContainThePlayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(LevelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(354, 354, 354)
                .addComponent(ContainThePlayArea, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(MainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(LevelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(170, 170, 170)
                .addComponent(MainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(ContainThePlayArea, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
        Proyectofinal.playMusicGame(false);

        to.interrupt();
        Proyectofinal.ShowMainMenu();
        this.setVisible(false);

         
    }//GEN-LAST:event_MainMenuActionPerformed

    private void MainMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainMenuMouseClicked


    }//GEN-LAST:event_MainMenuMouseClicked

    private void MainMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainMenuMouseEntered
         Proyectofinal.playbutton();
    }//GEN-LAST:event_MainMenuMouseEntered

    private void MainMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainMenuMousePressed
        Proyectofinal.playbuttonpress();
    }//GEN-LAST:event_MainMenuMousePressed

    
    public static void main(String args[]) {
       
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ContainThePlayArea;
    private javax.swing.JLabel LevelLabel;
    private javax.swing.JButton MainMenu;
    private javax.swing.JLabel ScoreLabel;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
