[<< 메인으로](https://github.com/AtomicLiquors/Java_Wiki_Chb)

&nbsp;  
# 익명 클래스

- 내부 클래스의 일종. 
- 선언과 객체 생성을 동시에 하는 클래스
- 자기 이름이 없는 클래스.
- 따라서 객체를 하나만 생성 가능한 일회용 클래스.


### 컴파일
자기 이름이 없기 때문에 컴파일 결과인 .class파일도 외부 클래스의 이름을 빌려 생성된다.

```
외부 클래스명$숫자.class
```
```java
ExClass.class
//원본 외부 클래스

ExClass$1.class
ExClass$2.class
ExClass$3.class
//익명 클래스들
```


별도로 특별한 설명은 없다.
