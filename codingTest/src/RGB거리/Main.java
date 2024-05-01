package RGB거리;
//RGB거리에는 집이 N개 있다. 거리는 선분으로 나타낼 수 있고,
// 1번 집부터 N번 집이 순서대로 있다.

//집은 빨강, 초록, 파랑 중 하나의 색으로 칠해야 한다.
// 각각의 집을 빨강, 초록, 파랑으로 칠하는 비용이 주어졌을 때,
// 아래 규칙을 만족하면서 모든 집을 칠하는 비용의 최솟값을 구해보자.

//1번 집의 색은 2번 집의 색과 같지 않아야 한다.
//N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
//i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.
//첫째 줄에 집의 수 N(2 ≤ N ≤ 1,000)이 주어진다.
//둘째 줄부터 N개의 줄에는 각 집을 빨강, 초록, 파랑으로 칠하는 비용이 1번 집부터 한 줄에 하나씩 주어진다.
//집을 칠하는 비용은 1,000보다 작거나 같은 자연수이다.


// 조건 정리
// 1. N개의 집, 거리는 선분으로 나타냄 -> 선분 (점과 점 사이 이은 선의 길이, 양쪽에 끝나는 점이 있는 직선)
// 2. 1번 집부터 N번 집이 순서대로
// 3. 색상은 RGB중 하나의 색
// 규칙
// 1. 연달아 같은 색상은 올 수 없다. -> 가운데 집 기준 앞뒤로 다른 색상.
// 2. 집의 수 입력 뒤 R G B 칠하는 비용
// 1000보다 작거나 같은 자연수 이며  모든 집을 칠하는 비용의 최솟값 출력.

//입력
// 3
//26 40 83
//49 60 57
//13 89 99

// 출력 96
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int totalHouse = sc.nextInt();
        int rgbHouse[][] = new int[totalHouse][3];
        for(int i = 0; i < totalHouse; i ++){
            for(int j = 0; j < 3; j ++){
                if(i == 0) rgbHouse[i][j] = sc.nextInt();
                else{
                    switch (j) {
                        case 0:
                            rgbHouse[i][j] = sc.nextInt() + Math.min(rgbHouse[i - 1][1], rgbHouse[i - 1][2]);
                            break;
                        case 1:
                            rgbHouse[i][j] = sc.nextInt() + Math.min(rgbHouse[i - 1][0], rgbHouse[i - 1][2]);
                            break;
                        case 2:
                            rgbHouse[i][j] = sc.nextInt() + Math.min(rgbHouse[i - 1][0], rgbHouse[i - 1][1]);
                            break;
                    }
                }
            }
        }
        System.out.println(Math.min(Math.min(rgbHouse[totalHouse-1][0],rgbHouse[totalHouse-1][1]),rgbHouse[totalHouse-1][2]));

    }

}
