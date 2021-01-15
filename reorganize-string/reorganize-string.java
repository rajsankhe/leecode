class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : S.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c,0)+1);
        }
        
        PriorityQueue<Character> heap = new PriorityQueue<>((a,b) -> countMap.get(b)- countMap.get(a));
        
        heap.addAll(countMap.keySet());
        
        StringBuilder sb = new StringBuilder();
        while(heap.size() > 1){
            char current = heap.remove();
            char next = heap.remove();
            sb.append(current);
            sb.append(next);
            countMap.put(current, countMap.get(current)-1);
            countMap.put(next, countMap.get(next)-1);
            if (countMap.get(current) > 0)
                heap.add(current);
            if (countMap.get(next) > 0)
                heap.add(next);
        }
        
        if(!heap.isEmpty()) {
            char last = heap.remove();
            if(countMap.get(last) > 1)
            return "";
            else
                sb.append(last);
            
        } 
            return sb.toString();
        
        
    }
}
