class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }
        
        int[] globalMax = new int[2];
        
        for (int i =0; i<s.length(); i++) {
            int[] r1= expandAroundCenter(s, i, i);
            int[] r2= expandAroundCenter(s, i, i+1);
            
            int[] localMax= r1[1] -r1[0] > r2[1] - r2[0] ? r1 : r2;
            globalMax = localMax[1] - localMax[0]  > globalMax[1] - globalMax[0]? localMax : globalMax;
        }
        
        return s.substring(globalMax[0], globalMax[1] + 1);
    }
    
    private int[] expandAroundCenter(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        
        return new int[]{left + 1, right - 1};
    }
}