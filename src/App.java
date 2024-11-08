//user interact with this

import java.util.Scanner;

public class App {
    static public void main(String[] args) throws Exception {
        // print for user
        System.out.println();
        System.out.println("Choose a level : ");

        // get from user
        Scanner scanner = new Scanner(System.in);
        int level = scanner.nextInt() - 1;

        // bring the board
        Boards boards = new Boards();
        String[][] board = boards.getBoard(level);// this is original

        // send it to the state class to let it deal with it within its functions(print
        // for ex)
        State initialState = new State(board);
        initialState.printBoard();

        MoveLogic moveLogic = new MoveLogic(initialState, level);

        // print to user
        System.out.println("Use 'w' for UP, 'a' for LEFT, 's' for DOWN, 'd' for RIGHT. Press 'q' to quit.");

        // loop for user input
        while (true) {
            System.out.print("Enter a direction: ");
            char input = scanner.next().charAt(0);

            switch (input) {
                case 'a':
                    // currentState=moveLogic.moveAllColors('l');
                    moveLogic.moveAllColors('l');
                    break;
                case 'd':
                    // currentState=moveLogic.moveAllColors('r');
                    moveLogic.moveAllColors('r');
                    break;
                case 'w':
                    // currentState=moveLogic.moveAllColors('u');
                    moveLogic.moveAllColors('u');
                    break;
                case 's':
                    // currentState=moveLogic.moveAllColors('d');
                    moveLogic.moveAllColors('d');
                    break;
                case '1':
                    System.out.println("This is what your board looks like in case of each move: ");
                    moveLogic.possibleMoves();
                    break;
                case 'y':
                    System.out.println(Boards.initGoals.get(4)); 
                    break;
                case 'q': // quit
                    System.out.println("Exiting game.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input. Use 'w', 'a', 's', 'd' to move, or 'q' to quit.");
                    continue;
            }

            // Check if the game is final
            // if (moveLogic.isFinal(currentState.board)) {
            // scanner.close();
            // break;
            // }

        }

    }

}