[<< 메인으로](https://github.com/AtomicLiquors/Java_Wiki_Chb)

&nbsp;  

# java.time
java.time에 속한 클래스는 String 클래스처럼 불변이다.  
기존 Calendar 클래스와 달리 멀티쓰레드 환경에서도 안전(*thread-safe*)하다.

멀티쓰레드 환경에서는 여러 쓰레드가 동시가 단일 객체에 접근할 수 있는데, 이 때 데이터가 잘못될 가능성이 있다.

&nbsp;  
### 그전과 달리, 날짜/시간/시간대를 별개의 클래스로 분리
날짜 : LocalDate  
시간 : LocalTime  
날짜와 시간 : LocalDateTime

&nbsp;  
### 객체 생성 메서드
.now() : 현재시간  
.of() : 직접 필드 값(연월일, 시분초 등) 지정


.parse() : 문자열을 날짜/시간으로 변환
&nbsp;  
### Temporal