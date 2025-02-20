package leetcodes._1D_DP;

import java.util.Arrays;

public class _9_fibonacci_DP {

  static int i = 1;

  public static void main(String[] args) {
      int times = 10;
      int[] mem = new int[times + 1]; //taking 1 size more array so that no need to take care of 0 indexing
    System.out.println(fibonacci(times, mem));
  }

  static int fibonacci(int n, int[] mem) {
    if(mem[n] != 0)
      return mem[n];

    int result = 0;
    if(n == 1 || n == 2)
      result = 1;
    else {
      result = fibonacci(n-1, mem) + fibonacci(n - 2, mem);
    }
    mem[n] = result;
    System.out.println(Arrays.toString(mem));
    return result;
  }

}
