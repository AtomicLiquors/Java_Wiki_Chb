    
- 예외처리
    
    예외: 문법적으로는 오류가 없지만 콘솔에서는 Exception으로 뜬다.
    자바는 예외들도 따로 클래스로 만들어놨다.


### 기본
```java
public class ExceptionEx1 {

	public static void main(String[] args) {
		try {
            //예외 발생 가능성이 있는 코드를 넣는다.
			int a = 22;
			int b = 0;
			System.out.println("a + b = " + (a + b));
			System.out.println("a - b = " + (a - b));
			System.out.println("a * b = " + (a * b));
			System.out.println("a / b = " + (a / b));
			System.out.println("계산 완료!");
            //예외가 발생하면, 다음 구문은 실행되지 않는다.
		} catch (Exception e) {
            //예외가 일어나면 실행되는 영역. 
            //e는 발생하는 예외 객체를 가리킨다.

			//System.out.println("예외 메시지 : " + e.getMessage());
			System.err.println("예외 메시지 : " + e.getMessage());
			//System.out을 안 쓰고 System.err를 쓴 점에 주목해 달라.
            //err를 쓴 경우, 다른 에러 메시지처럼 콘솔에서 빨간색으로 출력된다.

            e.printStackTrace(); 
			//예외가 일어나면 추적(history)내용까지 출력. 디버깅할 때 많이 쓴다.
		}
		try{
			System.out.println("try 실행");
		} finally {//try-catch-finally
			//예외가 있든 없든 무조건 실행하는 구문이다.
			System.out.println("finally 실행");
		}
		
	}

}

```


### Throws
```java
package ch03_1;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ExceptionEx6 {

	public static void main(String[] args) {
		try {
			FileReader fr = myRead("test.txt");
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

	// thorws는 "여기서 일어나는 예외는 나를 호출한 곳에 던지겠다"라는 의미.
	// 최종적으로 사용하는 곳에서 예외처리를 한다.
	//잘 이해가 안되니까 나중에 책 보자.
	public static FileReader myRead(String name) 
			throws FileNotFoundException {
		FileReader fr = new FileReader(name);
		return fr;
	}
}
```

- 파일 읽기 관련 예외처리는 위의 Throws 예시와 ExceptionEx4.java 참조.