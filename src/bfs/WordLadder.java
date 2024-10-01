package bfs;

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> cache = new HashSet<>();
        cache.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> table = new HashSet<>();
        for (String w : wordList) {
            table.add(w);
        }
        Set<String> visited = new HashSet<>();
        int res = 1;
        while (!q.isEmpty()) {
            int length = q.size();
            for (int j = 0; j < length; j++) {
                String s = q.poll();
                if (endWord.equals(s)) {
                    return res;
                }
                for (int i = 0; i < s.length(); i++) {
                    for(char k = 'a'; k <= 'z'; k++) {
                        StringBuilder sb = new StringBuilder(s);
                        sb.setCharAt(i, k);
                        String replace = sb.toString();
                        if (table.contains(replace) && !visited.contains(replace)) {
                            q.add(replace);
                            visited.add(replace);
                        }
                    }
                }
            }
            res++;
        }

        return 0;
    }
}
