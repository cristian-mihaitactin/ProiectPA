package com.maze.main;

import com.maze.entities.Maze;
import com.maze.ui.MainFrame;

public class Main {
    private final static int ROWS = 4;
    private final static int COLUMNS = 4;

    public static void main(String[] args) {
        /*
        System.out.println("Hello!");

        Maze maze = new Maze(ROWS, COLUMNS);

        for(int i = 0; i < maze.getRows(); i++){
            for(int j = 0; j < maze.getColumns(); j++){
                System.out.print(maze.getNeighbour(i,j));
            }
            System.out.println();
        }

         */

        MainFrame mainFrame = new MainFrame();


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainFrame.createAndShowFrame();
                /*
                synchronized (mainFrame){
                    while(mainFrame.isActive()){
                        try {
                            mainFrame.wait();
                            mainFrame.redrawMazePanel();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
                                 */
            }
        });
    }
}
