package ch08;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;

public class CheckboxEx extends MFrame {
	
	public CheckboxEx() {
		super(400, 200);
		setTitle("Checkbox 체크");
		Checkbox cb1, cb2, cb3;
		Checkbox rb1, rb2, rb3;
		CheckboxGroup grp; //üũ�ڽ��� �׷��� 체크�� �ȴ�.(체크 체크�ΰ�?)
		
		setTitle("Checkbox 체크");
		add(cb1 = new Checkbox("체크1", false));
		add(cb2 = new Checkbox("체크2", false));
		add(cb3 = new Checkbox("체크3", false));
		grp = new CheckboxGroup();
		
		add(rb1 = new Checkbox("체크1", grp, false));
		add(rb2 = new Checkbox("체크2", grp, false));
		add(rb3 = new Checkbox("체크3", grp, false));
		validate();
	}
	
	public static void main(String[] args) {
		new CheckboxEx();
	}

}
