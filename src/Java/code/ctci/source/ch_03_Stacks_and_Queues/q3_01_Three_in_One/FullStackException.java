package Java.code.ctci.source.ch_03_Stacks_and_Queues.q3_01_Three_in_One;

import java.io.Serial;

@SuppressWarnings("unused")
public class FullStackException extends Exception {
  @Serial private static final long serialVersionUID = 1L;

  public FullStackException() {
    super();
  }

  public FullStackException(String message) {
    super(message);
  }
}
