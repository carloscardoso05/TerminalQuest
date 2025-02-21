package prog2.entities.actions.skills.monsters;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.players.Player;
import prog2.entities.status.Atordoado;

import java.util.List;

public class PenasDeAco extends Skill{
    public PenasDeAco() {
        super("Penas de Aço", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        super.checarMana(origem.getManaAtual(), origem.getNome());
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        Player alvo = alvos.get(0);
        ResultadoAtaque resultado = new Attack("Penas de aço", 8, origem.getForcaDeAtaque()).execute(origem, alvos);
        if (resultado == ResultadoAtaque.CRITICAL_HIT) {
            alvo.getStatus().add(new Atordoado());
        }
        registrarLog(origem.getNome(), alvos);
        return resultado;
    }
}
