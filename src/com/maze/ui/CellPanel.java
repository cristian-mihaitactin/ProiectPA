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

    private Color color;
    public CellPanel(Cell matrixCell){
        //TODO the main panel should do the drawing an store the lines. you just tell it what to draw or hide
        super();
        this.matrixCell = matrixCell;
        this.setBorder(new CellBorder(matrixCell, Color.RED, 15));
        this.color = Color.GREEN;
    }

    //for testing
    /*
    public CellPanel(){
        super();
        this.setBorder(new CellBorder(Color.RED, 15));

    }

     */

    /*
    @Override
    public void paint(Graphics g) {
        Graphics2D graphic2d = (Graphics2D) g;
        graphic2d.setColor(Color.BLUE);

        graphic2d.setStroke(new BasicStroke(10));
        graphic2d.fillRect(100, 50, 60, 80);
        Line2D lin = new Line2D.Float();//new Line2D.Float(100, 100, 250, 260);
        Point2D pointA = new Point2D.Float(0, 0);
        Point2D pointB = new Point2D.Float(250, 260);
        lin.setLine(pointA, pointB);

        graphic2d.draw(lin);
    }
    */

    @Override
    protected void paintComponent(Graphics g) {

        this.setBackground(this.color);
        this.paintBorder(g);
        super.paintComponent(g);

        // draw the rectangle here
        //g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
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
}
