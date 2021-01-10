class Solution {
    public int findCircleNum(int[][] isConnected) {
        int numberOfProvinces = 0;
        boolean visited[] = new boolean[isConnected.length];
        for(int i=0; i<isConnected.length; i++){
            if (!visited[i]){
                dfs(i, visited, isConnected);
                numberOfProvinces++;
            }
        }
        return numberOfProvinces;
    }
    
    public void dfs(int i, boolean visited[],int[][] isConnected){
        visited[i] = true;
        for(int j=0; j<isConnected.length; j++){
            if(!visited[j] && isConnected[i][j] == 1)
                dfs(j, visited, isConnected);
        }
    }
}
