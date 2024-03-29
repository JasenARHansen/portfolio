package Java.code.ctci.source.ch_17_Hard.q17_13_ReSpace;

@SuppressWarnings("MethodDoesntCallSuperMethod")
public class ParseResult {
    public final int invalid;
    public final String parsed;

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

    @Override
    public boolean equals(Object o) {
        return (o instanceof ParseResult)
                && (((ParseResult) o).invalid == this.invalid)
                && (((ParseResult) o).parsed.equals(this.parsed));
    }

    public ParseResult clone() {
        return new ParseResult(this.invalid, this.parsed);
    }

    @Override
    public String toString() {
        return "(" + this.invalid + ", " + this.parsed + ")";
    }
}
