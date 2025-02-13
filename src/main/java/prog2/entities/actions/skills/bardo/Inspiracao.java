package prog2.entities.actions.skills.bardo;

import prog2.entities.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.status.Inspirado;

public class Inspiracao extends Skill {
    public Inspiracao() {
        super("Inspiração de Bardo", 5);
    }

    @Override
    public void execute(Player origem, Player[] alvos) {
        Player alvo = alvos[0];

        origem.setManaAtual(origem.getManaAtual() - this.getCusto());
        alvo.getStatus().add(new Inspirado());
    }
}
