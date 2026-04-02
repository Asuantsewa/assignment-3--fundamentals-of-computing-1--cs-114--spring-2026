import java.util.Scanner;
public class Diamond {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int n = scan.nextInt();
    if (n <= 0) {
      System.out.println("Number must be positive !")
    }
    scan.close();
  }
}
