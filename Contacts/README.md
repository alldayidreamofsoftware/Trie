# We're going to make our own Contacts application! The application must perform two types of operations:

add name, where  is a string denoting a contact name. This must store  as a new contact in the application.
find partial, where  is a string denoting a partial name to search the application for. It must count the number of contacts starting with  and print the count on a new line.
Given  sequential add and find operations, perform each operation in order.

#Input Format

The first line contains a single integer, , denoting the number of operations to perform. 
Each line  of the  subsequent lines contains an operation in one of the two forms defined above.

#Constraints

It is guaranteed that  and  contain lowercase English letters only.
The input doesn't have any duplicate  for the  operation.

#Output Format

For each find partial operation, print the number of contact names starting with  on a new line.

#Sample Input

4
add hack
add hackerrank
find hac
find hak

#Sample Output

2
0

#Explanation

We perform the following sequence of operations:

Add a contact named hack.
Add a contact named hackerrank.
Find and print the number of contact names beginning with hac. There are currently two contact names in the application and both of them start with hac, so we print  on a new line.
Find and print the number of contact names beginning with hak. There are currently two contact names in the application but neither of them start with hak, so we print  on a new line.


We use a trie data structure and each node stores a character. The root node we maintain a null string. Leaf nodes we mark with a boolean variable. We maintain two hashmaps. One hashmaps gives us
the trienode character given the character as key. That way we can traverse to the child. We maintain one more hashmap for keeping a count of children. Assume the root node is null. There are 
children starting with a,b...z. If we says how many children start with a? we will have to know all the words that start with a and have been inserted into the trie datastructure. In insertion
it definetely passes through the node a. Similarly how many children are with ab as the prefix? From the below figure I can say at the root how many words start with a or h ? Essentially
how many words have a or h as prefix?

------------------------------------------------------------------------------------------------------------------------------------------------------------------
 |value | leaf node | hashmap for children(where is the next node pointer for character a,b etc ?)| hashmap for count(a,b,c.d.....z)                              |
 |																																								   |
--------------------------------------------------------------------------------------------------------------------------------------------------------------------