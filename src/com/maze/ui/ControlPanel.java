package com.maze.ui;

import com.maze.ai.MazeGeneratorManager;
import com.maze.ai.algorithm.IMazeGenerationAlg;
import com.maze.ai.algorithm.growingtree.GrowingTreeMazeGenerationAlg;
import com.maze.entities.Maze;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;


import javafx.application.Platform;
import javafx.stage.FileChooser;

public class ControlPanel extends JPanel {
    private MainFrame mainFrame;
    private MazeGeneratorManager mazeManager;
    private IMazeGenerationAlg algorithm = new GrowingTreeMazeGenerationAlg(
            new Random(LocalDateTime.now().getSecond())
    );

    JTextField rowsTxt;
    JTextField columnsTxt;

    private JLabel errorLabel;

    public ControlPanel(MainFrame mainframe){
        this.mainFrame = mainframe;
        this.mazeManager = new MazeGeneratorManager(algorithm, mainFrame);

        this.init();
    }

    public void init(){
        this.setLayout(new BorderLayout());

        //this.setBackground(Color.BLACK);
        errorLabel = new JLabel();
        errorLabel.setForeground(Color.RED);
        errorLabel.setVisible(false);

        JButton runBtn = new JButton("Run");

        runBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    errorLabel.setVisible(false);
                    Thread mazeManagerThread = new Thread(mazeManager);
                    mazeManagerThread.run();

                    //mazeManager.run();

                    // mainFrame.redrawMazePanel();
                } catch (Exception exception) {
                    exception.printStackTrace();
                    errorLabel.setText(exception.getMessage());
                    errorLabel.setVisible(true);
                }

            }
        });

        this.add(errorLabel, BorderLayout.NORTH);
        this.add(runBtn, BorderLayout.SOUTH);

        //Matrix Creation
        GridLayout gridLayout = new GridLayout(3,2);
        JPanel matrixCreationPanel = new JPanel();
        matrixCreationPanel.setLayout(gridLayout);

        //Rows
        JPanel matrixCreationPanelRows = new JPanel();
        gridLayout = new GridLayout(0,2);
        matrixCreationPanelRows.setLayout(gridLayout);

        JLabel rowsLbl = new JLabel("Rows:");
        matrixCreationPanelRows.add(rowsLbl);
        rowsTxt = new JTextField();
        rowsTxt.setText("" + mainFrame.getMainMaze().getRows());

        matrixCreationPanelRows.add(rowsTxt);
        matrixCreationPanel.add(matrixCreationPanelRows);

        //Columns
        JPanel matrixCreationPanelColumns = new JPanel();
        matrixCreationPanelColumns.setLayout(gridLayout);

        JLabel columnsLbl = new JLabel("Columns:");
        matrixCreationPanelColumns.add(columnsLbl);
        columnsTxt = new JTextField();
        columnsTxt.setText("" + mainFrame.getMainMaze().getColumns());
        matrixCreationPanelColumns.add(columnsTxt);
        matrixCreationPanel.add(matrixCreationPanelColumns);


        JButton createMatrixBtn = new JButton("Create");
        createMatrixBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String rowsString = rowsTxt.getText();
                    String columnsString  = columnsTxt.getText();

                    int rows = Integer.parseInt(rowsString);
                    int columns = Integer.parseInt(columnsString);

                    Maze newMaze = new Maze(rows, columns);
                    mainFrame.setMainMaze(newMaze);
                } catch (Exception exception) {
                    exception.printStackTrace();
                    errorLabel.setText(exception.getMessage());
                    errorLabel.setVisible(true);
                }
            }
        });

        matrixCreationPanel.add(createMatrixBtn);

        JButton exportMazeBtn = new JButton("Export");
        exportMazeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MazePanel mazePanel = mainFrame.getMazePanel();
                BufferedImage image = new BufferedImage(mazePanel.getWidth(), mazePanel.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g = image.createGraphics();
                //this.paint(g);
                mazePanel.printAll(g);
                g.dispose();

                try {
                    ImageIO.write(image, "png", new File("d:/test.png"));
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

                FileChooser fileChooser = new FileChooser();

                //Set extension filter for text files
                FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("PNG files (*.[png])", "*.png");
                fileChooser.setTitle("Save");
                fileChooser.getExtensionFilters().add(extFilter);

                //Show save file dialog
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        File file = fileChooser.showSaveDialog(mainFrame.primaryStage);

                        if (file != null) {
                            try {
                                ImageIO.write(image, "PNG", file);
                            } catch (IOException ioException) {
                                ioException.printStackTrace();
                            }
                        }
                    }
                });
            }
        });

        matrixCreationPanel.add(exportMazeBtn);
        this.add(matrixCreationPanel, BorderLayout.CENTER);
    }
}
