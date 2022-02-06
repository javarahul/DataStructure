class FirstUniqCharacter2 {
    private static int CHAR = 26;
    public int firstUniqChar(String s) {
        int [] count = new int[CHAR];
        Arrays.fill(count, -1);
        
        for (int i = 0; i < s.length(); i++){
            if (count[s.charAt(i) - 'a'] == -1){
                count[s.charAt(i) - 'a'] = i;
            }else{
                count[s.charAt(i) - 'a'] = -2;
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++){
            if(count[s.charAt(i) - 'a'] >= 0)
            result = Math.min(result, count[s.charAt(i) - 'a']);
        }
        
        result = (result == Integer.MAX_VALUE) ? -1 : result;
        return result;
    }
}
