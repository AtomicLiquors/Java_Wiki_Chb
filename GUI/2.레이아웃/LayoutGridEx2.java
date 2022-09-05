package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

public class LayoutGridEx2 extends MFrame {
	//예제 못 따라갔다. 출력 결과가 달라.
	
	Button btn[];
	String s[] = {"add","remove","removeall","exit"};
	
	public LayoutGridEx2() {
		setTitle("GridLayout 예제");
		//Frame의 배치 관리자 
		
		btn = new Button[4];
		Panel p = new Panel();
		//Panel의 배치 관리자 
		
		p.setLayout(new GridLayout(4, 1));
		for (int i = 0; i < btn.length; i++) {
			p.add(btn[i] = new Button(s[i]));
		}
		add(p, BorderLayout.EAST);
		validate();
	}


	public static void main(String[] args) {
		new LayoutGridEx2();
	}

}
