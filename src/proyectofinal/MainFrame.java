
package proyectofinal;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.KeyStroke;

public class MainFrame extends javax.swing.JFrame {

    private PlayArea SaveParameter;
    public MainFrame() {
        
        initComponents();
        
        SaveParameter=new PlayArea(ContainThePlayArea,10);
        this.add(SaveParameter);
        
        Controls();
        
        StartGame();
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
        new ThreadOne(SaveParameter).start();
    }        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContainThePlayArea = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ContainThePlayArea.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ContainThePlayArea.setPreferredSize(new java.awt.Dimension(300, 550));

        javax.swing.GroupLayout ContainThePlayAreaLayout = new javax.swing.GroupLayout(ContainThePlayArea);
        ContainThePlayArea.setLayout(ContainThePlayAreaLayout);
        ContainThePlayAreaLayout.setHorizontalGroup(
            ContainThePlayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );
        ContainThePlayAreaLayout.setVerticalGroup(
            ContainThePlayAreaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 528, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(484, Short.MAX_VALUE)
                .addComponent(ContainThePlayArea, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(64, Short.MAX_VALUE)
                .addComponent(ContainThePlayArea, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
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
    // End of variables declaration//GEN-END:variables
}
