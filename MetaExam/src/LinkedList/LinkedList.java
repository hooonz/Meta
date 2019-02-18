package LinkedList;

public class LinkedList {
	private ListNode head;

	public LinkedList() {
		this.head = null;
	}

	void insertLastNode(String str) {
		ListNode node = new ListNode(str);
		if (head == null) {
			head = node;
		} else {
			ListNode current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = node;
		}
	}

	void insertMiddleNode(ListNode pre, String str) {
		ListNode node = new ListNode(str);
		if (head == null) {
			head = node;
		} else {
			ListNode current = head;
			while (current.next != pre) {
				current = current.next;
			}
			current = current.next;
			node.next = current.next;
			current.next = node;
		}
	}

	void insertFirstNode(String str) {
		ListNode node = new ListNode(str);
		if (head == null) {
			head = node;
		} else {
			ListNode current = head;
			node.next = current;
			head = node;
		}
	}

	void deleteLastNode() {
		if (head == null) {
			System.out.println("지울 노드가 존재하지 않습니다.");
		} else {
			ListNode prev = head;
			ListNode current = head.next;
			while (current.next != null) {
				prev = current;
				current = current.next;
			}
			prev.next = null;
		}
	}

	void deleteMiddleNode(String str) {
		ListNode node = new ListNode(str);
		if (head == null) {
			System.out.println("지울 노드가 존재하지 않습니다.");
		} else {
			ListNode prev = head;
			ListNode current = head.next;
			while (current.data != node.data) {
				prev = current;
				current = current.next;
			}
			prev.next = current.next;
		}
	}

	void deleteFirstNode() {
		if (head == null) {
			System.out.println("지울 노드가 존재하지 않습니다.");
		} else {
			head = head.next;
		}
	}

	ListNode searchNode(String str) {
		ListNode node = new ListNode(str);
		if (head == null) {
			System.out.println("노드가 비어있습니다.");
			return null;
		} else {
			ListNode current = head;
			while (current.data != node.data) {
				current = current.next;
			}
			return current;
		}
	}

	void reverseList() {
		ListNode next = head;
		ListNode current = null;
		ListNode prev = null;

		while (next != null) {
			prev = current;
			current = next;
			next = next.next;
			current.next = prev;
		}
		head = current;
	}

	void printList() {
		if (head == null) {
			System.out.println("출력할 리스트가 존재하지 않습니다.");
		} else {
			ListNode current = head;
			System.out.print("[");
			while (current.next != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.print(current.data);
			System.out.print("]");
			System.out.println();
		}
	}
}
