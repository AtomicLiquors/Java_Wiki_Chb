# Java

[https://docs.oracle.com/en/java/javase/11/docs/api/](https://docs.oracle.com/en/java/javase/11/docs/api/)

이거 보고 내가 원하는 거 만들 줄 알면 문법은 뗐다고 보면 됩니다.

새 클래스 생성할 때 superclass 란에 패키지명.클래스명을 기입해 상위클래스를 미리 설정할 수 있다. 

DB연동, AWT예제, IO, 네트워크 소켓

- 스레드를 많이 쓰지는 않지만.. 반드시 알아야 됩니다.
    
    스레드를 대체할 기능은 없어요.
    써야할 시점에선 반드시 써야 합니다.
    
    “멀티태스킹”
    
    - 스레드 동기화 : ”스레드 사이의 실행 순서를 제어한다.”
        
        동시에 계산하면 계산이 정확하게 되지 않는 경우, 
        동기화를 통한 실행순서 제어가 필요하다.
        
- 예외처리
    
    예외: 문법적으로는 오류가 없지만 콘솔에서는 Exception으로 뜬다.
    자바는 예외들도 따로 클래스로 만들어놨다.
    
- 데이터베이스
    
    heidisql 커맨드 화면 가독성. 맞어?
    
    MYSQL 포트번호 3306
     → Troubleshooting: 포트 번호를 누가 쓰고 있다고 뜨면?
    명령 프롬프트 > 
    netstat -a 
    netstat -na
    작업 관리자 > 서비스 
    ...등을 찾아보다가 결국 못 찾아서 번호를 바꿨다.
    포트 번호는 나중에 바꿀 수 있다고 함.
    
    계정 비번 : 1234
    
    계정 : root/1234
    (계정은 대소문자 구분 안한다.)
    
    “여러 사람이 공유하여 사용할 목적으로 체계화된 대용량 데이터 집합.”
    댓글을 달고, 게시판에 글 쓰고, 회원가입하고...
    DB 서버에 저장이 되는 것.
    
    MySQL 잘하면 Oracle 따라옵니다. Microsoft SQL 서버도요.
    Oracle이 먹고 변질된 MYSQL 보고 만든게 MariaDB., 개발자 입장에서 두 개가 흡사해.
    
    auto increment : 1씩 증가한다.
    
    레코드 : 각 행에 입력된 일련의 정보라고 이해했다.
    
    쿼리 실행 드래그 → 선택 실행
    
    - 쿼리문
        
        
        select * from
        
        INSERT tblName (attr1, attr2, attr3, attr4)
        VALUES ('연호주', '010-4***-2***', '벽산아파트','도서부');
        
        Update
        
        delete from
        
        CREATE 예시
        
        ```sql
        CREATE TABLE tblMember(
         	id int AUTO_INCREMENT PRIMARY KEY,
         	name char(20) NOT NULL,
         	phone char(20) NOT NULL,
           address char(50) NOT NULL,
         	team char(20) NOT NULL   
        )COLLATE='utf8_general_ci'
        ENGINE=InnoDB;
        ```
        
    
    - 자바와 연결
        
        자바에서는 MySQL, 오라클 등이 각각 제공하는 드라이버 클래스가 필요하다.
        .Java Build Path  → Add (...) JARS → 
        
    

System.exit(0); //정상종료
System.exit(1); //비정상종료 입니다.

사실 단일프로그램에서 종료 0은 의미가 없어요.
복합적으로 만들면 하나가 종료될 때 다른 프로그램에 매개변수로 0 또는 1이 넘어갑니다.

이벤트객체, 이벤트소스, 이벤트리스너 : 

[https://www.myheritage.co.kr/photo-enhancer/result/1311645222-500001](https://www.myheritage.co.kr/photo-enhancer/result/1311645222-500001)

미디어 

cpu → 계산 능력

메모리 → 기억력

HDD → 쪽지라고 하는데 필기노트보다 가벼운 느낌인가?

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
    

- 클래스
    
    ## 개념
    
    - 클래스 : 객체를 찍어내는 틀
    - 객체 : 고유한 특성*state*과 행동*behavior*을 갖는 모든 것. 클래스에 의해 생성되는 결과물
    - 필드 : 속성
    - 메소드 : 객체가 반복하여 수행하는 기능을 서술한 것
    
    - class는 어디에 위치하는가?
    
    ```java
    jre library > java.base > java.lang
    
    C:\Java\jdk-11.0.13\lib\src.zip // 자바 원소스 압축파일
    ```
    
    - 개발자가 만든 .java 파일은 JVM이 읽을 .class 파일로 컴파일된다.
    - 객체는 메모리에 생성되고, 객체 이름은 이를 가리키는(reference) 역할이다.
    그래서 객체 이름을 “레퍼런스 변수”라고 부른다.
    
    - Java의 최상위 클래스는 “Object”클래스.
        
        ![Untitled](Java%202da56/Untitled.png)
        
        ![Untitled](Java%202da56/Untitled%201.png)
        

- 더블클릭 > alt shitf T(Refactor) > Rename ‘변수명 동시에 바꾸기”
    
    ![Untitled](Java%202da56/Untitled%202.png)
    

- GUI
    
    ### awt
    
    못생겼다. 
    그러나 awt가 swing의 전신이고, 안드로이드 GUI의 기반기술이며,
    swing부터 배우면 어려우므로 먼저 배워둬야 된다.
    
    awt틀(배치관리)과 awt 이벤트
    
    Abstract Windows(OS 윈도우) Toolkit
    약점은... 맥, 솔라리스, 리눅스 등 OS끼리 차이가 있다.
    
    Swing은 그 단점을 보완한다.
    
    ### swing
    
    SUN이 Adobe한테 의뢰해서 만든 거. 
    
    - 챕터 8 정리하세요.
        - 라벨 예제
            
            ```jsx
            package ch08;
            
            import java.awt.Color;
            import java.awt.Label;
            
            import ch05.MColor;
            
            public class LabelEx extends MFrame{
            	
            	/*필드 선언하는 이유 : 
            	 * 1. 객체 속성
            	 * 2. 메소드 공유
            	 */
            	Label label1, label2, label3, label4;
            	
            	public LabelEx() {
            		super(200, 200);
            		setTitle("Label Example");
            		String str = "Tuesday Today";
            		label1 = new Label(str);
            		label2 = new Label(str, Label.CENTER);
            		label3 = new Label(str, Label.RIGHT);
            		label4 = new Label(str, Label.LEFT);
            		
            		label1.setBackground(Color.RED);
            		label1.setForeground(Color.YELLOW);//글자색.
            		
            		Color c[] = MColor.rColor2();
            		label2.setBackground(c[0]);
            		label2.setForeground(c[1]);
            		//랜덤 색상인가? 해당 색상의 상대적인 '보색'을 사용.
            		
            		//add: Frame(대표적인 컨테이너)에 추가하겠다.
            		add(label1);
            		add(label2);
            		add(label3);
            		add(label4);
            	}
            	
            	public static void main(String[] args) {
            		new LabelEx();
            	}
            }
            ```
            
        - 버튼 예제
            
            ```jsx
            package ch08;
            
            import java.awt.Button;
            import java.awt.Color;
            
            import ch05.MColor;
            
            public class ButtonEx extends MFrame {
            	
            	Button btn[] = new Button[4];
            	String str[] = {"추가", "삭제", "전체삭제", "종료"};
            	
            	public ButtonEx() {
            		super(250, 250);
            		setTitle("Button Example");
            		for (int i = 0; i < btn.length; i++) {
            			btn[i] = new Button(str[i]);
            			Color c[] = MColor.rColor2();
            			btn[i].setBackground(c[0]);
            			btn[i].setForeground(c[1]);
            			add(btn[i]);
            		}
            	}
            	
            	
            	public static void main(String[] args) {
            		new ButtonEx();
            	}
            }
            ```
            
        - 초이스 예제
            - 예제 1)
                
                ```jsx
                package ch08;
                
                import java.awt.Choice;
                import java.awt.Color;
                
                import ch05.MColor;
                
                public class ChoiceEx1 extends MFrame {
                	//html의 폼 같은 기능을 가진 컴포넌트.
                	
                	String city[] = {"도시를 선택하세요.","베를린","파 리",
                			"하와이","런 던","평 양","뉴 욕"};
                	
                	Choice ch;
                	
                	public ChoiceEx1() {
                		//super(300, 300, new Color(100, 200, 100)); //색상 지정
                		super(300, 300, MColor.rColor()); //배경색도 랜덤
                		setTitle("Choice 예제1");
                		
                		ch = new Choice();
                		for (int i = 0; i < city.length; i++) {
                			ch.add(city[i]);
                		}
                		Color c[] = MColor.rColor2();
                		ch.setBackground(c[0]);
                		ch.setForeground(c[1]);
                		add(ch);
                	}
                
                	public static void main(String[] args) {
                		new ChoiceEx1();
                	}
                
                }
                ```
                
            - 예제 2)
                
                ```jsx
                package ch08;
                
                import java.awt.Choice;
                import java.awt.Color;
                import java.awt.Graphics;
                import java.awt.Label;
                import java.awt.event.ItemEvent;
                import java.awt.event.ItemListener;
                
                public class ChoiceEx2 extends MFrame implements ItemListener {
                
                	Choice air, city;
                	String sair[] = { "대한항공", "아시아나", "에어부산", "진에어" };
                	String scity[] = { "서 울", "대 전", "대 구", "부 산", "제주도" };
                
                	public ChoiceEx2() {
                		super(300, 300, new Color(100, 200, 100)); // 색상 지정
                		setTitle("Choice 예제2");
                		air = new Choice();
                		city = new Choice();
                		for (int i = 0; i < sair.length; i++) {
                			air.add(sair[i]);
                		}
                		for (int i = 0; i < scity.length; i++) {
                			city.add(scity[i]);
                		}
                		add(air);
                		add(city);
                		add(new Label("항공사와 도시를 선택하세요."));
                		air.addItemListener(this);
                		city.addItemListener(this);
                		
                	}
                
                	@Override
                	public void itemStateChanged(ItemEvent e) {
                		repaint();
                	}
                
                	@Override
                	public void paint(Graphics g) {
                		g.setColor(Color.BLUE);
                		String str = "항공사 선택 : " + air.getSelectedItem();
                		g.drawString(str, 30, 120);
                		// 붓이다. x좌표와 y좌표를 지정해준다.
                		// 프로그램은 왼쪽 위가 원점이다.
                		// 해당 위치에 "항공사 선택 : ~"라는 내용을 그려줘라.
                		g.setColor(Color.RED);
                		str = "목적지 선택 : " + city.getSelectedItem();
                		g.drawString(str, 30, 150);
                	}
                
                	public static void main(String[] args) {
                		new ChoiceEx2();
                	}
                
                }
                ```
                
        - 각종 레이아웃 예제
            
            
            ㅁㄴㅁㄴㄻㄹ
            
        - 패널 예제
            
            ```jsx
            package ch08;
            
            import java.awt.BorderLayout;
            import java.awt.Button;
            import java.awt.Color;
            import java.awt.Label;
            import java.awt.Panel;
            
            import ch05.MColor;
            
            public class PanelEx extends MFrame {
            	
            	Label label[];
            	Button btn[];
            	String str1[] = {"첫번째", "두번째", "세번째"};
            	String str2[] = {"Start", "Stop", "End"};
            	Panel p1, p2;
            
            	public PanelEx() {
            		setTitle("Panel 예제");
            		setLayout(new BorderLayout());
            		p1 = new Panel();
            		p2 = new Panel();
            		label = new Label[3];
            		btn = new Button[3];
            		
            		for (int i = 0; i < btn.length; i++) {
            			p1.add(label[i] = new Label(str1[i])); 
            			p2.add(btn[i] = new Button(str2[i])); 
            		}
            		p1.setBackground(MColor.rColor());
            		p2.setBackground(MColor.rColor());
            		add (p1, BorderLayout.NORTH);
            		add (p2, BorderLayout.SOUTH);
            		validate();
            	}
            
            	public static void main(String[] args) {
            		new PanelEx();
            	}
            
            }
            ```
            
        
    
