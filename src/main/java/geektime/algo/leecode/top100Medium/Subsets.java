package geektime.algo.leecode.top100Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-11 15:32
 * @description:
 */
public class Subsets {

    //回溯方法: 78: 子集: 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
    List<Integer> t = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    public List<List<Integer>> subsets(int[] nums) {

        dfs(0, nums);
        return ans;
    }

    private void dfs(int curr, int[] nums) {
        if (curr == nums.length) {
            ans.add(new ArrayList<Integer>(t));
            return;
        }

        t.add(nums[curr]);
        dfs(curr + 1, nums);
        t.remove(t.size() - 1);
        dfs(curr + 1, nums);
    }


    // 子集 2: 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

    List<Integer> tt = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, 0, nums);
        return res;
    }

    public void dfs(boolean choosePre, int cur, int[] nums) {
        if (cur == nums.length) {
            res.add(new ArrayList<Integer>(tt));
            return;
        }
        dfs(false, cur + 1, nums);
        if (!choosePre && cur > 0 && nums[cur - 1] == nums[cur]) {
            return;
        }
        tt.add(nums[cur]);
        dfs(true, cur + 1, nums);
        tt.remove(tt.size() - 1);
    }
}
