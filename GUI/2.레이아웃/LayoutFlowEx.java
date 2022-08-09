package ch08;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;

import ch05.MColor;

public class LayoutFlowEx extends MFrame {
	
	Button btn[];
	String str[] = {"첫번째","두번째","세번째","네번째","다섯번째"};
	
	public LayoutFlowEx() {
		setTitle("FlowLayout 예제");
		
		
		
		setLayout(new FlowLayout());
		btn = new Button[5];
		for (int i = 0; i < btn.length; i++) {
			add(btn[i] = new Button(str[i]));
			Color c[] = MColor.rColor2();
			btn[i].setBackground(c[0]);
			btn[i].setForeground(c[1]);
		}
	}
	
	public static void main(String[] args) {
		new LayoutFlowEx();
	}

}
