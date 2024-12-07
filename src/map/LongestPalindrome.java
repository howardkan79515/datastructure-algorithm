package map;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Integer count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count + 1);
        }
        int result = 0;
        boolean isOdd = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int c = entry.getValue();
            if (c % 2 == 0) {
                result += entry.getValue();
            } else {
                isOdd = true;
                result += entry.getValue()-1;
            }
        }
        if(isOdd) {
            result = result + 1;
        }
        return result;
    }
}
