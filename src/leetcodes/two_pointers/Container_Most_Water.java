package leetcodes.two_pointers;

/**
 * LC 11. Container With Most Water
 *
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 *
 * Notice that you may not slant the container.
 */
public class Container_Most_Water {

  /**
   * start with left pointer at the beginning of the array and
   * the right pointer at the end of the array.
   * Then move the left point, one place if the height at the left is less than the height of the right
   * and same applies to the right point as well at every position.
   * Calculate the height by calling the calculate volume method and use the Math.max operator
   * in order to find the maximum height.
   * @param height
   * @return
   */
  public int maxArea(int[] height) {
    if(height.length == 1) return height[0];
    int max = 0;
    int l = 0;
    int r = height.length - 1;
    int h1, h2;
    while(l < r) {
      h1 = height[l];
      h2 = height[r];
      int area = calcVolume(h1,l,h2,r);
      max = Math.max(area,max);
      if(h1 < h2) {
        l++;
      } else if(h1 > h2) {
        r--;
      } else {
        l++;
      }
    }
    return max;
  }

  int calcVolume(int h1, int idx1, int h2, int idx2) {
    int breadth = Math.abs(idx2 - idx1);
    int height = Math.min(h1,h2);
    return breadth * height;
  }
}
