package ch08;

import java.awt.Button;
import java.awt.Color;

import ch05.MColor;

public class ButtonEx extends MFrame {
	
	Button btn[] = new Button[4];
	String str[] = {"btn1", "btn2", "btn3", "btn4"};
	
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
