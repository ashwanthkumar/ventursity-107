package in.ashwanthkumar.tictactoe.core;

import in.ashwanthkumar.utils.collections.Maps;

import java.util.Map;

public class Game {
    Board board;
    BoardValidator validator;

    public Game(int gridSize, int numberOfMarks) {
        board = new Board(gridSize);
        validator = new BoardValidator(board, numberOfMarks);
    }

    public boolean isOver() {
        /**
         * We need to check for multiple conditions
         * 1. When the board is full
         * 2. When X player has won
         * 3. When O player has won
         */
        return validator.hasPlayer1Won() ||
                validator.hasPlayer2Won() ||
                board.isFull();
    }

    public Map<String, Map<String, String>> prettyPrint() {
        Maps.MapBuilder<String, Map<String, String>> builder = Maps.builder();
        for (int row = 0; row < board.getSize(); row++) {
            Maps.MapBuilder<String, String> rowBuilder = Maps.builder();
            for (int column = 0; column < board.getSize(); column++) {
                rowBuilder.put("C" + column, String.valueOf(board.getPosition(row, column)));
            }
            builder.put("R" + row, rowBuilder.value());

        }

        return builder.value();
    }
}
