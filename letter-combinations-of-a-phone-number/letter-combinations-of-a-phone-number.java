class Solution {
    List<String> result= new ArrayList<>();
    Map<Integer, String> mappings = new HashMap<>(){
            {
                put(0, "");
                put(1, "");
                put(2, "abc");
                put(3, "def");
                put(4, "ghi");
                put(5, "jkl");
                put(6, "mno");
                put(7, "pqrs");
                put(8, "tuv");
                put(9, "wxyz");
            }};
    
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() ==0) {
            return new ArrayList<>();
        }
        
        String current = "";
        letterCombinationRegression(digits, 0, current);
        return result;
    }
        
    public void letterCombinationRegression(String digits, int index, String current){
        if(index == digits.length()){
            result.add(current);
            return;
        }
        
        String letters = mappings.get(digits.charAt(index) - '0');
        for(int i=0 ; i<letters.length(); i++){
            letterCombinationRegression(digits, index+1, current + letters.charAt(i));
        }
    }
}