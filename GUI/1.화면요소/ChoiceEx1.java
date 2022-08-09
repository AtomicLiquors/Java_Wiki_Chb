package ch08;

import java.awt.Choice;
import java.awt.Color;

import ch05.MColor;

public class ChoiceEx1 extends MFrame {
	//html�� �� ���� ����� ���� ������Ʈ.
	
	String city[] = {"도시를 선택하세요.","서울","도쿄",
			"요하네스버그","브라질리아","델리"};
	
	Choice ch;
	
	public ChoiceEx1() {
		//super(300, 300, new Color(100, 200, 100)); //���� ����
		super(300, 300, MColor.rColor()); //������ ����
		setTitle("Choice ����1");
		
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
