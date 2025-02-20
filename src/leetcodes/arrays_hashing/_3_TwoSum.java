package leetcodes.arrays_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _3_TwoSum {

  public static void main(String[] args) {
    int target = 10;
    int[] a = {2, 3, 4, 5, 7, 1};
    int[] result = twoSum(a, target);
    Arrays.stream(result).forEach(r -> System.out.print(r+" "));
  }

  static int[] twoSum(int[] a, int target) {
    Map<Integer, Integer> compTable = new HashMap<>();

    for(int index = 0; index < a.length ; index++) {

      int compliment = target - a[index];

      if(compTable.containsKey(a[index])) {
        return new int[]{compTable.get(a[index]), index};
      }
      compTable.put(compliment, index);
    }

    return new int[]{};
  }
}
