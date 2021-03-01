class Solution {
    public int numIslands(char[][] grid) {
        int directions[][] = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int noOfIsland = 0;
        int row = grid.length;
        int column = grid[0].length;
        for (int i= 0; i < row; i++) {
            for (int j=0; j < column; j++) {
                if (grid[i][j] == '1') {
                    noOfIsland++;
                    dfs(i,j, grid, directions);
                }
            }
        }
        
        return noOfIsland;
    }
    
    private void dfs(int i, int j, char[][] grid, int directions[][]) {
        grid[i][j] = '0';
        
        for (int [] dir : directions) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];
            if (nextI < 0 || 
                nextI >= grid.length ||
               nextJ < 0 ||
               nextJ >= grid[0].length || grid[nextI][nextJ] == '0')
                continue;
            dfs(nextI, nextJ, grid,directions);
        }
    }
}