package game.player;

import game.board.GameBoard;
import game.board.Horse;
import game.board.boardInterface;

public class PlayMan extends Man implements gamePlayer, Comparable{
    private int priority;
    private char symbol;

    public PlayMan(int priority, char symbol, String real) {
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
    public void myTurn(boardInterface board) {
        gamePlayer.super.myTurn(board);
    }

    @Override
    public void placeOnBoard(boardInterface board) {
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
        PlayMan a= (PlayMan) o;
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
