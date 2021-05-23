package com.maze.ui;

import com.maze.entities.Cell;
import com.maze.entities.CellStatus;
import com.maze.entities.Maze;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class MazePanel extends JPanel {
    private Maze maze;
    private MainFrame mainFrame;
    private List<CellPanel> cellPanelList = new LinkedList<CellPanel>();

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
        this.cellPanelList.add(cpanel);
    }

    public void redrawMaze(){
        for (CellPanel cellPanel
                : this.cellPanelList
             ) {
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

            cellPanel.paintComponent(this.getGraphics());
        }
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
