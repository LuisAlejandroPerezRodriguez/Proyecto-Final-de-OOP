
package proyectofinal;

import Blocks.*;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
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
    
    private TetrisBlock[] Blocks;
    
    public PlayArea(JPanel ContainThePlayArea, int columns)
    {
        //ContainThePlayArea.setVisible(false);
        this.setBounds(ContainThePlayArea.getBounds());
        this.setBackground(ContainThePlayArea.getBackground());
        this.setBorder(ContainThePlayArea.getBorder());
        
        tableColumns=columns;
        tableCellSize=this.getBounds().width/tableColumns;
        tableRows=this.getBounds().height/tableCellSize;
        
        
        Blocks=new TetrisBlock[]{new IShape(),new JShape(), new LShape(),
        new OShape(), new SShape(),new TShape(),new ZShape()};
    }
    
    public void ResetBackgroundArray()
    {
       BackgroundColor=new Color[tableRows][tableColumns];
    }        
    
    /*Metodo responsable de spawnear bloques, dentro del metodo
    instanciamos el bloque y por ahora le asignamos un color.*/
    public void SpawnBlock()
    {
        Random r=new Random();
        block=Blocks[r.nextInt(Blocks.length)];
        block.Spawn(tableColumns);
    }    
    
    /*Metodo que me indica que el bloque esta fuera del area de juego*/
    public boolean BlockOutOfBounds()
    {
        if(block.getJ()<0)
        {
            block=null;
            return true;
        }    
        
        return false;
    } 

    /*Metodo responsable de que el bloque caiga hacia abajo, lo que hace es
    llamar un metodo para ir hacia abajo y se va repintar el bloque en la 
    nueva posicion con respecto al eje i, j.*/
    public boolean BlockDown()
    {
        if(GridBotton()==false)
        {
            return false;
        }
        
        block.Down();
        repaint();
        
        return true;
    }
           
    
    /* Los metodos acontinuacion son los encargados del movimiento de
    los bloques y la rotacion.*/
    public void moveBlockRight()
    {
        if(block==null)return;
        if(!GridRight())return;
        Proyectofinal.playMovement();
        block.Right();
        repaint();
        
    }
    
    public void moveBlockLeft()
    {
        if(block==null)return;
        if(!GridLeft())return;
        block.Left();
        repaint();
        Proyectofinal.playMovement();
    }
       
    public void moveBlockDown()
    {
       if(block==null)return;
        repaint();
    }
    
    public void RotateBlock()
    {
        if(block==null)return;
        block.rotate();
        
        if(block.getLeftLimit()<0)block.setI(0);
        if(block.getRightLimit()>=tableColumns)block.setI(tableColumns-block.getWidth());
        if(block.getBottom()>=tableRows)block.setJ(tableRows-block.getHeight());
        
        repaint();
        Proyectofinal.playRotation();
    }
    

    /*Metodo encargado de decir si el bloque puede mover hacia abajo o no*/
    private boolean GridBotton()
    {
      if(block.getBottom()==tableRows)
      {
          return false;
      } 
      
      int[][] shape=block.getshape();
      int w=block.getWidth();
      int h=block.getHeight();
      
      for(int columns=0;columns<w;columns++)
      {
         for(int Row=h-1;Row>=0;Row--)
         {
             if(shape[Row][columns] !=0)
             {
                 int i= columns+block.getI();
                 int j=Row+block.getJ()+1;
                 if(j<0)break;
                 if(BackgroundColor[j][i]!=null)return false;
                 break;
             }    
         }    
      }    
      return true;
    }
    
    /*Los metodos acontinuacion son los encargados de chequear que los bloques
    no atraviesen el area de juego por la izquierda o derecha.*/
    private boolean GridRight()
    {
        if(block.getRightLimit()==tableColumns) return false;
        
      int[][] shape=block.getshape();
      int w=block.getWidth();
      int h=block.getHeight();
      
      for(int row=0;row<h;row++)
      {
         for(int colum=w-1;colum>=0;colum--)
         {
             if(shape[row][colum] !=0)
             {
                 int i= colum+block.getI()+1;
                 int j=row+block.getJ();
                 if(j<0)break;
                 if(BackgroundColor[j][i]!=null)return false;
                 break;
             }    
         }    
      }   
      
        
        return true;
    }  
    
    private boolean GridLeft()
    {
        if(block.getLeftLimit()==0) return false;
        
      int[][] shape=block.getshape();
      int w=block.getWidth();
      int h=block.getHeight();
      
      for(int row=0;row<h;row++)
      {
         for(int colum=0;colum<w;colum++)
         {
             if(shape[row][colum] !=0)
             {
                 int i= colum+block.getI()-1;
                 int j=row+block.getJ();
                 if(j<0)break;
                 if(BackgroundColor[j][i]!=null)return false;
                 break;
             }    
         }    
      }   
        
        return true;
    }    
    
    /*Metodo que limpia las lineas cuando se completan*/
    public int ClearLastLine()
    {
        boolean Line;
        int LinesCleared=0;
        
        for (int a=tableRows-1;a>=0;a--)
        {
            Line=true;
            
            for(int b=0;b<tableColumns;b++)
            {
                if(BackgroundColor[a][b]==null)
                {
                    Line=false;
                    break;
                }    
            }
            
            if(Line)
            {
             LinesCleared++;   
             ClearLine(a);
             HaciaAbajo(a);
             ClearLine(0);
             
             a++;
             
             repaint();
            }    
            
        }
        if(LinesCleared>0)
        {    
        Proyectofinal.playClear(true);
        }
        if (LinesCleared==2)
        {  
        return (LinesCleared-2)+20*2;
        } 
        if(LinesCleared==3)
        {
          Proyectofinal.playClear(false);    
          Proyectofinal.playRacha(); 
          return (LinesCleared-3)+25*3; 
        }
         if(LinesCleared==4)
        {
          Proyectofinal.playClear(false);    
          Proyectofinal.playRacha();   
          return (LinesCleared-4)+50*4; 
        }
          if(LinesCleared==5)
        {
          Proyectofinal.playClear(false);    
          Proyectofinal.playRacha(); 
          return (LinesCleared-5)+100*5; 
        }  
        else
        return LinesCleared; 
    }  
    
    /* Logica para borrar lineas*/
    private void ClearLine(int a)
    {
         for(int i=0;i<tableColumns;i++)
              {
                  BackgroundColor[a][i]=null;
              }
    }
    
    private void HaciaAbajo(int a)
    {
        for(int row=a;row>0;row--)
        {
            for(int colm=0;colm<tableColumns;colm++)
            {
                BackgroundColor[row][colm]=BackgroundColor[row-1][colm];
            }    
        }    
    }        
    
    /*Este metodo va a chequear cada elemento actual del shape array
    y si el elemento es igual a 1 el motdo va enviar el elemento correspondiente
    del Backgroud array.*/
    public void MoveBlockToBackgroud()
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
         Proyectofinal.playDown();
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
        
        for(int row = 0; row < hight; row++) {
           for( int col = 0; col < width; col++) {
               if(figura[row][col] != 0) {
                   int x = col + block.getI();
                   int y = row + block.getJ();
                   if(y < 0)
                       break;
                   if(BackgroundColor[y][x] != null){
                       block.rotateBack();
                       repaint();
                       return;
                   }
                       
               }
           }
       }
        
        repaint();
        
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
