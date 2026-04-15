import java.util.Scanner;

public class Matrix {
  private static final String HIGHLIGHT_COLOR = "\u001b[33m\u001b[1m"; 
  private static final String RESET_COLOR = "\u001b[0m";

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int matrixSize = 0;

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
System.out.println(" Initial Matrix ");
printMatrix(matrix, matrixSize, false); 

 populateMatrix(matrix, matrixSize);
  System.out.println(" Populated Matrix  ");
  printMatrix(matrix, matrixSize, true);

flipMatrix(matrix, matrixSize);

System.out.println(" Flipped Matrix  ");

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
for (int i = 0; i < size; i++) {
  for (int j = 0; j < size; j++) {
    if (i + j < size - 1) { 
    int oppositeRow = size - 1 - j;
    int oppositeCol = size - 1 - i;

int temp = matrix[i][j];
matrix[i][j] = matrix[oppositeRow][oppositeCol];
matrix[oppositeRow][oppositeCol] = temp;
      }
    }
  }
}
private static void printMatrix(int[][] matrix, int size, boolean highlightDiagonal) {
int paddingWidth = String.valueOf(size * size).length() + 2;

for (int i = 0; i < size; i++) {
    for (int j = 0; j < size; j++) {

  boolean isAntiDiagonal = (i + j == size - 1);

if (highlightDiagonal && isAntiDiagonal) {
  System.out.print(HIGHLIGHT_COLOR); 
}
System.out.printf("%" + paddingWidth + "d", matrix[i][j]);

if (highlightDiagonal && isAntiDiagonal) {
  System.out.print(RESET_COLOR); 
  }
}
  System.out.println(); 
    }
  }
}
