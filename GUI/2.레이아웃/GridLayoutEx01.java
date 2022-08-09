package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;

public class GridLayoutEx01 extends MFrame {
	
	String str = "GridLayout Example";
	Label label;
	Button btn[];
	String s[] = {"add", "remove", "removeall", "exit"};
	List list;
	
	public GridLayoutEx01() {
		super(400,400);
		setTitle(str);
		setLayout(new BorderLayout());	
		label = new Label(str, Label.CENTER);
		add(label, BorderLayout.SOUTH);
	
		Panel p = new Panel();
		p.setLayout(new GridLayout(4,1));
		btn = new Button[4];
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new Button(s[i]);
			p.add(btn[i]);
		}
		add(BorderLayout.EAST,p);

		list = new List();
		list.add("����");
		list.add("����");
		list.add("�ٳ���");
		add(list,BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new GridLayoutEx01();
	}
}