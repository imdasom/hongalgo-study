import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DFS_2668 {
	static int[] intArr = new int[101];
    static int[] visitArr = new int[101];
    static int n;
    public static void main(String[] args) throws  IOException{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	n = Integer.parseInt(br.readLine());
		for(int i=1;i<=n;i++) intArr[i] = Integer.parseInt(br.readLine());
    	for(int i=1 ; i <= n; i++){
    		for(int j=1;j<=n;j++){
				if(visitArr[j]==1) visitArr[j]=0;
			}
    		isCircular(i,intArr[i],0);
    	}
    	int ans = 0;
    	String input = "";
    	for(int i=1;i<=n;i++){
    		if(visitArr[i]==2){ 
    			ans++;
    			input += i+"\n";
    		}
    	}
    	System.out.println(ans);
    	System.out.print(input);
    	br.close();
    }
    
    public static int isCircular(int start, int cur, int count){
    	if(visitArr[cur] == 1 || visitArr[cur] == 2) return 0;
    	visitArr[cur] = 1;
    	if(start == cur) {
    		for(int i=1;i<=n;i++){
    			if(visitArr[i] == 1) visitArr[i]=2;
    		}
    		return count+1;
    	}
    	return isCircular(start,intArr[cur],count+1);
    }
}
