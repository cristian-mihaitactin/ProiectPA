package com.maze.entities;

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

    public Cell(Cell nordNeighbour, Cell westNeighbour, Cell southNeighbour, Cell eastNeighbour){
        this.id = UUID.randomUUID();

        if (nordNeighbour != null){
            this.nord = Optional.of(new Neighbour(nordNeighbour));
            nordNeighbour.setSouth(Optional.of(new Neighbour(this)));
        }else{
            this.nord = Optional.empty();
        }

        if (westNeighbour != null){
            this.west = Optional.of(new Neighbour(westNeighbour));
            westNeighbour.setEast(Optional.of(new Neighbour(this)));
        }else{
            this.west = Optional.empty();
        }

        if (southNeighbour != null){
            this.south = Optional.of(new Neighbour(southNeighbour));
            southNeighbour.setNord(Optional.of(new Neighbour(this)));
        }else{
            this.south = Optional.empty();
        }

        if (eastNeighbour != null){
            this.east = Optional.of(new Neighbour(eastNeighbour));
            eastNeighbour.setWest(Optional.of(new Neighbour(this)));
        }else{
            this.east = Optional.empty();
        }
    }

    public UUID getId() {
        return id;
    }

    public Optional<Neighbour> getNord() {
        return nord;
    }

    public void setNord(Optional<Neighbour> nord) {
        this.nord = nord;
    }

    public Optional<Neighbour> getWest() {
        return west;
    }

    public void setWest(Optional<Neighbour> west) {
        this.west = west;
    }

    public Optional<Neighbour> getSouth() {
        return south;
    }

    public void setSouth(Optional<Neighbour> south) {
        this.south = south;
    }

    public Optional<Neighbour> getEast() {
        return east;
    }

    public void setEast(Optional<Neighbour> east) {
        this.east = east;
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
}
