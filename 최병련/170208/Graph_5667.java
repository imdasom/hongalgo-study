import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * 결혼식 / 5567
 * https://www.acmicpc.net/problem/5567
 * http://yukari-ko.blogspot.kr/2014/07/5567.html
 */
public class Graph_5667
{
    private static int FRIEND[][] = new int[501][501];
    private static int LIST[] = new int[501];
    private static int N,M,S;

    public static void main(String[] args)
    {
        System.out.println("Hello 5667");

        try
        {
            BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
            N = Integer.parseInt(buf.readLine());
            M = Integer.parseInt(buf.readLine());
            for (int i = 0; i < M; i++)
            {
                String[] array = buf.readLine().split(" ");
                FRIEND[Integer.parseInt(array[0])][Integer.parseInt(array[1])] = 1;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        for(int i=2;i<=N;i++)
        {
            if (FRIEND[1][i] == 1 || FRIEND[i][1] == 1)
            {
                for (int j = 1; j <= N; j++)
                {
                    if (FRIEND[i][j] == 1 || FRIEND[j][i] == 1)
                        LIST[i] = LIST[j] = 1;
                }
            }
        }

        for(int i=2;i<=N;i++)
        {
            S+=LIST[i];
        }
        System.out.println(S);
    }
}
