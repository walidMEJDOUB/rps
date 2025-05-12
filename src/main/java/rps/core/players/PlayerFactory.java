package rps.core.players;

public class PlayerFactory {
    private static final String REAL = "REAL";
    private static final String COMPUTER = "COMPUTER";

    public Player getPlayer(String playerType) {

        if (REAL.equalsIgnoreCase(playerType)) {
            return new RealPlayer();
        } else if (COMPUTER.equalsIgnoreCase(playerType)) {
            return new ComputerPlayer();
        }
        return null;
    }
}