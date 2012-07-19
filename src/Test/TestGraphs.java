package Test;

import static org.junit.Assert.*;
import org.junit.Test;
import BFS.BFS;
import BFS.Node;
public class TestGraphs {

/*
 *               One
 *          -------------------     
 *         |         |         |           
 *        Two      Three      Four
 *       ----       ----       |  
 *      |    |     |    |      |    
 *    Five  Six  Seven Eight  Nine   
 * 
 */

	private Node<String> simpleTree(){
		
		//leaf nodes - level 3
		Node<String> five = new Node<String>("Five");
		Node<String> six = new Node<String>("Six");
		Node<String> seven = new Node<String>("Seven");
		Node<String> eight = new Node<String>("Eight");
		Node<String> nine = new Node<String>("Nine");
		
		//level 2
		Node<String> two = new Node<String>("Two");
		two.addChild(five) ;
		two.addChild(six) ;
		
		Node<String> three = new Node<String>("Three");
		three.addChild(seven) ;
		three.addChild(eight) ;
		
		Node<String> four = new Node<String>("Four");
		four.addChild(nine) ;
		
		//root
		Node<String> one = new Node<String>("One");
		one.addChild(two) ;
		one.addChild(three) ;
		one.addChild(four) ;
		
		return one ;
	
	}
	
	/*
	 *        ---<-------------<------
	 *       |                        |   
	 *        ---> A ---> B ---> C --- 
	*/
	
	private Node<String> circle(){
		Node<String> a = new Node<String>("A");
		Node<String> b = new Node<String>("B");
		Node<String> c = new Node<String>("C");
		a.addChild(b) ;
		b.addChild(c) ;
		c.addChild(a) ;
		return a ;
	}

	@Test
	public void testTree(){
		Node<String> searchMe = simpleTree();
		BFS<String> bfs = new BFS<String>();
		assertTrue(bfs.search("Nine", searchMe)) ;
		assertTrue(bfs.search("Two", searchMe)) ;
		assertFalse(bfs.search("Ten", searchMe)) ;
	}
	
	@Test
	public void testCircle(){
		Node<String> searchMe = circle();
		BFS<String> bfs = new BFS<String>();
		assertTrue(bfs.search("C", searchMe)) ;
		assertFalse(bfs.search("D", searchMe)) ;
	}
	
}