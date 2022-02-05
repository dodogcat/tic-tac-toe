package game.player;

import game.board.GameBoard;
import game.board.Horse;

public class playMan extends Man implements gamePlayer, Comparable{
    public int priority;
    public char symbol;

    public playMan(int priority, char symbol, String real) {
        this.priority = priority;
        this.symbol = symbol;
        this.setRealName(real);
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void myTurn(GameBoard board) {
        gamePlayer.super.myTurn(board);
    }

    @Override
    public void placeOnBoard(GameBoard board) {
        gamePlayer.super.placeOnBoard(board);
    }

    @Override
    public Horse makeNewHorse(int[] coordinate) {
        return new Horse(symbol, coordinate);
    }

    @Override
    public int[] inputToCoordinate(String input) {
        return gamePlayer.super.inputToCoordinate(input);
    }

    @Override
    public int compareTo(Object o) {
        playMan a= (playMan) o;
        if(a.getPriority() < priority){
            return 1;
        }
        else if(a.getPriority() == priority){
            return 0;
        }
        else{
            return -1;
        }
    }
}
