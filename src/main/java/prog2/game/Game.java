package prog2.game;

import prog2.entities.Hero;
import prog2.entities.Monster;
import prog2.entities.Player;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final Set<Player> players = new HashSet<>();

    public Set<Player> getPlayers() {
        return Set.copyOf(players);
    }

    public Set<Monster> getMonsters() {
        return getPlayers().stream()
                .filter(p -> p instanceof Monster)
                .map(p -> (Monster) p)
                .collect(Collectors.toSet());
    }

    public Set<Hero> getHeroes() {
        return getPlayers().stream()
                .filter(p -> p instanceof Hero)
                .map(p -> (Hero) p)
                .collect(Collectors.toSet());
    }

    public int getPlayersCount() {
        return getPlayers().size();
    }

    public int getMonstersCount() {
        return getMonsters().size();
    }

    public int getHeroesCount() {
        return getHeroes().size();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }
}
