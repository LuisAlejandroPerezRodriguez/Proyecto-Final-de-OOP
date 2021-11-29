
package proyectofinal;

import javax.swing.JOptionPane;

public class Proyectofinal 
{
    private static MainFrame mf;
    private static Leaderboard lb;
    private static MainMenu mm;
    
    public static void Start()
    {
        mf.setVisible(true);
        mf.StartGame();
    }   
    
    public static void ShowLeaderboard()
    {
        lb.setVisible(true);
    }
    
    public static void ShowMainMenu()
    {
        mm.setVisible(true);
    } 
    
    public static void GameOver(int Score)
    {
       String playerName=JOptionPane.showInputDialog("Game Over :( \n Please enter your name.");

       mf.setVisible(false);
       lb.AddPlayer(playerName,Score);
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
