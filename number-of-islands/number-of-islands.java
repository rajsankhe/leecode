class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int[][] directions = {{0,-1}, {0,1}, {1,0}, {-1,0}};
        int numOfIslands = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                    numOfIslands++;
                    dfs(grid, row, column, directions, i, j);
                }
            }
        }
        
        return numOfIslands;
    }
    
    public void dfs(char[][] grid, int row, int column, int[][] directions, int i, int j) {
        grid[i][j] = '0';
        for (int[] direction : directions){
            int nextRow = i + direction[0];
            int nextColumn = j + direction[1];
            
            if (nextRow < 0 || 
                nextRow >= row || 
                nextColumn < 0 || 
                nextColumn >= column || 
                grid[nextRow][nextColumn] == '0') 
            continue;
        
            dfs(grid, row, column, directions, nextRow, nextColumn);       
        } 
    }
}