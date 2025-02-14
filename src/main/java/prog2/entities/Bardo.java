package prog2.entities;

import java.io.Serial;

public class Bardo extends Hero{
    @Serial
    private static final long serialVersionUID = 1L;

    public Bardo (String nome, int vidaMaxima, int vidaAtual, int forcaDeAtaque, int defesa, int velocidade, int destreza, int nivel) {
        super (nome, 95, 95,2, 1, 2, 3, 1);
    }
    
}
