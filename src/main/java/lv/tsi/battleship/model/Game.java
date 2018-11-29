package lv.tsi.battleship.model;

import static lv.tsi.battleship.model.CellState.*;

public class Game {
    private User player1;
    private User player2;
    private boolean player1Turn = true;
    private boolean finished = false;

    private User activeUser() {
        return player1Turn ? player1 : player2; // if true p1, if false p2, p1 (:)or p2
    }

    private User inactiveUser() {
        return !player1Turn ? player1 : player2; // if true p1, if false p2, p1 (:)or p2
    }

    public boolean isCompleted() {
        return player1 != null && player2 != null;
    }

    public boolean isReady() {
        return player1.isReady() && player2.isReady();
    }

    public User getPlayer1() {
        return player1;
    }

    public void setPlayer1(User player1) {
        this.player1 = player1;
    }

    public User getPlayer2() {
        return player2;
    }

    public void setPlayer2(User player2) {
        this.player2 = player2;
    }

    public boolean isPlayer1Turn() {
        return player1Turn;
    }

    public boolean isFinished() {
        return finished;
    }

    public void fire(String addr) {
        CellState state = inactiveUser().getMyField().getState(addr);
        if (state == SHIP) {
            inactiveUser().getMyField().setState(addr, HIT);
            activeUser().getEnemyField().setState(addr, HIT);
            checkWin();
            return;
        } else if (state == EMPTY) {
            inactiveUser().getMyField().setState(addr, MISS);
            activeUser().getEnemyField().setState(addr, MISS);
        }
        player1Turn = !player1Turn;
    }

    private void checkWin() {
        if (!inactiveUser().getMyField().hasShips()) {
            activeUser().setWinner(true);
            inactiveUser().setLoser(true);
            finished = true;
        }
    }
}
