package graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class MyUndirectedGraph<T> implements UndirectedGraph<T>{


	private int totalNodes;
	private int totalEdges;
	private Map<T , Node<T>> nodeList;
	private List<Edge<T>> edgeList = new LinkedList<Edge<T>>();
	
	public MyUndirectedGraph() {
		totalNodes = 0;
		totalEdges = 0;
		nodeList = new HashMap<T, Node<T>>();
	}
	
	
	public static class Node<T>{
		
		T data;
		private LinkedList<T> adjList = new LinkedList<T>();
		
		public Node(T node) {
			this.data = node;
			
			
		}
	}
	public static class Edge<T>{
		private T n1, n2;	
		private int c;
		Edge(T node1, T node2, int cost){
			this.n1 = node1;
			this.n2 = node2;
			this.c = cost;
			
		}
		
		public T getNode1() {
			return n1;
		}
		
		public T getNode2() {
			return n2;
		}
		
		public int getCost() {
			return c;
		}
		
	}


	@Override
	public boolean add(T newNode) {

		if(newNode == null) {
			throw new NullPointerException();
		}
		if(nodeList.containsKey(newNode)) {
			return false;
		}
		Node<T> node = new Node<T>(newNode);
		
		
//		System.out.println(newNode.toString()+ " created node");
		nodeList.put(newNode, node);
//		System.out.println(newNode.toString() + node.toString() + " added");
		totalNodes++;
		
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
		if(cost < 1) {
			return false;
		}
		
		if(isConnected(node1 , node2)) {
			for(Edge<T> e : edgeList) {
				if(e.n1.equals(node1)&& e.n2.equals(node2) ||e.n1.equals(node2)&& e.n2.equals(node1) ) {
					e.c = cost;
				
				}
			}
			return true;
		}
		if(!nodeList.containsKey(node1)|| !nodeList.containsKey(node2)) {
			return false;
		}
		Edge<T> edge = new Edge<T>(node1, node2 ,cost);
		edgeList.add(edge);
		nodeList.get(node1).adjList.add(node2);
		nodeList.get(node2).adjList.add(node1);
		totalEdges++;
//		System.out.println("connect true");
					
		return true;
	
	
	}

	@Override
	public boolean isConnected(T node1, T node2) {
		if (nodeList.containsKey(node1) && nodeList.containsKey(node2)) {
			for (Edge<T> e : edgeList) {
				if (e.n1.equals(node1) && e.n2.equals(node2)|| e.n1.equals(node2) && e.n2.equals(node1)) {
					return true;

				} 

			}
		}
		return false;
	}

	@Override
	public int getCost(T node1, T node2) {
		if(!isConnected(node1, node2)) {
			return -1;
		}
		for(Edge<T> e : edgeList) {
			if(e.n1.equals(node1) && e.n2.equals(node2)
			|| e.n1.equals(node2) && e.n2.equals(node1)) {
				return e.c;
			}
		}
		
		return 0;
		
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
	public List depthFirstSearch(T start, T end) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List breadthFirstSearch(T start, T end) {
		Queue<T> nextN = new LinkedList<T>();
		List<T> visited = new LinkedList<T>();
		List<T> temp = new LinkedList<T>();
		if (start == null || end == null) {
			return visited;
		}
		if (nodeList.containsKey(start) && nodeList.containsKey(end)) {

			if (start == end) {
				visited.add(start);
				return visited;
			}

			nextN.add(start);
			System.out.println(start + "										start added ");
			Node<T> node;

			while (!nextN.isEmpty()) {

				node = nodeList.get(nextN.remove());
				visited.add(node.data);
//				visited.add(node.data);
				if (node.data.equals(end)) {
					visited.add(node.data);
					return visited;
				}

				

				System.out.println(visited + "visited");
				System.out.println(node.adjList + "lista för länkade noder");
				System.out.println(nextN + "nextN innan add");

				for (T n : node.adjList) {
					if (visited.contains(n)) {
						continue;
					} else {
						nextN.add(n);
					}
				}
				
				if(!nextN.isEmpty()) {
					
					for(T t : nextN) {
						
						node = nodeList.get(t);
						for (T n : node.adjList) {
							if(visited.contains(n)) {
								
								continue;
							}
							if(node.adjList.contains(end)) {
								System.out.println(nextN + "nextN ENd");
								visited.add(node.data);
								visited.add(end);
								System.out.println(visited + " end");
								
								return visited;
							}
							

						}
					}
				}
				
				System.out.println(nextN + " nextN efter ADd");
			
			
			
				
//				for (T n : node.adjList) {
//					System.out.println(node.adjList + " adj List för: " + n);
//					if(visited.contains(n)) {
//						continue;
//					}else if (node.adjList.contains(end)) {
//						visited.add(n);
//						System.out.println(visited + " end");
//						return visited;
//					} 
//					
//
//					if (!visited.contains(n)) {
//						nextN.add(n);
//						System.out.println(nextN + " ny nextN");
//					}
//					
//
//					visited.add(n);
//					System.out.println(visited + " visited");
//
//
//					
//				}
//
//				
//				for(T n : nextN) {
//					node =nodeList.get(nextN.remove());
//					visited.add(n);
//					System.out.println(nextN + " nextN");
//					if(node.adjList.contains(end)) {
//						System.out.println(visited + " end");
//
//						return visited;
//					}else {
//						for(T e : node.adjList) {
//							nextN.add(e);
//						}
//						System.out.println(nextN + " efter att ha lag till");
//						
//					}
//					
//				}
//				
//				
//				for(T nex : nextN) {
//					temp.add(nex);
//					
//					System.out.println(temp + "added to temp");
//					System.out.println(nextN + "nextN");
//				}
//				
//				
//				for(T t: temp) {
//					node = nodeList.get(t);
//					visited.add(t);
//					System.out.println(visited);
//					if(node.adjList.contains(end)) {
//						System.out.println(visited + " end");
//
//						return visited;
//					}else {
//						for(T tem : temp) {
//							nextN.add(tem);
//						}
//					}
//				}

				
				
				
				
				


				
				
				
				
				
				
				
//				for(T n : nextN) {
//				node = nodeList.get(n);
//				System.out.println(n + "den vi tittar på");
//				temp.add(n);
//				System.out.println(node.adjList + "ADJLIST" );
//				
//				for(T e : node.adjList) {
//					
//					if(node.adjList.contains(end)) {
//						for (T t :temp) {
//							visited.add(t);
//						}
//						return visited;
//		
//					}else {
//						nextN.add(e);
//					}
//				}
//			}
			
			
//			for(T n : nextN) {
//				node = nodeList.get(n);
//				temp.add(node.data);
//				
//				
//				if (node.adjList.contains(end)) {
//					
//					for(T e : temp) {
//						visited.add(e);
//					}
//					return visited;
//				}
//				
//				for(T e : node.adjList) {
//					nextN.add(e);
//				}
//			}
				
				
				
			}
			
		}
		return visited;
		
	}

	@Override
	public UndirectedGraph minimumSpanningTree() {
		// TODO Auto-generated method stub
		return null;
	}

}
