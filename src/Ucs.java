import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Ucs {

    State currentState;
    PriorityQueue<State>queue = new PriorityQueue<>();
    List<State> visited = new ArrayList<>();
    List<State> path = new ArrayList<>();
    MoveLogic moveLogic;
    int level;

    Ucs(State iniState, int level) {
        this.currentState=iniState;
        queue.add(currentState);
        this.moveLogic = new MoveLogic(iniState, level);
        this.level=level;
    }

    List<State> ucsOn() {
        while (!queue.isEmpty()) {
            currentState = queue.poll();
            
            System.out.println("gonna add this to visited");
            moveLogic.printBoard(currentState.board);
            visited.add(currentState);

            if (moveLogic.isFinal(currentState.board, false)) {
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
                    child.cost+=child.parent.cost;
                    if (!moveLogic.isVisited(visited,child )) {
                        queue.add(child);
                        // بدنا المقارنة تكون حسب ال child cost
                        // queue.comparator()//child.cost

                    }
                }
            }
        }
        System.out.println("\n\nVisited states count is "+visited.size());
        System.out.println("Path length is "+path.size());
        return path;
    }

}