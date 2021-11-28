
package proyectofinal;

import java.awt.Color;

/*Se creo esta clase para poder manejar el codigo mejor,
ya que teniamos que acceder a PlayArea para poder manejar 
los bloques, por ende para mayor comodidad y mejor manejo del 
codigo se creo esta clase.*/
public class TetrisBlock 
{
    /*Cada bloque de tetris tiene una figura y colores diferentes.
    Declaracion de las variables responsable de las cordenadas 
    del bloque.*/
    private int[][] shape;
    private Color color;
    private int i,j;
    private int [][][] shapes;
    private int CurrentRotation;
    
    public TetrisBlock(int[][] shape, Color color)
    {
        this.shape=shape;
        this.color=color;
        
        initshapes();
    } 
    
    private void initshapes()
    {
        shapes= new int[4][][];
        
        for(int i=0;i<4;i++)
        {
            int a=shape[0].length;
            int b=shape.length;
            
            shapes[i]=new int[a][b];
            
            for(int k=0; k<a;k++)
            {
                for(int x=0; x<b;x++)
                {
                    shapes[i][k][x]=shape[b-x-1][k];
                }    
            } 
            
            shape=shapes[i];
        }    
    }        
    
    /*Metodo encargado de generar el bloque en el centro del area jugable.*/
    public void Spawn(int width)
    {
        CurrentRotation=0;
        shape=shapes[CurrentRotation];
        
        j=-getHeight();
        i=(width-getWidth())/2;
    }        
    
    /* Declaramos los metodos geters para poder acceder
    a los parametros de los bloques. Tambien para obtener
    el ancho y largo de los bloques.*/
    public int[][] getshape(){return shape;}
    
    public Color getcolor(){return color;}
    
    public int getHeight(){return shape.length;}
    
    public int getWidth(){return shape[0].length;}
    
    public int getI(){return i;}
    
    public int getJ(){return j;}
    
    /*Metodos responsables del movimiento del bloque ya sea
    hacia abajo, izquierda y derecha.*/
    public void Down(){j++;}
    
    public void Left(){i--;}
    
    public void Right(){i++;}
    
    /*Metodo responsable de rotar el bloque*/
    public void rotate()
    {
        CurrentRotation++;
        if(CurrentRotation>3) CurrentRotation=0;
        shape=shapes[CurrentRotation];
    }        
    
    /* Metodo encargado de calcular las cordenadas en j y la altura del bloque.*/
    public int getBottom(){return j + getHeight();}
    
    /* Metodos que retornar los limites derechos y izquerdos del area de juesgo.*/
    public int getLeftLimit(){return i;}
    
     public int getRightLimit(){return i+getWidth();}
    
    
}
