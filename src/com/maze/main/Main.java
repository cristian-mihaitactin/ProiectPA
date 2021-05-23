package com.maze.main;

import com.maze.entities.Maze;
import com.maze.ui.MainFrame;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        MainFrame mainFrame = new MainFrame(primaryStage);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                mainFrame.createAndShowFrame();
            }
        });

    }
}
