package LinkedList;

public class Test {
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		String str = "화";
		String str1 = "목";
		String str2 = "일";

		list.insertFirstNode(str2);
		list.insertFirstNode(str1);
		list.insertFirstNode(str);
		list.printList();

		ListNode pre = list.searchNode(str1);
		if (pre == null) {
			System.out.println("검색실패");
		} else {
			list.insertMiddleNode(pre, "금");
		}
		list.printList();
		
		
		list.insertFirstNode("월");
		list.printList();
		
		ListNode pre1 = list.searchNode("금");
		if(pre1 == null) {
			System.out.println("검색실패");
		}else {
			list.insertMiddleNode(pre1, "토");
			list.printList();
		}
		list.insertFirstNode("휴일");
		list.printList();
	}
	
}