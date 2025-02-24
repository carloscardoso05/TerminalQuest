package prog2.entities.players.heroes;

import prog2.entities.actions.skills.guerreiro.AtaqueAtordoante;

public class Guerreiro extends Hero {

    public Guerreiro(String nome) {
        super(nome, 40, 40, 16, 14, 12, 14, 1, 1, 3, new AtaqueAtordoante()); // TODO coloquei os últimos dois temporariamente
    }
}
