package prog2.entities.actions.skills.tanque;

import prog2.entities.Player;
import prog2.entities.status.Ameacador;
import prog2.entities.actions.skills.Skill;
import prog2.entities.status.Ameacador;

public class ChamarAtencao extends Skill {
    public ChamarAtencao() {
        super("Chamar atenção", 5);
    }

    @Override
    public void execute(Player origem, Player[] alvos) {
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());
        origem.getStatus().add(new Ameacador());
    }
}
