package ch08;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx2 extends MFrame implements ItemListener {

	Choice air, city;
	String sair[] = { "대한항공", "아시아나", "에어부산", "진에어" };
	String scity[] = { "서 울", "대 전", "대 구", "부 산", "제주도" };

	public ChoiceEx2() {
		super(300, 300, new Color(100, 200, 100)); // 색상 지정
		setTitle("Choice 예제2");
		air = new Choice();
		city = new Choice();
		for (int i = 0; i < sair.length; i++) {
			air.add(sair[i]);
		}
		for (int i = 0; i < scity.length; i++) {
			city.add(scity[i]);
		}
		add(air);
		add(city);
		add(new Label("항공사와 도시를 선택하세요."));
		air.addItemListener(this);
		city.addItemListener(this);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		String str = "항공사 선택 : " + air.getSelectedItem();
		g.drawString(str, 30, 120);
		// 붓이다. x좌표와 y좌표를 지정해준다.
		// 프로그램은 왼쪽 위가 원점이다.
		// 해당 위치에 "항공사 선택 : ~"라는 내용을 그려줘라.
		g.setColor(Color.RED);
		str = "목적지 선택 : " + city.getSelectedItem();
		g.drawString(str, 30, 150);
	}

	public static void main(String[] args) {
		new ChoiceEx2();
	}

}
