
package proyectofinal;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PlayArea extends JPanel
{
    /*La declaracion de las variables tables indican el numero de
    filas,columnas y tamano de las celdas. Esto se aplica para el
    tablero de juego, ya que lo estamos vizualidando como una hoja
    cuadriculada.
    */
    private int tableRows;
    private int tableColumns;
    private int tableCellSize;
    
    private int [][] block={{1,0},{1,0},{1,1}};
    
    public PlayArea(JPanel ContainThePlayArea, int columns)
    {
        ContainThePlayArea.setVisible(false);
        this.setBounds(ContainThePlayArea.getBounds());
        this.setBackground(ContainThePlayArea.getBackground());
        this.setBorder(ContainThePlayArea.getBorder());
        
        tableColumns=columns;
        tableCellSize=this.getBounds().width/tableColumns;
        tableRows=this.getBounds().height/tableCellSize;
    }
    
    /*Esta clase la utilizamos para dibujar una figura y vizualizarla en el area de
    juego.*/
    private void DrawBlock(Graphics g)
    {
        for(int rows=0;rows<block.length;rows++)
        {
            for(int columns=0;columns<block[0].length;columns++)
            {
               if(block[rows][columns]==1)
               {
                   g.setColor(Color.red);
                   g.fillRect(columns*tableCellSize, rows*tableCellSize, tableCellSize, tableCellSize);
                   g.setColor(Color.BLACK);
                   g.drawRect(columns*tableCellSize, rows*tableCellSize, tableCellSize, tableCellSize);
               }    
            }    
        }    
    }
    
    /* El metodo paintComponent es el encargado
    de agregar cosas al area de juego o el panel.
    */
   @Override
   protected void paintComponent(Graphics g) 
   {
      super.paintComponent(g);
    
      DrawBlock(g);
   }
}
