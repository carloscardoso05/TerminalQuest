package prog2.game;

public class SemAlvoDisponivelException extends RuntimeException {
    public SemAlvoDisponivelException() {
        super("Não há alvos disponíveis.");
    }
}
