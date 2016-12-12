package BreathFirshSearch;

import java.util.*;

/**
 * Created by yhk on 16. 12. 10..
 * url:https://www.acmicpc.net/problem/1325
 */
public class BFS_1325 {
	static Queue<Integer> q= new LinkedList<Integer>();
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
    	String[] f_input = scan.nextLine().split(" ");
        int N = Integer.parseInt(f_input[0]);
        int M = Integer.parseInt(f_input[1]);
        Map<Integer, ArrayList<Integer>> connectMap = new HashMap<Integer, ArrayList<Integer>>();
        for(int i = 0 ; i < M ; i++){
        	 String[] c_input = scan.nextLine().split(" ");
        	 int value = Integer.parseInt(c_input[0]);
             int key = Integer.parseInt(c_input[1]);
        	 if(connectMap.get(key) == null){
            	 ArrayList<Integer> values = new ArrayList<Integer>();
            	 values.add(value);
            	 connectMap.put(key, values);
             }else{
            	 connectMap.get(key).add(value);
             }
        }
        bfs(connectMap, N);
    }

    static void bfs(Map<Integer, ArrayList<Integer>> connectMap, int N){
        int max = 0;
        int size = 0;
        int[] save = new int[N];
        for(int i = 1 ; i <= N ; i++){
            int count = 0;
            int[] visit = new int[N+1];
            visit[i] = 1;
            q.add(i);
            count++;
            while(!q.isEmpty()){
            	int f = q.poll();
	            if(connectMap.get(f) != null){
	                for(int j = 0 ; j < connectMap.get(f).size() ; j++) {
	                	int temp = connectMap.get(f).get(j);
	                    if (visit[temp] == 0) {
	                    	visit[temp] = 1;
	                        q.add(temp);
	                        count++;
	                    }
	                }
	            }
            }
            
            if (max < count)
            {
                size = 0;
                max = count;
                save[size++] = i;
            }
            else if (max == count)
            {
                save[size++] = i;
            }
        }
        
        for (int i = 0; i < size; i++)
            System.out.printf("%d ", save[i]);
    }
}
