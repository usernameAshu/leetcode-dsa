package leetcodes;

import java.util.Arrays;
import java.util.List;

public class _11_Stair_jumps {

  /**
   * You have a jump array saying how many stairs to jump going up/down.
   * The least stair is 1.
   * Now we need to figure out what can be the minimum starting stair, in order to
   * complete the jumps so that we never come down from first staircase i.e. 1
   * i/p:[1,-2, -4, 3]
   * o/p: stating stair: 6
   */
    static int getStartingStair(List<Integer> jumpList) {
      int jsize = jumpList.size();
      int[] stairs = new int[jsize+1];
      int[] jumps = new int[jsize+1];
      int idx = 0;
      for(int j : jumpList) {
        jumps[idx] = j;
        idx++;
      }

      int startingStair = 1;
      stairs[0] = startingStair;
      int initialStep = 1;
      System.out.println("Jumps:" + Arrays.toString(jumps)+ " Starting point: "+ startingStair);
      return calc(initialStep, stairs, jumps);
    }

    static int calc(int step, int[] stairs, int[] jumps) {
      //base condition
      if(step == stairs.length) {
        return stairs[0];
      }

      int currStepVal = stairs[step - 1] + jumps[step - 1];
      if(currStepVal < 1) {
        //we need to backtrack and increase our initial stair value
        stairs[0] = stairs[0] + 1;
        step = 1; //starting from begining
        System.out.println("Negative path:" +Arrays.toString(stairs));
        return calc(step, stairs, jumps);
      } else {
        //happy path
        stairs[step] = currStepVal;
        step++;
        System.out.println("Happy path:" + Arrays.toString(stairs));
        return calc(step,stairs, jumps);
      }
    }

  public static void main(String[] args) {
    List<Integer> jumps = List.of(1,-2,-4,3);
    System.out.println(getStartingStair(jumps));
  }
}
