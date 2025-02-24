package prog2.entities.actions.skills.monsters;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.players.Player;
import prog2.entities.status.Atordoado;

import java.util.List;

public class RajadaDePenas extends Skill{
    public RajadaDePenas() {
        super("Rajada de Penas", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        super.checarMana(origem.getManaAtual(), origem.getNome());
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        ResultadoAtaque resultadoTotal = ResultadoAtaque.ERROU;
        for (Player alvo : alvos) {
            final ResultadoAtaque resultado = new Attack("Rajada de Penas", 4, origem.getForcaDeAtaque()).execute(origem, alvo);
            if (resultado == ResultadoAtaque.CRITICAL_HIT) {
                alvo.getStatus().add(new Atordoado());
            }
            if (resultado != ResultadoAtaque.ERROU && resultadoTotal != ResultadoAtaque.CRITICAL_HIT) {
                resultadoTotal = resultado;
            }
        }
        registrarLog(origem.getNome(), alvos);
        return resultadoTotal;
    }
}
