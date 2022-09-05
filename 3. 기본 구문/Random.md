로또 번호 예제

```java
package ch03;

import java.util.Random;

public class Lotto {
	public static void main(String[] args) {
		// 1에서 45 사이의 난수 6개를 추첨합니다.
		int lotto[] = new int[6];
		Random r = new Random();

		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = r.nextInt(6)+1;
			
			for(int j = 0; j < i; j++) {
				if(lotto[i] == lotto[j]) {
					i--; //초기화.
					break;
				}
			}
			
		}//배열 생성하는 for 종료
		
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i] + "\t");
		}
		
	}
}

/*
 * 
 * 
 * 
 * 
 * if (temp == lotto[i]) { break; } //새 수를 뽑을 때마다, 배열 항목을 전부 조회해 중복을 점검한다. //중복을
 * 찾은 경우, false를 반환하고 반복문을 나간다. //중복이 없는 경우, true를 반환하고 반복문을 나간다. } } //
 * 
 * 
 * 
 * Arrays.sort(lotto); for (int j = 0; j < lotto.length; j++) {
 * System.out.print(lotto[i]+"\t"); }
 */
```