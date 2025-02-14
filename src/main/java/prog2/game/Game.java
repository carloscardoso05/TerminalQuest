package prog2.game;

import prog2.entities.Player;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.log.Log;
import prog2.util.PlayerFactory;
import prog2.util.Aleatorio;
import prog2.util.ToString;

import java.io.Serial;
import java.io.Serializable;

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
        turno.addPlayer(PlayerFactory.criarMonstroAleatorio("M1"));
        turno.addPlayer(PlayerFactory.criarMonstroAleatorio("M2"));
        turno.addPlayer(PlayerFactory.criarMonstroAleatorio("M3"));
        turno.addPlayer(PlayerFactory.criarHeroiAleatorio("H1"));
        turno.addPlayer(PlayerFactory.criarHeroiAleatorio("H2"));
        turno.addPlayer(PlayerFactory.criarHeroiAleatorio("H3"));

        Player a = turno.getPlayers().get(0);
        Player b = turno.getPlayers().get(3);
        log.game(a);
        log.game(b);
        ResultadoAtaque resultado = a.realizarAtaque(b);
        log.game("%s atacou %s, resultado = %s".formatted(a.getNome(), b.getNome(), resultado));
        log.game(a);
        log.game(b);
    }

    @Override
    public String toString() {
        return ToString.fromGetters(this);
    }
}
