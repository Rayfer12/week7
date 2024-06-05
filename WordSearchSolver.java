import java.util.Arrays;

public class WordSearchSolver {
    private char[][] grid;
    private String[] words;

    public WordSearchSolver(char[][] grid, String[] words) {
        this.grid = grid;
        this.words = words;
    }

    public int solvePuzzle() {
        int matches = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                for (int rd = -1; rd <= 1; rd++) {
                    for (int cd = -1; cd <= 1; cd++) {
                        if (!(rd == 0 && cd == 0)) {
                            matches += solveDirection(row, col, rd, cd);
                        }
                    }
                }
            }
        }

        return matches;
    }

    private int solveDirection(int baseRow, int baseCol, int rowDelta, int colDelta) {
        int matches = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int currentRow = baseRow;
        int currentCol = baseCol;

        while (currentRow >= 0 && currentRow < rows && currentCol >= 0 && currentCol < cols) {
            StringBuilder sequence = new StringBuilder();
            sequence.append(grid[currentRow][currentCol]);

            for (int i = 0; i < words.length; i++) {
                int result = prefixSearch(words, sequence.toString());
                if (result >= 0) {
                    matches++;
                    System.out.println("Found " + words[result] + " at [" + baseRow + "," + baseCol + "] to [" + currentRow + "," + currentCol + "]");
                }
            }

            currentRow += rowDelta;
            currentCol += colDelta;
        }

        return matches;
    }

    private static int prefixSearch(String[] a, String x) {
        Arrays.sort(a);
        return Arrays.binarySearch(a, x);
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'J', 'K', 'L'},
            {'M', 'N', 'O', 'P'}
        };

        String[] words = {"AB", "EF", "KJ", "NH", "DC", "HK"};

        WordSearchSolver solver = new WordSearchSolver(grid, words);
        int matches = solver.solvePuzzle();
        System.out.println("Total matches found: " + matches);
    }
}
