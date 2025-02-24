package prog2.entities.players.heroes;

import prog2.entities.actions.skills.arqueiro.AtaqueMultiplo;

public class Arqueiro extends Hero {
    
    public Arqueiro(String nome){
        super(nome, 30, 30,14, 12, 14, 18, 1, 1, 2, new AtaqueMultiplo()); // TODO coloquei os últimos dois temporariamente
    }


}
