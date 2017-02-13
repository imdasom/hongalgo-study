import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class B11404 {
	static int N;
	static int M;
	static int[][] valueList;
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		valueList = new int[N][N];
		
		
		for(int i=0; i<M;i++){
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			int row = Integer.parseInt(st.nextToken()) - 1;
			int column = Integer.parseInt(st.nextToken()) - 1;
			int value = Integer.parseInt(st.nextToken());
			// 0이 아닐 때(비용 값이 존재할 때)
			if(valueList[row][column] != 0){
				// 비용이 더 들 경우 교체
				if(valueList[row][column] > value){
					valueList[row][column] = value;
				}
			}else{
				//비용값이 존재하지 않으므로 비용 값 입력
				valueList[row][column] = value;
			}
		}
		br.close();
		
		for(int i=0; i<N;i++){
			for(int j=0;j<N;j++){
				findOptimalRoute(i,j);
			}
			System.out.println();
		}
	}
	
	
	static void findOptimalRoute(int first, int last){
		Stack<Route> routeStack = new Stack<Route>();
		int optimalValue = 0;
		boolean hasLast = false;
		if(first!=last){
			for(int i=0; i<N; i++){
				if(isValid(first, i)){
					if(i != last && i!=first){
						routeStack.push(new Route(i, valueList[first][i]));
					}else{
						if(i == last){
							optimalValue = valueList[first][i];
							hasLast = true;
						}					
					}
				}
			}
		}
		while(!routeStack.isEmpty()){
			Route route = routeStack.pop();
			if(isValid(route.routeIndex,last)){
				if(isOptimal(route, optimalValue, last)){
					optimalValue = route.accumValue + valueList[route.routeIndex][last];
					hasLast = true;
				}
			}
			if(route.routeIndex != last){
				for(int i=0; i<N;i++){
					if(i != first && i != route.routeIndex){
						if(!route.wentList.contains(i))
							if(isValid(route.routeIndex, i))
								routeStack.push(new Route(route, i, route.accumValue+ valueList[route.routeIndex][i]));
					}
				}
			}
		}
		if(hasLast){
			System.out.print(optimalValue +" ");
		}else{
			System.out.print(0 + " ");
		}		
	}
	
	static boolean isValid(int first, int last){
		if(valueList[first][last] != 0){
			return true;
		}
		return false;
	}
	
	static boolean isOptimal(Route route, int optimal, int last){
		if(optimal == 0){
			return true;
		}else{
			if(optimal > route.accumValue + valueList[route.routeIndex][last]){
				return true;
			}
		}
		return false;
	}
}

class Route{
	int routeIndex;
	int accumValue;
	List<Integer> wentList;
	
	Route(Route ExistRoute, int routeIndex, int accumValue){
		wentList = ExistRoute.wentList;
		wentList.add(routeIndex);
		this.routeIndex = routeIndex;
		this.accumValue = accumValue;
	}
	
	Route(int routeIndex, int accumValue){
		wentList = new ArrayList<Integer>();
		wentList.add(routeIndex);
		this.routeIndex = routeIndex;
		this.accumValue = accumValue;
	}
}