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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderHashed = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inorderHashed.put(inorder[i], i);
        }
        
        return buildTreeHelper(0,0,preorder.length-1,preorder,inorderHashed);
    }
    
    private TreeNode buildTreeHelper(int index, int start, int end, int[] preorder, Map<Integer, Integer> inorderHashed){
        if(start>end)
            return null;
        TreeNode root = new TreeNode(preorder[index]);
        int rootIndex = inorderHashed.get(preorder[index]);
        root.left = buildTreeHelper(index+1,start,rootIndex-1,preorder, inorderHashed);
        root.right = buildTreeHelper(index+rootIndex-start+1, rootIndex+1, end, preorder, inorderHashed);
        return root;
        
    }
}