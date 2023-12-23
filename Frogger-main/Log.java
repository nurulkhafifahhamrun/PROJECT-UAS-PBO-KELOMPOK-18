import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Log class
 * 
 * @author Eli Wood
 * @version 1
 */
public class Log extends Car{
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param speed the log's speed
     * @param image the log's image
     */
    public Log(double speed, GreenfootImage image){
        super(speed, image);
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param speed the log's speed
     * @param image the log's image
     * @param yOffset the offset the log is from it's initial y
     */
    public Log(double speed, GreenfootImage image, int yOffset){
        super(speed, image, yOffset);
    }
    
    /**
     * empty constructor
     * 
     * @author Eli Wood
     */
    public Log(){
        super();
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param speed the log's speed
     * @param image the log's image
     * @param width the log's width
     * @param height the log's height
     */
    public Log(double speed, GreenfootImage image, int width, int height){
        super(speed, image, width, height);
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param speed the log's speed
     * @param image the log's image
     * @param width the log's width
     * @param height the log's height
     * @param yOffset the offset the log is from it's initial y
     */
    public Log(double speed, GreenfootImage image, int width, int height, int yOffset){
        super(speed, image, width, height, yOffset);
    }

    /**
     * checks and handles player collision
     * 
     * @author Eli Wood
     */
    @Override
    protected void checkCollision(){
        //save the player
        if(intersects(world.getFrog())){
            world.getFrog().setLocation(getX(), world.getFrog().getY());
            touchingFrog = true;
        } else{
            touchingFrog = false;
        }
    }
}
