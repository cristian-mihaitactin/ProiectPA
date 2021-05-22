package com.maze.ui;

import com.maze.entities.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class MainFrame extends JFrame {

    final static boolean shouldFill = true;
    final static boolean shouldWeightX = true;
    final static boolean RIGHT_TO_LEFT = false;

    private MazePanel mazePanel;
    private ControlPanel controlPanel;

    public MainFrame(){
        super("Maze Generator");

        mazePanel = new MazePanel(this);
        controlPanel = new ControlPanel(this);

        //Create and set up the window.
        init();

        //Maze testMaze = new Maze(10, 20);
        Maze testMaze = new Maze(5, 6);

        mazePanel.setMaze(testMaze);
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

        pane.add(controlPanel, BorderLayout.LINE_END);

        /*
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
            //natural height, maximum width
            c.fill = GridBagConstraints.VERTICAL;
        }

        
        if (shouldWeightX) {
            c.weighty = 1.0;   //request any extra vertical space
            c.weightx = 1.0;
        }
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        pane.add(mazePanel, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weighty = 1.0;   //request any extra vertical space
        c.weightx = 1.0;
        c.gridx = 1;
        c.gridy = 0;
        pane.add(controlPanel, c);
*/


/*
        button = new JButton("Long-Named Button 4");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 40;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;

        pane.add(button, c);

        button = new JButton("5");
        //c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10,0,0,0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        pane.add(button, c);

 */


    }

    public void createAndShowFrame(){


        //Set up the content pane.

        //Display the window.
        this.setPreferredSize(new Dimension(1000, 800));

        this.pack();
        this.setVisible(true);


    }
/*
    @Override
    public void paint(Graphics g) {
        Graphics2D graphic2d = (Graphics2D) g;
        graphic2d.setColor(Color.BLUE);

        graphic2d.setStroke(new BasicStroke(10));
        //graphic2d.fillRect(100, 50, 60, 80);
        Line2D lin = new Line2D.Float();//new Line2D.Float(100, 100, 250, 260);
        Point2D pointA = new Point2D.Float(0, 0);
        Point2D pointB = new Point2D.Float(250,260);
        lin.setLine(pointA, pointB);

        graphic2d.draw(lin);
    }
    */
/*
    public static void main(String[] args) {
        JFrame frame = new JFrame("Demo");
        frame.add(new MainFrame());
        frame.setSize(1000, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

 */


}
