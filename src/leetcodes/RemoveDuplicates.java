package leetcodes;

import java.util.Arrays;

public class RemoveDuplicates {
  public static int[] removeDuplicatesWithSorting(int[] array) {
    // Sort the array
    Arrays.sort(array);

    // Use two pointers to remove duplicates
    int n = array.length;
    int index = 0; // Points to the position of the unique elements

    for (int i = 1; i < n; i++) {
      if (array[i] != array[index]) {
        index++;
        array[index] = array[i];
      }
    }

    System.out.println("After rearrranging the uniques to the front:\n");
    System.out.println(Arrays.toString(array));
    System.out.println();

    // Create a new array with unique elements
    int[] result = Arrays.copyOf(array, index + 1);
    return result;
  }

  public static void main(String[] args) {
    int[] array = {1, 2, 3, 1, 2, 4, 5, 6};
    int[] result = removeDuplicatesWithSorting(array);

    System.out.println("Array after removing duplicates:");
    System.out.println(Arrays.toString(result));
  }

}
