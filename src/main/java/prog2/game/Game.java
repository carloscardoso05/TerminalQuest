package prog2.game;

import org.fusesource.jansi.Ansi;
import prog2.entities.players.heroes.*;
import prog2.game.log.Log;
import prog2.util.ScannerUtil;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final Turno turno = new Turno();
    private int qtdTurnos;
    private int qtdBatalhas;
    private final Log log = Log.getInstance();
    private final String name;
    private static final int PARTY_SIZE = 4;

    public Game(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Turno getTurno() {
        return turno;
    }

    public void run() {
        if (turno.getTurnNumber() == 1) {
            turno.setDifficulty(getDificuldade());
            turno.addPlayer(createParty());
            qtdBatalhas++;
            System.out.println(Ansi.ansi()
                    .bold()
                    .a("=============== Batalha %s ===============".formatted(qtdBatalhas))
                    .reset());
            turno.nextTurn();
            qtdTurnos++;
        }
        while (turno.hasNextTurn()) {
            if (turno.getTurnNumber() == 1) {
                qtdBatalhas++;
                System.out.println(Ansi.ansi()
                        .bold()
                        .a("=============== Batalha %s ===============".formatted(qtdBatalhas))
                        .reset());
            }
            System.out.println("Pressione Enter para ir para o próximo turno.");
//            new java.util.Scanner(System.in).nextLine();
            turno.nextTurn();
            qtdTurnos++;
        }
        Log.getInstance().game(
                Ansi.ansi().bold().a(
                        "=============== Fim de jogo ===============\n"
                                + "Batalhas jogadas: %s\n".formatted(qtdBatalhas)
                                + "Turnos jogados: %s\n".formatted(qtdTurnos)
                ).reset()
        );
        Log.getInstance().export();
    }

    public Difficulty getDificuldade() {
        int dificuldade = ScannerUtil.getInt("Insira a dificuldade do jogo:\n" +
                        "1. FÁCIL\n" +
                        "2. MÉDIO\n" +
                        "3. DIFÍCIL",
                input -> {
                    if (input < 1 || input > 3) {
                        return "insira uma opção válida";
                    }
                    return null;
                });
        return Difficulty.values()[dificuldade - 1];
    }

    public List<Hero> createParty() {
        List<Hero> heroes = new ArrayList<>();
        List<String> nomes = new ArrayList<>();
        List<Integer> classes = new ArrayList<>();

        for (int i = 0; i < PARTY_SIZE; i++) {
            int classe = ScannerUtil.getInt("Insira a classe do personagem\n" +
                            "1. Arqueiro\n" +
                            "2. Bardo\n" +
                            "3. Guerreiro\n" +
                            "4. Ladino\n" +
                            "5. Mago\n" +
                            "6. Tanque",
                    input -> {
                        if (classes.contains(input)) {
                            return "classe já utilizada";
                        }
                        if (input < 1 || input > 6) {
                            return "selecione uma opção válida";
                        }
                        return null;
                    });
            String nome = ScannerUtil.getString(
                    "Insira o nome para o personagem (deixe em branco para usar o nome padrão):",
                    input -> {
                        if (nomes.contains(input) && !input.isBlank()) {
                            return "nome ja utilizado";
                        }
                        return null;
                    });
            classes.add(classe);
            nomes.add(nome);
            switch (classe) {
                case 1:
                    heroes.add(new Arqueiro(nome));
                    break;
                case 2:
                    heroes.add(new Bardo(nome));
                    break;
                case 3:
                    heroes.add(new Guerreiro(nome));
                    break;
                case 4:
                    heroes.add(new Ladino(nome));
                    break;
                case 5:
                    heroes.add(new Mago(nome));
                    break;
                case 6:
                    heroes.add(new Tanque(nome));
            }
        }
        return heroes;
    }
}
