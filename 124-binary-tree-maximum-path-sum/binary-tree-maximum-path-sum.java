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
    static int maxPath;
    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        solve(root);
        return maxPath;
    }

    public static int solve(TreeNode node){
        if(node == null)return 0;

        int leftSum = Math.max(0,solve(node.left));
        int rightSum = Math.max(0,solve(node.right));

        maxPath = Math.max(maxPath, (leftSum + rightSum + node.val));
        return node.val + Math.max(leftSum,rightSum);
    }
}