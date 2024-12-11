import java.util.HashMap;
import java.util.Map;

public class Cost {
    int level;

    Cost(int level) {
        this.level=level;
    }

    public int getCost(String[][] b1, String[][] b2) {

        System.out.println("iam in get cost");
        Map<Character,Point> b1colors = new HashMap<>();
        Map<Character,Point> b2colors = new HashMap<>();

        for (int i = 0; i < b1.length; i++) {
            for (int j = 0; j < b1[i].length; j++) {

                if (Character.isLowerCase(b1[i][j].charAt(0))) {
                    b1colors.put( b1[i][j].charAt(0),new Point(i, j));
                }
                if (Character.isLowerCase(b2[i][j].charAt(0))) {
                    b2colors.put(b2[i][j].charAt(0),new Point(i, j));
                }
            }
        }
        System.out.println("b1colors is "+b1colors.size()+"b2colors is "+b2colors.size());

        int cost=0;

        for(Map.Entry<Character,Point> entry :b1colors.entrySet()){

            Point point1 = entry.getValue();
            Character color1 = entry.getKey();

            Point point2  = b2colors.get(color1);
            if (point2 != null) {
                int distance = Math.abs(point1.row - point2.row) + Math.abs(point1.col - point2.col);
                cost += distance;
            }
            else{
                Point goal=Boards.getGoalByColor(level,color1);
                int distance = Math.abs(point1.row - goal.row) + Math.abs(point1.col - goal.col);
                cost += distance;
            }
        }

        return cost;

    }
}
