import java.util.Scanner;

/**
 *
 * 9663 / N-Queen
 *
 * https://www.acmicpc.net/problem/9663
 *
 * http://comganet.github.io/dfs/2016/06/03/dfs-1000
 *
 */
public class DFS_9663
{
	static int result;	//퀸개수
	static int N;		//입력값 N
	
	static int check1[] = new int [14];		//열체크
	static int check2[] = new int [14*2];	//우측 상단 체크
	static int check3[] = new int [14*2];	//좌측 상단 체크 
	
	static void DFS(int n)
	{
		if (n >= N)
		{
			result++;
			return;
		}
		
		for (int i = 0; i < N; i++) 
		{
			//열과 우측상단, 좌측상단에 퀸이존재한다면 다음 열로 진행  
			if (check1[i] == 1)
			{
				continue;
			}
			if (check2[n+i] == 1) 
			{
				continue;
			}
			if (check3[N-1-(n-i)] == 1) 
			{
				continue;
			}
			
			//체크결과 겹치는 퀸이없다면 해당 위치에 퀸을 세워줌 // 1로   
			check1[i] = 1;
			check2[n+i] = 1;
			check3[N-1-(n-i)] = 1;
			
			//다음행으로 재귀    
			DFS(n+1);
			
			//재귀 호출에서 끝까지 진행못하고 중간에 빠져나오게되면 세웠던 퀸을 없앰 // 0 로  
			//원상복구한뒤에 다음 열로 진행
			check1[i] = 0;
			check2[n+i] = 0;
			check3[N-1-(n-i)] = 0;
		}
	}

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		DFS(0);
		System.out.println(result);
		sc.close();
	}
}
