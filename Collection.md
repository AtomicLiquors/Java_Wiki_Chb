- 컬렉션 : 가변적인 저장소
    
    요소(element, 가변 개수의 객체)의 저장소.
    따라서 그 크기도 가변적이다.
    한 객체가 사라지면, 자리를 자동으로 옮겨준다.
    
    이는 크기가 고정되고, 불변인 배열에서는 할 수 없던 것.
    또한 배열은 항목들의 타입이 동일해야 하므로 배열과도 차이가 있다.
    
    컬렉션은 제네릭 기법으로 구현된다.
    
    제네릭 기법 : “여러 종류의 타입을 특정한 타입으로 통일해주는 것.”
    — 교재의 설명은 거꾸로 됐습니다.
    
    강의 설명은 좀 뒤에 하겠습니다.
    
    제네릭은... 내가 저장해야 될 타입만 미리 정하면 되겠구나. 라고 생각하세요ㅗ.
    
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
    