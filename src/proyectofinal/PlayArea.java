
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
    
    /*Declaracion de una variable tipo bloque*/
    private TetrisBlock block;
    
    private Color[][] BackgroundColor;
    
    public PlayArea(JPanel ContainThePlayArea, int columns)
    {
        ContainThePlayArea.setVisible(false);
        this.setBounds(ContainThePlayArea.getBounds());
        this.setBackground(ContainThePlayArea.getBackground());
        this.setBorder(ContainThePlayArea.getBorder());
        
        tableColumns=columns;
        tableCellSize=this.getBounds().width/tableColumns;
        tableRows=this.getBounds().height/tableCellSize;
        
        BackgroundColor=new Color[tableRows][tableColumns];
    }
    
    /*Metodo responsable de spawnear bloques, dentro del metodo
    instanciamos el bloque y por ahora le asignamos un color.*/
    public void SpawnBlock()
    {
        block=new TetrisBlock(new int[][]{ {1,0},{1,0},{1,1} },Color.GREEN);
        block.Spawn(tableColumns);
    }    
    
    /*Metodo responsable de que el bloque caiga hacia abajo, lo que hace es
    llamar un metodo para ir hacia abajo y se va repintar el bloque en la 
    nueva posicion con respecto al eje i, j.*/
    public boolean BlockDown()
    {
        if(GridBotton()==false)
        {
            MoveBlockToBackgroud();
            return false;
        }
        
        block.Down();
        repaint();
        
        return true;
    }
    
    /*Metodo encargado de decir si el bloque puede mover hacia abajo o no*/
    private boolean GridBotton()
    {
      if(block.getBottom()==tableRows)
      {
          return false;
      }    
      return true;
    }
    
    /*Este metodo va a chequear cada elemento actual del shape array
    y si el elemento es igual a 1 el motdo va enviar el elemento correspondiente
    del Backgroud array.*/
    private void MoveBlockToBackgroud()
    {
        int [][] shape= block.getshape();
        int h=block.getHeight();
        int w= block.getWidth();
        int Iposcition=block.getI();
        int Jposcition=block.getJ();
        Color color=block.getcolor();
        
        for(int q=0;q<h;q++)
        {
            for(int e=0; e<w;e++)
            {
                if(shape[q][e]==1)
                {
                  BackgroundColor[q+Jposcition][e+Iposcition]  =color;
                }    
            }    
        }    
    }        
    
    /*Este metodo lo utilizamos para dibujar una figura y vizualizarla en el area de
    juego.*/
    private void DrawBlock(Graphics g)
    {
        int hight=block.getHeight();
        int width=block.getWidth();
        Color color=block.getcolor();
        int[][] figura=block.getshape();
        
        for(int rows=0;rows<hight;rows++)
        {
            for(int columns=0;columns<width;columns++)
            {
               if(figura[rows][columns]==1)
               {
                   int i=(block.getI()+columns)*tableCellSize;
                   int j=(block.getJ()+rows)*tableCellSize;
                    DrawSquare(g,color,i,j);
               }    
            }    
        }    
    }
    
    /* Metodo encargado de dibujar el contenido del fondo en el array en el
    area de juego*/
    private void DrawBackground(Graphics g)
    {
        Color color;
        
        for(int b=0;b<tableRows;b++)
        {
            for(int c=0; c<tableColumns;c++)
            {
                color=BackgroundColor[b][c];
                
                if(color !=null)
                {
                   int i= c*tableCellSize;
                   int j=b*tableCellSize;
                   DrawSquare(g,color,i,j);
                }    
            }    
        }    
    }
    
    /*Metodo encargado de de dibujar un solo cuadrado en la cuadricula*/
    private void DrawSquare(Graphics g,Color color, int i, int j)
    {
       g.setColor(color);
       g.fillRect(i, j, tableCellSize, tableCellSize);
       g.setColor(Color.BLACK);
       g.drawRect(i, j, tableCellSize, tableCellSize);          
    }        
    
    
    /* El metodo paintComponent es el encargado
    de agregar cosas al area de juego o el panel.
    */
   @Override
   protected void paintComponent(Graphics g) 
   {
      super.paintComponent(g);
      DrawBackground(g);
      DrawBlock(g);
   }
}
