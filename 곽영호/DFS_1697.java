import java.io.*;
import java.io.IOException;

/**
 * Created by yhk on 16. 12. 16..
 * url:https://www.acmicpc.net/problem/1697
 */
public class DFS_1697 {
    static int N, K;
    static Integer[] isCount = new Integer[10000];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        Point point = new Point(N, 0);
        dfs(point);
        System.out.println(isCount[K]);
    }


    public static void  dfs(Point point){

        if(isCount[point.getValue()] == null || isCount[point.getValue()]  > point.getCount()) {
            isCount[point.getValue()] = point.getCount();
        }else{
            return;
        }

        if (point.getValue()*2 <= K+1) {
            dfs(new Point(point.getValue()*2, point.getCount() + 1));
        }

        if (point.getValue()+1 <= K+1) {
            dfs(new Point(point.getValue() + 1, point.getCount() + 1));
        }

        if (point.getValue()-1 >= 0) {
            dfs(new Point(point.getValue() - 1, point.getCount() + 1));
        }

    }


    private static class Point{
        int value;
        int count;
        public Point(int value,int count){
            this.value = value;
            this.count = count;
        }
        public int getValue() {
            return value;
        }
        public void setValue(int value) {
            this.value = value;
        }
        public int getCount() {
            return count;
        }
        public void setCount(int count) {
            this.count = count;
        }
    }
}
