package leetcodes._1D_DP;

import static java.lang.Math.*;

/**
 * LC 152. Maximum Product Subarray Given an integer array nums, find a subarray that has the
 * largest product, and return the product.
 * <p>
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * <p>
 * Input: nums = [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product 6.
 */
public class _13_Maximum_Product_Subarray {

  public static void main(String[] args) {
    int[] nums = {5, 3, 1, -2, 0, -5, 8, -3};
    System.out.println(maxProduct(nums));
  }

  /**
   * Take reference: https://www.youtube.com/watch?v=OuRQ_TCCjsU
   * This is a dynamic problem.
   * Approach: we create 4 variables to store the val, current-min and current-max and answer
   * val is the value at index i
   * current-min is the min of (value, value*prevMin, value*prevMax)
   * current-max is the max of (value, value*prevMin, value*prevMax)
   * answer will store the max of (answer , current-max)
   * then reassign current values to previous min/max values.
   * return the answer.
   */
  public static int maxProduct(int[] nums) {
    int prevMin = nums[0], prevMax = nums[0], ans = nums[0];
    int idx = 1;
    int L = nums.length;
    while (idx < L) {
      int val = nums[idx];
      int currMin = min(val, min(val * prevMin, val * prevMax));
      int currMax = max(val, max(val * prevMin, val * prevMax));
      ans = Math.max(ans, currMax);
      prevMin = currMin;
      prevMax = currMax;
      idx++;
    }
    return ans;
  }
}
