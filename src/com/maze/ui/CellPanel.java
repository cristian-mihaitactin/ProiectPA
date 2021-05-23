package com.maze.ui;

import com.maze.entities.Cell;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class CellPanel extends JPanel {
    private Cell matrixCell;

    private static final int RECT_X = 20;
    private static final int RECT_Y = RECT_X;
    private static final int RECT_WIDTH = 100;
    private static final int RECT_HEIGHT = RECT_WIDTH;

    private int row;
    private int column;

    private Color color;
    public CellPanel(Cell matrixCell, int row, int column){
        //TODO the main panel should do the drawing an store the lines. you just tell it what to draw or hide
        super();
        this.matrixCell = matrixCell;
        this.setBorder(new CellBorder(matrixCell, Color.RED, 15));
        //this.color = Color.GREEN;

        this.row = row;
        this.column = column;
    }

    @Override
    protected void paintComponent(Graphics g) {

        this.setBackground(this.color);
        this.paintBorder(g);
        super.paintComponent(g);

        // draw the rectangle here
    }

    @Override
    public Dimension getPreferredSize() {
        // so that our GUI is big enough
        return new Dimension(RECT_WIDTH + 2 * RECT_X, RECT_HEIGHT + 2 * RECT_Y);
    }
    public Cell getMatrixCell() {
        return matrixCell;
    }

    public void setMatrixCell(Cell matrixCell) {
        this.matrixCell = matrixCell;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
