package leetcodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * LC 239 Maximum Sliding Window
 *
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class _14_Maximum_Sliding_window {

  public static void main(String[] args) {
//    int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
//    int[] nums = {1, -1};
//    int[] nums = {7,2,4};
    int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
    int k = 5;
    System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
  }

  /**
   * Refer video: https://www.youtube.com/watch?v=WgShcE36itI
   * Explaination:
   *
   */
  public static int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new LinkedList<>();
    int L = nums.length;
    List<Integer> result = new ArrayList<>();
    int l = 0, r = 0;

    while (r < L) {
      //peek elements from end and place it as minimum value
      //i.e. any lesser elements in front of this value, will be polled.
      while (!deque.isEmpty() && nums[r] > deque.peekLast()) {
        deque.pollLast();
      }
      deque.offerLast(nums[r]);

      //now we slide the window
      if (k <= r - l + 1) {

        //we populate the max from queue in result list
        result.add(deque.peekFirst());
        //we check whether the left element is present as the max element of deque
        //if yes we poll it out of the deque
        if (!deque.isEmpty() && deque.peekFirst() == nums[l++]) {
          deque.pollFirst();
        }
      }
      r++;
    }
    int[] rarr = new int[result.size()];
    int resultIdx = 0;
    for(int el: result) {
      rarr[resultIdx++] = el;
    }
    return rarr;
  }

}
