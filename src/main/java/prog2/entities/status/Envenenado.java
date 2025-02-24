package prog2.entities.status;

import prog2.entities.players.Player;
import prog2.game.Dice;
import prog2.util.exceptions.ImpedeAcao;
import prog2.game.log.Log;

public class Envenenado extends Status{
    private static final int DANO_MAX = 5;

    public Envenenado() {
        super("Envenenado", 3);
    }

    @Override
    public void aplicarEfeito(Player player) throws ImpedeAcao {
        int dano = Dice.rollDice(DANO_MAX);
        player.setVidaAtual(Math.max(player.getVidaAtual() - dano, 0));
        Log.getInstance().game(player.getNome() + " tomou " + dano + " por estar " + this.getNome());
    }

    @Override
    protected void reverterEfeito(Player player) {}
}
