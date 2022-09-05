package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//modal : ��Ŀ���� ���õ� boolean. true�� �����ϸ� �޽������� ��Ŀ���� �� ���ִ�.

public class DialogEx extends MFrame implements ActionListener {
	
	Button btn;
	String title = "��ȭ����";
	MyDialog md;
	
	public DialogEx() {
		super(300, 300);
		setLayout(new BorderLayout());
		add(btn = new Button("�޼���"), BorderLayout.SOUTH);
		btn.addActionListener(this);
	}
	
	//��ư�� ������ "���� Ŭ����"�� ���������.
	//�ܺ� Ŭ������ ���� ������ ���踦 �����ϰ� �ְ�, 
	//�� �ܺ� Ŭ������ �ʵ�� �޼ҵ带 �����Ӱ� ��� ����
	class MyDialog extends Dialog implements ActionListener{
		
		Button b;
		
		public MyDialog(Frame owner, String title, boolean modal) {
			super(owner, title, modal);
			setLayout(new FlowLayout());
			b = new Button("Ȯ��");
			//�߰��ٶ�
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose(); //������� �ʴ´�. �������.
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		md = new MyDialog(this, title, true);
		int w = 100;
		int h = 150;
		int fX = getX(); 
		int fY = getY(); 
		//Frame�� x��ǥ�� y��ǥ�� ��Ÿ����.
		
		int x = fX + getWidth()/2 - w/2;
		int y = fY + getHeight()/2 - h/2;
		//Frame�� ��ǥ���� �������� ������� ��ǩ���� �����. 
		
		md.setBounds(x, y, w, h);
		//�޽��� â�� ��� ��ǥ�� �ο��Ѵ�.
		
		md.setVisible(true);
		
				
	}

	public static void main(String[] args) {
		new DialogEx();
	}

}
