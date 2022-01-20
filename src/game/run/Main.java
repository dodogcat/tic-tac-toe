package game.run;

import game.board.GameBoard;
import game.player.Player;

public class Main {

    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        GameBoard board = new GameBoard(row, col);
        Player p1 = new Player('X');
        Player p2 = new Player('O');

        for(int turn = 0; turn < row*col; turn++){
            board.PrintBoard();
            Player nextPlayer;
            if(turn % 2 == 0){
                nextPlayer = p1;
            }
            else{
                nextPlayer = p2;
            }

            boolean gameEnd;
            gameEnd = nextPlayer.MyTurn(board);

            if(gameEnd == true){
                board.PrintBoard();
                System.out.printf("%c is win\n", nextPlayer.getName());
                return;
            }
        }

        board.PrintBoard();
        System.out.printf("draw");
    }
}
