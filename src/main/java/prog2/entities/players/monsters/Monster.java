package prog2.entities.players.monsters;

import org.fusesource.jansi.Ansi;
import prog2.entities.actions.skills.Skill;
import prog2.entities.players.Player;

public class Monster extends Player {
    public Monster(String nome, int vidaMaxima, int manaMaxima, int forcaDeAtaque, int inteligencia, int defesa, int velocidade, int destreza, int nivel, int ameaca, Skill habilidade) {
        super(nome, vidaMaxima, manaMaxima, forcaDeAtaque, inteligencia, defesa, velocidade, destreza, nivel, ameaca, habilidade);
    }

    @Override
    public String toString() {
        return Ansi.ansi().fgRgb(0xff9545).a(super.toString()).reset().toString();
    }
}
