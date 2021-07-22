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
    int totalSum = 0; 
    public int sumNumbers(TreeNode root) { 
        hasPathSum(root, 0);
        return totalSum;
    }
    
     public void hasPathSum(TreeNode node, int sum){
        if(node == null){
            return;
        }
        
        sum = sum * 10 + node.val;
        
        if(node.left == null && node.right == null){
            totalSum = totalSum + sum;
        }
        
        hasPathSum(node.left, sum);
        hasPathSum(node.right, sum);
    }
}