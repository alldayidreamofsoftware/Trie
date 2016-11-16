import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Contacts {

	public void numContactMatches() {
		
		String inputStr = "4 add hack add hacker find hac find hak";
		Trie root = new Trie();
		Scanner scanner = new Scanner(inputStr);
		int numOperations = scanner.nextInt();
		for(int i = 0; i < numOperations; i++) {
			String str = scanner.next();
			if(str.equals("add")) {
				String addStr = scanner.next();
				root.insert(addStr);
			}
			else if (str.equals("find")) {
				Integer value = root.find(scanner.next());
			   // System.out.println(value);

			}
		}
		scanner.close();
		
	}
	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Contacts sol = new Contacts();
		sol.numContactMatches();
	}
	class TrieNode {
		private boolean leafNode;
		private Character value;
		private HashMap<Character,TrieNode> children;
		private HashMap<Character,Integer> childrenCount;
		
		public TrieNode(Character ch) {
			children = new HashMap<Character,TrieNode> ();
			childrenCount = new HashMap<Character,Integer> ();
			leafNode = false;
			value = ch;
		}
		public boolean isLeafNode() {
			return (leafNode == true);
		}
		public void setLeafNode() {
			leafNode = true;
		}
		public void insertChild(Character c, TrieNode node) {
			children.put(c,node);
		}
		public TrieNode getTrieNode(Character c) {
			return children.get(c);
		}
		public void incrementCount(Character c) {
			Integer value = childrenCount.get(c);
			if(value == null) {
				value = new Integer(1);
				childrenCount.put(c,value);	   
			}
			else {
				value = new Integer(value.intValue() + 1);
				childrenCount.put(c,value);
			}
			
		}
		public Integer getCount(Character c) {
			return childrenCount.get(c);
		}
		public Character getValue() {
			return value;
		}
		
	}
	class Trie {
		private TrieNode root;
		
		public Trie() {
			root = new TrieNode('\0');
		}
		public void insert(String str) {
			TrieNode current = root;
			for(int i = 0; i < str.length(); i++) {
				Character ch = str.charAt(i);
				if(current.getTrieNode(ch) == null) {
					TrieNode newNode = new TrieNode(ch);
					current.insertChild(ch,newNode);
					
				}
				current.incrementCount(ch);
				current = current.getTrieNode(ch);
			}
			current.setLeafNode();
		}
		public Integer find(String str) {
			TrieNode current = root;
			Character ch='\0';
			for(int i = 0; i < str.length(); i++) {
								

				ch = str.charAt(i);
				if(current.getTrieNode(ch) == null) {
					return 0;
				}
				current = current.getTrieNode(ch);
				System.out.println(current.getValue());
				System.out.println(current.getCount(ch));
				
			}
			
			return(current.getCount(ch));
			
		}
		
		
		
	}
}
