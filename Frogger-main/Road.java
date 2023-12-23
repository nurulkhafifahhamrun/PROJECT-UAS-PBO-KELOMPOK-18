import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

public class Road extends Actor
{
    protected GreenfootImage road;
    protected boolean firstFrame = true;
    protected Game world;
    protected int x;
    protected int y;
    protected int width = 300;
    protected int height = 50;
    
    protected ArrayList<Car> cars = new ArrayList<Car>();
    protected double carSpeed = 5;
    protected int carFrequency = 60;
    protected GreenfootImage carImage = new GreenfootImage("car-5.png");
    
    //don't touch
    protected int timer = 0;
    
    /**
     * default constructor
     * 
     * @author Eli Wood
     * @version 1
     */
    public Road(){
        
        road = getImage();
        road.scale(300, 50);
        setImage(road);
    }
    
    /**
     * constructor
     * 
     * @author Eli Wood
     * @version 1
     * 
     * @param width the width of the road
     * @param height the height of the road
     */
    public Road(int width, int height){
        this.width = width;
        this.height = height;
        
        road = getImage();
        road.scale(width, height);
        setImage(road);
    }
    
    /**
     * constructor
     * 
     * @author Eli Wood
     * @version 1
     * 
     * @param width the width of the road
     * @param height the height of the road
     * @param carSpeed the speed of the car
     * @param carFrequency the frequency cars spawn
     */
    public Road(int width, int height, double carSpeed, int carFrequency){
        this.carSpeed = carSpeed;
        this.carFrequency = carFrequency;
        this.width = width;
        this.height = height;
        
        road = getImage();
        road.scale(width, height);
        setImage(road);
    }
    
    /**
     * constructor
     * 
     * @author Eli Wood
     * @version 1
     * 
     * @param width the width of the road
     * @param height the height of the road
     * @param carSpeed the speed of the car
     * @param carFrequency the frequency cars spawn
     * @param carImage the image the cars use
     */
    public Road(int width, int height, double carSpeed, int carFrequency, GreenfootImage carImage){
        this.width = width;
        this.height = height;
        this.carSpeed = carSpeed;
        this.carFrequency = carFrequency;
        this.carImage = carImage;
        
        road = getImage();
        road.scale(width, height);
    }
    
    /**
     * main act for the road
     * 
     * @author Eli Wood
     * @version 1
     */
    public void act(){
        // Add your action code here.
        if(world == null){
            world = (Game)getWorld();
        }
        
        int carY = y;
        int yOffset = 25;
        double newSpeed = carSpeed;
        
        if(timer % carFrequency == 0){
            for(int i = 0; i < 2; i++){
                cars.add(new Car(newSpeed, carImage, yOffset));
                int carX;
                if(newSpeed > 0){
                    carX = 0;
                } else{
                    carX = world.getWidth();
                }
                
                world.addObject(cars.get(cars.size()-1), carX, carY);
                newSpeed *= -1.25; //reverse for the second car
                yOffset *= -1;
            }
        }
        
        for(int i = 0; i < cars.size(); i++){
            cars.get(i).moveTo(cars.get(i).getX(), y);
            
            if(cars.get(i).getDead()){
                world.removeObject(cars.get(i));
                cars.remove(i);
                i--;
            }
        }
        
        setLocation(x, y);
        
        timer++;
    }
    
    /**
     * setter for the x
     * 
     * @author Eli Wood
     * @version 1
     * @param x the new x
     */
    public void setX(int x){
        this.x = x;
    }
    
    /**
     * setter for the y
     * 
     * @author Eli Wood
     * @version 1
     * @param y the new y
     */
    public void setY(int y){
        this.y = y;
    }
    
    /**
     * removes all cars
     * 
     * @author Eli Wood
     * @version 1
     */
    public void killAll(){
        for(int i = 0; i < cars.size(); i++){
            world.removeObject(cars.get(i));
            cars.remove(i);
            i--;
        }
    }
}
