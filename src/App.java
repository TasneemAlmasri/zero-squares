import java.util.Scanner;
public class App {
     static   public void main(String[] args) throws Exception {
        //print for user
        System.out.println();
        System.out.println("Choose a level : ");

        //get from user
        Scanner scanner = new Scanner(System.in);
        int level=scanner.nextInt()-1;

        //BRING THE BOARD
        Boards boards=new Boards();
        String[][] board =boards.getBoard(level);

        //send it to the state class to let it deal with it within its functions(print for ex)
        State state = new State(board);
        state.printBoard();


        MoveLogic moveLogic=new MoveLogic(state);
        moveLogic.moveAllColors('l');
        scanner.close();
    }
   
    
}
