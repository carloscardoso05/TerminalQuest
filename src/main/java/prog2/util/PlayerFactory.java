package prog2.util;

import prog2.entities.players.Player;
import prog2.entities.players.heroes.*;
import prog2.entities.players.monsters.*;

import java.util.Random;

public abstract class PlayerFactory {
    private static final Random rd = new Random();

    public static Player criarPlayerAleatorio(String nome, int nivel) {
        final int n = rd.nextInt(2);
        return switch (n) {
            case 0 -> criarHeroiAleatorio(nome);
            case 1 -> criarMonstroAleatorio(nivel);
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

    public static Monster criarMonstroAleatorio(int nivel) {
        final int n = rd.nextInt(4);
        return switch (n) {
            case 0 -> new Minion(nivel);
            case 1 -> new Coruja(nivel);
            case 2 -> new Piton(nivel);
            case 3 -> new Pinguim(nivel);
            default -> throw new IllegalArgumentException("Classe de monstro inválida. Valor: " + n);
        };
    }

    public static Monster criarMinionAleatorio(int nivel) {
        return new Minion(nivel);
    }

    public static Monster criarMonstroChefeAleatorio(int nivel) {
        final int n = rd.nextInt(3);
        return switch (n) {
            case 0 -> new Coruja(nivel);
            case 1 -> new Piton(nivel);
            case 2 -> new Pinguim(nivel);
            default -> throw new IllegalArgumentException("Classe de monstro inválida. Valor: " + n);
        };
    }
}
