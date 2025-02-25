package prog2.entities.players.heroes;

import prog2.entities.actions.skills.guerreiro.AtaqueAtordoante;

public class Guerreiro extends Hero {

    public Guerreiro(String nome) {
        super(nome, 12, 8, 2, 0, 12, 0, 2, 1, 14, new AtaqueAtordoante());
    }
}
