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
		setTitle("������ ����1");
		setLayout(new BorderLayout());

		p1 = new Panel();
		p2 = new Panel();
		p3 = new Panel();

		p1.add(label = new Label("�����߿� ����"));
		p1.setBackground(Color.GREEN);
		
		
		//üũ�ڽ� 2��, ��ư 2���� �ݵ�� �г��� ��� �˴ϴ�. 
		//���� p1�̶�� �гο� Label�� ����־���. Label�� ���� �������� '�����'�� �г� ���� ���� ���� ����. 
		cbg = new CheckboxGroup();
		p2.add(cb1 = new Checkbox("���", cbg, false));
		p2.add(cb2 = new Checkbox("����", cbg, false));
		p2.add(cb3 = new Checkbox("�޵�", cbg, false));

		p3.add(btn1 = new Button("Start"));
		p3.add(btn2 = new Button("End"));
		
		add(p1, BorderLayout.NORTH);
		add(p2);//���� BorderLayout ������ �� �� ���, default�� ����.
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

	// �޽����� õ�忡 �ȴ´� NORTH
	// ������ �׷����� ����, �����̳ʿ� �ִ´�.
	// btn1, btn2 Flow�� �����ٴڿ� �ȴ´�. SOUTH

	public static void main(String[] args) {
		new DesignEx1();
	}
}