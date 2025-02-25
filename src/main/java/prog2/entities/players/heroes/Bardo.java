package prog2.entities.players.heroes;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.bardo.Inspiracao;

public class Bardo extends Hero {

    public Bardo(String nome) {
        super(nome, 8,
                15,
                0,
                2,
                9,
                1,
                1,
                1,
                9,
                new Attack("Alaúde", 6, 2),
                new Inspiracao());
    }

    @Override
    public void subirNivel() {
        setVidaMaxima(getVidaMaxima() + 3);
        setManaMaxima(getManaMaxima() + 5);
        if (getNivel() % 2 == 0) {
            setInteligencia(getInteligencia() + 1);
            setVelocidade(getVelocidade() + 1);
            setDefesa(getDefesa() + 1);
        }
    }
}
