package in.ashwanthkumar.tictactoe.util;

import in.ashwanthkumar.utils.collections.Lists;
import in.ashwanthkumar.utils.lang.tuple.Tuple2;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SorterTest {
    @Test
    public void shouldPickTheMaxValue() {
        Tuple2<Integer, Integer> maxWithIndex = Sorter.maxWithIndex(Lists.of(1, 2, 3, 4, 5), 0);
        assertThat(maxWithIndex, is(new Tuple2<Integer, Integer>(5, 4)));
    }

    @Test
    public void shouldPickTheMinValue() {
        Tuple2<Integer, Integer> minWithIndex = Sorter.minWithIndex(Lists.of(1, 2, 3, 4, 5), Integer.MAX_VALUE);
        assertThat(minWithIndex, is(new Tuple2<Integer, Integer>(1, 0)));
    }


}