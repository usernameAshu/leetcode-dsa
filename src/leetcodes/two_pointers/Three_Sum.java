package leetcodes.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * LC 15: 3Sum Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such
 * that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4] Output: [[-1,-1,2],[-1,0,1]] Explanation: nums[0] + nums[1] +
 * nums[2] = (-1) + 0 + 1 = 0. nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0. nums[0] + nums[3] +
 * nums[4] = (-1) + 2 + (-1) = 0. The distinct triplets are [-1,0,1] and [-1,-1,2]. Notice that the
 * order of the output and the order of the triplets does not matter.
 */
public class Three_Sum {

  public static void main(String[] args) {
//    int[] nums = {-1,0,1,2,-1,-4};
    int[] nums = {-2, 0, 0, 2, 2};
    System.out.println(threeSum(nums));
  }

  /**
   * we will be using a N square time complexity here. First, we will sort the array, then, iterate over the array.
   * here we take care, we don't create combinations with the same element from the outer loop
   * in the loop, we now have two pointers one at the left and another one at the right
   * calculate the sum of the left and right pointers if the sum is less than the target, then we increase the left pointer
   * else we decrease the right pointer.when we reach the target, then we add the three values to the combination array.
   * in the inner loop, when the value reaches the target, we add the combinations in the array, and we decrease the left and right pointers.
   * here, we make sure that we do not generate duplicate combinations as well.
   * @param nums
   * @return
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    // [-1,0,1,2,-1,-4]
    // [-4,-1,-1,0,1,2]
    System.out.println(Arrays.toString(nums));
    List<List<Integer>> combinations = new ArrayList<>();
    int L = nums.length;
    int l, r;
    for (int i = 0; i < L - 2; i++) {
      List<Integer> combination = null;

      //We donot want to compute the combinations with same starting value
      if (i > 0 && nums[i] == nums[i - 1]) {
        continue;
      }
      int target = -nums[i];
      l = i + 1;
      r = L - 1;

      //Scanning the array from left & right, then incrementing/decrementing depending on sum & target
      while (l < r) {
        //We donot want to compute the same combination with same left or right values
        if(l > i+1 && nums[l] == nums[l-1]) {
          l++;
          continue;
        }
        int sum = nums[l] + nums[r];
        if (sum > target) {
          r--;
        } else if (sum < target) {
          l++;
        } else {
          combination = List.of(nums[i], nums[l], nums[r]);
          combinations.add(combination);
          l++;
          r--;
        }
      }

    }

    return combinations;
  }
}
