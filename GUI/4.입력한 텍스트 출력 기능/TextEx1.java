package ch08;

import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEx1 extends MFrame 
implements ActionListener{
	
	TextField tf1, tf2;
	TextArea ta;
	
	public TextEx1() {
		super(250, 300);
		setTitle("Text 예제");
		add(new Label("성명"));
		add(tf1 = new TextField("홍길동", 20));
		add(new Label("암호"));
		add(tf2 = new TextField("", 20));
		tf2.setEchoChar('$');
		add(ta = new TextArea(10, 30));
		ta.setBackground(MColor.rColor());
		ta.setEditable(false);//편집불가
		ta.setEnabled(false);//focus도 못감.(비활성화)
		//tf2에 입력 후 Enter을 하면 actionPerformed 호출
		tf2.addActionListener(this);
		validate();//새로고침
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ta.append("성명 : " + tf1.getText()+"\n");
		ta.append("암호 : " + tf2.getText()+"\n");
		tf1.setText("");
		tf2.setText("");
		tf1.requestFocus();//포커스를 tf1로 보냄.
	}
	
	public static void main(String[] args) {
		new TextEx1();
	}
}




