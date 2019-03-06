package graph2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class MyUndirectedGraph<T> implements UndirectedGraph<T> {

	
	private int totalNodes;
	private int totalEdges;
	private HashMap<T, ArrayList<Edge>> map;
	
	public MyUndirectedGraph(){
		totalNodes = 0;
		totalEdges = 0;
		map = new HashMap<T, ArrayList<Edge>>();
	}
	
	private class Node {
		private String data;
		public Node(T newNode) {
			data = newNode.toString();
		}
	}
	
	private class Edge {
		private int weight;
		public T from;
		public T to;
		public Edge(int w, T f, T t) {
			weight = w;
			from = f;
			to = t;
		}
		
		@Override
		public String toString() {
			return (from + " to " + to + " " + weight);
		}
	}
	
	@Override
	public int getNumberOfNodes() {
		return totalNodes;
	}

	@Override
	public int getNumberOfEdges() {
		return totalEdges;
	}

	@Override
	public boolean add(T newNode) {
//		Node n = new Node(newNode);
		if(map.containsKey(newNode)) {
			return false;
		}
		
		map.put(newNode, new ArrayList<>());
		totalNodes++;
		return true;
	}

	@Override
	public boolean connect(T node1, T node2, int cost) {
		if(cost<1) {
			return false;
		}
		if(isConnected(node1, node2)) {
			//uppdatera vikt
			for(Edge e : map.get(node1)) {
				if(e.from == node1 && e.to == node2 || e.from == node2 && e.to == node1) {
					e.weight = cost;
				}
			}
			for(Edge e : map.get(node2)) {
				if(e.from == node1 && e.to == node2 || e.from == node2 && e.to == node1) {
					e.weight = cost;
				}
			}
			return true;
		}
		//koppla ihop nod1 med nod2
		
		if(!map.containsKey(node2) || !map.containsKey(node1)) {
			return false;
		}
		Edge e = new Edge(cost, node1, node2);
		map.get(node1).add(e);
		map.get(node2).add(e);
		totalEdges++;
		return true;
	}

	@Override
	public boolean isConnected(T node1, T node2) {
		if(!map.containsKey(node1)) {
			return false;
		}
		for(Edge e : map.get(node1)) {
			if(e.from == node1 && e.to == node2 || e.from == node2 && e.to == node1) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int getCost(T node1, T node2) {
		if(!isConnected(node1, node2)) {
			return -1;
		} 
		for(Edge e : map.get(node1)) {
			if(e.from == node1 && e.to == node2 || e.from == node2 && e.to == node1) {
				return e.weight;
			}
		}
		for(Edge e : map.get(node2)) {
			if(e.from == node1 && e.to == node2 || e.from == node2 && e.to == node1) {
				return e.weight;
			}
		}
		
		return 0;
	}

	@Override
	public List<T> depthFirstSearch(T start, T end) {
		List<T> pathList = new ArrayList<T>();
		Stack<T> pathStack = new Stack<T>();
		T temp = start;
		
//		for(Edge e : map.get(start)) {
//			if(map.get(start).isEmpty()) {
//				pathStack.pop();
//			}
//			pathList.add(e.from);
//			pathStack.push(e.from);
//			temp = e;
//		}
		for(int i = 1; i<= totalNodes;i++) {
			System.out.println(temp + " check");

			if(map.get(temp).isEmpty() && !temp.toString().equals(end.toString())) {
				temp = pathStack.pop();
			}
			if(!pathList.contains(temp)) {
				pathList.add(temp);
				pathStack.push(temp);
				//hitta någon nod som är connectad till temp
				temp = map.get(temp).get(0).from;	
//				System.out.println(map.get(temp).get(0).from.toString() + " " + map.get(temp).get(1).to.toString());
//				System.out.println(map.get(temp).get(1).toString());
				}
			if(temp.toString().equals(end.toString())) {
				System.out.println("break");
				break;
			}
		}
		System.out.println(pathList);
		return pathList;
	}

	@Override
	public List<T> breadthFirstSearch(T start, T end) {
		PriorityQueue<T> pathQueue = new PriorityQueue<T>();
		
		return null;
	}

	@Override
	public UndirectedGraph<T> minimumSpanningTree() {
		// TODO Auto-generated method stub
		return null;
	}

}
