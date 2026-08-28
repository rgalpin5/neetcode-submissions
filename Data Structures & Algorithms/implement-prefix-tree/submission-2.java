public class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            cur.children.computeIfAbsent(c, k -> new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            if(cur.children.containsKey(c)){
                cur = cur.children.get(c);
            }
            else{
                return false;
            }
        }
        return cur.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(char c : prefix.toCharArray()) {
            if(cur.children.containsKey(c)){
                cur = cur.children.get(c);
            }
            else{
                return false;
            }
        }
        return true;
    }
}
