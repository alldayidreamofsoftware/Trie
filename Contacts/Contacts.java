import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public void numContactMatches() {
        
        Trie root = new Trie();
        Scanner scanner = new Scanner(System.in);
        int numOperations = scanner.nextInt();
        for(int i = 0; i < numOperations; i++) {
            String str = scanner.next();
            if(str.equals("add")) {
                String addStr = scanner.next();
                root.insert(addStr);
            }
            else if (str.equals("find")) {
                Integer value = root.find(scanner.next());
                System.out.println(value);

            }
        }
        scanner.close();
        
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Solution sol = new Solution();
        sol.numContactMatches();
    }
    class TrieNode {
        public boolean leafNode;
        public HashMap<Character,TrieNode> children;
        public HashMap<Character,Integer> childrenCount;
        
        public TrieNode() {
            children = new HashMap<Character,TrieNode> ();
            childrenCount = new HashMap<Character,Integer> ();
            leafNode = false;
        }
       
        
    }
    class Trie {
        private TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        public void insert(String str) {
            TrieNode current = root;
            for(int i = 0; i < str.length(); i++) {
                Character ch = str.charAt(i);
                if(current.children.get(ch) == null) {
                    TrieNode newNode = new TrieNode();
                    current.children.put(ch,newNode);
					
                }
				Integer value = current.childrenCount.get(ch);
				if(value == null) {
					current.childrenCount.put(ch,1);    
				}
				else {
					value++;
					current.childrenCount.put(ch,value);
				}
				current = current.children.get(ch);
            }
			current.leafNode = true;
        }
		public Integer find(String str) {
			TrieNode current = root;
            Character ch='\0';
            int count=0;
			for(int i = 0; i < str.length(); i++) {
				ch = str.charAt(i);
				if(current.children.get(ch) == null) {
					return 0;
				}
                count =current.childrenCount.get(ch);
                current = current.children.get(ch);
			}
			
            return count;
			
		}
		
        
        
    }
}
