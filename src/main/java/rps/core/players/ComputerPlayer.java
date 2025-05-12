package rps.core.players;

import rps.core.choice.Choice;

import java.util.Random;

public class ComputerPlayer extends Player {
    final Random generator = new Random();

    ComputerPlayer() {
        super();
    }

    /**
     * Generates random moves for computer player
     */
    public Choice makeMove() {
        int computerInt = generator.nextInt(3) + 1;
        Choice computerChoice = null;
        if (computerInt == 1)
            computerChoice = Choice.ROCK;
        else if (computerInt == 2)
            computerChoice = Choice.PAPER;
        else computerChoice = Choice.SCISSORS;
        return computerChoice;
    }

    @Override
    public boolean playAgain(int gameCounter) {
        return false;
    }

    @Override
    public String toString() {
        return "Computer Player []" + this.getScore();
    }

}