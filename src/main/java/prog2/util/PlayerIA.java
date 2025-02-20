package prog2.util;

import prog2.entities.players.Player;
import prog2.entities.enums.ResultadoAtaque;

import java.util.List;
import java.util.Random;

public class PlayerIA {
    private final Player player;

    public PlayerIA(Player player) {
        this.player = player;
    }

    protected Player getAlvo(List<Player> players) {
        final int i = new Random().nextInt(players.size());
        return players.get(i);
    }

    protected List<Player> getAlvos(List<Player> players) {
        // TODO escolher alvos
        return players;
    }

    public ResultadoAtaque realizarAcao(List<Player> players) {
        return player.realizarAtaque(getAlvo(players));
    }
}
