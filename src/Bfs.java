import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {

    State currentState;
    Queue<State>queue = new LinkedList<>();
    List<State> visited = new ArrayList<>();
    List<State> path = new ArrayList<>();
    MoveLogic moveLogic;
    int level;

    Bfs(State iniState, int level) {
        this.currentState=iniState;
        queue.add(currentState);
        this.moveLogic = new MoveLogic(iniState, level);
        this.level=level;
    }

    List<State> bfsOn() {
        while (!queue.isEmpty()) {
            // System.out.println("I am in the while loop");
            currentState = queue.poll();
            
            System.out.println("gonna add this to visited");
            moveLogic.printBoard(currentState.board);
            visited.add(currentState);

            if (moveLogic.isFinal(currentState.board, false)) {
                // System.out.println("i am in the if final case");
                path.add(currentState);
                while (currentState.parent != null) {
                    currentState = currentState.parent;
                    path.add(currentState);
                }
                break;
            } else {
                // System.out.println("i am in the else(not final) case ");
                List<State> children = new MoveLogic(currentState,level).nexStates( false);
                // System.out.println("children length is "+children.size());
                for (State child : children) {
                    child.parent=currentState;
                    if (!moveLogic.isVisited(visited,child )) {
                        // System.out.println("not visiteddddddddddddddddddddddd");
                        queue.add(child);

                    }
                }
            }
        }
        System.out.println("\n\nVisited states count is "+visited.size());
        System.out.println("Path length is "+path.size());
        return path;
    }

}





//لما ضيف عند البوش
// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Queue;

// public class Bfs {

//     State currentState;
//     Queue<State>queue = new LinkedList<>();
//     List<State> visited = new ArrayList<>();
//     List<State> path = new ArrayList<>();
//     MoveLogic moveLogic;
//     int level;

//     Bfs(State iniState, int level) {
//         this.currentState=iniState;
//         queue.add(currentState);
//         visited.add(currentState);
//         this.moveLogic = new MoveLogic(iniState, level);
//         this.level=level;
//     }

//     List<State> bfsOn() {
//         while (!queue.isEmpty()) {
//             // System.out.println("I am in the while loop");
//             currentState = queue.poll();
            
//             if (moveLogic.isFinal(currentState.board, false)) {
//                 // System.out.println("i am in the if final case");
//                 path.add(currentState);
//                 while (currentState.parent != null) {
//                     currentState = currentState.parent;
//                     path.add(currentState);
//                 }
//                 break;
//             } else {
//                 // System.out.println("i am in the else(not final) case ");
//                 List<State> children = new MoveLogic(currentState,level).nexStates( false);
//                 // System.out.println("children length is "+children.size());
//                 for (State child : children) {
//                     child.parent=currentState;
//                     if (!moveLogic.isVisited(visited,child )) {
//                         // System.out.println("not visiteddddddddddddddddddddddd");
//                         queue.add(child);

//                         System.out.println("gonna add this to visited");
//                         moveLogic.printBoard(child.board);
//                         visited.add(child);
//                     }
//                 }
//             }
//         }
//         System.out.println("\n\nVisited states count is "+visited.size());
//         System.out.println("Path length is "+path.size());
//         return path;
//     }

// }