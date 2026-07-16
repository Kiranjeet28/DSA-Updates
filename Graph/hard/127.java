import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = wordList.size();
        System.out.println(wordList.get(length-1)+" " + endWord);
        if(!wordList.get(length-1).equals(endWord)){
            return 0;
        }
        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
      
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int steps = current.steps;
            if (word.equals(endWord)) {
                return steps;
            }
            for (int i = 0; i < word.length(); i++) {
                char[] wordChars = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    wordChars[i] = c;
                    String newWord = new String(wordChars);
                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        queue.offer(new Pair(newWord, steps + 1));
                    }
                }
            }
        }
       return 0 ;
    }

    class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}