public class State {

    String[][] board;
    // instead of assigning it directly to the board,we ll make a copy of it
    public State(String[][] board) {
        this.board = deepCopyBoard(board);
    }

    private String[][] deepCopyBoard(String[][] original) {
        if (original == null) {
            return null;
        }
        String[][] theCopy = new String[original.length][];
        for (int i = 0; i < original.length; i++) {
            theCopy[i] = original[i].clone();
        }
        return theCopy;
    }

    public String[][] getBoard() {
        return deepCopyBoard(board); // return a copy 
    }

    public void setCell(int row, int col, String value) {
        board[row][col] = value;
    }

    public void printBoard(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
            //
        }
        System.out.println();
    }
}