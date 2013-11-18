/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package snakeduel;

import environment.ApplicationStarter;

/**
 *
 * @author dgill
 */
public class SnakeDuel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ApplicationStarter.run("Dilan's Snake Duel!!!!", new SnakeEnvironment());
    }
}
