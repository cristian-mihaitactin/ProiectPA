package com.maze.ai.algorithm.growingtree;

import com.maze.ai.algorithm.IMazeGenerationAlg;
import com.maze.entities.Cell;
import com.maze.entities.CellStatus;
import com.maze.entities.Maze;
import com.maze.entities.Neighbour;

import java.util.*;

public class GrowingTreeMazeGenerationAlg implements IMazeGenerationAlg {
    private Stack<Cell> cellQueue;
    private Maze maze = null;
    private Random randGen;

    public GrowingTreeMazeGenerationAlg(Random randomGenerator){
        this.randGen = randomGenerator;
    }

    public GrowingTreeMazeGenerationAlg(){
        this.cellQueue = new Stack<Cell>();
    }

    @Override
    public void prepareAlgorithm(Maze maze) {
        this.maze = maze;
        this.cellQueue = new Stack<>();

        Random rand = new Random(); //instance of random class

        int maxJ = maze.getColumns();
        int randJ = rand.nextInt(maxJ);

        int maxI = maze.getRows();
        int randI = rand.nextInt(maxI);

        Cell startingCell = maze.getCell(randI, randJ);
        startingCell.setStatus(CellStatus.FIRST);
        this.cellQueue.add(startingCell);
    }

    @Override
    public Maze applyNextStep() throws Exception {
        if (maze == null){
            throw new Exception("Algorithm not started. Apply the \"prepareAlgorithm(Maze maze)\" before trying to apply the next step.");
        }

        //Queue empty -> Maze complete
        if (this.cellQueue.isEmpty()){
            maze.markAsComplete();
            return maze;
        }

        Cell topCell = this.cellQueue.peek();

        List<Neighbour> unvisitedNeighbours = topCell.getUnvisitedNeighbour();

        // if there are no unvisited neighbours -> remove the cell from queue
        if(unvisitedNeighbours.isEmpty())
        {
            if (topCell.getStatus() != CellStatus.FIRST){
                topCell.setStatus(CellStatus.KICKED);
            }
            cellQueue.pop();

            return maze;
        }

        var randomPosition = randGen.nextInt(unvisitedNeighbours.size());
        var randNeighbour = unvisitedNeighbours.get(randomPosition);

        randNeighbour.getNeighbour().setStatus(CellStatus.LIVE);
        randNeighbour.setConnected(true);
        this.cellQueue.push(randNeighbour.getNeighbour());

        return maze;
    }
}
