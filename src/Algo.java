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

        System.out.println(
                "Please click :\n 1-for Dfs \n 2-for Bfs \n 3-for ucs \n 4-for recursive Dfs \n 5-for A* \n 6-for steepst hill climbing \n7-for simple hill climbing");
        int algo = scanner.nextInt();

        Dfs dfs = new Dfs(initialState, level);
        Bfs bfs = new Bfs(initialState, level);
        Ucs ucs = new Ucs(initialState, level);
        Recursive_Dfs rdfs = new Recursive_Dfs(initialState, level);
        AStar astar = new AStar(initialState, level);
        SteepestHillClimbing hillClimbing = new SteepestHillClimbing(initialState, level);
        SimpleHillClimbing simple = new SimpleHillClimbing(initialState, level);

        switch (algo) {
            case 1:
                System.out.println("Dfs:");
                long dfsStartTime = System.nanoTime();

                List<State> dfsPath = dfs.dfsOn();

                long dfsEndTime = System.nanoTime();
                long dfsDuration = dfsEndTime - dfsStartTime;
                System.out.println("DFS Time Taken: " + (dfsDuration / 1_000_000) + " ms\n");

                Collections.reverse(dfsPath);
                moveLogic.printPath(dfsPath);
                break;

            case 2:
                System.out.println("Bfs:");

                long bfsStartTime = System.nanoTime();

                List<State> bfsPath = bfs.bfsOn();

                long bfsEndTime = System.nanoTime();
                long bfsDuration = bfsEndTime - bfsStartTime;
                System.out.println("BFS Time Taken: " + (bfsDuration / 1_000_000) + " ms\n");

                Collections.reverse(bfsPath);
                moveLogic.printPath(bfsPath);
                break;

            case 3:
                System.out.println("Ucs:");

                long ucsStartTime = System.nanoTime();

                List<State> ucsPath = ucs.ucsOn();

                long ucsEndTime = System.nanoTime();
                long ucsDuration = ucsEndTime - ucsStartTime;
                System.out.println("UCS Time Taken: " + (ucsDuration / 1_000_000) + " ms\n");

                Collections.reverse(ucsPath);
                moveLogic.printPath(ucsPath);
                break;

            case 4:
                System.out.println("Recursive dfs:");

                long rdfsStartTime = System.nanoTime();

                List<State> rDfsPath = rdfs.rdfsOn();

                long rdfsEndTime = System.nanoTime();
                long rdfsDuration = rdfsEndTime - rdfsStartTime;
                System.out.println("Recursive DFS Time Taken: " + (rdfsDuration / 1_000_000) + " ms\n");

                Collections.reverse(rDfsPath);
                moveLogic.printPath(rDfsPath);
                break;

            case 5:
                System.out.println("A*:");

                long astarStartTime = System.nanoTime();

                List<State> astarPath = astar.aStarOn();

                long astarEndTime = System.nanoTime();
                long astarDuration = astarEndTime - astarStartTime;
                System.out.println("A* Time Taken: " + (astarDuration / 1_000_000) + " ms\n");

                Collections.reverse(astarPath);
                moveLogic.printPath(astarPath);
                break;

            case 6:
                System.out.println("steepest hill climbing :");

                long hillStartTime = System.nanoTime();

                List<State> hillPath = hillClimbing.hillClimbingOn();

                long hillEndTime = System.nanoTime();
                long hillDuration = hillEndTime - hillStartTime;
                System.out.println("Hill Climbing Time Taken: " + (hillDuration / 1_000_000) + " ms\n");

                Collections.reverse(hillPath);
                moveLogic.printPath(hillPath);
                break;
            case 7:
                System.out.println("steepest hill climbing :");

                long simpleStartTime = System.nanoTime();

                List<State> simplePath = simple.hillClimbingOn();

                long simpleEndTime = System.nanoTime();
                long simpleDuration = simpleEndTime - simpleStartTime;
                System.out.println("Hill Climbing Time Taken: " + (simpleDuration / 1_000_000) + " ms\n");

                Collections.reverse(simplePath);
                moveLogic.printPath(simplePath);
                break;

            default:
                System.out.println("Invalid algorithm selection!");
                break;
        }

        scanner.close();
    }
}
