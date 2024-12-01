import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Algo {
    State initialState;
    int level;
    List<State> path;

    Algo(State initialState, int level, List<State> path) {
        this.initialState = initialState;
        this.level = level;
        this.path = path;
    }

    public void playComputer() {

        Scanner scanner = new Scanner(System.in);
        MoveLogic moveLogic = new MoveLogic(initialState, level);

        System.out.println("Please click :\n 1-for Dfs \n 2-for Bfs \n 3-for ucs \n 4-for recursive Dfs \n 5-for A* \n 6-for hill climbing");
        int algo = scanner.nextInt();

        Dfs dfs = new Dfs(initialState, level);
        Bfs bfs = new Bfs(initialState, level);
        Ucs ucs = new Ucs(initialState, level);
        Recursive_Dfs rdfs = new Recursive_Dfs(initialState, level);
        AStar astar = new AStar(initialState, level);
        HillClimbing hillClimbing = new HillClimbing(initialState, level);

        switch (algo) {
            case 1:
                List<State> dfsPath = dfs.dfsOn();
                Collections.reverse(dfsPath);
                moveLogic.printPath(dfsPath);
                break;

            case 2:
                List<State> bfsPath = bfs.bfsOn();
                Collections.reverse(bfsPath);
                moveLogic.printPath(bfsPath);
                break;
            case 3:
                List<State> ucsPath = ucs.ucsOn();
                Collections.reverse(ucsPath);
                moveLogic.printPath(ucsPath);
                break;
            case 4:
                List<State> rDfsPath = rdfs.rdfsOn();
                Collections.reverse(rDfsPath);
                moveLogic.printPath(rDfsPath);
                break;
            case 5:
                List<State> astarPath = astar.aStarOn();
                Collections.reverse(astarPath);
                moveLogic.printPath(astarPath);
                break;
            case 6:
                List<State> hillPath = hillClimbing.hillClimbingOn();
                Collections.reverse(hillPath);
                moveLogic.printPath(hillPath);
                break;
            default:
                break;
        }
        scanner.close();
    }
}
