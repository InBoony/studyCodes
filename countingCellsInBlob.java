public class countingCellsInBlob {
	private static int N = 8;
	private static int [][] cells = {
			{1, 0, 0, 0, 0, 0, 0, 1},
			{0, 1, 1, 0, 0, 1, 0, 0},
			{1, 1, 0, 0, 1, 0, 1, 0},
			{0, 0, 0, 0, 0, 1, 0, 0},
			{0, 1, 0, 1, 0, 1, 0, 0},
			{0, 1, 0, 1, 0, 1, 0, 0},
			{1, 0, 0, 0, 1, 0, 0, 1},
			{0, 1, 1, 0, 0, 1, 1, 1}
	};
	
	public static void main(String[] args) {
		printCells();
		
		int x = 5;
		int y = 3;
		
		System.out.printf("blob count with cells[%d][%d] is %d\n", x, y, countingBlob(x, y));
		
		printCells();
	}
	
	private static int countingBlob(int x, int y) {
		int count = 0;
		
		if(x<0 || y<0 || x>=N || y>=N) {
			return 0;
		}
		else if(cells[x][y] != 1) {
			return 0;
		}
		else {
			// 현재 셀에 지나갔다는 표시를 한 후 count를 1 증가시켜줌(현재 셀은 포함)
			cells[x][y] = 2;
			count = 1;
			
			// 8방향 체크를 위한 반복문. 각 셀에서 8방향을 탐색하여 구한 count값을 더한다.
			for(int i=-1 ; i<=1 ; i++) {
				for(int j=-1 ; j<=1 ; j++) {
					count += countingBlob(x+i, y+j);
				}
			}
		}
		return count;
	}
	
	private static void printCells() {
		for(int i=0 ; i<N ; i++) {
			for(int j=0 ; j<N ; j++) {
				System.out.print(cells[i][j] + " ");
			}
			System.out.println("");
		}
		
		System.out.println("\n");
	}
}
