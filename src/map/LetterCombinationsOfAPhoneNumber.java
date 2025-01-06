package map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {
    Map<Integer, List<String>> map = Map.of(
            2, List.of("a", "b", "c"),
            3, List.of("d", "e", "f"),
            4, List.of("g", "h", "i"),
            5, List.of("j", "k", "l"),
            6, List.of("m", "n", "o"),
            7, List.of("p", "q", "r", "s"),
            8, List.of("t", "u", "v"),
            9, List.of("w", "x", "y", "z"));
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            char c = digits.charAt(i);
            int key = c - '0';
            if (result.isEmpty()) {
                result.addAll(map.get(key));
            } else {
                List<String> list = new ArrayList<>();
                for (String s : result) {
                    for (String val : map.get(key)) {
                        list.add(s+val);
                    }
                }
                result = list;
            }
        }
        return result;
    }
}
