package leetcodes.arrays_hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 271. Encode and Decode Strings Design an algorithm to encode a list of strings to a single
 * string. The encoded string is then decoded back to the original list of strings.
 * <p>
 * Please implement encode and decode
 * <p>
 * Example 1: Input: ["neet","code","love","you"] Output:["neet","code","love","you"]
 * <p>
 * Example 2: Input: ["we","say",":","yes"] Output: ["we","say",":","yes"]
 */
public class _6_Encode_Decode_String {

  /**
   * Lets approach by appending {length_of_string}:{string}
   * So we encode the string array by appending the {length}: to the front
   * Then, when we decode the string , we collect the number (remember collection will be in char till u encounter `:`)
   * Take substring chunk of the encoded string and put it in the result array.
   * Return the result array
   * @param strs
   * @return
   */
  public static String encode(List<String> strs) {
    return
        strs
            .stream()
            .reduce("",
                (acc, str) -> acc + str.length() + ":" + str,
                (s1, s2) -> s1 + s2);
  }

  public static List<String> decode(String str) {
    List<String> result = new ArrayList<>();
    int idx = 0;
    int incl, excl = 0;
    while (idx < str.length()) {

      StringBuilder sbr = new StringBuilder();
      //collect the prefixed number
      while(str.charAt(idx) != ':') {
        sbr.append(str.charAt(idx));
        idx++;
      }
      int len = Integer.parseInt(sbr.toString());
      incl = idx + 1;
      excl = incl + len;
      result.add(str.substring(incl, excl));
      idx = excl;
    }
    return result;
  }

  public static void main(String[] args) {
//    List<String> list = List.of("neet", "code", "love", "you");
//    List<String> list = List.of("");
    List<String> list = List.of("we", "say", ":", "yes", "!@#$%^&*()");
    System.out.println("Input: "+ list);
    String encoded = encode(list);
    System.out.println("Encoded: "+encoded);
    List<String> decode = decode(encoded);
    System.out.println(decode.size());
    System.out.println("Output:" +decode);

  }
}
