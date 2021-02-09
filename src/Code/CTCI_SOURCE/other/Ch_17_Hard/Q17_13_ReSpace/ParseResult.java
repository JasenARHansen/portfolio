package Code.CTCI_SOURCE.other.Ch_17_Hard.Q17_13_ReSpace;

public class ParseResult {
  public int invalid;
  public String parsed;

  public ParseResult(int inv, String p) {
    invalid = inv;
    parsed = p;
  }

  public static ParseResult min(ParseResult r1, ParseResult r2) {
    if (r1 == null) {
      return r2;
    } else if (r2 == null) {
      return r1;
    }

    return r2.invalid < r1.invalid ? r2 : r1;
  }

  @SuppressWarnings("MethodDoesntCallSuperMethod")
  public ParseResult clone() {
    return new ParseResult(this.invalid, this.parsed);
  }
}
