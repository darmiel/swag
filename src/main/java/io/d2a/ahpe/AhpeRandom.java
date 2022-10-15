package io.d2a.ahpe;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class AhpeRandom {

    private static final Random random = new Random();

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

    /*
     * Generates a random color with r, g and b values between {min} and {max}
     *
     * @param min minimum value to choose from (r, g, b)
     * @param max maximum value to choose from (r, g, b)
     * @return random color
     */
    public static Color randomColor(final int min, final int max) {
        return new Color(
                AhpeRandom.randomNumber(min, max),
                AhpeRandom.randomNumber(min, max),
                AhpeRandom.randomNumber(min, max)
        );
    }

    /*
     * Generates a random color with r, g and values between 0 and {max}
     *
     * @param max maximum value to choose from (r, g, b)
     * @return random color
     */
    public static Color randomColor(final int max) {
        return AhpeRandom.randomColor(0, max);
    }

    /**
     * Generates a random color with r, g and b values between 0 and 200 (inclusive)
     *
     * @return random color
     */
    public static Color randomColor() {
        return AhpeRandom.randomColor(200);
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
     * Returns a random entry from the given list
     *
     * @param list list to choose an entry from
     * @param <T>  type of list
     * @return random entry of list
     */
    public static <T> T randomList(final List<T> list) {
        if (list.size() == 0) {
            return null;
        }
        return list.get(random.nextInt(list.size()));
    }

}
