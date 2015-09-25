package in.ashwanthkumar.tictactoe.player;

import in.ashwanthkumar.tictactoe.core.Game;
import in.ashwanthkumar.utils.lang.tuple.Tuple2;

public interface Player {
    void init(final Game game);

    String getName();

    Tuple2<Integer, Integer> nextMove();
}
