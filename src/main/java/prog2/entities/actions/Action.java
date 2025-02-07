package prog2.entities.actions;

import prog2.entities.Player;
import prog2.entities.enums.ResultadoAtaque;
import prog2.game.Dice;

public abstract class Action {
    private Player origem, alvo;

    public Action(Player origem, Player alvo) {
        this.setOrigem(origem);
        this.setAlvo(alvo);
    }

    public Player getOrigem() {
        return origem;
    }
    public void setOrigem(Player origem) {
        this.origem = origem;
    }

    public Player getAlvo() {
        return alvo;
    }
    public void setAlvo(Player alvo) {
        this.alvo = alvo;
    }

    public ResultadoAtaque getResultadoAtaque(int ataque, int bonus) {
        if (ataque + bonus >= alvo.getDefesa()) {
            if (ataque == Dice.CRIT_ROLL)
                return ResultadoAtaque.CRITICAL_HIT;
            return ResultadoAtaque.ACERTOU;
        }
        return ResultadoAtaque.ERROU;
    }

    public abstract void execute();
}
