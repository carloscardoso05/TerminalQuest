package prog2.util;

import java.util.Random;

public class RandomSingleton {
    private static Random instance;

    private RandomSingleton() {
    }

    public static Random getInstance() {
        if (instance == null) {
            instance = new Random();
        }
        return instance;
    }
}
