
public class DoubleLinkedList{

	private int numElements;
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode tail;
	
	public DoubleLinkedList () {
		numElements = 0;
		head =null;
		tail =null;
	}
	public  DoubleLinkedListNode insert(String data) {
		
		DoubleLinkedListNode node = new DoubleLinkedListNode();
		
		if(tail == null) {
			node.data =data;
			head=node;
			tail=node;
		}
		else {
			node.data = data;
			node.prev = tail;
			tail.next =node;
			tail = node;
						
		}
		numElements ++;
		
		return tail;
	
	}
	public void delete(DoubleLinkedListNode node) {
		
		
		if(node == null) {
			return;
		}
		if(head == tail) {
			head =null;
			tail=null;
		}
	   else if(node == head) {
			head = node.next;
			head.prev = null;
		}
		else if(node == tail) {
			tail = node.prev;
			tail.next =null;
		}
		else {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			
		}
		node =null;
		numElements --;
		
		
	}
	public String getHeadData() {
		if(numElements != 0) {
			return head.data;
		}
		else {
			return null;
		}
			
	}
	
}

	


