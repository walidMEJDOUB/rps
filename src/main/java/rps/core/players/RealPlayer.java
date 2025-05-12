package rps.core.players;

import rps.core.choice.Choice;
import rps.core.choice.ChoiceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;


public class RealPlayer extends Player {
    private static final Logger logger = LoggerFactory.getLogger(RealPlayer.class);
    private static final String YES = "Y";


    public Choice makeMove() {
        ChoiceFactory choiceFactory = new ChoiceFactory();
        String personChoice = null;
        Scanner scan = new Scanner(System.in);
        while (personChoice == null || (!(Choice.ROCK.label.equalsIgnoreCase(personChoice))
                && !(Choice.PAPER.label.equalsIgnoreCase(personChoice)) && !(Choice.SCISSORS.label.equalsIgnoreCase(personChoice)))) {
            logger.info("Enter your Choice: (1)ROCK , (2)PAPER  , (3)SCISSORS");
            personChoice = scan.next();
        }
        return choiceFactory.makeChoice(personChoice.toUpperCase());
    }

    @Override
    public String toString() {
        return "RealPlayer []" + this.getScore();
    }

    /**
     * Play Again input
     */
    public boolean playAgain(int currentGame) {
        Scanner scan = new Scanner(System.in);
        logger.info("Play Again? Yes(Y) | No(N) ");
        if ((YES).equalsIgnoreCase(scan.nextLine())) {
            logger.info("You are playing game number {}", ++currentGame);
            return true;
        } else {
            return false;
        }
    }
}
