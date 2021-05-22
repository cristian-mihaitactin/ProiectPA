package com.maze.ui;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends JPanel {
    private MainFrame mainFrame;
    public MazePanel(MainFrame mainFrame){
        this.mainFrame = mainFrame;

        init();

        var cellPanel = new CellPanel();
        this.add(cellPanel);
    }

    private void init(){
        this.setBackground(Color.white);
    }


}
