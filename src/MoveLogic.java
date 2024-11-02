public class MoveLogic {
    private State state;
    private int level;

    public MoveLogic(State state, int level) {
        this.state = state;
        this.level = level;
    }

    private String[][] board() {
        // access the board (which is a copy of the original),the copy itself,not a copy
        // of the copy..getBoard will bring a copy of the copy'
        return state.board;
    }

    // function takes in coordinates and direction then returns Point that represent
    // closest wall in that direction
    Point findClosestWall(int row, int col, char direction) {
        String[][] board = board();
        // System.out.println("row is = " + row + " and col is= " + col + " and
        // board.length= " + board.length
        // + " and board[0].length= " + board[row].length);
        if (row >= 0 && row < board.length && col < board[row].length && col >= 0)// valid point
        {
            // System.out.println("iam in the if");
            // if we want the closest to the left
            if (direction == 'l') {
                for (int i = col - 1; i >= 0; i--) {
                    if (board[row][i].equals("w")) {
                        return new Point(row, i);
                    }
                }
            }
            // if we want the closest to the rihgt
            else if (direction == 'r') {
                for (int i = col + 1; i < board[row].length; i++) {
                    if (board[row][i].equals("w")) {
                        return new Point(row, i);
                    }
                }
            }
            // if we want the closest in the up
            else if (direction == 'u') {
                for (int i = row - 1; i >= 0; i--) {
                    if (board[i][col].equals("w")) {
                        return new Point(i, col);
                    }
                }
            }
            // if we want the closest below
            else if (direction == 'd') {
                for (int i = row + 1; i < board.length; i++) {
                    if (board[i][col].equals("w")) {
                        return new Point(i, col);
                    }
                }
            }
        }
        return new Point(-1, -1);
    }

    // takes in a color square and the closest wall to it then returns the count of
    // color squares between them
    int colorsCount(int r1, int c1, int r2, int c2) {
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
        String[][] board = board();
        for (int i = start + 1; i < end; i++) {
            // two lines to know if im looping in rows or cols(i have start and end,but dont
            // know in board[][] who is i and who is constant)
            int rindex = r1 != r2 ? i : r1;
            int cindex = c1 != c2 ? i : c1;
            if (!board[rindex][cindex].equals(" ") && board[rindex][cindex].charAt(0) != 'G'
                    && !board[rindex][cindex].equals("w")) {// here new
                count++;
            }
        }
        return count;

    }

    // check if my goal exists in the area between me and the wall(dont want it if
    // its after the wall)
    Point checkGoal(int r1, int c1, int r2, int c2, String color, char direction) {
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
        String[][] board = board();
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

    boolean canMove(int r, int c, char direction) {
        String[][] board = board();
        switch (direction) {
            case 'l':
                return c - 1 >= 0 && (board[r][c - 1].equals(" ") || board[r][c - 1].charAt(0) == 'G');// here new
            case 'r':
                return c + 1 < board[r].length && (board[r][c + 1].equals(" ") || board[r][c + 1].charAt(0) == 'G');
            case 'u':
                return r - 1 >= 0 && (board[r - 1][c].equals(" ") || board[r - 1][c].charAt(0) == 'G');
            case 'd':
                return r + 1 < board.length && (board[r + 1][c].equals(" ") || board[r + 1][c].charAt(0) == 'G');
            default:
                return false;
        }
    }

    // .......................................................................................................
    // move one color,these functions wont be called unless the square CAN (not near
    // wall or another color) move in the needed direction
    void moveOneColorRight(int r, int c, String color) {

        Point closeWall = findClosestWall(r, c, 'r');
        int wallRow = (closeWall.row == -1) ? r : closeWall.row;
        int wallCol = (closeWall.col == -1) ? board()[0].length - 1 : closeWall.col;

        int colorsCount = colorsCount(r, c, wallRow, wallCol);
        Point itsGoal = checkGoal(r, c, wallRow, wallCol, color, 'r');

        // case no goal
        if (itsGoal.row == -1) {
            //old to check if it was a goal before,i only care for this when moving from the current place not the distance
            char old = wasGoal(r, c);
            board()[r][c] = (old == ' ') ? " " : "G" + old;
            board()[wallRow][wallCol - colorsCount - 1] = (closeWall.col == -1) ? " " : color;
        }
        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.col - wallCol - 1) >= colorsCount) {
                char old = wasGoal(r, c);
                board()[r][c] = (old == ' ') ? " " : "G" + old;
                board()[itsGoal.row][itsGoal.col] = " ";
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color//not in case of no wall
            else {
                char old = wasGoal(r, c);
                board()[r][c] = (old == ' ') ? " " : "G" + old;
                if (closeWall.row == -1) {
                    // it will meet the goal
                    board()[itsGoal.row][itsGoal.col] = " ";
                    System.out.println("The Color " + color + " met its goal");
                } else {
                    board()[wallRow][wallCol - colorsCount - 1] = color;
                }
            }
        }
    }

    void moveOneColorLeft(int r, int c, String color) {

        Point closeWall = findClosestWall(r, c, 'l');
        int wallRow = (closeWall.row == -1) ? r : closeWall.row;
        int wallCol = (closeWall.col == -1) ? 0 : closeWall.col;

        int colorsCount = colorsCount(r, c, wallRow, wallCol);
        Point itsGoal = checkGoal(r, c, wallRow, wallCol, color, 'l');

        // case no goal for it
        if (itsGoal.row == -1) {
            // System.out.println("case no goal");
            char old = wasGoal(r, c);
            board()[r][c] = (old == ' ') ? " " : "G" + old;
            board()[wallRow][wallCol + colorsCount + 1] = (closeWall.row == -1) ? " " : color;
        }
        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.col - 1 - wallCol) >= colorsCount) {
                char old = wasGoal(r, c);
                board()[r][c] = (old == ' ') ? " " : "G" + old;
                board()[itsGoal.row][itsGoal.col] = " ";
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color
            // in case of no wall,they wont block it
            else {
                char old = wasGoal(r, c);
                board()[r][c] = (old == ' ') ? " " : "G" + old;
                if (closeWall.row == -1) {
                    // it will meet the goal
                    board()[itsGoal.row][itsGoal.col] = " ";
                    System.out.println("The Color " + color + " met its goal");
                } else {
                    board()[wallRow][wallCol + colorsCount + 1] = color;
                }

            }
        }
    }

    void moveOneColorUp(int r, int c, String color) {

        Point closeWall = findClosestWall(r, c, 'u');
        int wallRow = (closeWall.row == -1) ? 0 : closeWall.row;
        int wallCol = (closeWall.col == -1) ? c : closeWall.col;

        int colorsCount = colorsCount(r, c, wallRow, wallCol);
        Point itsGoal = checkGoal(r, c, wallRow, wallCol, color, 'u');

        // case no goal
        if (itsGoal.row == -1) {
            char old = wasGoal(r, c);
            board()[r][c] = (old == ' ') ? " " : "G" + old;
            board()[wallRow + colorsCount + 1][wallCol] = (closeWall.row == -1) ? " " : color;
        }
        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.row - wallRow - 1) >= colorsCount) {
                char old = wasGoal(r, c);
                board()[r][c] = (old == ' ') ? " " : "G" + old;
                board()[itsGoal.row][itsGoal.col] = " ";
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color,but not case of no wall
            else {
                char old = wasGoal(r, c);
                board()[r][c] = (old == ' ') ? " " : "G" + old;
                if (closeWall.col == -1) {
                    // it will meet the goal
                    board()[itsGoal.row][itsGoal.col] = " ";
                    System.out.println("The Color " + color + " met its goal");
                } else {
                    board()[wallRow + colorsCount + 1][wallCol] = color;
                }

            }
        }
    }

    void moveOneColorDown(int r, int c, String color) {

        Point closeWall = findClosestWall(r, c, 'd');
        int wallRow = (closeWall.row == -1) ? board().length - 1 : closeWall.row;
        int wallCol = (closeWall.col == -1) ? c : closeWall.col;

        int colorsCount = colorsCount(r, c, wallRow, wallCol);
        Point itsGoal = checkGoal(r, c, wallRow, wallCol, color, 'd');

        // case no goal
        if (itsGoal.row == -1) {
            char old = wasGoal(r, c);
            board()[r][c] = (old == ' ') ? " " : "G" + old;
            board()[wallRow - colorsCount - 1][wallCol] = (closeWall.row == -1) ? " " : color;
        }

        // case there is goal
        else {
            // if places between wall and goal fit for all other colors,so the color can
            // make it to its goal without it being blocked
            if (Math.abs(itsGoal.row - wallRow - 1) >= colorsCount) {
                char old = wasGoal(r, c);
                board()[r][c] = (old == ' ') ? " " : "G" + old;
                board()[itsGoal.row][itsGoal.col] = " ";
                System.out.println("The Color " + color + " met its goal");
            }
            // other colors will block the goal of the color
            else {
                char old = wasGoal(r, c);
                board()[r][c] = (old == ' ') ? " " : "G" + old;
                if (closeWall.col == -1) {
                    // it will meet the goal
                    board()[itsGoal.row][itsGoal.col] = " ";
                    System.out.println("The Color " + color + " met its goal");
                } else {
                    board()[wallRow - colorsCount - 1][wallCol] = color;
                }
            }
        }
    }

    // print passed board
    public void printBoard(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
            //
        }
        System.out.println();
    }

    // .......................................................................................................
    public void moveAllColors(char direction) {
        String[][] board = board();

        // in case of up or left i want to iterate form top left
        // (ex: in case of left,i want the closest to left to be processed first)
        int rowStart, rowEnd, rowStep;
        int colStart, colEnd, colStep;

        if (direction == 'r' || direction == 'd') {
            // bottom right to up
            rowStart = board.length - 1;
            rowEnd = -1;
            rowStep = -1;
            colStart = board[0].length - 1;
            colEnd = -1;
            colStep = -1;
        } else {
            // top left then down
            rowStart = 0;
            rowEnd = board.length;
            rowStep = 1;
            colStart = 0;
            colEnd = board[0].length;
            colStep = 1;
        }

        for (int i = rowStart; i != rowEnd; i += rowStep) {
            for (int j = colStart; j != colEnd; j += colStep) {
                // if color
                if (!board[i][j].equals(" ") && board[i][j].charAt(0) != 'G' && !board[i][j].equals("w")) {// check here
                                                                                                           // new here
                    if (canMove(i, j, direction)) {
                        switch (direction) {
                            case 'r':
                                moveOneColorRight(i, j, board[i][j]);
                                // printBoard(board);
                                break;
                            case 'l':
                                moveOneColorLeft(i, j, board[i][j]);
                                // printBoard(board);
                                break;
                            case 'u':
                                moveOneColorUp(i, j, board[i][j]);
                                // printBoard(board);
                                break;
                            case 'd':
                                moveOneColorDown(i, j, board[i][j]);
                                // printBoard(board);
                                break;
                        }
                    }
                }
            }
        }
    }

    // .......................................................................................................
    public boolean isFinal(String[][] board) {
        int colorsCount = 0;
        int goalsCount = 0;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // if color
                if (!board[i][j].equals(" ") && board[i][j].charAt(0) != 'G' && !board[i][j].equals("w")) {// here new
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
                System.out.println("You Win!");
            } else {
                System.out.println("You Lost!");
            }
            return true;
        }
        return false;
    }

    // .......................................................................................................
    Boards boards = new Boards();
    String[][] copyFromOriginal = boards.getCopiedBoard(level);

    public char wasGoal(int r, int c) {
        // if in the original its goal,note that it wont be its own goal,cause it wont
        // be above it,they shouldve gone
        if (copyFromOriginal[r][c].charAt(0) == 'G') {
            char color = copyFromOriginal[r][c].charAt(1);
            return color;
        }
        return ' ';
    }
}
