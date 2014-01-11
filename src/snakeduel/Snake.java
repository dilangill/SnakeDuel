/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeduel;

import java.awt.Point;
import java.util.ArrayList;
import static snakeduel.Direction.DOWN;
import static snakeduel.Direction.UP;

/**
 *
 * @author dgill
 */
public class Snake {
    private ArrayList<Point> body;
    private Direction direction = Direction.RIGHT;
    
    
    {
        setBody(new ArrayList<Point>());
    }
    
    public void move(){
       int x = 0;
       int y = 0; 
       
       switch (getDirection()){
           case UP:
               x = 0;
               y = -1;
               break;
               
           case DOWN:
               x = 0;
               y = 1;
               break;
              
           case RIGHT:
               x = 1;
               y = 0;
               break;
                  
           case LEFT:
               x = -1;
               y = 0;
                      
           
       }
       
        getBody().add(0, new Point(getHead().x + x, getHead().y + y)); 
       
        getBody().remove(getBody().size() - 1);
       
    }
    
    public Point getHead(){
        return getBody().get(0);
    }

    /**
     * @return the body
     */
    public ArrayList<Point> getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(ArrayList<Point> body) {
        this.body = body;
    }

    /**
     * @return the direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * @param direction the direction to set
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    
    
}
