package prog2.util;

import java.util.List;

public abstract class Aleatorio {
    private static final java.util.Random rd = new java.util.Random();


    public static <T> T escolhe(List<T> list) {
        final int index = rd.nextInt(list.size());
        return list.get(index);
    }

}
