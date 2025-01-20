package prog2.players;

import java.util.Random;

public abstract class PlayerFactory {
    private static final Random rd = new Random();

    private static int randomInt(int min, int max) {
        return rd.nextInt(min, max + 1);
    }

    public static Player criarPlayerAleatorio(String nome) {
        final int vidaMaxima = randomInt(100, 200);
        final int forcaDeAtaque = randomInt(10, 20);
        final int defesa = randomInt(5, 10);
        final int velocidade = randomInt(5, 10);
        final int destreza = randomInt(5, 10);
        final int nivel = randomInt(1, 10);
        return new Player(nome, vidaMaxima, vidaMaxima, forcaDeAtaque, defesa, velocidade, destreza, nivel);
    }

    public static Hero criarHeroiAleatorio(String nome) {
        return (Hero) criarPlayerAleatorio(nome);
    }

    public static Monster criarMonstroAleatorio(String nome) {
        return (Monster) criarPlayerAleatorio(nome);
    }
}
