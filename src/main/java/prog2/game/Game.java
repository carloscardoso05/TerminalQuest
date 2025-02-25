package prog2.game;

import prog2.entities.players.heroes.Hero;
import prog2.game.log.Log;
import prog2.util.PlayerFactory;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Turno turno = new Turno();
    private final Log log = Log.getInstance();
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

    public void run() {
        if (turno.getTurnNumber() == 1) {
            turno.addPlayer(createParty());
            turno.nextTurn();
        }
        while (turno.hasNextTurn()) {
            turno.nextTurn();
        }

    }

    public List<Hero> createParty() {
        // TODO implementar
        return List.of(
                PlayerFactory.criarHeroiAleatorio("Heroi 1"),
                PlayerFactory.criarHeroiAleatorio("Heroi 2"),
                PlayerFactory.criarHeroiAleatorio("Heroi 3"),
                PlayerFactory.criarHeroiAleatorio("Heroi 4")
        );
    }
}
