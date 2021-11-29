
package proyectofinal;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        leaderboard = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(820, 600));
        setResizable(false);

        MainMenu.setText("Exit");
        MainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuActionPerformed(evt);
            }
        });

        leaderboard.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Player", "Score"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(leaderboard);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(MainMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(MainMenu)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
        
        this.setVisible(false);
        Proyectofinal.ShowMainMenu();
    }//GEN-LAST:event_MainMenuActionPerformed

    public void AddPlayer(String PlayerName,int Score)
    {
        tm.addRow(new Object[]{PlayerName,Score});
        sorter.sort();
        SaveScoreTable();
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
    private javax.swing.JButton MainMenu;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable leaderboard;
    // End of variables declaration//GEN-END:variables
}
