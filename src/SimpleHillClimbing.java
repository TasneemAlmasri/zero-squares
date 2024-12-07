import java.util.ArrayList;
import java.util.List;

public class SimpleHillClimbing {
    State currentState;
    List<State> path = new ArrayList<>();
    MoveLogic moveLogic;
    int level;
    Heuristic heur;

    SimpleHillClimbing(State iniState, int level) {
        heur = new Heuristic();
        this.currentState = iniState;
        this.moveLogic = new MoveLogic(iniState, level);
        this.level = level;
    }

    List<State> hillClimbingOn() {

        while (true) {
            State parent = currentState;

            if (moveLogic.isFinal(currentState.board, false)) {
                path.add(currentState);
                while (currentState.parent != null) {
                    currentState = currentState.parent;
                    path.add(currentState);
                }
                break;
            }

            List<State> children = new MoveLogic(currentState, level).nexStates(false);
            boolean foundBetterChild = false;

            for (State child : children) {
                child.parent = parent;
                child.huer = heur.getHeuristic(child);

                if (child.huer < heur.getHeuristic(currentState)) {
                    currentState = child;
                    foundBetterChild = true;
                    break;
                }
            }

            if (!foundBetterChild) {
                path.add(currentState);
                while (currentState.parent != null) {
                    currentState = currentState.parent;
                    path.add(currentState);
                }
                break;
            }
        }

        System.out.println("Path length is " + path.size());
        return path;
    }
}
