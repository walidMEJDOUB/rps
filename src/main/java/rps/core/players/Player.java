package rps.core.players;

import rps.core.choice.Choice;

public abstract class Player {

    private int score = 0;

    /**
     * Allows Player to make Choices
     */
    public abstract Choice makeMove();
    public abstract boolean playAgain(int gameCounter);

    public int getScore() {
        return score;
    }

    /**
     * Increments Player score
     */
    public void setScore(int score) {
        this.score = this.score + score;
    }

}