class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

class WordDictionary {
    private TrieNode head;

    public WordDictionary() {
        head = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = head;

        for(char c : word.toCharArray()) {
            curr = curr.children.computeIfAbsent(c, k -> new TrieNode());
        }

        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = head;
        for(int i = 0; i < word.length(); i++) {
            char currChar = word.charAt(i);
            if(currChar == '.') {
                for(Character ch : curr.children.keySet()) {
                    if(searchFromDot(word.substring(i + 1), curr.children.get(ch))) {
                        return true;
                    }
                }
                return false;
            }
            else{
                if(curr.children.containsKey(currChar)) {
                    curr = curr.children.get(currChar);
                }
                else{
                    return false;
                }
            }
        }
        return curr.isWord;
    }
    
    private boolean searchFromDot(String word, TrieNode start) {
        if(word.length() == 0) return start.isWord;
        TrieNode curr = start;
        int i = 0;
        for(char currChar : word.toCharArray()) {
            if(currChar == '.') {
                for(Character ch : curr.children.keySet()) {
                    if(searchFromDot(word.substring(i + 1), curr.children.get(ch))) {
                        return true;
                    }
                }
                return false;
            }
            else{
                if(curr.children.containsKey(currChar)) {
                    curr = curr.children.get(currChar);
                }
                else{
                    return false;
                }
            }
            i++;
        }
        return curr.isWord;

    }
}
