package nl.novi.mariannat.exception;

public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;


    public RecordNotFoundException() {
        super("Cannot find specified record.");
    }
}
