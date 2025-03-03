package prog2.entities.status;

import prog2.entities.players.Player;
import prog2.game.Dice;
import prog2.util.exceptions.ImpedeAcao;

public class Congelado extends Status {
    private static final int DANO_MAX = 3;
    public Congelado() {
        super("Congelado", 2);
    }

    @Override
    public void aplicarEfeito(Player player) throws ImpedeAcao {
        int dano = Dice.rollDice(DANO_MAX);
        player.setVidaAtual(Math.max(player.getVidaAtual() - dano, 0));
        throw new ImpedeAcao();
    }

    @Override
    protected void reverterEfeito(Player player) {
    }
}
