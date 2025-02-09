public class TestGuideWire {

  public static void main(String[] args) {

  }

}

// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// //System.out.println("this is a debug message");

//Max sum <= 9

class Solution {

  public static void main(String[] args) {
//    String input = "518123";
    String input = "1118192929";
    System.out.println("Input: "+ input);
    System.out.println("Output: "+solution(input));
  }
  public static String solution(String s) {
    // Implement your solution here
    //System.out.println("Init String: " + s);
    int maxSum = 9;
    if(s.length() == 1) return s;
    int l=0,r=1;

    while(l < s.length()-1 && r < s.length()) {
      int ld = (int)s.charAt(l) - 48;
      int rd = (int)s.charAt(r) - 48;
      //System.out.println("ld:"+ ld+", rd:"+ rd);
      int sum = ld+rd;
      if(sum <= 9) {
        //'11 19812' -> '2 19812'
        //'111' -> '2 1' -> '21' -> '3'
        s = s.substring(0,l)+ sum + s.substring(l+2);
        //System.out.println("Shrink: "+ s);

      } else {
        l++;
        r++;

        //System.out.println("No Shrink: "+ s);
      }
    }
    //System.out.println("Final String: " +s);
    return s;
  }
}

