//수빈이는 동생과 숨바꼭질을 하고 있다.
//수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고,
//동생은 점 K(0 ≤ K ≤ 100,000)에 있다.
//수빈이는 걷거나 순간이동을 할 수 있다.
//수빈이의 위치가 X일 때
// 1. 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다.
// 2. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.

//수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.

//입력
//첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.

//출력
//수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.

//입력 5 17
//출력 4

package 숨바꼭질;

import java.io.*;
import java.util.*;

public class Main {

    static int N,K;
    static int[] visit = new int[100001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine()," ");
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());

        if(N==K) {
            System.out.println(0);
        }else {
            bfs(N);
        }

        br.close();
    }// main()

    static void bfs(int num) {

        Queue<Integer> qu = new LinkedList<>();
        qu.add(num);
        visit[num]=1;

        while(!qu.isEmpty()) {
            int tmp=qu.poll();
            for(int i=0;i<3;i++) {
                int next;
                if(i==0) {
                    next=tmp+1;
                }else if(i==1) {
                    next=tmp-1;
                }else {
                    next=tmp*2;
                }

                if(next==K) {
                    System.out.println(visit[tmp]);
                    return;
                }

                if (next >= 0 && next < visit.length && visit[next] == 0) {
                    qu.add(next);
                    visit[next] = visit[tmp] + 1;
                }
            }
        }
    }

}
