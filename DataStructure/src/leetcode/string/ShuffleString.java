class ShuffleString {
    public String restoreString(String s, int[] indices) {
        if (s == null || s.length() == 0){
            return "";
        }
        
        if (s.length() != indices.length){
            return null;
        }
        
        char tempCharArray[] = new char[indices.length];
        char sArray[] = s.toCharArray();
        for (int i = 0; i < indices.length; i++){
            int index = indices[i];
            tempCharArray[index] = sArray[i];
        }
        return new String().valueOf(tempCharArray);
    }
}
