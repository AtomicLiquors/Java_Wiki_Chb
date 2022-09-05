package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;

public class DesignEx31 extends MFrame {
	
	String str = "GridLayout Example";
	Label label;

	List list;
	Button b[] = new Button[4];
	String lab[] = {"추가","지우기","전체지우기","종료"};
	TextField tf;
	
	public DesignEx31() {
		super(300,200);
		setTitle("디자인 예제3");
		setLayout(new BorderLayout());	
		
		
		tf = new TextField("", 200);
		add(tf, BorderLayout.SOUTH);
		
		
		list = new List();
		list.add("리스트1");
		list.add("리스트2");
		add(list,BorderLayout.CENTER);
	
		Panel p = new Panel();
		p.setLayout(new GridLayout(4,1));
		for (int i = 0; i < b.length; i++) {
			b[i] = new Button(lab[i]);
			p.add(b[i]);
		}
		add(BorderLayout.EAST,p);

		
	}
	
	public static void main(String[] args) {
		new DesignEx31();
	}
}