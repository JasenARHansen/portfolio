package Java.code.ctci.source.ch_16_Moderate.q16_16_Sub_Sort;

public record Range(int start, int end) {

    public int end() {
        return this.end;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Range other = (Range) obj;
        if (this.end != other.end) return false;
        return this.start == other.start;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + this.end;
        result = prime * result + this.start;
        return result;
    }

    @Override
    public String toString() {
        return "Range [start=" + this.start + ", end=" + this.end + "]";
    }

    public int start() {
        return this.start;
    }
}
