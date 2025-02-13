package prog2.entities.actions.skills.arqueiro;

import prog2.entities.Player;
import prog2.entities.actions.attack.DefaultAttack;
import prog2.entities.actions.skills.Skill;

public class ataqueMultiplo extends Skill {

    public ataqueMultiplo() {
        super("Ataque múltiplo", 5);
    }

    @Override
    public void execute(Player origem, Player[] alvos) {
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        for (Player alvo : alvos) {
            new DefaultAttack().execute(origem, new Player[] {alvo});
        }
    }
}
