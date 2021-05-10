class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length ==0) {
            return new int[][]{};
        }
        List <int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[0] - b[0]));
        result.add(intervals[0]);
        
        for(int[] interval : intervals){
           int[] peek = result.get(result.size() - 1);
           if (peek[1] >= interval[0]) {
               peek[1] = Math.max(peek[1], interval[1]);
           }
         else {
                result.add(interval);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}