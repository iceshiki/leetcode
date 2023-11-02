package subject;

public class Subject5 {
    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        boolean[][] flags = new boolean[length][length];

        for (int i = 0; i < flags.length; i++) {
            flags[i][i] = true;
        }
        char[] chars = s.toCharArray();
        int maxlength = 1;
        int begin = 0;
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                if (chars[i] == chars[j]) {
                    if (j - i < 3) {
                        flags[i][j] = true;
                    } else {
                        flags[i][j] = flags[i + 1][j - 1];
                    }

                    if (flags[i][j] && j - i + 1 > maxlength) {
                        begin = i;
                        maxlength = j - i + 1;
                    }
                }
            }
        }
        return s.substring(begin, begin + maxlength);
    }

    public static void main(String[] args) {
        Subject5 subject5 = new Subject5();
//        System.out.println(subject5.longestPalindrome("babad"));
//        System.out.println(subject5.longestPalindrome("cbbd"));
        System.out.println(subject5.longestPalindrome("ac"));
        System.out.println(subject5.longestPalindrome("bb"));
    }
}
