package BFS;
import java.util.ArrayList;

public class Node<T> {
	private T value;
	private ArrayList<Node<T>> children ;

	public Node(T value){
		this.value = value ;
		children = new ArrayList<Node<T>>();
	}
	
	public void addChild(Node<T> child){
		children.add(child) ;
	}
	
	public T getValue(){
		return value ;
	}
	
	public ArrayList<Node<T>> getChildren(){
		return children ;
	}

}