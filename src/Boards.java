import java.util.HashMap;
import java.util.Map;

public class Boards {

    public static String[][][] initBoards = {
        // 0
        {
                        { "W", "W", "W", "W", "W", "W", "W", "W" },
                        { "W", " ", " ", "o", " ", " ", "Go", "W" },
                        { "W", "W", "W", "W", "W", "W", "W", "W" }
        },
        // 1
        {
                        { "W", "W", "W", "W", "W", "W", "W", "W" },
                        { "W", " ", " ", "W", " ", " ", " ", "W" },
                        { "W", "o", " ", " ", " ", " ", " ", "W" },
                        { "W", " ", " ", " ", " ", " ", " ", "W" },
                        { "W", "W", "W", "W", "Go", "W", "W", "W" },
                        { " ", " ", " ", "W", "W", "W", " ", " " },
        },
        // 2
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
        // 3
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
        // 4
        {
                        { "W", "W", "W", "W", "W", "W", " ", " ", " " },
                        { "W", "Go", " ", " ", " ", "W", "W", " ", " " },
                        { "W", " ", " ", "Gb", " ", " ", "W", "W", "W" },
                        { "W", " ", " ", " ", " ", " ", "b", "o", "W" },
                        { "W", "W", "W", "W", "W", "W", "W", "W", "W" },
        },
        // 5
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
        // 6
        {
                        { " ", "W", "W", "W", " ", " ", " ", " " },
                        { "W", "W", "Gy", "W", "W", "W", "W", "W" },
                        { "W", "y", "o", "b", " ", " ", " ", "W" },
                        { "W", "Gb", "W", "Go", "W", "W", "W", "W" },
                        { "W", "W", "W", "W", "W", " ", " ", " " },
        },
        // 7
        {
                        { " ", "W", "W", "W", "W", "W", " ", " ", " ", " ", " " },
                        { "W", "W", "r", " ", " ", "W", "W", "W", "W", "W", " " },
                        { "W", " ", " ", " ", " ", "W", "W", "Gb", " ", "W", " " },
                        { "W", " ", " ", " ", " ", " ", " ", " ", " ", "W", "W" },
                        { "W", " ", " ", " ", "W", "W", "W", " ", " ", "Gr", "W" },
                        { "W", " ", " ", " ", " ", " ", " ", " ", " ", "W", "W" },
                        { "W", "W", "b", " ", "W", "W", "W", "W", "W", "W", " " },
                        { " ", "W", "W", "W", "W", " ", " ", " ", " ", " ", " ", }
        },
        // 8 //20
        // {
        //                 { " ", " ", " ", "W", "W", "W", "W", " ", " " },
        //                 { "W", "W", "W", "W", "o", "Gy", "W", "W", "W" },
        //                 { "W", "Gb", "p", "b", " ", " ", " ", " ", "W" },
        //                 { "W", " ", "g", "W", "Go", " ", "W", "y", "W" },
        //                 { "W", "W", "W", "W", "W", "W", "W", "W", "W" },
        // },
        {
                { " ", " ", " ", "W", "W", "W", "W", " ", " " },
                { "W", "W", "W", "W", "o", "Gy", "W", "W", "W" },
                { "W", "Gb", "p", "b", " ", " ", " ", "y", "W" },
                { "W", "g", "Gp", "W", "Go", " ", "W", "Gg", "W" },
                { "W", "W", "W", "W", "W", "W", "W", "W", "W" },
},
        // 9 //10
        {
                        { " ", " ", "W", "W", "W", "W", "W", "W", "W", "W", " ", " " },
                        { " ", "W", "W", " ", " ", " ", " ", " ", " ", "W", "W", " " },
                        { "W", "W", " ", " ", "W", " ", "Gb", "W", " ", " ", "W", "W" },
                        { "W", " ", " ", "W", " ", "Gr", " ", " ", "W", " ", " ", "W" },
                        { "W", " ", " ", " ", " ", "W", " ", " ", "W", "W", " ", "W" },
                        { "W", "r", "W", " ", "W", "W", " ", " ", " ", "W", "b", "W" },
                        { "W", " ", " ", " ", "W", " ", " ", " ", " ", " ", " ", "W" },
                        { "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W", "W" }
        },
        //  10
        {
            { " ", "W", "W", "W"," ", " ", " ", " " },
            { "W", "W", "Gy", "W","W", " ", " ", " " },
            { "W", " ", " ", " ","W", " ", " ", " " },
            { "W", "W", "W", " ","W", "W", "W", "W" },
            { "W", "b", " ", " ","y", "W", "W", "W" },
            { "W", "W", " ", " "," ", " ", " ", "W" },
            { "W", "r", " ", "W","Gr", " ", "g", "W" },
            { "W", "W", "W", "W"," ", "W", "W", "W" },
            { " ", " ", " ", "W"," ", "Gb", " ", "W" },
            { " ", " ", " ", "W"," ", " ", " ", "W" },
            { " ", " ", " ", "W","W", "Gg", "W", "W" },
            { " ", " ", " ", " ","W", "W", "W", " " }
},

        
        // {
        // { "W", "W", "W", "W", "W", "W", "W", "W", " ", " ", " " },
        // { "W", "o", " ", "W", " ", " ", "b", "W", " ", " ", " " },
        // { " ", " ", " ", "Go", " ", " ", " ", " ", " ", " ", " " },
        // { "W", "Gy", " ", " ", " ", "Gb", " ", "W", "W", "W", "W" },
        // { "W", " ", " ", " ", " ", "W", " ", " ", " ", " ", "W" },
        // { "W", "W", "W", "W", "W", "W", "W", "W", " ", " ", "W" },
        // { " ", " ", " ", " ", " ", " ", " ", " ", " ", "y", "W" },
        // { " ", " ", " ", " ", " ", " ", " ", "W", " ", "W", "W" },
        // },

};
        static Map<Integer, Map<Point, String>> initGoals = new HashMap<>();
        static {
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

                                // thisssss
                initGoals.put(7, Map.of(
                        new Point(2, 7), "Gb",
                        new Point(4, 9), "Gr"
                ));
                initGoals.put(8, new HashMap<>() {{
                    put(new Point(1, 5), "Gy");
                    put(new Point(2, 1), "Gb");
                    put(new Point(3, 2), "Gp");
                    put(new Point(3, 4), "Go");
                    put(new Point(3, 7), "Gg");
                }});
                initGoals.put(9, new HashMap<>() {{
                    put(new Point(2, 6), "Gb");
                    put(new Point(3, 5), "Gr");
                }});

                initGoals.put(10, new HashMap<>() {{
                    put(new Point(1, 2), "Gy");
                    put(new Point(6,4 ), "Gr");
                    put(new Point(8, 5), "Gb");
                    put(new Point(10, 5), "Gg");
                }});

                // initGoals.put(??, Map.of(
                //                 new Point(1, 5), "Gy",
                //                 new Point(2, 1), "Gb",
                //                 new Point(3, 2), "Gp",
                //                 new Point(3, 4), "Go",
                //                 new Point(3, 7), "Gg"));
        }

        static String getGoal(int r, int c, int level) {
                // System.out.println("i ma in get goal and r "+r+" "+c+" level "+level);

                Map<Point, String> goals = initGoals.get(level);

                if (goals != null) {
                        for (Point goal : goals.keySet()) {
                                // System.out.println("soy inside la loop goal is at "+goal.row+" "+goal.col);
                                if (goal.row == r && goal.col == c) {
                                        // System.out.println("i foubd a goal");
                                        return goals.get(goal);
                                }
                        }
                }
                return "";
        }

        public static Point getGoalByColor(int level, Character color) {
                Map<Point, String> goals = initGoals.get(level);
                if (goals != null) {
                    for (Map.Entry<Point, String> entry : goals.entrySet()) {
                        if (entry.getValue().charAt(0)==color) {
                            return entry.getKey(); 
                        }
                    }
                }
                return null; // Return null if color not found
            }

        public static String[][] getBoard(int level) {
                if (level >= 0 && level < initBoards.length) {
                        return initBoards[level];
                } else {
                        System.out.println("No Such level");
                        System.exit(0);
                        return null;
                }
        }

}
