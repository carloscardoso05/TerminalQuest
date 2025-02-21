package prog2.entities.status;

import prog2.entities.players.Player;
import prog2.game.Dice;
import prog2.util.exceptions.ImpedeAcao;

public class Queimado extends Status {
    public Queimado() {
        super("Queimado", 2);
    }

    @Override
    public void aplicarEfeito(Player player) throws ImpedeAcao {
        player.setVidaAtual(player.getVidaAtual() - Dice.rollDice(5));
    }

    @Override
    protected void reverterEfeito(Player player) {
    }
}
