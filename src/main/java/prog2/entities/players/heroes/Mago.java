package prog2.entities.players.heroes;

import prog2.entities.actions.skills.mago.BolaDeFogo;

import java.io.Serial;

public class Mago extends Hero {

    @Serial
    private static final long serialVersionUID = 1L;

    public Mago(String nome) {
        super(nome, 8, 15, 0, 2, 9, 1, 0, 1, 8, new BolaDeFogo());
    }
}
