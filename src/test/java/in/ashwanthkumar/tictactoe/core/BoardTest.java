package in.ashwanthkumar.tictactoe.core;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardTest {

    @Test
    public void shouldPlaceMyMoveCorrectlyWithX() {
        Board board = new Board(3);
        board.placeMyMove(1, 2);
        assertThat(board.getPosition(1, 2), is('X'));
    }

    @Test
    public void shouldPlaceHisMoveCorrectlyWithO() {
        Board board = new Board(3);
        board.placeHisMove(1, 1);
        assertThat(board.getPosition(1, 1), is('O'));
    }

    @Test(expected = RuntimeException.class)
    public void shouldFailIfPlaceIsAlreadyTaken() {
        Board board = new Board(3);
        board.placeMyMove(1, 1);
        board.placeHisMove(1, 1);
    }

    @Test(expected = RuntimeException.class)
    public void shouldFailIfPositionIsBiggerThanGrid() {
        Board board = new Board(3);
        board.placeHisMove(4, 1);
    }

    @Test
    public void shouldCheckIfBoardIsFull() {
        Board board = new Board(3);
        board.placeHisMove(0, 0);
        board.placeHisMove(1, 0);
        board.placeHisMove(2, 0);
        board.placeHisMove(0, 1);
        board.placeHisMove(1, 1);
        board.placeHisMove(2, 1);

        assertThat(board.isFull(), is(false));

        board.placeHisMove(0, 2);
        board.placeHisMove(1, 2);
        board.placeHisMove(2, 2);

        assertThat(board.isFull(), is(true));
    }

    @Test
    public void shouldTestDeepCopy() {
        Board board = new Board(3);
        board.placeHisMove(1, 0).placeMyMove(1, 2);
        Board clone = board.deepCopy();
        assertThat(board, is(clone));
    }

}