package DSA.leetcodes;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * LC 128
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *
 * You must write an algorithm that runs in O(n) time.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [100,4,200,1,3,2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */
public class _12_Longest_Subsequence {

  /**
   *
   * @param nums
   * @return
   */
  public static int longestConsecutive(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    Set<Integer> set = new TreeSet<>();
    for (int n : nums) {
      set.add(n);
    }
    System.out.println(set);

    int size = set.size();
    int currMax = 1; //because one number is sequence in itself
    int newMax = 0;
    int l = 0, r = 1;
    Iterator<Integer> iterator = set.iterator();
    int right = 0;
    int left = iterator.next();
    while (r < size) {
      right = iterator.next();
      if (left + 1 == right) {
        currMax++;
      } else {
        newMax = Math.max(newMax, currMax);
        currMax = 1;
      }
      l = l + 1;
      r = r + 1;
      left = right;
    }

    newMax = Math.max(newMax, currMax); //if all numbers are consecutive

    return newMax;
  }

  public static void main(String[] args) {
//    int[] nums = {100, 4, 200, 1, 3, 2};
//    int[] nums = {0,3,7,2,5,8,4,6,0,1};
    int[] nums = {0};
    System.out.println(longestConsecutive(nums));
  }

}
