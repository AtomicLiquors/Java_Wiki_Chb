package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;

public class DesignEx3 extends MFrame{

	List list;
	Button b[] = new Button[4];
	String lab[] = {"�߰�","�����","��ü�����","����"};
	TextField tf;
	
	public DesignEx3() {
		super(300,200);
		setTitle("������ ����3");
		
	}

	public static void main(String[] args) {
		new DesignEx3();
	}
}
