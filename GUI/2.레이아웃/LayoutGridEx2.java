package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Panel;

public class LayoutGridEx2 extends MFrame {
	//���� �� ���󰬴�. ��� ����� �޶�.
	
	Button btn[];
	String s[] = {"add","remove","removeall","exit"};
	
	public LayoutGridEx2() {
		setTitle("GridLayout ����");
		//Frame�� ��ġ ������ 
		
		btn = new Button[4];
		Panel p = new Panel();
		//Panel�� ��ġ ������ 
		
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
