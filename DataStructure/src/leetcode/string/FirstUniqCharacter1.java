class FirstUniqCharacter1 {
    private static int CHAR = 26;
    public int firstUniqChar(String s) {
        int [] count = new int[CHAR];
        for (int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        
        for (int i = 0; i < s.length(); i++){
            if (count[s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
