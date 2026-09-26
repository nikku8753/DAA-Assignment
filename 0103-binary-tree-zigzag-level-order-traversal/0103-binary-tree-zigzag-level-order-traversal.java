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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        zigzag(root,ans,0);
        return ans;
    }
    private void zigzag(TreeNode root,List<List<Integer>> ans,int level){
        if(root==null)return;
        if(ans.size()==level){
          //  List<Integer> ls=new ArrayList();
        ans.add(new LinkedList<>());
        }
        if(level%2==0){
            ans.get(level).add(root.val);
        }
        else{
            ans.get(level).add(0,root.val);
        }
        
        zigzag(root.left,ans,level+1);
        zigzag(root.right,ans,level+1);

    }
}