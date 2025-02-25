package prog2.entities.players.heroes;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.arqueiro.AtaqueMultiplo;

public class Arqueiro extends Hero {

    public Arqueiro(String nome) {
        super(nome,
                10,
                10,
                0,
                0,
                12,
                2,
                2,
                1,
                11,
                new Attack("Arco e flecha", 8, 2),
                new AtaqueMultiplo());
    }

    @Override
    public void subirNivel() {
        setVidaMaxima(getVidaMaxima() + 4);
        setManaMaxima(getManaMaxima() + 4);
        if (getNivel() % 2 == 0) {
            setVelocidade(getVelocidade() + 1);
            setDestreza(getDestreza() + 1);
            setDefesa(getDefesa() + 1);
        }
    }
}
