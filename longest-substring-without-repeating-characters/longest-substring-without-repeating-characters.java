class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map  = new HashMap();
        for(int j = 0, i= 0; j < n; j++){
           if(map.containsKey(s.charAt(j))){
               i = Math.max(map.get(s.charAt(j)), i);
           }
            System.out.println("i " + i);
            System.out.println("j " + j);
            ans = Math.max(ans, j-i + 1);
            System.out.println("ans" + ans);

            map.put(s.charAt(j), j+1);
              }
              return ans;
               
}
              }