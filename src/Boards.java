public class Boards {

    public static String[][][] initBoards = {
            {
                    { "W", "W", "W", "W", "W", "W", "W", "W" },
                    { "W", " ", " ", "o", " ", " ", "Go", "W" },
                    { "W", "W", "W", "W", "W", "W", "W", "W" }
            },
            {
                    { "W", "W", "W", "W", "W", "W", "W", "W" },
                    { "W", " ", " ", "W", " ", " ", " ", "W" },
                    { "W", "o", " ", " ", " ", " ", " ", "W" },
                    { "W", " ", " ", " ", " ", " ", " ", "W" },
                    { "W", "W", "W", "W", "Go", "W", "W", "W" },
                    { " ", " ", " ", "W", "W", "W", " ", " " },
            },
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
            {
                    { "W", "W", "W", "W", "W", "W", " ", " ", " " },
                    { "W", "Go", " ", " ", " ", "W", "W", " ", " " },
                    { "W", " ", " ", "Gb", " ", " ", "W", "W", "W" },
                    { "W", " ", " ", " ", " ", " ", "b", "o", "W" },
                    { "W", "W", "W", "W", "W", "W", "W", "W", "W" },
            },
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
        {
            { " ", "W", "W", "W", " ", " ", " ", " "},
            { "W", "W", "Gy", "W", "W", "W", "W", "W"},
            { "W", "y", "o", "b", " ", " ", " ", "W"},
            { "W", "Gb", "W", "Go", "W", "W", "W", "W"},
            { "W", "W", "W", "W", "W", " ", " ", " "},
    },

    };

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
