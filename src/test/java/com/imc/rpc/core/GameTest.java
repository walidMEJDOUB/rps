package com.imc.rpc.core;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import com.imc.rpc.core.choice.Choice;
import com.imc.rpc.core.players.Player;
import com.imc.rpc.core.players.PlayerFactory;

class GameTest {

    @Mock
    private PlayerFactory playerFactory;
    @Mock
    private Player human;
    @Mock
    private Player computer;
    @Mock
    private Game game;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(playerFactory.getPlayer("COMPUTER")).thenReturn(computer);
        when(playerFactory.getPlayer("REAL")).thenReturn(human);
        Game.preparePlayers(playerFactory);
    }

    @Test
    void should_testPreparePlayers() {
        assertNotNull(human);
        assertNotNull(computer);
    }

    @Test
    void should_test_HumanWinsRound() {
        when(human.makeMove()).thenReturn(Choice.SCISSORS);
        when(computer.makeMove()).thenReturn(Choice.ROCK);
        Game.startGame();
        when(human.getScore()).thenReturn(1);
        assertTrue(human.getScore() > computer.getScore());
    }

    @Test
    void should_test_ComputerWinsRound() {
        when(human.makeMove()).thenReturn(Choice.SCISSORS);
        when(computer.makeMove()).thenReturn(Choice.ROCK);
        Game.startGame();
        when(computer.getScore()).thenReturn(1);
        assertTrue(computer.getScore() > human.getScore());
    }

    @Test
    void should_test_GameDraw() {
        when(human.makeMove()).thenReturn(Choice.PAPER);
        when(computer.makeMove()).thenReturn(Choice.PAPER);
        Game.startGame();
        assertEquals(human.getScore(), computer.getScore());
    }

    @Test
    void should_test_DetermineWinner() {
        when(human.makeMove()).thenReturn(Choice.PAPER);
        when(computer.makeMove()).thenReturn(Choice.PAPER);
        when(human.getScore()).thenReturn(3);
        when(computer.getScore()).thenReturn(2);
        Game.startGame();
        assertTrue(human.getScore() > computer.getScore());
    }

}
