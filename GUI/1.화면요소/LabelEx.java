package ch08;

import java.awt.Color;
import java.awt.Label;

import ch05.MColor;

public class LabelEx extends MFrame{
	
	/*�ʵ� �����ϴ� ���� : 
	 * 1. ��ü �Ӽ�
	 * 2. �޼ҵ� ����
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
		label1.setForeground(Color.YELLOW);//���ڻ�.
		
		Color c[] = MColor.rColor2();
		label2.setBackground(c[0]);
		label2.setForeground(c[1]);
		//���� �����ΰ�? �ش� ������ ������� '����'�� ���.
		
		//add: Frame(��ǥ���� �����̳�)�� �߰��ϰڴ�.
		add(label1);
		add(label2);
		add(label3);
		add(label4);
	}
	
	public static void main(String[] args) {
		new LabelEx();
	}
}
