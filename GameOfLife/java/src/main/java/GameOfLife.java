/**
 * Created by matt on 9/22/14.
 */

public class GameOfLife {

    public static final int DEAD = 0;
    public static final int ALIVE = 1;

    public static int[][] update(int[][] grid) {
        int[][] result = new int[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int numAlive = getNumLivingNeighbors(grid, row, col);
                int currentCell = grid[row][col];
                if (currentCell == ALIVE) {
                    if (numAlive == 2 || numAlive == 3) {
                        result[row][col] = ALIVE;
                    }
                } else {
                    if (numAlive == 3) {
                        result[row][col] = ALIVE;
                    }
                }
            }
        }
        return result;
    }

    private static int getNumLivingNeighbors(int[][] grid, int row, int col) {
        int[] neighbors = getCellNeighbors(grid, row, col);
        int numAlive = 0;
        for (int neighbor : neighbors) {
            if (neighbor == ALIVE) numAlive++;
        }
        return numAlive;
    }

    private static int[] getCellNeighbors(int[][] grid, int row, int col) {
        int[] result = new int[4];
        if (row > 0 && grid[row-1][col] == ALIVE) {
            result[0] = ALIVE;
        }
        if (row < grid.length - 1 && grid[row+1][col] == ALIVE) {
            result[1] = ALIVE;
        }
        if (col > 0 && grid[row][col-1] == ALIVE) {
            result[2] = ALIVE;
        }
        if (col < grid[0].length - 1 && grid[row][col+1] == ALIVE) {
            result[3] = ALIVE;
        }
        return result;
    }
}
