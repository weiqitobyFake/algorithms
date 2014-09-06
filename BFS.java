package algorithm;

import java.util.*;

// BFS用于图上.
// 一般这种问题, 常见的情况问是否在图上的两点上存在path之类的问题
// 这种问题的解决办法: BFS
// BFS的精髓就是在于要用Queue, 按层筛选.
// BFS class列出了常见的两种BFS问题
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
