package com.maze.ui;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    private MainFrame mainFrame;

    public ControlPanel(MainFrame mainframe){
        this.mainFrame = mainframe;
    }

    public void init(){
        this.setBackground(Color.BLACK);

    }
}
