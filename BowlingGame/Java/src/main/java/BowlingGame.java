/**
 * Created by matt on 9/20/14.
 */
public class BowlingGame {

    private int NUM_FRAMES = 10;
    private int NUM_ROLLS_PER_FRAME = 2;
    private int POSSIBLE_EXTRA_ROLL_IN_LAST_FRAME = 1;
    private int MAX_NUM_ROLLS_POSSIBLE = (NUM_FRAMES * NUM_ROLLS_PER_FRAME) + POSSIBLE_EXTRA_ROLL_IN_LAST_FRAME;
    private int currentRoll = 0;

    private int[] rolls = new int[MAX_NUM_ROLLS_POSSIBLE];

    public int getScore() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < NUM_FRAMES; frame++) {
            if (isStrike(rollIndex)) {
                score += getStrikeScore(rollIndex);
                rollIndex++;
            } else if (isSpare(rollIndex)) {
                score += getSpareScore(rollIndex);
                rollIndex += 2;
            } else {
                score += getFrameScore(rollIndex);
                rollIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private int getStrikeScore(int rollIndex) {
        return 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private int getSpareScore(int rollIndex) {
        return 10 + rolls[rollIndex + 2];
    }

    private int getFrameScore(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }

    private int spareBonus(int rollIndex) {
        return rolls[rollIndex + 2];
    }

    private boolean isSpare(int rollIndex) {
        return getFrameScore(rollIndex) == 10;
    }

    public void roll(int numPins) {
        rolls[currentRoll] = numPins;
        currentRoll++;
    }
}
