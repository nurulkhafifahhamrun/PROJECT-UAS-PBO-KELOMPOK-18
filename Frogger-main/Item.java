import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * class for an item that can interact with the player
 * 
 * @author Eli Wood 
 * @version 1
 */
public class Item extends Thing
{
    /**
     * main act function
     * 
     * @author Eli Wood
     */
    public void act(){
        y = getY();
        x = getX();
        checkCollision();
        checkEdge();
    }
    
    /**
     * moves to a specific location
     * 
     * @author Eli Wood
     * @param x the new x
     * @param y the new y
     */
    public void moveTo(int x, int y){
        setLocation(x, y);
    }
    
    /**
     * checks if the frog is intersecting with the item
     * 
     * @author Eli Wood
     */
    public void checkCollision(){
        if(intersects(world.getFrog())){
            
            
            isDead = true;
        }
    }
    
    /**
     * checks if the item is over the edge
     * 
     * @author Eli Wood
     */
    public void checkEdge(){
        if(y < world.getHeight()){
            isDead = true;
        }
    }
}
