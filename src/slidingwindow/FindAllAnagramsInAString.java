package slidingwindow;

import java.util.*;

public class FindAllAnagramsInAString {

    public static void main(String[] args) {
        new FindAllAnagramsInAString().findAnagrams("abaacbabc", "abc");
        new FindAllAnagramsInAString().findAnagrams("cbaebabacd", "abc");
    }

    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        for (int j = 0; j < p.length(); j++) {
            char c = p.charAt(j);
            int count = pMap.getOrDefault(c, 0);
            pMap.put(c, count+1);
        }
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = map.getOrDefault(c, 0);
            map.put(c, count+1);
            int diff = i - left;
            if (diff == p.length()-1) {
                boolean equal = true;
                for (Map.Entry<Character, Integer> entry : pMap.entrySet()) {
                    Character pKey = entry.getKey();
                    Integer sCount = map.get(pKey);
                    if (sCount == null || !sCount.equals(entry.getValue())) {
                        equal = false;
                        break;
                    }
                }
                int index = i-(p.length()-1);
                if (equal) {
                    res.add(index);
                }
                char prevC = s.charAt(index);
                int prevCount = map.get(prevC);
                if (prevCount == 1) {
                    map.remove(prevC);
                } else {
                    map.put(prevC, prevCount-1);
                }
                left++;
            }
        }
        return res;
    }

}
