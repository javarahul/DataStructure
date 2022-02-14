package geekforgeekpractice.recursion;

public class GenerateSubset{
    public static void main(String[] args){
        String str = "ABC";
        printSubset(str, "", 0);
    }
  
    private static void printSubset(String str, String curr, int index){
        if (index == str.length()){
            System.out.print(curr + " "); 
        }
      
        printSubset(str, curr, index + 1);
        printSubset(str, curr + str.charAt(index), index + 1);
    }
}
