
public class Solution {

	
	public static void main(String[] args) {

			String urls[] = {
								"http://www.linkedin.com",
								"www.samsung.com",
								"www.samsung.com",
								"www.google.com",
								"www.google.com",
								"http://www.linkedin.com",
								"www.korea.com",
								"www.korea.com"
							};
			
			UniqueUrl root = new UniqueUrl();
			
			for(int i =0; i <urls.length;i++) {
				root.insert(urls[i]);
								
			}
			System.out.print(root.getUniqueUrl());
	}

}
