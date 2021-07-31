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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathSumHelper(root);
        
        return max;
    }
    
    public int maxPathSumHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftMax = Math.max(maxPathSumHelper(root.left),0);
        int rightMax = Math.max(maxPathSumHelper(root.right),0);
        System.out.println("leftMax" + leftMax + "rightMax" + rightMax + "max" + max);
        max = Math.max(max, leftMax + rightMax + root.val);
        
        return Math.max(leftMax, rightMax) + root.val;
    }
}