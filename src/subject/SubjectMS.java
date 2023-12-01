package subject;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SubjectMS {

    public String test(String word) {
        int maxLength = 0;
        int curLength = 0;
        int start = 0, end = 0;
        int resultS = 0, resultE = 0;
        char[] chars = word.toCharArray();
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
                if ('u' == curLetter && letterMap.get(curLetter).contains(lastLetter) && ((i + 1 >= chars.length) || chars[i + 1] != 'u')) {
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

        return word.substring(resultS, resultE);

    }

    public static void main(String[] args) {

        SubjectMS subjectMS = new SubjectMS();
        // aaeeiioouu
        System.out.println(subjectMS.test("1aeiou4aaeeiioouu"));
        // aeiouu
        System.out.println(subjectMS.test("aeiouuaeiou"));
        // ""
        System.out.println(subjectMS.test(""));
        // ""
        System.out.println(subjectMS.test("tgbf"));
        // ""
        System.out.println(subjectMS.test("aei123ou"));
        // ""
        System.out.println(subjectMS.test("aei"));
        // ""
        System.out.println(subjectMS.test("eauoiouieaaoueiuaieoeauoiaueoiaeoiuieuaoiaeouiaueo"));
    }
}
