package map;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            List<String> list = map.computeIfAbsent(sortedStr, key->new ArrayList<>());
            if (list.isEmpty()) {
                result.add(list);
            }
            list.add(s);
        }
        return result;
    }
}
