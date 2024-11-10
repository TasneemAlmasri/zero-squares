
//this is with state and with code adjusment
//first with state
//sec with adj without staet
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MoveLogic {
    private State currentstate;
    private int level;

    public MoveLogic(State initialState, int level) {
        this.currentstate = initialState;
        this.level = level;
        // System.out.println("LEVEL
        // ISSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSs"+level);
    }

    // function takes in coordinates and direction then returns Point that represent
    // closest wall in that direction
    Point findClosestWall(int row, int col, char direction, String[][] board) {
        // System.out.println("row is = " + row + " and col is= " + col + " and
        // board.length= " + board.length
        // + " and board[0].length= " + board[row].length);
        if (row >= 0 && row < board.length && col < board[row].length && col >= 0)// valid point
        {
            // System.out.println("iam in the if");
            // if we want the closest to the left
            if (direction == 'l') {
                for (int i = col - 1; i >= 0; i--) {
                    if (board[row][i].equals("W")) {
                        return new Point(row, i);
                    }
                }
            }
            // if we want the closest to the rihgt
            else if (direction == 'r') {
                for (int i = col + 1; i < board[row].length; i++) {
                    if (board[row][i].equals("W")) {
                        return new Point(row, i);
                    }
                }
            }
            // if we want the closest in the up
            else if (direction == 'u') {
                for (int i = row - 1; i >= 0; i--) {
                    if (board[i][col].equals("W")) {
                        return new Point(i, col);
                    }
                }
            }
            // if we want the closest below
            else if (direction == 'd') {
                for (int i = row + 1; i < board.length; i++) {
                    if (board[i][col].equals("W")) {
                        return new Point(i, col);
                    }
                }
            }
        }
        return new Point(-1, -1);
    }

    // takes in a color square and the closest wall to it then returns the count of
    // color squares between them
    int colorsCount(int r1, int c1, int r2, int c2, String[][] board) {
        int start, end;
        // so col are the same and its up down case
        if (r1 != r2) {
            start = Math.min(r1, r2);
            end = Math.max(r1, r2);
        }
        // when the same row,so left right case
        else {
            start = Math.min(c1, c2);
            end = Math.max(c1, c2);
        }

        int count = 0;
        for (int i = start + 1; i < end; i++) {
            // two lines to know if im looping in rows or cols(i have start and end,but dont
            // know in board[][] who is i and who is constant)
            int rindex = r1 != r2 ? i : r1;
            int cindex = c1 != c2 ? i : c1;
            if (Character.isLowerCase(board[rindex][cindex].charAt(0))) // if color
            {
                count++;
            }
        }
        return count;

    }

    // check if my goal exists in the area between me and the wall(dont want it if
    // its after the wall)
    Point checkGoal(int r1, int c1, int r2, int c2, String color, char direction, String[][] board) {
        int start, end;
        // so col are the same and its up down case
        if (r1 != r2) {
            start = Math.min(r1, r2);
            end = Math.max(r1, r2);
        }
        // when the same row,so left right case
        else {
            start = Math.min(c1, c2);
            end = Math.max(c1, c2);
        }
        for (int i = start + 1; i < end; i++) {
            // coming two lines to know if im looping in rows or cols(i have start and
            // end,but dont
            // know in board[][] who is i and who is constant)
            int rindex = r1 != r2 ? i : r1;
            int cindex = c1 != c2 ? i : c1;
            if (board[rindex][cindex].charAt(0) == 'G' && board[rindex][cindex].charAt(1) == color.charAt(0)) {
                return new Point(rindex, cindex);
            }
        }
        return new Point(-1, -1);

    }

    boolean canMove(int r, int c, char direction, String[][] board) {
        // System.out.println("IAM IN CAN MOVE AND THE ONE MOVING IS " + r + " " + c);
        switch (direction) {
            case 'l':
                return c - 1 >= 0 && (board[r][c - 1].equals(" ") || board[r][c - 1].charAt(0) == 'G'
                        || board[r][c - 1].equals("B"));// here new
            case 'r':
                return c + 1 < board[r].length && (board[r][c + 1].equals(" ") || board[r][c + 1].charAt(0) == 'G'
                        || board[r][c + 1].equals("B"));
            case 'u':
                return r - 1 >= 0 && (board[r - 1][c].equals(" ") || board[r - 1][c].charAt(0) == 'G'
                        || board[r - 1][c].equals("B"));
            case 'd':
                return r + 1 < board.length && (board[r + 1][c].equals(" ") || board[r + 1][c].charAt(0) == 'G'
                        || board[r + 1][c].equals("B"));
            default:
                return false;
        }
    }

    // .......................................................................................................
    // move one color,these functions wont be called unless the square CAN (not near
    // wall or another color) move in the needed direction
    List<Point> removedGoals = new ArrayList<>();

    void moveOneColorRight(int r, int c, String color, String[][] board, List<Point> movableCells) {

        Point closeWall = findClosestWall(r, c, 'r', board);
        int wallRow = (closeWall.row == -1) ? r : closeWall.row;
        int wallCol = (closeWall.col == -1) ? board[0].length - 1 : closeWall.col;

        Point closUnmovablColor = getCloseUnmovablColor(r, c, wallRow, wallCol, 'r', board, movableCells);
        if (closUnmovablColor.row != -1) {
            // System.out.println("i am in the case where there is unmvable color fo rthe
            // color "+r+" "+c+"and the un is"+closUnmovablColor.row+"
            // "+closUnmovablColor.col);
            wallRow = closUnmovablColor.row;
            wallCol = closUnmovablColor.col;
        }

        int colorsCount = colorsCount(r, c, wallRow, wallCol, board);
        Point itsGoal = checkGoal(r, c, wallRow, wallCol, color, 'r', board);
        ChangeBlankSquare(r, c, wallRow, wallCol, board);

        // case no goal
        if (itsGoal.row == -1) {
            // old to check if it was a goal before,i only care for this when moving from
            // the current place not the distance
            char old = wasGoal(r, c);
            board[r][c] = (old == ' ') ? " " : "G" + old;
            if (closeWall.col != -1) {
                board[wallRow][wallCol - colorsCount - 1] = color;
            }

        }
        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.col - wallCol - 1) >= colorsCount) {
                char old = wasGoal(r, c);
                board[r][c] = (old == ' ') ? " " : "G" + old;
                board[itsGoal.row][itsGoal.col] = " ";
                removedGoals.add(new Point(itsGoal.row, itsGoal.col));
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color//not in case of no wall
            else {
                char old = wasGoal(r, c);
                board[r][c] = (old == ' ') ? " " : "G" + old;
                if (closeWall.row == -1) {
                    // it will meet the goal
                    board[itsGoal.row][itsGoal.col] = " ";
                    removedGoals.add(new Point(itsGoal.row, itsGoal.col));
                    System.out.println("The Color " + color + " met its goal");
                } else {
                    board[wallRow][wallCol - colorsCount - 1] = color;
                }
            }
        }
    }

    void moveOneColorLeft(int r, int c, String color, String[][] board, List<Point> movableCells) {

        Point closeWall = findClosestWall(r, c, 'l', board);
        int wallRow = (closeWall.row == -1) ? r : closeWall.row;
        int wallCol = (closeWall.col == -1) ? 0 : closeWall.col;

        Point closUnmovablColor = getCloseUnmovablColor(r, c, wallRow, wallCol, 'l', board, movableCells);
        if (closUnmovablColor.row != -1) {
            // System.out.println("i am in the case where there is unmvable color fo rthe
            // color "+r+" "+c+"and the un is"+closUnmovablColor.row+"
            // "+closUnmovablColor.col);
            wallRow = closUnmovablColor.row;
            wallCol = closUnmovablColor.col;
        }

        int colorsCount = colorsCount(r, c, wallRow, wallCol, board);
        Point itsGoal = checkGoal(r, c, wallRow, wallCol, color, 'l', board);
        ChangeBlankSquare(r, c, wallRow, wallCol, board);

        // case no goal for it
        if (itsGoal.row == -1) {
            // System.out.println("case no goal");
            char old = wasGoal(r, c);
            board[r][c] = (old == ' ') ? " " : "G" + old;
            if (closeWall.col != -1) {
                board[wallRow][wallCol + colorsCount + 1] = color;
            }

        }
        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.col - 1 - wallCol) >= colorsCount) {
                char old = wasGoal(r, c);
                board[r][c] = (old == ' ') ? " " : "G" + old;
                board[itsGoal.row][itsGoal.col] = " ";
                removedGoals.add(new Point(itsGoal.row, itsGoal.col));
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color
            // in case of no wall,they wont block it
            else {
                char old = wasGoal(r, c);
                board[r][c] = (old == ' ') ? " " : "G" + old;
                if (closeWall.row == -1) {
                    // it will meet the goal
                    board[itsGoal.row][itsGoal.col] = " ";
                    removedGoals.add(new Point(itsGoal.row, itsGoal.col));
                    System.out.println("The Color " + color + " met its goal");
                } else {
                    board[wallRow][wallCol + colorsCount + 1] = color;
                }

            }
        }
    }

    void moveOneColorUp(int r, int c, String color, String[][] board, List<Point> movableCells) {

        Point closeWall = findClosestWall(r, c, 'u', board);
        int wallRow = (closeWall.row == -1) ? 0 : closeWall.row;
        int wallCol = (closeWall.col == -1) ? c : closeWall.col;

        Point closUnmovablColor = getCloseUnmovablColor(r, c, wallRow, wallCol, 'u', board, movableCells);
        if (closUnmovablColor.row != -1) {
            // System.out.println("i am in the case where there is unmvable color fo rthe
            // color "+r+" "+c+"and the un is"+closUnmovablColor.row+"
            // "+closUnmovablColor.col);
            wallRow = closUnmovablColor.row;
            wallCol = closUnmovablColor.col;
        }

        int colorsCount = colorsCount(r, c, wallRow, wallCol, board);
        Point itsGoal = checkGoal(r, c, wallRow, wallCol, color, 'u', board);
        ChangeBlankSquare(r, c, wallRow, wallCol, board);

        // case no goal
        if (itsGoal.row == -1) {
            char old = wasGoal(r, c);
            board[r][c] = (old == ' ') ? " " : "G" + old;
            if (closeWall.col != -1) {
                board[wallRow + colorsCount + 1][wallCol] = color;
            }

        }
        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.row - wallRow - 1) >= colorsCount) {
                char old = wasGoal(r, c);
                board[r][c] = (old == ' ') ? " " : "G" + old;
                board[itsGoal.row][itsGoal.col] = " ";
                removedGoals.add(new Point(itsGoal.row, itsGoal.col));
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color,but not case of no wall
            else {
                char old = wasGoal(r, c);
                board[r][c] = (old == ' ') ? " " : "G" + old;
                if (closeWall.col == -1) {
                    // it will meet the goal
                    board[itsGoal.row][itsGoal.col] = " ";
                    removedGoals.add(new Point(itsGoal.row, itsGoal.col));
                    System.out.println("The Color " + color + " met its goal");
                } else {
                    board[wallRow + colorsCount + 1][wallCol] = color;
                }

            }
        }
    }

    void moveOneColorDown(int r, int c, String color, String[][] board, List<Point> movableCells) {

        Point closeWall = findClosestWall(r, c, 'd', board);
        int wallRow = (closeWall.row == -1) ? board.length - 1 : closeWall.row;
        int wallCol = (closeWall.col == -1) ? c : closeWall.col;

        Point closUnmovablColor = getCloseUnmovablColor(r, c, wallRow, wallCol, 'd', board, movableCells);
        if (closUnmovablColor.row != -1) {
            // System.out.println("i am in the case where there is unmvable color fo rthe
            // color "+r+" "+c+"and the un is"+closUnmovablColor.row+"
            // "+closUnmovablColor.col);
            wallRow = closUnmovablColor.row;
            wallCol = closUnmovablColor.col;
        }

        int colorsCount = colorsCount(r, c, wallRow, wallCol, board);
        Point itsGoal = checkGoal(r, c, wallRow, wallCol, color, 'd', board);
        ChangeBlankSquare(r, c, wallRow, wallCol, board);

        // case no goal
        if (itsGoal.row == -1) {
            char old = wasGoal(r, c);
            board[r][c] = (old == ' ') ? " " : "G" + old;
            if (closeWall.col != -1) {
                board[wallRow - colorsCount - 1][wallCol] = color;
            }

        }

        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.row - wallRow - 1) >= colorsCount) {
                char old = wasGoal(r, c);
                board[r][c] = (old == ' ') ? " " : "G" + old;
                board[itsGoal.row][itsGoal.col] = " ";
                removedGoals.add(new Point(itsGoal.row, itsGoal.col));
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color
            else {
                char old = wasGoal(r, c);
                board[r][c] = (old == ' ') ? " " : "G" + old;
                if (closeWall.col == -1) {
                    // it will meet the goal
                    board[itsGoal.row][itsGoal.col] = " ";
                    removedGoals.add(new Point(itsGoal.row, itsGoal.col));
                    System.out.println("The Color " + color + " met its goal");
                } else {
                    board[wallRow - colorsCount - 1][wallCol] = color;
                }
            }
        }
    }

    // print passed board
    public void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].length() == 1) {
                    System.out.print(board[i][j] + "  ");
                } else {
                    System.out.print(board[i][j] + " ");
                }
            }
            System.out.println();
            //
        }
        System.out.println();
    }

    // .......................................................................................................
    public State moveAllColors(char direction, boolean testing) {
        // clone the current state
        State newState = currentstate.copyState();
        String[][] board = newState.board;
        // in case of up or left i want to iterate form top left
        // (ex in case of left,i want the closest to left to be processed first)
        int rStart, rEnd, rStep;
        int cStart, cEnd, cStep;

        if (direction == 'r' || direction == 'd') {
            // bottom right to up
            rStart = board.length - 1;
            rEnd = -1;
            rStep = -1;
            cStart = board[0].length - 1;
            cEnd = -1;
            cStep = -1;
        } else {
            // top left then down
            rStart = 0;
            rEnd = board.length;
            rStep = 1;
            cStart = 0;
            cEnd = board[0].length;
            cStep = 1;
        }

        List<Point> movableCells = new ArrayList<>();

        for (int i = rStart; i != rEnd; i += rStep) {
            for (int j = cStart; j != cEnd; j += cStep) {
                // if color
                if (Character.isLowerCase(board[i][j].charAt(0))) {
                    if (canMove(i, j, direction, board)) {
                        movableCells.add(new Point(i, j));
                    }
                }
            }
        }
        for (Point p : movableCells) {
            // System.out.println("movable cell is"+p.row+" "+p.col);
            int i = p.row;
            int j = p.col;
            switch (direction) {
                case 'r':
                    moveOneColorRight(i, j, board[i][j], board, movableCells);
                    // printBoard(board);
                    break;
                case 'l':
                    moveOneColorLeft(i, j, board[i][j], board, movableCells);
                    // printBoard(board);
                    break;
                case 'u':
                    moveOneColorUp(i, j, board[i][j], board, movableCells);
                    // printBoard(board);
                    break;
                case 'd':
                    moveOneColorDown(i, j, board[i][j], board, movableCells);
                    // printBoard(board);
                    break;
            }
        }
        // update the current state to the new state
        this.currentstate = newState;
        if (!testing) {
            newState.printBoard();
        }

        if (isFinal(board, testing) && !testing) {
            System.exit(0);
        }
        // return the new state after moving
        return newState;
    }

    // .......................................................................................................
    public boolean isFinal(String[][] board, boolean testing) {
        int colorsCount = 0;
        int goalsCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // if color
                if (Character.isLowerCase(board[i][j].charAt(0))) {
                    colorsCount++;
                }
                // if goal
                else if (board[i][j].charAt(0) == 'G') {
                    goalsCount++;
                }
            }
        }
        if (colorsCount == 0) {
            if (goalsCount == 0) {
                if (!testing) {
                    System.out.println("You Won!");
                }
            } else {
                if (!testing) {
                    System.out.println("You Lost!");
                }
            }
            return true;
        }

        // عمل مشكلة لما الالوان قعدت فوق الغوال
        // // If colors and goals counts are not equal(case of open walls)
        // if (colorsCount != goalsCount) {
        // System.out.println("You Lost!");
        // return true;
        // }

        return false;
    }

    // .......................................................................................................

    public char wasGoal(int r, int c) {
        // System.out.println("I AM IN THE WASGOAL ");
        String theGoal = Boards.getGoal(r, c, level);

        if (!theGoal.isEmpty() && doesNotContain(r, c)) {
            // System.out.println("i am in the IF");
            return theGoal.charAt(1);

        }
        return ' ';
    }

    public boolean doesNotContain(int row, int col) {// check if goal in visited walles
        for (Point point : removedGoals) {
            if (point.row == row && point.col == col) {
                return false; // found the point so it exists in the list
            }
        }
        return true; // point not found so it does not exist in the list
    }

    // 1 7 //1 0
    public Point getCloseUnmovablColor(int r1, int c1, int r2, int c2, char direction, String[][] board,
            List<Point> movableCells) {
        int step, start, end;
        if (r1 != r2) {
            start = r1;
            end = r2;
            step = (r1 < r2) ? 1 : -1;
        } else {
            start = c1;// 7
            end = c2;// 0
            step = (c1 < c2) ? 1 : -1;// -1
        }
        // 7 -1
        for (int i = start; i != end + step; i += step) {
            int rindex = (r1 == r2) ? r1 : i;
            int colindex = (c1 == c2) ? c1 : i;
            // 1 i
            if (Character.isLowerCase(board[rindex][colindex].charAt(0))
                    && !isInMovableCells(rindex, colindex, movableCells)) {
                // System.out.println("the board is :");
                // printBoard(board);
                // System.out.println("in the case if "+r1+" "+c1+"close unmovable cell is
                // "+rindex+" "+colindex+"btw r2 and c2 are "+r2+" "+c2);
                return new Point(rindex, colindex);
            }
        }
        return new Point(-1, -1);

    }

    // this one to check if a point is in the recived points list
    public boolean isInMovableCells(int r, int c, List<Point> movableCells) {
        for (Point p : movableCells) {
            if (p.row == r && p.col == c) {
                return true;
            }
        }
        return false;
    }

    public void ChangeBlankSquare(int r1, int c1, int r2, int c2, String[][] board) {
        int start, end, step;
        // same col , up down case
        if (r1 != r2) {
            start = r1;
            end = r2;
            step = (r1 < r2) ? +1 : -1;
        }
        // same row,so left right case
        else {
            start = c1;
            end = c2;
            step = (c1 < c2) ? +1 : -1;
        }

        Character closestColor = board[r1][c1].charAt(0);

        for (int i = start; i != end + step; i += step) {
            // to know if im looping in rows or cols
            int rindex = r1 != r2 ? i : r1;
            int cindex = c1 != c2 ? i : c1;
            if (Character.isLowerCase(board[rindex][cindex].charAt(0))) {
                closestColor = board[rindex][cindex].charAt(0);
            } else if (board[rindex][cindex].equals("B")) {
                board[rindex][cindex] = "G" + closestColor;
            }
        }
    }

    public Map<Character, State> nexStates(boolean wannaPrint) {
        boolean testing = true;
        // to go back to it
        State originalState = currentstate.copyState();

        // Map< State,Character>posStateAndDirection=new LinkedHashMap<>();
        Map<Character, State> possibleStates = new LinkedHashMap<>();

        State leftCase = moveAllColors('l', testing);
        if (!isEqual(leftCase, originalState)) {
            possibleStates.put('l', leftCase);
        }
        currentstate = originalState.copyState();

        State rightCase = moveAllColors('r', testing);
        if (!isEqual(rightCase, originalState)) {
            possibleStates.put('r', rightCase);
        }
        currentstate = originalState.copyState();

        State upCase = moveAllColors('u', testing);
        if (!isEqual(upCase, originalState)) {
            possibleStates.put('u', upCase);
        }
        currentstate = originalState.copyState();

        State downCase = moveAllColors('d', testing);
        if (!isEqual(downCase, originalState)) {
            possibleStates.put('d', downCase);
        }
        currentstate = originalState.copyState();
        // System.out.println("holaaaaaaaaaa, length isss " + possibleStates.size());
        if (wannaPrint) {
            for (char c : possibleStates.keySet()) {
                System.out.println("In case of " + c + " :");
                printBoard(possibleStates.get(c).board);
            }
        }

        return possibleStates;
    }

    public boolean isEqual(State s1, State s2) {
        // System.out.println("i am in isEqual");
        String[][] board1 = s1.board;
        String[][] board2 = s2.board;

        if (board1.length != board2.length || board1[0].length != board2[0].length) {
            // System.out.println("first if checkk");
            return false;
        }

        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1[i].length; j++) {
                if (!board1[i][j].equals(board2[i][j])) {
                    // System.out.println("Oooops gonna return,not equal case for "+board1[i][j]+"
                    // "+board2[i][j]);
                    return false;
                }
            }
        }
        return true;
    }

    public void printPath(List<State> path) {
        // List<State> path = App.path;
        if (path.isEmpty()) {
            System.out.println("you did not take any actions yet");
            return;
        }
        System.out.println("This is the path you took");
        for (State state : path) {
            printBoard(state.board);
        }
    }
}