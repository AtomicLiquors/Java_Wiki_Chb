[<< 메인으로](https://github.com/AtomicLiquors/Java_Wiki_Chb)

&nbsp;  

# Calendar
Calendar는 추상 클래스로,   
인스턴스를 생성할 때는 getInstance()라는 메서드를 이용한다.  


getInstance() 실행 시 시스템의 국가와 지역설정을 확인해서,   
메서드가 자식 클래스 GregorianCalendar와 BuddhistCalendar 중   
적합한 클래스의 인스턴스를 생성한다.
```java
Calendar = new Calendar();

Calendar cal = Calendar.getInstance();
//태국이면 Buddhist, 그 외에는 Gregorian을 반환한다.
```

&nbsp;  
인스턴스 생성을 이처럼 메서드를 이용하는 방식으로 설계한 것은   
**최소한의 변경으로 프로그램이 동작할 수 있도록 하기 위함**이다.   
다른 역법을 쓰는 국가에서 프로그램을 돌릴 때 
개발자가 작성한 코드를 변경하지 않아도 되며,

다른 종류의 역법이 추가되었을 때에도  
getInstance()의 내용만 업데이트하면 된다.

&nbsp;  
## Date와 Calendar 간 변환
### Calendar > Date
```java
Calendar cal = Calendar.getInstance();
//...
Date d = new Date(cal.getTimeInMillis());
```

&nbsp;  
### Date > Calendar
```java
Date d = new Date();
//...
Calendar cal = Calendar.getInstance();
cal.setTime(d);

```


&nbsp;  
&nbsp;  
## 주요 메서드
add()  : 값 증가 또는 감소  
roll() : 연, 월 등 다른 필드를 건드리지 않고 값 증가  
getTimeInMillis()  
