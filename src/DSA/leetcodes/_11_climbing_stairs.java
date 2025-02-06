package DSA.leetcodes;


/**
 * LC 70. Climbing Stairs
 *
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class _11_climbing_stairs {

  /**
   * This is a DP memoization problem, where we are storing the result of leaf in a cache
   * Base condition:
   * We can reach to Step-0 in 1 way, We can reach to Step-1 in 1 way.
   * So, no. of steps to 'n' step is the summation of no. of steps to (n-1) and (n-2) step.
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(new _11_climbing_stairs().climbStairs(5));
  }

  public int climbStairs(int n) {
    int[] mem = new int[n + 1];
    return climbStairs(n, mem);
  }

  public int climbStairs(int n, int[] mem) {
    //Base condition
    if (n == 0 || n == 1) {
      return 1;
    }

    if (mem[n] != 0) {
      return mem[n];
    }

    //DPRC : Dynamic Prog Recursive condition
    int result = climbStairs(n - 2, mem) + climbStairs(n - 1, mem);
    mem[n] = result;
    //System.out.println(Arrays.toString(mem));
    return result;
  }


}
