package geektime.algo.leecode.top100Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-04-11 16:32
 * @description:  46. 全排列
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 */
public class Permute {

    // 回溯法
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }

    // 回溯法
    List<List<Integer>> list;
    public List<List<Integer>> permuteUnique(int[] nums) {
        list=new ArrayList<List<Integer>>();//最终的结果
        List<Integer> team=new ArrayList<Integer>();//回溯过程收集元素
        boolean jud[]=new boolean[nums.length];//用来标记
        dfs(jud, nums, team, 0);
        return list;
    }
    private  void dfs(boolean[] jud, int[] nums, List<Integer> team, int index) {
        int len = nums.length;
        if (index == len)// 停止
        {
            list.add(new ArrayList<Integer>(team));
        } else {
            for (int i = 0; i < len; i++) {
                if (jud[i]) //当前数字被用过 当前即不可用
                    continue;
                team.add(nums[i]);
                jud[i]=true;//标记该元素被使用
                dfs(jud, nums, team, index + 1);
                jud[i] = false;// 还原
                team.remove(index);//将结果移除临时集合
            }
        }

    }
}
