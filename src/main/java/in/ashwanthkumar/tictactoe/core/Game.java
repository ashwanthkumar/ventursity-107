package in.ashwanthkumar.tictactoe.core;

import in.ashwanthkumar.utils.collections.Lists;
import in.ashwanthkumar.utils.collections.Maps;
import in.ashwanthkumar.utils.lang.tuple.Tuple2;

import java.util.List;
import java.util.Map;

public class Game {
    public static final int I_MOVED = 0;
    public static final int HE_MOVED = 1;
    Board board;
    final BoardValidator validator;
    int marks;

    // 0 - Represents me
    // 1 - Represents him
    int previousMove = 1;

    public Game(int gridSize, int numberOfMarks) {
        this.board = new Board(gridSize);
        this.marks = numberOfMarks;
        this.validator = new BoardValidator(this.board, this.marks);
    }

    // copy constructor
    public Game(Game game) {
        this.board = game.getBoard().deepCopy();
        this.marks = game.getMarks();
        this.validator = game.validator;
        this.previousMove = game.previousMove;
    }

    public Board getBoard() {
        return board;
    }

    public int getMarks() {
        return marks;
    }

    public String whoWon() {
        if (validator.hasPlayerWon()) return "player";
        else if (validator.hasOpponentWon()) return "opponent";
        else return "none";
    }

    public BoardValidator getValidator() {
        return validator;
    }

    public boolean isOver() {
        /**
         * We need to check for multiple conditions
         * 1. When the board is full
         * 2. When X player has won
         * 3. When O player has won
         */
        return validator.hasPlayerWon() ||
                validator.hasOpponentWon() ||
                board.isFull();
    }


    public List<Tuple2<Integer, Integer>> availableMoves() {
        List<Tuple2<Integer, Integer>> moves = Lists.Nil();
        for (int row = 0; row < board.getSize(); row++) {
            for (int column = 0; column < board.getSize(); column++) {
                if (board.getPosition(row, column) == Board.EMPTY) {
                    moves.add(new Tuple2<Integer, Integer>(row, column));
                }
            }
        }

        return moves;
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

    public Game deepCopy() {
        return new Game(this);
    }

    public void doMove(Tuple2<Integer, Integer> move) {
        if (previousMove == I_MOVED) {
            System.out.println("Doing his move - " + move);
            doHisMove(move);
        }
        else {
            System.out.println("Doing my move - " + move);
            doMyMove(move);
        }
    }

    public void doHisMove(String input) {
        String[] parts = input.split("\\|");

        doHisMove(new Tuple2<Integer, Integer>(
                Integer.valueOf(parts[0]),
                Integer.valueOf(parts[1])
        ));
    }

    public void doHisMove(Tuple2<Integer, Integer> move) {
        previousMove = HE_MOVED;
        int x = move._1();
        int y = move._2();
        board.placeHisMove(x, y);
    }

    public void doMyMove(Tuple2<Integer, Integer> move) {
        previousMove = I_MOVED;
        int x = move._1();
        int y = move._2();
        board.placeMyMove(x, y);
    }

    public int getPreviousMove() {
        return previousMove;
    }

    public void undoMove(Tuple2<Integer, Integer> lastMove) {
        board.remove(lastMove._1(), lastMove._2());
        previousMove = previousMove == I_MOVED ? HE_MOVED : I_MOVED;
    }
}
