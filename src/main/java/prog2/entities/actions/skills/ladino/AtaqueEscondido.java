package prog2.entities.actions.skills.ladino;

import prog2.entities.Player;
import prog2.entities.actions.attack.DefaultAttack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.status.Escondido;

public class AtaqueEscondido extends Skill {

    public AtaqueEscondido() {
        super("Ataque escondido", 5);
    }

    @Override
    public void execute(Player origem, Player[] alvos) {
//        Primeiro turno: se esconder
        if (!origem.getStatus().contains(new Escondido())) {
            origem.setManaAtual(origem.getManaAtual() - this.getCusto());
            origem.getStatus().add(new Escondido());
            return;
        }
//        Segundo turno: atacar
        new DefaultAttack().execute(origem, alvos);
        new DefaultAttack().execute(origem, alvos);
    }
}
