package com.maze.entities;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Cell {
    private Optional<Neighbour> nord;
    private Optional<Neighbour> west;
    private Optional<Neighbour> south;
    private Optional<Neighbour> east;

    private UUID id;
    private CellStatus status = CellStatus.UNVISITED;
    private CellType cellType = CellType.PATH;

    //For debugging purposes
    private int row;
    private int column;


    //for testing
    public Cell(){

    }

    public Cell(Cell nordNeighbour, Cell westNeighbour, Cell southNeighbour, Cell eastNeighbour, int row, int column) {
        this(nordNeighbour,  westNeighbour,  southNeighbour,  eastNeighbour);
        this.row = row;
        this.column = column;

    }
    public Cell(Cell nordNeighbour, Cell westNeighbour, Cell southNeighbour, Cell eastNeighbour){
        this.id = UUID.randomUUID();

        if (nordNeighbour != null){
            this.nord = Optional.of(new Neighbour(this, nordNeighbour, NeighbourType.NORTH));
            nordNeighbour.setNeighbour(new Neighbour(nordNeighbour,this, NeighbourType.SOUTH), NeighbourType.SOUTH);
        }else{
            this.nord = Optional.empty();
        }

        if (westNeighbour != null){
            this.west = Optional.of(new Neighbour(this, westNeighbour, NeighbourType.WEST));
            westNeighbour.setNeighbour(new Neighbour(westNeighbour, this, NeighbourType.EAST), NeighbourType.EAST);
        }else{
            this.west = Optional.empty();
        }

        if (southNeighbour != null){
            this.south = Optional.of(new Neighbour(this, southNeighbour, NeighbourType.SOUTH));
            southNeighbour.setNeighbour(new Neighbour(southNeighbour, this, NeighbourType.NORTH), NeighbourType.NORTH);
        }else{
            this.south = Optional.empty();
        }

        if (eastNeighbour != null){
            this.east = Optional.of(new Neighbour(this, eastNeighbour, NeighbourType.EAST));
            eastNeighbour.setNeighbour(new Neighbour(eastNeighbour, this, NeighbourType.WEST), NeighbourType.WEST);
        }else{
            this.east = Optional.empty();
        }
    }

    public UUID getId() {
        return id;
    }

    public Optional<Neighbour> getNeighbour(NeighbourType searchNeighbourType){
        switch (searchNeighbourType){
            case NORTH:
                return nord;
            case EAST:
                return east;
            case SOUTH:
                return south;
            case WEST:
                return west;
            default:
                return Optional.empty();
        }
    }

    public void setNeighbour(Neighbour newNeighbour, NeighbourType searchNeighbourType){
        switch (searchNeighbourType){
            case NORTH:
                nord = Optional.of(newNeighbour);
                break;
            case EAST:
                east = Optional.of(newNeighbour);
            break;
            case SOUTH:
                south= Optional.of(newNeighbour);
                break;
            case WEST:
                west= Optional.of(newNeighbour);
                break;
        }
    }

    public CellStatus getStatus() {
        return status;
    }

    public void setStatus(CellStatus status) {
        this.status = status;
    }


    public CellType getCellType() {
        return cellType;
    }

    public void setCellType(CellType cellType) {
        this.cellType = cellType;
    }

    public List<Neighbour> getUnvisitedNeighbour(){
        List<Neighbour> unvisited = new LinkedList<Neighbour>();

        if(!nord.isEmpty() && nord.get().getNeighbour().getStatus() == CellStatus.UNVISITED)
        {
            unvisited.add(nord.get());
        }

        if(!east.isEmpty() && east.get().getNeighbour().getStatus() == CellStatus.UNVISITED)
        {
            unvisited.add(east.get());
        }

        if(!south.isEmpty() && south.get().getNeighbour().getStatus() == CellStatus.UNVISITED)
        {
            unvisited.add(south.get());
        }

        if(!west.isEmpty() && west.get().getNeighbour().getStatus() == CellStatus.UNVISITED)
        {
            unvisited.add(west.get());
        }

        return unvisited;
    }
}
