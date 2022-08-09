package ch08;

import java.awt.Color;
import java.awt.Label;

import ch05.MColor;

public class LabelEx extends MFrame{
	
	/*필드 선언하는 이유 : 
	 * 1. 객체 속성
	 * 2. 메소드 공유
	 */
	Label label1, label2, label3, label4;
	
	public LabelEx() {
		super(200, 200);
		setTitle("Label Example");
		String str = "Tuesday Today";
		label1 = new Label(str);
		label2 = new Label(str, Label.CENTER);
		label3 = new Label(str, Label.RIGHT);
		label4 = new Label(str, Label.LEFT);
		
		label1.setBackground(Color.RED);
		label1.setForeground(Color.YELLOW);//글자색.
		
		Color c[] = MColor.rColor2();
		label2.setBackground(c[0]);
		label2.setForeground(c[1]);
		//랜덤 색상인가? 해당 색상의 상대적인 '보색'을 사용.
		
		//add: Frame(대표적인 컨테이너)에 추가하겠다.
		add(label1);
		add(label2);
		add(label3);
		add(label4);
	}
	
	public static void main(String[] args) {
		new LabelEx();
	}
}
