import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Button class
 * 
 * @author Eli Wood
 * @version 1
 */
public class Button extends UIElement implements Clickable{
    boolean active = true;
    
    MouseInfo mouse = Greenfoot.getMouseInfo();
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     * @param image the image the button will use
     * @param active the default value
     */
    public Button (GreenfootImage image, boolean active){
        super(image);
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     * @param image the image the button will use
     */
    public Button (GreenfootImage image){
        super(image);
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     */
    public Button(){
        
    }
    
    /**
     * main act function
     * 
     * @author Eli Wood
     */
    public void act(){
        mouse = Greenfoot.getMouseInfo();
        
        if(mouse != null && mouse.getClickCount() < 1 && mouse.getButton() == 1 && mouse.getActor() == this){
            onClick();
        }
        
    }
    
    /**
     * toggles the state
     * 
     * @author Eli Wood
     * @version 1
     */
    public void onClick(){
        active = !active;
    }
    
    /**
     * sets the current state
     * 
     * @author Eli Wood
     * @version 1
     * @param state the new state
     */
    public void setState(boolean state){
        active = state;
    }
    
    /**
     * gets the current state
     * 
     * @author Eli Wood
     * @version 1
     * @return the current state
     */
    public boolean getState(){
        return active;
    }
}
