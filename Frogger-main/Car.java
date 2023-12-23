import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Car class
 * 
 * @author Eli Wood 
 * @version 1
 */
public class Car extends Thing{
    private double speed;
    GreenfootImage image;
    protected Game world;
    private int yOffset;
    
    protected boolean touchingFrog;
    
    /**
     * default constructor
     * 
     * @author Eli Wood
     */
    public Car(){
        speed = 5;
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param speed the car's speed
     * @param image the image the car uses
     */
    public Car(double speed, GreenfootImage image){
        this.speed = speed;
        this.image = image;
        
        setImage(image);
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param speed the car's speed
     * @param image the image the car uses
     * @param yOffset the offset from the initial y
     */
    public Car(double speed, GreenfootImage image, int yOffset){
        this.speed = speed;
        this.image = image;
        this.yOffset = yOffset;
        
        setImage(image);
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param speed the car's speed
     * @param image the image the car uses
     * @param width the width of the car
     * @param height the height of the car
     */
    public Car(double speed, GreenfootImage image, int width, int height){
        this.speed = speed;
        this.image = image;
        
        image.scale(width, height);
        setImage(image);
    }
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @param speed the car's speed
     * @param image the image the car uses
     * @param width the width of the car
     * @param height the height of the car
     * @param yOffset the offset from the initial y
     */
    public Car(double speed, GreenfootImage image, int width, int height, int yOffset){
        this.speed = speed;
        this.image = image;
        this.yOffset = yOffset;
        
        image.scale(width, height);
        setImage(image);
    }
    
    /**
     * main act function
     * 
     * @author Eli Wood
     */
    public void act(){
        if(world == null){
            world = (Game)getWorld();
        }
        x = getX();
        y = getY();
        move((int)speed);
        
        checkCollision();
        
        
    }
    
    /**
     * checks for collisions and handles them
     * 
     * @author Eli Wood
     * @version 1
     */
    protected void checkCollision(){
        if(intersects(world.getFrog())){
            world.getFrog().kill();
            touchingFrog = true;
        } else{
            touchingFrog = false;
        }
    }
    
    /**
     * moves to a specified place
     * 
     * @author Eli Wood
     * @vparam x the new x
     * @param y the new y
     */
    public void moveTo(int x, int y){
        setLocation(x, y + yOffset);
    }
    
    /**
     * checks if the car is over the edge
     * 
     * @author Eli Wood
     */
    protected void checkEdge(){
        if(speed > 0){
            if(x > world.getWidth()){
                isDead = true;
            }
        } else {
            if(x < 0){
                isDead = true;
            }
        }
        
        if(y > world.getHeight()){
            isDead = true;
        }
    }
    
    /**
     * checks if the car is touching the frog
     * 
     * @author Eli Wood
     * @return if the frog is touching the car
     */
    public boolean touchingFrog(){
        return touchingFrog;
    }
}
