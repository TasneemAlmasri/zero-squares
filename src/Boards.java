import java.util.HashMap;
import java.util.Map;

public class Boards {

    public static String[][][] initBoards = {
            // 1
            {
                    { "W", "W", "W", "W", "W", "W", "W", "W" },
                    { "W", " ", " ", "o", " ", " ", "Go", "W" },
                    { "W", "W", "W", "W", "W", "W", "W", "W" }
            },
            // 2
            {
                    { "W", "W", "W", "W", "W", "W", "W", "W" },
                    { "W", " ", " ", "W", " ", " ", " ", "W" },
                    { "W", "o", " ", " ", " ", " ", " ", "W" },
                    { "W", " ", " ", " ", " ", " ", " ", "W" },
                    { "W", "W", "W", "W", "Go", "W", "W", "W" },
                    { " ", " ", " ", "W", "W", "W", " ", " " },
            },
            // 3
            {
                    { " ", " ", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" },
                    { " ", " ", "W", "o", " ", " ", " ", " ", " ", " ", " ", " ", "W" },
                    { "W", "W", "W", " ", " ", "W", "W", "W", "W", "W", "W", " ", "W" },
                    { "W", " ", " ", " ", " ", " ", "Go", " ", " ", " ", "W", " ", "W" },
                    { "W", " ", "W", " ", " ", " ", " ", " ", " ", " ", "W", " ", "W" },
                    { "W", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "W" },
                    { "W", "W", "W", "W", " ", " ", " ", " ", " ", " ", " ", " ", "W" },
                    { " ", " ", " ", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" },
            },
            // 4
            {
                    { " ", " ", "W", "W", "W", " ", " ", " ", " ", " ", " " },
                    { " ", " ", "W", " ", "W", "W", "W", "W", "W", "W", "W" },
                    { "W", "W", "W", " ", " ", " ", " ", " ", " ", " ", "W" },
                    { "W", "W", " ", " ", " ", " ", " ", "W", " ", " ", "W" },
                    { "W", " ", "Go", " ", " ", " ", " ", " ", " ", " ", "W" },
                    { "W", "o", " ", " ", " ", " ", "W", " ", " ", " ", "W" },
                    { "W", " ", " ", " ", " ", "W", "W", "W", "W", "W", "W" },
                    { "W", " ", " ", " ", " ", "W", " ", " ", " ", " ", " " },
                    { "W", "W", "W", "W", "W", "W", " ", " ", " ", " ", " " },
            },
            // 5
            // two colors
            { // Go is @723279cf
                    { "W", "W", "W", "W", "W", "W", " ", " ", " " },
                    { "W", "Go", " ", " ", " ", "W", "W", " ", " " },
                    { "W", " ", " ", "Gb", " ", " ", "W", "W", "W" },
                    { "W", " ", " ", " ", " ", " ", "b", "o", "W" },
                    { "W", "W", "W", "W", "W", "W", "W", "W", "W" },
            },
            // 6
            {
                    { " ", " ", " ", " ", "W", "W", "W", "W", "W" },
                    { " ", " ", " ", " ", "W", " ", " ", " ", "W" },
                    { "W", "W", "W", "W", "W", "Go", "W", " ", "W" },
                    { "W", " ", " ", " ", "o", " ", "W", " ", "W" },
                    { "W", " ", " ", "Gb", "W", "b", "W", " ", "W" },
                    { "W", " ", " ", " ", " ", " ", " ", " ", "W" },
                    { "W", " ", " ", " ", " ", " ", " ", " ", "W" },
                    { "W", "W", "W", "W", "W", "W", "W", "W", "W" },
            },
            // 7
            // three colors
            {
                    { " ", "W", "W", "W", " ", " ", " ", " " },
                    { "W", "W", "Gy", "W", "W", "W", "W", "W" },
                    { "W", "y", "o", "b", " ", " ", " ", "W" },
                    { "W", "Gb", "W", "Go", "W", "W", "W", "W" },
                    { "W", "W", "W", "W", "W", " ", " ", " " },
            },
            // 8
            // four colors
            // {
            //         { " ", " ", " ", "W", "W", "W", "W", " ", " " },
            //         { "W", "W", "W", "W", "o", "Gy", "W", "W", "W" },
            //         { "W", "Gb", "p", "b", " ", " ", " ", " ", "W" },
            //         { "W", " ", "g", "W", "Go", " ", "W", "y", "W" },
            //         { "W", "W", "W", "W", "W", "W", "W", "W", "W" },
            // },
            // 9
            // four open walls
            {
                    { "W", "W", "W", "W", "W", "W", "W", "W", " ", " ", " " },
                    { "W", "o", " ", "W", " ", " ", "b", "W", " ", " ", " " },
                    { " ", " ", " ", "Go", " ", " ", " ", " ", " ", " ", " " },
                    { "W", "Gy", " ", " ", " ", "Gb", " ", "W", "W", "W", "W" },
                    { "W", " ", " ", " ", " ", "W", " ", " ", " ", " ", "W" },
                    { "W", "W", "W", "W", "W", "W", "W", "W", " ", " ", "W" },
                    { " ", " ", " ", " ", " ", " ", " ", " ", " ", "y", "W" },
                    { " ", " ", " ", " ", " ", " ", " ", "W", " ", "W", "W" },
            },

    };
    static Map<Integer, Map<Point, String>> initGoals = new HashMap<>();
    {
        initGoals.put(0, Map.of(
                new Point(1, 6), "Go"));
        initGoals.put(1, Map.of(
                new Point(4, 4), "Go"));
        initGoals.put(2, Map.of(
                new Point(3, 6), "Go"));
        initGoals.put(3, Map.of(
                new Point(4, 2), "Go"));
        initGoals.put(4, Map.of(
                new Point(1, 1), "Go", // @723279cf
                new Point(2, 3), "Gb"));
        initGoals.put(5, Map.of(
                new Point(2, 5), "Go",
                new Point(4, 3), "Gb"));
        initGoals.put(6, Map.of(
                new Point(1, 2), "Gy",
                new Point(3, 1), "Gb",
                new Point(3, 3), "Go"));
        initGoals.put(7, Map.of(
                new Point(1, 5), "Gy",
                new Point(2, 1), "Gb",
                new Point(3, 2), "Gp",
                new Point(3, 4), "Go",
                new Point(3, 7), "Gg"));
    }

    static String getGoal(int r, int c, int level) {
        Map<Point, String> goals = initGoals.get(level);

        if (goals != null) {
            for (Point goal : goals.keySet()) {
                if (goal.row == r && goal.col == c) {
                    return goals.get(goal);
                }
            }
        }

        return "";
    }

    public static String[][] getBoard(int level) {
        if (level >= 0 && level < initBoards.length) {
            return initBoards[level];
        } else {
            System.err.println("No Such level");
            return null;
        }
    }

    public String[][] getCopiedBoard(int level) {
        // System.out.println("iam in getCopied in Boards LEVEL
        // ISSSSSSSSSSSSSSSS"+level);
        if (level >= 0 && level < initBoards.length) {
            String[][] original = initBoards[level];// initBoards[level]
            String[][] theCopy = new String[original.length][];

            for (int i = 0; i < original.length; i++) {
                theCopy[i] = original[i].clone();
            }

            // print the copy
            for (int i = 0; i < theCopy.length; i++) {
                for (int j = 0; j < theCopy[i].length; j++) {
                    System.out.print(theCopy[i][j] + " ");
                }
                System.out.println();
                //
            }
            System.out.println();

            return theCopy;
        } else {
            System.err.println("No Such level");
            return null;
        }

    }

}
