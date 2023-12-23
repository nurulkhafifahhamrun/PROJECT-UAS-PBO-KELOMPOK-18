import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Rock class
 * 
 * @author Eli Wood
 * @version 1
 */
public class Rock extends Thing
{
    protected boolean touchingFrog;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     * @param yOffset the offset from the starting coordinates
     */
    public Rock(int yOffset){
        this.yOffset = yOffset;
        getImage().scale(50, 50);
    }
    
    /**
     * main act function
     * 
     * @author Eli Wood
     */
    public void act()
    {
        if(world == null){
            world = (Game)getWorld();
        }
        checkCollision();
        checkEdge();
    }
    
    /**
     * Checks for collisions and handles them
     * 
     * @author Eli Wood
     * @version 1
     */
    protected void checkCollision(){
        if(intersects(world.getFrog()) && Math.abs(getY() - world.getFrog().getY()) <= 20){
            world.getFrog().setLocation(getX(), world.getFrog().getY());
            touchingFrog = true;
        } else{
            touchingFrog = false;
        }
    }
    
    /**
     * kills if over the edge
     * 
     * @author Eli Wood
     * @version 1
     */
    protected void checkEdge(){
        if(y > world.getHeight()){
            isDead = true;
        }
    }
    
    /**
     * getter for touching frog
     * 
     * @author Eli Wood
     * @version 1
     * @return if you are toucing the frog
     */
    public boolean touchingFrog(){
        return touchingFrog;
    }
    
    /**
     * moves to a specific location
     * 
     * @author Eli Wood
     * @version 1
     * @param x the new x
     * @param y the new y
     */
    public void moveTo(int x, int y){
        setLocation(x, y + yOffset);
    }
}
