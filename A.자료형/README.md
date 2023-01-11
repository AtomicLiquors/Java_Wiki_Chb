# 데이터 타입

참고 : 자바의 정석

### 자료형의 정의

우리가 주로 사용하는 데이터의 종류는 크게 문자와 숫자로 나눌 수 있다.
숫자는 다시 정수와 실수로 나눌 수 있다.

자료형(data type)은 이와 같은
**데이터의 종류(type)에 따라 데이터가 저장될 공간의 크기와 저장형식을 정의한 것**이다.

&nbsp;  
### 자료형의 구분
  
#### 기본형 *Primitive type* 
 - 실제 데이터를 저장한다.
 - 8가지 종류가 해당한다. 
    - 논리형 : boolean
    - 문자형 : char 
    - 실수형 : byte, short, int, long, 
    - float, double. 
    &nbsp;  
#### 참조형 *Reference Type*
  - 어떤 데이터가 저장된 주소를 값으로 갖는다.
  - Java에서는 위 기본형 8가지를 제외한 나머지가 참조형에 해당한다.
  - Java에서는 위 기본형 8가지를 제외한 나머지가 모두 참조형에 해당한다.

  *c.f.)* 사용자 정의 타입 *User-Defined Type*  
  프로그래머가 직접, 연관된 변수를 묶어 하나의 타입으로 추가하는 것.  
  객체지향 언어의 클래스가 사용자 정의 타입이다.  
  

&nbsp;  

[!] Java는 C언어와 달리 **참조형 변수 간의 연산을 할 수 없다.** 
실제 연산에 사용되는 것은 모두 기본형 변수다.


&nbsp;  
### 참조형 변수 선언

참조형 변수를 선언할 때는, **특정 클래스를 타입으로** 지정한다.
새로운 클래스를 작성한다는 것은 새로운 참조형을 추가하는 셈이다.

```jsx
Date today = new Date(); //Date 객체를 생성하여, 그 주소를 today에 저장한다.
```



&nbsp;  
Q. 자료형과 타입의 차이가 뭔가요?
&nbsp;  

A. 사실 타입이 자료형보다 넓은 의미기 때문에 굳이 구분하지 않아도 됩니다.
기본형 변수의 종류를 얘기할 때는 자료형이란 용어를 씁니다.
참조형 변수의 종류를 구분할 때는 타입이란 용어를 씁니다.
참조형은 항상 객체의 주소를 저장하지, 데이터를 저장하는 것이 아니기 때문입니다.




&nbsp;  
&nbsp;  


Q. '.'을 붙여서 계속해서 객체 참조를 한다.
오버헤드가 있을까? 없을까?
&nbsp;  

A.
있다.
참조값을 다시 실제 주소로 바꾸는 과정이 늘어나니까.
그렇기 때문에 설계는 결합도를 낮추고, 응집도를 높여야 한다.

&nbsp;  

Q. Person p = new Person(); 을 작성하고 System.out.println(p);를 했다.  
끝에 웬 16자리 코드가 찍혀서 나온다.
그럼 이게 객체의 주소인가?

A. 해시코드잖아.  
정확히는 클래스 이름에 해시코드가 결합한 것.  
서로 다른 객체라도 같은 해시코드가 나올 수 있다.  
진짜 주소라면 서로 다른 객체일 때 다른 값이 나와야지.


&nbsp;  
&nbsp;  


### Q. 다음 두 가지 경우 출력 결과는 각각 어떻게 될까?
```java
int i = 10; 
int j = i;
j = j + 1;

// i와 j의 값은?
```


```java

class Person {
	
	public Person(String name) {
		this.name = name;
	}
	
	String name;
}


public class HelloTest {

	public static void main(String[] args) {
		Person p = new Person("김태희");
		Person p2 = p;
		p2.name = "정지훈";
		
		System.out.println(p.name);
		System.out.println(p2.name);
	
	}
}

```

&nbsp;  

```
i = 10, j = 11
```

```
p : 정지훈, p2 : 정지훈
```



&nbsp;  

