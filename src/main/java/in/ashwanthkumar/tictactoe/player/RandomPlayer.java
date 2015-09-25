package in.ashwanthkumar.tictactoe.player;

import in.ashwanthkumar.tictactoe.core.Board;
import in.ashwanthkumar.tictactoe.core.Game;
import in.ashwanthkumar.utils.lang.tuple.Tuple2;

/**
 * Player implementation that just marks X on the next empty slot on the board.
 * <p/>
 * Used for testing the other flows of the game.
 */
public class RandomPlayer implements Player {
    public static final String NAME = "RANDOM";
    Board board;

    @Override
    public void init(Game game) {
        this.board = game.getBoard();
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Tuple2<Integer, Integer> nextMove() {
        return pickNextEmptySlot();
    }

    protected Tuple2<Integer, Integer> pickNextEmptySlot() {
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                if (board.getPosition(row, column) == Board.EMPTY) return new Tuple2<Integer, Integer>(row, column);
            }
        }

        return new Tuple2<Integer, Integer>(-1, -1);
    }

}
