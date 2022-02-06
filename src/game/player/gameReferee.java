package game.player;

import game.board.GameBoard;
import game.board.boardInterface;

import java.util.ArrayList;

public interface gameReferee {
    PlayMan nextPlayer(ArrayList<PlayMan> list);

    default boolean checkEndGame(boardInterface board){
        int boardRow = board.getTics().length;
        int boardCol = board.getTics()[0].length;

        if(rowEnd(board.getTics(), boardRow, boardCol)){
            return true;
        }
        if(colEnd(board.getTics(), boardRow, boardCol)){
            return true;
        }
        if(diagonalEnd(board.getTics(), boardRow, boardCol)){
            return true;
        }
        if(diagonalReflexionEnd(board.getTics(), boardRow, boardCol)){
            return true;
        }

        return false;
    }

    default boolean rowEnd(char[][] tics, int boardRow, int boardCol){
        for(int row = 0; row < boardRow; row++){ // 행 체크
            if(oneLineCheck(tics[row])){
                return true;
            }
        }
        return false;
    }

    static boolean oneLineCheck(char[] line){
        if(line[0] == '0'){
            return false;
        }

        for(int i=0; i < line.length - 1; i++){
            if(line[i] != line[i + 1]){
                return false;
            }
        }

        return true;
    }

    default boolean colEnd(char[][] tics, int boardRow, int boardCol){
        for(int col = 0; col < boardCol; col++){ // 열 체크
            // 열 만들기
            char[] column = new char[boardRow];
            for(int row = 0; row < boardRow; row++){
                column[row] = tics[row][col];
            }

            if(oneLineCheck(column)){
                return true;
            }
        }
        return false;
    }

    default boolean diagonalEnd(char[][] tics, int boardRow, int boardCol){
        // 정사각일때만 비교
        if(boardRow != boardCol){
            return false;
        }

        char[] diagonal = new char[boardRow];
        for(int row = 0; row < boardRow; row++){ //  '\'방향 대각선
            diagonal[row] = tics[row][row];
        }

        if(oneLineCheck(diagonal)){
            return true;
        }

        return false;
    }

    default boolean diagonalReflexionEnd(char[][] tics, int boardRow, int boardCol){
        // 정사각일때만 비교
        if(boardRow != boardCol){
            return false;
        }

        char[] diagonal = new char[boardRow];
        for(int row = 0; row < boardRow; row++){ //  '/'방향 대각선
            diagonal[row] = tics[boardRow - 1 - row][row];
        }

        if(oneLineCheck(diagonal)){
            return true;
        }

        return false;
    }
}
