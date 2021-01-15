class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottenOranges = new LinkedList<>();
        int freshOranges = 0;
        int m=grid.length;
        int n= grid[0].length;
        for(int i=0 ; i<m; i++){
            for(int j=0; j<n;j++){
                if (grid[i][j] == 2)
                    rottenOranges.add(new int[]{i,j});
                if (grid[i][j] == 1)
                    freshOranges++;
            }
        }
        
        if (freshOranges == 0)
            return 0;
        int directions[][] = {{-1,0},{0,-1},{1,0},{0,1}};
        int min=-1;
        while(!rottenOranges.isEmpty()){
            int size= rottenOranges.size();
            for(int i=1; i<=size; i++){
                int [] rottenOrange = rottenOranges.poll();
                int currentRow = rottenOrange[0];
                int currentColumn = rottenOrange[1];
                for(int[] direction : directions){
                    int navigatedRow = currentRow+direction[0];
                    int navigatedColumn = currentColumn+direction[1];
                    if (navigatedRow < 0 || navigatedRow >=m
                       || navigatedColumn < 0 || navigatedColumn >=n)
                        continue;
                    
                    if (grid[navigatedRow][navigatedColumn] == 1){
                        freshOranges--;
                        rottenOranges.add(new int[]{navigatedRow, navigatedColumn});
                        grid[navigatedRow][navigatedColumn] = 2;
                    }
                }
            }
            
            min++;
        }
        
        return freshOranges == 0 ? min : -1;
    }
}
