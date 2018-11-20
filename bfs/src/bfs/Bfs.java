package bfs;

class Queue {
	private final int SIZE = 20;
	private int[] queArray;
	private int front;
	private int rear;

	public Queue() {
		queArray = new int[SIZE];
		front = 0;
		rear = -1;
	}

	public void insert(int j) {
		if (rear == SIZE - 1)
			rear = -1;
		queArray[++rear] = j;
	}

	public int remove() {
		int temp = queArray[front++];
		if (front == SIZE)
			front = 0;
		return temp;
	}

	public int peek() {
		return queArray[front];
	}

	public boolean isEmpty() {
		return (rear + 1 == front || (front + SIZE - 1 == rear));
	}

}

class StackX {
	private final int SIZE = 20;
	private int[] st;
	private int top;

	public StackX() {
		st = new int[SIZE];
		top = -1;
	}

	public void push(int j) {
		st[top++] = j;
	}

	public int pop() {
		return st[top--];
	}

	public int peek() {
		return st[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}

class Vertex {
	public char label;
	public boolean wasVisited;

	public Vertex(char lab) {
		label = lab;
		wasVisited = false;
	}

}

class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;
	private Queue theQueue;
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++)
			for (int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = 0;
		theQueue = new Queue();
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public void bfs() {
		vertexList[0].wasVisited = true;
		// displayVertex(0);
		theQueue.insert(0);
		int v2;
		while (!theQueue.isEmpty())

		{
			int v1 = theQueue.peek();
			if ((v2 = getAdjUnvisitedVertex(v1)) != -1) {
				vertexList[v2].wasVisited = true;
				displayVertex(v1);
				displayVertex(v2);
				theQueue.insert(v2);
				System.out.print(' ');
			} else {
				theQueue.remove();

			}
		}
		for (int j = 0; j < nVerts; j++)
			vertexList[j].wasVisited = false;
	}
	
	

	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++)
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	}
}

public class Bfs {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A'); // 0
		theGraph.addVertex('B'); // 1
		theGraph.addVertex('C'); // 2
		theGraph.addVertex('D'); // 3
		theGraph.addVertex('E'); // 4
		theGraph.addVertex('F'); // 5
		theGraph.addVertex('G'); // 6
		theGraph.addVertex('H'); // 7
		theGraph.addVertex('I'); // 8

		Graph graph2 = new Graph();
		graph2.addVertex('A'); // 0
		graph2.addVertex('B'); // 1
		graph2.addVertex('C'); // 2
		graph2.addVertex('D'); // 3
		graph2.addVertex('E'); // 4
		graph2.addVertex('F'); // 5
		graph2.addVertex('G'); // 6
		graph2.addVertex('H'); // 7
		graph2.addVertex('I'); // 8
		
		/*
		 * Graph with I as a lone node
		 */
		theGraph.addEdge(0, 1);
		theGraph.addEdge(0, 2);
		theGraph.addEdge(1, 4);
		theGraph.addEdge(1, 5);
		theGraph.addEdge(2, 3);
		theGraph.addEdge(2, 6);
		theGraph.addEdge(3, 6);
		theGraph.addEdge(4, 7);
		theGraph.addEdge(5, 6);
		theGraph.addEdge(5, 7);
		theGraph.addEdge(6, 7);
		theGraph.addEdge(7, 8);

		System.out.print("Visits:");
		theGraph.bfs();
		System.out.println();
		
		/*
		 * Circular graph
		 */
		graph2.addEdge(0, 1);
		graph2.addEdge(0, 2);
		graph2.addEdge(0, 4);
		graph2.addEdge(1, 3);
		graph2.addEdge(2, 5);
		graph2.addEdge(3, 4);
		graph2.addEdge(4, 5);
		graph2.addEdge(3, 6);
		graph2.addEdge(5, 8);
		graph2.addEdge(6, 7);
		graph2.addEdge(7, 8);
		graph2.addEdge(4, 7);

		System.out.print("Visits 2:");
		graph2.bfs();
		System.out.println();
		
	}
}
