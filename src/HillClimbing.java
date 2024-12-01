import java.util.ArrayList;
import java.util.List;

public class HillClimbing {
    State currentState;
    List<State> path = new ArrayList<>();
    MoveLogic moveLogic;
    int level;
    Heuristic heur;

    HillClimbing(State iniState, int level) {
        heur = new Heuristic();
        this.currentState = iniState;
        this.moveLogic = new MoveLogic(iniState, level);
        this.level = level;
    }

    List<State> hillClimbingOn() {

        while (true) {
            // System.out.println("loooooooooop");
            boolean foundSonSmaller = false;
            State parent = currentState;

            if (moveLogic.isFinal(currentState.board, false)) {
                // System.out.println("iam in finalllllllllll");
                path.add(currentState);
                while (currentState.parent != null) {
                    currentState = currentState.parent;
                    path.add(currentState);
                }
                break;

            } else {
                List<State> children = new MoveLogic(currentState, level).nexStates(false);

                for (State child : children) {

                    child.parent = parent;
                    child.huer=heur.getHeuristic(child);

                    if (child.huer < heur.getHeuristic(currentState)) {
                        // System.out.println("iam in the iffff");
                        currentState = child;
                        foundSonSmaller = true;
                    }

                }
                if (!foundSonSmaller) {
                    path.add(currentState);
                    while (currentState.parent != null) {
                        currentState = currentState.parent;
                        path.add(currentState);
                    }
                    break;
                }
            }
        }
        System.out.println("Path length is " + path.size());
        return path;
    }
}
