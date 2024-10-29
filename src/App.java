public class App {
    static String[][] board = {
            { "w", "w", "w", "w", "w", "w", "w", "w" },
            { "w", "o", "B", "B", "B", "B", "Go", "w" },
            { "w", "w", "w", "w", "w", "w", "w", "w" }
    };
    // {
    // { "w", "b", "Gb", "b", "w", "w", "w", "w" },
    // { "w", "B", "B", "w", "B", "B", "B", "w" },
    // { "w", "O", "B", "B", "B", "B", "B", "w" },
    // { "w", "B", "B", "B", "B", "B", "B", "w" },
    // { "w", "w", "w", "w", "G", "w", "w", "w" },
    // { "B", "B", "B", "w", "w", "w", "B", "B" },
    // };

    public static void main(String[] args) throws Exception {

        moveOneColorRight(1,1,"o");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
            //
        }
        System.out.println();

        // Point closeWall = findClosestWall(1, 3, 'd');
        // System.out.println(closeWall.row + " " + closeWall.col);
        // System.out.println(colorsCount(0, 1, 3, 1));
        // System.out.println(canMove(5,7,'u'));
        // Point p=checkGoal(0,3,0,1,'b','l');
        // System.out.println(p.row+" "+p.col);

    }

    // function takes in coordinates and direction then returns Point that represent
    // closest wall
    static Point findClosestWall(int row, int col, char direction) {
        // System.out.println("row is = " + row + " and col is= " + col + " and
        // board.length= " + board.length
        // + " and board[0].length= " + board[row].length);
        if (row >= 0 && row < board.length && col < board[row].length && col >= 0)// valid point
        {
            // System.out.println("iam in the if");
            // if we want the closest to the left
            if (direction == 'l') {
                for (int i = col - 1; i >= 0; i--) {
                    if (board[row][i] == "w") {
                        return new Point(row, i);
                    }
                }
            }
            // if we want the closest to the rihgt
            else if (direction == 'r') {
                for (int i = col + 1; i < board[row].length; i++) {
                    if (board[row][i] == "w") {
                        return new Point(row, i);
                    }
                }
            }
            // if we want the closest in the up
            else if (direction == 'u') {
                for (int i = row - 1; i >= 0; i--) {
                    if (board[i][col] == "w") {
                        return new Point(i, col);
                    }
                }
            }
            // if we want the closest below
            else if (direction == 'd') {
                for (int i = row + 1; i < board.length; i++) {
                    if (board[i][col] == "w") {
                        return new Point(i, col);
                    }
                }
            }
        }
        return new Point(-1, -1);
    }

    // takes in a color square and the closest wall to it then returns the count of
    // color squares between them
    static int colorsCount(int r1, int c1, int r2, int c2) {
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
            if (board[rindex][cindex] != "B" && board[rindex][cindex] != "G" && board[rindex][cindex] != "w") {
                count++;
            }
        }
        return count;

    }

    // check if my goal exists in the area between me and the wall(dont want it if
    // its after the wall)
    static Point checkGoal(int r1, int c1, int r2, int c2, String color, char direction) {
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

    static boolean canMove(int r, int c, char direction) {
        switch (direction) {
            case 'l':
                return c - 1 >= 0 && (board[r][c - 1] == "B" || board[r][c - 1].charAt(0) == 'G');
            // boundary check AND check if its blank or a goal so i can move
            case 'r':
                return c + 1 < board[r].length && (board[r][c + 1] == "B" || board[r][c + 1].charAt(0) == 'G');
            case 'u':
                return r - 1 >= 0 && (board[r - 1][c] == "B" || board[r - 1][c].charAt(0) == 'G');
            case 'd':
                return r + 1 < board.length && (board[r + 1][c] == "B" || board[r + 1][c].charAt(0) == 'G');

            default:
                return false;
        }
    }

    // .......................................................................................................
    //move one color..these functions wont be called unless the square CAN (not near wall or another color) move in the needed direction 
    static void moveOneColorRight(int r, int c, String color) {
        Point closeWall = findClosestWall(r, c, 'r');
        int colorsCount = colorsCount(r, c, closeWall.row, closeWall.col);
        Point itsGoal = checkGoal(r, c, closeWall.row, closeWall.col, color, 'r');
        // case no goal
        if (itsGoal.row == -1) {
            board[r][c] = "B";
            board[closeWall.row][closeWall.col - colorsCount - 1] = color;
        }
        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.col - closeWall.col - 1) >= colorsCount) {
                board[r][c] = "B";
                board[itsGoal.row][itsGoal.col] = "B";
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color
            else {
                board[r][c] = "B";
                board[closeWall.row][closeWall.col - colorsCount - 1] = color;
            }
        }
    }

    static void moveOneColorLeft(int r, int c, String color) {
        Point closeWall = findClosestWall(r, c, 'l');
        int colorsCount = colorsCount(r, c, closeWall.row, closeWall.col);
        Point itsGoal = checkGoal(r, c, closeWall.row, closeWall.col, color, 'l');
        // case no goal
        if (itsGoal.row == -1) {
            board[r][c] = "B";
            board[closeWall.row][closeWall.col + colorsCount + 1] = color;
        }
        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.col - closeWall.col - 1) >= colorsCount) {
                board[r][c] = "B";
                board[itsGoal.row][itsGoal.col] = "B";
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color
            else {
                board[r][c] = "B";
                board[closeWall.row][closeWall.col + colorsCount + 1] = color;
            }
        }
    }

    static void moveOneColorUp(int r, int c, String color) {
        Point closeWall = findClosestWall(r, c, 'u');
        int colorsCount = colorsCount(r, c, closeWall.row, closeWall.col);
        Point itsGoal = checkGoal(r, c, closeWall.row, closeWall.col, color, 'u');
        // case no goal
        if (itsGoal.row == -1) {
            board[r][c] = "B";
            board[closeWall.row + colorsCount + 1][closeWall.col] = color;
        }
        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.row - closeWall.row - 1) >= colorsCount) {
                board[r][c] = "B";
                board[itsGoal.row][itsGoal.col] = "B";
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color
            else {
                board[r][c] = "B";
                board[closeWall.row + colorsCount + 1][closeWall.col] = color;
            }
        }
    }

    static void moveOneColorDown(int r, int c, String color) {
        Point closeWall = findClosestWall(r, c, 'l');
        int colorsCount = colorsCount(r, c, closeWall.row, closeWall.col);
        Point itsGoal = checkGoal(r, c, closeWall.row, closeWall.col, color, 'l');
        // case no goal
        if (itsGoal.row == -1) {
            board[r][c] = "B";
            board[closeWall.row - colorsCount - 1][closeWall.col] = color;
        }
        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.row - closeWall.row - 1) >= colorsCount) {
                board[r][c] = "B";
                board[itsGoal.row][itsGoal.col] = "B";
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color
            else {
                board[r][c] = "B";
                board[closeWall.row - colorsCount - 1][closeWall.col] = color;
            }
        }
    }
}
