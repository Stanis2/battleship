package lv.tsi.battleship.model;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
@RequestScoped

public class TempShipHolder {
    private Map<String, Boolean> ships = new HashMap<>();

    public void addShip(String addr) {
        ships.put(addr, true);
    }

    public Map<String, Boolean> getShips() {
        return ships;
    }
}
