/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Map<TreeNode, TreeNode> parentMap;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        parentMap = new HashMap<>();
        
        fillParent(root, null);
        
        Set<TreeNode> seenNodes = new HashSet<>();
        seenNodes.add(target);
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);
        
        int dist = 0;
        
        List<Integer> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();
            if (currentNode == null) {
                if (dist == K) {
                    for(TreeNode next : queue) {
                        result.add(next.val);
                    }
                    return result;
                }
                queue.add(null);
                dist++;
            } else {
                if(currentNode.left != null){
                    if(!seenNodes.contains(currentNode.left)){
                        queue.add(currentNode.left);
                        seenNodes.add(currentNode.left);
                    }
                }
                if(currentNode.right != null){
                    if(!seenNodes.contains(currentNode.right)){
                        queue.add(currentNode.right);
                        seenNodes.add(currentNode.right);
                    }
                }
                TreeNode parentNode = parentMap.get(currentNode);
                if(parentNode != null){
                    if(!seenNodes.contains(parentNode)){
                        queue.add(parentNode);
                        seenNodes.add(parentNode);
                    }
                }
            }
        }
        return new ArrayList<Integer>();
    }
    
    public void fillParent(TreeNode node, TreeNode parent) {
        if(node != null){
            parentMap.put(node, parent);
            fillParent(node.left, node);
            fillParent(node.right, node);   
        }
    }
}