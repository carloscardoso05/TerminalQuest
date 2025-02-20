package prog2.util;

import prog2.entities.players.Player;
import prog2.entities.players.heroes.*;
import prog2.entities.players.monsters.Monster;
import prog2.entities.players.monsters.Rato;

import java.util.Random;

public abstract class PlayerFactory {
    private static final Random rd = new Random();

    public static Player criarPlayerAleatorio(String nome) {
        final int n = rd.nextInt(2);
        return switch (n) {
            case 0 -> criarHeroiAleatorio(nome);
            case 1 -> criarMonstroAleatorio(nome);
            default -> throw new IllegalArgumentException("Tipo de jogador inválido. Valor: " + n);
        };
    }

    public static Hero criarHeroiAleatorio(String nome) {
        final int n = rd.nextInt(6);
        return switch (n) {
            case 0 -> new Bardo(nome);
            case 1 -> new Ladino(nome);
            case 2 -> new Mago(nome);
            case 3 -> new Guerreiro(nome);
            case 4 -> new Arqueiro(nome);
            case 5 -> new Tanque(nome);
            default -> throw new IllegalArgumentException("Classe de herói inválida. Valor: " + n);
        };
    }

    public static Monster criarMonstroAleatorio(String nome) {
        return new Rato();
    }
}
