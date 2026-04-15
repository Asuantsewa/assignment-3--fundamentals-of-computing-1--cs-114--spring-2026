import java.util.Scanner;

public class Matrix {
  private static final String HIGHLIGHT_COLOR = "\u001b[33m\u001b[1m"; 
  private static final String RESET_COLOR = "\u001b[0m";

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int matrixSize = 0;

//  Request a positive number for the size of the matrix
while (matrixSize <= 0) {
  System.out.print("Enter a positive integer for the matrix size: ");
  if (scanner.hasNextInt()) {
  matrixSize = scanner.nextInt();
    if (matrixSize <= 0) {
        System.out.println("Size must be a positive integer. Please try again.");
    }
    } else {
        System.out.println("Invalid input. Please enter a whole number.");
        scanner.next(); 
  }
}
int[][] matrix = new int[matrixSize][matrixSize];
//  Prints the matrix consisting of 0s 
System.out.println(" Initial Matrix ");
// Print the matrix, but don't highlight the diagonal yet.
printMatrix(matrix, matrixSize, false); 
// Populate the matrix (1 to N*N) and Print it 
 populateMatrix(matrix, matrixSize);
    System.out.println(" Populated Matrix  ");
    // Now print the matrix and highlight the anti-diagonal.
    printMatrix(matrix, matrixSize, true);

    flipMatrix(matrix, matrixSize);

        //  STEP 6: Print the flipped matrix 
    System.out.println(" Flipped Matrix  ");
        // Print the final result, keeping the diagonal highlighted.
    printMatrix(matrix, matrixSize, true);

    scanner.close(); 
}
private static void populateMatrix(int[][] matrix, int size) {
    int currentValue = 1;
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            matrix[i][j] = currentValue++;
        }
    }
}
private static void flipMatrix(int[][] matrix, int size) {
// We only iterate through the upper-right triangle (i + j < size - 1)
// to ensure that each pair is swapped only once.
for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
// If the element is above/left of the anti-diagonal, it needs swapping.
    if (i + j < size - 1) { 
// The coordinate for the symmetric element across the anti-diagonal.
    int oppositeRow = size - 1 - j;
    int oppositeCol = size - 1 - i;

// Standard swap using a temporary variable
int temp = matrix[i][j];
matrix[i][j] = matrix[oppositeRow][oppositeCol];
matrix[oppositeRow][oppositeCol] = temp;
      }
    }
  }
}
private static void printMatrix(int[][] matrix, int size, boolean highlightDiagonal) {
 // Calculate the maximum padding width required for the largest number (N*N).
int paddingWidth = String.valueOf(size * size).length() + 2;

for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {
// Condition for the anti-diagonal: row index + column index equals size - 1
    boolean isAntiDiagonal = (i + j == size - 1);

    if (highlightDiagonal && isAntiDiagonal) {
        System.out.print(HIGHLIGHT_COLOR); 
}
                
// Use printf to ensure uniform spacing for all numbers.
System.out.printf("%" + paddingWidth + "d", matrix[i][j]);

if (highlightDiagonal && isAntiDiagonal) {
    System.out.print(RESET_COLOR); 
  }
}
    System.out.println(); // Newline after each row
    }
  }
}
