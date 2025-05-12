package com.imc.rpc.core.choice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ChoiceTest {
    @Test
    void beats()  {
        Assertions.assertEquals(Choice.PAPER,Choice.beats(Choice.SCISSORS));
        Assertions.assertEquals(Choice.SCISSORS,Choice.beats(Choice.ROCK));
        Assertions.assertEquals(Choice.ROCK,Choice.beats(Choice.PAPER));
        Assertions.assertNotEquals(Choice.PAPER,Choice.beats(Choice.ROCK));
        Assertions.assertNotEquals(Choice.ROCK,Choice.beats(Choice.SCISSORS));
    }
}