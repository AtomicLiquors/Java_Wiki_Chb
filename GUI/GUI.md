
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