static class Singleton {
    private static Singleton s = new Singleton();
    private String value;

    private Singleton() {
        
    }

    public static Singleton getInstance() {
        return s;
    }

    public String getValue() {
        return s.value;
    }

    public void setValue(String value) {
        s.value = value;
    }
    
}
