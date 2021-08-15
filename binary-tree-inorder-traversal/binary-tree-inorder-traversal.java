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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> op = new ArrayList<>();
        Stack<TreeNode> stack = new Stack();
        
        while(root != null || !stack.isEmpty()){
            
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            
            TreeNode node = stack.pop();
            op.add(node.val);
            root = node.right;
            
        }
        
        return op;
    }
}