package Java.code.ctci.source.ch_16_Moderate.q16_04_Tic_Tac_Win;

public record Position(int row, int column) {
    public int column() {
        return this.column;
    }

    public int row() {
        return this.row;
    }
}
