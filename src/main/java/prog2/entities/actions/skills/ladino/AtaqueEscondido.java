package prog2.entities.actions.skills.ladino;

import java.util.List;

import prog2.entities.Player;
import prog2.entities.actions.attack.DefaultAttack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Escondido;

public class AtaqueEscondido extends Skill {
    private static final int DANO_BASE = 8;

    public AtaqueEscondido() {
        super("Ataque escondido", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        Player alvo = alvos.get(0);
        Escondido statusEscondido = new Escondido(alvo);
//        Primeiro turno: se esconder
        if (!origem.getStatus().contains(statusEscondido)) {
            origem.setManaAtual(origem.getManaAtual() - this.getCusto());
            origem.getStatus().add(statusEscondido);
            return ResultadoAtaque.ERROU; // TODO rever isso aqui
        }
//        Segundo turno: atacar
        return new DefaultAttack(DANO_BASE).execute(origem, alvos);
    }
}
