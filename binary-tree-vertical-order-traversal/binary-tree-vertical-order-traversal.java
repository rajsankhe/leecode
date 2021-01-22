 */
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if( root == null)
            return result;
        Map<Integer, List<Integer>> columnTable = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
​
        int column = 0;
        queue.add(new Pair(root,column));
        int minColumn=0; int maxColumn=0;
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode current = p.getKey();
            column = p.getValue();
            
            if(current != null){
                if(!columnTable.containsKey(column))
                    columnTable.put(column, new ArrayList());
                columnTable.get(column).add(current.val);
                
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);
        
                queue.add(new Pair(current.left,column-1));
                
                
            
                queue.add(new Pair(current.right,column+1));
                
                
            }
        }
        for(int i= minColumn; i <=maxColumn; i++) {
            result.add(columnTable.get(i));
        }
        
        return result;
    }
}
