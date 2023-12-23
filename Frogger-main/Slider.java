import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A slider that the user can move
 * 
 * @author Eli Wood 
 * @version 1
 */
public class Slider extends Button{
    private World world;
    private int width;
    private int height;
    private int maxWidth;
    private Button interact;
    private GreenfootImage image;
    
    private int value = 100;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     * 
     * @param width the max width of the slider
     * @param height the height of the slider
     */
    public Slider(int width, int height){
        super();
        
        this.width = width;
        maxWidth = width;
        this.height = height;
        image = new GreenfootImage("button-blue.png");
        image.scale((int)(height*2), (int)(height*2));
        
        getImage().scale(width, height);
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     * 
     * @param width the max width of the slider
     * @param height the height of the slider
     * @param image the image of the button portion
     */
    public Slider(int width, int height, GreenfootImage image){
        super(image);
        
        this.width = width;
        maxWidth = width;
        this.height = height;
        image.scale((int)(height*1.5), (int)(height*1.5));
        this.image = image;
        
        getImage().scale(width, height);
    }
    
    /**
     * main act function
     * 
     * @author Eli Wood
     */
    public void act(){
        if(world == null){
            world = getWorld();
        }
        
        if(interact == null){
            interact = new Button(image, false);
            world.addObject(interact, getX() + width/2, getY());
        }
        
        mouse = Greenfoot.getMouseInfo();
        
        if(mouse != null && mouse.getClickCount() < 1 && mouse.getButton() == 1 && mouse.getActor() == interact){
            onClick();
        }
        
    }
    
    /**
     * sets the value to the mouse's x
     * 
     * @author Eli Wood
     * @version 1
     */
    public void onClick(){
        adjustWidth(mouse.getX() - getX() + width/2);
        value = (int)Game.map(width, 1, maxWidth, 1, 100);
    }
    
    /**
     * adjusts the width and the x accordingly
     * 
     * @author Eli Wood
     * @version 1
     * @param amount the new width
     */
    private void adjustWidth(int amount){
        amount = Game.constrain(amount, 1, maxWidth); //constrains the width
        
        double diff = width - amount;
        
        setLocation(getExactX() - diff/2, getExactY());
        
        width = amount;
        getImage().scale(width, height);
        
        if(interact != null){
            interact.setLocation(getExactX() + width/2, getY());
        }
        
    }
    
    /**
     * sets the value of the slider and adjusts the width accordingly
     * 
     * @author Eli Wood
     * @param value the new value
     */
    public void setValue(int value){
        this.value = value;
        
        adjustWidth((int)Game.map(value, 1, 100, 1, maxWidth));
    }
    
    /**
     * gets the value of the slide
     * 
     * @author Eli Wood
     * @version 1
     * @return the slider's value
     */
    public int getValue(){
        return value;
    }
    
    public boolean getState(){
        try{
            return interact.getState();
        } catch(Exception e){
            return false;
        }
    }
}
