class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int[][] result = new int[K][];
        Comparator<int[]> distanceComparator =  (int a[], int b[]) -> (getDistance(b) - getDistance(a));
        Queue<int[]> priorityQueue = new PriorityQueue<>(K, distanceComparator);
        for(int[] point : points){
            priorityQueue.offer(point);
            if (priorityQueue.size() > K){
                priorityQueue.poll();
            }
        }
        
        for(int i=0; i<K; i++) {
            result[i] = priorityQueue.poll();
        }
        
        return result;
    }
    
    public int getDistance(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}
