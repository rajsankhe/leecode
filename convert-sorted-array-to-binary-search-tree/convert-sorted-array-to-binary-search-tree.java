/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0 , nums.length - 1);
    }
    
    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right)
            return null;
        
        int middle = left + (right - left)/2;
        TreeNode newNode = new TreeNode(nums[middle]);
        newNode.left =  sortedArrayToBST(nums, left, middle - 1);
        newNode.right = sortedArrayToBST(nums, middle + 1 , right);
        return newNode;
    }
}
