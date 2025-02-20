package leetcodes.arrays_hashing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * LC 347. Top K Frequent Elements
 * <p>
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return
 * the answer in any order.
 * <p>
 * Example 1: Input: nums = [1,1,1,2,2,3], k = 2 Output: [1,2]
 * <p>
 * Example 2: Input: nums = [1], k = 1 Output: [1]
 */
public class _5_Top_K_Freq_Element {

  public static void main(String[] args) {
      int[] nums = {1,1,1,2,2,3};
      int k = 2;
      int[] result = topKFrequent(nums, k);

    System.out.println(Arrays.toString(result));
  }

  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    //map the frequency
    for (int n : nums) {
      if (map.containsKey(n)) {
        int val = map.get(n);
        val++;
        map.put(n, val);
        continue;
      }
      map.put(n, 1);
    }
    //System.out.println(map);
    //sort the map by value in descending order

    Map<Integer, Integer> sortedMap = map.entrySet()
        .stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(
            Map.Entry::getKey, //key mapper
            Map.Entry::getValue, //value mapper
            (oldValue, newValue) -> oldValue, //to handle duplicate keys in Map.Entry
            LinkedHashMap::new //Supplier
        ));

    //System.out.println(sortedMap);
    //load elements to array
    int[] result = new int[k];
    int index = 0;
    for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
      result[index] = entry.getKey();
      if(++index == k)
        break;
    }

    return result;
  }

}
