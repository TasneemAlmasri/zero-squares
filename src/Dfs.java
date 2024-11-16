// هي لما ضيف عند البوب
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Dfs {

    State currentState;
    Stack<State> stack = new Stack<>();
    List<State> visited = new ArrayList<>();
    List<State> path = new ArrayList<>();
    MoveLogic moveLogic;
    int level;
    // int count=0;

    Dfs(State iniState, int level) {
        this.currentState = iniState;
        stack.push(currentState);
        this.moveLogic = new MoveLogic(iniState, level);
        this.level = level;
    }

    List<State> dfsOn() {
        while (!stack.empty()) {
            // count++;
            currentState = stack.pop();

            // if(!moveLogic.isVisited(visited, currentState)){
            visited.add(currentState);
            System.out.println("gonna add this to visited");
            moveLogic.printBoard(currentState.board);
            // }
            // else{
            // continue;
            // }

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
                List<State> children = new MoveLogic(currentState, level).nexStates(false);

                for (State child : children) {
                    child.parent = currentState;

                    if (!moveLogic.isVisited(visited, child)) {
                        stack.push(child);
                    }
                }
            }
        }

        System.out.println("\n\nVisited states count is " + visited.size());
        System.out.println("Path length is " + path.size());
        return path;
    }
}

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Stack;

// public class Dfs {

// State currentState;
// Stack<State> stack = new Stack<>();
// List<State> visited = new ArrayList<>();
// List<State> path = new ArrayList<>();
// MoveLogic moveLogic;
// int level;
// // int count=0;

// Dfs(State iniState, int level) {
// this.currentState = iniState;
// stack.push(currentState);
// visited.add(currentState);
// this.moveLogic = new MoveLogic(iniState, level);
// this.level = level;
// }

// List<State> dfsOn() {
// while (!stack.empty()) {
// // count++;
// currentState = stack.pop();

// if (moveLogic.isFinal(currentState.board, false)) {
// // System.out.println("i am in the if final case");
// path.add(currentState);
// while (currentState.parent != null) {
// currentState = currentState.parent;
// path.add(currentState);
// }
// break;
// } else {
// // System.out.println("i am in the else(not final) case ");
// List<State> children = new MoveLogic(currentState, level).nexStates(false);

// for (State child : children) {
// child.parent = currentState;

// if (!moveLogic.isVisited(visited, child)) {
// stack.push(child);
// visited.add(child);

// System.out.println("gonna add this to visited");
// moveLogic.printBoard(child.board);
// }
// }
// }
// }

// System.out.println("\n\nVisited states count is " + visited.size());
// System.out.println("Path length is " + path.size());
// return path;
// }
// }
