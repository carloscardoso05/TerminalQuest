package prog2.entities.players.heroes;

import java.io.Serial;

public class Mago extends Hero {

    @Serial
    private static final long serialVersionUID = 1L;

    public Mago(String nome) {
        // TODO colocar valores corretos
        super(nome, 8, 15, 0, 2, 9, 1, 0, 1, 8);
    }
}
