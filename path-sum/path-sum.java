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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSum(root, 0, targetSum);
    }
    
    public boolean hasPathSum(TreeNode node, int sum, int targetSum){
        if(node == null){
            return false;
        }
        
        sum = sum + node.val;
        
        if(sum == targetSum && node.left == null && node.right == null){
            return true;
        }
        
        return hasPathSum(node.left, sum, targetSum) || hasPathSum(node.right, sum, targetSum);
    }
}