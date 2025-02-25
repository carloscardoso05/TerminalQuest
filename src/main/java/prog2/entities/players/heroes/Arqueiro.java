package prog2.entities.players.heroes;

import prog2.entities.actions.skills.arqueiro.AtaqueMultiplo;

public class Arqueiro extends Hero {

    public Arqueiro(String nome) {
        super(nome, 10, 10, 0, 0, 12, 2, 2, 1, 11, new AtaqueMultiplo());
    }


}
