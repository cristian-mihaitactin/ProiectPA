package com.maze.ai;

import com.maze.ai.algorithm.IMazeGenerationAlg;
import com.maze.entities.Maze;
import com.maze.ui.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MazeGeneratorManager implements Runnable {
    protected Maze maze;
    protected IMazeGenerationAlg mazeGenerationAlg;
    protected MainFrame mainFrame;

    public MazeGeneratorManager(IMazeGenerationAlg algorithm, MainFrame mainFrame){
        this.mazeGenerationAlg = algorithm;
        this.mainFrame = mainFrame;
    }

    public Maze getMaze() {
        return maze;
    }

    public void setMaze(Maze maze) {
        this.maze = maze;
    }

    public IMazeGenerationAlg getMazeGenerationAlg() {
        return mazeGenerationAlg;
    }

    protected void setMazeGenerationAlg(IMazeGenerationAlg mazeGenerationAlg) {
        this.mazeGenerationAlg = mazeGenerationAlg;
    }

    public void run() {
        Maze maze = mainFrame.getMainMaze();
        mazeGenerationAlg.prepareAlgorithm(maze);
        Timer timer = null;
        do{
            try {
                int delay = 100; //milliseconds
                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        try {
                            if (maze.isComplete())
                            {
                                return;
                            }
                            mainFrame.setMainMaze(mazeGenerationAlg.applyNextStep());
                            mainFrame.redrawMazePanel();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                timer = new Timer(delay, taskPerformer);
                timer.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }while(!maze.isComplete() && !timer.isRunning());
    }
}
