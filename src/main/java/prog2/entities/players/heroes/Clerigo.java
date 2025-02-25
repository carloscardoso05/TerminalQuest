package prog2.entities.players.heroes;


import prog2.entities.actions.attack.Attack;
import prog2.entities.actions.skills.clerigo.Cura;

public class Clerigo extends Hero{
    public Clerigo(String nome) {
        super(nome,
                10,
                15,
                1,
                2,
                12,
                0,
                1,
                1,
                10,
                new Attack("Martelo de guerra", 8, 1),
                new Cura());
    }

    @Override
    public void subirNivel() {
        setVidaMaxima(getVidaMaxima() + 4);
        setManaMaxima(getManaMaxima() + 5);
        if (getNivel() % 2 == 0) {
            setInteligencia(getInteligencia() + 1);
            setForcaDeAtaque(getForcaDeAtaque() + 1);
            setDefesa(getDefesa() + 1);
        }
    }
}
