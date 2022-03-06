
### 각종 연산

<aside>
💡 연산은 서로 다른 타입끼리 될 수가 없으며,
다른 타입 간의 연산을 명령한 경우 ”묵시적 형변환”이 일어난 후 계산된다.

</aside>

- **항의 갯수에 따른 연산자 구분 개념**
    
    항operand : 연산에 사용되는 값
    
    연산자operator : 연산하는 기호
    
    단항 연산자 ++
    
    이항 연산자 +
    
    삼항 연산자 ? → **condition** ? **value if true** : **value if false**;
    
- **대입 연산자** =
    
    변수에 값을 대입하는 연산자.
    연산의 결과를 변수에 대입한다.
    
    우선 순위는 가장 낮으며, 다른 연산이 수행된 후 가장 나중에 수행된다.
    
- **부호 연산자**
    
    ‘, - : 값을 각각 양수/ 음수로 만든다.
    

- **사칙연산**
    
    ```jsx
    package test0118;
    
    import java.util.Scanner;
    
    public class Optest01 {
    
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub
    		Scanner sc=new Scanner(System.in);
    		System.out.println("두 수를 입력하세요.");
    		int num1=sc.nextInt();
    		int num2=sc.nextInt();
    		int add=num1+num2;
    		int sub=num1-num2;
    		int mul=num1*num2;
    		double div1=num1/num2; // 정수끼리 / 연산을 하면 결과는 정수값만 나온다.
    		double div2=num1/(double)num2; // 연산할 때 한 쪽에 double을 붙여야 실수 형태의 결과를 얻을 수 있다.
    		int remember=num1%num2;
    		System.out.println("add: "+add);
    		System.out.println("sub: "+sub);
    		System.out.println("mul: "+mul);
    		System.out.println("div: "+div);
    		System.out.println("remember: "+remember);
    		
    		
    
    	}
    
    }
    ```
    
    ```jsx
    두 수를 입력하세요.
    7
    3
    add: 10
    sub: 4
    mul: 21
    div1: 2.0
    div2: 2.3333333333333335 // 보다시피 값이 좀 부정확하다.
    remember: 1
    ```
    

**증감 연산자**

++**var_name** = **var_name** += 1

**var_name**++ = 구문 실행 후 **var_name** += 1

**관계 연산자** (대소비교 등)

=== 등호 세개붙은 연산자는 값과 타입까지 비교한다.
일반적으로 == 는 두 대상의 타입이 서로 달라도 같은 유형으로 바꿔서 비교해 주는데, ===는 그렇지 않다.

- **논리 연산자***
    - && AND, “논리 곱”
    - || OR, “논리 합”
    - ! “논리 부정”
    
    주의!
    
    **논리 연산에서는 계산할 필요가 없는 항은 실행하지 않는다.**
    
    1. 한 자리 연산자 &과 두 자리 연산자 &&의 차이.
    - &와 달리 &&는 앞의 항이 false로 판명되면 뒤의 항은 실행 자체를 하지 않는다.
    (한 자리 연산자는 비트 연산자에서도 나오던데, 관련지어 생각할 건덕지가 있을까.)
        
        ```jsx
        package ch02;
        
        public class LogicalOp2 {
        	public static void main(String[] args) {
        		int a = 10;
        		int b = 20;
        		int c = 0;
        		
        		System.out.println((a>15)&(b>15));
        		System.out.println((a>15)&&(b>15));
        		System.out.println((a>15)&(a/c!=0));
        		System.out.println((a>15)&&(a/c!=0));
        	}
        }
        
        셋째 줄에서 0으로 나눴으니까 오류가 뜬다.
        이 줄을 빼고 넷째 줄로 넘어가면 오류가 뜨지 않는다.
        ```
        
    
    논리 곱에서 앞 항의 결과가 거짓이면, 그 다음 항은 실행되지 않는다. 또한, 
    
    논리 합에서 앞 항의 결과가 참이면, 그 다음 항은 실행되지 않는다.
    
    ```jsx
    package operator;
    
    public class OperationEx3 {
    	public static void main(String[] args) {
    		int num1 = 10;
    		int i = 2;
    		
    		boolean value = ((num1 = num1 + 10 ) < 10) && ((i = i + 2) < 10);
    		System.out.println(value);
    		System.out.println(num1);
    		System.out.println(i);
    		
    		value = ((num1 = num1 + 10) > 10) || ((i = i + 2 ) < 10);
    		System.out.println(value);
    		System.out.println(num1);
    		System.out.println(i);
    	}
    
    }
    ```
    
    ```jsx
    //결과값 :
    false 
    20 // num1 = num1 + 10은 계산되었다. 그 결과, 조건은 거짓이 되었고, AND연산도 거짓이 되었다.
    2 // 그래서 그 다음 항인 i = i + 2 는 계산되지 않았다.
    true
    30 // num1 = num1 + 10은 계산되었다. 그 결과 조건은 참이 되었고, OR연산도 참이 되었다.
    2
    ```
    
    논리연산자 xor(^) : 잘 쓰지는 않는다.
    
    두 불리언값을 비교해 참, 거짓이 **교차**되면 true.
    
    ```jsx
    System.out.println( (3!=2)^(-1>0) );
    System.out.println( (true)^(true) );
    //출력 결과는 각각 true, false
    ```
    

