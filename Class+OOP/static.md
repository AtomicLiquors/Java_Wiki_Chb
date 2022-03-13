정적 필드, 정적 메소드.  
필드나 메소드를, 인스턴스를 생성하지 않고 사용할 수 있다.  

메소드를 선언할 때, 인스턴스 필드를 이용하지 않는다면 정적 메소드로 선언하는 것이 좋다.


아래에서 정적 변수, 정적 메소드를 선언한 뒤
인스턴스 b1, b2를 생성하여 접근했더니 노란 줄이 뜬다.

```
package ch04;

class StaticSample {
	int n;
	void g() {	}
	static int m;
	static void f() {	}
}

public class StaticEx {
	public static void main(String[] args) {
		StaticSample b1 = new StaticSample();
		StaticSample b2 = new StaticSample();
		StaticSample b3 = new StaticSample();
		
		b1.m = 3; //여기와
		b2.f(); //여기에 노란 줄이 뜬다.
		
	}
}

```

