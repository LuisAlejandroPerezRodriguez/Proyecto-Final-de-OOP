package Blocks;

import proyectofinal.TetrisBlock;

public class IShape extends TetrisBlock 
{
    public IShape()
    {
        super(new int[][]{{1,1,1,1}});
    } 
    
    /*Este metodo es para rotar la figura de la I de forma
    aceptable.*/
    @Override
    public void rotate()
    {
        super.rotate();
        
        if(this.getWidth()==1)
        {
            this.setI(this.getI()+1);
            this.setJ(this.getJ()-1);
        }
        else
        {
            this.setI(this.getI()-1);
            this.setJ(this.getJ()+1);
        }    
    }        
}
