package pl.sylwekp.tictactoe;

public enum Sign {
    EMPTY("-"),
    PLAYER_O("O"),
    PLAYER_X("X");

    private String sign;

    Sign(String sign) {
        this.sign = sign;
    }

    public String getSign() {
        return sign;
    }
}