- 개념
    
    <aside>
    💡 **smallest elements of a program which are identified by the compiler
    컴파일러가 인식 가능한 최소한의 프로그램 요소 단위**
    . Tokens in java include identifiers, keywords, literals, operators and, separators.
    
    </aside>
    
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
    

jdk표준 자바 패키지 구조 : rt.jar에서 rt.jar를 x표 쳤다. 그게 무슨 의미냐?

- 상속
    
    ```jsx
    /*
    class A3{}
    class B3{}
    class C3 extends A3, B3{} ->여러 개의 클래스로부터 상속받을 수는 없다.
    */
    
    class A3{}
    class B3 extends A3{}
    class C3 extends B3{} 
    //부모는 하나뿐. 자바 상속 구조를 명확히 하기 위함이다.
    ```
    

- 업캐스팅 : 형변환
    
    ㄴshort 변수는 int로 아무 손실없이 변환 가능하다.
     short가 가진 모든 값들은 int가 감당할 수 있다.
    
    int변수가 short로 변환하는 것은 손실이 일어날 수도 있다.
    int변수의 일부 값은 short범위보다 큰 값이기 때문이다.
    
    ```jsx
    package ch05;
    
    public class CastingEx1 {
    	public static void main(String[] args) {
    		System.out.println(Short.MAX_VALUE);
    		System.out.println(Short.MIN_VALUE);
    		//short가 갖는 최댓값을 알아보자.
    		
    		short s1 = 100;
    		int i1 = s1;
    		System.out.println(i1);
    		
    		int i2 = 200;
    		//Short s2 = i2; //묵시적 형변환을 시도하면 오류가 난다.
    		Short s2 = (short)i2; //명시적, 강제적 형변환을 시도할 경우 
    		System.out.println(s2); //크기가 작으면 문제는 없지만
    		
    		int i3 = 33000;
    		short s3 = (short)i3;
    		System.out.println(s3); //short의 최대 크기를 넘어서면 값이 망가진다.
    	}
    }
    ```
    
    ```jsx
    32767
    -32768
    100
    200
    -32536
    ```
    
    ```jsx
    package ch05;
    
    class Person2{
    	String name;
    	Person2(String name){
    		this.name = name;
    		
    	}
    }
    
    class Student2 extends Person2{
    	String grade;
    	Student2(String name) {
    		super(name);
    	}
    }
    
    public class CastingEx2 {
    	public static void main(String[] args) {
    		Person2 p1; //변수만 선언
    		Student2 s1 = new Student2("홍길동");
    		p1 = s1; //에러가 안 났죠?
    		//객체는 아무리 업캐스팅, 다운캐스팅해도 "불변"이다.
    		System.out.println(p1.name);
    		//System.out.println(p.grade); //불가능. 당연하다지만 왜 당연한지 이해해라.
    		
    		Student2 s2;
    		Person2 p2 = new Person2("강호동");
    		//다운캐스팅(컴파일은 성공하지만, 실행은 에러가 된다.)
    		s2 = (Student2)p2; 
    		s2.grade = "A";
    		System.out.println(s2.grade); 
    		//다운캐스팅, 업캐스팅은 OCJP 단골문제다.
    		
    	}
    }
    ```
    
    ```jsx
    package ch05;
    
    import java.util.Vector;
    
    public class CastingEx3 {
    	public static void main(String[] args) {
    		//문법적으로 캐스팅의 실무적인 예제.
    		Vector v = new Vector();
    		//벡터는 객체를 담는 주머니 되시겠다.
    		String s = new String("테스트");
    		v.addElement(s); //매개변수 타입이 Object이기 때문에 모든 객체 저장 가능
    		
    		String s1 = (String)v.get(0); //명시적 형변환을 시켰을 때 빨간줄이 안 그인다.
    		System.out.println(s1);
    	}
    }
    ```
    
