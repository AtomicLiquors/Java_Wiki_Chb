[<< 메인으로](https://github.com/AtomicLiquors/Java_Wiki_Chb)

&nbsp;  


# 포함
*Composite*

상속 외에도 클래스를 재사용하는 방법.  
한 클래스의 멤버변수로 다른 클래스 타입의 참조변수를 선언하는 것을 가리킨다. 

```java
class Coordinate{
    int x;
    int y;
}

class Circle{
    Coordinate c = new Coordinate();
    int r;
}
```

&nbsp;
## 포함할 것인가? 상속시킬 것인가?
다음과 같이 말로 표현해보고 판단한다.
```java
 말티즈는 개의 일종이다. [O]  
 말티즈는 개를 갖고 있다. [X]  
 //-> 상속
```

```java
 원은 좌표의 일종이다. [X]  
 원은 좌표를 갖고 있다. [O]  
 //-> 포함
 ```