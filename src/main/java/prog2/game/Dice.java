package prog2.game;

import prog2.entities.enums.ResultadoAtaque;
import prog2.util.RandomSingleton;

public class Dice {
    public static final int CRIT_ROLL = 20;

    private static int roll(int numLados) {
        return RandomSingleton.getInstance().nextInt(1, numLados + 1);
    }

    public static int rollDice(int numLados, int bonus) {
        if (numLados < 2) {
            throw new IllegalArgumentException("Número de lados inválido");
        }

        return roll(numLados) + bonus;
    }
    public static int rollDice(int numLados) {
        if (numLados < 2) {
            throw new IllegalArgumentException("Número de lados inválido");
        }

        return roll(numLados);
    }

    public static int[] rollDices(int numDados, int numLados) {
        if (numDados < 1 || numLados < 2) {
            throw new IllegalArgumentException("Número de dados ou lados inválido");
        }
        int[] res = new int[numDados];
        for (int i = 0; i < numDados; i++) {
            res[i] = roll(numLados);
        }
        return res;
    }

    public static int rollAtaque() {
        return rollDice(20);
    }

    public static int rollDano(int numLados, int bonus, ResultadoAtaque resultado) {
        if (numLados < 2) {
            throw new IllegalArgumentException("Número de lados inválido");
        }

        return switch (resultado) {
            case CRITICAL_HIT -> 2 * roll(numLados) + bonus;
            case ACERTOU -> roll(numLados) + bonus;
            case ERROU -> 0;
        };
    }
    public static int rollDano(int numLados, ResultadoAtaque resultado) {
        if (numLados < 2) {
            throw new IllegalArgumentException("Número de lados inválido");
        }

        return switch (resultado) {
            case CRITICAL_HIT -> 2 * roll(numLados);
            case ACERTOU -> roll(numLados);
            case ERROU -> 0;
        };
    }
}
