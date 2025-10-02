package recursion.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Ripan Baidya
 * @date 26/09/25
 *
 * Given an array nums of distinct integers, return all the possible permutations. You
 * can return the answer in any order.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) {
            return List.of(new ArrayList<>());
        }

        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList<>();

        for (List<Integer> p : perms) {
            for (int i = 0; i <= p.size(); i ++) {
                List<Integer> pCopy = new ArrayList<>(p);
                pCopy.add(i, nums[0]);
                res.add(pCopy);
            }
        }
        return res;
    }

    static void main() {
        var obj = new Permutations();
        int[] nums = {1, 2, 3};

        List<List<Integer>> permutation = obj.permute(nums);
        System.out.println(permutation);
    }
}
