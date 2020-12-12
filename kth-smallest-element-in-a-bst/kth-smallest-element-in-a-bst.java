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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        int kthsmallest = -1;
        TreeNode curr = root;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null){
                stack.add(curr);
                curr = curr.left;
            }
            
            curr= stack.pop();
            k--;
            if (k==0){
                 kthsmallest = curr.val;
            }
            curr = curr.right;
        }
        return kthsmallest;
    }
}
