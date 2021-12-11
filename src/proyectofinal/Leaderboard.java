
package proyectofinal;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.RowSorter.SortKey;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class Leaderboard extends javax.swing.JFrame {

    private DefaultTableModel tm;
    
    private String LeaderboardFile="Leaderboard";
    
    private TableRowSorter<TableModel> sorter;
    
    public Leaderboard() 
    {
        initComponents();
        initTableData();
        InitTableSorter();
    }
    
    private void initTableData()
    {
        Vector CI=new Vector();
        CI.add("Player");
        CI.add("Score");
        CI.add("Date");
        
        tm=(DefaultTableModel)leaderboard.getModel();
        
        try
        {    
        FileInputStream fi=new FileInputStream(LeaderboardFile);
        ObjectInputStream os=new ObjectInputStream(fi);
        
        tm.setDataVector((Vector<Vector>)os.readObject(), CI);
        
        os.close();
        fi.close();
        }
        catch(Exception e){}
    }
    
    private void InitTableSorter()
    {
        sorter=new TableRowSorter<>(tm);
        leaderboard.setRowSorter(sorter);
        
        ArrayList<SortKey> keys=new ArrayList<>();
        keys.add(new SortKey (1, SortOrder.DESCENDING));
        
        sorter.setSortKeys(keys);
    }        
    
    private void SaveScoreTable()
    {
        try
        {    
        FileOutputStream fs=new FileOutputStream(LeaderboardFile) ;
        ObjectOutputStream os=new ObjectOutputStream(fs);
        
        os.writeObject( tm.getDataVector());
        
        os.close();
        fs.close();
        }
         catch(Exception e){}
    }        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainMenu = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        leaderboard = new javax.swing.JTable();
        Enviar = new javax.swing.JButton();
        Enviar1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainMenu.setBackground(new java.awt.Color(0, 0, 0,0));
        MainMenu.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        MainMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (23)_adobespark.png"))); // NOI18N
        MainMenu.setText("Exit");
        MainMenu.setBorder(null);
        MainMenu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MainMenu.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (24)_adobespark.png"))); // NOI18N
        MainMenu.addMouseListener(new java.awt.event.MouseAdapter() {
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
        getContentPane().add(MainMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 128, 43));

        jButton1.setBackground(new java.awt.Color(255, 204, 51));
        jButton1.setFont(new java.awt.Font("Retro Computer", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (32).png"))); // NOI18N
        jButton1.setText("Clear Table");
        jButton1.setBorder(null);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título (33).png"))); // NOI18N
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 140, 50));

        jLabel2.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        jLabel2.setText(" Nota: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 80, 30));

        jLabel3.setFont(new java.awt.Font("Retro Computer", 1, 14)); // NOI18N
        jLabel3.setText("Al eleminar la tabla hay que reiniciar el juego.");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 550, 60));

        leaderboard.setBackground(new java.awt.Color(255, 153, 153));
        leaderboard.setBorder(new javax.swing.border.MatteBorder(null));
        leaderboard.setFont(new java.awt.Font("Retro Computer", 0, 12)); // NOI18N
        leaderboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Score", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        leaderboard.setSelectionBackground(new java.awt.Color(153, 255, 51));
        jScrollPane1.setViewportView(leaderboard);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 380, 240));

        Enviar.setBackground(new java.awt.Color(0, 204, 0));
        Enviar.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        Enviar.setText("Enviar");
        Enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EnviarActionPerformed(evt);
            }
        });
        getContentPane().add(Enviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 140, 50));

        Enviar1.setBackground(new java.awt.Color(102, 102, 102));
        Enviar1.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        Enviar1.setText("Recibir");
        Enviar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Enviar1ActionPerformed(evt);
            }
        });
        getContentPane().add(Enviar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 140, 50));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0,0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Diseño sin título.gif"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, -1, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
        
        this.setVisible(false);
        Proyectofinal.ShowMainMenu();
        Proyectofinal.playScore(false);
    }//GEN-LAST:event_MainMenuActionPerformed

    private void MainMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainMenuMousePressed
                 Proyectofinal.playbuttonpress();
                  Proyectofinal.playScore(false);
    }//GEN-LAST:event_MainMenuMousePressed

    private void MainMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MainMenuMouseEntered
                Proyectofinal.playbutton();
               
    }//GEN-LAST:event_MainMenuMouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        File archivo=new File(LeaderboardFile);
        if(archivo.delete())
        {
        System.out.print("Hi");
        InitTableSorter();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
           Proyectofinal.playbutton();
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
         Proyectofinal.playbuttonpress();
    }//GEN-LAST:event_jButton1MouseClicked

    private void EnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EnviarActionPerformed
        // TODO add your handling code here:
        UdpClient client = new UdpClient();
        
        client.start();
        client.run();
        
        
    }//GEN-LAST:event_EnviarActionPerformed

    private void Enviar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Enviar1ActionPerformed
        // TODO add your handling code here:
        //UdpServer server = new UdpServer();
        //server.start();
        ///server.run();
        System.out.print("No disponible");
        
    }//GEN-LAST:event_Enviar1ActionPerformed

    public void AddPlayer(String PlayerName,int Score, LocalDate date)
    {
        tm.addRow(new Object[]{PlayerName,Score,date});
        sorter.sort();
        SaveScoreTable();
        Proyectofinal.playScore(true);
        this.setVisible(true);
        
    }        
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
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Leaderboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Leaderboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Enviar;
    private javax.swing.JButton Enviar1;
    private javax.swing.JButton MainMenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaderboard;
    // End of variables declaration//GEN-END:variables
}
