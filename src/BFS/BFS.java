package BFS;
/*
 *  2012-07-17 John Matthew Ian Davis
 *  Breadth first search
 *  this is something I could not produce for an interview
 *  so as penance I am writing it up and putting it on GitHub
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class BFS<T> {
	
	private Queue<Node<T>> queue;
	private HashSet<Node<T>> visitedList;

	public boolean search(T elementSearchedFor, Node<T> headOfGraphToSearch){

		queue = new LinkedList<Node<T>>();
		visitedList = new HashSet<Node<T>>();

		queue.add(headOfGraphToSearch) ;
		while(! queue.isEmpty()){
			Node<T> next = queue.poll() ;
			
			// detect and avoid loops in graph
			if(visitedList.contains(next))
			{ 
				continue ;
			}
			else
			{
				visitedList.add(next) ;
			}
			
			// if this is the one we were looking for ... done
			if(next.getValue() == elementSearchedFor ) return true ;
			
			// put the children on the queue
			for(Node<T> child : next.getChildren()){
				queue.add(child);				
			}
		}
		return false ;
	}
}
