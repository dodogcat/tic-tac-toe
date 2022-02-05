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

    public int[] getPosition() {
        return position;
    }
}
