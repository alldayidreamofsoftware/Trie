
public class Solution {

	
	public static void main(String[] args) {

			String urls[] = {
								"hello",
								"world",
								"wecandoit"
							};
			
			UniqueUrl root = new UniqueUrl();
			
			for(int i =0; i <urls.length;i++) {
				root.insert(urls[i]);
								
			}
			root.printTrieNoStack(root);
			//root.delete("www.google.com");
			//System.out.print(root.getUniqueUrl());
	}

}
