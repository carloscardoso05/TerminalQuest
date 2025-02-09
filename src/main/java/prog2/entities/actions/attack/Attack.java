package prog2.entities.actions.attack;

import prog2.entities.actions.Action;

public abstract class Attack extends Action {
    protected final int danoBase;

    public Attack(String name, int danoBase) {
        super(name);
        this.danoBase = danoBase;
    }
}
