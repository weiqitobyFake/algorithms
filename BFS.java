package algorithm;

import java.util.*;

// BFS is frequently used in graph problem.
// For the problem like to decide whether there is a path between two nodes, etc.
// The key part of BFS is to use a queue.
public class BFS {
	
	/***
	 * @description Print a Binary Tree by level order
	 * @param root
	 */
	public void printTreeByLevel(TreeNode root) {
		if (root == null)
			return;
		
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		
		while (!q.isEmpty()) {
			
			Queue<TreeNode> sub = new LinkedList<TreeNode>();
			while (!q.isEmpty()) {
				TreeNode item = q.poll();
				
				if (q.isEmpty()) {
					System.out.println(item.val);
				}else
					System.out.println(item.val+ " ");
				
				if (item.left != null)
					sub.offer(item.left);
				if (item.right != null)
					sub.offer(item.right);
			}
			q.addAll(sub);
		}
	}
	
	
	public int wordLadder(String start, String end, Set<String> dict) {
		if (start == end )
			return 1;
		
		Queue<String> w = new LinkedList<String>();
		Queue<Integer> s = new LinkedList<Integer>();
		
		w.offer(start);
		s.offer(1);
		
		while (!w.isEmpty()) {
			
			String curr = w.poll();
			int step = s.poll();
			
			if (curr.equals(end))
				return step;
			
			for (int i=0; i<curr.length(); i++) {
				char[] a = curr.toCharArray();
				
				for (char c = 'a'; c<='z'; c++) {
					a[i] = c;
					String newOne = new String(a);
					
					if (dict.contains(newOne));
					dict.remove(newOne);
					
					w.offer(newOne);
					s.offer(step+1);
				}
			}
		}
		return 0;
	}
}
