package prog2.game;

import java.util.Random;

import prog2.entities.enums.ResultadoAtaque;

public class Dice {
    public static int rollDice(int numLados, int bonus) {
        if (numLados < 2) {
            throw new IllegalArgumentException("Número de lados inválido");
        }
        Random rand = new Random();

        return rand.nextInt(1, numLados + 1) + bonus;
    }
    public static int rollDice(int numLados) {
        if (numLados < 2) {
            throw new IllegalArgumentException("Número de lados inválido");
        }
        Random rand = new Random();

        return rand.nextInt(1, numLados + 1);
    }

    public static int rollDano(int numLados, int bonus, ResultadoAtaque resultado) {
        if (numLados < 2) {
            throw new IllegalArgumentException("Número de lados inválido");
        }
        Random rand = new Random();

        return switch (resultado) {
            case CRITICAL_HIT -> 2 * rand.nextInt(1, numLados + 1) + bonus;
            case ACERTOU -> rand.nextInt(1, numLados + 1) + bonus;
            case ERROU -> 0;
        };
    }
    public static int rollDano(int numLados, ResultadoAtaque resultado) {
        if (numLados < 2) {
            throw new IllegalArgumentException("Número de lados inválido");
        }
        Random rand = new Random();

        return switch (resultado) {
            case CRITICAL_HIT -> 2 * rand.nextInt(1, numLados + 1);
            case ACERTOU -> rand.nextInt(1, numLados + 1);
            case ERROU -> 0;
        };
    }
}
