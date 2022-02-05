package game.player;

import game.board.GameBoard;

import java.util.ArrayList;
import java.util.Collections;

public class sideMan extends Man implements gameReferee{
    int beforePriority;

    public sideMan(int beforePriority) {
        this.beforePriority = beforePriority;
    }

    @Override
    public playMan nextPlayer(ArrayList<playMan> list) {
        Collections.sort(list);

        for(int i=0; i < list.size(); i++) {
            if (list.get(i).priority > beforePriority) {
                beforePriority = list.get(i).priority;
                System.out.printf("Next Player: %s\n", list.get(i).getRealName());
                System.out.printf("> ");


                return list.get(i);
            }
        }

        // 한바퀴 돌면 처음부터
        beforePriority = list.get(0).priority;
        System.out.printf("Next Player: %s\n", list.get(0).getRealName());
        System.out.printf("> ");

        return list.get(0);
    }

    @Override
    public boolean checkEndGame(GameBoard board) {
        return gameReferee.super.checkEndGame(board);
    }
}
