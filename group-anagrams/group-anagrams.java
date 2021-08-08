class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        StringBuilder sb;
        int[] count = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            Arrays.fill(count, 0);
            
            for(char c : str.toCharArray()){
                count[c-'a']++;
            }
            
            sb = new StringBuilder();
            
            for(int i = 0; i< 26; i++){
                sb.append(count[i]);
                sb.append("#");
            }
            
            String key = sb.toString();
             
            if(!map.containsKey(key)){
                map.put(key, new ArrayList());
            }
            
            map.get(key).add(str);
        }
        
        result = map.values().stream().collect(Collectors.toList());
        
         return result;
    }
}