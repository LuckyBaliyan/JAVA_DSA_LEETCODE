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
    static int diameter;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null && root.right == null)return 0;

        //reset the global variable for nextTest Cases 
        diameter = 0;

        solve(root);
        return diameter;
    }

    public static int solve(TreeNode root){
        if(root == null)return 0;

        //make dfs to depth on each sides
        int left = solve(root.left);
        int right = solve(root.right);

        diameter = Math.max(diameter,left + right);

        //return the maxDepth results for both side call's
        return 1 + Math.max(left,right);
    }
}