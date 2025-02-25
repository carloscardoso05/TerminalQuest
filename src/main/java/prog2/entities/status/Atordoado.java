package prog2.entities.status;

import prog2.entities.players.Player;
import prog2.util.exceptions.ImpedeAcao;
import prog2.game.log.Log;

public class Atordoado extends Status {
    public Atordoado() {
        super("Atordoado", 2);
    }

    @Override
    public void aplicarEfeito(Player player) throws ImpedeAcao {
        Log.getInstance().game(player + " não pode atacar essa rodada pois está " + this);
        throw new ImpedeAcao();
    }

    @Override
    public void reverterEfeito(Player player) {
    }
}
