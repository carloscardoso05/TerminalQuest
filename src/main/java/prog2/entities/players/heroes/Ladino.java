package prog2.entities.players.heroes;

import prog2.entities.actions.skills.ladino.AtaqueEscondido;

import java.io.Serial;

public class Ladino extends Hero {
    @Serial
    private static final long serialVersionUID = 1L;

    public Ladino(String nome) {
        // TODO colocar valores corretos
        super(nome, 85, 85, 2, 1, 4, 4, 1, 2, 4, new AtaqueEscondido());
    }
}
