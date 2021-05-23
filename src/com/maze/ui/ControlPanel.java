package com.maze.ui;

import com.maze.ai.MazeGeneratorManager;
import com.maze.ai.algorithm.IMazeGenerationAlg;
import com.maze.ai.algorithm.growingtree.GrowingTreeMazeGenerationAlg;
import com.maze.entities.Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    private MainFrame mainFrame;
    private MazeGeneratorManager mazeManager;
    private IMazeGenerationAlg algorithm = new GrowingTreeMazeGenerationAlg();

    private JLabel errorLabel;

    public ControlPanel(MainFrame mainframe){
        this.mainFrame = mainframe;
        this.mazeManager = new MazeGeneratorManager(algorithm,mainframe.getMainMaze());

        this.init();
    }

    public void init(){
        this.setLayout(new BorderLayout());

        this.setBackground(Color.BLACK);
        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        JButton runBtn = new JButton("Run");

        runBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    errorLabel.setVisible(false);
                    mazeManager.run();
                    mainFrame.redrawMazePanel();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    errorLabel.setText(exception.getMessage());
                    errorLabel.setVisible(true);
                }

                /*
                mainList.repaint();
                repaint();
                frame.repaint();

                 */
            }
        });

        this.add(errorLabel, BorderLayout.NORTH);
        this.add(runBtn, BorderLayout.SOUTH);
    }
}
