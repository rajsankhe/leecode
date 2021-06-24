class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null){
            return -1;
        }
        
        if (needle.isEmpty())
            return 0;
        
        for(int i =0; i< haystack.length(); i++){
            int j = 0;
            if (haystack.charAt(i) == needle.charAt(j)){
                while( i+j < haystack.length() &&
                     j < needle.length()&&
                     haystack.charAt(i+j) == needle.charAt(j)){
                    j++;
                }
                
                if(j == needle.length())
                    return i;
            }
            
        }
        
        return -1;
    }
}