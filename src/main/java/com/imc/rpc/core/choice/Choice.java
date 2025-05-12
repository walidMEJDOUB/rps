package com.imc.rpc.core.choice;

import java.util.EnumMap;
import java.util.Map;

public enum Choice {

    ROCK("1"),
    PAPER("2"),
    SCISSORS("3");
    public final String label;
    Choice(String label) {
        this.label=label;
    }
    /**
     * Holds the moves a move beats
     */
    private static final Map<Choice, Choice> beats = new EnumMap<>(Choice.class);

    static {
        beats.put(ROCK, SCISSORS);
        beats.put(PAPER, ROCK);
        beats.put(SCISSORS, PAPER);
    }
    /**
     * Returns the move this move beats
     *
     * @param choice The current move
     * @return The move this move beats
     */
    public static Choice beats(final Choice choice) {
        return beats.get(choice);
    }

}