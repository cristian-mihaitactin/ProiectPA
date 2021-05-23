package com.maze.ui;

import com.maze.entities.Cell;
import com.maze.entities.CellStatus;
import com.maze.entities.Maze;
import javafx.application.Platform;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MazePanel extends JPanel /*implements Runnable*/ {
    private Thread thread = null;

    private Maze maze;
    private MainFrame mainFrame;
    private List<CellPanel> cellPanelList = new LinkedList<CellPanel>();

    public MazePanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        init();
    }

    private void init(){
        this.setBackground(Color.white);
        this.setLayout(new GridBagLayout());
    }

    private void processMaze(Maze newMaze){
        this.removeAll();
        this.revalidate();
        this.repaint();

        for (int i = 0; i < newMaze.getRows(); i++){
            for ( int j = 0; j < newMaze.getColumns(); j++){
                var cellPanel = new CellPanel(newMaze.getCell(i,j), i, j);
                switch (cellPanel.getMatrixCell().getStatus()){
                    case UNVISITED:
                        cellPanel.setColor(Color.GREEN);
                        break;
                    case LIVE:
                        cellPanel.setColor(Color.RED);
                        break;
                    case KICKED:
                        cellPanel.setColor(Color.GRAY);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + cellPanel.getMatrixCell().getStatus());
                }

                addCellPanel(cellPanel, i, j);
            }
        }

        this.revalidate();
        this.repaint();
    }

    private void addCellPanel(CellPanel cpanel, int i, int j){
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        // 	c.anchor = GridBagConstraints.PAGE_END; //bottom of space

        c.gridy = i;
        c.gridx = j;

        this.add(cpanel, c);
        this.cellPanelList.add(cpanel);
    }

    public void setMaze(Maze maze){
        this.maze = maze;
        processMaze(maze);
    }
    public Maze getMaze() {
        return maze;
    }

    public MainFrame getMainFrame() {
        return mainFrame;
    }

    public void setMainFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }
}
