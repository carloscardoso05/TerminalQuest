package prog2.entities.status;

import prog2.entities.players.Player;
import prog2.game.log.Log;

public class Inspirado extends Status{
    private static final int DURACAO_CHEIA = 2;
    public Inspirado() {
        super("Inspirado", DURACAO_CHEIA);
    }

    @Override
    public void aplicarEfeito(Player player) {
        if (this.getDuracaoRestante() == DURACAO_CHEIA - 1) {
            player.setDestreza(player.getDestreza() + 2);
            Log.getInstance().game(player + " está " + this + ", ganhando +2 no atributo destreza");
        }
    }

    @Override
    public void reverterEfeito(Player player) {
        player.setDestreza(player.getDestreza() - 2);
    }
}
