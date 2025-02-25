package leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 * <p>
 * Notice that the solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 * <p>
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * <p>
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */
public class TripletsSum {

    public static void main(String[] args) {
        TripletsSum.threeSum3(new int[]{-1, 0, 1, 2, -1, -4});
//        TripletsSum.threeSum3(new int[]{0, 0, 0});
    }

    static class TripletKey {

        int i, j, k;

        @Override
        public boolean equals(Object tripletKey) {
            var obj = (TripletKey) tripletKey;
            if ((i == obj.i || i == obj.j || i == obj.k)
                && (j == obj.i || j == obj.j || j == obj.k)
                    && (k == obj.i || k == obj.j || k == obj.k)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            var hc = 31 + (i + j + k);
            return hc;
        }
    }

    public static List<List<Integer>> threeSum3(int[] nums) {

        var parentList = new ArrayList<List<Integer>>();
        var tripletKeyHashSet = new HashSet<TripletKey>();

//        int[] elements = Arrays.stream(nums).distinct().toArray();
        int[] elements = nums;

        for (int i = 0; i < elements.length; i++) {

            var iVal = elements[i];

            for (int j = i + 1; j < elements.length; j++) {

                var jVal = elements[j];

                for (int k = j + 1; k < elements.length; k++) {

                    var kVal = elements[k];
                    var sum = iVal + jVal + kVal;
                    if (iVal != jVal && iVal != kVal && jVal != kVal && sum == 0) {
                        var tk = new TripletKey();
                        tk.i = iVal;
                        tk.j = jVal;
                        tk.k = kVal;
                        tripletKeyHashSet.add(tk);
                    }
                }
            }
        }

        System.out.println(tripletKeyHashSet);
        return parentList;
    }

    public static List<List<Integer>> threeSum2(int[] nums) {

        var parentList = new ArrayList<List<Integer>>();

        for (int i = 0; i < nums.length; i++) {

            var iVal = nums[i];

            for (int j = i + 1; j < nums.length; j++) {

                var jVal = nums[j];
                if (iVal == jVal)
                    continue;

                for (int k = j + 1; k < nums.length; k++) {

                    var kVal = nums[k];
                    if (iVal == kVal || jVal == kVal)
                        continue;

                    var sum = iVal + jVal + kVal;
                    if (sum == 0) {
                        parentList.add(List.of(iVal, jVal, kVal));
                    }
                }
            }
        }

        System.out.println(parentList);
        return parentList;
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Set<Integer> uniqueElement = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        var parentList = new ArrayList<List<Integer>>();
        for (int i = 0; i < uniqueElement.size(); i++) {

            var iVal = nums[i];

            for (int j = i + 1; j < uniqueElement.size(); j++) {

                var jVal = nums[j];
                if (iVal == jVal)
                    continue;

                for (int k = j + 1; k < uniqueElement.size(); k++) {

                    var kVal = nums[k];
                    if (iVal == kVal || jVal == kVal)
                        continue;

                    var sum = iVal + jVal + kVal;
                    if (sum == 0) {
                        parentList.add(List.of(iVal, jVal, kVal));
                    }
                }
            }
        }
        System.out.println(parentList);
        return parentList;
    }
}
