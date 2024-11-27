public class State {

    State parent=null;
    int cost=0;

    String[][] board;
    
    public State(String[][] board) {
        this.board = copyBoard(board);
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
        return new State(this.board);
    }

    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j].length()==1){
                    System.out.print(board[i][j] + "  ");
                }else{
                   System.out.print(board[i][j] + " "); 
                }
                
            }
            System.out.println();
            //
        }
        System.out.println();
    }
}
