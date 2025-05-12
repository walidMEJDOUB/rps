package rps.core.players;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerPlayerTest {

    private final ComputerPlayer computerPlayer = new ComputerPlayer();

    @Test
    void should_Test_ComputerPlayer_MakeMove_IsnotNull() {
        //Arrange
        //Act
        //Assert
        Assertions.assertNotNull(computerPlayer.makeMove());
    }

    @Test
    void should_Test_getScore() {
        //Arrange
        //Act
        computerPlayer.setScore(5);
        //Assert
        Assertions.assertEquals(5, computerPlayer.getScore());
    }
}