package com.maze.ai.algorithm.growingtree;

import com.maze.ai.algorithm.IMazeGenerationAlg;
import com.maze.entities.Cell;
import com.maze.entities.CellStatus;
import com.maze.entities.Maze;
import com.maze.entities.Neighbour;

import java.util.*;

public class GrowingTreeMazeGenerationAlg implements IMazeGenerationAlg {
    private Queue<Cell> cellQueue;
    private Maze maze = null;

    public GrowingTreeMazeGenerationAlg(){
        this.cellQueue = new LinkedList<>();
    }

    @Override
    public void prepareAlgorithm(Maze maze) {
        this.maze = maze;
        this.cellQueue = new LinkedList<Cell>();

        Random rand = new Random(); //instance of random class

        int maxJ = maze.getColumns();
        int randJ = rand.nextInt(maxJ);

        int maxI = maze.getRows();
        int randI = rand.nextInt(maxI);

        Cell startingCell = maze.getCell(randI, randJ);
        startingCell.setStatus(CellStatus.LIVE);
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
            topCell.setStatus(CellStatus.KICKED);
            cellQueue.poll();

            return maze;
        }

        Random rand = new Random(); //instance of random class

        var randNeighbour = unvisitedNeighbours.get(rand.nextInt(unvisitedNeighbours.size()));

        randNeighbour.getNeighbour().setStatus(CellStatus.LIVE);
        randNeighbour.setConnected(true);
        this.cellQueue.add(randNeighbour.getNeighbour());

        return maze;
    }
}
