package algorithms;

import java.util.*;

public class BFSWithOneQueue {

    public void bfs(TreeNode root) {
        if (root == null)
            return;
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        
        
        // Note here, these 2 vars are used to work like the previous 
        // q and subq
        int nodesInCurrentLevel = 1, nodesInNextLevel =0;
        
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            System.out.println(curr.val);
            
            nodesInCurrentLevel--;
            
            if (curr.left != null) {
                q.offer(curr.left);
                nodesInNextLevel++;
            }
            
            if (curr.right != null) {
                q.offer(curr.right);
                nodesInNextLevel++
            }
            
            if (nodesInCurrentLevel == 0) {
                System.out.println();
                nodesInCurrentLevel = nodesInNextLevel;
                nodesIndexLevel = 0;
            }
        }
    }
    
    public static void main() {
        // just try this
        TreeNode yi = new TreeNode(1);
		TreeNode er = new TreeNode(2);
		TreeNode san = new TreeNode(3);
		TreeNode si = new TreeNode(4);
		TreeNode wu = new TreeNode(5);
		TreeNode liu = new TreeNode(6);
		TreeNode qi = new TreeNode(7);
		
		yi.left = er; yi.right = san;
		er.left = si; er.right = wu;
		san.left = liu; san.right = qi;
		
		bfs(yi);
    }
}
