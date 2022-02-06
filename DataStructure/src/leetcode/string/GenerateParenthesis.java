class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> results = new ArrayList<>();
        dfs(results, "", n, n);
        return results;
    }
    public void dfs(List<String> result, String s, int left, int right){
        if(left > right){
            return;
        }
 
        if(left == 0&& right == 0){
            result.add(s);
            return;
        }
 
        if(left > 0){
            dfs(result, s+"(", left - 1, right);
        }
 
        if(right > 0){
            dfs(result, s+")", left, right - 1);
        }
    }
}
