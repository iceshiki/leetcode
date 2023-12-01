package subject;

import java.util.*;

/**
 * 当一个字符串满足如下条件时，我们称它是 美丽的 ：
 * 所有 5 个英文元音字母（'a' ，'e' ，'i' ，'o' ，'u'）都必须 至少 出现一次。
 * 这些元音字母的顺序都必须按照 字典序 升序排布（也就是说所有的 'a' 都在 'e' 前面，所有的 'e' 都在 'i' 前面，以此类推）
 * 比方说，字符串 "aeiou" 和 "aaaaaaeiiiioou" 都是 美丽的 ，但是 "uaeio" ，"aeoiu" 和 "aaaeeeooo" 不是美丽的 。
 * 给你一个只包含英文元音字母的字符串 word ，请你返回 word 中 最长美丽子字符串的长度 。如果不存在这样的子字符串，请返回 0 。
 * 子字符串 是字符串中一个连续的字符序列。
 * <p>
 * 示例 1：
 * 输入：word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
 * 输出：13
 * 解释：最长子字符串是 "aaaaeiiiiouuu" ，长度为 13 。
 * <p>
 * 示例 2：
 * 输入：word = "aeeeiiiioooauuuaeiou"
 * 输出：5
 * 解释：最长子字符串是 "aeiou" ，长度为 5 。
 * <p>
 * 示例 3：
 * 输入：word = "a"
 * 输出：0
 * 解释：没有美丽子字符串，所以返回 0 。
 * <p>
 * 提示：
 * 1 <= word.length <= 5 * 105
 * word 只包含字符 'a'，'e'，'i'，'o' 和 'u' 。
 *
 * @level medium
 */
public class Subject1839 {

    /**
     * 最长的完美的元音字符串
     * <p>
     * 包含仅有所有元音字母
     * <p>
     * 按照aeiou顺序，可以aaeeiioouu, 连续
     * <p>
     * java 写状态机好难写
     *
     * @param word
     */

    public int longestBeautifulSubstring1(String word) {
        int ans = 0, type = 1, len = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) >= word.charAt(i - 1)) {
                len++;//更新当前字符串长度
            }
            if (word.charAt(i) > word.charAt(i - 1)) {
                type++; //更新当前字符种类
            }
            if (word.charAt(i) < word.charAt(i - 1)) {
                //当前字符串不美丽，从当前字符重新开始
                type = 1;
                len = 1;
            }
            if (type == 5) {
                //更新最大字符串
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Subject1839 subject1839 = new Subject1839();
        // 最长子字符串是 "aaaaeiiiiouuu" ，长度为 13
        System.out.println(subject1839.longestBeautifulSubstring1("aeiaaioaaaaeiiiiouuuooaauuaeiu"));
        // 最长子字符串是 "aeiou" ，长度为 5 。
        System.out.println(subject1839.longestBeautifulSubstring1("aeeeiiiioooauuuaeiou"));
        // 没有美丽子字符串，所以返回 0 。
        System.out.println(subject1839.longestBeautifulSubstring1("a"));
        // ""
        System.out.println(subject1839.longestBeautifulSubstring1(""));
    }
}
