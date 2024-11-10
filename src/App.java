//user interact with this

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List <State>path=new ArrayList<>();
    static public void main(String[] args) throws Exception {
        
        System.out.println();
        System.out.println("Choose a level : ");

        Scanner scanner = new Scanner(System.in);
        int level = scanner.nextInt() - 1;

        System.out.println("Choose 1 for player mode or 2 for computer mode :");
        int mode=scanner.nextInt();

        String[][] board = Boards.getBoard(level);
        State initialState = new State(board);
        initialState.printBoard();

        Player playerMode=new Player(initialState, level, path);
        Algo computerMode=new Algo(initialState, level, path);

        switch (mode) {
            case 1:
            playerMode.playPlayer();
                break;
            case 2:
            computerMode.playComputer();
                break;
            default:
            System.out.println("Wrong Input");
                break;
        }
        scanner.close();
    }

}