- Auto Boxing
    
    사실 코딩할 땐 이런 개념이 잘 생각 안 납니다. 그냥 저장 되니까 넣어요. 알고는 갑시다.
    
    ```jsx
    package ch06;
    
    import java.util.Vector;
    
    public class WrapperEx3 {
    	public static void main(String[] args) {
    		//자바기본형과 Wrapper클래스 간의 자동 변환.
    		
    		int n1 = 10;
    		Integer it1 = n1;
    		//int형에서 Integer형으로 변환된 것이다 (auto boxing)
    		//원래 이렇게 안 됐었는데, 워낙 빈번해서 5버전부터 자동으로 되게 반영되었다. 
    		
    
    		Integer it2 = Integer.valueOf(20);
    		int n2 = it2;
    		//반대로 Integer형으로 int형으로 변환된 것이다 (auto unboxing)
    		
    		Vector v = new Vector(); //객체를 저장하는 클래스가 벡터다.
    		int n3 = 20;
    		v.addElement(20);
    		//addElement에는 원래 자바 기본형 데이터를 못 넣는다.
    		//n3가 저장될 때 자동으로 Integer타입으로 autoboxing 되었다.
    		//그래서 여기에도 20을 바로 넣을 수 있게 됐다. 
    		
    		int n4 = (Integer)v.get(0);
    		//인트 언박싱.
    	}
    }
    ```
    
