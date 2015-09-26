package in.ashwanthkumar.tictactoe.core;

import in.ashwanthkumar.utils.lang.tuple.Tuple2;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void shouldTestAvailableMovesInGame() {
        Game game = new Game(3, 3);
        game.doHisMove("0|0");
        game.doHisMove("0|1");
        game.doHisMove("0|2");
        game.doHisMove("1|0");
        game.doHisMove("1|1");
        game.doHisMove("1|2");
        List<Tuple2<Integer, Integer>> availableMoves = game.availableMoves();
        assertThat(availableMoves.size(), is(3));
        assertThat(availableMoves, hasItem(new Tuple2<Integer, Integer>(2, 0)));
        assertThat(availableMoves, hasItem(new Tuple2<Integer, Integer>(2, 1)));
        assertThat(availableMoves, hasItem(new Tuple2<Integer, Integer>(2, 2)));
    }



}