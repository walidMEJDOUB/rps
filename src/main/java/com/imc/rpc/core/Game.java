package com.imc.rpc.core;

import com.imc.rpc.core.choice.Choice;
import com.imc.rpc.core.players.Player;
import com.imc.rpc.core.players.PlayerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;

import java.util.Scanner;

/**
 * A class that represents a full game with a final score
 */
public class Game {
    private static final Logger logger = LoggerFactory.getLogger(Game.class);
    private static int currentGame = 1;
    private static Choice computerChoice;
    private static Choice humanChoice;
    private static Player human;
    private static Player computer;

    public static void preparePlayers(PlayerFactory playerFactory) {
        computer = playerFactory.getPlayer("COMPUTER");
        human = playerFactory.getPlayer("REAL");
    }

    /**
     * A full game start
     */
    public static void startGame() {
        boolean playAgain = true;
        while (playAgain) {
            prepareChoices();
            prepareGameoutCome();
            logger.info("Your Score:{}", human.getScore());
            logger.info("Computer Score:{}", computer.getScore());
            playAgain = human.playAgain(currentGame);
        }
        determineWinner();
    }

    /**
     * Prepares players choices
     */
    private static void prepareChoices() {
        simultaneousChoiceHuman(human);
        simultaneousChoiceComputer(computer);
    }

    /**
     * Determines the outcome of one game
     */
    private static void prepareGameoutCome() {
        if (Choice.beats(humanChoice).equals(computerChoice)) {
            human.setScore(1);
            logger.info("----->You Won ! {} beats {}", humanChoice, computerChoice);
        } else if (Choice.beats(computerChoice).equals(humanChoice)) {
            computer.setScore(1);
            logger.info("----->Computer Won ! {} beats {}", computerChoice, humanChoice);
        } else logger.info("----->It is a tie between {} and {}", humanChoice, computerChoice);
    }

    /**
     * Determines the winner of all games
     */
    private static void determineWinner() {
        logger.info("-->FINAL SCORE : Computer score :{}  Your score : :{}", computer.getScore(), human.getScore());
        // Winning player determination conditions
        if (computer.getScore() > human.getScore()) {
            logger.info("--------->Computer Won the Game !");
        } else if (computer.getScore() < human.getScore()) {
            logger.info("--------->You Won the Game ! ");
        } else {
            logger.info("--------->It's a tie ! ");
        }
    }
    // A method to choose to play again or not


    /**
     * Generates computer Choices
     */
    private static void simultaneousChoiceComputer(Player player) {
        try {
            logger.info("Computer is making Choices");
            computerChoice = player.makeMove();
            logger.info("Computer Chose {}", computerChoice);
        } catch (Exception e) {
            logger.error("Error while Making Choices{} ", e.getMessage());
        }
    }

    /**
     * Generates Human Choices
     */
    private static void simultaneousChoiceHuman(Player player) {
        try {
            humanChoice = player.makeMove();
            logger.info("You Chose {}", humanChoice);
        } catch (Exception e) {
            logger.error("Error while Making Choices{} ", e.getMessage());
        }
    }

    /**
     * Numbers of Games input
     */
    public static void main(String[] args) {
        SpringApplication.run(Game.class, args);
        PlayerFactory playerFactory = new PlayerFactory();
        preparePlayers(playerFactory);
        startGame();
    }

}
