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

        System.out.println("Please click :\n 1-for Dfs \n 2-for Bfs ");
        int algo = scanner.nextInt();

        Dfs dfs=new Dfs(initialState, level);
        Bfs bfs=new Bfs(initialState, level);

        switch (algo) {
            case 1:
                List<State>dfsPath=dfs.dfsOn();
                // System.err.println("dfs path length is "+dfsPath.size());
                Collections.reverse(dfsPath);
                moveLogic.printPath(dfsPath);
                break;

            case 2:
            List<State>bfsPath=bfs.bfsOn();
            // System.err.println("dfs path length is "+dfsPath.size());
            Collections.reverse(bfsPath);
            moveLogic.printPath(bfsPath);
                break;

            default:
                break;
        }
        scanner.close();
    }
}
