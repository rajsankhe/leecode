class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0) {
            return true;
        }
        
        Map<Character, Character> closOpenParenthesesMap = new HashMap<>();
        
        closOpenParenthesesMap.put(')', '(');
        closOpenParenthesesMap.put('}', '{');
        closOpenParenthesesMap.put(']', '[');
        
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i< s.length(); i++){
            char current = s.charAt(i);
            
            if (closOpenParenthesesMap.containsKey(current)) {
                if (!stack.isEmpty() && stack.peek() == closOpenParenthesesMap.get(current)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(current);
            }
        }
        
        return stack.isEmpty();
    }
}