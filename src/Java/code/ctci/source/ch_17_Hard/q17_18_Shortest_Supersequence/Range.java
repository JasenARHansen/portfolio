package Java.code.ctci.source.ch_17_Hard.q17_18_Shortest_Supersequence;

public class Range {
    private final int end;
    private final int start;

    public Range(int s, int e) {
        start = s;
        end = e;
    }

    public int getEnd() {
        return end;
    }

    public int getStart() {
        return start;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + end;
        result = prime * result + start;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Range other = (Range) obj;
        if (end != other.end) return false;
        return start == other.start;
    }

    @Override
    public String toString() {
        return "Range [start=" + start + ", end=" + end + "]";
    }

    public boolean shorterThan(Range other) {
        return length() < other.length();
    }

    public int length() {
        return end - start + 1;
    }
}
