package map;

import java.util.*;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public static void main(String[] args) {
        new LongestSubstringWithAtLeastKRepeatingCharacters()
                .longestSubstring("bbaaacbd", 3);
    }

    public int longestSubstring(String s, int k) {
        dfs(s, k);
        return max;
    }

    int max = 0;

    private void dfs(String s, int k) {
        if (s.length() == 0) {
            return;
        }
        Set<Character> less = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            int freq = map.computeIfAbsent(c, key -> 0);
            map.put(c, freq+1);
            if (freq+1 < k) {
                less.add(c);
            } else {
                less.remove(c);
            }
        }
        if (less.isEmpty()) {
            this.max = Math.max(this.max, s.length());
            return;
        }
        List<String> segments = new ArrayList<>();
        StringBuilder currentSegment = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (less.contains(c)) {
                if (currentSegment.length() != 0) {
                    segments.add(currentSegment.toString());
                }
                dfs(currentSegment.toString(), k);
                currentSegment = new StringBuilder();
            } else {
                currentSegment.append(c);
            }
        }
        dfs(currentSegment.toString(), k);
    }


}
