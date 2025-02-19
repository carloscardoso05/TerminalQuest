package prog2.entities.actions.skills.arqueiro;

import java.util.List;

import prog2.entities.Player;
import prog2.entities.actions.attack.DefaultAttack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;

public class ataqueMultiplo extends Skill {
    private static final int DANO_BASE = 6;

    public ataqueMultiplo() {
        super("Ataque múltiplo", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        ResultadoAtaque resultadoTotal = ResultadoAtaque.ERROU;

        for (Player alvo : alvos) {
            final ResultadoAtaque resultado = new DefaultAttack(DANO_BASE).execute(origem, alvo);
            if (resultado != ResultadoAtaque.ERROU && resultadoTotal != ResultadoAtaque.CRITICAL_HIT) {
                resultadoTotal = resultado;
            }
        }

        // TODO retorna o melhor resultado
        return resultadoTotal;
    }
}
