package prog2.entities.actions.skills.bardo;

import java.util.List;

import prog2.entities.players.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Inspirado;

public class Inspiracao extends Skill {
    public Inspiracao() {
        super("Inspiração de Bardo", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        this.checarMana(origem.getManaAtual(), origem);
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        Player alvo = alvos.get(0);
        alvo.getStatus().add(new Inspirado());
        registrarLog(alvos);
        return ResultadoAtaque.ACERTOU;
    }
}
