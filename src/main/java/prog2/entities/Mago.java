package prog2.entities;

import java.io.Serial;

public class Mago extends Hero{

    @Serial
    private static final long serialVersionUID = 1L;

    public Mago (String nome, int vidaMaxima, int vidaAtual, int forcaDeAtaque, int defesa, int velocidade, int destreza, int nivel ) {
        super (nome, 80, 80,3, 1, 2, 3, 1);
    }
}
