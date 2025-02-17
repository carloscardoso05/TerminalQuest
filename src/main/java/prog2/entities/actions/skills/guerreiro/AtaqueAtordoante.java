package prog2.entities.actions.skills.guerreiro;

import java.util.List;

import prog2.entities.Player;
import prog2.entities.actions.attack.DefaultAttack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Atordoado;

public class AtaqueAtordoante extends Skill {
    public AtaqueAtordoante() {
        super("Ataque atordoante", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        Player alvo = alvos.get(0);

        origem.setManaAtual(origem.getManaAtual() - this.getCusto());
        alvo.getStatus().add(new Atordoado());
        return new DefaultAttack().execute(origem, alvos);
    }
}
