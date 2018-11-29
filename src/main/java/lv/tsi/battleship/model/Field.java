package lv.tsi.battleship.model;

import java.util.HashMap;
import java.util.Map;

import static lv.tsi.battleship.model.CellState.SHIP;

public class Field {
    private Map<String, CellState> cells = new HashMap<>();

    public void setState (String addr, CellState state) {
        cells.put(addr, state);
    }

    public CellState getState(String addr) {
        return cells.getOrDefault(addr, CellState.EMPTY);
    }

    public boolean hasShips() {
        return cells
                .values()
                .stream()
                .anyMatch(s -> s == SHIP);
    }
}
