package leatcode.string;

public class FirstUniqueCharacter {

	public static void main(String[] args) {
		String s = "leetcode";
		int index = firstUniqueChar(s);
		System.out.println("Index of first unique chararcter:-> " + index);
	}

	private static int firstUniqueChar(String s) {
		for (int i = 0; i < s.length(); i++){
            boolean flag = false;
            for (int j = 0; j < s.length(); j++){
                if (i != j && s.charAt(i) == s.charAt(j)){
                    flag = true;
                    break;
                }
            }
            if (!flag){
                return i;
            }
        }
        return -1;	
}
