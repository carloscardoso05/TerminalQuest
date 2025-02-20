package prog2.entities.actions.skills.monsters;

import prog2.entities.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Envenenado;

import java.util.List;

public class envenenar extends Skill {


    public envenenar(String name) {
        super(name, 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        Player alvo = alvos.get(0);
        alvo.getStatus().add(new Envenenado());
        return ResultadoAtaque.ACERTOU;
    }
}
