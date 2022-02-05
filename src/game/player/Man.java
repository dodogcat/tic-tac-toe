package game.player;

import game.board.GameBoard;

public class Man {
    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void printboard(GameBoard board){
        board.PrintBoard();
    }
}
