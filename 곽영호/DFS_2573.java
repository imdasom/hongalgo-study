import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by yhk on 16. 12. 20..
 * url:https://www.acmicpc.net/problem/2573
 *
 */
public class DFS_2573 {
    static int N;
    static int M;
    static int[][] baseArr;
    static int[][] visitArr;
    static int[][] minusArr;

    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);

		if(N < 3 || M > 300){
			return;
		}

		baseArr = new int[N][M];
		visitArr = new int[N][M];
		minusArr = new int[N][M];

		for(int i = 0 ; i < N ; i++){
			String[] input_arr = br.readLine().split(" ");
			for(int j = 0 ; j < M ; j++) {
				baseArr[i][j] = Integer.parseInt(input_arr[j]);
			}
		}

		dfs();

	    }

	    public static void dfs() {
	        int year = 0;
	        while (true) {
	        	year++;
	        	visitArr = new int[N][M];
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < M; j++) {
	                    if (baseArr[i][j] != 0) {
	                        if (baseArr[i][j] - minus(i, j) > 0) {
	                            minusArr[i][j] = baseArr[i][j] - minus(i, j);
	                        } else {
	                            minusArr[i][j] = 0;
	                        }
	                    }
	                }
	            }

	         
	            int cnt = 0;
	            for (int i = 0; i < N; i++) {
	                for (int j = 0; j < M; j++) {
	                	if(minusArr[i][j] != 0 && visitArr[i][j] == 0){ 
	                		count(i, j);
	                		cnt++;
	                	}
	                }
					if(cnt > 1){
						break;
					}
	            }
	            
	            if(cnt > 1){
	            	System.out.print(year);
	            	break;
	            }else if(cnt == 0){
					System.out.print(cnt);
					break;
				}
	            
	            baseArr = minusArr;
	        }
	    }

	    public static void count(int x, int y) {

	        if (x > N-1 || y > M-1) return ;

	        if (x + 1 < N && minusArr[x + 1][y] > 0 && visitArr[x + 1][y] == 0) {
	            visitArr[x + 1][y] = 1;
	            count(x + 1, y);
	        }
	        if (x - 1 >= 0 && minusArr[x - 1][y] > 0 && visitArr[x - 1][y] == 0) {
	            visitArr[x - 1][y] = 1;
	            count(x - 1, y);
	        }
	        if (y + 1 < M && minusArr[x][y + 1] > 0 && visitArr[x][y + 1] == 0) {
	            visitArr[x][y + 1] = 1;
	            count(x, y + 1);
	        }
	        if (y - 1 >= 0 && minusArr[x][y - 1] > 0 && visitArr[x][y - 1] == 0) {
	            visitArr[x][y - 1] = 1;
	            count(x, y - 1);
	        }
	    }

	    public static int minus(int x, int y) {
	        int cnt = 0;
	        if (x + 1 < N && baseArr[x + 1][y] == 0) {
	            cnt++;
	        }

	        if (x - 1 >= 0 && baseArr[x - 1][y] == 0) {
	            cnt++;
	        }

	        if (y + 1 < M && baseArr[x][y + 1] == 0) {
	            cnt++;
	        }

	        if (y - 1 >= 0 && baseArr[x][y - 1] == 0) {
	            cnt++;
	        }
	        return cnt;
	    }
}
