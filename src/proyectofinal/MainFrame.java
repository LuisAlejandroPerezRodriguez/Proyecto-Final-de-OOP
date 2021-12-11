
package proyectofinal;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_ENTER;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class MainFrame extends javax.swing.JFrame{

   
    private PlayArea SaveParameter;
    private ThreadOne to;
    boolean flag=false;

    public MainFrame() {
        
        initComponents();
        
        SaveParameter=new PlayArea(ContainThePlayArea,10);
        this.add(SaveParameter);

        Controls();
          setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Imagenes/App icon v2.png")));
        
    }
    /* Este metodo se encarga de los atajos de teclado o las pulsaciones
    del teclado*/
    private void Controls()
    {
       InputMap in=this.getRootPane().getInputMap();
       ActionMap ac=this.getRootPane().getActionMap();
       KeyStroke keyStroke;
        final  boolean pause=false;
       /*Obtencion de las pulsacion de la flecha de la derecha*/
       in.put(KeyStroke.getKeyStroke("RIGHT"), "right");
       
       /*Obtencion de las pulsacion de la flecha de la izquerda*/
       in.put(KeyStroke.getKeyStroke("LEFT"), "left");
       
       /*Obtencion de las pulsacion de la flecha hacia arriba*/
       in.put(KeyStroke.getKeyStroke("UP"), "up");
       
       /*Obtencion de las pulsacion de la flecha hacia abajo*/
       in.put(KeyStroke.getKeyStroke("DOWN"), "down");
       
       /*Obtencion de la pulsacion del Esc para pausar el juego*/
       in.put(KeyStroke.getKeyStroke("ESCAPE"),"escape");
       
       in.put(KeyStroke.getKeyStroke("ENTER"),"enter");
       
        
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
       
       ac.put("escape", new AbstractAction(){
           @Override
           public void actionPerformed(ActionEvent e) {
                 to.suspend();
                 Proyectofinal.PlayPause();
                 Proyectofinal.playMusicGame(false); 
                // in.clear(); Inutilizar las teclas
                
                 
                 
           }
           
       });
       
        ac.put("enter", new AbstractAction(){
           @Override
           public void actionPerformed(ActionEvent e) {
                  to.resume();
                  Proyectofinal.playbutton();
                  Proyectofinal.playMusicGame(true);
           }
           
       });
    }        

    /* Metodo responsable de crear un objeto tipo hilo.*/
    public void StartGame()
    {
       SaveParameter.ResetBackgroundArray();
       to= new ThreadOne(SaveParameter,this);
       to.start();
       this.jLabel2.setVisible(false);
       
    } 
    
    /*Metodo encargado de actualizar los puntos obtenidos*/
    public void UpdateScore(int score)
    {
        ScoreLabel.setText("Score: " + score);
    } 
    
    public int Savedscore()
    {
        if(flag==true){
    String score=Serializar.deserializarObjeto("save.dat", String.class);
    String num=score.substring(7);
    System.out.println("Se cargo el los puntos");
        ScoreLabel.setText("Score: " + Integer.parseInt(num));
        return Integer.parseInt(num);}
         flag=false;
        return 0;
      
    }        
    
    /*Metodo encargado de actualizar el nivel*/
    public void UpdateLevel(int level)
    {
        LevelLabel.setText("Level: " + level);
    }        
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        save = new javax.swing.JButton();
        Cargar = new javax.swing.JButton();
        ScoreLabel = new javax.swing.JLabel();
        LevelLabel = new javax.swing.JLabel();
        MainMenu = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ContainThePlayArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        save.setBackground(new java.awt.Color(0, 0, 0));
        save.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Save_adobespark.png"))); // NOI18N
        save.setText("Save");
        save.setBorder(null);
        save.setFocusable(false);
        save.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        save.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sombreado save.png"))); // NOI18N
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                saveMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveMousePressed(evt);
            }
        });
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        Cargar.setBackground(new java.awt.Color(0, 0, 0));
        Cargar.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        Cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Load.png"))); // NOI18N
        Cargar.setText("Load");
        Cargar.setBorder(null);
        Cargar.setFocusable(false);
        Cargar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Cargar.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sombreado load.png"))); // NOI18N
        Cargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CargarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                CargarMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                CargarMousePressed(evt);
            }
        });
        Cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargarActionPerformed(evt);
            }
        });

        ScoreLabel.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        ScoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        ScoreLabel.setText("Score: 0");

        LevelLabel.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        LevelLabel.setForeground(new java.awt.Color(255, 255, 255));
        LevelLabel.setText("Level: 1");

        MainMenu.setBackground(new java.awt.Color(0, 0, 0));
        MainMenu.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        MainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Menu in ame.png"))); // NOI18N
        MainMenu.setText("Main Menu");
        MainMenu.setBorder(null);
        MainMenu.setFocusable(false);
        MainMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MainMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Sombra min.png"))); // NOI18N
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

        jLabel2.setFont(new java.awt.Font("Retro Computer", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 51));
        jLabel2.setText("Pause");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Fondo final.png"))); // NOI18N

        ContainThePlayArea.setBackground(new java.awt.Color(0, 0, 0));
        ContainThePlayArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        ContainThePlayArea.setPreferredSize(new java.awt.Dimension(300, 550));
        ContainThePlayArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ContainThePlayAreaKeyPressed(evt);
            }
        });

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
                .addGap(40, 40, 40)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(494, 494, 494)
                .addComponent(ContainThePlayArea, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(MainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LevelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(390, 390, 390)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(Cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(ContainThePlayArea, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(MainMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(LevelLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ScoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
        Proyectofinal.playMusicGame(false);

        to.interrupt();
        Proyectofinal.ShowMainMenu();
        flag=false;
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

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
    
        
    }//GEN-LAST:event_formKeyPressed

    private void ContainThePlayAreaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContainThePlayAreaKeyPressed

    }//GEN-LAST:event_ContainThePlayAreaKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped

    }//GEN-LAST:event_formKeyTyped

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked

    Serializar.serializarObjeto("save.dat", ScoreLabel.getText());
    System.out.println("Se guardo el juego");
    }//GEN-LAST:event_saveMouseClicked

    private void saveMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_saveMouseEntered

    private void saveMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveMousePressed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveActionPerformed

    private void CargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarMouseClicked
        flag=true;
        Savedscore();
      
    }//GEN-LAST:event_CargarMouseClicked

    private void CargarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_CargarMouseEntered

    private void CargarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CargarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_CargarMousePressed

    private void CargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CargarActionPerformed

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
    public javax.swing.JButton Cargar;
    private javax.swing.JPanel ContainThePlayArea;
    private javax.swing.JLabel LevelLabel;
    private javax.swing.JButton MainMenu;
    private javax.swing.JLabel ScoreLabel;
    private javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel2;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
}
