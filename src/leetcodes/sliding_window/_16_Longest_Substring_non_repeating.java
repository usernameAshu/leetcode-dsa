package leetcodes.sliding_window;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LC 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string s, find the length of the longest substring without duplicate characters.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length of 3.
 */
public class _16_Longest_Substring_non_repeating {

  public static int lengthOfLongestSubstring(String s) {
    int max = 0, currLen = 0;
    Map<Character, Integer> characterMap = new LinkedHashMap<>();
    int idx = 0;
    int initPos = 0;
    while (idx < s.length()) {

      char now = s.charAt(idx);
      if (characterMap.containsKey(now)) {
        //collect the substring , compare and store the max
        currLen = s.substring(initPos,idx).length();
        int prevIdx = characterMap.get(now);
        max = Math.max(currLen, max);
        //characterMap.clear();
        while(initPos <= prevIdx) {
          characterMap.remove(s.charAt(initPos));
          initPos++;
        }
        characterMap.put(now, idx);
        currLen = s.substring(initPos,idx+1).length();
        //currLen = 0;
        //initPos = prevIdx + 1;
      } else {
        characterMap.put(now, idx);
        currLen++;
      }

      //System.out.println(characterMap + "Curr Length :"+ currLen+", Max:"+ max);
      idx++;
    }

    max = Math.max(currLen, max);
    return max;
  }

  public static void main(String[] args) {
//    String s = "abcabcbb";
//    String s = "bbbbb";
//    String s = "pwwkew";
//    String s = " ";
//    String s = "aab";
//    String s = "dvdf";
    String s = "dvdfqwertyfzsa";
    // d
    // dv
    // dvd -> vd
    // vdf
    // "dvdfqwertyfzsa..."
    // vdfqwerty:length -> qwerty
    // qwertyf
    // qwertyfz
    System.out.println(s);
    System.out.println(lengthOfLongestSubstring(s));
  }
}
