package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Label;
import java.awt.Panel;

import ch05.MColor;

public class DesignEx1 extends MFrame {

	Label label;
	Checkbox cb1, cb2, cb3;
	CheckboxGroup cbg;
	Button btn1, btn2;

	Panel p1, p2, p3;

	public DesignEx1() {
		super(250, 150);
		setTitle("디자인 예제1");
		setLayout(new BorderLayout());

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();

		p1.add(label = new Label("과일중에 선택"));
		p1.setBackground(Color.GREEN);
		
		
		//체크박스 2개, 버튼 2개는 반드시 패널을 써야 됩니다. 
		//나는 p1이라는 패널에 Label을 집어넣었다. Label은 무슨 이유인지 '끊긴다'며 패널 쓰지 않을 것을 권장. 
		cbg = new CheckboxGroup();
		p2.add(cb1 = new Checkbox("사과", cbg, false));
		p2.add(cb2 = new Checkbox("딸기", cbg, false));
		p2.add(cb3 = new Checkbox("앵두", cbg, false));

		p3.add(btn1 = new Button("Start"));
		p3.add(btn2 = new Button("End"));
		
		add(p1, BorderLayout.NORTH);
		add(p2);//따로 BorderLayout 지정을 안 한 경우, default는 센터.
		add(p3, BorderLayout.SOUTH);

		validate();

		/*
		 * Panel p1, p2;
		 * 
		 * label = new Label[3]; btn = new Button[3];
		 * 
		 * for (int i = 0; i < btn.length; i++) { p1.add(label[i] = new Label(str1[i]));
		 * p2.add(btn[i] = new Button(str2[i])); } p1.setBackground(MColor.rColor());
		 * p2.setBackground(MColor.rColor()); add (p1, BorderLayout.NORTH); add (p2,
		 * BorderLayout.SOUTH); validate(); }
		 */

	}

	// 메시지를 천장에 꽂는다 NORTH
	// 라디오를 그룹으로 붂고, 컨테이너에 넣는다.
	// btn1, btn2 Flow로 만들어바닥에 꽂는다. SOUTH

	public static void main(String[] args) {
		new DesignEx1();
	}
}