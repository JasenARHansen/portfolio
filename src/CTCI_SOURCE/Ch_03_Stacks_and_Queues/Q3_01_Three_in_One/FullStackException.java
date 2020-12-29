package CTCI_SOURCE.Ch_03_Stacks_and_Queues.Q3_01_Three_in_One;

import java.io.Serial;

public class FullStackException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public FullStackException() {
        super();
    }

    public FullStackException(String message) {
        super(message);
    }
}
