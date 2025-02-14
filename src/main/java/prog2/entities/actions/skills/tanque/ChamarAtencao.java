package prog2.entities.actions.skills.tanque;

import prog2.entities.Player;
import prog2.entities.actions.Action;
import prog2.entities.actions.skills.Skill;

public class ChamarAtencao extends Skill {
    public ChamarAtencao() {
        super("Chamar atenção", 5);
    }

    @Override
    public void execute(Player origem, Player[] alvos) {
        // TODO: CRIAR ATRIBUTO MANA NA CLASSE PLAYER
        // TODO: ADICIONAR ATRIBUTO DE AMEAÇA
    }
}
