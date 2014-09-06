package algorithms;

import java.util.*;

public class MergeSortLinkedList {
	ArrayList<ListNode> list;
	ArrayList<ListNode> temp;
	public ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null)
			return head;
		
		list = new ArrayList<ListNode>();
		ListNode p = head;
		
		while (p != null) {
			list.add(p);
			p = p.next;
		}
		
		temp = new ArrayList<ListNode>();
		for (int i=0; i<list.size(); i++) {
			temp.add(null);
		}
		
		helper(0, list.size()-1);
		
		System.out.println(list);
		
		
		// Even if here is O(n) the overall is still 
		// O(nlogn)
		// But this method spends some space 
		int i=0;
		while (i < list.size()-1) {
			list.get(i).next = list.get(i+1);
			i++;
			if (i == list.size()-1)
				list.get(i).next = null;
		}
		
		return list.get(0);
	}
	
	public void helper(int low, int high) {
		if (low == high)
			return;
		
		int m = (low+high)/2;
		helper(low, m);
		helper(m+1, high);
		doMerge(low, m, high);
	}
	
	public void doMerge(int low, int m, int high) {
		for (int i=low; i<=high; i++) {
			temp.set(i, list.get(i));
		}
		
		int i=low, j=m+1;
		int k = low;
		
		while (i <= m && j <= high) {
			ListNode first = temp.get(i), sec = temp.get(j);
			if (first.value < sec.value) {
				list.set(k, first);
				i++;
			}else {
				list.set(k, sec);
				j++;
			}
			k++;
		}
		
		while (i <= m) {
			list.set(k++, temp.get(i++));
		}
	}
	
	// The method above is using array imitating array mergeSort
	// This method can not pass very big data
	public static void main(String[] args) {
		ListNode yi = new ListNode(-4);
		ListNode er = new ListNode(5);
		ListNode san = new ListNode(1);
		ListNode si = new ListNode(-2);
		ListNode wu = new ListNode(0);
		ListNode liu = new ListNode(7);
		ListNode qi = new ListNode(6);
		ListNode ba = new ListNode(13);
		ListNode jiu = new ListNode(-7);
		ListNode shi = new ListNode(10);
		
		yi.next = er;
		er.next = san;
		san.next = si;
		si.next = wu;
		wu.next = liu;
		liu.next = qi;
		qi.next = ba;
		ba.next = jiu; 
		jiu.next = shi;
		
		MergeSortLinkedList m = new MergeSortLinkedList();
		ListNode ans = m.sortList(yi);
		
		ListNode p = ans;
		while (p != null) {
			System.out.println(p + " ");
			p = p.next;
		}
	}
	
	// The method below is a good one
	// which use divide and conquer
	// Then merge together each list
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        return helper(head);
    }
    
	// This part is core part of this problem
	// Learn how to divide and conquer
    public ListNode helper(ListNode head) {
        if (head.next == null)
            return head;
        
        ListNode slow = head, fast = head;
        ListNode head1 = head;
        
        // This can be used to find the middle point
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode head2 = slow.next;
        slow.next = null;
        
        // divide
        head1 = helper(head1);
        head2 = helper(head2);
        
        // conquer
        return doMerge2(head1, head2);
    }
    
    // This method would allocate too much space on the stack
    public ListNode doMerge(ListNode h1, ListNode h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
            
        if (h1.value < h2.value) {
            h1.next = doMerge(h1.next, h2);
            return h1;
        }else {
            h2.next = doMerge(h1, h2.next);
            return h2;
        }
    }
    
    
    // Choose this iterative one
    public ListNode doMerge2(ListNode h1, ListNode h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
            
        ListNode p1 = h1, p2 = h2;
        ListNode newHead = new ListNode(0);
        ListNode p = newHead;
        
        while (p1 != null && p2 != null) {
            if (p1.value < p2.value) {
                p.next = p1;
                p1 = p1.next;
            }else {
                p.next = p2;
                p2 = p2.next;
            }
            
            p = p.next;
        }
        
        if (p1 != null) {
            while (p1 != null) {
                p.next = p1;
                p = p.next;
                p1 = p1.next;
            }
        }else {
            while (p2 != null) {
                p.next = p2;
                p = p.next;
                p2 = p2.next;
            }
        }
        
        return newHead.next;
    }
}
