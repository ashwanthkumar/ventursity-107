package in.ashwanthkumar.tictactoe;

public class Board {
    public static final char ME = 'X';
    public static final char HIM = 'O';

    char[][] board;
    int size;
    int movesSoFar = 0;

    public Board(int size) {
        this.size = size;
        board = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                board[row][column] = '\0';
            }
        }
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

    protected void checkIfSpotTaken(int x, int y) {
        if (x >= size || y >= size) throw new RuntimeException("Out of board position");
        else if (board[x][y] != '\0') throw new RuntimeException("Spot already taken");
    }
}
