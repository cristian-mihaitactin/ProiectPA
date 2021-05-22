package com.maze.entities;

public class Neighbour {
    private Cell cell;
    private boolean isWall = true;

    public Neighbour(Cell cell){
        this.cell = cell;
    }
}
