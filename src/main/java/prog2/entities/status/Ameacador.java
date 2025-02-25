package prog2.entities.status;

import prog2.entities.players.Player;
import prog2.game.log.Log;

public class Ameacador extends Status {
    private static final int DURACAO_CHEIA = 2;
    public Ameacador() {
        super("Ameaçador", DURACAO_CHEIA);
    }

    @Override
    public void aplicarEfeito(Player player) {
        // Duracao cheia - 1 já que a duração é decrementada antes da aplicação do efeito
        if (this.getDuracaoRestante() == DURACAO_CHEIA - 1) {
            Log.getInstance().game(player + " está " + this + ", ganhando +2 no atributo ameaça");
            player.setAmeaca(player.getAmeaca() + 2);
        }
    }

    @Override
    public void reverterEfeito(Player player) {
        player.setAmeaca(player.getAmeaca() - 2);
    }
}
