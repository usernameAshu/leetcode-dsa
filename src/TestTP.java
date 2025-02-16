import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestTP {

  /**
   * They talked it over, and they was going to rule me out, because they said every boy must have a
   * family or somebody to kill, or else it wouldn’t be fair and square for the others. Well, nobody
   * could think of anything to do—everybody was stumped, and set still. I was most ready to cry;
   * but all at once I thought of a way, and so I offered them Miss Watson—they could kill her.
   * Everybody said:
   */

  public static void main(String[] args) {
    String input = "They talked it over, and they was going to rule me out, because they said every boy must have a family or somebody to kill, or else it wouldn’t be fair and square for the others. Well, nobody could think of anything to do—everybody was stumped, and set still. I was most ready to cry; but all at once I thought of a way, and so I offered them Miss Watson—they could kill her. Everybody said:";

    //frequency of consonants
    //t - 10
    //h - 8

    Set<Character> vowels = new HashSet<>(List.of('a','e','i','o','u'));

    input = input.toLowerCase();
    Map<Character, Integer> map = new HashMap<>();

    String[] inputArr = input.split(" ");
    System.out.println(Arrays.toString(inputArr));

    for(int i =0;i<input.length();i++) {
      char c = input.charAt(i);
      if(!vowels.contains(c) && c >= 97 && c <= 122) {
        //consonants
        if(map.containsKey(c)) {
          int val = map.get(c);
          map.put(c, ++val);
        } else {
          map.put(c,1);
        }
      }
    }

    System.out.println(map);


  }
}
