package game.run;

import game.board.GameBoard;
import game.board.boardInterface;
import game.player.*;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        int row = 3;
        int col = 3;
        int playerCount = 2;
        boardInterface board = new GameBoard(row, col);

        ArrayList <PlayMan> players = new ArrayList<PlayMan>();
        gameReferee referee = new SideMan(-1);

        initPlayer(players, playerCount);

        for(int turn = 0; turn < row*col; turn++){
            ((viewBoard) referee).printBoard(board);
            gamePlayer nowPlayer = referee.nextPlayer(players);
            nowPlayer.myTurn(board);

            if(referee.checkEndGame(board)){
                ((viewBoard) referee).printBoard(board);
                System.out.printf("%s is win\n", nowPlayer.getRealName());
                return;
            }
        }

        ((viewBoard) referee).printBoard(board);
        System.out.printf("draw");
    }

    private static void initPlayer(ArrayList <PlayMan> players, int playerCount){
        for(int i=0; i < playerCount; i++){
            if(i == 0){
                players.add(new PlayMan(1, 'X', "철수"));
            }
            if(i == 1){
                players.add(new PlayMan(5, 'O', "영희"));
            }
//            if(i == 2){
//                players.add(new playMan(3, '!', "명수"));
//            }
        }
    }
}
