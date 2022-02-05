package game.board;

public class Horse {
    private char symble;
    private int[] position;

    public Horse(char symble, int[] position) {
        this.symble = symble;
        this.position = position;
    }

    public char getSymble() {
        return symble;
    }

    public void setSymble(char symble) {
        this.symble = symble;
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }
}
