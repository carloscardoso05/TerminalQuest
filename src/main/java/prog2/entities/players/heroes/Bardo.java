package prog2.entities.players.heroes;

import prog2.entities.actions.skills.bardo.Inspiracao;

public class Bardo extends Hero {

    public Bardo(String nome) {
        super(nome, 8, 15, 0, 2, 9, 1, 1, 1, 9, new Inspiracao());
    }
}
