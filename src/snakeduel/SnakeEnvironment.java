/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeduel;

import environment.Environment;
import environment.Grid;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author dgill
 */
class SnakeEnvironment extends Environment {
    private Snake snake;
    private Grid grid;

    public SnakeEnvironment() {
    }

    @Override
    public void initializeEnvironment() {
        snake = new Snake();
        snake.getBody().add(new Point(5, 5));
        snake.getBody().add(new Point(4, 5));
        snake.getBody().add(new Point(3, 5));
        
        grid = new Grid();
        // change grid stuff here...
        
    }

    @Override
    public void timerTaskHandler() {
    
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
    
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (grid != null){
            grid.paintComponent(graphics);
            
            if (snake != null){
                graphics.setColor(Color.GREEN);
                Point cellLocation;
                for (int i = 0; i < snake.getBody().size(); i++) {
                    cellLocation = grid.getCellPosition(snake.getBody().get(i));
                    graphics.fillRect(cellLocation.x, cellLocation.y, grid.getCellWidth(), grid.getCellHeight());
                }
            }
        }
    
    }
    
}
