package ch08;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx2 extends MFrame implements ItemListener {

	Choice air, city;
	String sair[] = { "�����װ�", "�ƽþƳ�", "����λ�", "������" };
	String scity[] = { "�� ��", "�� ��", "�� ��", "�� ��", "���ֵ�" };

	public ChoiceEx2() {
		super(300, 300, new Color(100, 200, 100)); // ���� ����
		setTitle("Choice ����2");
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
		add(new Label("�װ���� ���ø� �����ϼ���."));
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
		String str = "�װ��� ���� : " + air.getSelectedItem();
		g.drawString(str, 30, 120);
		// ���̴�. x��ǥ�� y��ǥ�� �������ش�.
		// ���α׷��� ���� ���� �����̴�.
		// �ش� ��ġ�� "�װ��� ���� : ~"��� ������ �׷����.
		g.setColor(Color.RED);
		str = "������ ���� : " + city.getSelectedItem();
		g.drawString(str, 30, 150);
	}

	public static void main(String[] args) {
		new ChoiceEx2();
	}

}
