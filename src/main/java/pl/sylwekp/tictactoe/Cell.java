package pl.sylwekp.tictactoe;

public class Cell {

    private Sign sign;

    public Cell() {
    }

    public Sign getSign() {
        return sign;
    }

    public void setSign(Sign given) {
        this.sign = given;
    }

    public void clear() {
        this.sign = Sign.EMPTY;
    }
}
