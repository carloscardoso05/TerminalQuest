package prog2.entities.actions.skills;

import prog2.entities.actions.Action;
import prog2.entities.players.Player;
import prog2.game.log.Log;
import prog2.util.exceptions.ManaInsuficiente;

public abstract class Skill extends Action {
    private final int custo;

    public Skill(String name, int custo) {
        super(name);
        this.custo = custo;
    }

    protected void checarMana(int mana, Player player) {
        if (mana < this.getCusto()){
            Log.getInstance().game(player + " não possui mana suficiente para usar " + this);
            throw new ManaInsuficiente();
        }
    }

    public int getCusto() {
        return custo;
    }
}
