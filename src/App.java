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

        Boards boards = new Boards();
        String[][] board = boards.getBoard(level);

        State initialState = new State(board);
        initialState.printBoard();

        MoveLogic moveLogic = new MoveLogic(initialState, level);

        System.out.println("Use 'w' for UP, 'a' for LEFT, 's' for DOWN, 'd' for RIGHT, '1' for help. Press 'q' to quit.");

        while (true) {
            System.out.print("Enter a direction: ");
            char input = scanner.next().charAt(0);

            switch (input) {
                case 'a':
                    // currentState=moveLogic.moveAllColors('l');
                    path.add(moveLogic.moveAllColors('l',false)); 
                    break;
                case 'd':
                    // currentState=moveLogic.moveAllColors('r');
                    path.add(moveLogic.moveAllColors('r',false));
                    break;
                case 'w':
                    // currentState=moveLogic.moveAllColors('u');
                    path.add(moveLogic.moveAllColors('u',false));
                    break;
                case 's':
                    // currentState=moveLogic.moveAllColors('d');
                    path.add(moveLogic.moveAllColors('d',false));
                    break;
                case '1':
                    System.out.println("These are the possible moves: ");
                    moveLogic.possibleMoves();
                    break;
                case 'p':
                    moveLogic.printPath();
                    break;
                case 'q': // quit
                    System.out.println("Exiting game.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input. Use 'w', 'a', 's', 'd' to move,'1' for help, or 'q' to quit.");
                    continue;
            }
        }

    }

}