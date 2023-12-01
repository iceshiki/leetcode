package subject;

import java.util.*;

public class Subject1839 {

    /**
     * 最长的完美的元音字符串
     * <p>
     * 包含仅有所有元音字母
     * <p>
     * 按照aeiou顺序，可以aaeeiioouu, 连续
     *
     * @param str
     */
    public String test(String str) {
        int maxLength = 0;
        int curLength = 0;
        int start = 0, end = 0;
        int resultS = 0, resultE = 0;
        char[] chars = str.toCharArray();
        char lastLetter = 'w';
        HashMap<Character, Set<Character>> letterMap = new HashMap<>();

        Set<Character> aSet = new HashSet<>();
        aSet.add('a');
        Set<Character> eSet = new HashSet<>();
        eSet.add('e');
        eSet.add('a');
        Set<Character> iSet = new HashSet<>();
        iSet.add('i');
        iSet.add('e');
        Set<Character> oSet = new HashSet<>();
        oSet.add('o');
        oSet.add('i');
        Set<Character> uSet = new HashSet<>();
        uSet.add('u');
        uSet.add('o');
        letterMap.put('a', aSet);
        letterMap.put('e', eSet);
        letterMap.put('i', iSet);
        letterMap.put('o', oSet);
        letterMap.put('u', uSet);
        char curLetter;
        for (int i = 0; i < chars.length; i++) {
            curLetter = chars[i];
            if (lastLetter != 'a' && curLetter == 'a') {
                curLength = 1;
                start = i;
                end = i + 1;
            } else if (end > start) {
                if ('u' == curLetter && ((i + 1 >= chars.length) || chars[i + 1] != 'u')) {
                    // u 为最后一次字母|| u的下一个字母不是u
                    if (curLength >= maxLength) {
                        maxLength = curLength;
                        resultS = start;
                        resultE = i + 1;
                    }
                } else if (letterMap.containsKey(curLetter)) {
                    // 命中中间字母
                    if (letterMap.get(curLetter).contains(lastLetter)) {
                        curLength++;
                    } else {
                        start = i;
                        curLength = 0;
                    }
                } else {
                    // 序列不完整
                    start = i;
                    curLength = 0;
                }
            } else {
                start = i;
                curLength = 0;
            }
            lastLetter = chars[i];
        }

        return str.substring(resultS, resultE);

    }

    public static void main(String[] args) {
        Subject1839 subject1839 = new Subject1839();
        // aaeeiioouu
        System.out.println(subject1839.test("1aeiou4aaeeiioouu"));
        // aeiouu
        System.out.println(subject1839.test("aeiouuaeiou"));
        // ""
        System.out.println(subject1839.test(""));
        // ""
        System.out.println(subject1839.test("tgbf"));
        // ""
        System.out.println(subject1839.test("aei123ou"));
        // ""
        System.out.println(subject1839.test("aei"));
    }
}
