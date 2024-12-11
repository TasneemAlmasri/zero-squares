import java.util.HashMap;
import java.util.Map;

class Heuristic{

    // بجيب الهيوريستسك تبع كل الرقعة الحالية اي بيمسك كل لون و بخزن اكساتو و واياتو ثم غولو و بخزن ,و بعدين بجمعهم لكل الالوان
     int getHeuristic(State s){

        String[][] board=s.board;

        Map<Point, Character> colors = new HashMap<>();
        Map<Point, Character> goals = new HashMap<>();

        // رح نفتل عالرقعة لنجمع الالوان و الغوال
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {

                if (Character.isLowerCase(board[i][j].charAt(0))) {
                    colors.put(new Point(i, j), board[i][j].charAt(0));
                }
                
                if (board[i][j].charAt(0)=='G') {
                    goals.put(new Point(i, j), board[i][j].charAt(1));
                }
                
            }
        }

        int heur=0;
        Point color=new Point(-1, -1);
        Point goal =new Point(-1, -1);;

        for(Point c: colors.keySet()){
            color=c;
            
            for(Point g:goals.keySet()){
                if(colors.get(c) ==goals.get(g)){
                    goal=g;
                }
            }
           
           heur+=Math.abs(color.row- goal.row)+Math.abs(color.col-goal.col);

        }
        return heur;
    }
}