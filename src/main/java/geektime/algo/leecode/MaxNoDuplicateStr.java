package geektime.algo.leecode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: zhaixiaoshuang
 * @date: 2021-03-03 08:59
 * @description: 字符串的最大不重复子串
 * 思路
 * 标签：滑动窗口
 * 暴力解法时间复杂度较高，会达到 O(n^2)O(n
 * 2
 *  )，故而采取滑动窗口的方法降低时间复杂度
 * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
 * 我们定义不重复子串的开始位置为 start，结束位置为 end
 * 随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
 * 无论是否更新 start，都会更新其 map 数据结构和结果 ans。
 * 时间复杂度：O(n)O(n)
 *
 * 作者：guanpengchn
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/hua-jie-suan-fa-3-wu-zhong-fu-zi-fu-de-zui-chang-z/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxNoDuplicateStr {

        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            int ans = 0;
            Map<Character, Integer> temp = new HashMap();
            for(int start = 0, end = 0; end < len ; end++) {
                Character ch = s.charAt(end);
                if(temp.containsKey(ch)) {
                    // map的value直接存字符的下标更好理解，在map.get(c)的地方再进行+1操作。
                    start = Math.max(temp.get(ch) + 1, start);
                }
                ans = Math.max(ans, end - start + 1);
                temp.put(ch, end);
            }
            return ans;
        }
}