package other;

/**
 * @author athakor
 */
public class BinarySearch {

    public static void main(String[] args) {
        var array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        var target = 4;
        System.out.println(test(array, target));
    }

    public static int test(int[] array, int target) {

        if (array == null || array.length == 0)
            return -1;

        var left = 0;
        var right = array.length - 1;
        while (left <= right) {
            var mid = (left + right) / 2;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
