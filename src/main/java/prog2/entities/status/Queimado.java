package prog2.entities.status;

import prog2.entities.players.Player;
import prog2.game.Dice;
import prog2.game.log.Log;
import prog2.util.exceptions.ImpedeAcao;

public class Queimado extends Status {
    private static final int DANO_MAX = 5;

    public Queimado() {
        super("Queimado", 2);
    }

    @Override
    public void aplicarEfeito(Player player) throws ImpedeAcao {
        int dano = Dice.rollDice(DANO_MAX);
        player.setVidaAtual(Math.max(player.getVidaAtual() - dano, 0));
        Log.getInstance().game(player + " tomou " + dano + "de dano por estar " + this);
    }

    @Override
    protected void reverterEfeito(Player player) {
    }
}
