import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Corpse extends Actor
{
    int timer;
    GreenfootImage corpse;
    
    /**
     * empty constructor
     * 
     * @author Eli Wood
     */
    public Corpse(){
        
    }
    
    /**
     * setter for the x
     * 
     * @author Eli Wood
     * @param x the new x
     */
    public void setX(int x){
        setLocation(x, getY());
    }
    
    /**
     * setter for the y
     * 
     * @author Eli Wood
     * @param y the new y
     */
    public void setY(int y){
        setLocation(getX(), y);
    }
    
    /**
     * main act for the corpse
     * 
     * @author Eli Wood
     */
    public void act(){
        if(corpse == null){
            corpse = getImage();
        }
        if(timer%1 == 0 && corpse.getTransparency() >= 0){
            fade();
        }
        
        timer++;
    }
    
    /**
     * makes the corpse 1 point more transparent
     * 
     * @author Eli Wood
     */
    public void fade(){
        corpse.setTransparency(corpse.getTransparency() - 1);
    }
    
    /**
     * getter for the transparency
     * 
     * @author Eli Wood
     * @return the corpse's transparency
     */
    public int getTransparency(){
        return corpse.getTransparency();
    }
}
