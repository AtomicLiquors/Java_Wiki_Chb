# Java


___

새 클래스 생성할 때 superclass 란에 패키지명.클래스명을 기입해  
상위클래스를 미리 설정할 수 있다.

System.exit(0); //정상종료  
System.exit(1); //비정상종료 입니다.

사실 단일프로그램에서 종료 0은 의미가 없어요.  
복합적으로 만들면 하나가 종료될 때 다른 프로그램에 매개변수로 0 또는 1이 넘어갑니다.



 if문의 실행문 코드가 한 줄이면 중괄호는 생략가능하다.

- EventEx
    
    ```jsx
    package ch09;
    
    import java.awt.BorderLayout;
    import java.awt.Button;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    /*버튼을 클릭하면 발생되는 이벤트객체는 ActionEvent이다.
     * 이벤트소스(Button)랑 이벤트객체(ActionEvent)를 연결하기 위한 
     * 이벤트 리스너는 XXXListener -> ActionListener 인터페이스를 구현*/
    
    public class EventEx1 extends MFrame implements ActionListener{
    	
    	Button btn;
    	
    	public EventEx1() {
    		add(btn = new Button("버튼"),BorderLayout.SOUTH);
    		//이벤트 소스랑 이벤트리스너 연결은 addXXXListener
    		//this(내자신): 내 클래스에 XXXListener 구현
    		btn.addActionListener(null);
    	}
    	
    	@Override
    	public void actionPerformed(ActionEvent e) {
    		setBackground(MColor.rColor());
    	}
    	
    	
    	public static void main(String[] args) {
    		new EventEx1();
    	}
    
    }
    ```
    
    ```jsx
    package ch09;
    
    import java.awt.BorderLayout;
    import java.awt.Button;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    
    public class EventEx2 extends MFrame{
    //버튼을 누르면 색이 바뀌는 예제다.
    
    	Button btn;
    	
    	public EventEx2() {
    		add(btn = new Button("버튼"), 
    				BorderLayout.SOUTH);
    		btn.addActionListener(new ActionListener() {
    
    			@Override
    			public void actionPerformed(ActionEvent e) {
    				setBackground(MColor.rColor());
    			}
    			
    		});
    	}
    	
    	public static void main(String[] args) {
    		new EventEx2();
    	}
    
    }
    ```
    

- 개념
    <aside>
    💡 **smallest elements of a program which are identified by the compiler
    컴파일러가 인식 가능한 최소한의 프로그램 요소 단위**
    . Tokens in java include identifiers, keywords, literals, operators and, separators.
    
    </aside>
    

jdk표준 자바 패키지 구조 : rt.jar에서 rt.jar를 x표 쳤다. 그게 무슨 의미냐?

- 패키지의 활용법
    
    협업을 할 때 각자 작업하다 보면 클래스 명의 중복이 발생할 수 있다.
    이 때 각자 분담한 분야에 맞춰 패키지 이름을 만들면 중복을 예방할 수 있다.
    
    회사의 패키지명은 도메인을 거꾸로.(유니크)
    정확한 개념이...?
    

패키지 선언하면 컴파일러

명령 프롬프트로 자바 컴파일하기

![Untitled](Java%202da56/Untitled%203.png)

소수점 두자리

System.out.printf("원기둥의 부피: %.2f\n", c.getVolume());

1) 메모장에 .java 

javac -d . C:\

패키지 이름 정하기

