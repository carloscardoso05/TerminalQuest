package prog2.game;

import prog2.game.log.Log;
import prog2.util.ToString;

import java.io.Serial;
import java.io.Serializable;

public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Turno turno = new Turno();
    private final Log log = new Log();
    private final String name;

    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Turno getTurno() {
        return turno;
    }

    @Override
    public String toString() {
        return ToString.fromGetters(this);
    }
}
