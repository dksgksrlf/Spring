import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		System.out.println(T);
		for(int test=0;test<T;test++) {
			int result =0;
			int N1=scan.nextInt();
			int N2=scan.nextInt();
			scan.nextLine();
			
			int[] A = new int[N1*N2];
			String[] dataStr = scan.nextLine().split(" ");
			for(int i=0;i<N1*N2;i++) {
				A[i]=Integer.parseInt(dataStr[i]);
			}
			System.out.println(Arrays.toString(A));
			System.out.println("#"+(test+1)+" "+result);
		}
		scan.close();
	}
}
