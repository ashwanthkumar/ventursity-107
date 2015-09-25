package in.ashwanthkumar.tictactoe.core;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class BoardValidatorTest {

    @Test
    public void shouldCheckIfIWonViaRow() {
        Board board = new Board(3);
        /*
             ------- ------- -------       
            |       |       |       |
             ------- ------- -------
            |   O   |   O   |       |
             ------- ------- -------
            |   X   |   X   |   X   |
             ------- ------- -------

             X has won via Row 0
         */
        board.placeMyMove(0, 0);
        board.placeHisMove(1, 0);
        board.placeMyMove(0, 1);
        board.placeHisMove(1, 1);
        board.placeMyMove(0, 2);

        BoardValidator validator = new BoardValidator(board, 3);
        assertThat(validator.hasPlayer1Won(), is(true));
        assertThat(validator.hasPlayer2Won(), is(false));
    }

    @Test
    public void shouldCheckIfIWonViaColumn() {
        /*
             ------- ------- -------
            |   X   |   O   |   O  |
             ------- ------- -------
            |   X   |       |      |
             ------- ------- -------
            |   X   |       |      |
             ------- ------- -------

             X has won via Column 0
         */
        Board board = new Board(3);
        board.placeMyMove(0, 0);
        board.placeHisMove(2, 1);
        board.placeMyMove(1, 0);
        board.placeHisMove(2, 2);
        board.placeMyMove(2, 0);

        BoardValidator validator = new BoardValidator(board, 3);
        assertThat(validator.hasPlayer1Won(), is(true));
        assertThat(validator.hasPlayer2Won(), is(false));
    }

    @Test
    public void shouldCheckIfIWonDiagonally() {
        /*
             ------- ------- -------
            |       |       |   X  |
             ------- ------- -------
            |       |   X   |   O  |
             ------- ------- -------
            |   X   |   O   |      |
             ------- ------- -------

             X has won diagonally
         */
        Board board = new Board(3);
        board.placeMyMove(0, 0);
        board.placeHisMove(0, 1);
        board.placeMyMove(1, 1);
        board.placeHisMove(1, 2);
        board.placeMyMove(2, 2);

        BoardValidator validator = new BoardValidator(board, 3);
        assertThat(validator.hasPlayer1Won(), is(true));
        assertThat(validator.hasPlayer2Won(), is(false));
    }

}