import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9372 {
	public static int T,N,M;
	public static int tArray[];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		tArray = new int[T];
		for(int i=0; i<T; i++){
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			for(int j=0; j<M; j++){
				br.readLine();
			}
			tArray[i]=N-1;
		}
		for(int i=0;i<T;i++){
			System.out.println(tArray[i]);
		}
		br.close();
	}
}
