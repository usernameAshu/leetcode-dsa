package leetcodes.two_pointers;

public class _17_Valid_Pallindrome {

  public static void main(String[] args) {

  }

  public boolean isPalindrome(String s) {
    s = s.toLowerCase();
    int i = 0, j = s.length() - 1;

    while (i < j) {
      char left = s.charAt(i);
      char right = s.charAt(j);
      if (!isAlphaNumeric(left)) {
        i++;
      } else if (!isAlphaNumeric(right)) {
        j--;
      } else if (left == right) {
        i++;
        j--;
      } else {
        return false;
      }

    }
    return true;
  }

  private boolean isAlphaNumeric(Character c) {
    if ((c >= 97 && c <= 122) || (c >= 48 && c <= 57)) {
      return true;
    }
    return false;
  }

}
