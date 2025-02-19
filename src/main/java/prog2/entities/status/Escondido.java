package prog2.entities.status;

import prog2.entities.Player;
import prog2.entities.actions.skills.ladino.AtaqueEscondido;
import prog2.util.exceptions.ImpedeAcao;

public class Escondido extends Status {
    private Player alvo;
    public Escondido(Player alvo) {
        super("Escondido", 1);
        this.alvo = alvo;
    }

    @Override
    public void aplicarEfeito(Player player) throws ImpedeAcao {
        throw new ImpedeAcao();
    }

    @Override
    public void reverterEfeito(Player player) {
        AtaqueEscondido skill = (AtaqueEscondido) player.getHabilidades().get(0);
        skill.execute(player, this.alvo);
    }
}
