package com.imc.rpc.core.choice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ChoiceFactoryTest {

    @Test
    void makeChoice()  {
        ChoiceFactory choiceFactory = new ChoiceFactory();
        Assertions.assertEquals(Choice.ROCK,choiceFactory.makeChoice("1"));
        Assertions.assertEquals(Choice.PAPER,choiceFactory.makeChoice("2"));
        Assertions.assertEquals(Choice.SCISSORS,choiceFactory.makeChoice("3"));
    }

}