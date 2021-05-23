package com.maze.ui;

import com.maze.entities.Cell;
import com.maze.entities.NeighbourType;

import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class CellBorder extends AbstractBorder {
    private Cell matrixCell;
    private Color borderColour;
    private int gap;

    public CellBorder(Cell matrixCell, Color colour, int g){
        this.matrixCell = matrixCell;
        this.borderColour = colour;
        this.gap = g;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y,
                            int width, int height) {

        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = null;
        if (g instanceof Graphics2D)
        {
            g2d = (Graphics2D) g;
            g2d.setColor(borderColour);
            this.drawBoarders(g2d, x, y, width, height);
            //Left Border

            //////////////////TESTING
            /*
            x -= 10;
            y -= 10;

             */

            /*
            height += 10;
            width += 10;

             */
            //////////////////////////////

            //Left Boarder
            // Upper

            //Left Boarder

            /*
            g2d.draw(new Line2D.Double( (double)x , (double)y
                    , (double)x + 20, (double)y ));

             */

            // Right Border

            /*
            g2d.draw(new Line2D.Double( (double)width , (double)y
                    , (double)width - 20, (double)y ));

             */
            // Lower Border

            /*
            g2d.draw(new Line2D.Double( (double)x , (double)height
                    , (double)x , (double)height - 20));

             */
            // Lower Right Border
            /*
            g2d.draw(new Line2D.Double( (double)width , (double)height
                    , (double)width - 20, (double)height ));
            g2d.draw(new Line2D.Double( (double)width , (double)height
                    , (double)width , (double)height - 20));

             */
        }
    }
    @Override
    public Insets getBorderInsets(Component c)
    {
        return (getBorderInsets(c, new Insets(gap, gap, gap, gap)));
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets)
    {
        insets.left = insets.top = insets.right = insets.bottom = gap;
        return insets;
    }


    @Override
    public boolean isBorderOpaque()
    {
        return true;
    }

    private void drawBoarders(Graphics2D g2d, int x, int y,
                              int width, int height){
        boolean upper = this.matrixCell.getNeighbour(NeighbourType.NORTH).isPresent()
                ? !this.matrixCell.getNeighbour(NeighbourType.NORTH).get().isConnected()
                : true;
        boolean right = this.matrixCell.getNeighbour(NeighbourType.EAST).isPresent()
                ? !this.matrixCell.getNeighbour(NeighbourType.EAST).get().isConnected()
                : true;
        boolean bottom = this.matrixCell.getNeighbour(NeighbourType.SOUTH).isPresent()
                ? !this.matrixCell.getNeighbour(NeighbourType.SOUTH).get().isConnected()
                : true;
        boolean left = this.matrixCell.getNeighbour(NeighbourType.WEST).isPresent()
                ? !this.matrixCell.getNeighbour(NeighbourType.WEST).get().isConnected()
                : true;

        if (upper){
            g2d.draw(new Line2D.Double((double)x , (double)y
                    , (double)x + width, (double)y ));
        }
        if (right){
            g2d.draw(new Line2D.Double( (double)x , (double)height
                    , (double)x + width, (double)height ));
        }
        if (bottom){
            g2d.draw(new Line2D.Double( (double)width , (double)y
                    , (double)width , (double)y + height));
        }
        if (left){
            g2d.draw(new Line2D.Double((double)x , (double)y
                    , (double)x , (double)y + height));        }
    }
}
