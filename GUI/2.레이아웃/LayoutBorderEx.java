package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.util.Random;

import ch05.MColor;

public class LayoutBorderEx extends MFrame {
	Button btn[];
	String str[] = { "첫번째", "두번째", "세번째", "네번째", "다섯번째" };
	String pos[] = { "North", "East", "South", "West", "Center" };

	public LayoutBorderEx() {
		setTitle("FlowLayout 예제");
		setLayout(new BorderLayout());
		btn = new Button[5];
		for (int i = 0; i < btn.length; i++) {
			add(btn[i] = new Button(str[i]), pos[i]);
			Color c[] = MColor.rColor2();
			btn[i].setBackground(c[0]);
			btn[i].setForeground(c[1]);

		}
		validate();
	}

	public static void main(String[] args) {
		new LayoutBorderEx();
		Random r = new Random();

		LayoutBorderEx bl = new LayoutBorderEx();
		bl.setBounds(1, 1, 200, 200);

	}

}
