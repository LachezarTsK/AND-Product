import java.util.Scanner;

public class SolutionThree {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int numberOfTestCases = scanner.nextInt();

    while (numberOfTestCases-- > 0) {
      long min = scanner.nextLong();
      long max = scanner.nextLong();
      System.out.println(find_bitwiseAND_inRange(min, max));
    }
    scanner.close();
  }

  /**
   * The bitwise operation x & y = 1, only if both bits 'x' and 'y' have a value of '1'. 
   * Thus, performed on an inclusive range of integers, all the bits in the corresponding 
   * columns of the integer range have to be with value '1' in order for the result 
   * of this column to be equal to '1'.
   *
   *@return A long integer, representing the value of the bitwise operation 'AND',
   *        performed on all integers within the range.
   */
  private static long find_bitwiseAND_inRange(long min, long max) {
    long result = 0;
    String maxToBinary = Long.toBinaryString(max);
    int exponent = maxToBinary.length() - 1;

    for (int i = 0; i < maxToBinary.length(); i++) {

      if (maxToBinary.charAt(i) == '1') {

        if (result + Math.pow(2, exponent) <= min) {
          result += (long) Math.pow(2, exponent);
        } else {
          break;
        }
      }
      exponent--;
    }

    return result;
  }
}
