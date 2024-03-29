[<< 메인으로](https://github.com/AtomicLiquors/Java_Wiki_Chb)

&nbsp;  


# 다형성
*polymorphism*  
여러 가지 형태를 가질 수 있는 성질.  
**1. 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 하였다.**  
**2. 한 가지 메서드로 여러 종류의 매개변수를 사용할 수 있도록 하였다.**
```
상속 개념을 충분히 학습하셨나요?  
Class c = new Class();의 의미를 설명할 수 있나요?
```
```
다형성을 이해해야 추상클래스, 인터페이스를 이해할 수 있습니다.  
반복해서 학습합시다.
다형성의 실제 활용에 대해서는 다루지 않고, 
여기선 개념적인 부분만 짚겠습니다.
```
```
- 구현 방식 Tv t = new SmartTv();
- 업캐스팅, 다운캐스팅 : "참조변수의 형변환"
- instanceof 연산자
이 세 가지만 알고 계시면 되겠습니다.
```

&nbsp;  
&nbsp;  

## Java의 다형성 구현 방식
**1. 한 타입의 참조변수로 여러 타입의 객체를 참조할 수 있도록 하였다.**  
=> 부모 클래스 타입의 참조변수로 자손 클래스의 인스턴스를 다룰 수 있도록 하였다.
&nbsp;  
다음과 같이 정의된 두 객체 타입에 대해,
```java
//부모 클래스 Tv를 다음과 같이 정의한다.
class Tv{
    boolean power;
    int channel;

    void power(){
        power = !power;
    }

    void channelUp(){
        ++channel;
    }

    void channelDown(){
        --channel;
    }
}
```

```java
//자식 클래스 Tv를 다음과 같이 정의한다.
class SmartTv extends Tv{
    String text;
    void caption(){
        //자막을 달아주는 가상의 기능.
    }
}
```
&nbsp;  
&nbsp;  
다음과 같은 연산이 가능한 것이 '다형성'이다.
```java
Tv t = new SmartTv();
//부모 타입의 참조변수에
//자식 타입의 인스턴스를 대입하였다.

//지금까지 배운 대로라면 타입이 불일치해서 불가능할텐데..??!
``` 
이 연산의 구체적인 내용은 업캐스팅/다운캐스팅 참조.
&nbsp;  
&nbsp;  
&nbsp;  
**형변환을 하면 어떤 차이가 있을까?**
```java
Tv t1 = new SmartTv(); //형변환을 한 경우
SmartTv t2 = new SmartTv(); //하지 않은 경우.
```
&nbsp;  
- <u>부모 타입의 참조변수 t1은 자식 타입의 멤버에 접근할 수 없다.</u>
```java
t1.power = false;
t1.channel = 0;

t1.power();
t1.channelUp();
t1.channelDown();

t1.text = "페이퍼 타월이 여기 있네"; [x]
t1.caption(); [x]
```
&nbsp;  
&nbsp;  
- 자식 타입의 참조변수 t2만 자식 타입의 멤버에 접근할 수 있다.
```java
t2.power = false;
t2.channel = 0;

t2.power();
t2.channelUp();
t2.channelDown();

t2.text = "페이퍼 타월이 여기 있네";
t2.caption();
```

&nbsp;  
&nbsp;  
**Q. 거꾸로 자손 타입의 참조변수가 부모 타입의 인스턴스를 저장할 수 있나요?**   
**A. 불가능합니다.**
```java
SmartTv t = new Tv();
//[X]
```
이 경우,  
실제 인스턴스인 Tv의 멤버에 존재하지 않는 멤버를 참조변수 t가 사용할 가능성이 생기지요.  
그래서 이를 허용하지 않습니다.

