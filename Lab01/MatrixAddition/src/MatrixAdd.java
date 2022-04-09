import java.util.Scanner;
public class MatrixAdd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m, n;
		m = sc.nextInt();
		n = sc.nextInt();
		int[][] matrix1 = new int[m][n];
		int[][] matrix2 = new int[m][n];
		int[][] sumMatrix = new int[m][n];
		for(int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				matrix1[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				matrix2[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
				System.out.print(sumMatrix[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
