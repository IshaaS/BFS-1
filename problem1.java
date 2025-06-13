// BFS-1
// Problem 1
//Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)


// Time Complexity :O(n)
// Space Complexity :O(h)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
//using bfs: use queue and keep a track of size=> numbe rof nodes in each level and as we take out elements
//add their children

//using dfs: keep track of level pass a local level in the recursion and keep adding 
//values in the list of index equivalent to level.
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
//bfs
// class Solution {
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         List<List<Integer>> result= new ArrayList<>();
//         if(root==null) return result;
//         Queue<TreeNode> q = new LinkedList<>();
//         q.add(root);
//         while(!q.isEmpty()){
//             int size=q.size();
//             List<Integer> level = new ArrayList<>();
//             for(int i=0;i<size;i++){
//                 root = (q.poll());
//                 if(root.left!=null) q.add(root.left);
//                 if(root.right!=null) q.add(root.right);
//                 level.add(root.val);
//             }
//             result.add(level);
//         }
//         return result;
//     }
// }

//dfs
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        this.result= new ArrayList<>();
        if(root==null) return result;
        dfs(root,0);
        return result;
    }
    private void dfs(TreeNode root, int level){
        if(root==null) return;
        if(result.size()-1<level) result.add(new ArrayList<>());
        result.get(level).add(root.val);
        dfs(root.left, level+1);
        dfs(root.right, level+1);
    }
}