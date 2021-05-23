package com.maze.ai.algorithm;

import com.maze.entities.Maze;

public interface IMazeGenerationAlg {
    void prepareAlgorithm(Maze maze);
    Maze applyNextStep() throws Exception;
}
