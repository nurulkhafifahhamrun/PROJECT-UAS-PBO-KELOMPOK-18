import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * abstract class for a thing
 * 
 * @author Eli Wood
 * @version 1
 */
public abstract class Thing extends Actor
{
    protected int x;
    protected int y;
    protected int speed;
    protected Game world;
    protected int yOffset;
    protected boolean isDead = false;
    
    /**
     * used for checking if over the edge
     * 
     * @author Eli Wood
     */
    abstract void checkEdge();
    
    /**
     * used to detect and handle collision
     * 
     * @author Eli Wood
     */
    abstract void checkCollision();
    
    /**
     * moves to a specific location
     * 
     * @author Eli Wood
     * @param x the new x
     * @param y the new y
     */
    abstract void moveTo(int x, int y);
    
    /**
     * checks if the thing is dead
     * 
     * @return if the thing is dead
     */
    public boolean getDead(){
        return isDead;
    }
}
