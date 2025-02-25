package prog2.entities.actions.skills.arqueiro;

import java.util.List;

import prog2.entities.players.Player;
import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;

public class AtaqueMultiplo extends Skill {
    private static final int DANO_BASE = 6;

    public AtaqueMultiplo() {
        super("Ataque múltiplo", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        this.checarMana(origem.getManaAtual(), origem);
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        ResultadoAtaque resultadoTotal = ResultadoAtaque.ERROU;
        for (Player alvo : alvos) {
            final ResultadoAtaque resultado = new Attack(this.getName(), DANO_BASE, origem.getDestreza()).execute(origem, alvo);
            if (resultado != ResultadoAtaque.ERROU && resultadoTotal != ResultadoAtaque.CRITICAL_HIT) {
                resultadoTotal = resultado;
            }
        }

        // retorna o melhor resultado
        return resultadoTotal;
    }
}