대문자 A 코드는 65.

소문자 a 코드는 97.

JAVA 

**복합 대입 연산자 :** +=, -=, *=, /=, %= 

- 예제 : 지폐 갯수 계산 초급(반복문 X)
    
    ```jsx
    package test0118;
    
    import java.util.Scanner;
    
    public class Optest04 {
    
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub
    
    		// 6자리 이상의 금액을 입력하라.
    		Scanner sc = new Scanner(System.in);
    		int balance = sc.nextInt();
    
    		// 5만원권, 1만원권, 5천원권, 천원권 몇장이 필요한지 출력해라.
    		int bill_50k = balance / 50000;
    		balance %= 50000; 
    		int bill_10k = balance / 10000;
    		balance %= 10000; 
    		int bill_5k = balance / 5000;
    		balance %= 5000; 
    		int bill_1k = balance / 1000;
    		balance %= 1000; 
    
    		System.out.printf("오만원권 : %d장, 만원권 : %d장, 오천원권 : %d장, 천원권 : %d장입니다.\n", bill_50k, bill_10k, bill_5k, bill_1k);
    		System.out.println("잔액: "+balance);
    		
    
    	}
    
    }
    ```
    

Q. 영어 알파벳을 입력받아 대문자가 아니면, 소문자로 고쳐서 출력하라.

### 비트 연산자

비트연산은 2진수형태의 숫자 0과 1로 할 수 있는 연산이다. 

<aside>
💡 **왜 하는가?**

- 알고리즘을 다양한 방법으로 작성할 수 있다.
- 시간복잡도를 줄여 준다.

</aside>

~ : 비트 반전(0 → 1)

^ :

<< :

>> :

>>> :

- 보수
    
    ### 비트의 보수(~)
    
    이진수의 모든 비트를 반대로 바꾼다. 0 이면 1, 1이면 0으로 바꾼다. 
    **보수를 사용할 경우 32자리를 기준**으로 값을 반환한다.
    
    **~x** 형식으로 연산자를 사용하고 x의 보수를 구하라는 의미이다.
    
    **ex) ~0110 = 11111111111111111111111111111001**
    
    기존 앞에 자리는 0으로 간주하여 1로 바뀌고 1이었던 자리는 0으로 바뀐다.
    
- 시프트
    
    ### <<(왼쪽 시프트)
    
    숫자의 모든 비트를 왼쪽으로 이동시킨다.
    오른쪽에 생기는 빈 비트 자리는 0으로 채운다.
    
    **x << y** 형식으로 연산자를 사용하면 되고 
    = **x의 비트를 왼쪽으로 y칸 이동**시킨다
    = x의 값을 2^y만큼 곱한다
    
    **ex) 1111 << 2 = 111100**
    
    **1111(십진수 15)** 이 **111100(십진수 60)**로 바뀌었다. **x * 2^y** 값을 반환한다.
    
    ### >>(오른쪽 시프트)
    
    숫자의 모든 비트를 오른쪽으로 이동시킨다. 
    가장 우측에 있는 숫자가 밀려나가면, 그냥 버린다.
    
    **x >> y** 
    ”**x의 비트를 왼쪽으로 y칸 이동**시킨다”
    
    **ex) 1111 >> 2 = 11**
    
    **1111(15)** 이 **11(3)**로 변형되는 것을 보면 **x / 2^y** 으로 나머지를 제외한 몫을 반환한다.
    
    <<<, >>> : 비트이동은 동일하나, **남은 공간은 부호비트가 아닌 0으로 채운다.**
    
    뭐가 다른지 모르겠다. 보충하자.
    

### JAVA 예시

