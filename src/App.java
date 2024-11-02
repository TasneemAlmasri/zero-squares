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

        // BRING THE BOARD
        Boards boards = new Boards();
        String[][] board = boards.getBoard(level);

        // send it to the state class to let it deal with it within its functions(print
        // for ex)
        State state = new State(board);
        state.printBoard();

        MoveLogic moveLogic = new MoveLogic(state,level);

        // print to user
        System.out.println("Use 'w' for UP, 'a' for LEFT, 's' for DOWN, 'd' for RIGHT. Press 'q' to quit.");

        // loop for user input
        while (true) {
            System.out.print("Enter a direction: ");
            char input = scanner.next().charAt(0);

            switch (input) {
                case 'a': // left
                    moveLogic.moveAllColors('l');
                    break;
                case 'd': // right
                    moveLogic.moveAllColors('r');
                    break;
                case 'w': // up
                    moveLogic.moveAllColors('u');
                    break;
                case 's': // down
                    moveLogic.moveAllColors('d');
                    break;
                case 'q': // quit
                    System.out.println("Exiting game.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid input. Use 'w', 'a', 's', 'd' to move, or 'q' to quit.");
                    continue;
            }
            // Print the updated board after each move
            state.printBoard();

            // Check if the game is final
            if (moveLogic.isFinal(state.board)) {
                scanner.close();


                // String[][]copyFromOriginal= boards.getCopiedBoard(level);
                // for (int i = 0; i < copyFromOriginal.length; i++) {
                //     for (int j = 0; j < copyFromOriginal[i].length; j++) {
                //         System.out.print(copyFromOriginal[i][j] + " ");
                //     }
                //     System.out.println();
                //     //
                // }
                // System.out.println();


                break;
            }

        }


        
    }

}
