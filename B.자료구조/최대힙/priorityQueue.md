
https://girawhale.tistory.com/24

# PriorityQueue

```
PriorityQueue는 add와 poll 모두 O(log n)으로 
O(nlogn)만에 문제를 해결할 수 있다.

PriorityQueue는 기본적으로 오름차순 정렬이기 때문에, Collections.reverseOrder()를 활용해 내림차순으로 변경해준다. 
출력을 할 때, queue의 size = 0이라면 배열이 비어있는 경우이므로, 
0을 출력해준다. 
```


```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num == 0)
                sb.append(que.size() == 0 ? 0 : que.poll()).append('\n');
            else que.add(num);
        }
        System.out.println(sb.toString());
    }
}
```