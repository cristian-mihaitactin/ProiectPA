package com.maze.ui;

import com.maze.entities.Cell;
import com.maze.entities.Maze;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {
    private Maze maze;
    private MainFrame mainFrame;

    public MazePanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        //var cellPanel = new CellPanel(new Cell());



        init();
    }

    private void init(){
        this.setBackground(Color.white);
        this.setLayout(new GridBagLayout());
    }

    private void processMaze(){
        for (int i = 0; i < maze.getRows(); i++){
            for ( int j = 0; j < maze.getColumns(); j++){
                if(j == maze.getColumns() - 1){
                    int ttt = 0;
                }
                var cellPanel = new CellPanel(maze.getCell(i,j));
                addCellPanel(cellPanel, i, j);
            }
        }

        this.revalidate();
    }

    private void addCellPanel(CellPanel cpanel, int i, int j){
        GridBagConstraints c = new GridBagConstraints();

        c.fill = GridBagConstraints.HORIZONTAL;
        // 	c.anchor = GridBagConstraints.PAGE_END; //bottom of space

        c.gridy = i;
        c.gridx = j;

        this.add(cpanel, c);
    }

    public void setMaze(Maze maze){
        this.maze = maze;
        processMaze();
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
