package com.maze.entities;

public class Neighbour {
    private Cell cell;
    private Cell neighbourCell;
    private NeighbourType neighbourType;
    private boolean connected = false;

    public Neighbour(Cell cell, Cell neighbourCell, NeighbourType neighbourType){
        this.cell = cell;
        this.neighbourCell = neighbourCell;
        this.neighbourType = neighbourType;
    }

    public Cell getNeighbour() {
        return neighbourCell;
    }

    public boolean isConnected() {
        return connected;

    }

    public void setConnected(boolean connected) {
        this.connected = connected;
        var oppositeNeighbour = getOppositeNeighbourType(this.neighbourType);
        neighbourCell.getNeighbour(oppositeNeighbour).get().setTrueConnected();
    }

    // When a Neighbour is connected
    protected void setTrueConnected(){
        this.connected = true;
    }

    private NeighbourType getOppositeNeighbourType(NeighbourType type){
        switch (type){
            case NORTH:
                return NeighbourType.SOUTH;
            case EAST:
                return NeighbourType.WEST;
            case SOUTH:
                return NeighbourType.NORTH;
            case WEST:
                return NeighbourType.EAST;
        }
        return null;
    }
}
