package prog2.game;

import prog2.entities.Hero;
import prog2.entities.Monster;
import prog2.entities.Player;
import prog2.util.ToString;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Turno implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private int turnNumber;

    public void nextTurn() {
        // Lógica de turno
        turnNumber += 1;
    }

    public List<Player> getPlayerEmOrdemDeAcao() {
        final List<Player> players = new ArrayList<>(getPlayers());
        players.sort((p1, p2) -> Integer.compare(p2.getVelocidade(), p1.getVelocidade()));
        return players;
    }

    private final List<Player> players = new ArrayList<>();

    public List<Player> getPlayers() {
        return List.copyOf(players);
    }

    public List<Monster> getMonsters() {
        return getPlayers().stream()
                .filter(p -> p instanceof Monster)
                .map(p -> (Monster) p)
                .collect(Collectors.toList());
    }

    public List<Hero> getHeroes() {
        return getPlayers().stream()
                .filter(p -> p instanceof Hero)
                .map(p -> (Hero) p)
                .collect(Collectors.toList());
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

    public void addPlayer(List<Player> players) {
        for (final Player player : players) {
            addPlayer(player);
        }
    }

    public int getTurnNumber() {
        return turnNumber;
    }

    @Override
    public String toString() {
        return ToString.fromGetters(this);
    }
}
