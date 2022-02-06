class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null){
            return false;
        }        
        
        if (s.length() != t.length()){
            return false;
        }
        
        int CHAR = 26;
        
        int count[] = new int[CHAR];
        
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        
        for (int i = 0; i < CHAR; i++){
            if (count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
