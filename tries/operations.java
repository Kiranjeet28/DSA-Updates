import java.util.*;

class Trie {

    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        TrieNode() {
            children = new HashMap<>();
            isEnd = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }

        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }

        return curr.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }

        return true;
    }
}