- 메소드 오버라이딩
    
    ```jsx
    package ch05;
    
    class A1{
    	void prn1() {}
    	void prn2(String name) {}
    }
    
    class B1 extends A1{
    	@Override
    	void prn1() {
    		super.prn1(); //부모의 메소드를 호출하고, 추가적으로 기능을 넣는 경우
    	}
    	
    	@Override
    	void prn2(String name) {}//처음부터 재정의하는 경우
    	void prn3() {}
    }
    
    public class OverrideEx1 {
    
    }
    ```
    
    ```jsx
    package ch05;
    
    class Animal{
    	void move() {
    		System.out.println("동물아 움직여라~~~~");
    	}
    }
    
    //애니멀 상속받고 메소드 오버라이딩.
    class Bird extends Animal{
    	void move() {
    		System.out.println("날아라~");
    	}
    }
    class Fish extends Animal{
    	void move() {
    		System.out.println("헤엄쳐라~");
    	}
    }
    
    class Cheetah extends Animal{
    	void move() {
    		System.out.println("달려라~");
    	}
    }
    
    public class OverrideEx2 {
    	public static void main(String[] args) {
    		Animal ani[] = new Animal[3];
    		//new가 있어서 헷갈릴 수 있는데 Animal 객체를 만든 게 아니고, 배열을 3개 만든 것.
    		ani[0] = new Bird();
    		ani[1] = new Fish();
    		ani[2] = new Cheetah();
    		
    		
    		for (int i = 0; i < ani.length; i++) {
    			ani[i].move();
    		}
    		//동적 바인딩 : 동적으로 하위 클래스의 오버라이딩 된 메소드를 호출했다.
    		//어떤 메소드에 매개변수로 하위 클래스가 들어올 때 동적으로 메소드를 호출하는 목적이다.
    	}
    }
    ```
    
