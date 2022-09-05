package ch08;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

public class LayoutGridEx1 extends MFrame {
	//���� �� "Constructors from superclass"�� ������ �Ʒ� �����ڵ��� �����ߴ�.

	public LayoutGridEx1() {
		setTitle("GridLayout ����");
		setLayout(new GridLayout(3, 2));
		add(new Button("1"));
		add(new Label("2"));
		add(new Button("3"));
		add(new Button("4"));
		add(new Label("5"));
		add(new Button("6"));
		validate();
	}
	

	public LayoutGridEx1(int w, int h) {
		super(w, h);

	}

	public LayoutGridEx1(Color c) {
		super(c);

	}

	public LayoutGridEx1(int w, int h, Color c) {
		super(w, h, c);

	}

	public LayoutGridEx1(int w, int h, Color c, boolean flag) {
		super(w, h, c, flag);

	}

	public static void main(String[] args) {
		new LayoutGridEx1();
	}

}
