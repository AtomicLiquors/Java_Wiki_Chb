package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

import ch05.MColor;

public class DesignEx2 extends MFrame {

	TextField tf;
	TextArea ta;
	Button btn1, btn2;
	Panel p1, p3;

	public DesignEx2() {
		super(500, 400);
		setTitle("디자인 예제2");
		setLayout(new BorderLayout());
		
		p1 = new Panel();
		p3 = new Panel();
		

		//p1
		p1.add(tf = new TextField("Hello JDK!", 20));
		

		//p2		
		ta = new TextArea();
		ta.setEditable(false);
		
		//p3
		p3.add(btn1 = new Button("마우스 시험용"));
		p3.add(btn2 = new Button("종료"));
		
		add(p1, BorderLayout.NORTH);
		add(ta, BorderLayout.CENTER);
		add(p3, BorderLayout.SOUTH);

		validate();

	}

	public static void main(String[] args) {
		new DesignEx2();
	}
}
