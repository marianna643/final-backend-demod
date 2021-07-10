package nl.novi.mariannat.exception;

public class DatabaseErrorException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DatabaseErrorException() {
        super("There is a problem in database");
    }
}
