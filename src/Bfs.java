// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.Map;
// import java.util.Queue;

// public class Bfs {
//     State initialState;
//     int level;
//     List<State> path = new ArrayList<>();
//     MoveLogic moveLogic;
//     Queue<Map<Character,State>> queue;

//     Bfs(State initialState, int level) {
//         this.level = level;
//         this.initialState = initialState;
//         path.add(initialState);
//         this.moveLogic = new MoveLogic(initialState, level);
//         this.queue=new LinkedList<>();
//     }

//     public void BfsOn() {
//         System.out.println("iam in BfsOn");

//         // Queue<State> queue = new LinkedList<>();
        
//         Map<Character, State> children = moveLogic.nexStates(false);
//         queue.addAll(children);
        
//         State currenState = queue.poll();

//         goOn(currenState,children);

//     }

//     public void goOn(State currenState, Map<Character, State> sibling){
        
//         if (!moveLogic.isFinal(currenState.board, true)){

//             if (addToPathIfCan(currenState)) {

//                 char direction = bringStateDirection(currenState, sibling);
//                 moveLogic.moveAllColors(direction, false);

//                 Map<Character, State>children=moveLogic.nexStates(false);
//                 List<State> childrenStates = new ArrayList<>(children.values());
//                 queue.addAll(childrenStates);

//                 currenState=queue.poll();
//                 //بدي الماب اللي هيه فيها
//                 goOn(currenState,)
//             }

//         }
//     }

//     public boolean addToPathIfCan(State state) {
//         if (!isInPath(state)) {
//             path.add(state);
//             return true;
//         }
//         return false;
//     }

//     public boolean isInPath(State state) {
//         for (State p : path) {
//             if (moveLogic.isEqual(p, state)) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     public char bringStateDirection(State s, Map<Character, State> sibling) {
//         for (Character key : sibling.keySet()) {
//             if (sibling.get(key).equals(s)) {
//                 return key;
//             }
//         }
//         return ' ';
//     }
// }

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;

public class Bfs {
    State initialState;
    int level;
    List<State> path = new ArrayList<>();
    MoveLogic moveLogic;
    Queue<State> queue;
    Map<State, Character> directionMap;

    Bfs(State initialState, int level) {
        this.level = level;
        this.initialState = initialState;
        path.add(initialState);
        this.moveLogic = new MoveLogic(initialState, level);
        this.queue = new LinkedList<>();
        this.directionMap = new HashMap<>();
    }

    public void BfsOn() {
        System.out.println("I am in BfsOn");

        // Generate initial children
        Map<Character, State> children = moveLogic.nexStates(false);
        for (Map.Entry<Character, State> entry : children.entrySet()) {
            queue.add(entry.getValue());
            directionMap.put(entry.getValue(), entry.getKey());  // Track direction for each child
        }
        
        // Start exploring
        State currentState = queue.poll();
        goOn(currentState);
    }

    public void goOn(State currentState) {
        if (currentState == null) return;
        
        // Retrieve the direction for the current state
        char direction = directionMap.getOrDefault(currentState, ' ');

        // Check if the current state is final
        if (moveLogic.isFinal(currentState.board, true)) {
            path.add(currentState);
            moveLogic.printPath(path);  // Print the path to the final state
            return;
        }
        
        // Only process if state is not in path
        if (addToPathIfCan(currentState)) {
            // Move based on the direction
            moveLogic.moveAllColors(direction, false);

            // Generate the next states
            Map<Character, State> children = moveLogic.nexStates(false);
            for (Map.Entry<Character, State> entry : children.entrySet()) {
                queue.add(entry.getValue());            // add each child state to the queue
                directionMap.put(entry.getValue(), entry.getKey());  // track direction in the map
            }

            // Recur for the next state in the queue
            goOn(queue.poll());
        } else {
            // Node is already in the path, skip and move to the next
            goOn(queue.poll());
        }
    }

    public boolean addToPathIfCan(State state) {
        if (!isInPath(state)) {
            path.add(state);
            return true;
        }
        return false;
    }

    public boolean isInPath(State state) {
        for (State p : path) {
            if (moveLogic.isEqual(p, state)) {
                return true;
            }
        }
        return false;
    }
}
















//1,4,5,