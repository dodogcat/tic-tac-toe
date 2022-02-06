package game.player;

import game.board.GameBoard;
import game.board.boardInterface;

import java.util.ArrayList;
import java.util.Collections;

public class SideMan extends Man implements gameReferee{
    int beforePriority;

    public SideMan(int beforePriority) {
        this.beforePriority = beforePriority;
    }

    @Override
    public PlayMan nextPlayer(ArrayList<PlayMan> list) {
        // 정렬 후 우선순위에 따라 다음 순서 정해줌
        Collections.sort(list);

        for(int i=0; i < list.size(); i++) {
            if (list.get(i).getPriority() > beforePriority) {
                beforePriority = list.get(i).getPriority();
                System.out.printf("Next Player: %s\n", list.get(i).getRealName());
                System.out.printf("> ");

                return list.get(i);
            }
        }

        // 한바퀴 돌면 처음부터
        beforePriority = list.get(0).getPriority();
        System.out.printf("Next Player: %s\n", list.get(0).getRealName());
        System.out.printf("> ");

        return list.get(0);
    }

    @Override
    public boolean checkEndGame(boardInterface board) {
        return gameReferee.super.checkEndGame(board);
    }
}
