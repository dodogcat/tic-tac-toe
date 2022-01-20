package game.player;

import game.board.GameBoard;

import java.util.Scanner;

public class Player {
    private char name;

    public Player(char name){
        this.name = name;
    }

    public boolean MyTurn(GameBoard board){
        System.out.printf("Next Player: %c\n", name);
        System.out.printf("> ");

        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        board.ChangeBoard(name, input);

        if(board.CheckGameEnd(name) == true){
            return true;
        }
        else{
            return false;
        }
    }

    public char getName() {
        return name;
    }
}
