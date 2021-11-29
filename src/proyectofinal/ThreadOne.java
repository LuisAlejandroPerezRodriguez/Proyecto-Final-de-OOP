package proyectofinal;

import java.util.logging.Level;
import java.util.logging.Logger;

/*Clase encarga de ejecutar parte del codigo en un hilo
separado de los demas metodos y clases.*/
public class ThreadOne extends Thread
{
    private PlayArea SaveParameter;
    
    public ThreadOne(PlayArea SaveParameter)
    {
        this.SaveParameter=SaveParameter;
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
                    Thread.sleep(100);
                }
                    catch (InterruptedException ex) 
                    {
                        Logger.getLogger(ThreadOne.class.getName()).log(Level.SEVERE, null, ex);
                    }
            }
        } 
    }        
}
