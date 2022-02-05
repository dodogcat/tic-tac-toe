package game.player;

import game.board.GameBoard;
import game.board.Horse;

import java.util.Scanner;

public interface gamePlayer {
    default void myTurn(GameBoard board){
//        board.PrintBoard();
        placeOnBoard(board);
    }

    default void placeOnBoard (GameBoard board){
        String input = playerInput();
        int[] coordinate = inputToCoordinate(input);
        Horse added = makeNewHorse(coordinate);

        board.ChangeBoard(added);
    }

    Horse makeNewHorse(int[] coordinate);

    static String playerInput(){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        return input;
    }

    default int[] inputToCoordinate(String input){
        // 기본은 2차원에 첫 글자가 알파벳으로 된 열을 표현
        // 두번째 글자는 숫자로 행을 표현

        int[] transfer = new int[input.length()];

        for(int i=0; i < input.length(); i++){
            if(i==0){
                transfer[i] = input.charAt(i) - 'a';
            }
            if(i==1){
                transfer[i] = input.charAt(i) - '1';
            }
        }

        return transfer;
    }
}
