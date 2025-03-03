package prog2.entities.actions.skills.monsters;

import prog2.entities.players.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Envenenado;

import java.util.List;

public class Envenenar extends Skill {


    public Envenenar() {
        super("Envenenar", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        this.checarMana(origem.getManaAtual(), origem);
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        Player alvo = alvos.get(0);
        alvo.getStatus().add(new Envenenado());
        return ResultadoAtaque.ACERTOU;
    }
}
