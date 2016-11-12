import java.util.Arrays;
import java.util.Stack;

public class UniqueUrl {

	private boolean isLeaf;
	private UniqueUrl parent;
	private UniqueUrl children[];
	private String str="";
	int goBackIndex;
	
	
	
	final int URL_MAX_CHAR =26;
	DoubleLinkedListNode node;
	static DoubleLinkedList list = new DoubleLinkedList();
	static Stack<UniqueUrl> stack = new Stack<UniqueUrl>();
	static Stack<Integer> trackIndex = new Stack<Integer>();
	
	public UniqueUrl() {
		this.isLeaf = false;
		children = new UniqueUrl [URL_MAX_CHAR];
		Arrays.fill(children, null);
		this.parent = null;
		this.goBackIndex =0;
	}
	public void insert(String url) {
		
		UniqueUrl current = this;
		for(int i=0; i< url.length();i++) {

			int index = (int) url.charAt(i);
			index = index - 'a';
			
			if(current.children[index] == null) {
				current.children[index] = new UniqueUrl();
				current.children[index].parent = current;
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
public void printTrieNoStack(UniqueUrl root) {
		
		int index=0;
		int level =0;
		
		
		do{
			index = root.goBackIndex;
			root.goBackIndex = 0;
			while(index < URL_MAX_CHAR) {
				if(root.children[index] != null) {
					 char temp = (char)(index+ 'a');
					 str=str.concat(Character.toString((temp)));
					 root.goBackIndex = index + 1;
					 level ++;
					 root = root.children[index];
					 index=0;
					 
				}
				else 
					index++;
			}
			if(level == 0)
				return;
			if(root.isLeaf == true) {
				System.out.println(str);
			}
			level --;
			str = str.substring(0,level);
			root = root.parent;
		}while(root != null);
		
		
		
	}
	public void printTrie(UniqueUrl root) {
		
		int index=0;
		int prev_index=0;
		int level =0;
		
		
		do{
			while(index < URL_MAX_CHAR) {
				if(root.children[index] != null) {
					 char temp = (char)(index+ 'a');
					 str=str.concat(Character.toString((temp)));
					 level ++;
					 prev_index = index;
					 stack.push(root);
					 index++;
					 trackIndex.push(index);
					 root = root.children[prev_index];
					 index=0;
					 
				}
				else 
					index++;
			}
			if(root.isLeaf == true) {
				System.out.println(str);
				
			}
			if(!stack.isEmpty()) {
				root = stack.pop();
				level --;
				str = str.substring(0,level);
				if(!trackIndex.isEmpty()) {
					index = trackIndex.pop();
				}
			}
			
		}while(root != null);
		
		
		
	}
	public void printQueue() {
		
	}
	public void delete(String url) {
		
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
