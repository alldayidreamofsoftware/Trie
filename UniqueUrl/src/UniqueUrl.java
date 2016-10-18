import java.util.Arrays;

public class UniqueUrl {

	private boolean isLeaf;
	private UniqueUrl children[];
	final int URL_MAX_CHAR =256;
	DoubleLinkedListNode node;
	static DoubleLinkedList list = new DoubleLinkedList();
	
	public UniqueUrl() {
		this.isLeaf = false;
		children = new UniqueUrl [URL_MAX_CHAR];
		Arrays.fill(children, null);
	}
	public void insert(String url) {
		
		UniqueUrl current = this;
		for(int i=0; i< url.length();i++) {

			int index = (int) url.charAt(i);
			
			if(current.children[index] == null) {
				current.children[index] = new UniqueUrl();
			}
			current = current.children[index];
		}
		if(current.isLeaf == true) {
			if(current.node != null) {
				list.delete(current.node);
				current.node = null;
			}
		}
		else {
			current.isLeaf = true;
			current.node=list.insert(url);
		}
		return;
	}
	public String getUniqueUrl() {
		
		return list.getHeadData();
	}
	public boolean search(String url) {
		UniqueUrl current = this;
		for(int i=0;i<url.length();i++) {
			int index = (int)url.charAt(i);
			if(current.children[index] == null) {
				return false;
			}
			else {
				current = current.children[index];
			}
		}
		return current.isLeaf;
	}
}
