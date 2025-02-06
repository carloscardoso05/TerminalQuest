package prog2.game.action;

import prog2.entities.Player;

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

    public abstract void execute();
}
