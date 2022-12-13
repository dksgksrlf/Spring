import java.util.Scanner;
class Test1 {
	static int AnswerN;
	static int N = 10;

	public static void main(String args[]) throws Exception {
		//System.setIn(new FileInputStream("C:\sample_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int[] runner=new int[N];
			int[] team=new int[N];
			AnswerN=0;
			for(int i=0;i<N;i++){
			    runner[i]=sc.nextInt();
			}
			for(int i=0;i<N;i++){
				int maxSum=-999999999; //경우의수 중 가능한 최대점수
				int rightIndex=-1;
				//int leftIndex=-1;
				int pre=0;			//이전 최소점수
				int sum=0;// 팀 전체 합
				int min=0; //팀원중 최소점수
				int minIndex=-1; //최소점수를 가진 선수의 인덱스
				//i~t
				for(int j=i;j<N;j++) {
					if(j!=i&&min>runner[j]) {//i가 아니고 현재 최소점수보다 작으면
						pre=min;
						min=runner[j];
						minIndex=j;
						sum+=runner[j];
						
						continue; //아직 최소 점수가 맨끝이므로 최대점수 계산을 하지 않는다
					}else {
						
						sum+=runner[j];
					}
					
					if(maxSum<sum-min) { //최대 점수계산 min은 처음엔 0이고 이후엔 음수이므로 -하여 팀전체 합에서 최소점수를 뺀값
						maxSum=sum-min;
						rightIndex=j;
					}
				}//최소값이 맨끝일경우 이전최솟값으로 변경 ex) -1 2 -3 2 -1
				if(minIndex>=rightIndex) {
					sum-=min;
					min=pre;
					minIndex=-1;
				}
				//s~i-1
				for(int j=i-1;j>=0;j--) {
					if(min>runner[j]) {
						min=runner[j];
						minIndex=j;
						sum+=runner[j];
						
						continue;
					}else {
						
						sum+=runner[j];
					}
					
					if(maxSum<sum-min) {
						maxSum=sum-min;
						//leftIndex=j;
					}
				}
				team[i]=maxSum;
				if(team[i]<0) {
					team[i]*=-1;
				}
				
				
			}
			for(int i=0;i<N;i++) {
				AnswerN+=team[i];
			}
			AnswerN%=1000000007;
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}
}
