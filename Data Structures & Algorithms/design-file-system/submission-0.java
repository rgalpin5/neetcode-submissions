class FileSystem {
    HashMap<String, Integer> map;
    public FileSystem() {
        this.map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if(map.containsKey(path)) return false;
        if(path.lastIndexOf('/') == 0 || map.containsKey(path.substring(0, path.lastIndexOf('/')))) {
            map.put(path, value);
            return true;
        }
        return false;
    }
    
    public int get(String path) {
        if(map.containsKey(path)) return map.get(path);
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
