package lv.tsi.battleship.model;

public class Game {
    private User player1;
    private User player2;

    public boolean isCompleted() {
        return player1 != null && player2 != null;
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
}
