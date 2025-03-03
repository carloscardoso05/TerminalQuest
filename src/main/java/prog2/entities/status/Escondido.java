package prog2.entities.status;

import prog2.entities.players.Player;
import prog2.entities.actions.skills.ladino.AtaqueEscondido;
import prog2.game.log.Log;
import prog2.util.exceptions.ImpedeAcao;

public class Escondido extends Status {
    private final Player alvo;
    public Escondido(Player alvo) {
        super("Escondido", 1);
        this.alvo = alvo;
    }

    @Override
    public void aplicarEfeito(Player player) throws ImpedeAcao {
        Log.getInstance().game(player + " não pode atacar essa rodada pois está " + this);
        throw new ImpedeAcao();
    }

    @Override
    public void reverterEfeito(Player player) {
        AtaqueEscondido skill = (AtaqueEscondido) player.getHabilidade();
        skill.execute(player, this.alvo);
    }
}
