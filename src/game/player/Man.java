package game.player;

import game.board.GameBoard;
import game.board.boardInterface;

public class Man implements viewBoard{
    private String realName;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Override
    public void printBoard(boardInterface board) {
        viewBoard.super.printBoard(board);
    }
}
