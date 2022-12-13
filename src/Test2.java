import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Test2 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String,Integer> func = Integer::parseInt;

        int T = func.apply(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = func.apply(br.readLine());
             List<Integer> list = new ArrayList<>();

            String tmp[] = br.readLine().split(" ");
            Arrays.stream(tmp).forEach(a -> list.add(func.apply(a)));

            //연속적인 부분 수열 중 최대?
            // 단 그 중 하나만 제외 가능 !!!
            int result = 0;
            for (int i = 0; i < N; i++) { // 각 선수마다 최대인 경우 찾아야 됨
                int max = 0;
                int dp[] = new int[N+1];
                dp[0] = list.get(i);
                for (int j = 0; j < N; j++) {
                    if(i == j) {
                        dp[j+1] = dp[j];
                        continue;
                    }
                    dp[j+1] = Math.max(dp[j], dp[j] + list.get(j));

                }
//                Arrays.stream(dp).forEach(System.out::println);
                System.out.println(dp[dp.length-1]);
                result += Math.abs(dp[dp.length-1]);
            }
            System.out.println("#" + (tc + 1) + " " + result %  1000000007);
        }
    }

}
