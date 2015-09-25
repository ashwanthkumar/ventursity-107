package in.ashwanthkumar.tictactoe.core;

import java.util.Arrays;

public class Board {
    public static final char ME = 'X';
    public static final char HIM = 'O';
    public static final char EMPTY = '\0';

    char[][] board;
    int size;
    int movesSoFar = 0;

    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                board[row][column] = EMPTY;
            }
        }
    }

    // copy constructor
    public Board(Board board) {
        this.size = board.getSize();
        this.board = new char[size][size];
        this.movesSoFar = board.movesSoFar;
        System.arraycopy(board.board, 0, this.board, 0, board.getSize());
    }

    public Board placeMyMove(int x, int y) {
        checkIfSpotTaken(x, y);
        board[x][y] = ME;
        movesSoFar++;
        return this;
    }

    public Board placeHisMove(int x, int y) {
        checkIfSpotTaken(x, y);
        board[x][y] = HIM;
        movesSoFar++;
        return this;
    }

    public char getPosition(int x, int y) {
        return board[x][y];
    }

    public boolean isFull() {
        return movesSoFar >= size * size;
    }

    public int getSize() {
        return size;
    }

    public Board deepCopy() {
        return new Board(this);
    }

    protected void checkIfSpotTaken(int x, int y) {
        if (x >= size || y >= size) throw new RuntimeException("Out of board position");
        else if (board[x][y] != '\0') throw new RuntimeException("Spot already taken");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board1 = (Board) o;

        if (size != board1.size) return false;
        if (movesSoFar != board1.movesSoFar) return false;
        return Arrays.deepEquals(board, board1.board);

    }

    @Override
    public int hashCode() {
        int result = board != null ? Arrays.deepHashCode(board) : 0;
        result = 31 * result + size;
        result = 31 * result + movesSoFar;
        return result;
    }
}
