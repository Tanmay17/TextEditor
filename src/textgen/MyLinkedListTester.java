/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
                int size=list1.size();
		list1.add(340);
		assertEquals("Size of list:", size+1, list1.size());
		int num=list1.get(list1.size()-1);
		System.out.println(num);
		assertEquals("Last Value:", 340, num );
		try{
			list1.add(null);
			fail("Test fail");
		}
		catch(NullPointerException e){
			
		}
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
                assertEquals("Zero Size:", 0, emptyList.size());
		emptyList.add(1);
		assertEquals("Size one", 1, emptyList.size());
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        
                int n=list1.get(1);
                int size=list1.size();
                list1.add(1, 52);
                int n1=list1.get(1);
        
                assertEquals("element",52,n1);
                assertEquals("element",n,(int)list1.get(2));
                assertEquals("element",size+1,list1.size());
        
                try{
			list1.add(1,null);
			fail("test failed");
		}
		catch(NullPointerException e){
			
		}
                try{
			list1.add(-1,45);
			fail("test failed");
		}
		catch(IndexOutOfBoundsException e){
			
		}
                try{
			list1.add(50,45);
			fail("test failed");
		}
		catch(IndexOutOfBoundsException e){
                }	
		
		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    int size=longerList.size();
		int n1=longerList.get(3);
		int n=longerList.set(2,23);
		assertEquals("Element",size, longerList.size());
		assertEquals("Element",23,(int)longerList.get(2));
		assertEquals("Element",n1,(int)longerList.get(3));
	    // TODO: implement this test
		 try{
				list1.set(1,null);
				fail("test failed");
			}
			catch(NullPointerException e){
				
			}
	        try{
				list1.set(-1,45);
				fail("test failed");
			}
			catch(IndexOutOfBoundsException e){
				
			}
	        try{
				list1.set(50,45);
				fail("test failed");
			}
			catch(IndexOutOfBoundsException e){
				
			}
	}
	
	
	// TODO: Optionally add more test methods.
	
}
