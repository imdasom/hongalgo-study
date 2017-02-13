
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

////
////단지번호붙이기(2667)
////https://www.acmicpc.net/problem/2667
////
////참조사이트
////http://webcache.googleusercontent.com/search?q=cache:MI_UYz4pacUJ:codedoc.tistory.com/603+&cd=1&hl=ko&ct=clnk&gl=kr
////

public class Main
{
    private static final int fx[] = {0,0,1,-1};	//상하좌우 x좌표 체크
    private static final int fy[] = {1,-1,0,0};	//상하좌우 y좌표 체크 
    private static int c[][];	// 집의 가로세로 배열 + 2(상하좌우체크 떄문에 배열크기 2추가 )
    private static int a[];		// 각 단지의 집개수 배열 
    private static int cnt = 0;	// 단지 갯수 

    static void dfs(int x, int y)
    {
    	if(c[x][y] <= 0)
            return;
        c[x][y] = 0;
        a[cnt] ++;
        for (int i = 0; i < 4; i++)
        {
            dfs(x + fx[i], y + fy[i]);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException
    {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		c = new int[count+2][count+2];
		a = new int[(count*count)/2+1];
        for (int i = 1; i <= count; i++)
        {
            char[] array = br.readLine().toCharArray();
            for (int j = 1; j <= count; j++)
            {
                c[i][j] = Integer.parseInt(String.valueOf(array[j-1]));
            }
        }
        
        for (int i = 1; i <= count; i++)
        {
            for (int j = 1; j <= count; j++)
            {
                if (c[i][j] > 0)
                {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
        Arrays.sort(a, 0, cnt);
        for (int i = 0; i < cnt; i++)
        {
        	System.out.println(a[i]);
        }
    }
}
