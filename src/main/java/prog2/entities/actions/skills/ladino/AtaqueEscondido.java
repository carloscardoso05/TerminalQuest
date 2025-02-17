package prog2.entities.actions.skills.ladino;

import java.util.List;

import prog2.entities.Player;
import prog2.entities.actions.attack.DefaultAttack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Escondido;

public class AtaqueEscondido extends Skill {

    public AtaqueEscondido() {
        super("Ataque escondido", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
//        Primeiro turno: se esconder
        if (!origem.getStatus().contains(new Escondido())) {
            origem.setManaAtual(origem.getManaAtual() - this.getCusto());
            origem.getStatus().add(new Escondido());
            return ResultadoAtaque.ERROU; // TODO rever isso aqui
        }
//        Segundo turno: atacar
        return new DefaultAttack().execute(origem, alvos);
    }
}
