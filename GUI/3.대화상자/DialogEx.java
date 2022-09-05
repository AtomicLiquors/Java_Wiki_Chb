package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//modal : 포커스와 관련된 boolean. true로 설정하면 메시지에만 포커스가 갈 수있다.

public class DialogEx extends MFrame implements ActionListener {
	
	Button btn;
	String title = "대화상자";
	MyDialog md;
	
	public DialogEx() {
		super(300, 300);
		setLayout(new BorderLayout());
		add(btn = new Button("메세지"), BorderLayout.SOUTH);
		btn.addActionListener(this);
	}
	
	//버튼을 누르면 "내부 클래스"가 만들어진다.
	//외부 클래스와 아주 밀접한 관계를 유지하고 있고, 
	//또 외부 클래스의 필드와 메소드를 자유롭게 사용 가능
	class MyDialog extends Dialog implements ActionListener{
		
		Button b;
		
		public MyDialog(Frame owner, String title, boolean modal) {
			super(owner, title, modal);
			setLayout(new FlowLayout());
			b = new Button("확인");
			//추가바람
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			dispose(); //종료되지 않는다. 사라진다.
		}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		md = new MyDialog(this, title, true);
		int w = 100;
		int h = 150;
		int fX = getX(); 
		int fY = getY(); 
		//Frame의 x좌표와 y좌표를 나타낸다.
		
		int x = fX + getWidth()/2 - w/2;
		int y = fY + getHeight()/2 - h/2;
		//Frame의 좌표값을 바탕으로 상대적인 좌푯값을 만든다. 
		
		md.setBounds(x, y, w, h);
		//메시지 창에 상대 좌표를 부여한다.
		
		md.setVisible(true);
		
				
	}

	public static void main(String[] args) {
		new DialogEx();
	}

}
