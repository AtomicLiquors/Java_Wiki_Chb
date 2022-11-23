[<< 메인으로](https://github.com/AtomicLiquors/Java_Wiki_Chb)

&nbsp;  

# 캡슐화와 접근 제어자
클래스 내부에 선언된 데이터를 보호한다.
- 데이터가 유효한 값을 유지하도록 한다.
- 민감한 데이터를 외부에서 함부로 변경하지 못하게 한다.

&nbsp;  

이를 구현하기 위해 "접근 제어자"를 사용한다.  



### 접근 제어자 종류
- default(기본값) : 같은 패키지 내에서만 접근 가능.
- private : 같은 클래스 내에서만 접근 가능.
- protected : 같은 패키지 + 다른 패키지의 자식 클래스에서 접근 가능.
- public : 접근 제한 없음.

클래스는 public, default만 사용 가능.

&nbsp;  
예제

인스턴스의 생성 제한
```java
class Singleton{

    private static Singleton s = new Singleton();

    private Singleton(){

    }

    public static Singleton getInstance(){
        return s;
    }
}
```
