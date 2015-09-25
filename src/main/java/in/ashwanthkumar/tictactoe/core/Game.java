package in.ashwanthkumar.tictactoe.core;

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
}
