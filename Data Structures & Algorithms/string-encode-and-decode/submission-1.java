class Solution {

    public String encode(List<String> strs) {
        String encoded = "";
        for(String str : strs){
            encoded += str.length() + "#" + str;
        }
        return encoded;
    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        for(int i = 0;i<str.length();i++){
            String stri = "";
            String temp = "";
            while(str.charAt(i) != '#'){
                temp += str.charAt(i);
                i++;
            }
            int letters = Integer.parseInt(temp);

            while(letters != 0 && i < str.length()){
                stri += str.charAt(i+1);
                i++;
                letters--;
            }
            decoded.add(stri);
        }
        return decoded;
    }
}
