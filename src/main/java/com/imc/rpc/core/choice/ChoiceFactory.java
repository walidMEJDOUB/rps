package com.imc.rpc.core.choice;

import java.util.HashMap;
import java.util.Map;

import static com.imc.rpc.core.choice.Choice.*;

public class ChoiceFactory {
    private static final Map<String, Choice> CHOICE_ENTRY_MAP = new HashMap<>();

    static {
        CHOICE_ENTRY_MAP.put("1", ROCK);
        CHOICE_ENTRY_MAP.put("2", PAPER);
        CHOICE_ENTRY_MAP.put("3", SCISSORS);
    }

    /**
     * Generates Choice from string input
     */
    public Choice makeChoice(String choice) {
        return CHOICE_ENTRY_MAP.get(choice);
    }
}