package subject;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 示例 1：
 * 输入：s = "()"
 * 输出：true
 * <p>
 * 示例 2：
 * 输入：s = "()[]{}"
 * 输出：true
 * <p>
 * 示例 3：
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * 提示：
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 *
 * @level easy
 */
public class Subject20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            switch (aChar) {
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        stack.push(aChar);
                    }
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        stack.push(aChar);
                    }
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        stack.push(aChar);
                    }
                    break;
                default:
                    stack.push(aChar);
            }

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Subject20 subject20 = new Subject20();
        System.out.println(subject20.isValid("()"));
        System.out.println(subject20.isValid("()[]{}"));
        System.out.println(subject20.isValid("(]"));
        System.out.println(subject20.isValid("(){}}{"));
    }
}
