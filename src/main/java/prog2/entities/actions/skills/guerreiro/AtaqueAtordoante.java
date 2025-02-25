package prog2.entities.actions.skills.guerreiro;

import java.util.List;

import prog2.entities.actions.attack.Attack;
import prog2.entities.players.Player;
import prog2.entities.actions.skills.Skill;
import prog2.entities.enums.ResultadoAtaque;
import prog2.entities.status.Atordoado;

public class AtaqueAtordoante extends Skill {
    private static final int DANO_BASE = 6;

    public AtaqueAtordoante() {
        super("Ataque atordoante", 5);
    }

    @Override
    public ResultadoAtaque execute(Player origem, List<Player> alvos) {
        if (alvos.size() != 1) throw new IllegalArgumentException("Esta habilidade aceita apenas um alvo.");

        this.checarMana(origem.getManaAtual(), origem);
        origem.setManaAtual(origem.getManaAtual() - this.getCusto());

        Player alvo = alvos.get(0);
        alvo.getStatus().add(new Atordoado());
        registrarLog(alvos);
        return new Attack(this.getName(), DANO_BASE, origem.getForcaDeAtaque()).execute(origem, alvos);
    }
}
