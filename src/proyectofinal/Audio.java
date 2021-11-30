
package proyectofinal;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Audio 
{
    private String SoundsFolder="TerisSounds"+File.separator;
    private String ClearLinePath=SoundsFolder+"clear.wav";
    private String GameOverPath=SoundsFolder+"gameover.wav";
    private String MainMenuPath=SoundsFolder+"MainMenuTheme.wav";
    private String RotatePath=SoundsFolder+"Rotar.wav";
    private String MovePath=SoundsFolder+"Movimiento.wav";
    private String DownPath=SoundsFolder+"Down.wav";
    private String ScorePath=SoundsFolder+"HighScore Theme.wav";
    private String ButtonPath=SoundsFolder+"Buton.wav";
    private String ButtonPressPath=SoundsFolder+"buttonpres.wav";
    private String Music1Path=SoundsFolder+"Music 2.wav";
    private String MoreScorePath=SoundsFolder+"Raccha.wav";
    private String LevelPath=SoundsFolder+"LvlUp.wav";
    
    private Clip clearlinesound,gameoversound,mainmenusound,rotarsound,movesound,downsound,
            scoresound,buttonsound,buttonpresssound,musicsound,pointsssound,lvlsound;
    
    public Audio()
    {
        try 
        {
            clearlinesound= AudioSystem.getClip();
            gameoversound= AudioSystem.getClip();
            mainmenusound=AudioSystem.getClip();
            rotarsound=AudioSystem.getClip();
            movesound=AudioSystem.getClip();
            downsound=AudioSystem.getClip();
            scoresound=AudioSystem.getClip();
            buttonsound=AudioSystem.getClip();
            buttonpresssound=AudioSystem.getClip();
            musicsound=AudioSystem.getClip();
            pointsssound=AudioSystem.getClip();
            lvlsound=AudioSystem.getClip();
            
            clearlinesound.open(AudioSystem.getAudioInputStream(new File(ClearLinePath).getAbsoluteFile()));  
            gameoversound.open(AudioSystem.getAudioInputStream(new File(GameOverPath).getAbsoluteFile()));
            mainmenusound.open(AudioSystem.getAudioInputStream(new File(MainMenuPath).getAbsoluteFile()));
            rotarsound.open(AudioSystem.getAudioInputStream(new File(RotatePath).getAbsoluteFile()));
            movesound.open(AudioSystem.getAudioInputStream(new File(MovePath).getAbsoluteFile()));
            downsound.open(AudioSystem.getAudioInputStream(new File(DownPath).getAbsoluteFile()));
            scoresound.open(AudioSystem.getAudioInputStream(new File(ScorePath).getAbsoluteFile()));
            buttonsound.open(AudioSystem.getAudioInputStream(new File(ButtonPath).getAbsoluteFile()));
            buttonpresssound.open(AudioSystem.getAudioInputStream(new File(ButtonPressPath).getAbsoluteFile()));
            musicsound.open(AudioSystem.getAudioInputStream(new File(Music1Path).getAbsoluteFile()));
            pointsssound.open(AudioSystem.getAudioInputStream(new File(MoreScorePath).getAbsoluteFile()));
            lvlsound.open(AudioSystem.getAudioInputStream(new File(LevelPath).getAbsoluteFile()));

            
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    
    public void playClearLine(boolean p)
    {
        if (p==true){
        clearlinesound.setFramePosition(0);
        clearlinesound.start();
        } 
        
        else
        {
           clearlinesound.stop();
        }  
        
    }
    
    public void playGameOver()
    {
        gameoversound.setFramePosition(0);
        gameoversound.start();
    } 
    
    public void playmaintheme(boolean p)
    {
       if (p==true){
       mainmenusound.setFramePosition(0);
       mainmenusound.start();
        } else 
         {
             mainmenusound.stop();
         } 
    } 
    
    public void playRotation()
    {
        rotarsound.setFramePosition(0);
        rotarsound.start();
    } 
    
    public void playMovement()
    {
        movesound.setFramePosition(0);
        movesound.start();
    } 
    
    public void playDown()
    {
        downsound.setFramePosition(0);
        downsound.start();
    }
    
    public void playScore(boolean p)
    {
       if (p==true){
       scoresound.setFramePosition(0);
       scoresound.start();
        } else 
         {
             scoresound.stop();
         } 
    }
    
    public void playButton()
    {
       buttonsound.setFramePosition(0);
       buttonsound.start();
    } 
    
    public void playbuttonpressed()
    {
       buttonpresssound.setFramePosition(0);
       buttonpresssound.start();
    }   
    
    public void playMusic(boolean p)
    {
        if (p==true){
       musicsound.setFramePosition(0);
       musicsound.start();
        } else 
         {
             musicsound.stop();
         } 
    } 
    
    public void playMorePoints()
    {
        pointsssound.setFramePosition(0);
        pointsssound.start();
    }
    
    public void playLevelUp()
    {
        lvlsound.setFramePosition(0);
        lvlsound.start();
    }        
    
}
