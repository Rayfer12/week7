import java.util.Scanner;

public class WordSearchMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input grid
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of columns:");
        int cols = scanner.nextInt();
        scanner.nextLine(); 
        char[][] grid = new char[rows][cols];

        System.out.println("Enter the grid:");
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

       
        System.out.println("Enter the number of words:");
        int numWords = scanner.nextInt();
        scanner.nextLine(); 
        String[] words = new String[numWords];

        System.out.println("Enter the words:");
        for (int i = 0; i < numWords; i++) {
            words[i] = scanner.nextLine();
        }

      
        WordSearchSolver solver = new WordSearchSolver(grid, words);
        int matches = solver.solvePuzzle();
        System.out.println("Total matches found: " + matches);

        scanner.close();
    }
}
