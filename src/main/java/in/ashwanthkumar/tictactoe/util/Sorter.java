package in.ashwanthkumar.tictactoe.util;

import in.ashwanthkumar.utils.lang.tuple.Tuple2;

import java.util.List;

public class Sorter {
    public static <T extends Comparable<T>> Tuple2<T, Integer> maxWithIndex(List<T> values, T base) {
        T max = base;
        int maxIndex = 0;
        for (int index = 0; index < values.size(); index++) {
            T value = values.get(index);
            if (value.compareTo(max) > 0) {
                max = value;
                maxIndex = index;
            }
        }

        return new Tuple2<T, Integer>(max, maxIndex);
    }

    public static <T extends Comparable<T>> Tuple2<T, Integer> minWithIndex(List<T> values, T base) {
        T min = base;
        int minIndex = 0;
        for (int index = 0; index < values.size(); index++) {
            T value = values.get(index);
            if (value.compareTo(min) < 0) {
                min = value;
                minIndex = index;
            }
        }

        return new Tuple2<T, Integer>(min, minIndex);
    }
}
