import java.util.ArrayList;
import java.util.List;

public class Recursive_Dfs {

    State currentState;
    List<State> visited = new ArrayList<>();
    List<State> path = new ArrayList<>();
    MoveLogic moveLogic;
    int level;

    Recursive_Dfs(State iniState, int level) {
        this.currentState = iniState;
        this.moveLogic = new MoveLogic(iniState, level);
        this.level = level;
    }

    List<State> rdfsOn() {
        path = recursive(currentState);

        System.out.println("\n\nVisited states count is " + visited.size());
        System.out.println("Path length is " + path.size());

        return path;
    }

    List<State> recursive(State currentState) {

        visited.add(currentState);

        if (moveLogic.isFinal(currentState.board,currentState.removedGoals, false)) {
            path.add(currentState);
            
            while (currentState.parent != null) {
                currentState = currentState.parent;
                path.add(currentState);
            }
            return path;
        } else {
            List<State> children = new MoveLogic(currentState, level).nexStates(false);
            
            for (State child : children) {
                child.parent = currentState;

                if (!moveLogic.isVisited(visited, child)) {
                    List<State> childPath =
                     recursive(child);
                    if (!childPath.isEmpty()) {
                        return childPath; 
                    }
                }
            }
        }

        return new ArrayList<>();
    }
    
}
