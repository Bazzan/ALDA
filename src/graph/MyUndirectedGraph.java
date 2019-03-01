package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MyUndirectedGraph<T> implements UndirectedGraph<T>{
//
//
//	public static class Node<T>{
//		
//		T data;
////		private LinkedList<T> adjList;
//		
//		public Node(T node) {
//			this.data = node;
////			this.adjList = new LinkedList<T>();
//			
//		}
//	}
	public static class Edge<T>{
		private T node1, node2;	
		private int cost;
		Edge(T node1, T node2, int cost){
			this.node1 = node1;
			this.node2 = node2;
			this.cost = cost;
			
		}
		
		public T getNode1() {
			return node1;
		}
		
		public T getNode2() {
			return node2;
		}
		
		public int getCost() {
			return cost;
		}
		
	}
	private Edge<T> edge;
	private MyUndirectedGraph graph;
	
	private HashSet<T> nodeList = new HashSet<T>();
	private ArrayList<Edge<T>> edgeList = new ArrayList<Edge<T>>(); 
	//System.out.println("nya Listor");

//	private Node<T> node;
	
//	private LinkedList<T> adjList = new LinkedList<T>();

	
	
	//	public MyUndirectedGraph(){
//		list = new HashMap<>();
//		edgeList = new HashMap<>();
//		System.out.println("Init");
//		
//	}


	@Override
	public boolean add(T newNode) {
//		Node<T> node =  new Node<T>(newNode);

		if(newNode == null) {
			throw new NullPointerException();
		}
		if(nodeList.contains(newNode)) {
			return false;
		}
		
//		node = new Node<T>(newNode);
		
		System.out.println(newNode.toString()+ " created");
		nodeList.add(newNode);
		System.out.println(newNode.toString() + " added");
		
		
		return true;
	}
	
//	public T getNode(int i) {
//		return arr.get(i);
//	}
//	public T getData(int i) {
//		node = getNode(i);
//	}

	@Override
	public boolean connect(T node1, T node2, int cost) {
		if(nodeList.contains(node1) && nodeList.contains(node2)) {
			edge = new Edge<T>(node1, node2, cost);
			if(edgeList.contains(edge)) {
				return false;
			}else if(cost < 0) {
				throw new IllegalArgumentException("Cost cant be lower than 0");
			}
		}
		edgeList.add(edge);
		return true;
	}

	@Override
	public boolean isConnected(Object node1, Object node2) {
		if(nodeList.contains(node1) && nodeList.contains(node2)) {
			
			for(Edge<T> e : edgeList) {
				node1.equals(e.getNode1());
			}
		}
	
		return true;
	}


	@Override
	public int getCost(Object node1, Object node2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfNodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getNumberOfEdges() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public List depthFirstSearch(Object start, Object end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List breadthFirstSearch(Object start, Object end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UndirectedGraph minimumSpanningTree() {
		// TODO Auto-generated method stub
		return null;
	}

}
