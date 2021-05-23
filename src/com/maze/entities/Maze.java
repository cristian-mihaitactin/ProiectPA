package com.maze.entities;

public class Maze {
    private Cell[][] cellMaze;
    private int rows;
    private int columns;
    private boolean complete = false;

    public Maze(int rows, int columns){
        this.rows = rows;
        this.columns = columns;

        cellMaze = initCellMaze(rows, columns);
    }

    private Cell[][] initCellMaze(int rows, int columns) {
        Cell[][] newMaze = new Cell[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                Cell nordNeighnour = i == 0 ? null : newMaze[i - 1][j];
                Cell westNeighnour = j == 0 ? null : newMaze[i][j - 1];
                Cell southNeighnour = i == rows - 1 ? null : newMaze[i + 1][j];
                Cell eastNeighnour = j == columns - 1 ? null : newMaze[i][j + 1];

                Cell newCell = new Cell(nordNeighnour,westNeighnour,southNeighnour,eastNeighnour);

                newMaze[i][j] = newCell;
            }
        }

        return newMaze;
    }

    public Cell[][] getCellMaze() {
        return cellMaze;
    }

    public void setCellMaze(Cell[][] cellMaze) {
        this.cellMaze = cellMaze;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Cell getCell(int i, int j){
        return cellMaze[i][j];
    }

    public boolean isComplete() {
        return complete;
    }

    public void markAsComplete() {
        this.complete = true;
    }
}
