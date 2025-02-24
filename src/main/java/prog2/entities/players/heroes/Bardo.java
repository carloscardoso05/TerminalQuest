package prog2.entities.players.heroes;

import prog2.entities.actions.skills.bardo.Inspiracao;

public class Bardo extends Hero {

    public Bardo(String nome) {
        // TODO colocar valores corretos
        super(nome, 95, 95, 2, 1, 2, 3, 1, 1, 2, new Inspiracao());
    }
}
