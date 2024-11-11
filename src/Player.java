import java.util.List;
import java.util.Scanner;

public class Player {

    State initialState;
    int level;
    List <State>path;

    Player(State initialState,int level,List <State>path){
        this.initialState=initialState;
        this.level=level;
        this.path=path;
    }

    public void playPlayer(){

        Scanner scanner = new Scanner(System.in);
        MoveLogic moveLogic = new MoveLogic(initialState, level);
        
        System.out.println("press 'w' for up, 'a' for left, 's' for down, 'd' for right, '1' for help . Press 'q' to quit.");

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
                    moveLogic.nexStates(true);
                    break;
                case 'p':
                    moveLogic.printPath(path);
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