- String Format
    
    ```jsx
    String format 문법 형식
    %[argument_index$][flags][width]conversion
    문법 설명
    1) 필수값: %와 conversion 으로 무조건 있어야합니다.
    "conversion": 표현 할 데이터의 타입으로, s(문자열), d(정수), x(16진수), o(8진수), f(실수) ex) %s, %d, %x, %o, %f
    ex) System.out.println(String.format("%s, %s", "KOREA", "JAPAN"));
    2) 옵션값: [argument_index$][flags][width] 는 생략 가능합니다.
    생략 가능한 옵션
    [argument_index] 옵션
    [flags] 옵션
    [width] 옵션
    [argument_index] 옵션
    들어갈 파라미터의 인덱스이다. 1부터 시작한다.
    아래를 보면 2$와 1$를 각 각 추가했는데 2$는 두번 째 문자열인 "JAPAN"을 의미하고,
    1$는 첫 번째 "KOREA"를 의미하기 때문에 출력 순서가 바뀐 것입니다.
    
    // 길이를 10으로 지정 (width +  argument_index 옵션)
    System.out.println(String.format("%2$10s%1$10s", "KOREA", "JAPAN"));
         JAPAN     KOREA
    
    [flags] 옵션
    [flags]는 [argument_index]와 [width]사이에 위치합니다.
    '-' flag를 사용하면 출력되는 문자열이 왼쪽으로 정렬 됩니다.
    '-' flag를 빼면 이전 예제와 같이 오른쪽으로 정렬됩니다.
    
    System.out.println(String.format("%-10s%-10s", "KOREA", "JAPAN"));
    KOREA     JAPAN     
    
    System.out.println(String.format("%10s%10s", "KOREA", "JAPAN"));
         KOREA     JAPAN
    
    [width] 옵션
    conversion앞에 위치하는 [width]를 사용한 샘플입니다.
    
    // 길이를 10으로 지정 (width 옵션)
    System.out.println(String.format("%10s%10s", "KOREA", "JAPAN"));
         KOREA     JAPAN
    
    출처: https://interconnection.tistory.com/116 [Ryan Server]
    ```
    

