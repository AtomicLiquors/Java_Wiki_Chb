
- String
    
    ```jsx
    package ch06;
    
    public class StringEx1 {
    
    	public static void main(String[] args) {
    		String s1 = new String("Java");
    		String s2 = new String("Java");
    		//String은 유일하게 new 연산자 없이 객체 생성이 가능한 클래스다.
    		//왜? 너무 많이 쓰이니까.
    		String s3 = "Java";
    		String s4 = "Java";
    		
    		//기본형 data type에서 == 연산자는 값을 비교하는 것
    		int a = 10, b= 10;
    		if(a==b)
    			System.out.println("a는 b와 같다");
    		
    		//참조형 data type에서 ==연산자는 "객체 주소값" 비교
    		if(s1==s2) System.out.println("s1==s2 : true");
    		if(s1==s3) System.out.println("s1==s3 : true");
    		if(s3==s4) System.out.println("s3==s4 : true");
    		//new연산자를 달고 독립적으로 만들어진 String 객체는 독립적인 공간에 저장된다.
    		//new연산자 없이 선언된 String 객체는 "String 저장소"라는 공간에 저장된다.
    		//저장소에서 없으면 생성을 함, 그러나 동일한 문자열이 같이 사용" -> 의미가? 
    		//따라서 출력을 할 경우 ㄴ3와 s4의 주솟값만 같다는 결과가 나온다.
    		
    		System.out.println(System.identityHashCode(s1));
    		System.out.println(System.identityHashCode(s2));
    		System.out.println(System.identityHashCode(s3));
    		System.out.println(System.identityHashCode(s4));
    		//직접 출력해서 어디 저장되는지 확인할 수 있다. 값이 절대적이진 않고 pc마다 상이할 수 있음.
    		
    		//equals 메소드는 "객체 내용"을 비교한다.
    		if(s1.equals(s2))
    			System.out.println("true");
    		if(s1.equals(s3))
    			System.out.println("true");
    		if(s3.equals(s4))
    			System.out.println("true");
    		
    		//대소문자 구분 없이 비교
    		String s5 = "APPLE";
    		String s6 = "apple";
    		if(s5.equalsIgnoreCase(s6))
    			System.out.println("대소문자 구분 없이 비교 : true");
    		
    	}
    
    }
    ```
    
    ```jsx
    package ch06;
    
    public class StringEx2 {
    
    	public static void main(String[] args) {
    		String s1 = "Java Programming";
    		int len = s1.length();
    		System.out.println("문자열 길이 : " + len);
    		System.out.println("대문자 : " + s1.toUpperCase());
    		System.out.println("소문자 : " + s1.toLowerCase());
    		
    		String s2 = s1.substring(5);
    		String s3 = s1.substring(5, 10);
    		System.out.println(s2);
    		System.out.println(s3);
    		
    		char c1 = s1.charAt(8);
    		System.out.println(c1);
    		for (int i = 0; i < len; i++) {
    			if(i%2==0)
    				System.out.print(s1.charAt(i));
    		}
    		System.out.println("\n--------------------");
    		
    		//첫 a의 자리값
    		int idx1 = s1.indexOf('a');
    		System.out.println("idx1 : " + idx1);
    		
    		//마지막 a의 자릿값
    		int idx2 = s1.indexOf('a');
    		System.out.println("idx2 : " + idx2);
    		
    		String s4 = s1.replace('a', 'q');
    		System.out.println(s4);
    		
    		for (int i = 0; i < len; i++) {
    			if(s1.charAt(i)=='a')
    				System.out.print('k');
    			else
    				System.out.println(s1.charAt(i));
    		}
    		System.out.println("\n--------------------");
    		
    		//문자열을 특정 문자를 기준점 삼아 쪼개서 배열로 만듦.
    		String s5 = "Java&JSP&Android&Spring";
    		String s6[] = s5.split("&");
    		for (int i = 0; i < s6.length; i++) {
    			System.out.println(s6[i]);
    		}
    		
    		String s7 = "   JSPStudy   ";
    		//앞쪽 뒤쪽 공백 제거 기능
    		System.out.println("***"+s7.trim() +"***");
    		
    		
    	}
    
    }
    ```
    
    - 문제풀이
        
        ```jsx
        package ch06;
        
        public class StringEx3 {
        
        	public static void main(String[] args) {
        		String s1 = "전지현이가 백화점에서 팬사인회를 연다."
        		        + "전지현은 5일 오후 3시 서울 소공동 롯데 백화점"
        		        + " 8층 이벤트홀에서... 구두 브랜드 조이제화의" 
        		        + " 홍보를 위한 팬사인회에 참석한다.";
        		
        		int len = s1.length();
        		System.out.println(len);
        		//문제1. s1의 앞에서부터 빈칸 자릿값을 출력하세요.(indexOf)
        		//5, 11, 17...
        		//문제2. s1의 뒤에서부터 빈칸 자릿값을 출력하세요.(lastIndexOf)
        				//87, 81, 78
        				
        		
        		//indexOf를 안 쓴 예제
        		
        		for (int i = 0; i < len; i++) {
        			if(s1.charAt(i) ==' ')
        				System.out.print(i+", ");
        		}
        		System.out.println("");
        		
        		for (int i = len-1; i>=0; i--) {
        			if(s1.charAt(i) ==' ')
        				System.out.print(i+", ");
        		}
        		System.out.println("");
        		
        		
        		//indexOf를 쓴 예제
        		
        		int idx = -1;
        		do {
        			idx = s1.indexOf(' ', idx+1);
        			if(idx>=0) 
        				System.out.print(idx + ", ");
        				//조건에 맞는 위치값이 더 이상 없을때 idx가 -1이 리턴된다.(왜지?)
        				//아무튼 그래서 반복문은 종결.
        		} while (idx>=0);
        		System.out.println("");
        		
        		
        		int ldx = len;
        		do {
        			ldx = s1.lastIndexOf(' ', ldx-1);
        			if(ldx>=0) 
        				System.out.print(ldx + ", ");
        		} while (ldx>=0);
        		System.out.println("");
        		
        		
        		
        		
        		//문제3. 빈칸을 '_'로 출력
        		String s2 = s1.replace(' ', '_');
        		System.out.println(s2);
        		
        		//문제4. 첫 단어를 출력
        		//문제5. 마지막 단어를 출력
        		
        		//나의 답변
        		String s1Arr[] = s1.split(" ");		
        		System.out.println("첫 번째 단어 : " + s1Arr[0]);
        		System.out.println("마지막 단어 : " + s1Arr[s1Arr.length - 1]);
        		
        		//모범답안
        		String s3 = s1.substring(0, s1.indexOf(' '));
        		System.out.println(s3);
        		
        		String s4 = s1.substring(s1.lastIndexOf(' ')+1, len);
        		System.out.println(s4);
        		
        	}
        
        }
        ```
        
