package game.player;

import game.board.boardInterface;

public interface viewBoard {
    default void printBoard(boardInterface board){
        board.PrintBoard();
    }
}
