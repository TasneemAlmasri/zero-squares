import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Ucs {

    Comparator<State> costComparator = new Comparator<State>() {
        @Override
        public int compare(State p1, State p2) {
            return Integer.compare(p1.cost, p2.cost);
        }
    };

    State currentState;
    PriorityQueue<State>queue = new PriorityQueue<>(costComparator);
    List<State> visited = new ArrayList<>();
    List<State> path = new ArrayList<>();
    MoveLogic moveLogic;
    int level;

    Ucs(State iniState, int level) {
        this.currentState=iniState;
        queue.add(currentState);
        // System.out.println("now in the queue we have init"+queue.element().cost); 
        this.moveLogic = new MoveLogic(iniState, level);
        this.level=level;
    }

    List<State> ucsOn() {

        while (!queue.isEmpty()) {
            currentState = queue.poll();
            
            // System.out.println("gonna add this to visited");
            // moveLogic.printBoard(currentState.board);
            visited.add(currentState);

            if (moveLogic.isFinal(currentState.board,currentState.removedGoals, false)) {
                path.add(currentState);
                while (currentState.parent != null) {
                    currentState = currentState.parent;
                    path.add(currentState);
                }
                break;
            } else {
                List<State> children = new MoveLogic(currentState,level).nexStates( false);

                for (State child : children) {
                    child.parent=currentState;
                    child.cost=child.parent.cost+1;
                    if (!moveLogic.isVisited(visited,child )) {
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