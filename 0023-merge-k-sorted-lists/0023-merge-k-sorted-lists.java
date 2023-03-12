/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

	class Solution {
	    public ListNode mergeKLists(ListNode[] lists) {
	        int len = lists.length;
	        if(len == 0 )   return null;
	        if(1 == len) return lists[0];
	        ListNode result = new ListNode(0);
	        result.next = lists[0];
	        for(int i= 1; i < len; i++){
	            result = mergeTwoList(result, lists[i]);
	        }
	        return result.next;
	    }
	    private ListNode mergeTwoList(ListNode result, ListNode mergeList){
	        ListNode ans = new ListNode(0);
	        ListNode dummy  = ans;
	        ListNode head = new ListNode(0);
	        head.next = mergeList;
	        while(head.next != null || result.next != null){
	            if(head.next != null && result.next != null){
	                if(head.next.val <= result.next.val){
	                    ans.next = head.next;
	                    head.next = head.next.next;
	                }else{
	                    ans.next = result.next;
	                    result.next = result.next.next;
	                }
	                ans = ans.next;
	            }else if(head.next != null && result.next == null){
	                ans.next = head.next;
	                break;
	            }else{
	                ans.next = result.next;
	                break;
	            }
	        }
	        return dummy;
	    }
	}