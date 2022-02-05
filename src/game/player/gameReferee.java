package game.player;

import game.board.GameBoard;

import java.util.ArrayList;

public interface gameReferee {
    playMan nextPlayer(ArrayList<playMan> list);

    default boolean checkEndGame(GameBoard board){
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

    static boolean rowEnd(char[][] tics, int boardRow, int boardCol){
        for(int row = 0; row < boardRow; row++){ // 행 체크
            if(tics[row][0] == '0'){
                continue;
            }
            boolean check = true;
            for(int col = 0; col < boardCol - 1; col++){
                if(tics[row][col] != tics[row][col + 1]){
                    check = false;
                    break;
                }
            }
            if(check){
                return true;
            }
        }
        return false;
    }

    static boolean colEnd(char[][] tics, int boardRow, int boardCol){
        for(int col = 0; col < boardCol; col++){ // 행 체크
            if(tics[0][col] == '0'){
                continue;
            }
            boolean check = true;
            for(int row = 0; row < boardRow - 1; row++){
                if(tics[row][col] != tics[row + 1][col]){
                    check = false;
                    break;
                }
            }
            if(check){
                return true;
            }
        }
        return false;
    }

    static boolean diagonalEnd(char[][] tics, int boardRow, int boardCol){
        // 정사각일때만 비교
        if(boardRow != boardCol){
            return false;
        }

        for(int row = 0; row < boardRow - 1; row++){ //  '\'방향 대각선
            if(tics[0][0] == '0'){
                return false;
            }
            if(tics[row][row] != tics[row + 1][row + 1]){
                return false;
            }
        }
        return true;
    }

    static boolean diagonalReflexionEnd(char[][] tics, int boardRow, int boardCol){
        // 정사각일때만 비교
        if(boardRow != boardCol){
            return false;
        }

        for(int row = 0; row < boardRow - 1; row++){ //  '/'방향 대각선
            if(tics[(boardRow - 1)][0] == '0'){
                return false;
            }
            if(tics[(boardRow - 1) - row][row] != tics[(boardRow - 1) - row - 1][row + 1]){
                return false;
            }
        }

        return true;
    }
}
