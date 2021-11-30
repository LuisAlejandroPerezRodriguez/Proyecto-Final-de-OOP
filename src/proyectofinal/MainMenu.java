/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectofinal;

import java.applet.AudioClip;

/**
 *
 * @author luisa
 */
public class MainMenu extends javax.swing.JFrame {

    private boolean p=true;
    public MainMenu() {
        initComponents();

        Proyectofinal.playMainMenu(this.p);     
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Start = new javax.swing.JButton();
        Leaderboard = new javax.swing.JButton();
        Titulo = new javax.swing.JLabel();
        Exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Start.setBackground(new java.awt.Color(0,0,0,0));
        Start.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        Start.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (20)_adobespark.png"))); // NOI18N
        Start.setText("Start Game");
        Start.setBorder(null);
        Start.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Start.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (21)_adobespark.png"))); // NOI18N
        Start.setRolloverSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (20)_adobespark.png"))); // NOI18N
        Start.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                StartMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                StartMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                StartMousePressed(evt);
            }
        });
        Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StartActionPerformed(evt);
            }
        });
        getContentPane().add(Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 160, 50));

        Leaderboard.setBackground(new java.awt.Color(0, 0, 0,0));
        Leaderboard.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        Leaderboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Icono de las puntuaciones.png"))); // NOI18N
        Leaderboard.setText("Leaderboard");
        Leaderboard.setBorder(null);
        Leaderboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Leaderboard.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Puntuaciones precionado.png"))); // NOI18N
        Leaderboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                LeaderboardMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                LeaderboardMousePressed(evt);
            }
        });
        Leaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderboardActionPerformed(evt);
            }
        });
        getContentPane().add(Leaderboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, 160, 50));

        Titulo.setBackground(new java.awt.Color(0, 0, 0));
        Titulo.setFont(new java.awt.Font("Retro Computer", 1, 60)); // NOI18N
        Titulo.setForeground(new java.awt.Color(255, 51, 51));
        Titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Titulo del Main Menu.gif"))); // NOI18N
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 200, 110));

        Exit.setBackground(new java.awt.Color(0, 0,0,0));
        Exit.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (18)_adobespark.png"))); // NOI18N
        Exit.setText("Quit");
        Exit.setBorder(null);
        Exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Exit.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (19)_adobespark.png"))); // NOI18N
        Exit.setSelected(true);
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExitMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ExitMousePressed(evt);
            }
        });
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 380, 160, 50));

        jLabel1.setBackground(new java.awt.Color(255, 153, 51));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (1).gif"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaderboardActionPerformed
        this.setVisible(false);
        Proyectofinal.ShowLeaderboard();
    }//GEN-LAST:event_LeaderboardActionPerformed

    private void StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StartActionPerformed
        Proyectofinal.playMusicGame(true);
        
        this.setVisible(true);
        Proyectofinal.Start();
        this.setVisible(false);
        
        
    }//GEN-LAST:event_StartActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        
        System.exit(0);
    }//GEN-LAST:event_ExitActionPerformed

    private void StartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartMouseClicked

    }//GEN-LAST:event_StartMouseClicked

    private void StartMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartMouseEntered
       System.out.print("a");
       Proyectofinal.playbutton();
    }//GEN-LAST:event_StartMouseEntered

    private void LeaderboardMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeaderboardMouseEntered
           Proyectofinal.playbutton();
    }//GEN-LAST:event_LeaderboardMouseEntered

    private void ExitMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseEntered
           Proyectofinal.playbutton();
    }//GEN-LAST:event_ExitMouseEntered

    private void StartMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_StartMousePressed
         Proyectofinal.playbuttonpress();
    }//GEN-LAST:event_StartMousePressed

    private void LeaderboardMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LeaderboardMousePressed
                 Proyectofinal.playbuttonpress();
    }//GEN-LAST:event_LeaderboardMousePressed

    private void ExitMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMousePressed
                Proyectofinal.playbuttonpress();
    }//GEN-LAST:event_ExitMousePressed

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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton Leaderboard;
    private javax.swing.JButton Start;
    private javax.swing.JLabel Titulo;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
