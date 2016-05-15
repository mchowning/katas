import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by matt on 9/22/14.
 */
public class GameOfLifeTest {

    @Test
    public void cellWithNoNeighborsDies() {
        int[][] start = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}};
        int[][] result = GameOfLife.update(start);
        Assert.assertEquals("cell with no neighbors should die", 0, result[1][1]);
    }

    @Test
    public void cellWithOnlyOneNeighborDies() {
        int[][] start = new int[][]{
                {0, 0, 0},
                {0, 1, 0},
                {0, 1, 0}};
        int[][] result = GameOfLife.update(start);
        Assert.assertEquals("cell with one neighbor should die", 0, result[1][1]);
        Assert.assertEquals("cell with one neighbor should die", 0, result[2][1]);
    }

    @Test
    public void cellWithFourNeighborsDies() {
        int[][] start = new int[][]{
                {0, 1, 0},
                {1, 1, 1},
                {0, 1, 0}};
        int[][] result = GameOfLife.update(start);
        Assert.assertEquals("cell with four neighbors should die", 0, result[1][1]);
    }

    @Test
    public void cellWithTwoNeighborsLives() {
        int[][] start = new int[][]{
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}};
        int[][] result = GameOfLife.update(start);
        Assert.assertEquals("cell with two neighbors should live", 1, result[1][1]);
        Assert.assertEquals("cell with two neighbors should live", 1, result[2][0]);
    }

    @Test
    public void cellWithThreeNeighborsLives() {
        int[][] start = new int[][]{
                {0, 0, 1},
                {1, 1, 1},
                {1, 1, 1}};
        int[][] result = GameOfLife.update(start);
        Assert.assertEquals("cell with three neighbors should live", 1, result[1][2]);
        Assert.assertEquals("cell with three neighbors should live", 1, result[1][1]);
        Assert.assertEquals("cell with three neighbors should live", 1, result[2][1]);
    }
}
