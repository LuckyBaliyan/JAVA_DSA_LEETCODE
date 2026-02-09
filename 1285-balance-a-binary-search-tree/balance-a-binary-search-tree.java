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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> nodes =  new ArrayList<>();
        inOrder(root,nodes);
        return construct(nodes,0,nodes.size()-1);
    }

    public static void inOrder(TreeNode root,ArrayList<Integer> nodes){
        if(root == null)return;

        //Traverse left first 
        inOrder(root.left,nodes);
        //Add the Root The Node of the Current Subtree
        nodes.add(root.val);
        //Traverse The right SubTree
        inOrder(root.right,nodes);
    }

    public static TreeNode construct(ArrayList<Integer> nodes,int l,int r){
        if(l > r)return null;

        int mid = (l + r)/2;

        TreeNode root = new TreeNode(nodes.get(mid));
        root.left = construct(nodes,l,mid - 1);
        root.right = construct(nodes,mid+1,r);

        return root;
    }
}