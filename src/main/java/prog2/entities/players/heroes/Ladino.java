package prog2.entities.players.heroes;

import prog2.entities.actions.skills.ladino.AtaqueEscondido;

import java.io.Serial;

public class Ladino extends Hero {
    @Serial
    private static final long serialVersionUID = 1L;

    public Ladino(String nome) {
        super(nome,
                10,
                10,
                0,
                0,
                12,
                2,
                1,
                1,
                10,
                new AtaqueEscondido());
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
