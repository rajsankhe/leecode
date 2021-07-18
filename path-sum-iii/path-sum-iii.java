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
    
    int count = 0; 
    public int pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return count;
    }
    
    public void dfs(TreeNode node, int targetSum){
        if(node == null){
            return;
        }    
        hasPathSum(node, 0, targetSum);
        
        dfs(node.left, targetSum);
        dfs(node.right, targetSum);
    }
    
    public void hasPathSum(TreeNode node, int sum, int targetSum){
        if(node == null){
            return;
        }
        
        sum = sum + node.val;
        
        if(sum == targetSum) {
            count = count + 1;
        }
        
        hasPathSum(node.left, sum, targetSum);
        hasPathSum(node.right, sum, targetSum);
    }
}