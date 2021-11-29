package proyectofinal;

import java.util.logging.Level;
import java.util.logging.Logger;

/*Clase encarga de ejecutar parte del codigo en un hilo
separado de los demas metodos y clases.*/
public class ThreadOne extends Thread
{
    private PlayArea SaveParameter;
    private MainFrame gf;
    private int score;
    private int level=1;
    private int ScorePerLevel=1;
    private int Gamerunning =300;
    private int SpeedPerLevel=100;
    
    public ThreadOne(PlayArea SaveParameter,MainFrame gf )
    {
        this.SaveParameter=SaveParameter;
        this.gf=gf;
    } 
    
    @Override
    public void run()
    {
        /* Loop encargado de mover el bloque despues de esperar
        el tiempo estimado en el hilo. Se corre mientras jugamos*/
        while(true)
        {   
            /* Crear otro bloque mientras el primero llego al fondo*/
            SaveParameter.SpawnBlock();
            
            while (SaveParameter.BlockDown())
            {
                try 
                {
                    Thread.sleep(Gamerunning);
                }
                    catch (InterruptedException ex) 
                    {
                        Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
            
            if(SaveParameter.BlockOutOfBounds())
            {
                System.out.println("Game over");
                break;
            }
            
            SaveParameter.MoveBlockToBackgroud();
            score+=SaveParameter.ClearLastLine();
            gf.UpdateScore(score);
            
            int lvl=score/ScorePerLevel+1;
            if(lvl>level)
            {
                level=lvl;
                gf.UpdateLevel(level);
                Gamerunning-=SpeedPerLevel;
            }    
        } 
    }        
}
