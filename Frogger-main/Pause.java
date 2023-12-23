import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Pause screen
 * 
 * @author Eli Wood
 * @version 1
 */
public class Pause extends Menu{
    UIElement title;
    Button muteMusic;
    Button muteSound;
    
    Slider musicSlider;
    Slider soundSlider;
    
    private static int musicVolume = 100;
    private static int soundVolume = 100;
    private static boolean musicMuted = false;
    private static boolean soundMuted = false;
    
    /**
     * Constructor 
     * 
     * @author Eli Wood
     * @version 1
     * @param world the world you are comung from
     */
    public Pause(World world){    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(world); 
        
        showText("Press space to resume", getWidth()/2, getHeight()/2 - 100);
        
        muteMusic = new Button();
        muteSound = new Button();
        
        musicSlider = new Slider(getWidth()/5*2, 20);
        soundSlider = new Slider(getWidth()/5*2, 20);
        
        title = new UIElement(new GifImage("title.gif"));
        addObject(title, getWidth()/2, getHeight()/2 - 150);
        addObject(muteMusic, getWidth()/5, getHeight()/2);
        addObject(muteSound, getWidth()/5, getHeight()/2 + 75);
        muteMusic.setState(musicMuted);
        muteSound.setState(soundMuted);
        addObject(musicSlider, getWidth()/2, getHeight()/2);
        addObject(soundSlider, getWidth()/2, getHeight()/2 + 75);
        showText("Music:" + musicVolume, getWidth()/5*4, getHeight()/2);
        showText("Sound:" + soundVolume, getWidth()/5*4, getHeight()/2 + 75);
    }
    
    /**
     * main act function
     * 
     * @author Eli Wood
     * @version 1
     */
    public void act(){
        if(!musicSlider.getState()){
            musicSlider.setValue(musicVolume);
        }
        
        if(!soundSlider.getState()){
            soundSlider.setValue(soundVolume);
        }
        
        showText("Press space to resume", getWidth()/2, getHeight()/2 - 100);
        
        showText("Music:" + musicVolume, getWidth()/5*4, getHeight()/2);
        showText("Sound:" + soundVolume, getWidth()/5*4, getHeight()/2 + 75);
        
        if(muteMusic.getState()){
            musicVolume = 1;
        } else{
            musicVolume = musicSlider.getValue();
        }
        
        if(muteSound.getState()){
            soundVolume = 1;
        } else{
            soundVolume = soundSlider.getValue();
        }
        
        musicMuted = muteMusic.getState();
        soundMuted = muteSound.getState();
        
        if(Greenfoot.isKeyDown("space")){
            removeObject(title);
            removeObject(muteMusic);
            removeObject(muteSound);
            Greenfoot.setWorld(world);
        }
    }
    
    /**
     * gets the music volume
     * 
     * @author Eli Wood
     * @version 1
     * @return music volume
     */
    public static int getVolume(){
        return musicVolume;
    }
    
    /**
     * gets the sound effect volume
     * 
     * @author Eli Wood
     * @version 1
     * @return sound effect volume
     */
    public static int getSoundVolume(){
        return soundVolume;
    }
}
