import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The start screen for the game
 * 
 * @author Eli Wood
 * @version 1
 */
public class Start extends Menu
{
    UIElement title;

    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     * 
     * @param game the game you are coming from
     */
    public Start(Game game)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(game); 
        showText("Press space to start", getWidth()/2, getHeight()/2);
        title = new UIElement(new GifImage("title.gif"));
        addObject(title, getWidth()/2, getHeight()/2 - 50);
        
    }
    
    /**
     * main act function
     * 
     * @author Eli Wood
     * @version 1
     */
    public void act(){
        showText("Press space to start", getWidth()/2, getHeight()/2);
        
        if(Greenfoot.isKeyDown("space")){
            removeObject(title);
            Greenfoot.setWorld(world);
        } else if(Greenfoot.isKeyDown("escape")){
            Greenfoot.setWorld(new Pause(this));
        }
    }
}
