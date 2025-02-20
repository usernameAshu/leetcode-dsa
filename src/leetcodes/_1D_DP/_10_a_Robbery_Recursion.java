package leetcodes._1D_DP;

import java.util.HashMap;
import java.util.Map;

public class _10_a_Robbery_Recursion {

  public static void main(String[] args) {
    int[] houses = {5, 1, 2, 10, 6, 2, 7, 9, 3, 1};
    System.out.println(rob(houses));
  }

  private static Map<Integer, Integer> memo = new HashMap<>();

  public static int rob(int[] nums) {
    // Get the last index of the array (zero-based index)
    // Comment explaining comment: We start from the last house and recursively decide whether to rob it or not.
    int n = nums.length - 1;
    return rob(n, nums);
  }


  private static int rob(int i, int[] nums) {
    // Base Case 1: If we are at the first house (index 0), the best we can do is rob it.
    // Comment explaining comment: We cannot skip the first house because there are no previous ones to compare.
    if (i == 0)
      return nums[0];

    // Base Case 2: If we are at the second house (index 1), we can either rob house 0 or house 1.
    // Comment explaining comment: We must take the maximum of the first house alone or the second house alone.
    if (i == 1)
      return Math.max(nums[0], nums[1]);

    // Check if we have already calculated the result for this index `i`
    // Comment explaining comment: Memoization avoids recalculating results for `rob(i)`, optimizing time complexity.
    if (memo.containsKey(i))
      return memo.get(i);

    // Recurrence Relation:
    // Either we:
    // 1. Rob this house (nums[i]) and skip the previous house (rob(i-2))
    // 2. Skip this house and rob up to the previous house (rob(i-1))
    // Comment explaining comment: This is the main DP logic where we decide the optimal choice at index `i`.
    int maxRobbed = Math.max(rob(i - 2, nums) + nums[i], rob(i - 1, nums));

    // Store the computed result in memo to avoid redundant calculations
    // Comment explaining comment: Storing the result ensures we don't recompute `rob(i)` for the same `i` again.
    memo.put(i, maxRobbed);
    System.out.println(memo);
    // Return the computed maximum amount for index `i`
    return memo.get(i);
  }

}
