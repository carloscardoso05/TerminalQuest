package prog2.entities.players.heroes;

import prog2.entities.actions.skills.mago.BolaDeFogo;

public class Mago extends Hero {
    public Mago(String nome) {
        super(nome,
                8,
                15,
                0,
                2,
                9,
                1,
                0,
                1,
                8,
                new BolaDeFogo());
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