- 추상 클래스, 인터페이스
    
    문법은 비슷하지만, 전혀 다릅니다.
    
    우리가 직접 만들 일은 없지만, 
    SUN에서 제공하는 등 기존에 있는 것을 갖다 쓸 일은 많다.
    
    그러려면? 원리를 이해하고 갖다 쓸 줄을 알아야지.
    
    **추상 클래스**
    
    객체를 만들 수 없는 클래스.
    상속을 해서 
    
    ```jsx
    package ch05;
    
    //추상 클래스 선언
    abstract class Abstract1{
    	//추상메소드 : 추상클래스를 상속받는 클래스는 "강제"적으로 오버라이딩해야 한다. 이해보다는 일단 인지를 합시다.
    	abstract void prn(); //선언부만 존재
    }
    
    class Normal1 extends Abstract1{
    	@Override
    	void prn() {
    	}
    	//추상클래스를 상속받는 틀만 만들어 놓으면 에러가 뜬다.
    	//오버라이딩을 시켜야 에러가 사라진다.
    	//ctrl space를 누르면 제일 먼저 오버라이딩부터 뜬다.
    }
    
    public class AbstractEx1 {
    
    	public static void main(String[] args) {
    		//Abstract1 a = new Abstract1(); -> 불가능
    		Abstract1 a;
    		Normal1 n = new Normal1();
    		a = n; //*이처럼 상위클래스 변수는 하위클래스 변수 참조 가능
    	}
    	
    }
    ```
    
    ```jsx
    package ch05;
    
    abstract class Abstract2{
    	abstract void prn();
    }
    
    abstract class Abstract2_1 extends Abstract2{
    	abstract void prn2();
    }
    
    class Normal2 extends Abstract2_1{
    
    	@Override
    	void prn2() {
    	}
    
    	@Override
    	void prn() {
    	}
    	
    }
    
    public class AbstractEx2 {
    
    	public static void main(String[] args) {
    
    	}
    
    }
    ```
    
    편의기능 : 추상 클래스를 상속받는 클래스가 비어있으면 앞에 에러가 뜰 것이다.
    
    x 아이콘을 클릭해서 Add implemented class로 필요한 오버라이드 메소드들을 한꺼번에 추가할 수있다.
    
    인터페이스 
    
    인터페이스 역시 .java 파일인데, 아이콘에 보라색 ”I” 마크가 붙는다.
    
    인터페이스는 협업에 필요한 서로간의 약속이라는 의의를 갖는다.
    
    ```jsx
    package ch05;
    
    interface Calcu{
    	//인터페이스 안에 선언되는 메소드는 abstract를 달지 않아도 추상 메소드
    	void prn(int a, int b);
    }
    
    //implements : 구현 
    class Function2 implements Calcu {
    
    	@Override
    	public void prn(int a, int b) {
    	} //인터페이스를 implement한 클래스는 반드시 메소드를 오버라이드해야 한다.
    	
    }
    
    class Graphics2 implements Calcu{
    
    	@Override
    	public void prn(int a, int b) {
    	}
    	
    }
    
    public class interfaceEx1 {
    
    	public static void main(String[] args) {
    		
    	}
    
    }
    ```
    
    다중 상속이 안 된다는 자바의 특성상
    
    인터페이스를 활용해 다중 상속을 하기도 한다.
    
- 익명 클래스 : 리스너와 연관됩니다.
    
    ```jsx
    package ch05_1;
    
    //인터페이스를 선언합니다.
    interface MyInter{
    	void prn();
    }
    
    public class AnonymousEx1 {
    
    	public static void main(String[] args) {
    		//인터페이스는 타입으로만 존재할 뿐, 객체를 생성하는 게 아니다.
    		//"구현하는 클래스 없이 선언과 동시에 바로 객체를 생성하겠다."
    		//클래스지만, 이름이 없는 클래스.
    		//[애매모호하고 어려운 개념]
    		
    		
    		//MyInter 타입의 객체를 선언한다. 동시에 new를 사용하여 객체를 생성한다.
    		new MyInter() {
    			
    			@Override
    			public void prn() {
    				System.out.println("익명 클래스");
    			}
    		}.prn();//.prn();은 당장 실행을 위해 호출한 거고 큰 의미는 없다.
    
    	}
    
    }
    ```
    
    ```jsx
    package ch05_1;
    
    //인터페이스를 선언합니다.
    interface MyInter{
    	void prn();
    }
    
    public class AnonymousEx1 {
    
    	public static void main(String[] args) {
    		//인터페이스는 타입으로만 존재할 뿐, 객체를 생성하는 게 아니다.
    		//"구현하는 클래스 없이 선언과 동시에 바로 객체를 생성하겠다."
    		//클래스지만, 이름이 없는 클래스.
    		//[애매모호하고 어려운 개념]
    		
    		
    		//MyInter 타입의 객체를 선언한다. 동시에 new를 사용하여 객체를 생성한다.
    		new MyInter() {
    			
    			@Override
    			public void prn() {
    				System.out.println("익명 클래스");
    			}
    		}.prn();//.prn();은 당장 실행을 위해 호출한 거고 큰 의미는 없다.
    
    	}
    
    }
    ```
    

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
    

- 지정자
    
    **접근 지정자**
    
    private : 주택 화장실. 외부로부터 완벽 차단
    protected : 아파트 전용 화장실 
    “상속을 하면 사용 가능, 동일한 패키지도 사용 가능”
    public : 공중화장실. 모든 클래스에 허용
    default(접근지정자 생략) : 동일 패키지에 허용
    

