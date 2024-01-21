package Exceptions;

public class StationExistingException extends Throwable {
    public StationExistingException(String message) {
        super("Ошибка: " + message);
    }
}
