package leetcodes.arrays_hashing;

/**
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * using all the original letters exactly once.
 * <p>
 * Input: s = "anagram", t = "nagaram", o/p: true Input: s = "rat", t = "car", o/p: false
 */
public class _2_valid_anagram {

  public static void main(String[] args) {
      String s = "rat";
      String t = "car";

    System.out.println(isAnagram(s,t));
  }

  public static boolean isAnagram(String s, String t) {
    if (s.length() != t.length())
      return false;
    if (generateFreqString(s).equals(generateFreqString(t))) {
      return true;
    }
    return false;
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