- 취소선이 뜨는(deprecated) 이유는?
    
    **사용을 권장하지 않는다는 의미**이다.
    
    **deprecate**
    
    되었다는 말이다.
    
    deprecate의 사전적 의미 조차도
    
    "**더 이상 사용하지 않음**"
    
    이다.
    
    쉽게 말하면
    
    **더이상 지원하지 않겠다는 의미로 써도되긴하나 앞으로 버전이 바뀌면서 어떻게 바뀔지 모르며**
    
    **오작동이 일어나도 책임지지 않겠다는 말**이다.
    
    그래서 지금 당장은 기능이 작동되지만 앞으로 어떻게 변할지 모르기에
    
    가급적이면 대체되는 메소드를 찾아 사용하는 것이 좋다.
    
    출처:
    
    [https://mine-it-record.tistory.com/180](https://mine-it-record.tistory.com/180)
    
    [나만의 기록들]
    

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

- 클래스 관련
    
    가령 String은 java.lang.이란 패키지에 속한 클래스다.
    
    개발자가 패키지명을 다르게 선언해서 String클래스를 선언할 수 있다.
    
    //같은 패키지를 제외한 클래스는 반드시 "import"를 받아야 한다.
    [//java.lang](https://java.lang/).*에 해당되는 클래스는 import 없이도 쓸 수 있는데, 이는 import가 생략된 것.
    
    해당되는 클래스 : String, System, Math, Integer....
    
    중요 :
    
    SUN에서 제공되는 클래스가 아닌, 
    **타회사가 만든 클래스의 패키지명은 도메인을 거꾸로 선언한다.**
    왜? Unique : 유일하게 만들어주기위해서
    
    →  이 얘기는 교재에 안 나온다.
    
    [naver.com](http://naver.com) → date ⇒ com.naver.Date
    
    [daum.net](http://daum.net) → date ⇒ net.daum.Date
    
    SUN → java.sql.Date, java.util.Date
    
    같은 클래스명을 사용하면 패키지명. 클래스 → 풀네임으로 사용
    
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

- 상속
    
    ```jsx
    package ch04;
    
    class SuperClass5{
    	SuperClass5(int i){}
    }
    
    class SubClass5 extends SuperClass5{
    
    }
    
    public class ConstructorEx5{
    	
    }
    
    코드를 이렇게만 쓰면 오류가 난다. 왜?
    Superclass5(int i){} ->여기서 int와 관련이 있다.
    디폴트 생성자의 첫번째 라인에 오는 super()형태의 생성자는
    정의가 되어 있지 않다.
    
    ...
    class SubClass5 extends SuperClass5{
    	SubClass5(){
    		super();
    	}
    }
    반드시 생성자 첫번째 라인에 와야 한다.
    부모 객체가 먼저 생성이 되어야 하니까.
    그런데 super();랑 같은 형태가 아니라, 매개변수 int가 들어갔잖아.
    부모 클래스에다가 SuperClass5(){} 를 넣든지,
    형식에 맞게끔 super 안에 정수를 넣어 주든지 해야 한다.
    
    ```
    
    ```jsx
    class SuperClass5{
    	SuperClass5(int i){}
    }
    
    class SubClass 
    ```
    
    ```jsx
    package ch04;
    
    class Constructor6 extends Object {
    	
    	Constructor6(){
    		//매개변수가 String인 생성자 호출
    		this("msg");//반드시 생성자의 첫 번째 라인에 온다.
    		
    	}
    	
    	Constructor6(int i){
    		this("msg");
    	}
    	
    	Constructor6(String s){
    		super();
    	}
    
    }
    ```
    

[https://opentutorials.org/module/4294](https://opentutorials.org/module/4294)

스캐너 쓰고 sc.close(); 써야 된다.
안 쓰면 어떻게 됩니까?

자바 문제풀이와 사고과정.
**실제로 문제풀이를 시작하는 시점에서!**
릿코드 몇번을 푸는지만 확인한 뒤 직접 풀어보고,
그다음 강의를 보자.

1. [승지니어 기술면접 라이브코딩 기본편](https://www.youtube.com/watch?v=Bt11jaoqt_Y&list=PL2mzT_U4XxDm7p6g1o3KeQMsyRLfzSaVW)
2. [승지니어 기술면접 라이브코딩 실전편](https://www.youtube.com/watch?v=go8y4-vVg3Y&list=PL2mzT_U4XxDl8PP-jMk4rt6BPzBtS__pQ)

자바는 v10부터 JS처럼 var가 존재하는데...
”실무에서 쓰는 건 거의 못 봤어요.(강사)”

이전 버전과 호환성.

— 시장에서 검증된 버전을 쓰는 게 관례다.

— 공부는 최신 버전으로 하면 이전 버전을 다 포괄해요.

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

# 상식

- 자바 업계
    - “자바”는 인도의 커피 특산지.
    동시에 제임스 고슬링 등 개발진 4명의 이름 이니셜이다.
        
        선마이크로시스템즈의 제임스 고슬링이 
        OAK라는 초기 이름으로 시작하였다.
        
        가전제품용 소프트웨어로 시작하였다.
        
        1995년 발표되었다. 
        
    
    1. 자바는 제임스 고슬링이 만들어고, 썬마이크로시스템즈가 관리했다.
    2. 오라클이 2009년 썬마이크로시스템즈를 인수했고, 고슬링이 떠났다.
    3. 오라클은 특정 자바 JDK를 유료화했다. 
    4. 구글은 이미 해당 JDK로 안드로이드 핵심 프레임워크와 서비스를 만들어놓았고, 
    오라클한테 특허 사용료를 청구당했다.
    5. 구글 vs 오라클 가슴이 웅장해지는 법정싸움 실화냐...?
    
    - 자바 언어 자체는 무료로 사용할 수 있다.
    근데 자바 언어로 프로그램을 쓰려면 SDK인 자바 JDK가 필요하다. (Developer Kit)
        
        자바 바이트코드를 실행하려면 JVM이 필요하다.
        오라클은 Oracle JDK와 JVM을 부분유료화하였다.
        
    
    기존 썬마이크로시스템즈가 오픈한 OpenJDK는 유지되고 있으며, 
    그 바리에이션인 Zulu 등의 JDK가 있는 모양.
    
    이런 업계사정은 코틀린의 채택을 유도하게 되는데...
    
- 자바의 특성
    - C++ 계열이다.
        
        완성된 객체지향형 언어이며, C#이 여기서 따왔기 때문에
        자바랑 C#이랑 문법이 똑같다.
        
    
    - 자바의 탄생 목적은...
        
        플랫폼 호환성 문제를 해결하는 것.
        플랫폼 독립적인 언어를 개발하는 것.
        메모리 사용량이 적고 다양한 플랫폼을 갖는 가전제품에 적용하는 것.
        
        - **WORA : Write Once, Run Anywhere**
        “한번 코드를 작성하면, 모든 플랫폼에서 바로 실행하자”
        이는 플랫폼에 다소 종속된 기존 프로그래밍 언어에선 불가능했던 것.
        (예 : 인텔 cpu+ 리눅스에 종속된 C, C++)
        - 웹 브라우저, 분산환경 지원
        “네트워크에 연결된 어느 클라이언트에서나 실행하자”
        - 자바에선 어떻게 WORA가 가능한가?
            - Byte Code :
                - 자바 소스를 컴파일한 목적 코드
                - CPU에 종속적이지 않은 중립적인 코드
            - 가상 기계 소프트웨어 JVM에 의해 해석되고 실행된다.
            → JVM을 쓰기 때문에 속도가 느리다. 그래서 게임 언어로는 안 쓰인다.
    
    - 클래스로 캡슐화
        
        클래스 내에 모든 변수(필드), 함수(메소드)를 구현해야 한다.
        
    
    jre : 실행환경
    
    bin 폴더 : 
    
    “고급 시스템 설정 보기” > 시스템 속성 > 고급 > 환경 변수 > 싯템 변수 > PATh  편집 > 새로 만들기 
    
    java bin 폴더 경로를 붙여넣는다.
    
    이클립스 : IDE. 기본적으로 비영리 단체고 점유율로 승부한다.
    
- 기본사항
    
    class는 몇 개라도 있어도 상관없지만, public class는 단 하나만 있어야 한다.
    
    main 함수는 반드시 필요한 것은 아니다.
    
    단, main이 없는 클래스는 main안에서 인스턴스를 만들어 사용된다.
    
    class_name.func(); : class_name을 실행하라.
    
    패키지가 필요한 이유?
    
    패키지 명의 .은 상위/하위 경로를 나타낸다.
    
- main 함수 관련
    
    26
    
    The signature of the main method is specified in the [Java Language Specifications section 12.1.4](http://docs.oracle.com/javase/specs/jls/se8/html/jls-12.html#jls-12.1.4) and clearly states:
    
    > The method main must be declared public, static, and void. It must specify a formal parameter (§8.4.1) whose declared type is array of String.
    > 
    - it must be `public` otherwise it would not be possible to call it
    - it must be `static` since you have no way to instantiate an object before calling it
    - the list of `String` arguments is there to allow to pass parameters when executing a Java program from the command line. It would have been possible to define it without arguments but is more practical like that (and similar to other languages)
    - the return type is `void` since it does not make sense to have anything else: a Java program can terminate before reaching the end of the main method (e.g., by calling `System.exit()`)
    
    The method signature can therefore be:
    
    ```
    public static void main( String[] args )
    public static void main( String... args )
    
    ```
    
    note that the *varargs* version (`...`) is only valid from Java 5
    
    As the Java language allows the brackets `[]` to be positioned after the type or the variable (the first is generally preferred),
    

클래스 이름 변경 : refactor > rename

```java
import java.util.*; 
public class Main{ public static void main(String args[]){ Scanner sc = new Scanner(System.in); 
int a, b; 
a = sc.nextInt(); 
b = sc.nextInt(); 
System.out.println(a + b); } }

공백으로 구분된 숫자쌍 입력받기
```

[https://docs.oracle.com/javase/8/docs/api/](https://docs.oracle.com/javase/8/docs/api/)

필요한 클래스가 있다면 여기를 참조한다.
Scanner도 여기에 있는 java.util에서 가져온다.

음의 정수 표현

정수의 가장 왼쪽에 존재하는 비트는 부호 비트다.

MSB : 가장 중요한 비트.

음수를 만들고자 하면 2의 보수를 취한다.

00000101

11111010 → 0,1을 반전해 준 다음

11111011 → 1을 더해주면 양수가 음수로 된다.

→ 어떤 체계인지 이해가 안 된다.

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

### 주석 및 IDE 편의기능

- 주석 : //, /* */

**이클립스 편의기능**

- 블록 주석
    - // : ctrl + /, 다시 단축키로 주석해제 가능
    - /* : ctrl + shift + /, 단축키로 주석해제 불가능
- **클래스 다이어그램**
    
    플러그인 설치 후 new > other >
    java 파일을 끌어오면 어떤 클래스를 이용했는지 도식적으로 보여준다.
    이는 ppt에도 매우 유용하다.
    
- 드롭다운 메뉴를 펼쳐서 실행된 파일이 어떤 파일인지 확인할 수 있다.
    
    ![ffff.png](Java%202da56/ffff.png)
    
    만약에 main함수를 안 썼거나 해서 엉뚱한 파일이 실행된 경우,
    그 파일이 어떤 파일인지 확인할 수 있다.
    

- 자동 임포트 : Ctrl Shift O
- 자동 정렬 : ctrl +  shift + f
(우클릭 > source > format에 해당하는 기능이다.)
- 파일명이 적힌 탭을 더블클릭하면 → 디렉토리 창 열기/닫기.
- Ctrl Alt 방향키 : 열려있는 파일 간 탭 이동.
- 자동 완성 : ctrl + space
    - 자주 쓰는 키워드 : sysout, main, ...
- 호출된 메소드에 대고 ctrl을 누르면 선언부로 올라간다.
- 코드가 너무 길다면 좌측 +, - 로 일부 코드를 숨길 수 있다.

- 변수명 동시에 변경 : alt shift R

사용자 지정 자동완성 

Window > Preference > Java > Editor > Templates

한글 지원 : 

Window > Preference > workspace > Text file enconding → others(UTF-8)

Window > Preference > Spelling > Encoding → UTF-8

### 환경 설정

> IDE : 이클립스
> 
> - Troubleshooting
>     - “가상 머신을 찾을 수 없다.”
>     
>     [https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=siren258&logNo=220429528361](https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=siren258&logNo=220429528361)
>     
> 
> JDK : 개발 환경. JRE를 포함한다.
> 
> JRE만 : 실행 환경. [https://www.java.com/ko/download/](https://www.java.com/ko/download/)
> 
>  * JDK와 JRE 차이는 무조건 아셔야 됩니다.
> 

문법 배우는 건 끝이 없습니다. API 보는 방법까지 알면, 자바 문법은 졸업입니다.

### 기본 구문

**괄호 종류**

{} :

[] :  

() : 함수

**변수 선언**

이름에 들어갈 수 있는 것은 알파벳(대소구분), 숫자, _, $

— 변수 이름이 숫자로 시작해선 안 된다.
— 변수 이름은 공백을 낄 수 없다.
— “class” 등 프로그램 내에 의미 있게 통용되는 키워드는 변수명으로 쓸 수 없다.

변수 이름을 의미 있게 잘 짓는게 은근 빡세다.

자료형 없이 변수 사용하기 

변수를 선언할 때는 변수가 사용할 메모리 크기, 유형을 구분하기 위해

변수가 대입되는 값을 보고 컴파일러가 추론한다.

“지역변수 자료형 추론”

(추가바람)

노란 밑줄 : 만들어놓고 안 쓸 때 발생.

보기 싫다면 인스턴스명.close() → 변수도 해당?

상수

final double PI = 3.14;

final int MAX_NUM = 100;

상수 선언 후, 다른 값을 대입하면 에러가 발생한다.

```jsx
for (int i = 0; i < Integer.MAX_VALUE; i++) {
			DecimalFormat df = new DecimalFormat("###,###");
			System.out.println(df.format(i));
		}
		//숫자 형식 지정
		//정수 끝 범위가 어디까지 가나 볼까?
		
	}
```

### **데이터 유형**

![Untitled](Java%202da56/Untitled%207.png)

![Untitled](Java%202da56/Untitled%208.png)

변수에 실제 값이 들어감.

정수형

문자형

실수형

논리형

참조형 : 변수에 값의 참조(주소)가 저장된다. array collection, class, interface

배열형

컬렉션형

인터페이스형

클래스형

byte : 동영상, 음악

short : 옛날 c, c++호환성 문제로 썼었다.

long : 가장 큰 정수 자료형... 숫자 뒤에 L, l을 써서 long형임을 표시해야 한다.

알파벳, 문자에 int를 붙이면 각각 해당하는 값의 정수가 된다.

숫자 연산을 붙이면 자동으로 정수가 된다.

거꾸로 문자에 정수를 더해서 문자를 고칠 수도 있다.

```jsx
package aa;

public class DataType01 {
	public static void main(String[] args) {
		byte b1=127;
		byte b2=-128;
		System.out.println(b1);
		System.out.println((byte)(b1+1));
		System.out.println((byte)(b2-1));
		
		char ch1='A';
		char ch2='가';
		System.out.println(ch1);
		System.out.println(ch1+1);
		System.out.println(ch2);
		System.out.println((char)(ch2+1));

	}

}
```

실수

소수는 그냥 쓰면  double유형이다.

float을 정의하고 싶으면, 소수 쓰고 f를 달아준다.

```jsx
double dnum = 2.15;
float fnum = 3.15f;
```

실수 유형에 데이터를 저장하면 정확한 값이 안 나오고 짤리거나 생략될 수가 있다.
밑에 코드는 그래서 쓰는 건가.

```jsx
public class DoubleTest01 {
	public static void main(String[] args) {
		double dnum = 0;
		for (int i = 0; i < 10000; i++) {
			dnum = dnum + 0.01;
		}
		System.out.println(dnum);
	}
}
```

불리언

```jsx
boolean isAvailable = true;
```

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
    
    ### 객체 프로그래밍
    
    생성자 > this > super > 상속 개념이 연결되어 있다.
    
    - **생성자**
        
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