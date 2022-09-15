# LinkedList

Collection 프레임워크의 일부이며 java.util 패키지에 소속되어 있다.

LinkedList는 데이터부분과 주소부분으로 나뉘어져,   
각 노드가 선으로 포인터와 주소를 사용하여 연결된 형태로 이어져 있다.

&nbsp;  
### ArrayList보다 유리할 때 :
**배열에서 자주 삽입, 삭제가 이루어지는 경우** 

### ArrayList보다 불리할 때 : 
**검색**

&nbsp;  

### 유형 :
**Singly LinkedList**
![https://blog.kakaocdn.net/dn/bygm8v/btq5lxMb2f7/UookpU9dnl1uKNZs6i4Bu0/img.png](https://blog.kakaocdn.net/dn/bygm8v/btq5lxMb2f7/UookpU9dnl1uKNZs6i4Bu0/img.png)

&nbsp;  
**Doubly LinkedList**
![https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/17/screen-shot-2018-04-17-at-161130.png](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/17/screen-shot-2018-04-17-at-161130.png)



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

## 원리
___

### 삽입 : O(1)속도로 삽입하기
1. 새로운 노드를 선언한다.
2. 추가할 노드의 "next"field를 다음 노드로 지정한다.
3. 이전 노드의 "next" 속성을 추가할 노드로 지정한다.

&nbsp;  
모든 원소를 일일이 뒤로 옮겨줘야 했던 배열 삽입과 달리,   
${O(1)}만에 새 노드를 삽입해 줄 수 있다.


&nbsp;  

### 삭제 : O(1)속도로 삭제하기
&nbsp;  
**일반적인 노드**
1. 삭제할 노드의 이전 노드와 다음 노드를 연결시킨다.

&nbsp;  
**첫 번째 노드**
1. 두 번째 노드를 "헤드"로 취급한다.

&nbsp;  
**마지막 노드**
1. 두 번째 노드를 "헤드"로 취급한다.