import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B11403 {
	private static int[][] adjoinList;
	private static int[][] availableList;
	private static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		adjoinList = new int[N][N];
		availableList = new int[N][N];
		for(int i=0; i<N; i++){
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			for(int j=0; j<N; j++){
				adjoinList[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		br.close();
		
		for(int i=0; i<N;i++){
			bfs(i);
			printLine(i);
		}
	}
	
	private static void printLine(int num){
		for(int i=0; i<N;i++){
			System.out.print(availableList[num][i] + " ");
		}
		System.out.println();
	}
	
	private static void bfs(int num){
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(num);
		while(!q.isEmpty()){
			int polled = q.poll();
			for(int i=0; i<N;i++){
				if(adjoinList[polled][i] == 1 && availableList[num][i]==0){
					availableList[num][i] = 1;
					q.add(i);
				}
			}
		}
	}
}
