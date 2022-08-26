[<< 메인으로](https://github.com/AtomicLiquors/Java_Wiki_Chb)

&nbsp;  

# 패키지와 임포트
효율적인 관리를 위한, 서로 관련된 클래스의 묶음.  
- 같은 이름의 클래스일지라도 서로 다른 패키지에 존재할 수 있으므로,  
다른 개발자의 라이브러리와 충돌을 예방할 수 있다.


### 선언  

```
package ch04;
```
&nbsp;  
- 클래스의 풀네임은 실제로는 소속된 패키지 이름까지 포함한다.  
    
   -  **SUN에서 만든 경우**

       - java.sql.Date
       - java.util.Date

    - **SUN이 아닌 타사에서 만든 경우**  
    충돌 방지를 위해 도메인을 거꾸로 선언한다.

      - [naver.com](http://naver.com/) -> Date => com.naver.Date
      - [daum.net](http://daum.net/) -> Date => net.daum.Date

### [프롬프트 컴파일] -d 옵션
```
c:\jdk1.8\work>javac -d . PackageTest.java
```
'-d'옵션은 소스파일에 지정된 경로를 통해 패키지의 위치를 찾아   
클래스 파일을 생성한다.  
-d 옵션 뒤에는 해당 패키지의 루트 디렉토리 경로를 적는다.  
(예제의 경우, 현재 디렉토리[.])

-d를 사용하지 않으면 프로그래머가 직접 계층구조에 맞게 디렉토리를 생성해야 한다.

자바의 정석 1권 337페이지.

# import
설명 생략.
## static import
static 멤버를 호출할 때 사용한다.
```java
import static java.lang.Integer.*;
import static java.lang.Math.random;
import static java.lang.System.out;
```

임포트 전
```java
System.out.println(Math.random());
```
임포트 후
```
out.println(random());
```

