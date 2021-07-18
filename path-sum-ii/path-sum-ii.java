/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         
        hasPathSum(root, 0, targetSum, new ArrayList<>());
        return result;
    }
    
    public void hasPathSum(TreeNode node, int sum, int targetSum, List<Integer> list){
        if(node == null){
            return;
        }
        
        sum = sum + node.val;
        list.add(node.val);
        
        if(sum == targetSum && node.left == null && node.right == null){
            result.add(new ArrayList(list));
        }
        
        hasPathSum(node.left, sum, targetSum, list);
        hasPathSum(node.right, sum, targetSum, list);
        
        sum = sum - node.val;
        list.remove(list.size() - 1);
    }
}