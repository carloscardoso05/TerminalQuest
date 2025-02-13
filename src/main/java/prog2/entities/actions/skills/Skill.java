package prog2.entities.actions.skills;

import prog2.entities.Player;
import prog2.entities.actions.Action;

public abstract class Skill extends Action {
    private final int custo;

    public Skill(String name, int custo) {
        super(name);
        this.custo = custo;
    }

    @Override
    public abstract void execute(Player origem, Player[] alvos);

    public int getCusto() {
        return custo;
    }
}
