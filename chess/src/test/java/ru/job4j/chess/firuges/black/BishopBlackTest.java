package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    void whenPositionThenGetOccupiedCell() {
        Cell position = Cell.findBy(1, 1);
        Figure blackBishop = new BishopBlack(position);
        assertThat(blackBishop.position()).isEqualTo(Cell.B7);
    }

    @Test
    void whenWayThenArrayOfDiagonalCells() {
        Figure bishop = new BishopBlack(Cell.C1);
        Cell[] expected = {Cell.D2, Cell.E3, Cell.F4, Cell.G5,};
        assertThat(expected).containsExactly(bishop.way(Cell.G5));
    }

    @Test
    void whenMoveByDiagonalThenTrue() {
        Figure bishop = new BishopBlack(Cell.C1);
        assertThat(new BishopBlack(bishop.position()).isDiagonal(bishop.position(), Cell.F4)).isTrue();
    }

    @Test
    void whenCopyThenGetNewFigure() {
        Cell destPosition = Cell.findBy(1, 3);
        Figure srcFigure = new BishopBlack(Cell.findBy(1, 1));
        assertThat(Cell.B5).isEqualTo(srcFigure.copy(destPosition).position());
    }
}