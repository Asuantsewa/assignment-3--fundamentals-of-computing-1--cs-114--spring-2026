import java.util.Scanner;
public class Diamond {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a number: ");
    int size = scan.nextInt();
    if (size <= 0) {
      System.out.println("Number must be positive !");
      return;
    }
    if (size % 2 == 0) {
    }



    // odd diamond
    public static void OddDiamond(int n) {
      int mid = (size/2);

      for (int i = 0; i <n; i++){
        int stars = i <= mid ? (2 * i + 1) : (2*(n -1 - i) + 1);
        int spaces = Math.abs(mid - i);

        for (int s = 0; s < spaces; s++){
          System.out.print(" ");
        }
        for (int st = 0; s < stars; st++);
        Sysytem.out.print("*");
      }
      System.out.println();
    }
    scan.close();
  }
}
