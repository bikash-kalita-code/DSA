import java.util.*;

public class Solution {
    public boolean containsDuplicate(int[] nums) {

        if (nums == null || nums.length == 0)
            return false;

        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.add(i))
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean result = sol.containsDuplicate(new int[] { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 });
        System.out.println(result);

    }
}