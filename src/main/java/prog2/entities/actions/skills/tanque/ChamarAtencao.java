package prog2.entities.actions.skills.tanque;

import prog2.entities.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;

import java.util.List;

public class ChamarAtencao extends Skill {
    public ChamarAtencao() {
        super("Chamar atenção", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
