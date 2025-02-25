package prog2.entities.players.heroes;

import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.tanque.ChamarAtencao;

public class Tanque extends Hero {

    public Tanque(String nome) {
        super(nome,
                15,
                8,
                2,
                0,
                14,
                0,
                1,
                1,
                14,
                new Attack("Espada", 8, 2),
                new ChamarAtencao());
    }

    @Override
    public void subirNivel() {
        setVidaMaxima(getVidaMaxima() + 5);
        setManaMaxima(getManaMaxima() + 3);
        if (getNivel() % 2 == 0) {
            setForcaDeAtaque(getForcaDeAtaque() + 1);
            setDestreza(getDestreza() + 1);
            setDefesa(getDefesa() + 1);
        }
    }
}
