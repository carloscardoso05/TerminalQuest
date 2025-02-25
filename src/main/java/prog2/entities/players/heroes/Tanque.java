package prog2.entities.players.heroes;

import prog2.entities.actions.skills.tanque.ChamarAtencao;

public class Tanque extends Hero {

    public Tanque(String nome) {
        super(nome, 15, 8, 2, 0, 14, 0, 1, 1, 14, new ChamarAtencao());
    }
}
