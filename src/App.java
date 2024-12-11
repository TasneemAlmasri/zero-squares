import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static List<State> path = new ArrayList<>();

    static public void main(String[] args) throws Exception {

        // PrintStream fileOut = new PrintStream(new File("level 9 after moving removed to state .txt"));
        // System.setOut(fileOut);

        System.out.println();
        System.out.println("Choose a level : ");

        Scanner scanner = new Scanner(System.in);
        int level = scanner.nextInt() - 1;
        String[][] board = Boards.getBoard(level);

        System.out.println("Choose 1 for player mode or 2 for computer mode :");
        int mode = scanner.nextInt();

        State initialState = new State(board, new ArrayList<>());
        initialState.printBoard();

        Player playerMode = new Player(initialState, level, path);
        Algo computerMode = new Algo(initialState, level, path);

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
        // fileOut.close();
    }

}