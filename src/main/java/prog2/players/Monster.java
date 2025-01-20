package prog2.players;

import java.io.Serial;

public class Monster extends Player {
    @Serial
    private static final long serialVersionUID = 1L;

    public Monster(String nome, int vidaMaxima, int vidaAtual, int forcaDeAtaque, int defesa, int velocidade, int destreza, int nivel) {
        super(nome, vidaMaxima, vidaAtual, forcaDeAtaque, defesa, velocidade, destreza, nivel);
    }
}
