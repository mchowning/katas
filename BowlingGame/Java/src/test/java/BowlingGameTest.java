import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BowlingGameTest {

    private BowlingGame game;

    @Before
    public void setUp() throws Exception {
        game = new BowlingGame();
    }

    @Test
    public void startScoreShouldBeZero() {
        assertEquals("starting score should be zero", 0, game.getScore());
    }

    @Test
    public void rollOneReturnsOne() {
        game.roll(1);
        assertEquals("knocking down a single pin should result in a score of 1", 1, game.getScore());
    }

    @Test
    public void rollAllOnes() {
        rollMany(1, 20);
        assertEquals("rolling all 1s should result in a score of 20", 20, game.getScore());
    }

    @Test
    public void rollAllTwos() {
        rollMany(2, 20);
        assertEquals("rolling all 2s should result in a score of 40", 40, game.getScore());
    }

    @Test
    public void rollOneSpare() {
        game.roll(3);
        game.roll(7);
        game.roll(5);
        game.roll(3);
        assertEquals("Rolling a spare (3-7, 5-3...) should result in a score of 23 (15+8)", 23, game.getScore());
    }

    @Test
    public void rollOneStrike() {
        game.roll(10);
        game.roll(3);
        game.roll(4);
        game.roll(9);
        assertEquals("Rolling one strike (10, 2-4, 9... should result in a score of 33", 33, game.getScore());
    }

    @Test
    public void rollAllStrikes() {
        rollMany(10, 21);
        assertEquals("Rolling all strikes should result in a score of 300", 300, game.getScore());
    }

    private void rollMany(int pins, int numTimes) {
        for (int i = 0; i < numTimes; i++) {
            game.roll(pins);
        }
    }
}