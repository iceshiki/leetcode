package subject;

import java.awt.*;
import java.util.HashSet;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * 示例1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author chenjianchao
 * @description TODO
 * @createDate 2022/11/17 14:03
 */
public class Subject3 {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        char[] chars = s.toCharArray();
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charSet.contains(chars[i])) {
                left = Math.max(left, i+1);
            }
            charSet.add(chars[i]);

            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("dvdf"));
    }
}
