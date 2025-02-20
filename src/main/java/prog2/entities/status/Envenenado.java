package prog2.entities.status;

import prog2.entities.Player;
import prog2.game.Dice;
import prog2.util.exceptions.ImpedeAcao;

public class Envenenado extends Status{

    public Envenenado() {
        super("Envenenado", 3);
    }

    @Override
    public void aplicarEfeito(Player player) throws ImpedeAcao {
        player.setVidaAtual(Math.max(player.getVidaAtual() - Dice.rollDice(5), 0));
        if (player.getVidaAtual() <= 0) {
            throw new ImpedeAcao();
        }
    }

    @Override
    protected void reverterEfeito(Player player) {}
}
