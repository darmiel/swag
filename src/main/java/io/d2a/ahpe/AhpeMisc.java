package io.d2a.ahpe;

import javax.swing.*;
import java.util.Comparator;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class AhpeMisc {

    /**
     * Checks if b is between a and b (inclusive)
     *
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
     *
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
     *
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
     * Returns the min value from multiple values
     *
     * @param comparator comparator for values
     * @param values     values
     * @param <T>        type of values
     * @return min value
     */
    @SafeVarargs
    public static <T> T min(final Comparator<T> comparator, final T... values) {
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
     *
     * @param values integer values
     * @return min integer value
     */
    public static int min(final int... values) {
        return IntStream.of(values).min().orElse(0);
    }

    /**
     * Returns the min value from multiple doubles
     *
     * @param values double values
     * @return min double value
     */
    public static double min(final double... values) {
        return DoubleStream.of(values).min().orElse(0.0);
    }


    /**
     * Returns the max value from multiple values
     *
     * @param comparator comparator for values
     * @param values     values
     * @param <T>        type of values
     * @return max value
     */
    @SafeVarargs
    public static <T> T max(final Comparator<T> comparator, final T... values) {
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
     *
     * @param values integer values
     * @return max integer value
     */
    public static int max(final int... values) {
        return IntStream.of(values).max().orElse(0);
    }

    /**
     * Returns the max value from multiple doubles
     *
     * @param values double values
     * @return max double value
     */
    public static double max(final double... values) {
        return DoubleStream.of(values).max().orElse(0.0);
    }

    public static String repeat(final String what, final long howMany) {
        final StringBuilder builder = new StringBuilder();
        for (long i = 0; i < howMany; i++) {
            builder.append(what);
        }
        return builder.toString();
    }

    public static void visible(final JFrame frame, final int addHeight, final int addWidth) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        if (addWidth != 0 || addHeight != 0) {
            frame.setSize(frame.getWidth() + addWidth, frame.getHeight() + addHeight);
        }
    }

    public static void visible(final JFrame frame) {
        AhpeMisc.visible(frame, 0, 0);
    }

}
