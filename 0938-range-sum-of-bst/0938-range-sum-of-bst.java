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
    int s=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return -1;
        sum(root,low,high);
        return s;
    }
    private void sum(TreeNode root,int low, int high){
        if(root==null)return;
        if(root.val>=low && root.val<=high) {
            s+=root.val;
        }
        sum(root.left,low,high);
        sum(root.right,low,high);
        return;    }
}