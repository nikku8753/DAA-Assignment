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
 
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null) return ans;
        Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map=new TreeMap<>();
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(root,0));
        int level=0;
        while(!q.isEmpty())
        //Map<Integer,ArrayList> map=new TreeNode<>();
    }
}
*/
class Solution {

    //Queue k liye we need ek horizantal distance , node 
    class Pair {
        TreeNode node;
        int hd;
        int level;

        Pair(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>(); //ans k liye 

        if (root == null) return ans;     //no nodes in the tree 

        // HD -> Level -> Nodes
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
            = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(root, 0));

        int level = 0;

        while (!q.isEmpty()) {

            // Current level ke andar kitne nodes hain
            int size = q.size();

            for (int i = 0; i < size; i++) {

                Pair current = q.poll();

                TreeNode node = current.node;
                int hd = current.hd;

                // HD create karo 
                map.putIfAbsent(hd, new TreeMap<>());

                // Level create karo
                map.get(hd).putIfAbsent(
                    level,
                    new PriorityQueue<>()
                );

                // Same HD + same Level
                // smaller value pehle
                map.get(hd)
                   .get(level)
                   .offer(node.val);

                // Left child
                if (node.left != null) {
                    q.offer(new Pair(
                        node.left,
                        hd - 1
                    ));
                }

                // Right child
                if (node.right != null) {
                    q.offer(new Pair(
                        node.right,
                        hd + 1
                    ));
                }
            }

            // Current level complete
            level++;
        }

        // HD sorted because outer TreeMap
                     //level ,  ///pore nodes
        for (TreeMap<Integer, PriorityQueue<Integer>> levels : map.values()) {

            List<Integer> vertical = new ArrayList<>();

            // Level sorted because inner TreeMap
            for (PriorityQueue<Integer> pq : levels.values()) {

                // Same HD + same level
                // values sorted
                while (!pq.isEmpty()) {
                    vertical.add(pq.poll());
                }
            }

            ans.add(vertical);
        }

        return ans;
    }
}