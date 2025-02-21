package prog2.entities.actions.skills.mago;

import prog2.entities.players.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.actions.attack.SkillAttack;

import java.util.List;
import prog2.entities.status.Queimado;

public class BolaDeFogo extends Skill {
    private static final int DANO_BASE = 10;

    public BolaDeFogo() {
        super("Bola de fogo", 10);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        this.checarMana(origem.getManaAtual(), origem.getNome());
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        Player alvo = alvos.get(0);
        ResultadoAtaque resultado = new SkillAttack(this.getName(), DANO_BASE, origem.getInteligencia()).execute(origem, alvos);
        if (resultado == ResultadoAtaque.CRITICAL_HIT) {
            alvo.getStatus().add(new Queimado());
        }
        registrarLog(origem.getNome(), alvos);
        return resultado;
    }
}
