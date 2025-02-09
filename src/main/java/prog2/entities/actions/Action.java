package prog2.entities.actions;

import prog2.entities.Player;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

public abstract class Action {
    private final String name;

    public Action(String name) {
        this.name = name;
    }

    public ResultadoAtaque getResultadoAtaque(Player alvo, int ataque, int bonus) {
        if (ataque + bonus >= alvo.getDefesa()) {
            if (ataque == Dice.CRIT_ROLL)
                return ResultadoAtaque.CRITICAL_HIT;
            return ResultadoAtaque.ACERTOU;
        }
        return ResultadoAtaque.ERROU;
    }

    public abstract void execute(Player origem, Player[] alvos);

    public String getName() {
        return name;
    }
}
