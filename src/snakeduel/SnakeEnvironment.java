/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeduel;

import environment.Environment;
import environment.GraphicsPalette;
import environment.Grid;
import image.ResourceTools;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 *
 * @author dgill
 */
class SnakeEnvironment extends Environment {
    private GameState gameState = GameState.RUNNING;
    private Snake snake;
    private Grid grid;
    private int score = 0;
    private ArrayList<Point> apples;
    private int speed = 3;
    private int moveCounter = speed;
    private Object poisonbottle;
    
    public SnakeEnvironment() { 
    }

    @Override
    public void initializeEnvironment() {
        this.setBackground(ResourceTools.loadImageFromResource("resources/snakeduelone.jpg"));
        
        snake = new Snake();
        snake.getBody().add(new Point(5, 5));
        snake.getBody().add(new Point(4, 5));
        snake.getBody().add(new Point(3, 5));
        snake.getBody().add(new Point(2, 5));
        
      
        
        
        this.apples = new ArrayList<Point>();
        for (int i = 0; i < 10; i++) {
            this.apples.add(new Point(getRandomGridPoint()));
        }
        
        
                
        grid = new Grid();
        this.grid.setColor(Color.BLUE);
        this.grid.setColumns(44);
        this.grid.setRows(15);
        this.grid.setCellHeight(20);
        this.grid.setCellWidth(20);
        this.grid.setPosition(new Point(10, 100));
        
        
    }
    
    private Point getRandomGridLocation(){
      return new Point((int) (Math.random() * this.grid.getColumns()),
                         (int) (Math.random() * this.grid.getRows()) );
    }

    @Override
    public void timerTaskHandler() {
        //if (this.gameState == GameState.RUNNING){
        if (snake != null) {
            if (moveCounter <= 0) {
                snake.move();
                moveCounter = speed;
                checkSnakeIntersection();
            } else {
                moveCounter--;
                if (snake.selfHitTest()) {
                    
                }
                
            }
            
            
       
        System.out.println("Timer");
        if (snake != null){
            if (moveCounter <= 0){
                snake.move();
                moveCounter = speed;
                checkSnakeIntersection();
            } else {
                moveCounter--;  
            }
        }      
        }
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        
             if (gameState == GameState.RUNNING) {
             gameState = GameState.PAUSED;
             } else if (gameState == GameState.PAUSED) {
              gameState = GameState.RUNNING;
             }
        } else if (e.getKeyCode() == KeyEvent.VK_UP){
            snake.setDirection(Direction.UP);
            snake.move();
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            snake.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN){
            snake.setDirection(Direction.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT){
            snake.setDirection(Direction.RIGHT); 
            
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
            //grid.paintComponent(graphics);
            
           if(this.apples != null) {
               for (int i = 0; i < this.apples.size(); i++) {
                   this.apples.get(i);
                   GraphicsPalette.drawApple(graphics, this.grid.getCellPosition(this.apples.get(i)), this.grid.getCellSize());
                   
               }
               
           
           
           }
                graphics.setColor(Color.GREEN);
                Point cellLocation;
                 if (snake != null){
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

    private void checkSnakeIntersection() {
        for (int i = 0; i < this.apples.size(); i++ ) {
            if (snake.getHead().equals( this.apples.get(i) )) {
                this.apples.get(i).setLocation(getRandomGridLocation());
                this.snake.addGrowthcounter(moveCounter);
                this.score += 10;
                
                
            }
    }

}

    private Point getRandomGridPoint() {
        return new Point((int) (Math.random() * this.grid.getColumns()), (int) (Math.random() + this.grid.getRows()));
    }
    
}
 
            
   
    



