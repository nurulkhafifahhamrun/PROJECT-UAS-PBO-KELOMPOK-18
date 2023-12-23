import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * abstract menu class
 * 
 * @author Eli Wood
 * @version 1
 */
public abstract class Menu extends World
{
    protected World world;
    
    /**
     * Constructor
     * 
     * @author Eli Wood
     * @version 1
     * @param world the world you are coming from
     */
    public Menu(World world)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(300, 500, 1); 
        this.world = world;
    }
}
