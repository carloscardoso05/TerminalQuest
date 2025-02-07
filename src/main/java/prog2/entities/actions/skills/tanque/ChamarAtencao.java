package prog2.entities.actions.skills.tanque;

import prog2.entities.Player;
import prog2.entities.actions.Action;

public class ChamarAtencao extends Action {
    private static final int custo = 5;

    public ChamarAtencao(Player origem) {
        super(origem, origem);
    }

    @Override
    public void execute() {
        Player origem = getOrigem();

        // TODO: CRIAR ATRIBUTO MANA NA CLASSE PLAYER
        // TODO: ADICIONAR ATRIBUTO DE AMEAÇA
    }
}
