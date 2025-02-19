package prog2.entities;

import java.io.Serial;

public class Ladino extends Hero {
    @Serial
    private static final long serialVersionUID = 1L;

    public Ladino(String nome) {
        // TODO colocar valores corretos
        super(nome, 85, 85, 2, 1, 4, 4, 1, 2, 4);
    }
}
