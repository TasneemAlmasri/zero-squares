import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class AStar {
    Comparator<State> costHeuComparator = new Comparator<State>() {
        @Override
        public int compare(State p1, State p2) {
            return Integer.compare(p1.heuCost, p2.heuCost);
        }
    };

    State currentState;
    PriorityQueue<State>queue = new PriorityQueue<>(costHeuComparator);
    List<State> visited = new ArrayList<>();
    List<State> path = new ArrayList<>();
    MoveLogic moveLogic;
    int level;
    Heuristic heur;
    Cost cost;

    AStar(State iniState, int level) {
         heur=new Heuristic();
         cost=new Cost(level);
        this.currentState=iniState;
        currentState.huer=heur.getHeuristic(currentState);
        queue.add(currentState);
        // System.out.println("now in the queue we have init"+queue.element().cost); 
        this.moveLogic = new MoveLogic(iniState, level);
        this.level=level;
    }

    List<State> aStarOn() {

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
                    child.cost=child.parent.cost+cost.getCost(child.board, currentState.board);

                    child.huer=heur.getHeuristic(child);
                    child.heuCost=heur.getHeuristic(child)+child.cost;
                    
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
