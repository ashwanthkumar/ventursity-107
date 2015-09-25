package in.ashwanthkumar.tictactoe.player;

import in.ashwanthkumar.tictactoe.core.Game;

public class PlayerFactory {
    public static Player create(String name, Game game) {
        Player player;
        if (name.equalsIgnoreCase(RandomPlayer.NAME)) player = new RandomPlayer();
        else {
            throw new RuntimeException("Invalid player type specified - " + name);
        }

        player.init(game);
        return player;
    }
}
