import java.util.*;
public class Question {
	/* Back Tracking
	static void printSolution(int board[][], int N){
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
    System.out.println();
    }
	static boolean safe(int board[][], int row, int col, int N){
		int i, j;
        for (i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;
        for (i=row, j=col; i>=0 && j>=0; i--, j--)
            if (board[i][j] == 1)
                return false;
        for (i=row, j=col; j>=0 && i<N; i++, j--)
            if (board[i][j] == 1)
                return false;
        return true;
	}
	static boolean solve(int board[][], int col, int n){
		if(col == n){
			printSolution(board, n);
			return true;
		}
		for(int i=0;i<n;i++){
			if(safe(board,i,col,n)){
				board[i][col] = 1;
				solve(board,col+1,n);
				board[i][col] = 0;
			}
		}
		return false;
	}
	*/
	/*
	 * https://en.wikipedia.org/wiki/Eight_queens_puzzle
	 * An alternative to exhaustive search is an 'iterative repair' algorithm, 
	 * which typically starts with all queens on the board, 
     * for example with one queen per column.[11] 
     * It then counts the number of conflicts (attacks), 
     * and uses a heuristic to determine how to improve the placement of the queens. 
     * The 'minimum-conflicts' heuristic 
	 * conflict(new−pos1)!=conflict(old−pos2)
	*/
	static void printSolution(int arr[],int N){
		System.out.println(Arrays.toString(arr));
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				if(j==arr[i])
					System.out.printf(" 1 ");	
				else
					System.out.printf(" 0 ");	
			}
			System.out.println();
		}
	System.out.println();
	}
	static boolean safe(int arr[],int col,int i){
		//System.out.printf("col %d, i %d\n",col,i);
		for(int j=0;j<col;j++){
			if(arr[j] == i || Math.abs(arr[j] -i) == Math.abs(col-j))
				return false;
		}
		return true;
	}
	static void printArray(int arr[],int n){
		for(int i=0;i<n;i++){
			System.out.printf("%d ",arr[i]);
		}
		System.out.println();
	}
	static void solve(int arr[], int col, int n) {
		for(int i=0;i<n;i++){
			if(safe(arr,col,i)){
				arr[col] = i;
				if(col == n-1){
					printSolution(arr,n);
				}else{
					solve(arr,col+1,n);
				}
			}
		}
	}
	public static void main(String ... args){
		System.out.println("Enter Size of Board");
		Scanner in = new Scanner(System.in);
		int n;
		n = in.nextInt();
		int arr[] = new int[n];
		solve(arr,0,n);
	}
}
