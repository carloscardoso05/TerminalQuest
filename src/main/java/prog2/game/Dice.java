package prog2.game;

import java.util.Random;

import prog2.entities.enums.ResultadoAtaque;

public class Dice {
    private static int roll(int numLados) {
        Random rand = new Random();
        return rand.nextInt(1, numLados + 1);
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
        Random rand = new Random();

        return switch (resultado) {
            case CRITICAL_HIT -> 2 * roll(numLados);
            case ACERTOU -> roll(numLados);
            case ERROU -> 0;
        };
    }
}
