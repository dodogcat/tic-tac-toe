package game.run;

import game.board.GameBoard;
import game.player.playMan;
import game.player.sideMan;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        GameBoard board = new GameBoard(row, col);

        ArrayList <playMan> players = new ArrayList<playMan>();
        sideMan referee = new sideMan(-1);

        for(int i=0; i < 2; i++){
            if(i == 0){
                players.add(new playMan(1, 'X', "철수"));
            }
            if(i == 1){
                players.add(new playMan(5, 'O', "영희"));
            }
//            if(i == 2){
//                players.add(new playMan(3, '!', "명수"));
//            }
        }


        for(int turn = 0; turn < row*col; turn++){
            referee.printboard(board);
            playMan nowPlayer = referee.nextPlayer(players);
            nowPlayer.myTurn(board);

            if(referee.checkEndGame(board)){
                board.PrintBoard();
                System.out.printf("%s is win\n", nowPlayer.getRealName());
                return;
            }
        }

        referee.printboard(board);
        System.out.printf("draw");
    }
}