- 제공된 강의노트. 모르는 내용 있나?
    
    2/16
    1.this : 자기자신을 뜻하는 키워드
    2.super : 부모(상위, super)를 뜻하는 키워드
    3.상속(Inheritance)
    
    - 자동차(Car) : 잘 만들어 놓음
    - 택시, 승용차, 버스, 트럭
    - 사람 클래스 -> 남자클래스, 여자클래스
    4.상속 : 물체(Object) > 동물 > 포유류> 고양이 > 사자
    물체(Object) > 동물 > 포유류 > 사람 > 남자 > 장동건
    ex) class 장동건 extends 남자{}
    5.모든 클래스는 부모클래스가 있다.
    단.Object 클래스는 제외 <- 최고 상위 클래스(곰 같은 존재)
    1. 메소드에 매개변수로 넘기는 값이 기본형 vs 참조형
    - 기본형 값이 전달: call by value <- 값이 전달
    - 참조형 값이 전달 : call by reference <- 객체의 주소값
    
    7.package를 선언하면 컴파일 시점 자동으로 폴더가 만들어짐.
    
    - javac -d . A.java
    -> javac : 컴파일 명령어
    -> -d : 패키지 컴파일 옵션
    -> . : 현재 디렉토리에 파일 생성
    -> .java : 현재 디렉토리에 있는 모든 자바 한꺼번에 컴파일
    1. 패키지 이름 정하기
    - java.lang.String : java.lang -> 패키지명
    String -> 클래스명
    => 개발자 패키지명 다르게 선언해서 String 클래스 선언 가능
    1. SUN에서 제공되는 클래스를 제외하고 다른 회사에 만드는
    클래스의 패키지명은 도메인 꺼꾸로 선언 -> 유니크
    - [naver.com](http://naver.com/) -> Date => com.naver.Date
    - [daum.net](http://daum.net/) -> Date => net.daum.Date
    - SUN -> java.sql.Date, java.util.Date

- CallBy.. value, reference(배열까지)
    
    
    매개변수로 넘기는 값이 기본형이냐, 참조형이냐?
    기본형 값이 전달될 때를... call by value
    참조형 값이 전달될 때를... call by reference라고 한다.
    
- 오버로딩 : 
한 클래스 내에 
같은 이름, 다른 인자와 타입을 가진 메소드가 여러 개 선언되는 것.
    
    ```jsx
    package ch04;
    
    public class OverloadingEx2 {
    	
    	void plus(int a, int b) {
    		System.out.println(a+b);
    	}//매개변수가 2개 들어갔다.
    	
    	void plus(int a, int b, int c) {
    		System.out.println(a+b+c);
    	}//매개변수가 3개 들어갔다.
    	
    	void plus(int arr[]) {
    		int sum = 0;
    		for (int i = 0; i < arr.length; i++) {
    			sum += arr[i];
    		}
    		System.out.println(sum);
    	}
    }//매개변수로 배열이 들어갔다.
    ```
    

C:\Java\jdk-11.0.13\jmods → jmod파일을 반디집으로 오픈

[https://opentutorials.org/module/4294](https://opentutorials.org/module/4294)

스캐너 쓰고 sc.close(); 써야 된다.
안 쓰면 어떻게 됩니까?


자바에서...

![Untitled](Java%202da56/Untitled%204.png)

![Untitled](Java%202da56/Untitled%205.png)

![Untitled](Java%202da56/Untitled%206.png)

프롬프트

[C:\test] 디렉토리로 이동 후...

javac Test.java

컴파일. 자바 .class 파일이 생긴다.

java Test

실행이 된다.

C:\test>

환경 변수의 path는 뭡니까?

여기에 경로를 지정하면, 그 폴더로 들어가 exe명령어 위치에 관계없이 실행하기 위한 목적
(명확히 좀....)

자바 프로그램 구조

자바 코드는 항상 클래스 내부에 들어간다.

자바에서는 함수에 해당하는 것을 메소드라고 지칭한다.

url 단축을 위해

Servers > Tomcat ~ > server.xml에서 포트 번호를 8080 > 80으로 수정했다.(맞지?) 

브라우저 개발자 메뉴 - 콘솔 

typeof : 대상의 값 유형

불리언은 가장 크기가 작은 유형이다.

“참과 거짓을 가진 최소 크기의 값”

엄밀히 말해서 논리형은 아니라는데...

null : “값이 없는 상태, 할당되지 않은 상태, 값이 유효하지 않은 상태”

숫자 + 문자일 경우 무조건 문자+문자로 변환된다.

이 점을 알면 코드를 훨씬 간단하게 짤 수 있지.

자바의 시간 단위는 디폴트로는 밀리초입니다.

이클립스는 저장과 동시에 자동으로 컴파일된다.

패키지는 사실상 폴더라고 봐도 무방한 개념.

    
- 기본사항
    
    class는 몇 개라도 있어도 상관없지만, public class는 단 하나만 있어야 한다.
    
    main 함수는 반드시 필요한 것은 아니다.
    
    단, main이 없는 클래스는 main안에서 인스턴스를 만들어 사용된다.
    
    class_name.func(); : class_name을 실행하라.
    
    패키지가 필요한 이유?
    
    패키지 명의 .은 상위/하위 경로를 나타낸다.
    

    



```java
import java.util.*; 
public class Main{ public static void main(String args[]){ Scanner sc = new Scanner(System.in); 
int a, b; 
a = sc.nextInt(); 
b = sc.nextInt(); 
System.out.println(a + b); } }

공백으로 구분된 숫자쌍 입력받기
```





연산자

- 다음을 보고 출력되는 수가 뭘지 맞혀보세요.
    
    ```jsx
    package ch02;
    
    public class AssignmentIncDecOperator {
    
    	public static void main(String[] args) {
    		int a = 3, b = 3, c = 3;
    		a += 3;
    		b *= 3;
    		c %= 2;
    		
    		System.out.println("a = " + a + ", b = " + b + ", c = "+ c);
    		
    		int d = 3;
    		a = d++;
    		System.out.println("a = "+ a);
    		System.out.println("d = "+ d);
    		a = ++d;
    		System.out.println("a = "+ a);
    		System.out.println("d = "+ d);
    		a = d--;
    		a = --d;
    	}
    
    }
    ```
    
    - 정답
        
        ```jsx
        a = 6, b = 9, c = 1
        a = 3
        d = 4
        a = 5
        d = 5
        ```
        

식별자 :
클래스, 변수, 메소드 등에 붙이는 이름
특수문자는 _, $외에 불허하며 공백도 안 된다.
첫째 문자로 숫자는 안 된다.
첫째 문자로 _, $ 가능은 한데 잘안 쓴다.
길이제한은 없다. 

파일 경로를 ./으로 수정


### 입출력문

**출력**

**System.out.print("text");**
→ System의 표준 출력장치 out에 출력(print)하라.

print : 그냥 출력.

println : 출력 후 한 줄 띄운다.

printf : format 기능을 사용. 변수를 집어넣고, 또 내가 원하는 형식을 지정해 준다.

```kotlin
printf(“text **%s** text **%d** text **%f**”, **str_var**, **int_var**, **float_var**);
```

```jsx
System.out.printf("원기둥의 면적: %.2f\n", c.getArea());
```

<aside>
💡 sysout을 입력하고 → ctrl + space를 누르면 
**System.out.println**이 호출된다.

</aside>

**입력**

먼저 main함수 밖에서 스캐너를 임포트해야 한다.

import java.util.Scanner;

[System.in](http://System.in) 
키보드로부터 직접 읽는 자바의 표준 입력 스트림
키 값을 바이트 데이터(011010...)로 리턴. 응용 프로그램이 문자 정보로 변환해 줘야...

표준입력 장치로부터 입력된 byte스트림을 자바의 데이터형으로 변경한다.

Scanner 클래스  : 
System.in에게 키를 읽게 하고, 입력된 바이트를... 변환

문자 입력 next();

정수 입력 nextInt();

관련 에러

- the import java.util.Scanner conflicts with a type defined in the same file
    - class 이름 바꿔보셈 중복대서 그런거같음2019.01.23 23:19:56
        
        삭제
        
    - *3331*(39.119)2019.01.23 23:21:09
        
        7번째 줄에 Scanner선언했는데 그게 class Scanner랑 util.Scanner랑 뭐불러올지 몰라서 그런거같은데 정확히 모르는데 class 이름 refactor하
        
    
    컨트롤 + 쉬프트 + o
    

### 조건문

- If
    
    ```jsx
    if(**condition**)
    {
    	**execution1**
    }else if{
    	**execution2**
    }else{
    	**execution3**
    }
    
    ```
    
- Switch
    
    ```jsx
    package test01;
    
    public class IfSwtich01 {
    	public static void main(String [] args) {
    		int rank = 1;
    		
    		switch(rank) { //변수 값에 따라 출발점을 달리한다.
    		case 1: 
    			System.out.println("G");
    			break; //break를 하지 않으면, 다음 구문을 수행한다.
    		case 2: 
    			System.out.println("S");
    			break;
    		case 3: 
    			System.out.println("B");
    			break;
    		default:
    			System.out.println("UR");
    		}
    	}
    
    }
    ```
    
    Switch는 범위를 대상으로 사용할 수 없다. 
    
    대신 int에다 나눗셈 연산을 하면, 소수점은 없어지고 정수만 남는다는 점을 활용하자.
    
    사계절
    
    ```jsx
    package test01;
    
    public class IfSwtich01 {
    	public static void main(String [] args) {
    		int month = 5;
    		
    		switch(month) {
    		case 3: 
    		case 4: 
    		case 5: System.out.println("Spring");	break;
    		case 6:
    		case 7:
    		case 8: System.out.println("Summer");	break;
    ...
    
    		}
    	}
    
    }
    ```
    
    ```jsx
    package test01;
    
    public class IfSwtich01 {
    	public static void main(String [] args) {
    		int month = 5;
    		
    		switch(month/3) {
    		case 1: 
    			System.out.println("Spring");
    			break;
    		case 2: 
    			System.out.println("Summer");
    			break;
    		case 3: 
    			System.out.println("Fall");
    			break;
    		default:
    			System.out.println("Winter"); //권장하지 않음... 이건 변수값을 잘못 입력했을 때 쓰는 듯.
    		}
    	}
    
    }
    ```
    
    ```jsx
    package ch02;
    
    import java.util.Scanner;
    
    public class SwitchEx1 {
    	public static void main(String[] args) {
    		Scanner sc = new Scanner(System.in);
    		int m = sc.nextInt();
    		switch (m) {
    		case 12: case 1: case 2: //12를 입력하면 case1, case2를 거쳐 겨울이 출력된다. 
    			System.out.println("겨울입니다.");
    			break;
    		case 3: case 4: case 5:
    			System.out.println("봄입니다.");
    			break;
    		case 6: case 7: case 8:
    			System.out.println("여름입니다.");
    			break;
    		case 9: case 10: case 11:
    			System.out.println("가을입니다.");
    			break;
    		default:
    			System.out.println("해당사항 없음");
    			break;
    		}
    	}
    
    }
    ```
    
    문자를 대상으로 switch를 사용할 수 있다.
    아래는 간단한 사칙연산을 switch로 구현한 것이다.
    
    ```jsx
    package test0119;
    
    import java.util.Scanner;
    
    public class WhileCalculat {
    	public static void main(String args[]) {
    
    		Scanner sc = new Scanner(System.in);
    		
    		Boolean isCalculatorOn = true;
    
    		while (isCalculatorOn) {
    			System.out.print("1: 계산기 실행, 2:종료 >> ");
    			int num = sc.nextInt();
    			switch (num) {
    			case 1:
    				System.out.print("num1>> ");
    				int n1 = sc.nextInt();
    				System.out.print("연산>> ");
    				String op = sc.next();
    				System.out.print("num2>> ");
    				int n2 = sc.nextInt();
    
    				int result = 0;
    				switch (op) {
    				case "+":
    					result = n1 + n2;
    					break;
    				case "-":
    					result = n1 - n2;
    					break;
    				case "*":
    					result = n1 * n2;
    					break;
    				case "/":
    					result = n1 / n2;
    					break;
    				default:
    					System.out.println("사칙연산 부호를 올바르게 입력해 주세요.");
    				}
    				System.out.println(result);
    
    				break;
    				
    			case 2:
    				System.out.println("계산기를 종료합니다.");
    				isCalculatorOn = false;
    				break;
    
    			}
    
    		}
    		// while
    		// switch() case 1:
    	}
    
    }
    ```
    

- Math.
    
    abs : 절댓값
    

### 함수

함수 내에서 선언한 지역변수는 사용하기 전에 초기화를 해야 한다.
값을 뭐든 넣어 줘야지 쓸 수 있다는 것이다.
자세한 설명은 관련 지식 필요.

### 반복문

- for
    
    ```jsx
    for(초기화식; 조건식; 증감식;){
    	실행문;
    }
    ```
    
    ![Untitled](Java%202da56/Untitled%209.png)
    
    - 실습 : 다이아몬드 그리기
        
        ```jsx
        package test0119;
        
        import java.util.Scanner;
        
        public class DoWhileTest4 {
        	static int func(int i, int j) {
        		return i + j;
        	}
        
        	public static void main(String[] args) {
        		// TODO Auto-generated method stub
        		for (int i = -10; i <= 10; i++) {
        			for (int j = -9; j <= 9; j++) {
        				if (Math.abs(j) > 9 - Math.abs(i)) {
        					System.out.print(" ");
        				}else {
        					System.out.print("*");
        				}
        			}
        
        			System.out.print("\n");
        		}
        		
        
        	}
        }
        ```
        
        ```jsx
        				 *         
                ***        
               *****       
              *******      
             *********     
            ***********    
           *************   
          ***************  
         ***************** 
        *******************
         ***************** 
          ***************  
           *************   
            ***********    
             *********     
              *******      
               *****       
                ***        
                 *
        ```
        
        수정사항 : 첫 줄이 왜 공백인가? 논리를 완전히 설명할 수 있나?
        
    
    반복문 선언(alt) : 이렇게 쓸 수는 있다 정도.
    
    1)
    
    ```jsx
    int j = 0;
    		for (;j< 11; j++) {
    			구문
    		}
    ```
    
    2) 이건 while로 완전 대체 가능한것 아니냐?
    
    ```jsx
    for(;true;){
    	 무한반복할 구문
    }
    ```
    
    3) 증감값이 2개
    
    ```jsx
    for(int n = 0, m = 0; n<11; n++, m--){
    }
    ```
    
- while
    
    
    <aside>
    💡 조건문에다 스캔을 받을 수 있다.
    
    </aside>
    
    ```jsx
    package test0119;
    
    import java.util.Scanner;
    
    public class WhileTest02 {
    	static int func(int i, int j) {
    		return i+j;
    	}
    
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub
    		Scanner sc = new Scanner(System.in);
    		String s1="";
    		**while(!(s1=sc.next()).equals("quit"))** { //조건문에서 입력을 받고, 입력 내용이 quit인지 아닌지를 판단한다.
    			char ch=s1.charAt(0);
    			if(ch >='a' && ch <= 'z') {
    				System.out.println((char)(ch-32));
    			}else {
    				System.out.println(ch);
    			}
    		}
    
    	}
    }
    ```
    
- do - while
    
    조건검사 없이 일단 한 번은 수행한다.
    
    ```jsx
    package test01;
    
    public class WhileTest {
    
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub
    		
    		int i = 0;
    		int result=0;
    		do {
    			result += i;
    			System.out.printf("i= %d, result = %d\n", i, result);
    			i++;
    		}while(i<10);
    		System.out.println("i="+i);
    
    	}
    
    }
    ```
    
- continue; continue 뒤의 명령을 수행하지 않고 반복문의 다음 단계로 진행한다.
솔직히 잘 안 써요. if문만 넣어도 충분합니다.
- break; 반복문 탈출.

### 문자열

“\n” : 한줄 띄우기

“\t” : 한 탭 띄우기

다차원 배열 개념 추가하세요.

- 오답 : 중복 없는 추첨
    
    ```jsx
    package ch03;
    
    import java.util.Random;
    
    public class Lotto {
    	public static void main(String[] args) {
    		// 1에서 45 사이의 난수 6개를 추첨합니다.
    		int lotto[] = new int[6];
    		Random r = new Random();
    
    		for (int i = 0; i < lotto.length; i++) {
    			lotto[i] = r.nextInt(6)+1;
    			
    			for(int j = 0; j < i; j++) {
    				if(lotto[i] == lotto[j]) {
    					i--; //이전 회차로 돌아가 다시 실시한다.
    					break;
    				}
    			}
    			
    		}//배열 생성하는 for 종료
    		
    		for (int i = 0; i < lotto.length; i++) {
    			System.out.print(lotto[i] + "\t");
    		}
    		
    	}
    }
    ```
    
    왜 틀렸는가? 
    i—, break를 쓸 생각을 못하고 
    for문을 while로 감싸려 했다.
    for문 내부에서 while문을 탈출할 방법을 만들지 못했다.

        ### 개요
        
        메소드의 일종으로, 객체를 생성하는 특별한 기능의 메소드.
        ”객체 생성에 필요한 값을 초기화”하는 역할이다.
        
        반드시 클래스명과 동일한 이름으로 선언해야 한다
        
        메소드 리턴 타입 선언 자체가 없다. 생략하는 게 아니라.
        그래서 이름 앞에 데이터 유형을 적어주지 않는다.
        int 이런것도 안 붙이고, void조차 안 붙인다.
        
        - **생성자가 선언되어 있지 않으면, 컴파일 시점에 JVM 디폴트 생성자를 제공한다.**
            
            ```jsx
            package ch04;
            
            public class Circle {	
            	int radius;
            	void set(int r) { 
            		radius = r; 
            		}
            	double getArea() { 
            		return 3.14*radius*radius; 
            		}
            	
            	public static void main(String[] args) {
            		**Circle pizza = new Circle();**
            		pizza.set(5);
            		System.out.println(pizza.getArea());
            	}
            
            }
            ```
            
            위 코드를 실행하면 정상적으로 5의 반지름을 갖는 원의 면적이 출력된다.
            진한 글씨로 표현한 **Circle pizza = new Circle();**에서 왜 오류가 나지 않을까?
            
            Circle 클래스에 생성자가 하나도 없는데, 컴파일 오류가 나야 하는 것 아닌가?
            오류가 나지 않는 이유는 호출하는 순간, 
            컴파일러가 **알아서 기본 생성자를 클래스에 삽입**해 주었기 때문이다.
            
            하지만 생성자가 하나라도 있다면, 
            컴파일러는 스스로 기본 생성자를 만들어 주지 않는다.
            
            ```jsx
            package ch04;
            
            public class Circle {	
            	int radius;
            	void set(int r) { 
            		radius = r; 
            		}
            	double getArea() { 
            		return 3.14*radius*radius; 
            		}
            	
            //---------------------------
            	**public Circle(int r) {
            		radius = r;
            	}**
            //---------------------------
            
            	public static void main(String[] args) {
            		
            		
            		Circle pizza = new Circle();
            		pizza.set(5);
            		System.out.println(pizza.getArea());
            
            		Circle donut = new Circle(10);
            		System.out.println(donut.getArea());
            		
            		
            	}
            
            }
            ```
            
            표시한 것과 같이 정숫값을 받는 생성자를 하나 만들었다.
            그랬더니 아까 입력한 것처럼 pizza 인스턴스를 생성할 때 오류가 난다.
            개발자가 생성자를 만들어 넣었으면,
            이제부터 그 생성자의 양식에 맞춰서 인스턴스를 만들어야 오류가 안 나고 실행이 된다.
            더 이상 컴파일러가 기본 생성자를 넣어주지 않는다.
            
        
        생성자가 여러개 존재하는 이유 : 
        
        오버로딩(overloading) :
        같은 클래스에 동일한 이름으로 메소드 선언
        (매개변수 타입 갯수가 달라야 한다.)
        
        이를 통해 여러가지 생성자를 만들 수 있다.
        
        객체가 생성되는 다양한 case가 존재하기 때문이다.
        
        내가 선언만 하고 나중에 매개변수를 넣든지,
        내가 선언과 동시에 매개변수를 집어넣든지...
        
        프로그래밍 하면서 클래스를 다양한 형태로 활용할 수 있도록 하기 위해.
        
    
    - this : 객체 자신에 대한 참조
        
        컴파일러에 의해 자동으로 관리된다. 개발자는 사용하기만 하면 된다.
         → 정확히 무슨 뜻일까?
        
    - this()는 무엇인가?
        
        **같은 클래스 내에서 생성자가 다른 생성자를 호출할 때만 사용한다.**
        
        this()는 생성자에서만 사용된다.
        
        this()는 생성자 코드의 첫 번째 문장이 되어야 한다.
        
    
    우클릭 > 소스 > Generate Getters And  Setters 
    
    아래와 같이 필드로 선언된 변수명과 매개변수로 입력된 변수명이 동일하다면,
    필드의 변수는 앞에 this를 붙여주어야 한다.
    
    ```jsx
    public void setName(String name) {
    		this.name = name;
    	}
    ```
    
    super : 상속 개념과 결부되어 있다.
    부모, 상위를 뜻하는 키워드.
    
    ```jsx
    class ITaxi extends ICar1{ //상속을 받는다.
    	void speedUp() {
    		super.speedUp(); //부모 클래스의 speedUp 메소드를 받아온다.
    	}
    }
    ```