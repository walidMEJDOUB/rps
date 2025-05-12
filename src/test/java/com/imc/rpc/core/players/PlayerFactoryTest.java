package com.imc.rpc.core.players;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class PlayerFactoryTest {
    private final PlayerFactory playerFactory = new PlayerFactory();

    @Test
    void getPlayer() {
        playerFactory.getPlayer("REAL");
        Assertions.assertNotNull(playerFactory.getPlayer("real"));
        Assertions.assertTrue(playerFactory.getPlayer("real") instanceof RealPlayer);
        Assertions.assertTrue(playerFactory.getPlayer("COMPUTER") instanceof ComputerPlayer);
    }
}