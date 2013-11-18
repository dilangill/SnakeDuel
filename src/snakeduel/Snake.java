/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeduel;

import java.awt.Point;
import java.util.ArrayList;

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
    
    
    
}
