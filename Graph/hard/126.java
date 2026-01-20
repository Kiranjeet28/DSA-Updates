import java.util.*;

class Solution {

    Map<String, List<String>> parentMap = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    String beginWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        this.beginWord = beginWord;
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return result;

        bfs(beginWord, endWord, dict);
        dfs(endWord, new ArrayList<>());

        return result;
    }

    // BFS builds parent relationships
    private void bfs(String beginWord, String endWord, Set<String> dict) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                char[] arr = word.toCharArray();

                for (int p = 0; p < arr.length; p++) {
                    char old = arr[p];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old)
                            continue;
                        arr[p] = c;
                        String next = new String(arr);

                        if (!dict.contains(next))
                            continue;

                        if (!visited.contains(next)) {
                            if (!levelVisited.contains(next)) {
                                queue.offer(next);
                                levelVisited.add(next);
                            }
                            parentMap
                                    .computeIfAbsent(next, k -> new ArrayList<>())
                                    .add(word);

                            if (next.equals(endWord))
                                found = true;
                        }
                    }
                    arr[p] = old;
                }
            }
            visited.addAll(levelVisited);
        }
    }

    // DFS rebuilds all shortest paths
    private void dfs(String word, List<String> path) {
        path.add(word);

        if (word.equals(beginWord)) {
            List<String> valid = new ArrayList<>(path);
            Collections.reverse(valid);
            result.add(valid);
        } else {
            if (parentMap.containsKey(word)) {
                for (String parent : parentMap.get(word)) {
                    dfs(parent, path);
                }
            }
        }

        path.remove(path.size() - 1);
    }
}
