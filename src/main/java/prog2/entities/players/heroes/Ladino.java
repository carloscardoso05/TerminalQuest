package prog2.entities.players.heroes;

import java.io.Serial;

public class Ladino extends Hero {
    @Serial
    private static final long serialVersionUID = 1L;

    public Ladino(String nome) {
        // TODO colocar valores corretos
        super(nome, 10, 10, 0, 0, 12, 2, 1, 1, 10);
    }
}
