class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++){
            String str = strs[i];
            char count[] = new char[26];
            for (int j = 0; j < str.length(); j++){
                count[str.charAt(j) - 'a']++;
            }
            String tempStr = new String(count);
            
            if (map.containsKey(tempStr)){
                map.get(tempStr).add(str);
            }else{
                ArrayList<String> al = new ArrayList<>();
                al.add(str);
                map.put(tempStr, al);
            }
        }
        
        result.addAll(map.values());
        
        return result;
    }
}
