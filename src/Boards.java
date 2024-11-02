public class Boards {

    public static String[][][] initBoards = {
            {
                    { "w", "w", "w", "w", "w", "w", "w", "w" },
                    { " ", "h", "o", "Gh", "w", " ", "w", "w" },
                    { "w", "w", "w", "w", "w", "w", "w", "w" }
            },
            // {
            // { "w", "w", "w", "w", "w", "w", "w", "w" },
            // { "w", " ", "Go", " ", "o", "h", "w", "w" },
            // { "w", "w", "w", "w", "w", "w", "w", "w" }
            // },
            {
                    { "w", "w", "w", "w", "w", "w", "w", "w" },
                    { "w", " ", " ", "w", "o", " ", " ", "w" },
                    { "w", " ", " ", " ", " ", " ", " ", "w" },
                    { "w", " ", " ", " ", " ", " ", " ", "w" },
                    { "w", "w", "w", "w", "Go", "w", "w", "w" },
                    { " ", " ", " ", "w", "w", "w", " ", " " },
            },
            {
                    { " ", " ", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w" },
                    { " ", " ", "w", " ", " ", " ", " ", " ", " ", " ", " ", " ", "w" },
                    { "w", "w", "w", " ", " ", "w", "w", "w", "w", "w", "w", " ", "w" },
                    { "w", "o", " ", " ", " ", " ", "Go", " ", " ", " ", "w", " ", "w" },
                    { "w", " ", "w", " ", " ", " ", " ", " ", " ", " ", "w", " ", "w" },
                    { "w", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "w" },
                    { "w", "w", "w", "w", " ", " ", " ", " ", " ", " ", " ", " ", "w" },
                    { " ", " ", " ", "w", "w", "w", "w", "w", "w", "w", "w", "w", "w" },
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

        if (level >= 0 && level < initBoards.length) {
            String[][] original = initBoards[level];
            String[][] theCopy = new String[original.length][];

            for (int i = 0; i < original.length; i++) {
                theCopy[i] = original[i].clone();
            }
            return theCopy;
        } else {
            System.err.println("No Such level");
            return null;
        }

    }

}
