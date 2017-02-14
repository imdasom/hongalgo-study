import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * https://www.acmicpc.net/problem/11404
 * https://ko.wikipedia.org/wiki/%EA%B7%B8%EB%9E%98%ED%94%84_%EC%9D%B4%EB%A1%A0_%EC%9A%A9%EC%96%B4%EC%82%AC%EC%A0%84
 * http://m.blog.naver.com/kks227/220797649276
 */
public class GRAPH_11404
{
    private static int N;
    private static int M;
    private static int[][] AB;

    public static void main(String[] args) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        M = Integer.parseInt(bufferedReader.readLine());

        AB = new int[M][M];

        for (int i=0; i<N; i++)
        {
            for (int j=0; j<N; j++)
            {

                AB[i][j] = i == j ? 0 : 100001;
                //AB[i][j] = i == j ? 0 : Integer.MIN_VALUE;
            }
        }

        for (int i = 0; i < M; i++)
        {
            String[] split = bufferedReader.readLine().split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[1]);
            int c = Integer.parseInt(split[2]);

            AB[a-1][b-1] = Math.min(AB[a-1][b-1], c);
        }

        int index = 0;
        for (int k = 0; k < N; k++)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    AB[i][j] = Math.min(AB[i][j], AB[i][k] + AB[k][j]);
                }
            }

        }

        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (AB[i][j] == 100001)
                {
                    System.out.print(0 + " ");
                }
                else
                {
                    System.out.print(AB[i][j] + " ");
                }

            }
            System.out.println("");
        }
    }
}

