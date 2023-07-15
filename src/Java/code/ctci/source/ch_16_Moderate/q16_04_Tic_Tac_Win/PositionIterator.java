package Java.code.ctci.source.ch_16_Moderate.q16_04_Tic_Tac_Win;

import java.util.Iterator;

public class PositionIterator implements Iterator<Position> {
    private final int colIncrement;
    private final int rowIncrement;
    private final int size;
    private Position current;

    public PositionIterator(Position p, int rowIncrement, int colIncrement, int size) {
        this.rowIncrement = rowIncrement;
        this.colIncrement = colIncrement;
        this.size = size;
        current = new Position(p.row() - rowIncrement, p.column() - colIncrement);
    }

    @Override
    public boolean hasNext() {
        return current.row() + rowIncrement < size && current.column() + colIncrement < size;
    }

    @Override
    public Position next() {
        current = new Position(current.row() + rowIncrement, current.column() + colIncrement);
        return current;
    }
}
