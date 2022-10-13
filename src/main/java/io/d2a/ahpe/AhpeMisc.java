package io.d2a.ahpe;

import java.awt.*;
import java.util.Comparator;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class AhpeMisc {

    private static final Random random = new Random();

    /**
     * Checks if b is between a and b (inclusive)
     * @param a value a
     * @param b value b
     * @param c value c
     * @return true if b is between a and c (inclusive)
     */
    public static boolean between(final int a, final int b, final int c) {
        return a <= b && b <= c;
    }

    /**
     * Checks if b is between a and b (exclusive)
     * @param a value a
     * @param b value b
     * @param c value c
     * @return true if b is between a and c (exclusive)
     */
    public static boolean betweenEx(final int a, final int b, final int c) {
        return a < b && b < c;
    }

    /**
     * ROT13-Encodes a string
     * @param message string
     * @return rot13-encoded string
     */
    public static String rot13(final String message) {
        final StringBuilder builder = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (!between('A', c, 'z') || betweenEx('Z', c, 'a')) {
                builder.append(c);
            } else if (between('A', c, 'M') || between('a', c, 'm')) {
                // "Alle Zeichen von A-M und a-m werden durch das Zeichen 13 Buchstaben später im Alphabet ersetzt."
                builder.append((char) (c + 13));
            } else {
                // "Alle Zeichen von N-Z und n-z wird das Zeichen 13 Buchstaben früher im Alphabet ersetzt."
                builder.append((char) (c - 13));
            }
        }
        return builder.toString();
    }

    /**
     * Generates a random color
     *
     * @param max value value to choose from (r, g, b)
     * @return random color
     */
    public static Color randomColor(final int max) {
        return new Color(random.nextInt(max + 1), random.nextInt(max + 1), random.nextInt(max + 1));
    }

    /**
     * Generates a random color
     *
     * @return random color
     */
    public static Color randomColor() {
        return randomColor(200);
    }

    /**
     * Generates a random number between {between} (min) and {and} (max)
     *
     * @param between min
     * @param and     max
     * @return random number between min and max
     */
    public static int randomNumber(final int between, final int and) {
        return random.nextInt(and + 1 - between) + between;
    }

    /**
     * Returns a random entry from the given array
     *
     * @param array array to choose an entry from
     * @param <T>   type of array
     * @return random entry from array
     */
    public static <T> T randomArray(final T[] array) {
        if (array.length == 0) {
            return null;
        }
        return array[random.nextInt(array.length)];
    }

    /**
     * Returns the min value from multiple values
     * @param comparator comparator for values
     * @param values values
     * @return min value
     * @param <T> type of values
     */
    @SafeVarargs
    public static <T> T min(final Comparator<T> comparator, final T ... values) {
        T max = null;
        for (int i = 0; i < values.length; i++) {
            final T value = values[i];
            if (i == 0 || comparator.compare(value, max) < 0) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Returns the min value from multiple integers
     * @param values integer values
     * @return min integer value
     */
    public static int min(final int ... values) {
        return IntStream.of(values).min().orElse(0);
    }

    /**
     * Returns the min value from multiple doubles
     * @param values double values
     * @return min double value
     */
    public static double min(final double ... values) {
        return DoubleStream.of(values).min().orElse(0.0);
    }


    /**
     * Returns the max value from multiple values
     * @param comparator comparator for values
     * @param values values
     * @return max value
     * @param <T> type of values
     */
    @SafeVarargs
    public static <T> T max(final Comparator<T> comparator, final T ... values) {
        T max = null;
        for (int i = 0; i < values.length; i++) {
            final T value = values[i];
            if (i == 0 || comparator.compare(value, max) > 0) {
                max = value;
            }
        }
        return max;
    }

    /**
     * Returns the max value from multiple integers
     * @param values integer values
     * @return max integer value
     */
    public static int max(final int ... values) {
        return IntStream.of(values).max().orElse(0);
    }

    /**
     * Returns the max value from multiple doubles
     * @param values double values
     * @return max double value
     */
    public static double max(final double ... values) {
        return DoubleStream.of(values).max().orElse(0.0);
    }

    public static void main(String[] args) {
        System.out.println(max(Comparator.comparingInt(a -> a), 1, 2, 99, 3, 4, 5, 6));
    }

}
