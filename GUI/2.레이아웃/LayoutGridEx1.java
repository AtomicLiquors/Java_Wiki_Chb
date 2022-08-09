package ch08;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;

public class LayoutGridEx1 extends MFrame {
	//생성 시 "Constructors from superclass"를 선택해 아래 생성자들을 생성했다.

	public LayoutGridEx1() {
		setTitle("GridLayout 예제");
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
