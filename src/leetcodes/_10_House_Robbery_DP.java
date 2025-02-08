package leetcodes;

/**
 * LC: 198 There is an array of integers representing networth of Houses sequentially Robbers are
 * planning to loot the houses But, they can't rob houses adjacent to each other, else they will be
 * caught. So, find out how much can be robbed at most ?
 */
public class _10_House_Robbery_DP {

  public static void main(String[] args) {
    int[] houses = {5, 1, 2, 10, 6, 2, 7, 9, 3, 1};
    System.out.println("Max loot:"+ rob(houses));
  }

  /**
   *We are storing adjacent-max (rob2) and non-adjacent-max (rob1)
   * Each time we check the max of, (sum of non-adjacent-max and current-element) & adjacent-max
   * Non-adjacent-max is moved to adjacent-max
   * adjacent-max is assigned the max
   */
  public static int rob(int[] nums) {
    int rob1 =0,rob2 = 0,max = 0;

    for(int i =0 ; i < nums.length; i++) {
      max = Math.max(rob1+nums[i], rob2);
      rob1 = rob2;
      rob2 = max;
    }

    return max;
  }

}
