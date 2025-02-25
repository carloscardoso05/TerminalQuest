package prog2.entities.players.heroes;

import org.fusesource.jansi.Ansi;
import prog2.entities.actions.skills.Skill;
import prog2.entities.players.Player;

public abstract class Hero extends Player {
    public Hero(String nome, int vidaMaxima, int manaMaxima, int forcaDeAtaque, int inteligencia, int defesa, int velocidade, int destreza, int nivel, int ameaca, Skill habilidade) {
        super(nome, vidaMaxima, manaMaxima, forcaDeAtaque, inteligencia, defesa, velocidade, destreza, nivel, ameaca, habilidade);
    }

    @Override
    public String toString() {
        return Ansi.ansi().fgBlue().a(super.toString()).reset().toString();
    }

    public void recuperarPontos() {
        setVidaAtual(Math.min(getVidaMaxima(), (int) (getVidaAtual() * 1.7)));
        setManaAtual(Math.min(getManaMaxima(), (int) (getManaAtual() * 1.7)));
    }

    public abstract void subirNivel();
}
