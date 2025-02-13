package prog2.entities.actions.skills.guerreiro;

import prog2.entities.Player;
import prog2.entities.actions.attack.DefaultAttack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.status.Atordoado;

public class AtaqueAtordoante extends Skill {
    public AtaqueAtordoante() {
        super("Ataque atordoante", 5);
    }

    @Override
    public void execute(Player origem, Player[] alvos) {
        Player alvo = alvos[0];

        origem.setManaAtual(origem.getManaAtual() - this.getCusto());
        new DefaultAttack().execute(origem, alvos);
        alvo.getStatus().add(new Atordoado());
    }
}
