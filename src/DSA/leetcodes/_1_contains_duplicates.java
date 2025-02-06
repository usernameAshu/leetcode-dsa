package DSA.leetcodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * LC 217
 * Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 * i/p: nums = [1,2,3,4] o/p: false
 * i/p: nums = [1,1,1,3,3,4,3,2,4,2], o/p: true
 */
public class _1_contains_duplicates {

  public static void main(String[] args) {
    int[] nums = {1,2,3,4,1};

    System.out.println(containsDuplicate(nums));

  }

  public static boolean containsDuplicate(int[] nums) {
    boolean flag = false;
    Set<Integer> set = new HashSet<>();
    for(int n: nums) {
      if(set.contains(n)) {
        flag = true;
        break;
      }
      set.add(n);
    }
    return flag;
  }

}
