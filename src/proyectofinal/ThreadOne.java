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
    private int ScorePerLevel=400;
    private int Gamerunning =1200;
    private int SpeedPerLevel=100;
    
    public ThreadOne(PlayArea SaveParameter,MainFrame gf )
    {
        this.SaveParameter=SaveParameter;
        this.gf=gf;
        
        gf.UpdateScore(score);
        gf.UpdateLevel(level);
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
                        return;
                    }
            }
            
            if(SaveParameter.BlockOutOfBounds())
            {
                Proyectofinal.GameOver(score);
                break;
            }
            
            SaveParameter.MoveBlockToBackgroud();
            score+=SaveParameter.ClearLastLine();
            gf.UpdateScore(score);   
            
            int lvl=score/ScorePerLevel+1;
            if(lvl>level)
            {
                level=lvl;
                Proyectofinal.playClear(false); 
                Proyectofinal.playLvlUp();
                gf.UpdateLevel(level);
                Gamerunning-=SpeedPerLevel;
            }    
        } 
    }        
}
