package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEx2 extends MFrame 
implements ActionListener {

	TextField tf;
	TextArea ta;
	Button btn;
	
	public TextEx2() {
		super(250, 300);
		setTitle("MyChat v1.0");
		setLayout(new BorderLayout());
		add(ta = new TextArea(), BorderLayout.CENTER);
		Color c[] = MColor.rColor2();
		ta.setBackground(c[0]);
		ta.setForeground(c[1]);
		ta.setEditable(false);
		//middle container
		Panel p = new Panel();
		p.add(tf = new TextField(20));
		p.add(btn = new Button("SEND"));
		//tf and btn event 연결
		tf.addActionListener(this);
		btn.addActionListener(this);
		add(p, BorderLayout.SOUTH);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * String s = tf.getText(); 
		 * s = s.trim();
		 */
		String s = tf.getText().trim(); 
		if(s.length()==0)
			s = "입력을 다시 하세요.";
		ta.append(s+"\n");
		tf.setText("");
		tf.requestFocus();
	}
	
	public static void main(String[] args) {
		new TextEx2();
	}

}
