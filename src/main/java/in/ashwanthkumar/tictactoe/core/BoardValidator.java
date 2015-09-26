package in.ashwanthkumar.tictactoe.core;

public class BoardValidator {
    enum TraverseMode {
        ROW, COLUMN
    }

    final Board board;
    int marks;

    public BoardValidator(Board board, int marks) {
        this.board = board;
        this.marks = marks;
    }

    public boolean hasPlayerWon() {
        return haveWon(Board.ME);
    }

    public boolean hasOpponentWon() {
        return haveWon(Board.OPPONENT);
    }

    private boolean haveWon(char whom) {
        /**
         * For `whom` to win, we need to check
         * - if `whom` is present k times on a row (or)
         * - if `whom` is present k times on a column (or)
         * - if `whom` is present k times on a diagonal
         */
        return wonViaRowOrColumn(whom, TraverseMode.ROW) ||
                wonViaRowOrColumn(whom, TraverseMode.COLUMN) ||
                wonViaDiagonal(whom);
    }

    private boolean wonViaRowOrColumn(char whom, TraverseMode withMode) {
        for (int row = 0; row < board.getSize(); row++) {
            int count = 0;
            for (int column = 0; column < board.getSize(); column++) {
                /**
                 * NB: We don't reset the count because the problem statement only says
                 * "The first player to get k of their marks in a row, column or diagonal where 3<=k<=n wins the game (user defined)"
                 *
                 * It says first player to get k marks and not first player to get k continous marks.
                 */
                if (pick(row, column, withMode) == whom) count++;
                // TODO - If we need to account for continous marks, enable the next line
                // else count = 0;
            }
            if (count >= marks) return true;
        }
        return false;
    }

    private boolean wonViaDiagonal(char whom) {
        int count = 0;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getPosition(i, i) == whom) count++;
            // TODO - If we need to account for continous marks, enable the next line
            // else count = 0;
        }
        return count >= marks;
    }

    private char pick(int row, int column, TraverseMode mode) {
        if (mode == TraverseMode.ROW) return board.getPosition(row, column);
        else if (mode == TraverseMode.COLUMN) return board.getPosition(column, row);
        else {
            throw new RuntimeException("Invalid TraverseMode specified - " + mode);
        }
    }

}
