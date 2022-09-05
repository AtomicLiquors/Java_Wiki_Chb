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
