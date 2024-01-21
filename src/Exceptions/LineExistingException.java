package Exceptions;

public class LineExistingException extends Throwable {
    public LineExistingException(String message) {
        super("Ошибка: " + message);
    }
}
