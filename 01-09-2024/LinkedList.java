
// Given the heads of 2 linkdelists. WAP to calculate the sum of node data
// from the point where the 2 lists merge and point to the same address.

package LinkedListPack;

import java.util.ArrayList;

public class LinkedList {
	
	static Node head1, head2;
	public static void main(String args[]) {
		
		Node intersect = new Node(4);
		intersect.next = new Node(5);

		head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = intersect;
		
		head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = intersect;
		
		System.out.println(LLSumApproach1(head1,head2));
		System.out.println(LLSumApproach2(head1,head2,5,4));

	}
	
	public static int LLSumApproach1(Node head1, Node head2) {
		int sum = 0;
		
		ArrayList<Node> list1 = new ArrayList<>();
		ArrayList<Node> list2 = new ArrayList<>();
		Node itr1 = head1;
		while(itr1!=null) {
			list1.add(itr1);
			itr1=itr1.next;
		}
		
		Node itr2=head2;
		while(itr2!=null) {
			list2.add(itr2);
			itr2=itr2.next;
		}
		int l1 = list1.size()-1;
		int l2 = list2.size()-1;
		while(list2.get(l2)==list1.get(l1)) {
			sum += list2.get(l2).data;
			l2--;
			l1--;
		}
		
		return sum;
	}

	public static int LLSumApproach2(Node head1, Node head2, int l1, int l2) {
		int sum = 0;
		int i=0;
		//Given l1>l2 always
		while(i<l1-l2) {
			head1 =head1.next;
			i++;
		}
		while(head1!=head2) {
			head1 = head1.next;
			head2 = head2.next;
		}
				
		while(head1!=null) {
			sum+=head1.data;
			head1=head1.next;
		}			
		return sum;
	} 
}

class Node {
	
	public int data;
	public Node next;
	public Node(int data) {
		super();
		this.data = data;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}

}
