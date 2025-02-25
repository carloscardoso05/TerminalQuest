package prog2.entities.actions.skills.monsters;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.players.Player;
import prog2.entities.status.Atordoado;

import java.util.List;

public class RajadaDePenas extends Skill{
    public RajadaDePenas() {
        super("Rajada de penas", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        super.checarMana(origem.getManaAtual(), origem);
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        Player alvo = alvos.get(0);
        ResultadoAtaque resultado = new Attack("Rajada de penas", 8, origem.getForcaDeAtaque()).execute(origem, List.of(alvo));
        if (resultado == ResultadoAtaque.CRITICAL_HIT) {
            alvo.getStatus().add(new Atordoado());
        }
        return resultado;
    }
}
