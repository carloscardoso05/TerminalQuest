package prog2.entities.actions.skills.bardo;

import java.util.List;

import prog2.entities.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Inspirado;

public class Inspiracao extends Skill {
    public Inspiracao() {
        super("Inspiração de Bardo", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        Player alvo = alvos.get(0);

        origem.setManaAtual(origem.getManaAtual() - this.getCusto());
        alvo.getStatus().add(new Inspirado());
        return ResultadoAtaque.ACERTOU;
    }
}
