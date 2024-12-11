import java.util.ArrayList;
import java.util.List;

public class State {

    State parent = null;
    int cost = 0;
    int heuCost = 0;
    int huer = 0;

    String[][] board;
    
    public List<Point> removedGoals ;
    
    public State(String[][] board,List<Point> removedGoals) {
        this.board = copyBoard(board);
        this.removedGoals = new ArrayList<>(removedGoals);
    }

    private String[][] copyBoard(String[][] original) {
        if (original == null) {
            return null;
        }
        String[][] theCopy = new String[original.length][];
        for (int i = 0; i < original.length; i++) {
            theCopy[i] = original[i].clone();
        }
        return theCopy;
    }

    public State copyState() {
        State newState = new State(this.board,this.removedGoals);
        return newState;
    }

    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].length() == 1) {
                    System.out.print(board[i][j] + "  ");
                } else {
                    System.out.print(board[i][j] + " "); 
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
