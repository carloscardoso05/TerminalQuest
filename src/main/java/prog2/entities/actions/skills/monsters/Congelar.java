package prog2.entities.actions.skills.monsters;

import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.players.Player;
import prog2.entities.status.Congelado;

import java.util.List;

public class Congelar extends Skill {
    public Congelar() {
        super("Congelar", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        super.checarMana(origem.getManaAtual(), origem);
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        Player alvo = alvos.get(0);
        alvo.getStatus().add(new Congelado());
        return ResultadoAtaque.ACERTOU;
    }
}
