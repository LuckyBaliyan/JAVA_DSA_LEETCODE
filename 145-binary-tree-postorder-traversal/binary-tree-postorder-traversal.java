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
    static List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        solvePost(root);
        return res;
    }

    public static void solvePost(TreeNode root){
        if(root == null)return;

        solvePost(root.left);
        solvePost(root.right);
        res.add(root.val);
    }
}