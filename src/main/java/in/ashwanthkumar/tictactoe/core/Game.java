package in.ashwanthkumar.tictactoe.core;

import in.ashwanthkumar.utils.collections.Maps;

import java.util.Map;

public class Game {
    Board board;
    BoardValidator validator;
    int marks;

    public Game(int gridSize, int numberOfMarks) {
        board = new Board(gridSize);
        this.marks = numberOfMarks;
        validator = new BoardValidator(this.board, this.marks);
    }

    public Board getBoard() {
        return board;
    }

    public int getMarks() {
        return marks;
    }

    public String whoWon() {
        if(validator.hasPlayer1Won()) return "player1";
        else if(validator.hasPlayer2Won()) return "player2";
        else return "none";
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

    public void opponentMove(String input) {
        String[] parts = input.split("\\|");
        int x = Integer.valueOf(parts[0]);
        int y = Integer.valueOf(parts[1]);

        board.placeHisMove(x, y);
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
