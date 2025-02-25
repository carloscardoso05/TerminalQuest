package prog2.entities.players.heroes;

import prog2.entities.actions.skills.mago.BolaDeFogo;

import java.io.Serial;

public class Mago extends Hero {

    @Serial
    private static final long serialVersionUID = 1L;

    public Mago(String nome) {
        // TODO colocar valores corretos
        super(nome, 80, 80, 3, 1, 2, 3, 1, 5, 7, new BolaDeFogo());
    }
}
