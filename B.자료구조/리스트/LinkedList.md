# LinkedList

Collection 프레임워크의 일부이며 java.util 패키지에 소속되어 있다.

LinkedList는 데이터부분과 주소부분으로 나뉘어져,   
각 노드가 선으로 포인터와 주소를 사용하여 연결된 형태로 이어져 있다.

&nbsp;  

![https://blog.kakaocdn.net/dn/bygm8v/btq5lxMb2f7/UookpU9dnl1uKNZs6i4Bu0/img.png](https://blog.kakaocdn.net/dn/bygm8v/btq5lxMb2f7/UookpU9dnl1uKNZs6i4Bu0/img.png)


&nbsp;  
### ArrayList보다 유리할 때 :
**배열에서 자주 삽입, 삭제가 이루어지는 경우** 

### ArrayList보다 불리할 때 : 
**검색**

&nbsp;  



### LinkedList 선언하기

```java 
LinkedList li = new LinkedList(); 
// 타입 설정 없이 Object로 입력

LinkedList<LinkedListDemo> demo = new LinkedList<LinkedListDemo>(); 
// List타입을 LinkedListDemo

LinkedList<Integer> i = new LinkedList<Integer>(); 
// int 타입으로 선언

LinkedList<Integer> i2 = new LinkedList<>(); 
// 타입 선언 생략도 가능

LinkedList<Integer> i3 = new LinkedList<Integer>(Arrays.asList(1, 2, 3)); 
// 초기 값 세팅
		
LinkedList<String> s = new LinkedList<String>(); 
// String 타입 사용

LinkedList<Character> ch = new LinkedList<Character>(); 
// Char 타입 사용

```

### 값 추가하기

```java
import java.util.LinkedList;

public class LinkedListDemo {
	public static void main(String[] args)  {
		LinkedList<String> ll = new LinkedList<String>();
		
		ll.add("Hello");
		ll.add("Hello");
		ll.add(1, "World");
		
		System.out.print(ll);
	}
}
```
