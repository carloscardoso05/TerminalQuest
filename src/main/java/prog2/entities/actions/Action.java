package prog2.entities.actions;

import org.fusesource.jansi.Ansi;
import prog2.entities.players.Player;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

import java.util.List;

public abstract class Action {
    private final String name;

    public Action(String name) {
        this.name = name;
    }

    public abstract ResultadoAtaque execute(Player origem, List<Player> alvos);

    public final ResultadoAtaque execute(Player origem, Player alvo) {
        return execute(origem, List.of(alvo));
    }

    protected ResultadoAtaque getResultadoAtaque(Player alvo, int ataque, int bonus) {
        if (ataque + bonus >= alvo.getDefesa()) {
            if (ataque == Dice.CRIT_ROLL)
                return ResultadoAtaque.CRITICAL_HIT;
            return ResultadoAtaque.ACERTOU;
        }
        return ResultadoAtaque.ERROU;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return Ansi.ansi().fgRgb(0xcb0072).a(name).reset().toString();
    }
}
