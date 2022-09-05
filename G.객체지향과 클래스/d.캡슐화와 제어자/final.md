#### final은 세 가지 용도로 쓰인다.
###### 1. 클래스 : 하위 클래스를 가질 수 없는 클래스
(상속하지 말라. 만들어 준 그대로 사용하라.)
(우리가 직접 만들 일은 잘 없다.)

###### 2. 필드 : 상수(일반적으로 static과 같이 사용)
수정불가, 새 값을 대입할 수 없다.

###### 3. 메소드 : 오버라이딩 불가
(오버라이딩 : 상속 관계에서 부모가 선언한 메소드를 자식 클래스에서 재정의하는 것.) 


``` 
package ch04;


class Final1{
	void prn1() {}
	final void prn2() {}
}

class Final2{
	void prn1() {}
	final void prn2() {}
}


public class FinalEx {
	
	final static int SAMSUNG = 10;
	
	public static void main(String[] args) {
		SAMSUNG = 20;
		//SAMSUNG은 static과 같이 사용되어 상수로 지정되었다. 여기에 새 값을 넣으면 오류가 뜬다.
	}
}
```
