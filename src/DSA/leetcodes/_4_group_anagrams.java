package DSA.leetcodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC 49
 *
 * Given an array of strings strs, group the anagrams
 *  together. You can return the answer in any order.
 *
 *  Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 */
public class _4_group_anagrams {

  public static void main(String[] args) {

    String[] strs = {"eat","tea","tan","ate","nat","bat"};

    System.out.println(groupAnagrams(strs));

  }

  public static List<List<String>> groupAnagrams(String[] strs) {

    Map<String, List<String>> map = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    for(String s: strs) {
        String key = generateFreqString(s);
        if(map.containsKey(key)) {
          var list = map.get(key);
          list.add(s);
          map.put(key, list);
          continue;
        }
          var list = List.of(s);
          map.put(key, new ArrayList<>(list));

    }

    map.forEach((key, val) -> result.add(val));

    return result;
  }

  static String generateFreqString(String s) {
    s = s.toLowerCase();
    int[] freq = new int[26];
    int freqIndex = 0;
    //populate the freq array
    for (int index = 0; index < s.length(); index++) {
      char c = s.charAt(index);
      freq[c - 97]++;
    }
    //forming the string
    StringBuilder sbr = new StringBuilder(s.length());

    for (int index = 0; index < freq.length; index++) {
      int occurence = freq[index];
      if (occurence > 0) {
        char c = (char) (index + 97); //alphabet
        sbr.append(occurence).append(c);
      }
    }

    return sbr.toString();
  }

}
