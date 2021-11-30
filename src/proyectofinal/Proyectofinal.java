
package proyectofinal;

import javax.swing.JOptionPane;

public class Proyectofinal 
{
    private static MainFrame mf;
    private static Leaderboard lb;
    private static MainMenu mm;
    
    private static Audio audio=new Audio();
    
    public static void Start()
    {
        mf.setVisible(true);
        mf.StartGame();
        playMainMenu(false);
       

    }   
    
    public static void ShowLeaderboard()
    {
        lb.setVisible(true);
        playScore(true);
        playMainMenu(false);
        playScore(true);

    }
    
    public static void ShowMainMenu()
    {
        boolean p=true;
        mm.setVisible(true);
        playMainMenu(p);
        playMainMenu(p);

    } 
    
    public static void GameOver(int Score)
    {
       playGameOver();
       Proyectofinal.playMusicGame(false);
       String playerName=JOptionPane.showInputDialog("Game Over :( \n Please enter your name.");
        
       mf.setVisible(false);
       lb.AddPlayer(playerName,Score);
    }
    
    public static void playClear(boolean p)
    {
        audio.playClearLine(p);
    } 
    
    public static void playGameOver()
    {
        audio.playGameOver();
    }
    
    public static void playMainMenu(boolean p)
    {
        audio.playmaintheme(p);
    }
    
    public static void playRotation()
    {
        audio.playRotation();
    } 
    
    public static void playMovement()
    {
        audio.playMovement();
    }
    
    public static void playDown()
    {
        audio.playDown();
    }
    
    public static void playScore(boolean p)
    {
        audio.playScore(p);
    } 
    
    public static void playbutton()
    {
        audio.playButton();
    } 
    
    public static void playbuttonpress()
    {
        audio.playbuttonpressed();
    }
    
    public static void playMusicGame(boolean p)
    {
        audio.playMusic(p);
    }
    
    public static void playRacha()
    {
        audio.playMorePoints();
    }
    
    public static void playLvlUp()
    {
        audio.playLevelUp();
    }        
         
    
    public static void main(String[] args) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                 mf=new MainFrame();
                 lb=new Leaderboard();
                 mm=new MainMenu();
         
                 mm.setVisible(true);
            }
        });
        
    }
    
}
