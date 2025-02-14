package prog2.entities;

import java.io.Serial;

public class Hero extends Player {
    @Serial
    private static final long serialVersionUID = 1L;

    public Hero(String nome, int vidaMaxima, int manaMaxima, int forcaDeAtaque, int inteligencia, int defesa, int velocidade, int destreza, int nivel, int ameaca) {
        super(nome, vidaMaxima, manaMaxima, forcaDeAtaque, inteligencia, defesa, velocidade, destreza, nivel, ameaca);
    }
}
