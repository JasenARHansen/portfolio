package CTCI_SOURCE.Ch_03_Stacks_and_Queues;

import java.io.Serial;

public class Q3_01_Three_in_One_FullStackException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public Q3_01_Three_in_One_FullStackException() {
        super();
    }

    public Q3_01_Three_in_One_FullStackException(String message) {
        super(message);
    }
}
