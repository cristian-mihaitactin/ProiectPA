package com.maze.ai;

import com.maze.ai.algorithm.IMazeGenerationAlg;
import com.maze.entities.Maze;

public class MazeGeneratorManager /*implements Runnable*/ {
    protected Maze maze;
    protected IMazeGenerationAlg mazeGenerationAlg;

    public MazeGeneratorManager(IMazeGenerationAlg algorithm, Maze maze){
        this.mazeGenerationAlg = algorithm;
        this.maze = maze;
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

    public void run() throws Exception {
        this.mazeGenerationAlg.prepareAlgorithm(this.maze);
        while(!maze.isComplete()){
            mazeGenerationAlg.applyNextStep();
        }
    }
    /*
    @Override
    public void run() {
        synchronized (maze) {
            startGame();
            while (!board.getTokens().isEmpty()) {
                try {
                    board.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (board.getTokens().isEmpty()) {
                board.showEndgameResult();
            }
        }
    }

     */
}
