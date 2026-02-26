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
    public int maxDepth(TreeNode root) {
        return solveDfs(root);
    }

    public static int solveDfs(TreeNode root){
        if(root == null)return 0;

        int left = 0;
        int right = 0;

        if(root.left != null)
        left = solveDfs(root.left);

        if(root.right != null)
        right = solveDfs(root.right);

        return 1 + Math.max(left,right);
    }
}