class TrieNode {
    private HashMap<Character, TrieNode> children = new HashMap<>();
    private boolean isWord = false;
}

class Solution {
    boolean[][] visited;
    int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
    HashSet<String> ans;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode head = new TrieNode();
        TrieNode curr = head;
        ans = new HashSet<>();
        for(String word : words) {
            curr = head;
            for(char c : word.toCharArray()) {
                curr = curr.children.computeIfAbsent(c, k -> new TrieNode());
            }
            curr.isWord = true;
        }
        int rows = board.length;
        int cols = board[0].length;
        visited = new boolean[rows][cols];
        for(int r = 0; r < rows; r++) {
            for(int c = 0; c < cols; c++) {
                search(board, r, c, head, new StringBuilder());
            }
        }
        return new ArrayList<>(ans);
    }

    private void search(char[][] board, int r, int c, TrieNode node, StringBuilder currWord) {
        int ROWS = board.length, COLS = board[0].length;

        if(r < 0 || c < 0 || r >= ROWS || c >= COLS || visited[r][c] || !node.children.containsKey(board[r][c])) {
            return;
        }
         
        visited[r][c] = true;

        node = node.children.get(board[r][c]);
        currWord.append(board[r][c]);
        if(node.isWord) {
            ans.add(currWord.toString());
        }

        for(int[] dir : directions) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            search(board, newRow, newCol, node, currWord);
        }
        
        
        currWord.deleteCharAt(currWord.length() - 1);
        visited[r][c] = false;

    }
}
