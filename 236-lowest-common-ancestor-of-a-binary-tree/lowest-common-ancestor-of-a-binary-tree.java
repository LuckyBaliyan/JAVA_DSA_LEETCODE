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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return solve(root,p,q);
    }

    public static TreeNode solve(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)return null;
        if(root == p || root == q)return root;

        TreeNode left_val = solve(root.left,p,q);
        TreeNode right_val = solve(root.right,p,q);

        if((left_val != null) && (right_val != null))
        return root;
        else if ((left_val != null) && (right_val == null))
        return left_val;
        else return right_val;
    }
}