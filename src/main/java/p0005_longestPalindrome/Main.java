package p0005_longestPalindrome;
/*
https://leetcode.com/problems/longest-palindromic-substring/description/
 */

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        String s = "babad";
//        String s = "cbbd";
//        String s = "a";
//        String s = "ac";
//        String s = "racecar";
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";

        System.out.println(solution.longestPalindrome(s));
        System.out.println("Expand center iterations: " + Counter.get());

        Counter.reset();
        System.out.println(solution.longestPalindrome_bruteforce(s));
        System.out.println("Brute force iterations: " + Counter.get());


    }
}

class Counter {
    private static int cnt = 0;

    public static void inc() {
        cnt++;
    }

    public static int get() {
        return cnt;
    }

    public static void reset() {
        cnt = 0;
    }
}

class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            Counter.inc();
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);

            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    public int expandAroundCenter(String s, int left, int right) {
        if (left < 0 || right >= s.length()) {
            return 0;
        }

        // Если парный центр и символы не равны — сразу выходим
        if (left != right && s.charAt(left) != s.charAt(right)) {
            return 0;
        }

        //тернарник если центр один символ, либо два символа и они равны
        int len = (left == right) ? 1 : 2;

        left--;
        right++;

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            Counter.inc();
            len += 2;
            left--;
            right++;
        }

        return len;
    }


    public String longestPalindrome_bruteforce(String s) {
        int pLeft = 0;
        int pRight = 0;
        int max = 0;
        for (int left = 0; left < s.length(); left++) {
            for (int right = left; right < s.length(); right++) {
                Counter.inc();
                if (isPalindrome(s, left, right)) {
                    if ((right - left + 1) > max) {
                        max = right - left + 1;
                        pLeft = left;
                        pRight = right;
                    }
                }
            }
        }
        return s.substring(pLeft, pRight + 1);
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            Counter.inc();
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }



}