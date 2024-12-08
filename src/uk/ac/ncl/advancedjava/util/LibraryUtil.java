package uk.ac.ncl.advancedjava.util;

import java.util.Random;

public class LibraryUtil {

    // Random object used to generate random numbers
    private static Random random = new Random();

    /**
     * Generates a random integer between 0 (inclusive) and the given size (exclusive).
     *
     * @param size The upper bound (exclusive) for the random number.
     * @return A random integer between 0 and size-1.
     */
    public static int getRandom(int size) {
        return random.nextInt(size);
    }

}
