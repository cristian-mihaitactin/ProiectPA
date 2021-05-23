package com.maze.ui;

import com.maze.entities.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MainFrame extends JFrame /*implements Runnable*/ {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    private MazePanel mazePanel;
    private ControlPanel controlPanel;
    private Maze mainMaze;

    public MainFrame(){
        super("Maze Generator");

        //TODO: move maze generation to ControlPanel
        this.mainMaze = new Maze(6, 5);


        mazePanel = new MazePanel(this);
        controlPanel = new ControlPanel(this);

        //Create and set up the window.
        init();

        //Maze testMaze = new Maze(5, 6);

        mazePanel.setMaze(mainMaze);
    }

    private void init() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = this.getContentPane();

        pane.setLayout(new BorderLayout());

        // mazePanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JPanel containerPanel = new JPanel();
        containerPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        containerPanel.setLayout(new BorderLayout());
        //panel to test
        // mazePanel.setPreferredSize(new Dimension(200, 100));

        containerPanel.add(mazePanel,BorderLayout.CENTER);


        pane.add(containerPanel, BorderLayout.CENTER);


        controlPanel.setPreferredSize(new Dimension(100, 100));

        containerPanel.add(controlPanel, BorderLayout.LINE_END);
    }

    public void createAndShowFrame(){
        //Set up the content pane.
        //Display the window.
        this.setPreferredSize(new Dimension(1000, 800));
        this.pack();
        this.setVisible(true);
    }

    public Maze getMainMaze() {
        return this.mainMaze;
    }

    public void setMainMaze(Maze mainMaze) {
        this.mainMaze = mainMaze;
    }

    public void redrawMazePanel() {
        this.mazePanel.processMaze(mainMaze);
    }
}
