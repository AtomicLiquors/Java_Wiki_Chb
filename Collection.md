https://github.com/JaeYeopHan/Interview_Question_for_Beginner/tree/master/Java#jvm-%EC%97%90-%EB%8C%80%ED%95%B4%EC%84%9C-gc-%EC%9D%98-%EC%9B%90%EB%A6%AC
# 컬렉션 
가변적인 저장소 

요소(element, 가변 개수의 객체)의 저장소.
- 배열과 다르게 객체를 보관하기 위한 공간을 미리 정하지 않아도 된다.  
-  = 상황에 따라 객체의 수를 동적으로 정할 수 있다.   
-  = 프로그램의 공간적인 효율성 또한 높여준다.
- 또한 배열과 달리 항목들의 타입이 동일하지 않아도 된다.

내부의 한 객체가 사라지면, 자리를 자동으로 옮겨준다.

&nbsp;  

예시)
Java Collection 에는 List, Map, Set 인터페이스를 기준으로 여러 구현체가 존재한다. 이에 더해 Stack과 Queue 인터페이스도 존재한다. 왜 이러한 Collection 을 사용하는 것일까?   
그 이유는 다수의 Data 를 다루는데 표준화된 클래스들을 제공해주기 때문에 DataStructure 를 직접 구현하지 않고 편하게 사용할 수 있기 때문이다.     

List
List 인터페이스를 직접 @Override를 통해 사용자가 정의하여 사용할 수도 있으며, 대표적인 구현체로는 ArrayList가 존재한다. 이는 기존에 있었던 Vector를 개선한 것이다. 이외에도 LinkedList 등의 구현체가 있다.
Map
대표적인 구현체로 HashMap이 존재한다. (밑에서 살펴볼 멀티스레드 환경에서의 개발 부분에서 HashTable 과의 차이점에 대해 살펴본다.) key-value 의 구조로 이루어져 있으며 Map 에 대한 구체적인 내용은 DataStructure 부분의 hashtable 과 일치한다. key 를 기준으로 중복된 값을 저장하지 않으며 순서를 보장하지 않는다. key 에 대해서 순서를 보장하기 위해서는 LinkedHashMap을 사용한다.
Set
대표적인 구현체로 HashSet이 존재한다. value에 대해서 중복된 값을 저장하지 않는다. 사실 Set 자료구조는 Map 의 key-value 구조에서 key 대신에 value 가 들어가 value 를 key 로 하는 자료구조일 뿐이다. 마찬가지로 순서를 보장하지 않으며 순서를 보장해주기 위해서는 LinkedHashSet을 사용한다.
Stack 과 Queue
Stack 객체는 직접 new 키워드로 사용할 수 있으며, Queue 인터페이스는 JDK 1.5 부터 LinkedList에 new 키워드를 적용하여 사용할 수 있다. 자세한 부분은 DataStructure 부분의 설명을 참고하면 된다.



