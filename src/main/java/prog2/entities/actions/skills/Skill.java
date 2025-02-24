package prog2.entities.actions.skills;

import prog2.entities.actions.Action;
import prog2.entities.players.Player;
import prog2.game.log.Log;
import prog2.util.exceptions.ManaInsuficiente;

import java.util.Iterator;
import java.util.List;

public abstract class Skill extends Action {
    private final int custo;

    public Skill(String name, int custo) {
        super(name);
        this.custo = custo;
    }

    protected void checarMana(int mana, String playerName) {
        if (mana < this.getCusto()){
            Log.getInstance().game(playerName + " não possui mana suficiente para usar " + this.getName());
            throw new ManaInsuficiente();
        }
    }

    protected void registrarLog(String playerName, List<Player> alvos) {
        StringBuilder alvosNames = new StringBuilder();
        Iterator<Player> alvoIterator = alvos.iterator();
        while (alvoIterator.hasNext()) {
            alvosNames.append(alvoIterator.next().getNome());
            if (alvoIterator.hasNext()) {
                alvosNames.append(", ");
            }
        }
        Log.getInstance().game(playerName + " usou a habilidade " + this.getName() + "em " + alvosNames);
    }

    public int getCusto() {
        return custo;
    }
}
