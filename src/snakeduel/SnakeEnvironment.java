/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeduel;

import environment.Environment;
import environment.Grid;
import java.awt.Color;
import java.awt.Font;
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
    private String score;
    
    private int speed = 5;
    private int moveCounter = speed;
    
    public SnakeEnvironment() {
    }

    @Override
    public void initializeEnvironment() {
        snake = new Snake();
        snake.getBody().add(new Point(5, 5));
        snake.getBody().add(new Point(4, 5));
        snake.getBody().add(new Point(3, 5));
        
        grid = new Grid();
        this.grid.setColor(Color.BLUE);
        this.grid.setColumns(44);
        this.grid.setRows(15);
        this.grid.setCellHeight(20);
        this.grid.setCellWidth(20);
        this.grid.setPosition(new Point(10, 100));
        
        
    }

    @Override
    public void timerTaskHandler() {
        System.out.println("Timer");
        if (snake != null){
            if (moveCounter <= 0){
                snake.move();
                moveCounter = speed;
            } else {
                moveCounter--;  
            }
               
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
           this.score += 57;
        } else if (e.getKeyCode() == KeyEvent.VK_W){
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_A){
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_S){
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_D){
            snake.move();
        }
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
                    graphics.fillOval(cellLocation.x, cellLocation.y, grid.getCellWidth(), grid.getCellHeight());
                }
            }
        }
    graphics.setColor(Color.BLACK);
    graphics.setFont(new Font("CenturyGothic", Font.BOLD, 60));
    graphics.drawString("Score: " + this.score, 50, 50); 
 
    }
      
}