따라서 그 크기도 가변적이다.


    
    - 컬렉션 — 벡터Vector
        
        ```jsx
        package ch07;
        
        import java.util.Vector;
        
        public class VectorEx1 {
        
        	public static void main(String[] args) {
        		//저장되는 요소 유형은 자유, 크기도 유동적 : 그것이 벡터를 비롯한 "콜렉션"의 장점이다.
        		Vector vec = new Vector();
        		System.out.println(vec.size()); //요소의 개수
        		System.out.println(vec.capacity()); //공간의 개수(...?) 사용은 잘 안 합니다.
        		//방은 빼더라도, 공간은 남는다.
        		
        		vec.add(new String("하하"));
        		vec.add(22); 
        		//원래는 int형 저장 안 됩니다. Object타입이어야 됩니다.
        		//그럼에도 되는 것은? Integer로 오토박싱이 이루어졌기 때문.
        		
        		vec.add("노르웨이");		
        		//add는 저장 여부를 Boolean으로 리턴.
        		//addElement는 그냥 저장.
        		System.out.println(vec.size());
        		System.out.println(vec.capacity());
        		for (int i = 0; i < vec.size(); i++) {
        			System.out.println(vec.get(i));
        		}
        		
        	}
        
        }
        ```
        
        ```jsx
        package ch07;
        
        import java.util.Vector;
        
        public class VectorEx2 {
        	public static void main(String[] args) {
        		String str[] = {"노르웨이","스위스","뉴질랜드","덴마크","캐나다"};
        		//배열에 저장된 문자열을 2개의 Vector에 저장
        				
        		Vector vec1 = new Vector();
        		//제네릭의 장점1 : Vector에서 어떤 요소를 저장할지 파악이 쉽다.
        		
        		Vector<String> vec2 = new Vector<String>();
        		//예컨대 여기서는 "String이 저장이 된다"라고 파악이 된다는 것이다.
        		for (int i = 0; i < str.length; i++) {
        			vec1.add(str[i]);
        			vec2.add(str[i]);
        		}
        		
        		for (int i = 0; i < vec1.size(); i++) {
        			//Vector 바구니에서 어떤 걸 꺼낼지 알 수가 없기 때문에 String이라고 캐스팅.
        			String st1 = (String)vec1.get(i);
        			System.out.println(st1);
        			//제네릭의 장점 2: vec2 바구니는 처음부터 String 지정을 했다. 캐스팅할 필요가 없다.
        			String st2 = vec2.elementAt(i);
        			System.out.println(st2);
        		}
        		
        		//제네릭은 int가 안 된다. Object타입인 Integer여야만 한다.
        		int arr[] = {10, 20, 30, 40, 50};
        		Vector<Integer> vec3 = new Vector<Integer>();
        		for (int i = 0; i < arr.length; i++) {
        			vec3.add(arr[i]); //자동으로 Integer 변환되어 저장 <- 오토박싱
        			Integer it = vec3.get(i);
        			System.out.println(it);
        		}
        	}
        }
        ```
        
        ```jsx
        package ch07;
        
        import java.util.Vector;
        
        public class VectorEx3 {
        
        	public static void main(String[] args) {
        		Vector vec = new Vector(4, 3);
        		System.out.println(vec.capacity());
        		for (int i = 0; i < 10; i++) {
        			vec.add(i*10);
        		}
        		System.out.println(vec.size()); 
        		System.out.println(vec.capacity()); //유동적으로 최대 크기가 조절되었다.
        		
        		System.out.println("첫번째 요소 : " + vec.firstElement());
        		System.out.println("마지막 요소 : " + vec.lastElement());
        		System.out.println("두번째 요소 : " + vec.elementAt(1));
        		System.out.println("비어있는지 여부 : " + vec.isEmpty());
        		vec.remove(2);
        		for (int i = 0; i < vec.size(); i++) {
        			System.out.println(vec.get(i));
        		}
        		
        		System.out.println(vec.size()); //9개
        		System.out.println(vec.capacity()); //10개
        		if(vec.contains(new Integer(30))) {
        			System.out.println("30이 있네요!");
        		}
        		System.out.println(vec.indexOf(40));
        		vec.trimToSize();//빈 공간 제거
        		System.out.println(vec.size()); //9개
        		System.out.println(vec.capacity()); //9개
        		
        		vec.removeAllElements();//모든 요소 지우기
        		System.out.println(vec.size()); //0개
        		System.out.println(vec.capacity()); //9개
        	}
        
        }
        ```
        
    - ArrayList
    - HashMap
        
        ```jsx
        package ch07;
        
        import java.util.Enumeration;
        import java.util.HashMap;
        import java.util.Hashtable;
        
        public class HashMapEx1 {
        	
        	/* 이번 예제만 잘 이해해도 제네릭, 콜렉션 사용하는데 전혀 문제 없습니다.
        	 * 교재가 설명을 어렵게 해 놨는데, 스킵하셔도 됩니다. */
        	
        	public static void main(String[] args) {
        		//제네릭의 첫 매개변수는 키값, 두번째는 요소값
        		//hash.put(key, value)라고 보면 되겠다.
        		//put은 순차적으로 차곡차곡 넣는 add보다는 주머니에 무질서하게 집어넣는 방식이다.  
        		
        		HashMap<String, String> hash = 
        				new HashMap<String, String>();
        		hash.put("사과", "Apple");
        		hash.put("포도", "Grapes");
        		hash.put("딸기", "Strawberry");
        		System.out.println(hash.size());
        		
        		hash.put("딸기", "Erdbeeren");
        		System.out.println(hash.size());
        		System.out.println(hash.get("딸기"));
        		hash.remove("사과");
        		
        		hash.put("멜론", "Melon");
        		hash.put("수박", "WaterMelon");
        		System.out.println(hash.size());
        		//////////////////////////////////////////
        		
        		Hashtable<String, String> ht = 
        				new Hashtable<String, String>();
        		hash.put("사과", "Apple");
        		hash.put("포도", "Grapes");
        		hash.put("딸기", "Strawberry");
        		//Enumeration: 줄줄이 사탕처럼 key를 가져온다.
        		Enumeration<String> e = ht.keys();
        		while(e.hasMoreElements()) {
        			String key = e.nextElement();
        			String value = ht.get(e.nextElement());
        			System.out.println(key+ " : " + value);
        		}
        		
        	}
        
        }
        ```
        

- 가변인수
    
    ```jsx
    package ch06;
    
    public class WrapperEx4 {
    	public static void plus(int a, int b) {
    		System.out.println(a+b);
    	}
    	
    	public static void plus(int a, int b, int c) {
    		System.out.println(a+b+c);
    	}
    	
    	//...2개, 3개 까지는 했는데 4개, 5개까지 계속 이렇게 할 건가?
    	
    	/*가변인수 : 자동적으로 "배열"이 되는, 갯수가 유동적인 인수*/
    	public static void vplus(int...arr) {
    		int sum = 0;
    		for (int i = 0; i < arr.length; i++) {
    			sum += arr[i];
    		}
    		System.out.println(sum);
    		
    	}
    	
    	public static void main(String[] args) {
    		vplus(1);
    		vplus(1, 2, 3);
    		vplus(1, 2, 3, 4, 5, 6, 7, 8);
    		
    		int a = 10, b = 20, c = 30;
    		System.out.printf("%d + %d = %d", a, b, c);
    			
    	}
    }
    ```
    