[https://t1.daumcdn.net/cfile/tistory/994FD8365DD8138E30](https://t1.daumcdn.net/cfile/tistory/994FD8365DD8138E30)

### 결과

[https://t1.daumcdn.net/cfile/tistory/9961FE335DD8138E04](https://t1.daumcdn.net/cfile/tistory/9961FE335DD8138E04)

### AND(&)

기본 AND 연산자처럼 해당 자리수에서 둘다 1인 경우 1을 반환하고 나머지는 0을 반환한다.

**x & y** 형태로 사용하고 의미의 숫자 x와 y를 비교한다.

**ex) 1111 & 1000 = 1000**

### OR(|)

기본 OR 연산자처럼 해당 자리수에서 하나라도 1인 경우 1을 반환하고 둘다 0인 경우 0을 반환한다.

**x | y** 형태로 사용하고 의미의 숫자 x 와 y를 비교한다.

**ex) 1111 & 1000 = 1111**

### XOR(^)  Exclusive OR

**x ^ y** 형태로 사용하고 해당 자리수에서 서로 다른 경우 1을 반환하고 같은 경우 0을 반환한다.

**ex) 1111 & 1000 = 111**

### JAVA 예시

[https://t1.daumcdn.net/cfile/tistory/9907194C5DD8138E28](https://t1.daumcdn.net/cfile/tistory/9907194C5DD8138E28)

### 결과

[https://t1.daumcdn.net/cfile/tistory/99ED0B3B5DD8138E30](https://t1.daumcdn.net/cfile/tistory/99ED0B3B5DD8138E30)

### 복합 대입 연산자

X <<= Y  : Y만큼 비트를 왼쪽으로 이동하고, 그 값을 X에 대입한다.

등등

- 비트 논리 연산자
    
    & : 양쪽 항의 자릿수를 비교해서 둘 다 1일 때만 1로 바꾼다.
    
    ```jsx
    
    ```
    
    | : 양쪽 항의 자릿수를 비교해서 한쪽만 1이라도 1로 바꾼다.
    
    ^ : 
    

### 삼항 연산자 : Ternary Operator

? :

엑셀의 if와 비슷. 어딘가 적어놨으니 찾아봐라.

- 예제) 알파벳 대문자 변환
    
    ```jsx
    package test0118;
    
    import java.util.Scanner;
    
    public class Optest03 {
    
    	public static void main(String[] args) {
    		// TODO Auto-generated method stub
    		Scanner sc=new Scanner(System.in);
    		String s=sc.next(); //s라는 변수에 문자를 입력받아서...
    		char ch=s.charAt(0);//s의 맨 첫 번째 글자를 가져와서 ch에 넣어라.
    		
    		int result = (ch>=97)?ch-32:ch; 
    		/*알파벳은 각각 정수에 대응된다는 얘길 했었다. 
    		97이 넘어가면 소문자고, 대문자와의 격차는 32다. 
    		
    		*/
    		System.out.println((char)result);
    		
    
    	}
    
    }
    ```
    
- 예제) 3의 배수 판독 (js)
    
    ```jsx
    var bloodType = prompt("숫자를 입력하세요.");
    	if(num!=null){
    		(num%3==0)? alert("3의 배수입니다."): alert("3의 배수가 아닙니다.");
    	}else{
    		alert("입력이 취소됐습니다.");
    	}
    ```
    

연산자 우선순위

![Untitled](Java%202da56/Untitled%2010.png)

### 

보충 : 비트 연산자\

상수는 대문자로 표기하는 것이 관례다.

```jsx
if (num < 1 || num > 30) {
			System.out.println("숫자의 범위를 벗어났습니다.");
			return; // return을(return만) 쓰면, 함수가 종결된다! 숙지할 것.
		}
```

```jsx
package ch02;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		//1~29 숫자 중 3, 6, 9 게임 숫자는 "짝"으로 표현하세요.
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자를 입력하세요.");
		int num = sc.nextInt();
		
		digit2 = int(num/10);
		digit1 = num%10;
		if(num<1 || num > 30) {
			System.out.println("숫자의 범위를 벗어났습니다.");
			return; // return을(reutrn만) 쓰면, 함수가 종결된다! 숙지할 것.
		}
		
		if(digit1 == 3 || digit1 == 6 || digit1 == 9) {
			System.out.println("짝");
		}else if(digit2 == 3 || digit2 == 6 || digit2 == 9) {
			
		}
	
		sc.close();
	}

}
```
