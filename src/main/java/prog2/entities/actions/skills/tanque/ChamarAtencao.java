package prog2.entities.actions.skills.tanque;

import java.util.List;

import prog2.entities.players.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Ameacador;

public class ChamarAtencao extends Skill {
    public ChamarAtencao() {
        super("Chamar atenção", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());
        origem.getStatus().add(new Ameacador());
        return ResultadoAtaque.ACERTOU;
    }
}
