package prog2.entities.actions;

import prog2.entities.Player;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

public abstract class Action {
    private Player origem;
    private Player[] alvos;

    public Action(Player origem, Player[] alvos) {
        this.setOrigem(origem);
        this.setAlvo(alvos);
    }

    public Player getOrigem() {
        return origem;
    }
    public void setOrigem(Player origem) {
        this.origem = origem;
    }

    public Player[] getAlvo() {
        return alvos;
    }
    public void setAlvo(Player[] alvos) {
        this.alvos = alvos;
    }

    public ResultadoAtaque getResultadoAtaque(Player alvo, int ataque, int bonus) {
        if (ataque + bonus >= alvo.getDefesa()) {
            if (ataque == Dice.CRIT_ROLL)
                return ResultadoAtaque.CRITICAL_HIT;
            return ResultadoAtaque.ACERTOU;
        }
        return ResultadoAtaque.ERROU;
    }

    public abstract void execute();
}
