package game.board;

public class GameBoard {
    private int boardRow;
    private int boardCol;
    private char[][] tics;
    private char[][] boardLayout;

    public GameBoard(int boardRow, int boardCol) {
        this.boardRow = boardRow;
        this.boardCol = boardCol;

        this.tics = new char[boardRow][boardCol];
        this.boardLayout = new char[boardRow * 3 + 1][boardCol * 6];

        initBoard();
    }

    private void initBoard(){
        for(int row = 0; row < boardRow; row++){
            for(int col = 0; col < boardCol; col++){
                tics[row][col] = '0';
            }
        }

        char colIndex = 'a';
        char rowIndex = '1';
        for(int row = 0; row < boardRow * 3 + 1; row++){
            for(int col = 0; col < boardCol * 6; col++){
                boardLayout[row][col] = ' '; //초기화 용으로 일단 넣기

                
                if(row == 0){   // a      b      c  setting
                    if((col - 3) % 6 == 0){
                        boardLayout[row][col] = colIndex;
                        colIndex++;
                        continue;
                    }
                }
                if((row - 1) % 3 == 0){    // | 만 있는 행 세팅
                    if(col == 0){
                        continue;
                    }
                    if(col % 6 == 0){
                        boardLayout[row][col] = '|';
                        continue;
                    }
                }
                if((row - 1) % 3 == 1){     // 행 숫자 있는 곳 세팅
                    if(col == 0){
                        boardLayout[row][col] = rowIndex;
                        rowIndex++;
                        continue;
                    }
                    if(col % 6 == 3){
                        boardLayout[row][col] = '-';
                        continue;
                    }
                    if(col % 6 == 0){
                        boardLayout[row][col] = '|';
                        continue;
                    }
                }
                if((row - 1) % 3 == 2){    // | 만 있는 행 세팅
                    if(col == 0){
                        continue;
                    }
                    if(col % 6 == 0){
                       boardLayout[row][col] = '|';
                       continue;
                    }
                    else{
                        if(row == boardRow * 3 ){   // 마지막 줄은 패스
                            continue;
                        }
                        boardLayout[row][col] = '_';
                        continue;
                    }
                }
            }
        }
    }

    public void PrintBoard() {
        for (int row = 0; row < boardRow * 3 + 1; row++) {
            System.out.println(boardLayout[row]);
//            for (int col = 0; col < boardCol * 6; col++) {
//                System.out.printf(String.valueOf(boardLayout[row][col]));
//            }
//            System.out.printf("\n");
        }
    }

    public void ChangeBoard(char player, String position){
        int inRow = position.charAt(1) - '1';
        int inCol = position.charAt(0) - 'a';

        tics[inRow][inCol] = player;
        boardLayout[inRow * 3 + 2][inCol * 6 + 3] = player;
    }

    public boolean CheckGameEnd(char player){
        for(int row = 0; row < boardRow; row++){ // 행 체크
            boolean End = true;
            for(int col = 0; col < boardCol; col++){
                if(tics[row][col] != player){
                    End = false;
                    break;
                }
            }
            if (End == true){
                return true;
            }
        }

        for(int col = 0; col < boardCol; col++){ // 열 체크
            boolean End = true;
            for(int row = 0; row < boardRow; row++){
                if(tics[row][col] != player){
                    End = false;
                    break;
                }
            }
            if (End == true){
                return true;
            }
        }

        if(boardCol == boardRow){ //정사각행렬이면 대각선도 체크
            boolean End = true; //  남동풍 방향
            for(int row = 0; row < boardRow; row++){
                if(tics[row][row] != player){
                    End = false;
                    break;
                }
            }
            if (End == true){
                return true;
            }

            End = true; //  북동풍 방향
            for(int row = 0; row < boardRow; row++){
                if(tics[boardRow - 1 - row][row] != player){
                    End = false;
                    break;
                }
            }
            if (End == true){
                return true;
            }
        }

        return false;
    }
}