- StringBuffer 클래스
    
    왜 필요한가?
    
    ”여러 개의 리터럴 생성을 방지한다.”
    
    String의 치명적 단점 : 한번 문자열 값이 지정되면, (엄밀한 의미로) 값을 수정할 수 없다.
    가령 다음과 같이 코드를 친다면...
    
    ```java
    String str = "abc";
    str += "efg";
    ```
    
    → 기존 abc가 abcefg로 바뀐다(x)
    
    → 기존 abc를 놔두고 새로운 abcefg라는 문자열이 따로 만들어진다.
    
    ”리터럴 값이 2개가 만들어지게 된다.”
    
    왜 이렇게 만들어 놨죠?
    
    ```java
    str1 = “abc”;
    
    str2 = "abc";
    //두 변수가 같은 ~~~를 참조하고 있다. 배운 내용 복습 한번 드가자.
    
    //이 때...
    str1 += "efg";
    //라고 했을 때, 
    //같은 ~~~를 참조하는 두 변수 중 str1 값만 영구히 수정해 버리면 str2는 붕 떠버린다.
    //이를 방지하기 위함이다.
    ```
    
    다음처럼 리터럴이 여러 가지 나올 상황에 StringBuffer 쓰는 게 권장되어 왔다.
    
    - “**반복문**에 문자열을 쓰게 될 때.”
    - 또?
    
    관련 기능
    
    ```jsx
    package ch06;
    
    public class StringBufferEx {
    
    	public static void main(String[] args) {
    		String str = "Java";
    		str += "Programming";
    		
    		StringBuffer sb = new StringBuffer("Java");
    		sb.append(" Programming");
    		System.out.println(sb);
    		sb.replace(0, 4, "Android");
    		System.out.println(sb);
    		sb.deleteCharAt(0);
    		System.out.println(sb);
    		sb.reverse();
    		System.out.println(sb);
    		
    		
    	}
    ```
    
- StringTokenizer 클래스
    
    <aside>
    💡 The string tokenizer class allows an application to break a string into **token**s. The tokenization method is much simpler than the one used by the `StreamTokenizer`
     class. The `StringTokenizer`
     methods do not distinguish among identifiers, numbers, and quoted strings, nor do they recognize and skip comments.
    
    </aside>
    
    ```jsx
    package ch06;
    
    import java.util.StringTokenizer;
    
    public class StringTokenizerEx {
    
    	public static void main(String[] args) {
    		String str = "Java JSP Android Spring";
    		StringTokenizer st = 
    				new StringTokenizer(str);
    		int a = st.countTokens();
    		System.out.println("토큰갯수 : " + a);
    		
    		while(st.hasMoreElements()) {
    			//요소가 더 남았나?
    			
    			System.out.println(st.nextElement());
    			//다음 요소를 출력하고, 다시 요소가 더 남았는지를 판단. 
    		}
    		String arr[] = new String[st.countTokens()];
    		for (int i = 0; i < arr.length; i++) {
    			System.out.println(111);
    			arr[i] = st.nextToken();
    			System.out.println(arr[i]);
    		}
    		
    		System.out.println("------------------------");
    		String str2 = "서울;인천,대전,부산;광주,대구";
    		StringTokenizer st2 = new StringTokenizer(str2, "; ");
    		String arr2[] = new String[st2.countTokens()];
    		for (int i = 0; i < arr2.length; i++) {
    			arr2[i] = st2.nextToken();
    			System.out.println(arr2[i]);
    		}
    		
    	}
    
    }
    ```
    
