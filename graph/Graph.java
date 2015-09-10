import java.util.*;

public class Graph{
	//number of vertex
	static int N = 8;
	static int[][] G = {
			{1, 1, 1, 0, 0, 0, 0, 0},
			{1, 1, 0, 0, 1, 0, 0, 0},
			{1, 0, 1, 0, 0, 0, 0, 1},
			{0, 0, 0, 1, 0, 0, 0, 0},
			{0, 1, 0, 0, 1, 0, 0, 0},
			{0, 0, 0, 0, 0, 1, 1, 0},
			{0, 0, 0, 0, 0, 1, 1, 0},
			{0, 0, 1, 0, 0, 0, 0, 1}
		};
	static boolean[] visited = new boolean[N];

	public static void main (String[]args){
		System.out.println("BFS: ");
		bfs(G);
		//reset visited
		visited = new boolean[N];
		System.out.println("DFS: ");
		dfs(G);
		
	}

	// transverse graph using bfs
	static void bfs(int[][] G){
		Queue<Integer> q = new LinkedList<Integer>();		
		for (int ver_start = 0; ver_start < N; ver_start ++){
			if (visited[ver_start]) continue;
			q.add(ver_start);
			visited[ver_start] = true;

			while(!q.isEmpty()){
				int vertex = q.remove();
				System.out.print((vertex+1) + " ");
				for (int i=0; i<N; i++){
					if (G[vertex][i] == 1 && !visited[i]){
						// find neigbor of current vertex and not visited
						// add into the queue
						q.add(i);
						visited[i] = true;
					}
				}
			}
			System.out.println("--");			
		}
	}

	//transverse graph using dfs
	static void dfs(int[][] G){
		Stack<Integer> s = new Stack<Integer>();
		for (int ver_start=0; ver_start<N; ver_start++){
			if (visited[ver_start]) continue;
			s.push(ver_start);
			visited[ver_start] = true;

			while(!s.isEmpty()){
				int vertex = s.pop();
				System.out.print((vertex+1) + " ");
				for (int i=0; i<N; i++){
					if (G[vertex][i] == 1 && !visited[i]){
						// find neigbor of current vertex and not visited
						// add into the stack
						s.push(i);
						visited[i] = true;
					}
				}
			}

			System.out.println();
		}
	}
}