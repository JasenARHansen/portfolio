package CTCI_SOURCE.unprocessed.Ch_16_Moderate;

import java.util.Iterator;

public class Q16_04_Tic_Tac_Win_PositionIterator implements Iterator<Q16_04_Tic_Tac_Win_Position> {
    private final int rowIncrement;
    private final int colIncrement;
    private final int size;
    private Q16_04_Tic_Tac_Win_Position current;

    public Q16_04_Tic_Tac_Win_PositionIterator(Q16_04_Tic_Tac_Win_Position p, int rowIncrement, int colIncrement, int size) {
        this.rowIncrement = rowIncrement;
        this.colIncrement = colIncrement;
        this.size = size;
        current = new Q16_04_Tic_Tac_Win_Position(p.row - rowIncrement, p.column - colIncrement);
    }

    @Override
    public boolean hasNext() {
        return current.row + rowIncrement < size && current.column + colIncrement < size;
    }

    @Override
    public Q16_04_Tic_Tac_Win_Position next() {
        current = new Q16_04_Tic_Tac_Win_Position(current.row + rowIncrement, current.column + colIncrement);
        return current;
    }
}
