package ch08;

import java.awt.Button;

public class NullLayoutEx extends MFrame {
	
	Button btn1, btn2;
	
	public NullLayoutEx() {
		setTitle("NullLayout 예제");
		setLayout(null);
		btn1 = new Button("버튼1");
		btn2 = new Button("버튼2");
		
		btn1.setBounds(10, 50, 50, 50);
		btn2.setBounds(100, 50, 75, 75);
		add(btn1);
		add(btn2);
	}
		
	public static void main(String[] args) {
		new NullLayoutEx();
	}

}
