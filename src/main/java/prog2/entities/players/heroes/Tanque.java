package prog2.entities.players.heroes;

import prog2.entities.actions.skills.tanque.ChamarAtencao;

public class Tanque extends Hero {

    public Tanque(String nome) {
        super(nome, 50, 50, 16, 18, 8, 10, 1, 1, 4, new ChamarAtencao()); // TODO coloquei os últimos dois temporariamente
    }
}
