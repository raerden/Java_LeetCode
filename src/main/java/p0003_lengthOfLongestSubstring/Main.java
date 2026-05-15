package p0003_lengthOfLongestSubstring;
/*
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 */
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

//        String s = "abcabcbb"; // 3
//        String s = "bbbbb"; // 1
//        String s = "pwwkew"; // 3
//        String s = "aab"; // 2
        String s = "dvdf"; // 3
        System.out.println(solution.lengthOfLongestSubstring(s));
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (map.containsKey(ch) && map.get(ch) >= left) {
                left = map.get(ch) + 1;
            }

            map.put(ch, right);

            int cur = right - left + 1;
            max = Math.max(max, cur);
        }

        return max;
    }
}